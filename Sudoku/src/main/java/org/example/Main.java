package org.example;

import pl.cp.SudokuBoard;

public class Main {
    public static void main(String[] args) {

        SudokuBoard sudoku = new SudokuBoard();
        if (sudoku.fillBoard(0, 0)) {
            sudoku.printSudoku();
        } else {
            System.out.println("Error");
        }
    }
}