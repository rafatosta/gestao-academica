package com.uefs.gestaoacademica.model;

import com.uefs.gestaoacademica.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private List<Integer> alunosID;
    private Integer professorID;
    private List<Avaliacao> avaliacoes;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void alocarAluno(Aluno aluno) {
        this.alunosID.add(aluno.getId());
    }

    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        for (Integer alunoID : this.alunosID) {
            Aluno a = DAO.getAluno().findById(alunoID);
            alunos.add(a);
        }
        return alunos;
    }

    public void setProfessor(Professor professor) {
        this.professorID = professor.getId();
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public List<Avaliacao> getAvaliacoes() {
        return this.avaliacoes;
    }


}
