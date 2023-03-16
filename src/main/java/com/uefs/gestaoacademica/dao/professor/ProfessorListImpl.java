package com.uefs.gestaoacademica.dao.professor;

import com.uefs.gestaoacademica.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorListImpl implements ProfessorDAO {

    private List<Professor> lista;

    private int nextID;

    public ProfessorListImpl() {
        this.lista = new ArrayList<>();
        this.nextID = 0;
    }

    @Override
    public Professor create(Professor professor) {
        professor.setId(this.nextID);
        this.nextID++;

        this.lista.add(professor);

        return professor;
    }

    @Override
    public List<Professor> findMany() {
        List<Professor> listProfessor = new ArrayList<Professor>();
        for (Object o : this.lista) {
            listProfessor.add((Professor) o);
        }
        return listProfessor;
    }

    @Override
    public Professor findById(int id) {
        for (Professor professor : this.lista) {
            if (professor.getId() == id) {
                return professor;
            }
        }
        return null;
    }

    @Override
    public List<Professor> findByName(String name) {
        List<Professor> listProfessor = new ArrayList<Professor>();
        for (Professor professor : this.lista) {
            if (professor.getNome() == name) {
                listProfessor.add(professor);
            }
        }
        return listProfessor;
    }

    @Override
    public void update(Professor professor) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == professor.getId()) {
                this.lista.set(i, professor);
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

    @Override
    public void deleteMany() {
        this.lista = new ArrayList<>();
        this.nextID = 0;
    }
}
