package pl.cp.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import pl.cp.DifficultyLevel;

public class HelloController implements Initializable {


    @FXML
    Button easy;

    @FXML
    Button medium;

    @FXML
    Button hard;

    @FXML
    ChoiceBox<String> choiceBox;

    private final String[] choiceb = {"English", "Polski"};

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBox.getItems().addAll(choiceb);
        choiceBox.setValue("English");
        choiceBox.setOnAction(this::changeLanguage);
    }

    public void changeLanguage(ActionEvent event) {
        String choice = choiceBox.getValue();
        switch (choice) {
            case "English":
                break;
            case "Polski":
                break;
            default:
                break;
        }
    }
}