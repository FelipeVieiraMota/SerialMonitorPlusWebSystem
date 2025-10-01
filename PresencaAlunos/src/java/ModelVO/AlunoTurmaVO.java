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
public class AlunoTurmaVO {
    private int idAluno;
    private int idTurma;
    private String nomeAluno;
    private String turma;
    
    public AlunoTurmaVO(int idAluno, int idTurma) {
        this.idAluno = idAluno;
        this.idTurma = idTurma;
    }
    
    public AlunoTurmaVO(){}

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    
}
