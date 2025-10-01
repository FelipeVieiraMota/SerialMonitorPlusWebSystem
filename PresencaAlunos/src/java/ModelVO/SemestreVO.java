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
public class SemestreVO {

    private int idSemestre;
    private String semestre;
    private String observacoes;
    private String codigoSemestre;    

    public SemestreVO(int idSemestre, String semestre, String observacoes, String codigoSemestre) {
        this.idSemestre = idSemestre;
        this.semestre = semestre;
        this.observacoes = observacoes;
        this.codigoSemestre = codigoSemestre;
    }

    public SemestreVO(String semestre, String observacoes) {
        this.semestre = semestre;
        this.observacoes = observacoes;
    }

    public SemestreVO(int idSemestre, String semestre, String observacoes) {
        this.idSemestre = idSemestre;
        this.semestre = semestre;
        this.observacoes = observacoes;
    }        

    public SemestreVO() {
    }

    public String getCodigoSemestre() {
        return codigoSemestre;
    }

    public void setCodigoSemestre(String codigoSemestre) {
        this.codigoSemestre = codigoSemestre;
    }

    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
}
