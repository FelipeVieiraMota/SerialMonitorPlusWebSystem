/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelBO.DisciplinaBO;
import ModelVO.DisciplinaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class DisciplinaDAO {

    public final String CONSULTAR_TODAS_AS_DISCIPLINAS
            = " SELECT * FROM DISCIPLINA; ";

    public final String CONSULTAR_DISCIPLINA_PELO_NOME
            = " SELECT * FROM DISCIPLINA WHERE NOME_DISCIPLINA = ?; ";

    public final String CONSULTAR_DISCIPLINA_PELO_ID
            = " SELECT * FROM DISCIPLINA WHERE ID_DISCIPLINA = ?; ";

    public final String CADASTRAR_DISCIPLINA_SEM_O_CODIGO_DA_DISCIPLINA
            = "  INSERT INTO DISCIPLINA( "
            + "  NOME_DISCIPLINA "
            + " ,ABREVIACAO_DISCIPLINA "
            + " ,CARGA_HOARARIA_DISCIPLINA "
            + " ,OBSERVACOES) "
            + "  VALUES(?,?,?,?); ";

    public final String CADASTRAR_CODIGO_DA_DISCIPLNA
            = " UPDATE DISCIPLINA SET CODIGO_DISCIPLINA = ?"
            + " WHERE ID_DISCIPLINA = ?;";

    public final String ALTERAR_DISCIPLINA
            = "  UPDATE DISCIPLINA SET "
            + "  NOME_DISCIPLINA = ?"
            + " ,ABREVIACAO_DISCIPLINA = ? "
            + " ,CARGA_HOARARIA_DISCIPLINA = ? "
            + " ,OBSERVACOES = ? "
            + "  WHERE ID_DISCIPLINA = ?; ";

    public ArrayList<DisciplinaVO> consultarTodasAsDisciplinas() {
        System.out.println("Dentro do Metodo DAO consultarTodasAsDisciplinas ...");
        ArrayList<DisciplinaVO> disciplinaArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_TODAS_AS_DISCIPLINAS);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DisciplinaVO disciplinaVO = new DisciplinaVO();
                    disciplinaVO.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
                    disciplinaVO.setNomeDisciplina(rs.getString("NOME_DISCIPLINA"));
                    disciplinaVO.setAbreviacaoDisciplina(rs.getString("ABREVIACAO_DISCIPLINA"));
                    disciplinaVO.setCodigoDisicplina(rs.getString("CODIGO_DISCIPLINA"));
                    disciplinaVO.setCargaHorariaDisciplina(rs.getString("CARGA_HOARARIA_DISCIPLINA"));
                    disciplinaVO.setObservacoes(rs.getString("OBSERVACOES"));
                    disciplinaArray.add(disciplinaVO);
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
        return disciplinaArray;
    }

    public ArrayList<DisciplinaVO> consultarDisciplinaPeloNome(String nomeDisciplina) {
        System.out.println("Dentro do Metodo DAO consultarDisciplina ...");
        ArrayList<DisciplinaVO> disciplinaArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_DISCIPLINA_PELO_NOME);
            ps.setString(1, nomeDisciplina);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DisciplinaVO disciplinaVO = new DisciplinaVO();
                    disciplinaVO.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
                    disciplinaVO.setNomeDisciplina(rs.getString("NOME_DISCIPLINA"));
                    disciplinaVO.setAbreviacaoDisciplina(rs.getString("ABREVIACAO_DISCIPLINA"));
                    disciplinaVO.setCodigoDisicplina(rs.getString("CODIGO_DISCIPLINA"));
                    disciplinaVO.setCargaHorariaDisciplina(rs.getString("CARGA_HOARARIA_DISCIPLINA"));
                    disciplinaVO.setObservacoes(rs.getString("OBSERVACOES"));
                    disciplinaArray.add(disciplinaVO);
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
        return disciplinaArray;
    }

    public ArrayList<DisciplinaVO> consultarDisciplinaPeloId(int id) {
        System.out.println("Dentro do Metodo DAO consultarDisciplinaPeloId ...");
        ArrayList<DisciplinaVO> disciplinaArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_DISCIPLINA_PELO_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DisciplinaVO disciplinaVO = new DisciplinaVO();
                    disciplinaVO.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
                    disciplinaVO.setNomeDisciplina(rs.getString("NOME_DISCIPLINA"));
                    disciplinaVO.setAbreviacaoDisciplina(rs.getString("ABREVIACAO_DISCIPLINA"));
                    disciplinaVO.setCodigoDisicplina(rs.getString("CODIGO_DISCIPLINA"));
                    disciplinaVO.setCargaHorariaDisciplina(rs.getString("CARGA_HOARARIA_DISCIPLINA"));
                    disciplinaVO.setObservacoes(rs.getString("OBSERVACOES"));
                    disciplinaArray.add(disciplinaVO);
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
        return disciplinaArray;
    }

    public boolean cadastrarDisciplina(DisciplinaVO disciplinaVO) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_DISCIPLINA_SEM_O_CODIGO_DA_DISCIPLINA)) {
                ps.setString(1, disciplinaVO.getNomeDisciplina());
                ps.setString(2, disciplinaVO.getAbreviacaoDisciplina());
                ps.setString(3, disciplinaVO.getCargaHorariaDisciplina());
                ps.setString(4, disciplinaVO.getObservacoes());
                ps.execute();
                ps.close();

            }
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_CODIGO_DA_DISCIPLNA)) {
                DisciplinaBO disciplinaBO = new DisciplinaBO();
                int idDisciplina = disciplinaBO.pesquisarPeloNomeDaDisciplinaRetornarIdDaDisciplina(disciplinaVO.getNomeDisciplina());
                String codigoDaDisciplina = disciplinaBO.gerarCodigoDaDisciplina(idDisciplina);
                if (idDisciplina > 0) {
                    ps.setString(1,codigoDaDisciplina);
                    ps.setInt(2, idDisciplina);
                    ps.execute();
                    ps.close();
                    status = true;
                    System.out.println(" =) dentro da classe DisciplinaDAO");
                    System.out.println(" =) codigo gerado para a disciplina : " + codigoDaDisciplina);
                    System.out.println(" =) cadastro de Disciplina realizado com sucesso!");                    
                }else{
                    System.out.println("id = "+idDisciplina);
                }
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
        }
        return status;
    }

    public boolean alterarDisciplina(DisciplinaVO disciplinaVO) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(ALTERAR_DISCIPLINA)) {
                ps.setString(1, disciplinaVO.getNomeDisciplina());
                ps.setString(2, disciplinaVO.getAbreviacaoDisciplina());
                ps.setString(3, disciplinaVO.getCargaHorariaDisciplina());
                ps.setString(4, disciplinaVO.getObservacoes());
                ps.setInt(5, disciplinaVO.getIdDisciplina());
                ps.execute();
                ps.close();
                System.out.println(" =) dentro da classe DisciplinaDAO");
                System.out.println(" =) alteracao de Disciplina realizada com sucesso!");
                status = true;
                return status;
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
            return status;
        }
    }

}
