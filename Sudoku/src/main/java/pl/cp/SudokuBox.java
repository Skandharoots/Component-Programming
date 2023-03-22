package pl.cp;

import java.util.Arrays;

public class SudokuBox {

    private Integer[] box;

    private Integer[] arrayNum = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public SudokuBox(Integer[] box) {
        this.box = box;
    }

    public boolean verify() {
        Arrays.sort(box);
        if (Arrays.equals(box, arrayNum)) {
            return true;
        }
        return false;
    }
}
