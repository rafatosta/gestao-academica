package com.uefs.gestaoacademica.model;

import java.util.List;

public class Departamento {

    private List<Professor> professores;

    public void setProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public List<Professor> getProfessores() {
        return professores;
    }
}
