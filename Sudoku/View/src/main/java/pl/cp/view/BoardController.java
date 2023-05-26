package pl.cp.view;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import pl.cp.BacktrackingSudokuSolver;
import pl.cp.SudokuBoard;

public class BoardController {

    @FXML
    GridPane myGrid;

    @FXML
    Button backButton;

    private SudokuBoard board;

    @FXML
    public void initialize() {
        board = new SudokuBoard(new BacktrackingSudokuSolver());
        board.solveGame();
        HelloController.difficultyLevel.createBoard(board);
        populateGrid();
    }

    public void populateGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                TextField field = new TextField();
                String fieldval = Integer.toString(board.getNumber(i, j));
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
                myGrid.add(field, i, j);
            }
        }
    }
}
