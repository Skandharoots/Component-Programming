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


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BacktrackingSudokuSolver implements SudokuSolver {


    public BacktrackingSudokuSolver() {

    }

    @Override
    public void solve(SudokuBoard board) {
        solve(0, 0, board);
    }

    private boolean solve(int i, int j, SudokuBoard board) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(numbers);
        if (i == SudokuUtils.size - 1 && j == SudokuUtils.size) {
            return true;
        }
        if (j == SudokuUtils.size) {
            i++;
            j = 0;
        }
        if (board.getNumber(i, j) != 0) {
            return solve(i, j + 1, board);
        }
        for (int num = 0; num < 9; num++) {
            if (checkIfCanPlace(i, j, numbers.get(num), board)) {
                board.setNumber(i, j, numbers.get(num));
                if (solve(i, j, board)) {
                    return true;
                }
            }
            board.setNumber(i, j, 0);
        }
        return false;
    }

    private boolean canPlaceInRow(int i, int num, SudokuBoard board) {
        for (int j = 0; j < SudokuUtils.size; j++) {
            if (board.getNumber(i, j) == num) {
                return false;
            }
        }
        return true;
    }

    private boolean canPlaceInColumn(int j, int num, SudokuBoard board) {
        for (int i = 0; i < SudokuUtils.size; i++) {
            if (board.getNumber(i, j) == num) {
                return false;
            }
        }
        return true;
    }

    private boolean canPlaceInBox(int row, int col, int num, SudokuBoard board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getNumber(i + (row - row % 3),j + (col - col % 3)) == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkIfCanPlace(int i, int j, int num, SudokuBoard board) {
        return canPlaceInRow(i, num, board)
                && canPlaceInColumn(j, num, board)
                && canPlaceInBox(i, j, num, board);
    }
}
