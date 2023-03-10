package com.uefs.gestaoacademica.dao.disciplina;

import com.uefs.gestaoacademica.model.Aluno;
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
    public Disciplina create(Disciplina disciplina) {
        disciplina.setId(this.nextID);
        this.nextID++;

        this.lista.add(disciplina);

        return disciplina;
    }

    @Override
    public Disciplina findById(int id) {
        for (Disciplina disciplina : this.lista) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }
        return null;
    }

    @Override
    public List<Disciplina> findMany() {
        return this.lista;
    }

    @Override
    public void update(Disciplina disciplina) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == disciplina.getId()) {
                this.lista.add(i, disciplina);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == id) {
                this.lista.remove(i);
                return;
            }
        }
    }
}
