package pl.cp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest extends SudokuBoard {

    @Test
    void testFillBoard() {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.fillBoard(0, 0);

        //Test for rows and columns
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            Set<Integer> set2 = new HashSet<>();
            Set<Integer> set3 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                set2.add(sudoku.getNumber(i, j));
                set3.add(sudoku.getNumber(j, i));
            }
            assertEquals(set, set2);
            assertEquals(set, set3);
        }
        //Test for the boxes
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 9; i += 3) {
            for (int k = 0; k < 9; k += 3) {
                Set<Integer> set2 = new HashSet<>();
                for (int j = i; j < i + 3; j++) {
                    for (int l = k; l < k + 3; l++) {
                        set2.add(sudoku.getNumber(j, l));
                    }
                }
                System.out.println(set2);
                assertEquals(set, set2);
            }
        }
    }

    @Test
    void testIfTwoBoardsAreNotTheSame() {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.fillBoard(0, 0);
        SudokuBoard sudoku2 = new SudokuBoard();
        sudoku2.fillBoard(0, 0);
        assertNotSame(sudoku, sudoku2);
    }


    @Test
    void testPrintSudoku() {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.fillBoard(0, 0);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        sudoku.printSudoku();
        String notExpectedOutput  = null;
        assertNotEquals(notExpectedOutput, outContent.toString());
    }
}