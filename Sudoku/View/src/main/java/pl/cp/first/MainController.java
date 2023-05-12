package pl.cp.first;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.cp.SudokuBoard;

public class MainController {

    private SudokuBoard board;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}