package pl.cp.view;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Locale locale = new Locale.Builder().setRegion("US").setLanguage("en").build();
        HelloController.activeBundle = ResourceBundle.getBundle("pl.cp.i18n.App", locale);
        HelloController.authorsBundle = ResourceBundle.getBundle("pl.cp.i18n.Authors", locale);
        fxmlLoader.setResources(HelloController.activeBundle);
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Sudoku!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}