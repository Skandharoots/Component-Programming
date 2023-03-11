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
        for (int i = 0; i < 9; i += 3) {
            Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            Set<Integer> set2 = new HashSet<>();
            for (int k = 0; k < 9; k += 3) {
                for (int j = i; j < i + 3; j++) {
                    for (int l = k; l < k + 3; l++) {
                        set2.add(sudoku.getNumber(j, l));
                    }
                }
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

        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        sudoku.printSudoku(); // I will assume items is already initialized properly.

        //Now you have to validate the output. Let's say items had 1 element.
        // With name as FirstElement and number as 1.
        String notExpectedOutput  = "1 2 3 4 5 6 7 8 9\n" +
                "1 2 3 4 5 6 7 8 9\n" +
                "1 2 3 4 5 6 7 8 9\n" +
                "1 2 3 4 5 6 7 8 9\n" +
                "1 2 3 4 5 6 7 8 9\n" +
                "1 2 3 4 5 6 7 8 9\n" +
                "1 2 3 4 5 6 7 8 9\n" +
                "1 2 3 4 5 6 7 8 9\n" +
                "1 2 3 4 5 6 7 8 9\n"; // Notice the \n for new line.

        // Do the actual assertion.
        assertNotEquals(notExpectedOutput, outContent.toString());
    }
}