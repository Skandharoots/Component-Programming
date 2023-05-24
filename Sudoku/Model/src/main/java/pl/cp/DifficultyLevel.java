package pl.cp;

import java.util.Random;

public class DifficultyLevel {
    public DifficultyLevel(Difficulty var) {
        difficulty = var;
    }
    protected enum Difficulty {
        Easy,
        Medium,
        Hard
    }
    private final DifficultyLevel.Difficulty difficulty;
    public void createBoard(SudokuBoard board) {
        int removables = 0;

        switch (difficulty) {
            case Easy:
                removables = 30;
                break;
            case Medium:
                removables = 40;
                break;
            case Hard:
                removables = 50;
                break;
        }

        Random x = new Random();
        Random y = new Random();
        for (int i = 0; i < removables; i++) {
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
