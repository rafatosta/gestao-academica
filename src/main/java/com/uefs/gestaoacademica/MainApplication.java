package com.uefs.gestaoacademica;

import com.uefs.gestaoacademica.model.Avaliacao;
import com.uefs.gestaoacademica.model.Disciplina;
import com.uefs.gestaoacademica.model.LimiteAvException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws LimiteAvException {

        Disciplina d = new Disciplina("Prog 2", 60);


            d.setAvaliacao(new Avaliacao("Av1", 5));
            d.setAvaliacao(new Avaliacao("Av1", 5));
            d.setAvaliacao(new Avaliacao("Av1", 5));
            d.setAvaliacao(new Avaliacao("Av error", 5));





       // launch();
    }
}