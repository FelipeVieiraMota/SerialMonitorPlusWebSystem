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
public class DisciplinaCursoVO {
    private int idDisciplina;
    private int idCurso;
    private String disciplinaCurso;
    private String observacoes;
    private String abreviacaoDisciplina;
    private String cargaHorariaDisciplina;
    private String disciplina;
    private String curso;
    private String codigoDisciplina;
    private String codigoCurso;

    public DisciplinaCursoVO(int idDisciplina, int idCurso, String disciplinaCurso, String observacoes) {
        this.idDisciplina = idDisciplina;
        this.idCurso = idCurso;
        this.disciplinaCurso = disciplinaCurso;
        this.observacoes = observacoes;
    }

    public DisciplinaCursoVO(int idDisciplina, int idCurso, String disciplinaCurso, String observacoes, String abreviacaoDisciplina, String cargaHorariaDisciplina, String disciplina, String curso, String codigoDisciplina, String codigoCurso) {
        this.idDisciplina = idDisciplina;
        this.idCurso = idCurso;
        this.disciplinaCurso = disciplinaCurso;
        this.observacoes = observacoes;
        this.abreviacaoDisciplina = abreviacaoDisciplina;
        this.cargaHorariaDisciplina = cargaHorariaDisciplina;
        this.disciplina = disciplina;
        this.curso = curso;
        this.codigoDisciplina = codigoDisciplina;
        this.codigoCurso = codigoCurso;
    }

    
    
    
    public DisciplinaCursoVO() {
    }

        
    
    public String getDisciplinaCurso() {
        return disciplinaCurso;
    }

    public void setDisciplinaCurso(String disciplinaCurso) {
        this.disciplinaCurso = disciplinaCurso;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getAbreviacaoDisciplina() {
        return abreviacaoDisciplina;
    }

    public void setAbreviacaoDisciplina(String abreviacaoDisciplina) {
        this.abreviacaoDisciplina = abreviacaoDisciplina;
    }

    public String getCargaHorariaDisciplina() {
        return cargaHorariaDisciplina;
    }

    public void setCargaHorariaDisciplina(String cargaHorariaDisciplina) {
        this.cargaHorariaDisciplina = cargaHorariaDisciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

           
}
