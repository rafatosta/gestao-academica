package com.uefs.gestaoacademicadev.model;

public class Aluno {

    private int id;

    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.nome;
    }
}
