package com.uefs.gestaoacademica.model;

import com.uefs.gestaoacademica.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private List<Integer> alunosID;
    private Professor professor;
    private List<Avaliacao> avaliacoes;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void alocarAluno(Aluno aluno) {
        this.alunosID.add(aluno.getId());
    }

    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<Aluno>();

        for (Integer alunoID : this.alunosID) {
            Aluno a = (Aluno) DAO.getAluno().findById(alunoID);
            alunos.add(a);
        }

        return alunos;
    }

    public void setProfessor(Professor professor) {

        this.professor = professor;
    }

    public void setAvaliacao(String desricao, double peso) {
        avaliacoes.add(new Avaliacao(desricao, peso));
    }

    public int getId() {
        return id;
    }
}
