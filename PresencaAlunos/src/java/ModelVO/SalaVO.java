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
public class SalaVO {
    private int idSala;
    private String tipoDeSala;
    private String numeroDaSala;
    private String andarDaSala;
    private String codigoDaSala;
    private String nomeSala;
    private String observacoes;

    public SalaVO(int idSala, String tipoDeSala, String numeroDaSala, String andarDaSala, String codigoDaSala, String nomeSala, String observacoes) {
        this.idSala = idSala;
        this.tipoDeSala = tipoDeSala;
        this.numeroDaSala = numeroDaSala;
        this.andarDaSala = andarDaSala;
        this.codigoDaSala = codigoDaSala;
        this.nomeSala = nomeSala;
        this.observacoes = observacoes;
    }

    public SalaVO(String tipoDeSala, String numeroDaSala, String andarDaSala, String codigoDaSala, String nomeSala, String observacoes) {
        this.tipoDeSala = tipoDeSala;
        this.numeroDaSala = numeroDaSala;
        this.andarDaSala = andarDaSala;
        this.codigoDaSala = codigoDaSala;
        this.nomeSala = nomeSala;
        this.observacoes = observacoes;
    }

    public SalaVO() {
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getTipoDeSala() {
        return tipoDeSala;
    }

    public void setTipoDeSala(String tipoDeSala) {
        this.tipoDeSala = tipoDeSala;
    }

    public String getNumeroDaSala() {
        return numeroDaSala;
    }

    public void setNumeroDaSala(String numeroDaSala) {
        this.numeroDaSala = numeroDaSala;
    }

    public String getAndarDaSala() {
        return andarDaSala;
    }

    public void setAndarDaSala(String andarDaSala) {
        this.andarDaSala = andarDaSala;
    }

    public String getCodigoDaSala() {
        return codigoDaSala;
    }

    public void setCodigoDaSala(String codigoDaSala) {
        this.codigoDaSala = codigoDaSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    
}
