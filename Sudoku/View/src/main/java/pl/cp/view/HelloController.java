package pl.cp.view;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import pl.cp.DifficultyLevel;

public class HelloController {


    @FXML
    Button easy;

    @FXML
    Button medium;

    @FXML
    Button hard;

    @FXML
    MenuItem englishChoice;

    @FXML
    MenuItem polishChoice;

    @FXML
    MenuItem aboutItem;

    public static ResourceBundle activeBundle;

    public static Locale activeLocale;

    public static ResourceBundle authorsBundle;

    public static DifficultyLevel difficultyLevel;

    public void setBoardScene() throws Exception {
        FXMLLoader fxmlLoader =
                new FXMLLoader(HelloApplication.class.getResource("board-view.fxml"));
        fxmlLoader.setResources(activeBundle);
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        Stage stage = (Stage) easy.getScene().getWindow();
        stage.setTitle("Sudoku!");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void onEasyButtonClick() throws Exception {
        difficultyLevel = DifficultyLevel.Easy;
        setBoardScene();
    }

    @FXML
    protected void onMediumButtonClick() throws Exception {
        difficultyLevel = DifficultyLevel.Medium;
        setBoardScene();
    }

    @FXML
    protected void onHardButtonClick() throws Exception {
        difficultyLevel = DifficultyLevel.Hard;
        setBoardScene();
    }

    public void onEnglishItemClick() throws IOException {
        activeLocale = new Locale.Builder().setRegion("Us").setLanguage("en").build();
        activeBundle = ResourceBundle.getBundle("pl.cp.i18n.App", activeLocale);
        authorsBundle = ResourceBundle.getBundle("pl.cp.view.Authors", activeLocale);
        FXMLLoader fxmlLoader =
                new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(activeBundle);
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        Stage stage = (Stage) easy.getScene().getWindow();
        stage.setTitle("Sudoku!");
        stage.setScene(scene);
        stage.show();
    }

    public void onPolishItemClick() throws IOException {
        activeLocale = new Locale.Builder().setRegion("PL").setLanguage("pl").build();
        activeBundle = ResourceBundle.getBundle("pl.cp.i18n.App", activeLocale);
        authorsBundle = ResourceBundle.getBundle("pl.cp.view.Authors", activeLocale);
        FXMLLoader fxmlLoader =
                new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(activeBundle);
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        Stage stage = (Stage) easy.getScene().getWindow();
        stage.setTitle("Sudoku!");
        stage.setScene(scene);
        stage.show();
    }

    public void onAuthorsClick() throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(HelloApplication.class.getResource("author-view.fxml"));
        fxmlLoader.setResources(authorsBundle);
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        Stage stage = new Stage();
        stage.setTitle("Authors");
        stage.setScene(scene);
        stage.show();
    }
}