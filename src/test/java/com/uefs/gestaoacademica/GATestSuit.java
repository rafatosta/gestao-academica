package com.uefs.gestaoacademica;

import com.uefs.gestaoacademica.dao.aluno.AlunoListImpl;
import com.uefs.gestaoacademica.model.Disciplina;
import org.junit.platform.suite.api.*;

@SelectPackages({"com.uefs.gestaoacademica.dao", "com.uefs.gestaoacademica.model"})
@Suite
public class GATestSuit {
}
