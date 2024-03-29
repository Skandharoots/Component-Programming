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

import java.util.HashMap;
import java.util.Map;

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

    @Test
    void testSudokuVerifyEquals() {
        int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SudokuVerify ver1 = new SudokuBox(c);
        SudokuVerify ver2 = null;
        assertTrue(ver1.equals(ver1));
        assertFalse(ver1.equals(ver2));
    }

    @Test
    void testSudokuVerifyHash() {
        int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SudokuVerify ver1 = new SudokuBox(c);
        SudokuVerify ver2 = new SudokuColumn(c);
        Map<SudokuVerify, Integer> map = new HashMap<SudokuVerify, Integer>();
        map.put(ver1, 3);
        map.put(ver2, 2);
        assertTrue(ver1.hashCode() == ver2.hashCode());
    }

}