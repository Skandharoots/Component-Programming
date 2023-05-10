package pl.cp;

public class SudokuRow extends SudokuVerify implements Cloneable {

    public SudokuRow(int[] row) {
        super(row);
    }

    @Override
    public SudokuRow clone() throws CloneNotSupportedException {
        return (SudokuRow) super.clone();
    }
}
