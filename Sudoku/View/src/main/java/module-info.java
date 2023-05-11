module pl.cp.first.view {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.cp.first.view to javafx.fxml;
    exports pl.cp.first.view;
}