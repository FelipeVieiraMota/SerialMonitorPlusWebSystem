/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelBO.SemestreBO;
import ModelVO.SemestreVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class SemestreDAO {

    public final String CONSULTAR_TODOS_SEMESTRE
            = " SELECT * FROM ANO_SEMESTRE;";

    public final String CONSULTAR_SEMESTRE_PELO_NOME
            = " SELECT * FROM ANO_SEMESTRE"
            + " WHERE ANO_SEMESTRE = ?;";

    public final String CONSULTAR_SEMESTRE_PELO_ID
            = " SELECT * FROM ANO_SEMESTRE"
            + " WHERE ID_ANO_SEMESTRE = ?;";

    public final String CADASTRAR_SEMESTRE
            = " INSERT INTO ANO_SEMESTRE(ANO_SEMESTRE,OBSERVACOES) "
            + " VALUES(?,?); ";

    public final String ALTERAR_SEMESTRE
            = "UPDATE ANO_SEMESTRE SET ANO_SEMESTRE = ? ,OBSERVACOES = ?"
            + " WHERE ID_ANO_SEMESTRE = ?;";

    public final String CADASTRAR_CODIGO_DO_SEMESTRE
            = " UPDATE ANO_SEMESTRE SET CODIGO_ANO_SEMESTRE = ?"
            + " WHERE ID_ANO_SEMESTRE = ?;";

    public ArrayList<SemestreVO> consultarTodosSemestres() {
        System.out.println("Dentro do Metodo DAO consultarTodosSemestres ...");
        ArrayList<SemestreVO> semestreArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_TODOS_SEMESTRE);
            //ps.setString(1, semestre);
            /*ps.setString(2,"%"+nomeAluno+"%");*/
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Semestre: " + rs.getInt("ID_ANO_SEMESTRE"));
                    System.out.println("Semestre: " + rs.getString("ANO_SEMESTRE"));
                    System.out.println("Observações: " + rs.getString("OBSERVACOES"));
                    System.out.println("CODIGO_ANO_SEMESTRE: " + rs.getString("CODIGO_ANO_SEMESTRE"));
                    System.out.println("*****************************************");
                    SemestreVO semestreVo = new SemestreVO();
                    semestreVo.setIdSemestre(rs.getInt("ID_ANO_SEMESTRE"));
                    semestreVo.setSemestre(rs.getString("ANO_SEMESTRE"));
                    semestreVo.setObservacoes(rs.getString("OBSERVACOES"));
                    semestreVo.setCodigoSemestre(rs.getString("CODIGO_ANO_SEMESTRE"));
                    semestreArray.add(semestreVo);
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
        return semestreArray;
    }

    public ArrayList<SemestreVO> consultarSemestrePeloNome(String semestre) {
        System.out.println("Dentro do Metodo DAO consultarSemestre ...");
        ArrayList<SemestreVO> semestreArray = new ArrayList();
        System.out.println("*** Semestre Digitado = " + semestre + " ***");
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_SEMESTRE_PELO_NOME);
            ps.setString(1, semestre);
            /*ps.setString(2,"%"+nomeAluno+"%");*/
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Semestre: " + rs.getInt("ID_ANO_SEMESTRE"));
                    System.out.println("Semestre: " + rs.getString("ANO_SEMESTRE"));
                    System.out.println("Observações: " + rs.getString("OBSERVACOES"));
                    System.out.println("CODIGO_ANO_SEMESTRE: " + rs.getString("CODIGO_ANO_SEMESTRE"));
                    System.out.println("*****************************************");
                    SemestreVO semestreVo = new SemestreVO();
                    semestreVo.setIdSemestre(rs.getInt("ID_ANO_SEMESTRE"));
                    semestreVo.setSemestre(rs.getString("ANO_SEMESTRE"));
                    semestreVo.setObservacoes(rs.getString("OBSERVACOES"));
                    semestreVo.setCodigoSemestre(rs.getString("CODIGO_ANO_SEMESTRE"));
                    semestreArray.add(semestreVo);
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
        return semestreArray;
    }

    public ArrayList<SemestreVO> consultarSemestrePeloId(int IdSemestre) {
        System.out.println("Dentro do Metodo DAO consultarSemestre ...");
        ArrayList<SemestreVO> semestreArray = new ArrayList();
        System.out.println("*** ID Digitado = " + IdSemestre + " ***");
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_SEMESTRE_PELO_ID);
            ps.setInt(1, IdSemestre);
            /*ps.setString(2,"%"+nomeAluno+"%");*/
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Semestre: " + rs.getInt("ID_ANO_SEMESTRE"));
                    System.out.println("Semestre: " + rs.getString("ANO_SEMESTRE"));
                    System.out.println("Observações: " + rs.getString("OBSERVACOES"));
                    System.out.println("CODIGO_ANO_SEMESTRE: " + rs.getString("CODIGO_ANO_SEMESTRE"));
                    System.out.println("*****************************************");
                    SemestreVO semestreVo = new SemestreVO();
                    semestreVo.setIdSemestre(rs.getInt("ID_ANO_SEMESTRE"));
                    semestreVo.setSemestre(rs.getString("ANO_SEMESTRE"));
                    semestreVo.setObservacoes(rs.getString("OBSERVACOES"));
                    semestreVo.setCodigoSemestre(rs.getString("CODIGO_ANO_SEMESTRE"));
                    semestreArray.add(semestreVo);
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
        return semestreArray;
    }

    public boolean cadastrarSemestre(SemestreVO semestreVO) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_SEMESTRE)) {
                ps.setString(1, semestreVO.getSemestre());
                ps.setString(2, semestreVO.getObservacoes());
                ps.execute();
                ps.close();
            }
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_CODIGO_DO_SEMESTRE)) {
                SemestreBO semestreBO = new SemestreBO();
                int idSemestre = semestreBO.pesquisarPeloNomeDoSemestreRetornarIdDoSemestre(semestreVO.getSemestre());
                String codigoDoSemestre = semestreBO.gerarCodigoDoSemestre(idSemestre);
                if (idSemestre > 0) {
                    ps.setString(1, codigoDoSemestre);
                    ps.setInt(2, idSemestre);
                    ps.execute();
                    ps.close();
                    System.out.println(" =) dentro da classe SemestreDAO");
                    System.out.println(" =) cadastrarSemestre realizado com sucesso!");
                    status = true;
                }
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
            //return status;
        }
        return status;
    }

    public boolean alterarSemestre(SemestreVO semestreVO) {
        boolean status = false;
        //SemestreVO comp = new SemestreVO ();
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(ALTERAR_SEMESTRE)) {
                System.out.println("ID = " + semestreVO.getIdSemestre());
                System.out.println("SEMESTRE = " + semestreVO.getSemestre());
                System.out.println("OBSERVACOES = " + semestreVO.getObservacoes());
                ps.setString(1, semestreVO.getSemestre());
                ps.setString(2, semestreVO.getObservacoes());
                ps.setInt(3, semestreVO.getIdSemestre());
                ps.execute();
                ps.close();
                System.out.println(" =) dentro da classe SemestreDAO");
                System.out.println(" =) alterarSemestre realizado com sucesso!");
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
