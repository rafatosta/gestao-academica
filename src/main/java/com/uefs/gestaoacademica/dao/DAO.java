package com.uefs.gestaoacademica.dao;

import com.uefs.gestaoacademica.dao.aluno.AlunoDAO;
import com.uefs.gestaoacademica.dao.aluno.AlunoFileImpl;
import com.uefs.gestaoacademica.dao.aluno.AlunoListImpl;

public class DAO {

    private static AlunoDAO alunoDAO;

    //private static DepartamentoDAO departamentoDAO;

    //private static DisciplinaDAO disciplinaDAO;

    public static AlunoDAO getAluno() {
        /*Singleton - ter um único objeto de classe */
        if (alunoDAO == null) {
            alunoDAO = new AlunoListImpl();
        }
        return alunoDAO;
    }

}
