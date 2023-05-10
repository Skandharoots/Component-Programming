package pl.cp;


public class SudokuColumn extends SudokuVerify implements Cloneable {

    public SudokuColumn(int[] col) {
        super(col);
    }

    @Override
    public SudokuColumn clone() throws CloneNotSupportedException {
        return (SudokuColumn) super.clone();
    }
}
