/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelBO.TurmaBO;
import ModelVO.TurmaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class TurmaDAO {

    public final String CADASTRAR_TURMA
            = " INSERT INTO TURMA( "
            + "  ID_CURSO "
            + " ,NOME_TURMA "
            + " ,ABREVIACAO_TURMA "
            + " ,CICLO "
            + " ,PERIODO "
            + " ,OBSERVACOES)"
            + " VALUES(?,?,?,?,?,?)";

    public final String CADASTRAR_TURMA_EM_UM_SEMESTRE_EXISTENTE
            = " INSERT INTO ANO_SEMESTRE_TURMA( "
            + " ID_TURMA "
            + ",ID_ANO_SEMESTRE "
            + ",OBSERVACOES) "
            + " VALUES(?,?,?);";

    public final String GERAR_CODIGO_TURMA
            = " UPDATE TURMA SET "
            + " CODIGO_TURMA = ? "
            + " WHERE ID_TURMA = ?;";

    public final String ALTERAR_DADOS_DA_TABELA_TURMA
            = "  UPDATE TURMA SET "
            + "  ID_CURSO = ?"
            + " ,NOME_TURMA = ? "
            + " ,ABREVIACAO_TURMA = ? "
            + " ,CICLO = ? "
            + " ,PERIODO = ? "
            + " ,OBSERVACOES = ? "
            + " ,CODIGO_TURMA = ? "
            + "  WHERE ID_TURMA = ?";

    public final String PESQUISAR_JOIN_TURMA_ANO_SEMESTRE_CURSO_PELO_NOME_DA_TURMA
            = " SELECT * FROM TURMA T, CURSO C, ANO_SEMESTRE ANS, ANO_SEMESTRE_TURMA ANST "
            + " WHERE "
            + " T.ID_CURSO = C.ID_CURSO AND "
            + " ANS.ID_ANO_SEMESTRE = ANST.ID_ANO_SEMESTRE AND "
            + " T.ID_TURMA = ANST.ID_TURMA AND "
            + " T.NOME_TURMA = ?;";

    public final String PESQUISAR_JOIN_TURMA_CURSO_PELO_NOME_DA_TURMA
            = " SELECT * FROM TURMA T, CURSO C "
            + " WHERE "
            + " T.ID_CURSO = C.ID_CURSO AND "
            + " T.NOME_TURMA = ?;";

    public final String PESQUISAR_JOIN_TURMA_ANO_SEMESTRE_CURSO_SEM_PARAMETROS_DE_ENTRADA
            = " SELECT * FROM TURMA T, CURSO C, ANO_SEMESTRE ANS, ANO_SEMESTRE_TURMA ANST "
            + " WHERE "
            + " T.ID_CURSO = C.ID_CURSO AND "
            + " ANS.ID_ANO_SEMESTRE = ANST.ID_ANO_SEMESTRE AND "
            + " T.ID_TURMA = ANST.ID_TURMA ";

    public final String PESQUISAR_JOIN_TURMA_ANO_SEMESTRE_CURSO_COM_PARAMETROS_DE_ENTRADA_ID_TURMA_ID_CURSO_ID_ANO_SEMESTRE
            = " SELECT * FROM TURMA T, CURSO C, ANO_SEMESTRE ANS, ANO_SEMESTRE_TURMA ANST "
            + " WHERE "
            + " ANST.ID_TURMA = ? "
            + " AND "
            + " C.ID_CURSO = ? "
            + " AND "
            + " ANST.ID_ANO_SEMESTRE = ? ";

        /* T.ID_TURMA */
        /* T.ID_CURSO */
        /* ANS.ID_ANO_SEMESTRE */
    
    public boolean cadastrarObjetoTurmaDao(TurmaVO turmaVO) {
        System.out.println("*** =) dentro do metodo cadastrarTurma da classe CursoDAO ***");
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_TURMA)) {
                ps.setInt(1, turmaVO.getIdCurso());
                ps.setString(2, turmaVO.getNomeTurma());
                ps.setString(3, turmaVO.getAbreviacaoTurma());
                ps.setString(4, turmaVO.getCiclo());
                ps.setString(5, turmaVO.getPeriodo());
                ps.setString(6, turmaVO.getObservacoes());
                ps.execute();
                ps.close();
                System.out.println("turma cadastrada , porem falta coletar o id dessa turma e cadastrar na tabela ano_semestre_turma....");
            }
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(GERAR_CODIGO_TURMA)) {
                System.out.println("NOME TURMA = " + turmaVO.getNomeTurma());
                TurmaBO bo = new TurmaBO();
                int idTurma = bo.pesquisarObjetoTurmaPeloNomeRetornarIdTurmaBo(turmaVO.getNomeTurma());
                if (idTurma != 0) {
                    String codigoTurma = bo.gerarCodigoDaTurmaBo(idTurma);
                    ps.setString(1, codigoTurma);
                    ps.setInt(2, idTurma);
                    ps.execute();
                    ps.close();
                    System.out.println("Codigo da Turma = " + codigoTurma);
                } else {
                    System.out.println("Não foi possivel gerar o codigo da turma...");
                }
            }

            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_TURMA_EM_UM_SEMESTRE_EXISTENTE)) {
                TurmaBO bo = new TurmaBO();
                int idTurma;
                idTurma = bo.pesquisarObjetoTurmaPeloNomeRetornarIdTurmaBo(turmaVO.getNomeTurma());
                System.out.println("NOME TURMA = " + turmaVO.getNomeTurma());
                if (idTurma != 0) {
                    System.out.println("Id da turma = " + idTurma);
                    System.out.println("Id do semestres = " + turmaVO.getIdSemestre());
                    ps.setInt(1, idTurma);
                    ps.setInt(2, turmaVO.getIdSemestre());
                    ps.setString(3, turmaVO.getObservacoes());
                    ps.execute();
                    ps.close();
                    System.out.println("=-) conseguimos!!!!!!!!!!!!!!!!!");
                } else {
                    System.out.println("Id =( " + turmaVO.getIdTurma());
                    System.out.println("Não foi possivel coletar o id da turma, verifique se a turma foi cadastrada para não existir conflitos");
                    return status;
                }
            }
            System.out.println(" =) dentro da classe CursoDAO");
            System.out.println(" =) cadastro de Curso realizado com sucesso!");
            status = true;
            return status;
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
            return status;
        }
    }

    public boolean alterarObjetoTurmaDao(TurmaVO turmaVO) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(ALTERAR_DADOS_DA_TABELA_TURMA)) {
                System.out.println("ID = " + turmaVO.getIdCurso());
                System.out.println("TURMA = " + turmaVO.getNomeTurma());
                System.out.println("OBSERVACOES = " + turmaVO.getObservacoes());
                ps.setInt(1, turmaVO.getIdCurso());
                ps.setString(2, turmaVO.getNomeTurma());
                ps.setString(3, turmaVO.getAbreviacaoTurma());
                ps.setString(4, turmaVO.getCiclo());
                ps.setString(5, turmaVO.getPeriodo());
                ps.setString(6, turmaVO.getObservacoes());
                ps.setString(7, turmaVO.getCodigoTurma());
                ps.setInt(8, turmaVO.getIdTurma());
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

    public ArrayList<TurmaVO> pesquisarObjetoTurmaEmRelacaoAoCursoAnoSemestrePeloNomeRetornarObjetoTurmaCompletoDao(String nomeTurma) {
        System.out.println("Dentro do Metodo DAO pesquisarObjetoTurmaEmRelacaoSomenteAoCursoPeloNomeRetornarObjetoTurmaCompletoDao ...");
        System.out.println("*** Turma Digitada = " + nomeTurma + " ***");
        ArrayList<TurmaVO> turmaArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_JOIN_TURMA_ANO_SEMESTRE_CURSO_PELO_NOME_DA_TURMA);
            ps.setString(1, nomeTurma);//PESQUISAR_JOIN_TURMA_CURSO_PELO_NOME_DA_TURMA
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("Dentro do laço while!!!!");
                    TurmaVO turmaVO = new TurmaVO();
                    turmaVO.setIdTurma(rs.getInt("ID_TURMA"));
                    turmaVO.setIdCurso(rs.getInt("ID_CURSO"));
                    turmaVO.setIdSemestre(rs.getInt("ID_ANO_SEMESTRE"));
                    turmaVO.setNomeTurma(rs.getString("NOME_TURMA"));
                    turmaVO.setCurso(rs.getString("NOME_CURSO"));
                    turmaVO.setAnoSemestre(rs.getString("ANO_SEMESTRE"));
                    turmaVO.setAbreviacaoTurma(rs.getString("ABREVIACAO_TURMA"));
                    turmaVO.setCiclo(rs.getString("CICLO"));
                    turmaVO.setPeriodo(rs.getString("PERIODO"));
                    turmaVO.setCodigoTurma(rs.getString("CODIGO_TURMA"));
                    turmaVO.setObservacoes(rs.getString("OBSERVACOES"));
                    turmaArray.add(turmaVO);
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
        return turmaArray;
    }

    public ArrayList<TurmaVO> pesquisarObjetoTurmaPeloNomeParaCadastroDaTurmaDao(String nomeTurma) {
        System.out.println("Dentro do Metodo DAO pesquisarObjetoTurmaEmRelacaoSomenteAoCursoPeloNomeRetornarObjetoTurmaCompletoDao ...");
        System.out.println("*** Turma Digitada = " + nomeTurma + " ***");
        ArrayList<TurmaVO> turmaArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_JOIN_TURMA_CURSO_PELO_NOME_DA_TURMA);
            ps.setString(1, nomeTurma);//PESQUISAR_JOIN_TURMA_CURSO_PELO_NOME_DA_TURMA
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("Dentro do laço while!!!!");
                    TurmaVO turmaVO = new TurmaVO();
                    turmaVO.setIdTurma(rs.getInt("ID_TURMA"));
                    turmaVO.setIdCurso(rs.getInt("ID_CURSO"));
                    turmaVO.setNomeTurma(rs.getString("NOME_TURMA"));
                    turmaVO.setCurso(rs.getString("NOME_CURSO"));
                    turmaVO.setAbreviacaoTurma(rs.getString("ABREVIACAO_TURMA"));
                    turmaVO.setCiclo(rs.getString("CICLO"));
                    turmaVO.setPeriodo(rs.getString("PERIODO"));
                    turmaVO.setCodigoTurma(rs.getString("CODIGO_TURMA"));
                    turmaVO.setObservacoes(rs.getString("OBSERVACOES"));
                    turmaArray.add(turmaVO);
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
        return turmaArray;
    }

    public ArrayList<TurmaVO> pesquisarObjetoTurmaPeloNomeEmTodosOsRelacionamentosQuePossuiRetornarObjetoTurmaCompletoDao(String nomeTurma) {
        System.out.println("Dentro do Metodo DAO joinTurmaAnoSemestreCurso ...");
        System.out.println("*** Turma Digitada = " + nomeTurma + " ***");
        ArrayList<TurmaVO> turmaArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_JOIN_TURMA_ANO_SEMESTRE_CURSO_PELO_NOME_DA_TURMA);
            ps.setString(1, nomeTurma);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("Dentro do laço while!!!!");
                    TurmaVO turmaVO = new TurmaVO();
                    turmaVO.setIdTurma(rs.getInt("ID_TURMA"));
                    turmaVO.setIdCurso(rs.getInt("ID_CURSO"));
                    turmaVO.setIdSemestre(rs.getInt("ID_ANO_SEMESTRE"));
                    turmaVO.setNomeTurma(rs.getString("NOME_TURMA"));
                    turmaVO.setCurso(rs.getString("NOME_CURSO"));
                    turmaVO.setAnoSemestre(rs.getString("ANO_SEMESTRE"));
                    turmaVO.setAbreviacaoTurma(rs.getString("ABREVIACAO_TURMA"));
                    turmaVO.setCiclo(rs.getString("CICLO"));
                    turmaVO.setPeriodo(rs.getString("PERIODO"));
                    turmaVO.setCodigoTurma(rs.getString("CODIGO_TURMA"));
                    turmaVO.setObservacoes(rs.getString("OBSERVACOES"));
                    turmaArray.add(turmaVO);
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
        return turmaArray;
    }

    public boolean pesquisarObjetoTurmaPeloIdTurmaIdCursoIdSemestreEmTodosOsRelacionamentosQuePossuiRetornarBooleanDao(int idTurma, int idCurso, int IdAnoSemestre) {
        System.out.println("Dentro do Metodo DAO joinTurmaAnoSemestreCurso ...");
        boolean status = false;
        ArrayList<TurmaVO> turmaArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_JOIN_TURMA_ANO_SEMESTRE_CURSO_COM_PARAMETROS_DE_ENTRADA_ID_TURMA_ID_CURSO_ID_ANO_SEMESTRE);
            ps.setInt(1, idTurma);
            ps.setInt(2, idCurso);
            ps.setInt(3, IdAnoSemestre);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("Dentro do laço while!!!!");
                    TurmaVO turmaVO = new TurmaVO();
                    turmaVO.setIdTurma(rs.getInt("ID_TURMA"));
                    turmaVO.setIdCurso(rs.getInt("ID_CURSO"));
                    turmaVO.setIdSemestre(rs.getInt("ID_ANO_SEMESTRE"));
                    turmaVO.setNomeTurma(rs.getString("NOME_TURMA"));
                    turmaVO.setCurso(rs.getString("NOME_CURSO"));
                    turmaVO.setAnoSemestre(rs.getString("ANO_SEMESTRE"));
                    turmaVO.setAbreviacaoTurma(rs.getString("ABREVIACAO_TURMA"));
                    turmaVO.setCiclo(rs.getString("CICLO"));
                    turmaVO.setPeriodo(rs.getString("PERIODO"));
                    turmaVO.setCodigoTurma(rs.getString("CODIGO_TURMA"));
                    turmaVO.setObservacoes(rs.getString("OBSERVACOES"));
                    turmaArray.add(turmaVO);
                }
                ps.close();
                if (!turmaArray.isEmpty()) {
                    status = true;
                    return status;
                }
            } else {
                System.out.println("rs está null");
            }
        } catch (SQLException e) {
            int code = e.getErrorCode();
            String msg = e.getMessage();
            System.out.println("Erro code Nº: " + code + "\n" + "ErrorMSG: " + msg);
        }
        return status;
    }

    public ArrayList<TurmaVO> pesquisarTodosOsObjetosTurmasSemParametrosEmTodosOsRelacionamentosRetornarObjetoTurmaCompletoDao() {
        System.out.println("Dentro do Metodo DAO consultarTodasTurma ...");
        ArrayList<TurmaVO> turmaArray = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_JOIN_TURMA_ANO_SEMESTRE_CURSO_SEM_PARAMETROS_DE_ENTRADA);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    TurmaVO turmaVO = new TurmaVO();
                    turmaVO.setIdTurma(rs.getInt("ID_TURMA"));
                    turmaVO.setIdCurso(rs.getInt("ID_CURSO"));
                    turmaVO.setIdSemestre(rs.getInt("ID_ANO_SEMESTRE"));
                    turmaVO.setNomeTurma(rs.getString("NOME_TURMA"));
                    turmaVO.setCurso(rs.getString("NOME_CURSO"));
                    turmaVO.setAnoSemestre(rs.getString("ANO_SEMESTRE"));
                    turmaVO.setAbreviacaoTurma(rs.getString("ABREVIACAO_TURMA"));
                    turmaVO.setCiclo(rs.getString("CICLO"));
                    turmaVO.setCodigoTurma(rs.getString("CODIGO_TURMA"));
                    turmaVO.setObservacoes(rs.getString("OBSERVACOES"));
                    turmaArray.add(turmaVO);
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
        return turmaArray;
    }
}
