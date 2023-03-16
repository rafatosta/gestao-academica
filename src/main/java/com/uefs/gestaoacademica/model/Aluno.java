package com.uefs.gestaoacademica.model;

import com.uefs.gestaoacademica.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {


    public Aluno(String nome) {
        super(nome);

    }

    @Override
    public String getMatricula() {
        return this.getId() + "AL";
    }

    public List<Inscricao> getInscricoes() {
        return DAO.getInscricao().getIncricoesByAluno(this);
    }

    public List<Inscricao> getInscricoes(int semestre) {
        return DAO.getInscricao().getIncricoesByAluno(this, semestre);
    }

    @Override
    public boolean equals(Object obj) {
        Aluno aluno = (Aluno) obj;

        if (this.getId() == aluno.getId()) {
            return true;
        }
        return false;
    }
}
