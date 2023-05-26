package pl.cp;


import java.util.Arrays;

public abstract class SudokuVerify {

    public int[] numbers;

    private int[] arrayNum = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public SudokuVerify(int[] numbers) {
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
