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
public class FrequenciaAlunoVO {
    private int idAluno;
    private int idDiaDeprova;
    private boolean status;
    private String nomeAluno;
    private String prova;
    private String sala;
    private String dataDiaDeProva;
    private String horarioDoPonto;
    private String diaDaSemana;    

    public FrequenciaAlunoVO(int idAluno, int idDiaDeprova, boolean status, String nomeAluno,String prova, String sala, String dataDiaDeProva, String horarioDoPonto, String diaDaSemana) {
        this.idAluno = idAluno;
        this.idDiaDeprova = idDiaDeprova;
        this.status = status;
        this.nomeAluno = nomeAluno;
        this.prova = prova;
        this.sala = sala;
        this.dataDiaDeProva = dataDiaDeProva;
        this.horarioDoPonto = horarioDoPonto;
        this.diaDaSemana = diaDaSemana;        
    }

    public FrequenciaAlunoVO(int idDiaDeprova, boolean status, String nomeAluno,String prova, String sala, String dataDiaDeProva, String horarioDoPonto, String diaDaSemana) {
        this.idDiaDeprova = idDiaDeprova;
        this.status = status;
        this.nomeAluno = nomeAluno;
        this.prova = prova;
        this.sala = sala;
        this.dataDiaDeProva = dataDiaDeProva;
        this.horarioDoPonto = horarioDoPonto;
        this.diaDaSemana = diaDaSemana;        
    }

    public FrequenciaAlunoVO(boolean status, String nomeAluno,String prova, String sala, String dataDiaDeProva, String horarioDoPonto, String diaDaSemana) {
        this.status = status;
        this.nomeAluno = nomeAluno;
        this.prova = prova;
        this.sala = sala;
        this.dataDiaDeProva = dataDiaDeProva;
        this.horarioDoPonto = horarioDoPonto;
        this.diaDaSemana = diaDaSemana;        
    }

    public FrequenciaAlunoVO() {
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdDiaDeprova() {
        return idDiaDeprova;
    }

    public void setIdDiaDeprova(int idDiaDeprova) {
        this.idDiaDeprova = idDiaDeprova;
    }

    public boolean getStatus() {
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

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
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

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    
}
