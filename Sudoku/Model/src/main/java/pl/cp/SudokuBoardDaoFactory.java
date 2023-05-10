package pl.cp;

public class SudokuBoardDaoFactory {
    public SudokuBoardDaoFactory() {

    }

    public Dao getFileDao(String fileName) {
        return new FileSudokuBoardDao(fileName);
    }
}
