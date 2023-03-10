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
        this.disciplina = new Disciplina("Programação II");
    }

    /**
     * Testa a alocação dos alunos em uma disciplina
     */
    @Test
    void alocarAluno() {
        /* Cria os alunos*/
        Aluno alunoJoao = DAO.getAluno().create(new Aluno("João"));
        Aluno alunoGabriel = DAO.getAluno().create(new Aluno("Gabriel"));

        /* Insere na disciplina */
        this.disciplina.alocarAluno(alunoJoao);
        this.disciplina.alocarAluno(alunoGabriel);

        /* Pega a lista alunos alocados */

        List<Aluno> disciplinaAlunos = this.disciplina.getAlunos();

        /*verifica se são os mesmos retornados*/
        assertEquals(alunoJoao, disciplinaAlunos.get(0));
        assertEquals(alunoGabriel, disciplinaAlunos.get(1));
    }

    /**
     * Testa a adição de avaliações
     */
    @Test
    void setAvaliacao() {
        Avaliacao av1 = new Avaliacao("Prova 1", 10);
        Avaliacao av2 = new Avaliacao("Prova 2", 10);
        Avaliacao av3 = new Avaliacao("Prova 3", 10);

        this.disciplina.setAvaliacao(av1);
        this.disciplina.setAvaliacao(av2);
        this.disciplina.setAvaliacao(av3);

        assertEquals(av1, this.disciplina.getAvaliacoes().get(0));
        assertEquals(av2, this.disciplina.getAvaliacoes().get(1));
        assertEquals(av3, this.disciplina.getAvaliacoes().get(2));

        /* Testa a adição além do permitido */
        Avaliacao av4 = new Avaliacao("Prova 4", 10);
        this.disciplina.setAvaliacao(av4);

        assertEquals(this.disciplina.getLIMITE_AVALIACOES(), this.disciplina.getAvaliacoes().size());

    }
}