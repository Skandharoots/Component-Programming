package pl.cp;

import org.junit.jupiter.api.Test;
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
        Dao dao1 = factory1.getFileDao("Sudoku2.txt");
        SudokuBoardDaoFactory factory2 = new SudokuBoardDaoFactory();
        Dao dao2 = factory2.getFileDao("SudokuNoFile.txt");
        DaoExceptions thrown1 = assertThrows(DaoExceptions.class, () -> dao1.read(), "Reader failed");
        // thrown2 = assertThrows(DaoExceptions.class, () -> dao2.write(new SudokuBoard(null)), "Write failed");
        assertTrue(thrown1.getMessage().contentEquals("Reader failed"));
        //assertTrue(thrown2.getMessage().contentEquals("Write failed"));
    }
}
