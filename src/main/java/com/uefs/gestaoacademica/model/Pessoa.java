package com.uefs.gestaoacademica.model;

public abstract class Pessoa {

    private int id;

    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getMatricula();

    @Override
    public String toString() {
        return this.id + "\t" + this.nome;
    }
}
