/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelBO.CursoBO;
import ModelVO.CursoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class CursoDAO {

    public final String CADASTRAR_CURSO
            = "  INSERT INTO CURSO( "
            + "  NOME_CURSO "
            + " ,TIPO_CURSO "
            + " ,DURACAO "
            + " ,QTD_SEMESTRES "
            + " ,CARGA_HORARIA "            
            + " ,OBSERVACOES) "
            + "  VALUES(?,?,?,?,?,?); ";

    public final String ALTERAR_CURSO
            = "  UPDATE CURSO SET "
            + "  NOME_CURSO = ? "
            + " ,TIPO_CURSO = ? "
            + " ,DURACAO = ? "
            + " ,QTD_SEMESTRES = ? "
            + " ,CARGA_HORARIA = ? "            
            + " ,OBSERVACOES = ? "
            + "  WHERE ID_CURSO = ?; ";

    public final String CADASTRAR_CODIGO_DO_CURSO
            = " UPDATE CURSO SET CODIGO_CURSO = ?"
            + " WHERE ID_CURSO = ?;";

    public final String CONSULTAR_CURSO_PELO_NOME
            = " SELECT * FROM CURSO "
            + " WHERE NOME_CURSO = ?;";

    public final String CONSULTAR_CURSO_PELO_ID
            = " SELECT * FROM CURSO "
            + " WHERE ID_CURSO = ?; ";

    public final String CONSULTAR_TODOS_CURSO
            = " SELECT * FROM CURSO; ";

    public ArrayList<CursoVO> consultarTodosCursos() {
        System.out.println("Dentro do Metodo DAO consultarTodosSemestres ...");
        ArrayList<CursoVO> cursoArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_TODOS_CURSO);
            //ps.setString(1, semestre);
            /*ps.setString(2,"%"+nomeAluno+"%");*/
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Curso: " + rs.getInt("ID_CURSO"));
                    System.out.println("Curso: " + rs.getString("NOME_CURSO"));
                    System.out.println("Codigo Curso: " + rs.getString("CODIGO_CURSO"));
                    System.out.println("Observações: " + rs.getString("OBSERVACOES"));
                    System.out.println("*****************************************");
                    CursoVO cursoVO = new CursoVO();
                    cursoVO.setIdCurso(rs.getInt("ID_CURSO"));
                    cursoVO.setNomeCurso(rs.getString("NOME_CURSO"));
                    cursoVO.setTipoCurso(rs.getString("TIPO_CURSO"));
                    cursoVO.setDuracao(rs.getString("DURACAO"));
                    cursoVO.setQtdSemestres(rs.getString("QTD_SEMESTRES"));
                    cursoVO.setCargaHoraria(rs.getString("CARGA_HORARIA"));
                    cursoVO.setCodigoCurso(rs.getString("CODIGO_CURSO"));
                    cursoVO.setObservacoes(rs.getString("OBSERVACOES"));
                    cursoArray.add(cursoVO);
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
        return cursoArray;
    }

    public ArrayList<CursoVO> consultarCursoPeloId(int id) {
        System.out.println("Dentro do Metodo DAO consultarDisciplinaPeloId ...");
        ArrayList<CursoVO> cursoArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_CURSO_PELO_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CursoVO cursoVO = new CursoVO();
                    cursoVO.setIdCurso(rs.getInt("ID_CURSO"));
                    cursoVO.setNomeCurso(rs.getString("NOME_CURSO"));
                    cursoVO.setTipoCurso(rs.getString("TIPO_CURSO"));
                    cursoVO.setDuracao(rs.getString("DURACAO"));
                    cursoVO.setQtdSemestres(rs.getString("QTD_SEMESTRES"));
                    cursoVO.setCargaHoraria(rs.getString("CARGA_HORARIA"));
                    cursoVO.setCodigoCurso(rs.getString("CODIGO_CURSO"));
                    cursoVO.setObservacoes(rs.getString("OBSERVACOES"));
                    cursoArray.add(cursoVO);
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
        return cursoArray;
    }

    public ArrayList<CursoVO> consultarCursoPeloNome(String curso) {
        System.out.println("Dentro do Metodo DAO consultarCurso ...");
        System.out.println("*** Curso Digitado = " + curso + " ***");
        ArrayList<CursoVO> cursoArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_CURSO_PELO_NOME);
            ps.setString(1, curso);
            /*ps.setString(2,"%"+nomeAluno+"%");*/
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Curso: " + rs.getInt("ID_CURSO"));
                    System.out.println("CURSO: " + rs.getString("NOME_CURSO"));
                    System.out.println("Observações: " + rs.getString("OBSERVACOES"));
                    System.out.println("*****************************************");
                    CursoVO cursoVO = new CursoVO();
                    cursoVO.setIdCurso(rs.getInt("ID_CURSO"));
                    cursoVO.setNomeCurso(rs.getString("NOME_CURSO"));
                    cursoVO.setTipoCurso(rs.getString("TIPO_CURSO"));
                    cursoVO.setDuracao(rs.getString("DURACAO"));
                    cursoVO.setQtdSemestres(rs.getString("QTD_SEMESTRES"));
                    cursoVO.setCargaHoraria(rs.getString("CARGA_HORARIA"));
                    cursoVO.setCodigoCurso(rs.getString("CODIGO_CURSO"));
                    cursoVO.setObservacoes(rs.getString("OBSERVACOES"));
                    cursoArray.add(cursoVO);
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
        return cursoArray;
    }

    public boolean cadastrarCurso(CursoVO cursoVO) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_CURSO)) {
                ps.setString(1, cursoVO.getNomeCurso());
                ps.setString(2, cursoVO.getTipoCurso());
                ps.setString(3, cursoVO.getDuracao());
                ps.setString(4, cursoVO.getQtdSemestres());
                ps.setString(5, cursoVO.getCargaHoraria());
                ps.setString(6, cursoVO.getObservacoes());
                ps.execute();
                ps.close();
            }
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_CODIGO_DO_CURSO)) {
                CursoBO cursoBO = new CursoBO();
                int idCurso = cursoBO.pesquisarPeloNomeDoCursoRetornarIdDoCurso(cursoVO.getNomeCurso());
                String codigoDoCurso = cursoBO.gerarCodigoDoCurso(idCurso);
                if (idCurso > 0) {
                    ps.setString(1, codigoDoCurso);
                    ps.setInt(2, idCurso);
                    ps.execute();
                    ps.close();
                    System.out.println(" =) dentro da classe CursoDAO");
                    System.out.println(" =) codigo gerado para o curso : " + codigoDoCurso);
                    System.out.println(" =) cadastro de Curso realizado com sucesso!");
                    status = true;
                }
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
        }
        return status;
    }

    public boolean alterarCurso(CursoVO cursoVO) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(ALTERAR_CURSO)) {
                System.out.println("ID = " + cursoVO.getIdCurso());
                System.out.println("CURSO = " + cursoVO.getNomeCurso());
                System.out.println("OBSERVACOES = " + cursoVO.getObservacoes());
                ps.setString(1, cursoVO.getNomeCurso());
                ps.setString(2, cursoVO.getTipoCurso());
                ps.setString(3, cursoVO.getDuracao());
                ps.setString(4, cursoVO.getQtdSemestres());
                ps.setString(5, cursoVO.getCargaHoraria());                
                ps.setString(6, cursoVO.getObservacoes());
                ps.setInt(7, cursoVO.getIdCurso());
                ps.execute();
                ps.close();
                System.out.println(" =) dentro da classe CursoDAO");
                System.out.println(" =) alterção do curso realizada com sucesso!");
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
