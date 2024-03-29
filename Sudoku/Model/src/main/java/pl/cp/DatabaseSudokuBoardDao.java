package pl.cp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSudokuBoardDao implements Dao<SudokuBoard> {

    private String boardName;

    private final String url = "jdbc:postgresql://localhost:5432/postgres";

    private final String user = "postgres";

    private final String password = "lapunia";

    public DatabaseSudokuBoardDao(String boardName) {
        this.boardName = boardName;
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public SudokuBoard read() {
        String querry = "SELECT * FROM fields LEFT JOIN boards b on b.id = fields.board_id "
                + "WHERE name = '" + this.boardName + "'";
        try (Connection con = connect();
             ResultSet set = con.createStatement().executeQuery(querry)) {
            con.setAutoCommit(false);
            SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
            if (set.next()) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        board.setNumber(i, j, set.getInt("value"));
                        set.next();
                    }
                }
            } else {
                throw new DaoExceptions("Missing data");
            }
            con.commit();
            return board;
        } catch (SQLException | DaoExceptions e) {
            throw new DaoExceptions("Reading from database failed");
        }
    }

    @Override
    public void write(SudokuBoard object) {
        String querry1 = "INSERT INTO fields (board_id, value, editable) VALUES (?, ?, ?)";
        String querry2 = "INSERT INTO boards (id, name)"
                + " VALUES (DEFAULT, '" + this.boardName + "') RETURNING id;";
        try (Connection con = connect(); PreparedStatement pstmt = con.prepareStatement(querry1)) {
            con.setAutoCommit(false);
            ResultSet idb = con.createStatement().executeQuery(querry2);
            if (idb.next()) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        pstmt.setInt(2, object.getNumber(i, j));
                        pstmt.setInt(1, idb.getInt("id"));
                        pstmt.setBoolean(3, true);
                        pstmt.executeUpdate();
                    }
                }
            } else {
                throw new DaoExceptions("No data found");
            }
            con.commit();
        } catch (SQLException | DaoExceptions e) {
            throw new DaoExceptions("Writing to database failed");
        }
    }

    @Override
    public void close() {

    }
}
