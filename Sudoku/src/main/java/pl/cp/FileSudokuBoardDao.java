package pl.cp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {
    private String fileName;

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    private FileWriter writer = null;
    private FileReader reader = null;


    @Override
    public SudokuBoard read() {
        if (reader != null) {
            throw new DaoExceptions("Reader already used");
        }
        try {
            SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
            reader = new FileReader(fileName);
            BufferedReader in = new BufferedReader(reader);
            String line = in.readLine();
            if (false == line.matches("")) {
                reportFormatError();
            }
            for (int ln = 0; ln < 9; ln++) {
                line = in.readLine();
                String[] fieldValues = line.split(",");
                if (fieldValues.length != 9) {
                    reportFormatError();
                }
                    for (int k = 0; k < 9; k++) {
                        board.setNumber(ln, k, Integer.valueOf(fieldValues[k]));
                    }
                }
            reader.close();
            return board;
        } catch (Exception ex) {
            throw new DaoExceptions("Reader failed");
        }
    }

    private void reportFormatError() throws DaoExceptions {
        throw new DaoExceptions("Incorrect data format");
    }

    @Override
    public void write(SudokuBoard object) {
        if (writer != null) {
            throw new DaoExceptions("Writer already used");
        }
        try {
            writer = new FileWriter(fileName);
            writer.write(object.toString());
            writer.close();
        } catch (Exception ex) {
            throw new DaoExceptions("Write failed");
        }
    }

    @Override
    public void close() throws Exception {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(FileSudokuBoardDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(FileSudokuBoardDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
