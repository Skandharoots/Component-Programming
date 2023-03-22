package pl.cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuRow {

    private Integer[] row;

    private Integer[] arrayNum = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public SudokuRow(Integer[] row) {
    this.row = row;
}

public boolean verify() {
        for (int i = 0; i < SudokuUtils.size; i++) {
            if (row == arrayNum) {
                return true;
            }
        }
        return false;
    }
}
