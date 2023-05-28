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

public class BoardController {

    @FXML
    GridPane myGrid;

    @FXML
    Button backButton;

    private SudokuBoard board;

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
                int finali = i;
                int finalj = j;
                TextField field = new TextField();
                String fieldval = String.valueOf(board.getNumber(i, j));
                field.setText(fieldval.equals("0") ? "" : fieldval);
                field.setAlignment(Pos.CENTER);
                field.setPrefHeight(40);
                field.setPrefWidth(20);
                field.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                    if (!newValue) { //when focus lost
                        if (!field.getText().matches("[1-9]")) {
                            //when it not matches the pattern (1.0 - 6.0)
                            //set the textField empty
                            field.setText("");
                        }
                    }

                });
                JavaBeanIntegerPropertyBuilder builder = JavaBeanIntegerPropertyBuilder.create();
                JavaBeanIntegerProperty prop = builder.bean(board.getNumber(i, j))
                        .name("fieldValue").build();
                StringConverter<Number> converter = new NumberStringConverter();
                Bindings.bindBidirectional(field.textProperty(), prop, converter);
                myGrid.add(field, i, j);

            }
        }
    }
}
