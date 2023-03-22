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

    public int getNumber(int i, int j) {
        return board[i][j].getFieldValue();
    }

    public void setNumber(int i, int j, int num) {
        board[i][j].setFieldValue(num);
    }

    public void solveGame() {
        instance.solve(this);
    }
}
