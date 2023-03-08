module com.uefs.gestaoacademicadev {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.uefs.gestaoacademicadev to javafx.fxml;
    exports com.uefs.gestaoacademicadev;
    exports com.uefs.gestaoacademicadev.controller;
    exports com.uefs.gestaoacademicadev.model;
    opens com.uefs.gestaoacademicadev.controller to javafx.fxml;
}