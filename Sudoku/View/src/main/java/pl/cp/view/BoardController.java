package pl.cp.view;

import javafx.beans.binding.Bindings;
import javafx.beans.property.adapter.JavaBeanIntegerProperty;
import javafx.beans.property.adapter.JavaBeanIntegerPropertyBuilder;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import pl.cp.BacktrackingSudokuSolver;
import pl.cp.SudokuBoard;
import pl.cp.SudokuField;

public class BoardController {

    @FXML
    GridPane myGrid;

    @FXML
    Button backButton;

    private SudokuBoard board;

    private HelloApplication mainApp;

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
                //StringConverter<Number> converter = new NumberStringConverter();
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
                    if (!newValue) {
                        if (!field.getText().matches("[1-9]") || !board.checkBoard()) {
                            field.setText("");
                        }
                    }

                });
                myGrid.add(field, i, j);



            }
        }
    }
}
