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
public class DisciplinaVO {
    private int idDisciplina;
    private String nomeDisciplina;
    private String abreviacaoDisciplina;
    private String codigoDisicplina;
    private String cargaHorariaDisciplina;
    private String observacoes;

    public DisciplinaVO(String nomeDisciplina, String abreviacaoDisciplina, String cargaHorariaDisciplina, String observacoes) {
        this.nomeDisciplina = nomeDisciplina;
        this.abreviacaoDisciplina = abreviacaoDisciplina;
        this.codigoDisicplina = codigoDisicplina;
        this.cargaHorariaDisciplina = cargaHorariaDisciplina;
        this.observacoes = observacoes;
    }

    public DisciplinaVO(int idDisciplina, String nomeDisciplina, String abreviacaoDisciplina, String cargaHorariaDisciplina, String observacoes) {
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.abreviacaoDisciplina = abreviacaoDisciplina;
        this.cargaHorariaDisciplina = cargaHorariaDisciplina;
        this.observacoes = observacoes;
    }

    public DisciplinaVO() {
    }
                    
    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getAbreviacaoDisciplina() {
        return abreviacaoDisciplina;
    }

    public void setAbreviacaoDisciplina(String abreviacaoDisciplina) {
        this.abreviacaoDisciplina = abreviacaoDisciplina;
    }

    public String getCodigoDisicplina() {
        return codigoDisicplina;
    }

    public void setCodigoDisicplina(String codigoDisicplina) {
        this.codigoDisicplina = codigoDisicplina;
    }

    public String getCargaHorariaDisciplina() {
        return cargaHorariaDisciplina;
    }

    public void setCargaHorariaDisciplina(String cargaHorariaDisciplina) {
        this.cargaHorariaDisciplina = cargaHorariaDisciplina;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
    
}
