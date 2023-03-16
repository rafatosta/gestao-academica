package com.uefs.gestaoacademica.dao.inscricao;

import com.uefs.gestaoacademica.model.Aluno;
import com.uefs.gestaoacademica.model.Disciplina;
import com.uefs.gestaoacademica.model.Inscricao;

import java.util.ArrayList;
import java.util.List;

public class InscricaoListImpl implements InscricaoDAO {

    private List<Inscricao> lista;

    private int nextID;

    public InscricaoListImpl() {
        this.lista = new ArrayList<>();
        this.nextID = 0;
    }

    @Override
    public Inscricao create(Inscricao inscricao) {
        inscricao.setId(this.nextID);
        this.nextID++;

        this.lista.add(inscricao);

        return inscricao;
    }

    @Override
    public Inscricao findById(int id) {
        for (Inscricao inscricao : this.lista) {
            if (inscricao.getId() == id) {
                return inscricao;
            }
        }
        return null;
    }

    @Override
    public List<Inscricao> findMany() {
        return this.lista;
    }

    @Override
    public void update(Inscricao inscricao) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId() == inscricao.getId()) {
                this.lista.set(i, inscricao);
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

    @Override
    public List<Inscricao> getIncricoesByAluno(Aluno aluno) {
        List<Inscricao> inscricaoByAluno = new ArrayList<>();
        for (Inscricao inscricao : this.lista) {
            if (inscricao.getAluno().equals(aluno)) {
                inscricaoByAluno.add(inscricao);
            }
        }
        return inscricaoByAluno;
    }

    @Override
    public List<Inscricao> getIncricoesByAluno(Aluno aluno, String semestre) {
        List<Inscricao> inscricaoByAluno = new ArrayList<>();

        for (Inscricao inscricao : this.lista) {
            if (inscricao.getAluno().equals(aluno) && inscricao.getSemestre().equals(semestre)) {
                inscricaoByAluno.add(inscricao);
            }
        }
        return inscricaoByAluno;
    }

    @Override
    public List<Inscricao> getInscricoesByDisciplina(Disciplina disciplina, String semestre) {
        List<Inscricao> inscricaoByDisciplina = new ArrayList<>();
        for (Inscricao inscricao : this.lista) {
            if (inscricao.getDisciplina().equals(disciplina) && inscricao.getSemestre().equals(semestre)) {
                inscricaoByDisciplina.add(inscricao);
            }
        }
        return inscricaoByDisciplina;
    }
}
