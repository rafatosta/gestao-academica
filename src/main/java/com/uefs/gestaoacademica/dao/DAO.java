package com.uefs.gestaoacademica.dao;

import com.uefs.gestaoacademica.dao.aluno.AlunoDAO;
import com.uefs.gestaoacademica.dao.aluno.AlunoFileImpl;
import com.uefs.gestaoacademica.dao.aluno.AlunoListImpl;
import com.uefs.gestaoacademica.dao.disciplina.DisciplinaDAO;
import com.uefs.gestaoacademica.dao.disciplina.DisciplinaListImpl;

public class DAO {

    private static AlunoDAO alunoDAO;

    private static DisciplinaDAO disciplinaDAO;

    public static AlunoDAO getAluno() {
        if (alunoDAO == null) {
            alunoDAO = new AlunoListImpl();
        }
        return alunoDAO;
    }

    public static DisciplinaDAO getDisciplina() {
        if (disciplinaDAO == null) {
            disciplinaDAO = new DisciplinaListImpl();
        }
        return disciplinaDAO;
    }

}
