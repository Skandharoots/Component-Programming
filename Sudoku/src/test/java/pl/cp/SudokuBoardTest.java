package pl.cp;

/*
 * #%L
 * 00_FirstJava-2.0
 * %%
 * Copyright (C) 2023 IFE - IT
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */


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
    void testSetterAndGetter() {
        SudokuBoard sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        assertEquals(0, sudoku.getNumber(0, 0));
        sudoku.setNumber(0, 0, 7);
        assertEquals(7, sudoku.getNumber(0, 0));
    }

    @Test
    void testGetRowColAndBox() {
        SudokuBoard sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        sudoku.solveGame();
        Integer[] arrayNum = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] check;
        assertNotNull(sudoku.getRow(2));
        assertNotNull(sudoku.getColumn(2));
        assertNotNull(sudoku.getBox(7, 3));
    }

    @Test
    void testCheckBoard() {
        SudokuBoard sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        assertFalse(sudoku.checkBoard());
        sudoku.solveGame();
        assertTrue(sudoku.checkBoard());
    }

    @Test
    void testSudokuUtils() {
        SudokuUtils util = new SudokuUtils();
        assertEquals(9, util.size);
    }
}