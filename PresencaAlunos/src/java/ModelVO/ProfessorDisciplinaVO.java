/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelVO;

/**
 *
 * @author felipe
 */
public class ProfessorDisciplinaVO {
    private int idProfessor;
    private int idDisciplina;

    public ProfessorDisciplinaVO(int idProfessor, int idDisciplina) {
        this.idProfessor = idProfessor;
        this.idDisciplina = idDisciplina;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
