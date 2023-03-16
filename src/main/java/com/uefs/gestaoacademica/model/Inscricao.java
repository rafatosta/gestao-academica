package com.uefs.gestaoacademica.model;

import com.uefs.gestaoacademica.dao.DAO;

public class Inscricao {

    private int id;
    private String semestre;
    private int alunoID;
    private int disciplinaID;

    public Inscricao(String semestre, Aluno aluno, Disciplina disciplina) {
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

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Inscricao) {
            Inscricao i = (Inscricao) obj;
            if (this.getId() == i.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getId() + ", " + this.getAluno().getNome() + ", " + this.getDisciplina().getNome() + ", " + this.getSemestre();
    }
}
