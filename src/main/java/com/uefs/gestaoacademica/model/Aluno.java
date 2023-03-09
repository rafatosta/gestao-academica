package com.uefs.gestaoacademica.model;

public class Aluno extends Pessoa {

    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public String getMatricula() {
        return this.getId() + "AL";
    }


}
