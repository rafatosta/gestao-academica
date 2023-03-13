package com.uefs.gestaoacademica.dao.professor;

import com.uefs.gestaoacademica.dao.CRUD;
import com.uefs.gestaoacademica.model.Aluno;
import com.uefs.gestaoacademica.model.Professor;

import java.util.List;

public interface ProfessorDAO extends CRUD<Professor> {
    public List<Professor> findByName(String name);

}
