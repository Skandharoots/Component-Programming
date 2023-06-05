package pl.cp.view;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(HelloController.class.getName());

    public void setBoardScene() throws InputException {
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(HelloApplication.class.getResource("board-view.fxml"));
            fxmlLoader.setResources(activeBundle);
            Scene scene = new Scene(fxmlLoader.load(), 500, 500);
            Stage stage = (Stage) easy.getScene().getWindow();
            stage.setTitle("Sudoku!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            InputException ex = new InputException(InputException.BOR_FAIL, e);
            ex.setBundle();
            throw ex;
        }
    }


    @FXML
    protected void onEasyButtonClick() {
        difficultyLevel = DifficultyLevel.Easy;
        try {
            setBoardScene();
        } catch (InputException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    @FXML
    protected void onMediumButtonClick() {
        difficultyLevel = DifficultyLevel.Medium;
        try {
            setBoardScene();
        } catch (InputException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    @FXML
    protected void onHardButtonClick() {
        difficultyLevel = DifficultyLevel.Hard;
        try {
            setBoardScene();
        } catch (InputException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    public void switchToEnglish() throws InputException {
        try {
            activeLocale = new Locale.Builder().setRegion("Us").setLanguage("en").build();
            generateBundle();
        } catch (IOException | MissingResourceException e) {
            InputException ex = new InputException(InputException.ENG_FAIL, e);
            ex.setBundle();
            throw ex;
        }
    }

    public void switchToPolish() throws InputException {
        try {
            activeLocale = new Locale.Builder().setRegion("PL").setLanguage("pl").build();
            generateBundle();
        } catch (IOException | MissingResourceException e) {
            InputException ex = new InputException(InputException.POL_FAIL, e);
            ex.setBundle();
            throw ex;
        }
    }

    private void generateBundle() throws InputException {
        try {
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
        } catch (IOException | MissingResourceException e) {
            InputException ex = new InputException(InputException.INPUT_FAIL, e);
            ex.setBundle();
            throw ex;
        }
    }

    public void switchToAuthorsWindow() throws InputException {
        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(HelloApplication.class.getResource("author-view.fxml"));
            fxmlLoader.setResources(authorsBundle);
            Scene scene = new Scene(fxmlLoader.load(), 500, 500);
            Stage stage = new Stage();
            stage.setTitle("Authors");
            stage.setScene(scene);
            stage.show();
        } catch (IOException | MissingResourceException e) {
            InputException ex = new InputException(InputException.AUTH_FAIL, e);
            ex.setBundle();
            throw ex;
        }
    }

    public void onEnglishItemClick() {
        try {
            switchToEnglish();
        } catch (InputException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    public void onPolishItemClick() {
        try {
            switchToPolish();
        } catch (InputException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    public void onAuthorsClick() throws IOException {
        try {
            switchToAuthorsWindow();
        } catch (InputException e) {
            logger.error(e.getLocalizedMessage());
        }
    }
}