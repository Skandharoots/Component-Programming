package org.example;

import pl.cp.SudokuBoard;

public class Main {
    public static void main(String[] args) {
        SudokuBoard sudoku = new SudokuBoard();
        sudoku.solveGame();
        sudoku.printSudoku();
    }
}
