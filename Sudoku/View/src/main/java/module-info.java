module pl.cp.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.slf4j;
    requires Model;

    opens pl.cp.view to javafx.fxml;
    exports pl.cp.view;
}