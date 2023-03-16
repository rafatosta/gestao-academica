package com.uefs.gestaoacademica.dao.inscricao;

import com.uefs.gestaoacademica.dao.DAO;
import com.uefs.gestaoacademica.dao.aluno.AlunoDAO;
import com.uefs.gestaoacademica.model.Aluno;
import com.uefs.gestaoacademica.model.Disciplina;
import com.uefs.gestaoacademica.model.Inscricao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscricaoListImplTest {

    private Aluno aluno1;
    private Aluno aluno2;

    private Disciplina disciplina1;

    private Disciplina disciplina2;

    /**
     * Executa ANTES de cada teste
     */
    @BeforeEach
    void setUp() {
        aluno1 = DAO.getAluno().create(new Aluno("João"));
        disciplina1 = DAO.getDisciplina().create(new Disciplina("Programação 2", 60));

        aluno2 = DAO.getAluno().create(new Aluno("Gabriel"));
        disciplina2 = DAO.getDisciplina().create(new Disciplina("Engenharia de Software", 90));
    }

    /**
     * Executa DEPOIS de cada teste
     */
    @AfterEach
    void tearDown() {
        DAO.getAluno().deleteMany();
        DAO.getDisciplina().deleteMany();
        DAO.getInscricao().deleteMany();
    }

    @Test
    void create() {
        Inscricao esperado = new Inscricao("2023.1", aluno1, disciplina1);
        esperado.setId(0);

        Inscricao atual = DAO.getInscricao().create(new Inscricao("2023.1", aluno1, disciplina1));

        assertEquals(esperado, atual, "Criação de uma instrução");
    }

    @Test
    void findById() {
        Inscricao atual = DAO.getInscricao().create(new Inscricao("2023.1", aluno1, disciplina1));
        Inscricao esperado = DAO.getInscricao().findById(0);

        assertEquals(esperado, atual);

        atual = DAO.getInscricao().create(new Inscricao("2023.1", aluno1, disciplina2));
        esperado = DAO.getInscricao().findById(1);

        assertEquals(esperado, atual);

    }

    @Test
    void findMany() {
        DAO.getInscricao().create(new Inscricao("2023.1", aluno1, disciplina1));
        DAO.getInscricao().create(new Inscricao("2023.1", aluno1, disciplina2));

        List<Inscricao> lista = DAO.getInscricao().findMany();
        int tamanho_esperado = 2;
        assertEquals(tamanho_esperado, lista.size());
    }

    @Test
    void getIncricoesByAluno() {
        DAO.getInscricao().create(new Inscricao("2023.1", aluno1, disciplina1));
        DAO.getInscricao().create(new Inscricao("2023.1", aluno1, disciplina2));

        List<Inscricao> incricoesByAluno = DAO.getInscricao().getIncricoesByAluno(aluno1);
        assertEquals(disciplina1, incricoesByAluno.get(0).getDisciplina());
        assertEquals(disciplina2, incricoesByAluno.get(1).getDisciplina());
    }

    @Test
    void getIncricoesByAlunoSemestre() {
        String semestre1 = "2023.1";
        String semestre2 = "2023.2";
        String semestre3 = "2024.2";


        DAO.getInscricao().create(new Inscricao(semestre1, aluno1, disciplina1));
        DAO.getInscricao().create(new Inscricao(semestre1, aluno1, disciplina2));

        DAO.getInscricao().create(new Inscricao(semestre2, aluno1, disciplina1));


        List<Inscricao> iByAlunoS1 = DAO.getInscricao().getIncricoesByAluno(aluno1, semestre1);
        List<Inscricao> iByAlunoS2 = DAO.getInscricao().getIncricoesByAluno(aluno1, semestre2);

        List<Inscricao> iByAlunoS3 = DAO.getInscricao().getIncricoesByAluno(aluno1, semestre3);

        assertEquals(2, iByAlunoS1.size());
        assertEquals(1, iByAlunoS2.size());
        assertEquals(0, iByAlunoS3.size());

    }

    @Test
    void getInscricoesByDisciplina() {
        String semestre1 = "2023.1";
        String semestre2 = "2023.2";
        String semestre3 = "2024.2";


        DAO.getInscricao().create(new Inscricao(semestre1, aluno1, disciplina1));
        DAO.getInscricao().create(new Inscricao(semestre1, aluno1, disciplina2));
        DAO.getInscricao().create(new Inscricao(semestre2, aluno1, disciplina1));

        DAO.getInscricao().create(new Inscricao(semestre1, aluno2, disciplina1));
        DAO.getInscricao().create(new Inscricao(semestre1, aluno2, disciplina2));


        List<Inscricao> iByDisciplinaS1 = DAO.getInscricao().getInscricoesByDisciplina(disciplina1, semestre1);
        List<Inscricao> iByDisciplinaS2 = DAO.getInscricao().getInscricoesByDisciplina(disciplina1, semestre2);

        List<Inscricao> iByDisciplinaS3 = DAO.getInscricao().getInscricoesByDisciplina(disciplina1, semestre3);

        assertEquals(2, iByDisciplinaS1.size());
        assertEquals(1, iByDisciplinaS2.size());
        assertEquals(0, iByDisciplinaS3.size());
    }


}