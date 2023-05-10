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
        Dao dao = factory.getFileDao("Sudoku1.txt");
        dao.write(board);
        SudokuBoard board2 = (SudokuBoard) dao.read();
        assertEquals(board, board2);
    }

    @Test
    void testExceptionDao() {
        SudokuBoardDaoFactory factory1 = new SudokuBoardDaoFactory();
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        String s = null;
        Dao dao1 = factory1.getFileDao("Wrong.txt");
        DaoExceptions thrown1 = assertThrows(DaoExceptions.class, () -> dao1.read(), "Reader failed");
        assertTrue(thrown1.getMessage().contentEquals("Reader failed"));
        SudokuBoardDaoFactory factory2 = new SudokuBoardDaoFactory();
        Dao dao2 = factory2.getFileDao("Wrong1.txt");
        DaoExceptions thrown2 = assertThrows(DaoExceptions.class, () -> dao2.read(), "Reader failed");
        assertTrue(thrown2.getMessage().contentEquals("Reader failed"));
        SudokuBoardDaoFactory factory3 = new SudokuBoardDaoFactory();
        Dao dao3 = factory3.getFileDao("?.txt");
        DaoExceptions thrown3 = assertThrows(DaoExceptions.class, () -> dao3.write(board), "Write failed");
        assertTrue(thrown3.getMessage().contentEquals("Write failed"));
    }

    @Test
    public void closeTest() {
        SudokuBoardDaoFactory factory1 = new SudokuBoardDaoFactory();
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        Dao dao1 = factory1.getFileDao("Wrong.txt");
        assertDoesNotThrow(() -> dao1.close());
    }
}