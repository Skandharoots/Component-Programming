package pl.cp;

import org.junit.jupiter.api.Test;
import java.util.*;
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
        assertFalse(sudoku.equals(sudoku2));
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
    @Test
    void testEqualsSudokuBoard() {
        SudokuBoard Sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBoard Sudoku2 = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBoard Sudoku3 = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuField field = new SudokuField();
        Sudoku.solveGame();
        Sudoku2.solveGame();
        Sudoku3.solveGame();
        assertFalse(Sudoku.equals(Sudoku2));
        assertTrue(Sudoku.equals(Sudoku));
        assertFalse(Sudoku.equals(field));
    }

    @Test
    void testEqualsSudokuField() {
        SudokuField field = new SudokuField();
        SudokuField field2 = new SudokuField();
        SudokuField field3 = new SudokuField();
        SudokuBoard Sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        field.setFieldValue(1);
        field2.setFieldValue(1);
        field3.setFieldValue(2);
        assertFalse(field.equals(Sudoku));
        assertFalse(field.equals(field3));
        assertTrue(field.equals(field));
    }

    @Test
    void testToHash() {
        SudokuBoard Sudoku = new SudokuBoard(new BacktrackingSudokuSolver());
        SudokuBoard Sudoku2 = new SudokuBoard(new BacktrackingSudokuSolver());
        Sudoku.solveGame();
        Sudoku2.solveGame();
        Map<SudokuBoard, Integer> map = new HashMap<SudokuBoard, Integer>();
        map.put(Sudoku, 3);
        map.put(Sudoku2, 2);
        assertFalse(Sudoku.hashCode() == Sudoku2.hashCode());
    }

    @Test
    void testGetField() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        assertFalse(board.getField(0, 0) == null);
    }

}