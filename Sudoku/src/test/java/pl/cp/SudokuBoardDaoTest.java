package pl.cp;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
