package com.uefs.gestaoacademica.model;

public class Professor {
    private int id;
    private String nome;

    public Professor(String nome) {
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
