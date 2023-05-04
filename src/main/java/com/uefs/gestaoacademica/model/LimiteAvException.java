package com.uefs.gestaoacademica.model;

public class LimiteAvException extends Exception {
    private Avaliacao avaliacao;
    private Disciplina disciplina;

    public LimiteAvException(Avaliacao avaliacao, Disciplina disciplina) {
        super("Limite excedido!");
        this.avaliacao = avaliacao;
        this.disciplina = disciplina;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " - " + this.disciplina.getNome();
    }
}
