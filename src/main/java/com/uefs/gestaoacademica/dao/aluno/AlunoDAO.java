package com.uefs.gestaoacademica.dao.aluno;

import com.uefs.gestaoacademica.dao.CRUD;
import com.uefs.gestaoacademica.model.Aluno;

import java.util.List;

public interface AlunoDAO extends CRUD<Aluno> {
    public List<Aluno> findByName(String name);

}
