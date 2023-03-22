package pl.cp;

public class SudokuBoard {

    private int size = 9;
    private SudokuField[][] board;

    private SudokuSolver instance;

    public SudokuBoard(SudokuSolver instance) {
        board = new SudokuField[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new SudokuField();
                board[i][j].setFieldValue(0);
            }
        }
        this.instance = instance;
    }

    public Integer getNumber(int i, int j) {
        return board[i][j].getFieldValue();
    }

    public void setNumber(int i, int j, int num) {
        board[i][j].setFieldValue(num);
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
        Integer[] rows = new Integer[size];
        for (int j = 0; j < size; j++) {
            rows[j] = getNumber(i, j);
        }
        SudokuVerify row = new SudokuRow(rows);
        return row;
    }

    public SudokuVerify getColumn(int j) {
        Integer[] column = new Integer[size];
        for (int i = 0; i < size; i++) {
            column[i] = getNumber(i, j);
        }
        SudokuVerify col = new SudokuColumn(column);
        return col;
    }

    public SudokuVerify getBox(int row, int col) {
        Integer[] box = new Integer[size];
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
