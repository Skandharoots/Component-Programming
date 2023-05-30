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
        Locale locale = new Locale.Builder().setRegion("en").setLanguage("US").build();
        ResourceBundle bundle = ResourceBundle.getBundle("pl.cp.i18n.App", locale);
        fxmlLoader.setResources(bundle);
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Sudoku!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}