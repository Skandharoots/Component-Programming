package pl.cp;

public class SudokuBoardDaoFactory {
    public SudokuBoardDaoFactory() {

    }

    public Dao<SudokuBoard> getFileDao(String fileName) {
        return new FileSudokuBoardDao(fileName);
    }
}
