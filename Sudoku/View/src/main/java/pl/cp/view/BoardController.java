package pl.cp.view;

import java.io.IOException;
import javafx.beans.binding.Bindings;
import javafx.beans.property.adapter.JavaBeanIntegerProperty;
import javafx.beans.property.adapter.JavaBeanIntegerPropertyBuilder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.cp.BacktrackingSudokuSolver;
import pl.cp.Dao;
import pl.cp.DaoExceptions;
import pl.cp.SudokuBoard;
import pl.cp.SudokuBoardDaoFactory;



public class BoardController {

    @FXML
    GridPane myGrid;

    @FXML
    Button backButton;

    @FXML
    Button loadbtn;

    @FXML
    Button savebtn;

    private SudokuBoard board;

    private static final Logger logger =
            LoggerFactory.getLogger(BoardController.class.getName());

    @FXML
    public void initialize() throws NoSuchMethodException {
        board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        HelloController.difficultyLevel.createBoard(board);
        populateGrid();
    }

    public void populateGrid() throws NoSuchMethodException {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField field = new TextField();
                String fieldval = String.valueOf(board.getNumber(i, j));
                field.setText(fieldval.equals("0") ? "" : fieldval);
                JavaBeanIntegerPropertyBuilder builder = JavaBeanIntegerPropertyBuilder.create();
                JavaBeanIntegerProperty prop = builder.bean(board.getField(i, j))
                        .name("FieldValue").build();
                StringConverter<Number> c = new StringConverter<Number>() {
                    @Override
                    public String toString(Number number) {
                        if (number.equals(0)) {
                            return "";
                        }
                        return number.toString();
                    }

                    @Override
                    public Number fromString(String s) {
                        if (s.equals("")) {
                            return 0;
                        }
                        return Integer.parseInt(s);
                    }
                };
                Bindings.bindBidirectional(field.textProperty(), prop, c);
                field.setAlignment(Pos.CENTER);
                field.setPrefHeight(40);
                field.setPrefWidth(20);
                field.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                    if (!newValue && !field.getText().matches("[1-9]")) {
                            field.setText("");
                        }
                });
                myGrid.add(field, i, j);
            }
        }
    }

    public void onLoadButtonClick() throws NoSuchMethodException {
        try {
            SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
            Dao<SudokuBoard> dao = factory.getFileDao("bs.txt");
            board = dao.read();
            populateGrid();
        } catch (DaoExceptions e) {
            logger.error(DaoExceptions.getDaoMessage("reader.fail"), System.Logger.Level.ERROR);
        }
    }

    public void onSaveButtonClick() {
        try {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        Dao<SudokuBoard> dao = factory.getFileDao("MySudoku.txt");
        dao.write(board);
        } catch (DaoExceptions e) {
            logger.error(DaoExceptions.getDaoMessage("writer.fail"), System.Logger.Level.ERROR);
        }
    }

    public void onMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(HelloController.activeBundle);
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setTitle("Sudoku!");
        stage.setScene(scene);
        stage.show();
    }
}
