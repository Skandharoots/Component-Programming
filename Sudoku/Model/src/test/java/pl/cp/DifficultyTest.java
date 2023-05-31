package pl.cp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DifficultyTest {

    @Test
    void enumTest() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        try {
            SudokuBoard copy = board.clone();
            SudokuBoard copy2 = board.clone();
            DifficultyLevel dl2 = DifficultyLevel.Medium;
            dl2.createBoard(copy);
            assertFalse(copy.checkBoard());
            DifficultyLevel dl3 = DifficultyLevel.Hard;
            dl3.createBoard(copy2);
            assertFalse(copy2.checkBoard());
            assertTrue(board.checkBoard());
        } catch (CloneNotSupportedException ex) {
            System.out.println("Clone not supported");
        }
        DifficultyLevel dl = DifficultyLevel.Easy;
        dl.createBoard(board);
        assertFalse(board.checkBoard());
    }
}
