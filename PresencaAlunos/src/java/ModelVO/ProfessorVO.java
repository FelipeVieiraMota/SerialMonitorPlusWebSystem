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
public class ProfessorVO {
    private int idProfessor;
    private int idDisciplina;
    private String nomeProfessor;
    private int idadeProfessor;
    private String dataNascimentoProfessor;
    private String formacaoProfissionalProfessor;
    private String especializacaoProfissionalProfessor;
    private String cpfProfessor;
    private String rgProfessor;
    private String sexoProfessor;
    private String celularProfessor;
    private String codigomatriculaProfessor;

    public ProfessorVO(int idProfessor, int idDisciplina, String nomeProfessor, int idadeProfessor, String dataNascimentoProfessor, String formacaoProfissionalProfessor, String especializacaoProfissionalProfessor, String cpfProfessor, String rgProfessor, String sexoProfessor, String celularProfessor, String codigomatriculaProfessor) {
        this.idProfessor = idProfessor;
        this.idDisciplina = idDisciplina;
        this.nomeProfessor = nomeProfessor;
        this.idadeProfessor = idadeProfessor;
        this.dataNascimentoProfessor = dataNascimentoProfessor;
        this.formacaoProfissionalProfessor = formacaoProfissionalProfessor;
        this.especializacaoProfissionalProfessor = especializacaoProfissionalProfessor;
        this.cpfProfessor = cpfProfessor;
        this.rgProfessor = rgProfessor;
        this.sexoProfessor = sexoProfessor;
        this.celularProfessor = celularProfessor;
        this.codigomatriculaProfessor = codigomatriculaProfessor;
    }

    public ProfessorVO(String nomeProfessor, int idadeProfessor, String dataNascimentoProfessor, String formacaoProfissionalProfessor, String especializacaoProfissionalProfessor, String cpfProfessor, String rgProfessor, String sexoProfessor, String celularProfessor, String codigomatriculaProfessor) {
        this.nomeProfessor = nomeProfessor;
        this.idadeProfessor = idadeProfessor;
        this.dataNascimentoProfessor = dataNascimentoProfessor;
        this.formacaoProfissionalProfessor = formacaoProfissionalProfessor;
        this.especializacaoProfissionalProfessor = especializacaoProfissionalProfessor;
        this.cpfProfessor = cpfProfessor;
        this.rgProfessor = rgProfessor;
        this.sexoProfessor = sexoProfessor;
        this.celularProfessor = celularProfessor;
        this.codigomatriculaProfessor = codigomatriculaProfessor;
    }

    public ProfessorVO(int idProfessor, String nomeProfessor, int idadeProfessor, String dataNascimentoProfessor, String formacaoProfissionalProfessor, String especializacaoProfissionalProfessor, String cpfProfessor, String rgProfessor, String sexoProfessor, String celularProfessor, String codigomatriculaProfessor) {
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;
        this.idadeProfessor = idadeProfessor;
        this.dataNascimentoProfessor = dataNascimentoProfessor;
        this.formacaoProfissionalProfessor = formacaoProfissionalProfessor;
        this.especializacaoProfissionalProfessor = especializacaoProfissionalProfessor;
        this.cpfProfessor = cpfProfessor;
        this.rgProfessor = rgProfessor;
        this.sexoProfessor = sexoProfessor;
        this.celularProfessor = celularProfessor;
        this.codigomatriculaProfessor = codigomatriculaProfessor;
    }
    
    public ProfessorVO() {/* Here must be void*/}       
    
    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public int getIdadeProfessor() {
        return idadeProfessor;
    }

    public void setIdadeProfessor(int idadeProfessor) {
        this.idadeProfessor = idadeProfessor;
    }

    public String getDataNascimentoProfessor() {
        return dataNascimentoProfessor;
    }

    public void setDataNascimentoProfessor(String dataNascimentoProfessor) {
        this.dataNascimentoProfessor = dataNascimentoProfessor;
    }

    public String getFormacaoProfissionalProfessor() {
        return formacaoProfissionalProfessor;
    }

    public void setFormacaoProfissionalProfessor(String formacaoProfissionalProfessor) {
        this.formacaoProfissionalProfessor = formacaoProfissionalProfessor;
    }

    public String getEspecializacaoProfissionalProfessor() {
        return especializacaoProfissionalProfessor;
    }

    public void setEspecializacaoProfissionalProfessor(String especializacaoProfissionalProfessor) {
        this.especializacaoProfissionalProfessor = especializacaoProfissionalProfessor;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public String getRgProfessor() {
        return rgProfessor;
    }

    public void setRgProfessor(String rgProfessor) {
        this.rgProfessor = rgProfessor;
    }

    public String getSexoProfessor() {
        return sexoProfessor;
    }

    public void setSexoProfessor(String sexoProfessor) {
        this.sexoProfessor = sexoProfessor;
    }

    public String getCelularProfessor() {
        return celularProfessor;
    }

    public void setCelularProfessor(String celularProfessor) {
        this.celularProfessor = celularProfessor;
    }

    public String getCodigomatriculaProfessor() {
        return codigomatriculaProfessor;
    }

    public void setCodigomatriculaProfessor(String codigomatriculaProfessor) {
        this.codigomatriculaProfessor = codigomatriculaProfessor;
    }
    
}
