package com.uefs.gestaoacademica.dao.aluno;

import com.uefs.gestaoacademica.dao.DAO;
import com.uefs.gestaoacademica.model.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoListImplTest {

    @Test
    void create() {
        AlunoDAO dao = new AlunoListImpl();

        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("João");

        a1.setId(0);
        a2.setId(1);

        Aluno newA1 = dao.create(a1);
        Aluno newA2 = dao.create(a2);

        assertEquals(a1, newA1);
        assertEquals(a2, newA2);
    }

    @Test
    void findMany() {
        AlunoDAO dao = new AlunoListImpl();

        dao.create(new Aluno("Rafael"));
        dao.create(new Aluno("João"));

        List<Aluno> many = dao.findMany();
        assertEquals(2, many.size());
    }

    @Test
    void findById() {
        AlunoDAO dao = new AlunoListImpl();

        dao.create(new Aluno("Rafael"));
        dao.create(new Aluno("João"));

        Aluno byId = dao.findById(1);
        assertEquals(1, byId.getId());

        Aluno byIdNull = dao.findById(5);
        assertNull(byIdNull);
    }

    @Test
    void findByName() {
        AlunoDAO dao = new AlunoListImpl();

        dao.create(new Aluno("Rafael"));
        dao.create(new Aluno("João"));

        List<Aluno> findByName = dao.findByName("João");
        assertEquals(1, findByName.get(0).getId());

        List<Aluno> findByNameNull = dao.findByName("Rafael Tosta");
        assertEquals(0, findByNameNull.size());
    }

    @Test
    void update() {
        AlunoDAO dao = new AlunoListImpl();

        Aluno jg = new Aluno("José");
        jg = dao.create(jg);

        jg.setNome("José Gabriel");
        dao.update(jg);

        Aluno byId = dao.findById(jg.getId());
        assertEquals(jg.getNome(), byId.getNome());
    }

    @Test
    void delete() {
        AlunoDAO dao = new AlunoListImpl();

        dao.create(new Aluno("Rafael"));
        dao.create(new Aluno("João"));
        dao.create(new Aluno("Gabriel"));
        dao.create(new Aluno("Carlos"));
        dao.create(new Aluno("Matheus"));

        dao.delete(0);
        dao.delete(2);
        dao.delete(4);

        Aluno byId = dao.findById(0);
        assertNull(byId);
        Aluno byId2 = dao.findById(2);
        assertNull(byId);
        Aluno byId4 = dao.findById(4);
        assertNull(byId);

        List<Aluno> many = dao.findMany();
        assertEquals(2, many.size());
    }
}