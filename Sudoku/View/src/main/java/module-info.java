module pl.cp.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires Model;
    requires org.slf4j;
    requires java.sql;

    opens pl.cp.view to javafx.fxml;
    exports pl.cp.view;
}