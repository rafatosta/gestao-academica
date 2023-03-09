package com.uefs.gestaoacademica.model;

public class Professor extends Pessoa {

    public Professor(String nome) {
        super(nome);
    }

    @Override
    public String getMatricula() {
        return this.getId() + "PROF";
    }


}
