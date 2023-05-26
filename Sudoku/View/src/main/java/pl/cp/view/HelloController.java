package pl.cp.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import pl.cp.DifficultyLevel;

public class HelloController {


    @FXML
    Button easy;

    @FXML
    Button medium;

    @FXML
    Button hard;

    static DifficultyLevel difficultyLevel;

    public void setBoardScene() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("board-view.fxml"));
        Stage window = (Stage) easy.getScene().getWindow();
        Scene scene = new Scene(root, 500, 500);
        window.setScene(scene);
    }


    @FXML
    protected void onEasyButtonClick() throws Exception {
        difficultyLevel = new DifficultyLevel(DifficultyLevel.Difficulty.Easy);
        setBoardScene();
    }

    @FXML
    protected void onMediumButtonClick() throws Exception {
        difficultyLevel = new DifficultyLevel(DifficultyLevel.Difficulty.Medium);
        setBoardScene();
    }

    @FXML
    protected void onHardButtonClick() throws Exception {
        difficultyLevel = new DifficultyLevel(DifficultyLevel.Difficulty.Hard);
        setBoardScene();
    }
}