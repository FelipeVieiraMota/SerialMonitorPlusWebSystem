/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelBO.DiaDeProvaBO;
import ModelVO.DiaDeProvaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class DiaDeProvaDAO {

    public final String VERIFICAR_SE_ALUNO_JA_BATEU_PONTO
            = " SELECT * FROM FREQUENCIA_DO_ALUNO F, ALUNO A, DIA_DE_PROVA D"
            + " WHERE "
            + " F.ID_ALUNO = A.ID_ALUNO AND "
            + " F.ID_DIA_DE_PROVA = D.ID_DIA_DE_PROVA AND "
            + " A.CODIGO_CARTAO_RFID = ?;";

    public final String PESQUISAR_TODOS_OS_HORARIOS
            = " SELECT * FROM DIA_DE_PROVA;";

    public final String PESQUISAR_DIA_DE_PROVA
            = " SELECT * FROM DIA_DE_PROVA WHERE PROVA = ? ORDER BY PROVA; ";

    public final String PESQUISAR_ID_DIA_DE_PROVA
            = " SELECT * FROM DIA_DE_PROVA WHERE ID_DIA_DE_PROVA = ? ORDER BY ID_DIA_DE_PROVA; ";

    public final String CADASTRAR_DIA_DE_PROVA
            = " INSERT INTO DIA_DE_PROVA( "
            + " ID_TURMA"
            + ",ID_DISCIPLINA"
            + ",ID_PROFESSOR"
            + ",ID_SALA"
            + ",TURMA"
            + ",DISCIPLINA"
            + ",SALA"
            + ",PROFESSOR"
            + ",PROVA"
            + ",DATA_DA_PROVA"
            + ",DIA_DA_SEMANA"
            + ",HORARIO_INICIAL"
            + ",HORARIO_FINAL"
            + ",OBSERVACOES)"
            + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    
        public final String ALTERAR_DIA_DE_PROVA
            = " UPDATE DIA_DE_PROVA SET "
            + " ID_TURMA  = ? "
            + ",ID_DISCIPLINA  = ? "
            + ",ID_PROFESSOR  = ? "
            + ",ID_SALA  = ? "
            + ",TURMA  = ? "
            + ",DISCIPLINA  = ? "
            + ",SALA  = ? "
            + ",PROFESSOR  = ? "
            + ",PROVA  = ? "
            + ",DATA_DA_PROVA = ? "
            + ",DIA_DA_SEMANA  = ? "
            + ",HORARIO_INICIAL  = ? "
            + ",HORARIO_FINAL  = ? "
            + ",OBSERVACOES = ?"
            + " WHERE  ID_DIA_DE_PROVA= ?;";
    

    public final String GERAR_CODIGO_DIA_DE_PROVA
            = " UPDATE DIA_DE_PROVA SET "
            + " CODIGO_DIA_DE_PROVA = ? "
            + " WHERE ID_DIA_DE_PROVA = ?;";

    public ArrayList<DiaDeProvaVO> pesqusarTodosOsHorariosDeProvasDao() {
        System.out.println("Dentro do Metodo DAO pesqusarTodosOsHorariosDeProvasDao ...");
        ArrayList<DiaDeProvaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_TODOS_OS_HORARIOS);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DiaDeProvaVO vo = new DiaDeProvaVO();
                    vo.setIdDiaDeProva(rs.getInt("ID_DIA_DE_PROVA"));
                    vo.setIdTurma(rs.getInt("ID_TURMA"));
                    vo.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
                    vo.setIdProfessor(rs.getInt("ID_PROFESSOR"));
                    vo.setIdSala(rs.getInt("ID_SALA"));
                    vo.setTurma(rs.getString("TURMA"));
                    vo.setDisciplina(rs.getString("DISCIPLINA"));
                    vo.setSala(rs.getString("SALA"));
                    vo.setProfessor(rs.getString("PROFESSOR"));
                    vo.setProva(rs.getString("PROVA"));
                    vo.setCodigoDiaDeProva(rs.getString("CODIGO_DIA_DE_PROVA"));
                    vo.setDataDaProva(rs.getString("DATA_DA_PROVA"));
                    vo.setDiaDaSemana(rs.getString("DIA_DA_SEMANA"));
                    vo.setHorarioInicialDaProva(rs.getString("HORARIO_INICIAL"));
                    vo.setHorarioFinalDaProva(rs.getString("HORARIO_FINAL"));
                    vo.setObservacoes(rs.getString("OBSERVACOES"));
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

    public ArrayList<DiaDeProvaVO> pesquisarDiaDeProvaDao(String prova) {
        System.out.println("Dentro do Metodo DAO pesquisarDiaDeProvaDao ...");
        System.out.println("Prova : " + prova);
        ArrayList<DiaDeProvaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_DIA_DE_PROVA);
            ps.setString(1, prova);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DiaDeProvaVO vo = new DiaDeProvaVO();
                    vo.setIdDiaDeProva(rs.getInt("ID_DIA_DE_PROVA"));
                    vo.setIdTurma(rs.getInt("ID_TURMA"));
                    vo.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
                    vo.setIdProfessor(rs.getInt("ID_PROFESSOR"));
                    vo.setIdSala(rs.getInt("ID_SALA"));
                    vo.setTurma(rs.getString("TURMA"));
                    vo.setDisciplina(rs.getString("DISCIPLINA"));
                    vo.setSala(rs.getString("SALA"));
                    vo.setProfessor(rs.getString("PROFESSOR"));
                    vo.setProva(rs.getString("PROVA"));
                    vo.setCodigoDiaDeProva(rs.getString("CODIGO_DIA_DE_PROVA"));
                    vo.setDataDaProva(rs.getString("DATA_DA_PROVA"));
                    vo.setDiaDaSemana(rs.getString("DIA_DA_SEMANA"));
                    vo.setHorarioInicialDaProva(rs.getString("HORARIO_INICIAL"));
                    vo.setHorarioFinalDaProva(rs.getString("HORARIO_FINAL"));
                    vo.setObservacoes(rs.getString("OBSERVACOES"));
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

    public ArrayList<DiaDeProvaVO> pesquisarDiaDeProvPeloIdaDao(int idDiaDeProva) {
        System.out.println("Dentro do Metodo DAO pesquisarDiaDeProvaDao ...");
        System.out.println("IdProva : " + idDiaDeProva);
        ArrayList<DiaDeProvaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_ID_DIA_DE_PROVA);
            ps.setInt(1, idDiaDeProva);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    DiaDeProvaVO vo = new DiaDeProvaVO();
                    vo.setIdDiaDeProva(rs.getInt("ID_DIA_DE_PROVA"));
                    vo.setIdTurma(rs.getInt("ID_TURMA"));
                    vo.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
                    vo.setIdProfessor(rs.getInt("ID_PROFESSOR"));
                    vo.setIdSala(rs.getInt("ID_SALA"));
                    vo.setTurma(rs.getString("TURMA"));
                    vo.setDisciplina(rs.getString("DISCIPLINA"));
                    vo.setSala(rs.getString("SALA"));
                    vo.setProfessor(rs.getString("PROFESSOR"));
                    vo.setProva(rs.getString("PROVA"));
                    vo.setCodigoDiaDeProva(rs.getString("CODIGO_DIA_DE_PROVA"));
                    vo.setDataDaProva(rs.getString("DATA_DA_PROVA"));
                    vo.setDiaDaSemana(rs.getString("DIA_DA_SEMANA"));
                    vo.setHorarioInicialDaProva(rs.getString("HORARIO_INICIAL"));
                    vo.setHorarioFinalDaProva(rs.getString("HORARIO_FINAL"));
                    vo.setObservacoes(rs.getString("OBSERVACOES"));
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

    public boolean cadastrarObjetoDiaDeProvaDao(DiaDeProvaVO vo) {
        System.out.println("*** =) dentro do metodo cadastrarObjetoDiaDeProvaDao ***");
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_DIA_DE_PROVA)) {
                ps.setInt(1, vo.getIdTurma());
                ps.setInt(2, vo.getIdDisciplina());
                ps.setInt(3, vo.getIdProfessor());
                ps.setInt(4, vo.getIdSala());
                ps.setString(5, vo.getTurma());
                ps.setString(6, vo.getDisciplina());
                ps.setString(7, vo.getSala());
                ps.setString(8, vo.getProfessor());
                ps.setString(9, vo.getProva());
                ps.setString(10, vo.getDataDaProva());
                ps.setString(11, vo.getDiaDaSemana());
                ps.setString(12, vo.getHorarioInicialDaProva());
                ps.setString(13, vo.getHorarioFinalDaProva());
                ps.setString(14, vo.getObservacoes());
                ps.execute();
                ps.close();
            }
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(GERAR_CODIGO_DIA_DE_PROVA)) {
                DiaDeProvaBO bo = new DiaDeProvaBO();
                int idDiaDeProva = bo.pesquisarObjetoDiaDeProvaPeloNomeRetornarIdDiaDeProvaBo(vo.getProva());
                if (idDiaDeProva != 0) {
                    String codigoDiaDeProva = bo.gerarCodigoDaDiaDeProvaBo(idDiaDeProva);
                    ps.setString(1, codigoDiaDeProva);
                    ps.setInt(2, idDiaDeProva);
                    ps.execute();
                    ps.close();
                    System.out.println("Codigo  = " + codigoDiaDeProva);
                } else {
                    System.out.println("Não foi possivel gerar o codigo...");
                }
            }
            status = true;
            return status;
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
            return status;
        }
    }

    public boolean alterarObjetoDiaDeProvaDao(DiaDeProvaVO vo) {
        System.out.println("*** =) dentro do metodo alterarObjetoDiaDeProvaDao ***");
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(ALTERAR_DIA_DE_PROVA)) {
                ps.setInt(1, vo.getIdTurma());
                ps.setInt(2, vo.getIdDisciplina());
                ps.setInt(3, vo.getIdProfessor());
                ps.setInt(4, vo.getIdSala());
                ps.setString(5, vo.getTurma());
                ps.setString(6, vo.getDisciplina());
                ps.setString(7, vo.getSala());
                ps.setString(8, vo.getProfessor());
                ps.setString(9, vo.getProva());
                ps.setString(10, vo.getDataDaProva());
                ps.setString(11, vo.getDiaDaSemana());
                ps.setString(12, vo.getHorarioInicialDaProva());
                ps.setString(13, vo.getHorarioFinalDaProva());
                ps.setString(14, vo.getObservacoes());
                ps.setInt(15, vo.getIdDiaDeProva());
                ps.execute();
                ps.close();
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
