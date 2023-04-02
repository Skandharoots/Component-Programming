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
import java.util.List;

public class SudokuBoard {

    private int size = 9;
    private List<SudokuField[]> board;

    private SudokuSolver instance;

    public SudokuBoard(SudokuSolver instance) {
        board = Arrays.asList(new SudokuField[size][size]);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board.get(i)[j] = new SudokuField();
                board.get(i)[j].setFieldValue(0);
            }
        }
        this.instance = instance;
    }

    public Integer getNumber(int i, int j) {
        return board.get(i)[j].getFieldValue();
    }

    public void setNumber(int i, int j, int num) {
        board.get(i)[j].setFieldValue(num);
    }

    public void solveGame() {
        instance.solve(this);
    }

    public boolean checkBoard() {
        boolean ok = true;
        for (int i = 0; i < SudokuUtils.size; i++) {
            if (!getRow(i).verify()) {
                ok = false;
            }

        }
        for (int j = 0; j < SudokuUtils.size; j++) {
            if (!getColumn(j).verify()) {
                ok = false;
            }

        }
        for (int i = 0; i < SudokuUtils.size; i += 3) {
            for (int j = 0; j < SudokuUtils.size; j += 3) {
                if (!getBox(i, j).verify()) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    public SudokuVerify getRow(int i) {
        int[] rows = new int[size];
        for (int j = 0; j < size; j++) {
            rows[j] = getNumber(i, j);
        }
        SudokuVerify row = new SudokuRow(rows);
        return row;
    }

    public SudokuVerify getColumn(int j) {
        int[] column = new int[size];
        for (int i = 0; i < size; i++) {
            column[i] = getNumber(i, j);
        }
        SudokuVerify col = new SudokuColumn(column);
        return col;
    }

    public SudokuVerify getBox(int row, int col) {
        int[] box = new int[size];
        int ar = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                box[ar] = getNumber(i + (row - row % 3), j + (col - col % 3));
                ar++;
            }
        }
        SudokuVerify box1 = new SudokuBox(box);
        return box1;
    }
}
