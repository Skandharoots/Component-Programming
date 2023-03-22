package pl.cp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    void testFillBoard() {
        SudokuBoard sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        sudoku.solveGame();

        //Test for rows and columns
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            Set<Integer> set2 = new HashSet<>();
            Set<Integer> set3 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                assertTrue(set2.add(sudoku.getNumber(i, j)));
                assertTrue(set3.add(sudoku.getNumber(j, i)));
            }
        }
        //Test for the boxes
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 9; i += 3) {
            for (int k = 0; k < 9; k += 3) {
                Set<Integer> set2 = new HashSet<>();
                for (int j = i; j < i + 3; j++) {
                    for (int l = k; l < k + 3; l++) {
                        assertTrue(set2.add(sudoku.getNumber(j, l)));
                    }
                }
                System.out.println(set2);
                assertEquals(set, set2);
            }
        }
    }

    @Test
    void testIfTwoBoardsAreNotTheSame() {
        SudokuBoard sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        sudoku.solveGame();
        SudokuBoard sudoku2 = new SudokuBoard(new BacktrackingSudokuSolver());
        sudoku2.solveGame();
        assertNotSame(sudoku, sudoku2);
    }


    @Test
    void testPrintSudoku() {
        SudokuBoard sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        sudoku.solveGame();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        sudoku.printSudoku();
        String notExpectedOutput  = null;
        assertNotEquals(notExpectedOutput, outContent.toString());
    }

    @Test
    void testSetterAndGetter() {
        int[][] grid
                = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        SudokuBoard sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        assertEquals(0, sudoku.getNumber(0, 0));
        sudoku.setNumber(0, 0, 7);
        assertEquals(7, sudoku.getNumber(0, 0));
    }
}