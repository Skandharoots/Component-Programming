package pl.cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SudokuBoard {

    private static int[] arrayNum = {1, 2, 3, 4, 5, 6, 7, 8, 9};
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

    public boolean fillBoard(int i, int j) {
        Collections.shuffle(Arrays.asList(arrayNum));
        if (i == size - 1 && j == size) {
            return true;
        }
        if (j == size) {
            i++;
            j = 0;
        }
        if (board[i][j] != 0) {
            return fillBoard(i, j + 1);
        }
        for (int num = 0; num < 9; num++) {
            if (checkIfCanPlace(i, j, arrayNum[num])) {
                board[i][j] = arrayNum[num];
                if (fillBoard(i, j)) {
                    return true;
                }
            }
            board[i][j] = 0;
        }
        return false;
    }

    private boolean canPlaceInRow(int i, int num) {
        for (int j = 0; j < size; j++) {
            if (board[i][j] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean canPlaceInColumn(int j, int num) {
        for (int i = 0; i < size; i++) {
            if (board[i][j] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean canPlaceInBox(int row, int col, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + (row - row % 3)][j + (col - col % 3)] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkIfCanPlace(int i, int j, int num) {
        return (canPlaceInRow(i, num)
                && canPlaceInColumn(j, num)
                && canPlaceInBox(i, j, num));
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
}
