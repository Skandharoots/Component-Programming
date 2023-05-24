package pl.cp;

public class SudokuBox extends SudokuVerify implements Cloneable {

    public SudokuBox(int[] box) {
        super(box);
    }

    @Override
    public SudokuBox clone() throws CloneNotSupportedException {
        return (SudokuBox) super.clone();
    }
}
