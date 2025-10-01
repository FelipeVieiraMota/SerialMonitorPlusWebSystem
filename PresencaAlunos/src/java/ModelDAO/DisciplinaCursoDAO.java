/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelVO.DisciplinaCursoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class DisciplinaCursoDAO {

    public final String CADASTRAR_DISCIPLINA_CURSO
            = " INSERT INTO DISCIPLINA_CURSO( "
            + " ID_CURSO "
            + ",ID_DISCIPLINA "
            + ",DISCIPLINA_CURSO "
            + ",OBSERVACOES) "
            + "VALUES(?,?,?,?); ";

    public final String CONSULTAR_CADASTRAR_DISCIPLINA_CURSO_PELOS_SEUS_DOIS_IDS
            = " SELECT * FROM DISCIPLINA_CURSO DC "
            + " WHERE "
            + " DC.ID_CURSO = ? "
            + " AND "
            + " DC.ID_DISCIPLINA = ?;";

    public final String CONSULTAR_TODOS_AS_DISCIPLINAS_CADASTRADAS_EM_ALGUM_CURSO
            = " SELECT * FROM DISCIPLINA_CURSO DC, DISCIPLINA D, CURSO C "
            + " WHERE "
            + " DC.ID_CURSO = C.ID_CURSO "
            + " AND "
            + " DC.ID_DISCIPLINA = D.ID_DISCIPLINA "
            + " ORDER BY C.NOME_CURSO; ";

    public final String CONSULTAR_TODOS_AS_DISCIPLINAS_VINCULADAS_A_CURSOS_PELO_NOME
            = " SELECT * FROM DISCIPLINA_CURSO DC, DISCIPLINA D, CURSO C "
            + " WHERE "
            + " DC.ID_CURSO = C.ID_CURSO "
            + " AND "
            + " DC.ID_DISCIPLINA = D.ID_DISCIPLINA "
            + " AND  "
            + " DC.DISCIPLINA_CURSO = ?"
            + " ORDER BY C.NOME_CURSO; ";

    public boolean cadastrarDisciplinaCurso(DisciplinaCursoVO disciplinaCursoVO) {
        boolean status = false;
        System.out.println(" =) dentro da classe cadastrarDisciplinaCursoDAO");
        System.out.println("id Curso = " + disciplinaCursoVO.getIdCurso());
        System.out.println("id Disciplina = " + disciplinaCursoVO.getIdDisciplina());
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_DISCIPLINA_CURSO)) {
                ps.setInt(1, disciplinaCursoVO.getIdCurso());
                ps.setInt(2, disciplinaCursoVO.getIdDisciplina());
                ps.setString(3, disciplinaCursoVO.getDisciplinaCurso());
                ps.setString(4, disciplinaCursoVO.getObservacoes());
                ps.execute();
                ps.close();
                status = true;
                System.out.println(" =) dentro da classe cadastrarDisciplinaCursoDAO");
                System.out.println(" =) ID do Curso : " + disciplinaCursoVO.getIdCurso());
                System.out.println(" =) ID da Disciplina : " + disciplinaCursoVO.getIdCurso());
                System.out.println(" =) cadastro de cadastrarDisciplinaCurso realizado com sucesso!");
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
        }
        return status;
    }

    public ArrayList<DisciplinaCursoVO> pesquisarDisciplinaCursoPelosSeusDoisIds(int idCurso, int idDisciplina) {
        System.out.println("Dentro do Metodo DAO consultarDisciplinaCursoPeloId ...");
        System.out.println("id Curso = " + idCurso);
        System.out.println("id Disciplina = " + idDisciplina);
        ArrayList<DisciplinaCursoVO> arrayDisciplinaCurso = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_CADASTRAR_DISCIPLINA_CURSO_PELOS_SEUS_DOIS_IDS);
            ps.setInt(1, idCurso);
            ps.setInt(2, idDisciplina);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DisciplinaCursoVO disciplinaCursoVO = new DisciplinaCursoVO();
                    disciplinaCursoVO.setIdCurso(rs.getInt("ID_CURSO"));
                    disciplinaCursoVO.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
                    disciplinaCursoVO.setDisciplinaCurso(rs.getString("DISCIPLINA_CURSO"));
                    disciplinaCursoVO.setObservacoes(rs.getString("OBSERVACOES"));
                    arrayDisciplinaCurso.add(disciplinaCursoVO);
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
        return arrayDisciplinaCurso;
    }

    public ArrayList<DisciplinaCursoVO> pesquisarDisciplinaCursoPeloNome(String disciplinaCurso) {
        System.out.println("Dentro do Metodo DAO consultarDisciplinaCursoPeloId ...");
        ArrayList<DisciplinaCursoVO> arrayDisciplinaCurso = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_TODOS_AS_DISCIPLINAS_VINCULADAS_A_CURSOS_PELO_NOME);
            ps.setString(1, disciplinaCurso);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DisciplinaCursoVO disciplinaCursoVO = new DisciplinaCursoVO();
                    disciplinaCursoVO.setAbreviacaoDisciplina(rs.getString("ABREVIACAO_DISCIPLINA"));
                    disciplinaCursoVO.setCargaHorariaDisciplina(rs.getString("CARGA_HOARARIA_DISCIPLINA"));
                    disciplinaCursoVO.setCodigoCurso(rs.getString("CODIGO_CURSO"));
                    disciplinaCursoVO.setCodigoDisciplina(rs.getString("CODIGO_DISCIPLINA"));
                    disciplinaCursoVO.setCurso(rs.getString("NOME_CURSO"));
                    disciplinaCursoVO.setDisciplina(rs.getString("NOME_DISCIPLINA"));
                    disciplinaCursoVO.setDisciplinaCurso(rs.getString("DISCIPLINA_CURSO"));
                    disciplinaCursoVO.setIdCurso(rs.getInt("ID_CURSO"));
                    disciplinaCursoVO.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
                    disciplinaCursoVO.setObservacoes(rs.getString("OBSERVACOES"));
                    arrayDisciplinaCurso.add(disciplinaCursoVO);
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
        return arrayDisciplinaCurso;
    }

    public ArrayList<DisciplinaCursoVO> pesquisarTodasAsDisciplinasCadastradasEmAgumCurso() {
        System.out.println("Dentro do Metodo DAO pesquisarTodasAsDisciplinasCadastradasEmAgumCurso ...");
        ArrayList<DisciplinaCursoVO> arrayDisciplinaCurso = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_TODOS_AS_DISCIPLINAS_CADASTRADAS_EM_ALGUM_CURSO);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DisciplinaCursoVO disciplinaCursoVO = new DisciplinaCursoVO();
                    disciplinaCursoVO.setIdCurso(rs.getInt("ID_CURSO"));
                    disciplinaCursoVO.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
                    disciplinaCursoVO.setDisciplinaCurso(rs.getString("DISCIPLINA_CURSO"));
                    disciplinaCursoVO.setObservacoes(rs.getString("OBSERVACOES"));
                    arrayDisciplinaCurso.add(disciplinaCursoVO);
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
        return arrayDisciplinaCurso;
    }
}
