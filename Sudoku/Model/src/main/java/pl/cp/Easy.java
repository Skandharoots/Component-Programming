package pl.cp;

import java.util.Random;

public class Easy {
    private SudokuBoard board;

    private static int removables = 40;

    public Easy(SudokuBoard board) {
        this.board = board;
        board.solveGame();
    }

    public void createBoard() {
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
