package com.uefs.gestaoacademica.dao.disciplina;

import com.uefs.gestaoacademica.model.Disciplina;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DisciplinaListImpl implements DisciplinaDAO {

    private List<Disciplina> lista;

    private int nextID;

    public DisciplinaListImpl() {
        this.lista = new ArrayList<Disciplina>();
        this.nextID = 0;
    }


    @Override
    public Disciplina create(Disciplina obj) {
        return null;
    }

    @Override
    public Disciplina findById(int id) {
        return null;
    }

    @Override
    public List<Disciplina> findMany() {
        return null;
    }

    @Override
    public void update(Disciplina obj) {

    }

    @Override
    public void delete(int id) {

    }
}
