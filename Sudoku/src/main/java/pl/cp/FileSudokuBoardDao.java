package pl.cp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {
    private String fileName;

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    private FileWriter writer = null;
    private FileReader reader = null;


    @Override
    public SudokuBoard read() {
        try {
            SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
            reader = new FileReader(fileName);
            BufferedReader in = new BufferedReader(reader);
            String line = in.readLine();
            if (false == line.matches("")) {
                throw new DaoExceptions("Format error");
            }
            for (int ln = 0; ln < 9; ln++) {
                line = in.readLine();
                String[] fieldValues = line.split(",");
                if (fieldValues.length != 10) {
                    throw new DaoExceptions("Format error");
                }
                    for (int k = 0; k < 9; k++) {
                        board.setNumber(ln, k, Integer.valueOf(fieldValues[k + 1]));
                    }
                }
            reader.close();
            return board;
        } catch (Exception ex) {
            throw new DaoExceptions("Reader failed");
        }
    }

    @Override
    public void write(SudokuBoard object) {
        try {
            writer = new FileWriter(fileName);
            writer.write(object.toString());
            writer.close();
        } catch (Exception ex) {
            throw new DaoExceptions("Write failed", ex);
        }
    }

    @Override
    public void close() throws Exception {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(FileSudokuBoardDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(FileSudokuBoardDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
