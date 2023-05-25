module Model {
    requires org.apache.commons.lang3;

    opens pl.cp to org.apache.commons.lang3, pl.cp.view;
    exports pl.cp to pl.cp.view;
}