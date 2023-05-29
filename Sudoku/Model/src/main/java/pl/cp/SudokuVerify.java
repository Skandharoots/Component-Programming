package pl.cp;

import java.util.Arrays;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class SudokuVerify {

    public int[] numbers;

    private int[] arrayNum = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public SudokuVerify(int[] numbers) {
        this.numbers = numbers;
    }

    public void setNumber(int i, int number) {
        numbers[i] = number;
    }

    public int getNumber(int i) {
        return numbers[i];
    }

    public boolean verify() {
        Arrays.sort(numbers);
        if (Arrays.equals(numbers, arrayNum)) {
            return true;
        }
        return false;
    }

    @Override
    public SudokuVerify clone() throws CloneNotSupportedException {
        int[] c = numbers;
        SudokuVerify clone = (SudokuVerify) super.clone();
        for (int i = 0; i < 9; i++) {
            clone.setNumber(i, getNumber(i));
        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SudokuVerify that = (SudokuVerify) o;

        return new EqualsBuilder().append(numbers, that.numbers).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(numbers).toHashCode();
    }

}
