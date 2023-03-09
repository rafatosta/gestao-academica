package com.uefs.gestaoacademica.dao.aluno;

import com.uefs.gestaoacademica.model.Aluno;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlunoListImpl implements AlunoDAO {

    private List<Object> lista;

    private int nextID;

    public AlunoListImpl() {
        this.lista = new ArrayList<Object>();
        this.nextID = 0;
    }

    @Override
    public Aluno create(Object obj) {
        Aluno aluno = (Aluno) obj;
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
    public Object findById(int id) {
        for (Object a : this.lista) {
            Aluno aluno = (Aluno) a;
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> findByName(String name) {
        List<Aluno> listAluno = new ArrayList<Aluno>();
        for (Object a : this.lista) {
            Aluno aluno = (Aluno) a;
            if (aluno.getNome() == name) {
                listAluno.add(aluno);
            }
        }
        return listAluno;
    }

    @Override
    public void update(Object obj) {
        Aluno upAluno = (Aluno) obj;
        for (int i = 0; i < this.lista.size(); i++) {
            Aluno alunoL = (Aluno) this.lista.get(i);
            if (alunoL.getId() == upAluno.getId()) {
                this.lista.add(i, upAluno);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.lista.size(); i++) {
            Aluno alunoL = (Aluno) this.lista.get(i);
            if (alunoL.getId() == id) {
                this.lista.remove(i);
                return;
            }
        }
    }
}
