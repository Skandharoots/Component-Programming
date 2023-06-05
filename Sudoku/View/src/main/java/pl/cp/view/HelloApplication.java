package pl.cp.view;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            HelloController.activeLocale =
                    new Locale.Builder().setRegion("US").setLanguage("en").build();
            HelloController.activeBundle =
                    ResourceBundle.getBundle("pl.cp.i18n.App", HelloController.activeLocale);
            HelloController.authorsBundle =
                    ResourceBundle.getBundle("pl.cp.i18n.Authors", HelloController.activeLocale);
            FXMLLoader fxmlLoader =
                    new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            fxmlLoader.setResources(HelloController.activeBundle);
            Scene scene = new Scene(fxmlLoader.load(), 500, 500);
            stage.setTitle("Sudoku!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException | MissingResourceException e) {
            InputException ex = new InputException(InputException.APP_FAIL, e);
            ex.setBundle();
            throw ex;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}