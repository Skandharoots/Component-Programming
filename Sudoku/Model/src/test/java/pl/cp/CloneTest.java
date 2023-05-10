package pl.cp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CloneTest {

    @Test
    void testCloneSudokuBoard() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        try {
            SudokuBoard clone = board.clone();
            assertTrue(board.equals(clone));
        } catch (CloneNotSupportedException ex) {
            System.out.println("Clone not supported");
        }
    }

    @Test
    void testCloneSudokuField() {
        SudokuField field = new SudokuField();
        field.setFieldValue(6);
        try {
            SudokuField clone = field.clone();
            assertTrue(field.equals(clone));
        } catch (CloneNotSupportedException ex) {
            System.out.println("Clone not supported");
        }
    }

    @Test
    void testCompareToSudokuField() {
        SudokuField field = new SudokuField();
        SudokuField field2 = new SudokuField();
        field.setFieldValue(6);
        field2.setFieldValue(5);
        assertEquals(0, field.compareTo(field2));
        field2.setFieldValue(6);
        assertEquals(1, field.compareTo(field2));
        assertThrows(NullPointerException.class, () -> field.compareTo(null), "Null pointer");
    }

    @Test
    void testCloneSudokuBox() {
        int[] boxes = { 2, 3, 5, 6, 7, 1, 4, 8, 9 };
        SudokuBox box = new SudokuBox(boxes);
        try {
            SudokuBox clone = box.clone();
            assertFalse(box.equals(clone));
        } catch (CloneNotSupportedException ex) {
            System.out.println("Clone not supported");
        }
    }

    @Test
    void testCloneSudokuRow() {
        int[] boxes = { 2, 3, 5, 6, 7, 1, 4, 8, 9 };
        SudokuRow box = new SudokuRow(boxes);
        try {
            SudokuRow clone = box.clone();
            assertFalse(box.equals(clone));
        } catch (CloneNotSupportedException ex) {
            System.out.println("Clone not supported");
        }
    }

    @Test
    void testCloneSudokuColumn() {
        int[] boxes = { 2, 3, 5, 6, 7, 1, 4, 8, 9 };
        SudokuColumn box = new SudokuColumn(boxes);
        try {
            SudokuColumn clone = box.clone();
            assertFalse(box.equals(clone));
        } catch (CloneNotSupportedException ex) {
            System.out.println("Clone not supported");
        }
    }
}
