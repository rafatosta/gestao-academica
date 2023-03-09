package com.uefs.gestaoacademica.dao.disciplina;

import com.uefs.gestaoacademica.model.Disciplina;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DisciplinaListImpl implements DisciplinaDAO {

    private List<Object> lista;

    private int nextID;

    public DisciplinaListImpl() {
        this.lista = new ArrayList<Object>();
        this.nextID = 0;
    }


    @Override
    public Object create(Object obj) {
        return null;
    }

    @Override
    public List<Disciplina> findMany() {
        return null;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(int id) {

    }
}
