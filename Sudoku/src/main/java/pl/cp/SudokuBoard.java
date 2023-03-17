package pl.cp;

import java.util.Arrays;
import java.util.Collections;

public class SudokuBoard {

    private int size = 9;
    private int[][] board;

    public SudokuBoard() {
        board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void printSudoku() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getNumber(int i, int j) {
        return board[i][j];
    }

    public void setNumber(int i, int j, int num) {
        board[i][j] = num;
    }

    public void solveGame() {
        SudokuSolver instance = new BacktrackingSudokuSolver();
        instance.solve(this);
    }
}
