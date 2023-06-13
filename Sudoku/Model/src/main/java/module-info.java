module Model {
    requires org.apache.commons.lang3;
    requires java.sql;


    opens pl.cp to org.apache.commons.lang3, pl.cp.view, javafx.base;
    exports pl.cp to pl.cp.view;
}