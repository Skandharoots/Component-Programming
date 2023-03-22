package pl.cp;

import java.util.Arrays;

public abstract class SudokuVerify {

    private Integer[] numbers;

    private Integer[] arrayNum = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public SudokuVerify(Integer[] numbers) {
        this.numbers = numbers;
    }

    public boolean verify() {
        Arrays.sort(numbers);
        if (Arrays.equals(numbers, arrayNum)) {
            return true;
        }
        return false;
    }
}
