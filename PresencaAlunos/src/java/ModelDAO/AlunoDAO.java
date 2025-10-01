/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelBO.AlunoBO;
import ModelVO.AlunoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class AlunoDAO {

    public final String CADASTRAR_OBJETO_ALUNO
            = " INSERT INTO ALUNO( "
            + " NOME_ALUNO "
            + ",NOME_MAE_ALUNO "
            + ",NOME_PAI_ALUNO "
            + ",CPF_ALUNO "
            + ",SEXO_ALUNO "
            + ",IDADE_ALUNO "
            + ",DATA_NASCIMENTO_ALUNO "
            + ",EMAIL_ALUNO "
            + ",CELULAR_ALUNO "
            + ",RG_ALUNO"
            + ",CODIGO_CARTAO_RFID "
            + ",CODIGO_MATRICULA_ALUNO)"
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

    public final String ALTERAR_DADOS_DA_TABELA_ALUNO
            = " UPDATE ALUNO SET "
            + " NOME_ALUNO = ? "
            + ",NOME_MAE_ALUNO = ? "
            + ",NOME_PAI_ALUNO = ? "
            + ",CPF_ALUNO = ? "
            + ",SEXO_ALUNO = ? "
            + ",IDADE_ALUNO = ? "
            + ",DATA_NASCIMENTO_ALUNO = ? "
            + ",EMAIL_ALUNO = ? "
            + ",CELULAR_ALUNO = ? "
            + ",RG_ALUNO = ? "
            + ",CODIGO_CARTAO_RFID = ? "
            + ",CODIGO_MATRICULA_ALUNO = ? "
            + " WHERE ID_ALUNO = ?;";

    public final String GERAR_CODIGO_ALUNO
            = " UPDATE ALUNO SET "
            + " CODIGO_MATRICULA_ALUNO = ? "
            + " WHERE ID_ALUNO = ?; ";

    public final String PESQUISAR_OBJETO_ALUNO_PELO_NOME_OU_CPF
            = " SELECT * FROM ALUNO "
            + " WHERE NOME_ALUNO = ? OR CPF_ALUNO = ?"
            + " ORDER BY NOME_ALUNO;";

    public final String PESQUISAR_SOMENTE_NA_TABELA_ALUNO_PELO_NOME
            = " SELECT * FROM ALUNO "
            + " WHERE NOME_ALUNO = ? "
            + " ORDER BY NOME_ALUNO; ";

    public final String PESQUISAR_SOMENTE_NA_TABELA_ALUNO_PELO_CPF
            = " SELECT * FROM ALUNO "
            + " WHERE CPF_ALUNO = ? "
            + " ORDER BY CPF_ALUNO; ";

    public final String PESQUISAR_TODOS_OS_OBJETOS_ALUNOS
            = " SELECT * FROM ALUNO;";

    public boolean cadastrarObjetoAlunoDao(AlunoVO vo) {
        System.out.println("*** =) dentro do metodo cadastrarTurma da classe CursoDAO ***");
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_OBJETO_ALUNO)) {
                ps.setString(1, vo.getNomeAluno());
                ps.setString(2, vo.getNomeMaeAluno());
                ps.setString(3, vo.getNomePaiAluno());
                ps.setString(4, vo.getCpfAluno());
                ps.setString(5, vo.getSexoAluno());
                ps.setString(6, vo.getIdadeAluno());
                ps.setString(7, vo.getDataNascimentoAluno());
                ps.setString(8, vo.getEmailAluno());
                ps.setString(9, vo.getCelularAluno());
                ps.setString(10, vo.getRgAluno());
                ps.setString(11, vo.getCodigoCartaoRfidAluno());
                ps.setString(12, vo.getCodigoMatriculaAluno());
                ps.execute();
                ps.close();
            }
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(GERAR_CODIGO_ALUNO)) {
                AlunoBO bo = new AlunoBO();
                int idAluno = bo.pesquisarIdDoAlunoPeloSeuCpf(vo.getCpfAluno());
                System.out.println("ID ALUNO = " + idAluno);
                if (idAluno != 0) {
                    String codigoAluno = bo.gerarCodigoDaMatriculaDoAlunoBo(idAluno);
                    System.out.println("CODIGO ALUNO  = " + codigoAluno);
                    ps.setString(1, codigoAluno);
                    ps.setInt(2, idAluno);
                    ps.execute();
                    ps.close();
                    status = true;
                }
                return status;
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
            return status;
        }
    }

    public boolean alterarObjetoAlunoDao(AlunoVO vo) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(ALTERAR_DADOS_DA_TABELA_ALUNO)) {
                System.out.println("ID = " + vo.getIdAluno());
                System.out.println("ALUNO = " + vo.getNomeAluno());
                System.out.println("CODIGO ALUNO = " + vo.getCodigoMatriculaAluno());
                ps.setString(1, vo.getNomeAluno());
                ps.setString(2, vo.getNomeMaeAluno());
                ps.setString(3, vo.getNomePaiAluno());
                ps.setString(4, vo.getCpfAluno());
                ps.setString(5, vo.getSexoAluno());
                ps.setString(6, vo.getIdadeAluno());
                ps.setString(7, vo.getDataNascimentoAluno());
                ps.setString(8, vo.getEmailAluno());
                ps.setString(9, vo.getCelularAluno());
                ps.setString(10, vo.getRgAluno());
                ps.setString(11, vo.getCodigoCartaoRfidAluno());
                ps.setString(12, vo.getCodigoMatriculaAluno());
                ps.setInt(13, vo.getIdAluno());
                ps.execute();
                ps.close();
                System.out.println(" =) dentro de alterarObjetoAlunoDao");
                System.out.println(" =) alterção do aluno realizada com sucesso!");
                status = true;
                return status;
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro ao alterar os Dados da turma");
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
            return status;
        }
    }

    public ArrayList<AlunoVO> pesquisarObjetoAlunoNatabelaAlunoPeloNomeCpfRetornarObjetoAlunoCompletoDao(String nomeAluno, String cpfAluno) {
        System.out.println("Dentro do Metodo pesquisarObjetoAlunoNatabelaAlunoPeloNomeCpfRetornarObjetoProfesssorCompletoDao ...");
        ArrayList<AlunoVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_OBJETO_ALUNO_PELO_NOME_OU_CPF);
            ps.setString(1, nomeAluno);
            ps.setString(2, cpfAluno);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AlunoVO vo = new AlunoVO();
                    vo.setIdAluno(rs.getInt("ID_ALUNO"));
                    vo.setNomeAluno(rs.getString("NOME_ALUNO"));
                    vo.setNomeMaeAluno(rs.getString("NOME_MAE_ALUNO"));
                    vo.setNomePaiAluno(rs.getString("NOME_PAI_ALUNO"));
                    vo.setCpfAluno(rs.getString("CPF_ALUNO"));
                    vo.setSexoAluno(rs.getString("SEXO_ALUNO"));
                    vo.setIdadeAluno(rs.getString("IDADE_ALUNO"));
                    vo.setDataNascimentoAluno(rs.getString("DATA_NASCIMENTO_ALUNO"));
                    vo.setEmailAluno(rs.getString("EMAIL_ALUNO"));
                    vo.setCelularAluno(rs.getString("CELULAR_ALUNO"));
                    vo.setRgAluno(rs.getString("RG_ALUNO"));
                    vo.setCodigoCartaoRfidAluno(rs.getString("CODIGO_CARTAO_RFID"));
                    vo.setCodigoMatriculaAluno(rs.getString("CODIGO_MATRICULA_ALUNO"));
                    array.add(vo);
                }
                ps.close();
            } else {
                System.out.println("rs está null");
            }
        } catch (SQLException e) {
            int code = e.getErrorCode();
            String msg = e.getMessage();
            System.out.println("Erro code Nº: " + code + "/n" + "ErrorMSG: " + msg);
        }
        return array;
    }

    public ArrayList<AlunoVO> pesquisarSomenteNaTabelaAlunoPeloNomeDao(String nomeAluno) {
        System.out.println("Dentro do pesquisarSomenteNaTabelaAlunoPeloNomeDao ...");
        ArrayList<AlunoVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_SOMENTE_NA_TABELA_ALUNO_PELO_NOME);
            ps.setString(1, nomeAluno);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AlunoVO vo = new AlunoVO();
                    vo.setIdAluno(rs.getInt("ID_ALUNO"));
                    vo.setNomeAluno(rs.getString("NOME_ALUNO"));
                    vo.setNomeMaeAluno(rs.getString("NOME_MAE_ALUNO"));
                    vo.setNomePaiAluno(rs.getString("NOME_PAI_ALUNO"));
                    vo.setCpfAluno(rs.getString("CPF_ALUNO"));
                    vo.setSexoAluno(rs.getString("SEXO_ALUNO"));
                    vo.setIdadeAluno(rs.getString("IDADE_ALUNO"));
                    vo.setDataNascimentoAluno(rs.getString("DATA_NASCIMENTO_ALUNO"));
                    vo.setEmailAluno(rs.getString("EMAIL_ALUNO"));
                    vo.setCelularAluno(rs.getString("CELULAR_ALUNO"));
                    vo.setRgAluno(rs.getString("RG_ALUNO"));
                    vo.setCodigoCartaoRfidAluno(rs.getString("CODIGO_CARTAO_RFID"));
                    vo.setCodigoMatriculaAluno(rs.getString("CODIGO_MATRICULA_ALUNO"));
                    array.add(vo);
                }
                ps.close();
            } else {
                System.out.println("rs está null");
            }
        } catch (SQLException e) {
            int code = e.getErrorCode();
            String msg = e.getMessage();
            System.out.println("Erro code Nº: " + code + "\n" + "ErrorMSG: " + msg);
        }
        return array;
    }

    public ArrayList<AlunoVO> pesquisarSomenteNaTabelaAlunoPeloCpfDao(String cpfAluno) {
        System.out.println("Dentro do pesquisarSomenteNaTabelaAlunoPeloCpfDao...");
        ArrayList<AlunoVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_SOMENTE_NA_TABELA_ALUNO_PELO_CPF);
            ps.setString(1, cpfAluno);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AlunoVO vo = new AlunoVO();
                    vo.setIdAluno(rs.getInt("ID_ALUNO"));
                    vo.setNomeAluno(rs.getString("NOME_ALUNO"));
                    vo.setNomeMaeAluno(rs.getString("NOME_MAE_ALUNO"));
                    vo.setNomePaiAluno(rs.getString("NOME_PAI_ALUNO"));
                    vo.setCpfAluno(rs.getString("CPF_ALUNO"));
                    vo.setSexoAluno(rs.getString("SEXO_ALUNO"));
                    vo.setIdadeAluno(rs.getString("IDADE_ALUNO"));
                    vo.setDataNascimentoAluno(rs.getString("DATA_NASCIMENTO_ALUNO"));
                    vo.setEmailAluno(rs.getString("EMAIL_ALUNO"));
                    vo.setCelularAluno(rs.getString("CELULAR_ALUNO"));
                    vo.setRgAluno(rs.getString("RG_ALUNO"));
                    vo.setCodigoCartaoRfidAluno(rs.getString("CODIGO_CARTAO_RFID"));
                    vo.setCodigoMatriculaAluno(rs.getString("CODIGO_MATRICULA_ALUNO"));
                    array.add(vo);
                }
                ps.close();
            } else {
                System.out.println("rs está null");
            }
        } catch (SQLException e) {
            int code = e.getErrorCode();
            String msg = e.getMessage();
            System.out.println("Erro code Nº: " + code + "\n" + "ErrorMSG: " + msg);
        }
        return array;
    }

    public ArrayList<AlunoVO> pesquisarTodosOsObjetosAlunosSemParametroSomenteNaTabelaAlunoRetornarObjetoAlunoCompletoDao() {
        System.out.println("Dentro do Metodo DAO pesquisarTodosOsObjetosAlunosSemParametroSomenteNaTabelaAlunoRetornarObjetoAlunoCompletoDao ...");
        ArrayList<AlunoVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_TODOS_OS_OBJETOS_ALUNOS);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AlunoVO vo = new AlunoVO();
                    vo.setIdAluno(rs.getInt("ID_ALUNO"));
                    vo.setNomeAluno(rs.getString("NOME_ALUNO"));
                    vo.setNomeMaeAluno(rs.getString("NOME_MAE_ALUNO"));
                    vo.setNomePaiAluno(rs.getString("NOME_PAI_ALUNO"));
                    vo.setCpfAluno(rs.getString("CPF_ALUNO"));
                    vo.setSexoAluno(rs.getString("SEXO_ALUNO"));
                    vo.setIdadeAluno(rs.getString("IDADE_ALUNO"));
                    vo.setDataNascimentoAluno(rs.getString("DATA_NASCIMENTO_ALUNO"));
                    vo.setEmailAluno(rs.getString("EMAIL_ALUNO"));
                    vo.setCelularAluno(rs.getString("CELULAR_ALUNO"));
                    vo.setRgAluno(rs.getString("RG_ALUNO"));
                    vo.setCodigoCartaoRfidAluno(rs.getString("CODIGO_CARTAO_RFID"));
                    vo.setCodigoMatriculaAluno(rs.getString("CODIGO_MATRICULA_ALUNO"));
                    array.add(vo);
                }
                ps.close();
            } else {
                System.out.println("rs está null");
            }
        } catch (SQLException e) {
            int code = e.getErrorCode();
            String msg = e.getMessage();
            System.out.println("Erro code Nº: " + code + "\n" + "ErrorMSG: " + msg);
        }
        return array;
    }
}
