package com.uefs.gestaoacademica.model;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.nome;
    }
}
