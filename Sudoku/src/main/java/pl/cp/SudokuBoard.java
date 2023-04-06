package pl.cp;


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
