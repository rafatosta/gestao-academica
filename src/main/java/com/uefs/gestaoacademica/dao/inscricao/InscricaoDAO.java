package com.uefs.gestaoacademica.dao.inscricao;

import com.uefs.gestaoacademica.dao.CRUD;
import com.uefs.gestaoacademica.model.Aluno;
import com.uefs.gestaoacademica.model.Disciplina;
import com.uefs.gestaoacademica.model.Inscricao;

import java.util.List;

public interface InscricaoDAO extends CRUD<Inscricao, Exception> {

    public List<Inscricao> getIncricoesByAluno(Aluno aluno);

    public List<Inscricao> getIncricoesByAluno(Aluno aluno, String semestre);

    public List<Inscricao> getInscricoesByDisciplina(Disciplina disciplina, String semestre);

}
