package com.uefs.gestaoacademica.model;

import com.uefs.gestaoacademica.dao.DAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaTest {

    private Disciplina disciplina;

    @BeforeEach
    void setUp() {
        this.disciplina = new Disciplina("Programação II", 60);
    }

    /**
     * Testa a adição de avaliações
     */
    @Test
    void addAvaliacao() throws LimiteAvException {
        Avaliacao av1 = new Avaliacao("Prova 1", 10);
        Avaliacao av2 = new Avaliacao("Prova 2", 10);
        Avaliacao av3 = new Avaliacao("Prova 3", 10);

        this.disciplina.setAvaliacao(av1);
        this.disciplina.setAvaliacao(av2);
        this.disciplina.setAvaliacao(av3);

        assertEquals(av1, this.disciplina.getAvaliacoes().get(0));
        assertEquals(av2, this.disciplina.getAvaliacoes().get(1));
        assertEquals(av3, this.disciplina.getAvaliacoes().get(2));

        assertEquals(this.disciplina.getLIMITE_AVALIACOES(), this.disciplina.getAvaliacoes().size());
    }

    @Test
    public void limiteAvalicao() {
        Avaliacao av1 = new Avaliacao("Prova 1", 10);
        Avaliacao av2 = new Avaliacao("Prova 2", 10);
        Avaliacao av3 = new Avaliacao("Prova 3", 10);
        Avaliacao av4 = new Avaliacao("Prova 4", 10);

        assertThrows(LimiteAvException.class, () -> {
            this.disciplina.setAvaliacao(av1);
            this.disciplina.setAvaliacao(av2);
            this.disciplina.setAvaliacao(av3);
            this.disciplina.setAvaliacao(av4);
        });
    }
}