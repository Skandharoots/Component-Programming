package pl.cp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuVerifyTest {

    @Test
    void testSudokuVerify() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        assertFalse(board.getRow(2).verify());
        assertFalse(board.getColumn(3).verify());
        assertFalse(board.getBox(4, 6).verify());
        board.solveGame();
        assertTrue(board.getRow(2).verify());
        assertTrue(board.getColumn(5).verify());
        assertTrue(board.getBox(4, 6).verify());
    }

}