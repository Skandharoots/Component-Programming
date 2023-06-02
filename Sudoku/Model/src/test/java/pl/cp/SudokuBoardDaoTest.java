package pl.cp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.io.FileReader;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuBoardDaoTest {
    @Test
    void testWriteReadDao() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        try {
            Dao<SudokuBoard> dao = factory.getFileDao("Sudoku1.txt");
            dao.write(board);
            SudokuBoard board2 = dao.read();
            assertEquals(board, board2);
            assertDoesNotThrow(dao::close);
        } catch (DaoExceptions e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Test
    void testExceptionDao() {
        SudokuBoardDaoFactory factory1 = new SudokuBoardDaoFactory();
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        String s = null;
        try {
            Dao<SudokuBoard> dao1 = factory1.getFileDao("Wrong.txt");
            board = dao1.read();
        } catch (DaoExceptions e) {
            assertTrue(e.getMessage().contentEquals("Reader failed"));
        }
        SudokuBoardDaoFactory factory2 = new SudokuBoardDaoFactory();
        try {
            Dao<SudokuBoard> dao2 = factory2.getFileDao("Wrong1.txt");
            board = dao2.read();
        } catch (DaoExceptions e) {
            assertTrue(e.getMessage().contentEquals("Reader failed"));
        }
        SudokuBoardDaoFactory factory3 = new SudokuBoardDaoFactory();
        try {
            Dao dao3 = factory3.getFileDao("?.txt");
            dao3.write(board);
        } catch (DaoExceptions e) {
            assertTrue(e.getMessage().contentEquals("Write failed"));
        }
    }

    @Test
    public void closeTest() {
        SudokuBoardDaoFactory factory1 = new SudokuBoardDaoFactory();
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        Dao<SudokuBoard> dao1 = factory1.getFileDao("Wrong.txt");
        assertDoesNotThrow(dao1::close);
    }
}