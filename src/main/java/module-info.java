module project.jpwp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.management;
    requires java.sql;

    opens project.jpwp to javafx.fxml;
    exports project.jpwp;
//    opens project.jpwp to javafx.fxml;
    exports project.jpwp.controllers;
    opens project.jpwp.controllers to javafx.fxml;
}