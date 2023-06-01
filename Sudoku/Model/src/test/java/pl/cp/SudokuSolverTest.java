package pl.cp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {

    @Test
    void testSolve() {
        SudokuBoard sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        sudoku.solveGame();
        for (int i = 0; i < SudokuUtils.size; i++) {
            for (int j = 0; j < SudokuUtils.size; j++) {
                assertFalse(sudoku.getNumber(i, j).equals(0));
            }
        }
    }

}