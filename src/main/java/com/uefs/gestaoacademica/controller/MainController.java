package com.uefs.gestaoacademica.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.uefs.gestaoacademica.dao.DAO;
import com.uefs.gestaoacademica.model.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAlt;

    @FXML
    private Button btnDel;

    @FXML
    private Label labelError;

    @FXML
    private TextField nomeAluno;

    @FXML
    private TableView<Aluno> tabelaAlunos;

    private ObservableList<Aluno> alunosData;

    @FXML
    void btnAddAction(ActionEvent event) {
        if (this.nomeAluno.getText() != "") {
            Aluno novoAluno = new Aluno(this.nomeAluno.getText());

            novoAluno = (Aluno) DAO.getAluno().create(novoAluno);

            this.alunosData.add(novoAluno);
            this.clearAll();
        } else {
            this.labelError.setText("Entrada inválida!");
        }

    }

    @FXML
    void btnAltAction(ActionEvent event) {
        int i = this.tabelaAlunos.getSelectionModel().getSelectedIndex();

        if (i >= 0) {
            try {
                Aluno editAluno = this.tabelaAlunos.getSelectionModel().getSelectedItem();
                editAluno.setNome(this.nomeAluno.getText());

                DAO.getAluno().update(editAluno);

                this.alunosData.set(i, editAluno);
                this.clearAll();
            } catch (Exception e) {
                this.labelError.setText("Entradas inválidas!");
            }

        }
    }

    @FXML
    void btnDelAction(ActionEvent event) {
        int i = this.tabelaAlunos.getSelectionModel().getSelectedIndex();
        if (i >= 0) {
            Aluno deleteAluno = this.tabelaAlunos.getSelectionModel().getSelectedItem();

            DAO.getAluno().delete(deleteAluno.getId());

            this.alunosData.remove(i);
        }

    }

    @FXML
    void initialize() {

        List<Aluno> listaAlunos = DAO.getAluno().findMany();

        this.alunosData = FXCollections.observableArrayList();
        this.alunosData.addAll(listaAlunos);

        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<Aluno, String>("id"));

        TableColumn nomeCol = new TableColumn("Nome");
        nomeCol.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));

        this.tabelaAlunos.getColumns().addAll(idCol, nomeCol);
        this.tabelaAlunos.setItems(this.alunosData);
    }

    private void clearAll() {
        this.nomeAluno.clear();
        this.labelError.setText("");
    }

}
