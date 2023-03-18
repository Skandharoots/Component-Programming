package pl.cp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest extends SudokuBoard {

    @Test
    void testSolve() {
        SudokuBoard sudoku = new SudokuBoard();
        SudokuSolver sudokuSolve = new BacktrackingSudokuSolver();
        sudokuSolve.solve(sudoku);
        for (int i = 0; i < SudokuUtils.size; i++) {
            for (int j = 0; j < SudokuUtils.size; j++) {
                assertNotEquals(0, sudoku.getNumber(i, j));
            }
        }
    }

}