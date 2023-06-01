package pl.cp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public class FileSudokuBoardDao implements Dao<SudokuBoard> {
    private String fileName;
    private static final Logger logger =
            LoggerFactory.getLogger(FileSudokuBoardDao.class.getName());

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SudokuBoard read() {
        try (FileReader reader = new FileReader(fileName);
            BufferedReader in = new BufferedReader(reader)) {
            SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
            String line = in.readLine();
            if (false == line.matches("")) {
                throw new DaoExceptions(DaoExceptions.getDaoMessage("reader.fail"));
            }
            for (int ln = 0; ln < 9; ln++) {
                line = in.readLine();
                String[] fieldValues = line.split(",");
                if (fieldValues.length != 10) {
                    throw new DaoExceptions(DaoExceptions.getDaoMessage("reader.fail"));
                }
                    for (int k = 0; k < 9; k++) {
                        board.setNumber(ln, k, Integer.valueOf(fieldValues[k + 1]));
                    }
                }
            return board;
        } catch (Exception ex) {
            logger.error(DaoExceptions.getDaoMessage("reader.fail"), Level.ERROR);
            throw new DaoExceptions(DaoExceptions.getDaoMessage("reader.fail"), ex);
        }
    }

    @Override
    public void write(SudokuBoard object) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(object.toString());
        } catch (IOException ex) {
            logger.error(DaoExceptions.getDaoMessage("writer.fail"), Level.ERROR);
            throw new DaoExceptions(DaoExceptions.getDaoMessage("writer.fail"), ex);
        }
    }

    @Override
    public void close() {
        logger.info("Resource successfully closed");
    }
}
