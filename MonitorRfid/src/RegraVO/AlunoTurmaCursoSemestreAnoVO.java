/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraVO;

/**
 *
 * @author felipe
 */
public class AlunoTurmaCursoSemestreAnoVO {

    private int idTurma;
    private int idCurso;
    private int idAluno;
    private String nomeAluno;
    private String cartaoRfid;
    private String codigoMatriculaAluno;
    private String turma;
    private String semestreAno;
    private String periodoTurma;
    private String nomeCurso;

    public AlunoTurmaCursoSemestreAnoVO() {/**/
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getSemestreAno() {
        return semestreAno;
    }

    public void setSemestreAno(String semestreAno) {
        this.semestreAno = semestreAno;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getCartaoRfid() {
        return cartaoRfid;
    }

    public void setCartaoRfid(String cartaoRfid) {
        this.cartaoRfid = cartaoRfid;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getCodigoMatriculaAluno() {
        return codigoMatriculaAluno;
    }

    public void setCodigoMatriculaAluno(String codigoMatriculaAluno) {
        this.codigoMatriculaAluno = codigoMatriculaAluno;
    }

    public String getPeriodoTurma() {
        return periodoTurma;
    }

    public void setPeriodoTurma(String periodoTurma) {
        this.periodoTurma = periodoTurma;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

}
