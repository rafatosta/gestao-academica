module com.uefs.gestaoacademica {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.uefs.gestaoacademica to javafx.fxml;
    exports com.uefs.gestaoacademica;
    exports com.uefs.gestaoacademica.controller;
    exports com.uefs.gestaoacademica.model;

    /** Necessário para a Test Suit */
    opens com.uefs.gestaoacademica.dao.aluno;
    opens com.uefs.gestaoacademica.dao.inscricao;
    opens com.uefs.gestaoacademica.model;

    opens com.uefs.gestaoacademica.controller to javafx.fxml;
}