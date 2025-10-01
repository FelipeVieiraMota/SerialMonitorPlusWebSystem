/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDAO;

import Conections.ConnectionBdRegra;
import RegraVO.AlunoTurmaCursoSemestreAnoVO;
import RegraVO.DiaDeProvaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class FluxoDAO {

    public final String PESQUISAR_ALUNO_TURMA_CURSO_ANO_SEMESTRE
            = " SELECT * FROM "
            + " ALUNO A "
            + ",TURMA T "
            + ",CURSO C "
            + ",ALUNO_TURMA ALT "
            + ",ANO_SEMESTRE ANS "
            + ",ANO_SEMESTRE_TURMA ANST "
            + " WHERE "
            + " A.ID_ALUNO = ALT.ID_ALUNO AND "
            + " T.ID_TURMA = ALT.ID_TURMA AND "
            + " T.ID_TURMA = ANST.ID_TURMA AND "
            + " ANS.ID_ANO_SEMESTRE = ANST.ID_ANO_SEMESTRE AND "
            + " C.ID_CURSO = T.ID_CURSO AND "
            + " A.CODIGO_CARTAO_RFID = ?; ";

    public final String PESQUISAR_DATA_HORARIO_INICIAL_HORARIO_FINAL
            = " SELECT * FROM "
            + " DIA_DE_PROVA "
            + " WHERE "
            + " DATA_DA_PROVA = ? AND "
            + " ID_TURMA = ? AND "
            + " SALA = ?; ";

    public ArrayList<AlunoTurmaCursoSemestreAnoVO> pesquisarAlunoTurmaCursoSemestre(String codigoCartaRfid) {
        ArrayList<AlunoTurmaCursoSemestreAnoVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_ALUNO_TURMA_CURSO_ANO_SEMESTRE);
            ps.setString(1, codigoCartaRfid);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AlunoTurmaCursoSemestreAnoVO vo = new AlunoTurmaCursoSemestreAnoVO();
                    vo.setIdAluno(rs.getInt("ID_ALUNO"));
                    vo.setIdTurma(rs.getInt("ID_TURMA"));
                    vo.setIdCurso(rs.getInt("ID_CURSO"));
                    vo.setNomeAluno(rs.getString("NOME_ALUNO"));
                    vo.setCartaoRfid(rs.getString("CODIGO_CARTAO_RFID"));
                    vo.setCodigoMatriculaAluno(rs.getString("CODIGO_MATRICULA_ALUNO"));
                    vo.setTurma(rs.getString("NOME_TURMA"));
                    vo.setSemestreAno(rs.getString("ANO_SEMESTRE"));
                    vo.setPeriodoTurma(rs.getString("PERIODO"));
                    vo.setNomeCurso(rs.getString("NOME_CURSO"));   
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
    
    
    
    public ArrayList<DiaDeProvaVO> pesquisarDataHorarioInicialHorarioFinal(String dataAtualDoSistema, int idTurma, String sala) {
        ArrayList<DiaDeProvaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_DATA_HORARIO_INICIAL_HORARIO_FINAL);
            ps.setString(1, dataAtualDoSistema);
            ps.setInt(2, idTurma);
            ps.setString(3, sala);
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
                    System.out.println("Dentro do metodo DAO pesquisarDataHorarioInicialHorarioFinal sProva : "+vo.getProva());
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
