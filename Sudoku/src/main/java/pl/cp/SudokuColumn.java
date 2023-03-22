package pl.cp;

import java.util.Arrays;

public class SudokuColumn {

    private Integer[] row;

    private Integer[] arrayNum = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public SudokuColumn(Integer[] row) {
        this.row = row;
    }

    public boolean verify() {
        Arrays.sort(row);
        if (Arrays.equals(row, arrayNum)) {
            return true;
        }
        return false;
    }
}
