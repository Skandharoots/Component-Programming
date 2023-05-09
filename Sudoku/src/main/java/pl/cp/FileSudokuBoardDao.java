package pl.cp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSudokuBoardDao implements Dao<SudokuBoard> {
    private String fileName;

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
                throw new DaoExceptions("Format error");
            }
            for (int ln = 0; ln < 9; ln++) {
                line = in.readLine();
                String[] fieldValues = line.split(",");
                if (fieldValues.length != 10) {
                    throw new DaoExceptions("Format error");
                }
                    for (int k = 0; k < 9; k++) {
                        board.setNumber(ln, k, Integer.valueOf(fieldValues[k + 1]));
                    }
                }

            return board;
        } catch (Exception ex) {
            throw new DaoExceptions("Reader failed");
        }
    }

    @Override
    public void write(SudokuBoard object) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(object.toString());
        } catch (IOException ex) {
            throw new DaoExceptions("Write failed", ex);
        }
    }

    @Override
    public void close() {
        System.out.println("Closed The Resource");
    }
}
