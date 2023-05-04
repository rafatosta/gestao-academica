package com.uefs.gestaoacademica.model;

import com.uefs.gestaoacademica.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private int id;
    private String nome;
    private int carga_horaria;
    private Integer professorID;
    private List<Avaliacao> avaliacoes;

    private final int LIMITE_AVALIACOES = 3;

    public Disciplina(String nome, int carga_horaria) {
        this.nome = nome;
        this.carga_horaria = carga_horaria;
        this.avaliacoes = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Inscricao> getInscricoes(String semestre) {
        return DAO.getInscricao().getInscricoesByDisciplina(this, semestre);
    }

    public void setProfessor(Professor professor) {
        this.professorID = professor.getId();
    }

    public void setAvaliacao(Avaliacao avaliacao) throws LimiteAvException {
        if (this.avaliacoes.size() < LIMITE_AVALIACOES) {
            avaliacoes.add(avaliacao);
        } else {
            throw new LimiteAvException(avaliacao, this);
        }
    }

    public List<Avaliacao> getAvaliacoes() {
        return this.avaliacoes;
    }

    public int getLIMITE_AVALIACOES() {
        return this.LIMITE_AVALIACOES;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Disciplina) {
            Disciplina i = (Disciplina) obj;
            if (this.getId() == i.getId()) {
                return true;
            }
        }
        return false;
    }
}
