package com.uefs.gestaoacademica.model;

import com.uefs.gestaoacademica.dao.DAO;

public class Inscricao {

    private int id;
    private int semestre;
    private int alunoID;
    private int disciplinaID;

    public Inscricao(int semestre, Aluno aluno, Disciplina disciplina) {
        this.semestre = semestre;
        this.alunoID = aluno.getId();
        this.disciplinaID = disciplina.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Aluno getAluno() {
        return DAO.getAluno().findById(this.alunoID);
    }

    public void setAluno(Aluno aluno) {
        this.alunoID = aluno.getId();
    }

    public Disciplina getDisciplina() {
        return DAO.getDisciplina().findById(this.disciplinaID);
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplinaID = disciplina.getId();
    }
}
