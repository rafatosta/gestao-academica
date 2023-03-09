package com.uefs.gestaoacademica.model;

import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private List<Aluno> alunos;
    private Professor professor;
    private List<Avaliacao> avaliacoes;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setAvaliacao(String desricao, double peso) {
        avaliacoes.add(new Avaliacao(desricao, peso));
    }
}
