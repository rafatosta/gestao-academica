package com.uefs.gestaoacademica.dao.aluno;

import com.uefs.gestaoacademica.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoListImpl implements AlunoDAO {

    private List<Aluno> lista;

    private int nextID;

    public AlunoListImpl() {
        this.lista = new ArrayList<Aluno>();
        this.nextID = 0;
    }

    @Override
    public Aluno create(Aluno aluno) {
        aluno.setId(this.nextID);
        this.nextID++;

        this.lista.add(aluno);

        return aluno;
    }

    @Override
    public List<Aluno> findMany() {
        List<Aluno> listAluno = new ArrayList<Aluno>();
        for (Object o : this.lista) {
            listAluno.add((Aluno) o);
        }
        return listAluno;
    }

    @Override
    public Aluno findById(int id) {
        for (Aluno aluno : this.lista) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> findByName(String name) {
        List<Aluno> listAluno = new ArrayList<Aluno>();
        for (Aluno aluno : this.lista) {
            if (aluno.getNome() == name) {
                listAluno.add(aluno);
            }
        }
        return listAluno;
    }

    @Override
    public void update(Aluno aluno) throws Exception{
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == aluno.getId()) {
                this.lista.set(i, aluno);
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
