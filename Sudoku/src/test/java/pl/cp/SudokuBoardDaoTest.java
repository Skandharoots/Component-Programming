package pl.cp;

import org.junit.jupiter.api.Test;
import java.util.*;

public class SudokuBoardDaoTest {
    @Test
    void testWriteDao() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        Dao dao = factory.getFileDao("Sudoku1.txt");
        dao.write(board);
    }
}
