package com.uefs.gestaoacademica.dao;

import com.uefs.gestaoacademica.model.Aluno;

import java.util.List;

public interface CRUD {

    public Object create(Object obj);

    public Object findById(int id);

    public void update(Object obj);

    public void delete(int id);
}
