package pl.cp.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.cp.SudokuBoard;

public class HelloController {
    private SudokuBoard board;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}