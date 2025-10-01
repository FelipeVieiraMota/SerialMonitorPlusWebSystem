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
public class CursoVO {
    private int idCurso;
    private String nomeCurso;
    private String tipoCurso;
    private String duracao;    
    private String qtdSemestres;
    private String cargaHoraria;
    private String codigoCurso;
    private String observacoes;
    
    public CursoVO() {
    }

    public CursoVO(int idCurso, String nomeCurso, String tipoCurso, String duracao, String qtdSemestres, String cargaHoraria, String observacoes) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.tipoCurso = tipoCurso;
        this.duracao = duracao;
        this.qtdSemestres = qtdSemestres;
        this.cargaHoraria = cargaHoraria;
        this.observacoes = observacoes;
    }

    public CursoVO(String nomeCurso, String tipoCurso, String duracao, String qtdSemestres, String cargaHoraria, String codigoCurso, String observacoes) {
        this.nomeCurso = nomeCurso;
        this.tipoCurso = tipoCurso;
        this.duracao = duracao;
        this.qtdSemestres = qtdSemestres;
        this.cargaHoraria = cargaHoraria;
        this.codigoCurso = codigoCurso;
        this.observacoes = observacoes;
    }

    public CursoVO(String nomeCurso, String tipoCurso, String duracao, String qtdSemestres, String cargaHoraria, String observacoes) {
        this.nomeCurso = nomeCurso;
        this.tipoCurso = tipoCurso;
        this.duracao = duracao;
        this.qtdSemestres = qtdSemestres;
        this.cargaHoraria = cargaHoraria;
        this.observacoes = observacoes;
    }
    
    
    

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getQtdSemestres() {
        return qtdSemestres;
    }

    public void setQtdSemestres(String qtdSemestres) {
        this.qtdSemestres = qtdSemestres;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }                
}
