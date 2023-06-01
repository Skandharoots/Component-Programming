module pl.cp.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires Model;
    requires slf4j.api;

    opens pl.cp.view to javafx.fxml;
    exports pl.cp.view;
}