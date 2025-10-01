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
public class DiaDeProvaVO {

    private int idDiaDeProva;
    private int idTurma;
    private int idDisciplina;
    private int idProfessor;
    private int IdSala;
    private String dataDaProva;
    private String horarioInicialDaProva;
    private String horarioFinalDaProva;
    private String turma;
    private String disciplina;
    private String professor;
    private String sala;
    private String prova;
    private String diaDaSemana;
    private String codigoDiaDeProva;
    private String observacoes;

    public DiaDeProvaVO() {
    }

    public DiaDeProvaVO(int idTurma, int idDisciplina, int idProfessor, int IdSala, String dataDaProva, String horarioInicialDaProva, String horarioFinalDaProva, String turma, String disciplina, String professor, String sala, String prova, String diaDaSemana, String codigoDiaDeProva, String observacoes) {
        this.idTurma = idTurma;
        this.idDisciplina = idDisciplina;
        this.idProfessor = idProfessor;
        this.IdSala = IdSala;
        this.dataDaProva = dataDaProva;
        this.horarioInicialDaProva = horarioInicialDaProva;
        this.horarioFinalDaProva = horarioFinalDaProva;
        this.turma = turma;
        this.disciplina = disciplina;
        this.professor = professor;
        this.sala = sala;
        this.prova = prova;
        this.diaDaSemana = diaDaSemana;
        this.codigoDiaDeProva = codigoDiaDeProva;
        this.observacoes = observacoes;
    }

    public DiaDeProvaVO(int idDiaDeProva, int idTurma, int idDisciplina, int idProfessor, int IdSala, String dataDaProva, String horarioInicialDaProva, String horarioFinalDaProva, String turma, String disciplina, String professor, String sala, String prova, String diaDaSemana, String codigoDiaDeProva, String observacoes) {
        this.idDiaDeProva = idDiaDeProva;
        this.idTurma = idTurma;
        this.idDisciplina = idDisciplina;
        this.idProfessor = idProfessor;
        this.IdSala = IdSala;
        this.dataDaProva = dataDaProva;
        this.horarioInicialDaProva = horarioInicialDaProva;
        this.horarioFinalDaProva = horarioFinalDaProva;
        this.turma = turma;
        this.disciplina = disciplina;
        this.professor = professor;
        this.sala = sala;
        this.prova = prova;
        this.diaDaSemana = diaDaSemana;
        this.codigoDiaDeProva = codigoDiaDeProva;
        this.observacoes = observacoes;
    }

    public int getIdDiaDeProva() {
        return idDiaDeProva;
    }

    public void setIdDiaDeProva(int idDiaDeProva) {
        this.idDiaDeProva = idDiaDeProva;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
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

    public int getIdSala() {
        return IdSala;
    }

    public void setIdSala(int IdSala) {
        this.IdSala = IdSala;
    }

    public String getDataDaProva() {
        return dataDaProva;
    }

    public void setDataDaProva(String dataDaProva) {
        this.dataDaProva = dataDaProva;
    }

    public String getHorarioInicialDaProva() {
        return horarioInicialDaProva;
    }

    public void setHorarioInicialDaProva(String horarioInicialDaProva) {
        this.horarioInicialDaProva = horarioInicialDaProva;
    }

    public String getHorarioFinalDaProva() {
        return horarioFinalDaProva;
    }

    public void setHorarioFinalDaProva(String horarioFinalDaProva) {
        this.horarioFinalDaProva = horarioFinalDaProva;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getCodigoDiaDeProva() {
        return codigoDiaDeProva;
    }

    public void setCodigoDiaDeProva(String codigoDiaDeProva) {
        this.codigoDiaDeProva = codigoDiaDeProva;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    
}
