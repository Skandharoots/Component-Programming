package pl.cp;

public class SudokuBox extends SudokuVerify implements Cloneable {

    public SudokuBox(int[] box) {
        super(box);
    }

    @Override
    public SudokuBox clone() throws CloneNotSupportedException {
        int[] array = {};
        SudokuVerify copy = new SudokuBox(array);
        copy.numbers = super.numbers;
        return (SudokuBox) copy;
    }
}
