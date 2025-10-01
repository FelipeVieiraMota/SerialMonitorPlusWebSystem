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
public class FrequenciaVO {
   private int idaluno;
   private String sala;
   private String nomeAluno;      
   private boolean status;
   private String prova;
   private String dataDiaDeProva;
   private String horarioDoPonto;
   private String diaDaSemana;

    public FrequenciaVO(int idaluno, String sala, String nomeAluno, boolean status, String prova, String dataDiaDeProva, String horarioDoPonto, String diaDaSemana) {
        this.idaluno = idaluno;
        this.sala = sala;
        this.nomeAluno = nomeAluno;
        this.status = status;
        this.prova = prova;
        this.dataDiaDeProva = dataDiaDeProva;
        this.horarioDoPonto = horarioDoPonto;
        this.diaDaSemana = diaDaSemana;
    }

    public FrequenciaVO(String sala, String nomeAluno, boolean status, String prova, String dataDiaDeProva, String horarioDoPonto, String diaDaSemana) {
        this.sala = sala;
        this.nomeAluno = nomeAluno;
        this.status = status;
        this.prova = prova;
        this.dataDiaDeProva = dataDiaDeProva;
        this.horarioDoPonto = horarioDoPonto;
        this.diaDaSemana = diaDaSemana;
    }

    public FrequenciaVO() {
    }

   
   
   
    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    public String getDataDiaDeProva() {
        return dataDiaDeProva;
    }

    public void setDataDiaDeProva(String dataDiaDeProva) {
        this.dataDiaDeProva = dataDiaDeProva;
    }

    public String getHorarioDoPonto() {
        return horarioDoPonto;
    }

    public void setHorarioDoPonto(String horarioDoPonto) {
        this.horarioDoPonto = horarioDoPonto;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

   
}
