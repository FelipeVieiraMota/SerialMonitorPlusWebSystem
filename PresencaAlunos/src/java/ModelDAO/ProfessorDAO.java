/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelBO.ProfessorBO;
import ModelVO.ProfessorVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ProfessorDAO {

    public final String CADASTRAR_OBJETO_PROFESSOR
            = " INSERT INTO PROFESSOR( "
            + " NOME_PROFESSOR "
            + ",IDADE_PROFESSOR "
            + ",DATA_NASCIMENTO_PROFESSOR"
            + ",FORMACAO_PROFISSIONAL_PROFESSOR"
            + ",ESPECIALIZACAO_PROFISSIONAL_PROFESSOR"
            + ",CPF_PROFESSOR"
            + ",RG_PROFESSOR"
            + ",SEXO_PROFESSOR"
            + ",CELULAR_PROFESSOR) "
            + "VALUES(?,?,?,?,?,?,?,?,?);";

    public final String ALTERAR_DADOS_DA_TABELA_PROFESSOR
            = "  UPDATE PROFESSOR SET "
            + "  NOME_PROFESSOR = ? "
            + " ,IDADE_PROFESSOR = ? "
            + " ,DATA_NASCIMENTO_PROFESSOR = ? "
            + " ,FORMACAO_PROFISSIONAL_PROFESSOR = ? "
            + " ,ESPECIALIZACAO_PROFISSIONAL_PROFESSOR = ? "
            + " ,CPF_PROFESSOR = ? "
            + " ,RG_PROFESSOR = ? "
            + " ,SEXO_PROFESSOR = ? "
            + " ,CELULAR_PROFESSOR = ? "
            + "  WHERE ID_PROFESSOR = ?;";

    public final String GERAR_CODIGO_PROFESSOR
            = " UPDATE PROFESSOR SET "
            + " CODIGO_MATRICULA_PROFESSOR = ? "
            + " WHERE ID_PROFESSOR = ?; ";

    public final String PESQUISAR_OBJETO_PROFESSORE_PELO_NOME_OU_CPF
            = " SELECT * FROM PROFESSOR "
            + " WHERE NOME_PROFESSOR = ? OR CPF_PROFESSOR = ?"
            + " ORDER BY NOME_PROFESSOR;";

    public final String PESQUISAR_SOMENTE_NA_TABELA_PROFESSOR_PELO_NOME
            = " SELECT * FROM PROFESSOR "
            + " WHERE NOME_PROFESSOR = ? "
            + " ORDER BY NOME_PROFESSOR; ";

    public final String PESQUISAR_SOMENTE_NA_TABELA_PROFESSOR_PELO_CPF
            = " SELECT * FROM PROFESSOR "
            + " WHERE CPF_PROFESSOR = ? "
            + " ORDER BY CPF_PROFESSOR; ";

    public final String PESQUISAR_TODOS_OS_OBJETOS_PROFESSORES
            = " SELECT * FROM PROFESSOR;";

    public boolean cadastrarObjetoProfessorDao(ProfessorVO vo) {
        System.out.println("*** =) dentro do metodo cadastrarTurma da classe CursoDAO ***");
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_OBJETO_PROFESSOR)) {
                ps.setString(1, vo.getNomeProfessor());
                ps.setInt(2, vo.getIdadeProfessor());
                ps.setString(3, vo.getDataNascimentoProfessor());
                ps.setString(4, vo.getFormacaoProfissionalProfessor());
                ps.setString(5, vo.getEspecializacaoProfissionalProfessor());
                ps.setString(6, vo.getCpfProfessor());
                ps.setString(7, vo.getRgProfessor());
                ps.setString(8, vo.getSexoProfessor());
                ps.setString(9, vo.getCelularProfessor());                
                ps.execute();
                ps.close();
            }
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(GERAR_CODIGO_PROFESSOR)) {
                ProfessorBO bo = new ProfessorBO();
                int idProfessor = bo.pesquisarIdDoProfessorPeloSeuCpf(vo.getCpfProfessor());
                System.out.println("ID PROFESSOR = " + idProfessor);
                if (idProfessor != 0) {
                    String codigoProfessor = bo.gerarCodigoDaMatriculaDoProfessorBo(idProfessor);
                    System.out.println("CODIGO PROFESSOR  = " + codigoProfessor);
                    ps.setString(1, codigoProfessor);
                    ps.setInt(2, idProfessor);
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

    public boolean alterarObjetoProfessorDao(ProfessorVO vo) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(ALTERAR_DADOS_DA_TABELA_PROFESSOR)) {
                System.out.println("ID = " + vo.getIdProfessor());
                System.out.println("PROFESSOR = " + vo.getNomeProfessor());
                System.out.println("CODIGO PROFESSOR = " + vo.getCodigomatriculaProfessor());
                ps.setString(1, vo.getNomeProfessor());
                ps.setInt(2, vo.getIdadeProfessor());
                ps.setString(3, vo.getDataNascimentoProfessor());
                ps.setString(4, vo.getFormacaoProfissionalProfessor());
                ps.setString(5, vo.getEspecializacaoProfissionalProfessor());
                ps.setString(6, vo.getCpfProfessor());
                ps.setString(7, vo.getRgProfessor());
                ps.setString(8, vo.getSexoProfessor());
                ps.setString(9, vo.getCelularProfessor());
                ps.setInt(10, vo.getIdProfessor());
                ps.execute();
                ps.close();
                System.out.println(" =) dentro da classe CursoDAO");
                System.out.println(" =) alterção do curso realizada com sucesso!");
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

    public ArrayList<ProfessorVO> pesquisarObjetoProfessorNatabelaProfessorPeloNomeCpfRetornarObjetoProfesssorCompletoDao(String nomeProfessor, String cpfProfessor) {
        System.out.println("Dentro do Metodo pesquisarObjetoProfessorNatabelaProfessorPeloNomeCpfRetornarObjetoProfesssorCompletoDao ...");
        ArrayList<ProfessorVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_OBJETO_PROFESSORE_PELO_NOME_OU_CPF);
            ps.setString(1, nomeProfessor);
            ps.setString(2, cpfProfessor);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProfessorVO vo = new ProfessorVO();
                    vo.setIdProfessor(rs.getInt("ID_PROFESSOR"));
                    vo.setNomeProfessor(rs.getString("NOME_PROFESSOR"));
                    vo.setIdadeProfessor(rs.getInt("IDADE_PROFESSOR"));
                    vo.setDataNascimentoProfessor(rs.getString("DATA_NASCIMENTO_PROFESSOR"));
                    vo.setFormacaoProfissionalProfessor(rs.getString("FORMACAO_PROFISSIONAL_PROFESSOR"));
                    vo.setEspecializacaoProfissionalProfessor(rs.getString("ESPECIALIZACAO_PROFISSIONAL_PROFESSOR"));
                    vo.setCpfProfessor(rs.getString("CPF_PROFESSOR"));
                    vo.setRgProfessor(rs.getString("RG_PROFESSOR"));
                    vo.setSexoProfessor(rs.getString("SEXO_PROFESSOR"));
                    vo.setCelularProfessor(rs.getString("CELULAR_PROFESSOR"));
                    vo.setCodigomatriculaProfessor(rs.getString("CODIGO_MATRICULA_PROFESSOR"));
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

    public ArrayList<ProfessorVO> pesquisarSomenteNaTabelaProfessorPeloNomeDao(String nomeProfessor) {
        System.out.println("Dentro do pesquisarNaTabelaProfessorPeloNomeDao ...");
        ArrayList<ProfessorVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_SOMENTE_NA_TABELA_PROFESSOR_PELO_NOME);
            ps.setString(1, nomeProfessor);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProfessorVO vo = new ProfessorVO();
                    vo.setIdProfessor(rs.getInt("ID_PROFESSOR"));
                    vo.setNomeProfessor(rs.getString("NOME_PROFESSOR"));
                    vo.setIdadeProfessor(rs.getInt("IDADE_PROFESSOR"));
                    vo.setDataNascimentoProfessor(rs.getString("DATA_NASCIMENTO_PROFESSOR"));
                    vo.setFormacaoProfissionalProfessor(rs.getString("FORMACAO_PROFISSIONAL_PROFESSOR"));
                    vo.setEspecializacaoProfissionalProfessor(rs.getString("ESPECIALIZACAO_PROFISSIONAL_PROFESSOR"));
                    vo.setCpfProfessor(rs.getString("CPF_PROFESSOR"));
                    vo.setRgProfessor(rs.getString("RG_PROFESSOR"));
                    vo.setSexoProfessor(rs.getString("SEXO_PROFESSOR"));
                    vo.setCelularProfessor(rs.getString("CELULAR_PROFESSOR"));
                    vo.setCodigomatriculaProfessor(rs.getString("CODIGO_MATRICULA_PROFESSOR"));
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

    public ArrayList<ProfessorVO> pesquisarSomenteNaTabelaProfessorPeloCpfDao(String cpfProfessor) {
        System.out.println("Dentro do pesquisarNaTabelaProfessorPeloNomeDao...");
        ArrayList<ProfessorVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_SOMENTE_NA_TABELA_PROFESSOR_PELO_CPF);
            ps.setString(1, cpfProfessor);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProfessorVO vo = new ProfessorVO();
                    vo.setIdProfessor(rs.getInt("ID_PROFESSOR"));
                    vo.setNomeProfessor(rs.getString("NOME_PROFESSOR"));
                    vo.setIdadeProfessor(rs.getInt("IDADE_PROFESSOR"));
                    vo.setDataNascimentoProfessor(rs.getString("DATA_NASCIMENTO_PROFESSOR"));
                    vo.setFormacaoProfissionalProfessor(rs.getString("FORMACAO_PROFISSIONAL_PROFESSOR"));
                    vo.setEspecializacaoProfissionalProfessor(rs.getString("ESPECIALIZACAO_PROFISSIONAL_PROFESSOR"));
                    vo.setCpfProfessor(rs.getString("CPF_PROFESSOR"));
                    vo.setRgProfessor(rs.getString("RG_PROFESSOR"));
                    vo.setSexoProfessor(rs.getString("SEXO_PROFESSOR"));
                    vo.setCelularProfessor(rs.getString("CELULAR_PROFESSOR"));
                    vo.setCodigomatriculaProfessor(rs.getString("CODIGO_MATRICULA_PROFESSOR"));
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

    public ArrayList<ProfessorVO> pesquisarTodosOsObjetosProfessoresSemParametroSomenteNaTabelaProfessorRetornarObjetoProfessorCompletoDao() {
        System.out.println("Dentro do Metodo DAO pesquisarTodosOsObjetosProfessoresEmTodosOsRelacionamentosRetornarObjetoProfessorCompletoDao ...");
        ArrayList<ProfessorVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_TODOS_OS_OBJETOS_PROFESSORES);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProfessorVO vo = new ProfessorVO();
                    vo.setIdProfessor(rs.getInt("ID_PROFESSOR"));
                    vo.setNomeProfessor(rs.getString("NOME_PROFESSOR"));
                    vo.setIdadeProfessor(rs.getInt("IDADE_PROFESSOR"));
                    vo.setDataNascimentoProfessor(rs.getString("DATA_NASCIMENTO_PROFESSOR"));
                    vo.setFormacaoProfissionalProfessor(rs.getString("FORMACAO_PROFISSIONAL_PROFESSOR"));
                    vo.setEspecializacaoProfissionalProfessor(rs.getString("ESPECIALIZACAO_PROFISSIONAL_PROFESSOR"));
                    vo.setCpfProfessor(rs.getString("CPF_PROFESSOR"));
                    vo.setRgProfessor(rs.getString("RG_PROFESSOR"));
                    vo.setSexoProfessor(rs.getString("SEXO_PROFESSOR"));
                    vo.setCelularProfessor(rs.getString("CELULAR_PROFESSOR"));
                    vo.setCodigomatriculaProfessor(rs.getString("CODIGO_MATRICULA_PROFESSOR"));
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
