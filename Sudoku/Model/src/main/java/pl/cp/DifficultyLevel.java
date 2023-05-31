package pl.cp;

import java.util.Random;

public enum DifficultyLevel {
    Easy(30),
    Medium(40),
    Hard(50);

    int removeables;

    DifficultyLevel(int removeables) {
        this.removeables = removeables;
    }

    public void createBoard(SudokuBoard board) {
        Random x = new Random();
        Random y = new Random();
        for (int i = 0; i < removeables; i++) {
            int xx = x.nextInt(9);
            int yy = y.nextInt(9);
            if (board.getNumber(xx, yy) == 0) {
                i--;
            } else {
                board.setNumber(xx, yy, 0);
            }

        }
    }
}
