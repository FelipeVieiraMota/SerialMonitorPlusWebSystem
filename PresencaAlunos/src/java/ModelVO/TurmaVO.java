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
public class TurmaVO {

    private int idTurma;
    private int idSemestre;
    private int idCurso;
    private String anoSemestre;
    private String curso;
    private String nomeTurma;
    private String abreviacaoTurma;
    private String ciclo;
    private String periodo;
    private String codigoTurma;
    private String observacoes;

    public TurmaVO() {/* Here, this space must be void*/}

    public TurmaVO(String anoSemestre, String curso, String nomeTurma, String abreviacaoTurma, String ciclo, String periodo, String observacoes) {
        this.anoSemestre = anoSemestre;
        this.curso = curso;
        this.nomeTurma = nomeTurma;
        this.abreviacaoTurma = abreviacaoTurma;
        this.ciclo = ciclo;
        this.periodo = periodo;
        this.observacoes = observacoes;
    }
    

    public TurmaVO(String anoSemestre, String curso, String nomeTurma, String abreviacaoTurma, String ciclo, String periodo, String codigoTurma, String observacoes) {
        this.anoSemestre = anoSemestre;
        this.curso = curso;
        this.nomeTurma = nomeTurma;
        this.abreviacaoTurma = abreviacaoTurma;
        this.ciclo = ciclo;
        this.periodo = periodo;
        this.codigoTurma = codigoTurma;
        this.observacoes = observacoes;
    }

    public TurmaVO(int idCurso, String anoSemestre, String curso, String nomeTurma, String abreviacaoTurma, String ciclo, String periodo, String codigoTurma, String observacoes) {
        this.idCurso = idCurso;
        this.anoSemestre = anoSemestre;
        this.curso = curso;
        this.nomeTurma = nomeTurma;
        this.abreviacaoTurma = abreviacaoTurma;
        this.ciclo = ciclo;
        this.periodo = periodo;
        this.codigoTurma = codigoTurma;
        this.observacoes = observacoes;
    }

    public TurmaVO(int idSemestre, int idCurso, String anoSemestre, String curso, String nomeTurma, String abreviacaoTurma, String ciclo, String periodo, String codigoTurma, String observacoes) {
        this.idSemestre = idSemestre;
        this.idCurso = idCurso;
        this.anoSemestre = anoSemestre;
        this.curso = curso;
        this.nomeTurma = nomeTurma;
        this.abreviacaoTurma = abreviacaoTurma;
        this.ciclo = ciclo;
        this.periodo = periodo;
        this.codigoTurma = codigoTurma;
        this.observacoes = observacoes;
    }

    public TurmaVO(int idCurso, String anoSemestre, int idTurma, String curso, String nomeTurma, String abreviacaoTurma, String ciclo, String periodo, String codigoTurma, String observacoes) {
        this.idCurso = idCurso;
        this.anoSemestre = anoSemestre;
        this.idTurma = idTurma;
        this.curso = curso;
        this.nomeTurma = nomeTurma;
        this.abreviacaoTurma = abreviacaoTurma;
        this.ciclo = ciclo;
        this.periodo = periodo;
        this.codigoTurma = codigoTurma;
        this.observacoes = observacoes;
    }

    /* Alterarcao*/
    public TurmaVO(
             int idTurma
            ,int idSemestre
            ,int idCurso
            ,String anoSemestre
            ,String curso
            ,String nomeTurma
            ,String abreviacaoTurma
            ,String ciclo
            ,String periodo
            ,String codigoTurma
            ,String observacoes) {
        this.idTurma = idTurma;
        this.idSemestre = idSemestre;
        this.idCurso = idCurso;
        this.anoSemestre = anoSemestre;
        this.curso = curso;
        this.nomeTurma = nomeTurma;
        this.abreviacaoTurma = abreviacaoTurma;
        this.ciclo = ciclo;
        this.periodo = periodo;
        this.codigoTurma = codigoTurma;
        this.observacoes = observacoes;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getAnoSemestre() {
        return anoSemestre;
    }

    public void setAnoSemestre(String anoSemestre) {
        this.anoSemestre = anoSemestre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getAbreviacaoTurma() {
        return abreviacaoTurma;
    }

    public void setAbreviacaoTurma(String abreviacaoTurma) {
        this.abreviacaoTurma = abreviacaoTurma;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

   
}
