package pl.cp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest extends SudokuBoard {

    @Test
    void testFillBoard() {
        SudokuBoard sudoku = new SudokuBoard();
        SudokuBoard sudoku2 = new SudokuBoard();
        sudoku.fillBoard(0, 0);
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
    }


    //@Test
    //void testPrintSudoku() {
    //}
}