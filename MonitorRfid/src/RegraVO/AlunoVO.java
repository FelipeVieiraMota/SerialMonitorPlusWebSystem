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
public class AlunoVO {

    private int idAluno;
    private int idTurma;
    private int idCurso;
    private String nomeCurso;
    private String abreviacaoTurma;
    private String nomeAluno;
    private String nomeMaeAluno;
    private String nomePaiAluno;
    private String cpfAluno;
    private String sexoAluno;
    private String idadeAluno;
    private String dataNascimentoAluno;
    private String emailAluno;
    private String celularAluno;
    private String rgAluno;
    private String codigoCartaoRfidAluno;
    private String codigoMatriculaAluno;

    public AlunoVO() {/*Empty*/}

    public AlunoVO(int idAluno, int idTurma, int idCurso, String nomeCurso, String abreviacaoTurma, String nomeAluno, String nomeMaeAluno, String nomePaiAluno, String cpfAluno, String sexoAluno, String idadeAluno, String dataNascimentoAluno, String emailAluno, String celularAluno, String rgAluno, String codigoCartaoRfidAluno) {
        this.idAluno = idAluno;
        this.idTurma = idTurma;
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.abreviacaoTurma = abreviacaoTurma;
        this.nomeAluno = nomeAluno;
        this.nomeMaeAluno = nomeMaeAluno;
        this.nomePaiAluno = nomePaiAluno;
        this.cpfAluno = cpfAluno;
        this.sexoAluno = sexoAluno;
        this.idadeAluno = idadeAluno;
        this.dataNascimentoAluno = dataNascimentoAluno;
        this.emailAluno = emailAluno;
        this.celularAluno = celularAluno;
        this.rgAluno = rgAluno;
        this.codigoCartaoRfidAluno = codigoCartaoRfidAluno;
    }

    public AlunoVO(int idTurma, int idCurso, String nomeCurso, String abreviacaoTurma, String nomeAluno, String nomeMaeAluno, String nomePaiAluno, String cpfAluno, String sexoAluno, String idadeAluno, String dataNascimentoAluno, String emailAluno, String celularAluno, String rgAluno, String codigoCartaoRfidAluno) {
        this.idTurma = idTurma;
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.abreviacaoTurma = abreviacaoTurma;
        this.nomeAluno = nomeAluno;
        this.nomeMaeAluno = nomeMaeAluno;
        this.nomePaiAluno = nomePaiAluno;
        this.cpfAluno = cpfAluno;
        this.sexoAluno = sexoAluno;
        this.idadeAluno = idadeAluno;
        this.dataNascimentoAluno = dataNascimentoAluno;
        this.emailAluno = emailAluno;
        this.celularAluno = celularAluno;
        this.rgAluno = rgAluno;
        this.codigoCartaoRfidAluno = codigoCartaoRfidAluno;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
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

    public String getAbreviacaoTurma() {
        return abreviacaoTurma;
    }

    public void setAbreviacaoTurma(String abreviacaoTurma) {
        this.abreviacaoTurma = abreviacaoTurma;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeMaeAluno() {
        return nomeMaeAluno;
    }

    public void setNomeMaeAluno(String nomeMaeAluno) {
        this.nomeMaeAluno = nomeMaeAluno;
    }

    public String getNomePaiAluno() {
        return nomePaiAluno;
    }

    public void setNomePaiAluno(String nomePaiAluno) {
        this.nomePaiAluno = nomePaiAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public String getSexoAluno() {
        return sexoAluno;
    }

    public void setSexoAluno(String sexoAluno) {
        this.sexoAluno = sexoAluno;
    }

    public String getIdadeAluno() {
        return idadeAluno;
    }

    public void setIdadeAluno(String idadeAluno) {
        this.idadeAluno = idadeAluno;
    }

    public String getDataNascimentoAluno() {
        return dataNascimentoAluno;
    }

    public void setDataNascimentoAluno(String dataNascimentoAluno) {
        this.dataNascimentoAluno = dataNascimentoAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public String getCelularAluno() {
        return celularAluno;
    }

    public void setCelularAluno(String celularAluno) {
        this.celularAluno = celularAluno;
    }

    public String getRgAluno() {
        return rgAluno;
    }

    public void setRgAluno(String rgAluno) {
        this.rgAluno = rgAluno;
    }

    public String getCodigoCartaoRfidAluno() {
        return codigoCartaoRfidAluno;
    }

    public void setCodigoCartaoRfidAluno(String codigoCartaoRfidAluno) {
        this.codigoCartaoRfidAluno = codigoCartaoRfidAluno;
    }

    public String getCodigoMatriculaAluno() {
        return codigoMatriculaAluno;
    }

    public void setCodigoMatriculaAluno(String codigoMatriculaAluno) {
        this.codigoMatriculaAluno = codigoMatriculaAluno;
    }    
}
