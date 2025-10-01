/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelVO.AlunoTurmaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class AlunoTurmaDAO {

    public final String VINCULAR_ALUNO_EM_UMA_TURMA
            = " INSERT INTO ALUNO_TURMA( "
            + " ID_TURMA "
            + ",ID_ALUNO) "
            + " VALUES(?,?) ";

    public final String ALTERAR_VINCULO_ENTRE_ALUNO_TURMA
            = " UPDATE ALUNO_TURMA SET "
            + " ID_TURMA = ? "
            + ",ID_ALUNO = ? "
            + " WHERE "
            + " ID_TURMA = ? AND ID_ALUNO = ?;";

    public final String PESQUISAR_TODOS_OS_ALUNOS_TURMAS 
            = " SELECT * FROM ALUNO_TURMA ALT, ALUNO A, TURMA T"
            + " WHERE A.ID_ALUNO = ALT.ID_ALUNO AND "
            + " T.ID_TURMA = ALT.ID_TURMA;";

    public final String PESQUISAR_TODOS_OS_ALUNOS_TURMAS_PELO_NOME_ALUNO
            = " SELECT * FROM ALUNO A, ALUNO_TURMA ALT, TURMA T "
            + " WHERE "
            + " A.ID_ALUNO = ALT.ID_ALUNO AND "
            + " T.ID_TURMA = ALT.ID_TURMA AND " 
            + " A.NOME_ALUNO = ?; ";            

    public final String PESQUISAR_ALUNO_TURMA 
            = " SELECT * FROM ALUNO_TURMA"
            + " WHERE ID_ALUNO = ? AND ID_TURMA = ?;";

    public boolean vincularAlunoTurmaDao(AlunoTurmaVO vo) {
        System.out.println("*** =) dentro do metodo vincularAlunoTurmaDao ***");
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(VINCULAR_ALUNO_EM_UMA_TURMA)) {
                ps.setInt(1, vo.getIdTurma());
                ps.setInt(2, vo.getIdAluno());
                ps.execute();
                ps.close();
                status = true;
            }
            return status;
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
            return status;
        }
    }

    public boolean alterarVinculoEntreAlunoTurmaDao(AlunoTurmaVO vo) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(ALTERAR_VINCULO_ENTRE_ALUNO_TURMA)) {
                ps.setInt(1, vo.getIdTurma());
                ps.setInt(2, vo.getIdAluno());
                ps.setInt(3, vo.getIdTurma());
                ps.setInt(4, vo.getIdAluno());
                ps.execute();
                ps.close();
                System.out.println(" =) dentro de alterarVinculoEntreAlunoTurmaDao");
                System.out.println(" =) alterção do aluno realizada com sucesso!");
                status = true;
                return status;
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro ao alterar os Dados da turma e aluno");
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
            return status;
        }
    }

    public ArrayList<AlunoTurmaVO> pesquisarTodosOsAlunosTurmaDao() {
        System.out.println("Dentro do Metodo pesquisarTodosOsAlunosTurma ...");
        ArrayList<AlunoTurmaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_TODOS_OS_ALUNOS_TURMAS);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AlunoTurmaVO vo = new AlunoTurmaVO();
                    vo.setIdAluno(rs.getInt("ID_ALUNO"));
                    vo.setIdTurma(rs.getInt("ID_TURMA"));
                    vo.setNomeAluno(rs.getString("NOME_ALUNO"));
                    vo.setTurma(rs.getString("NOME_TURMA"));
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

    public ArrayList<AlunoTurmaVO> pesquisarAlunoTurmaDao(int idAluno, int idTurma) {
        System.out.println("Dentro do Metodo pesquisarTodosOsAlunosTurma ...");
        ArrayList<AlunoTurmaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_TODOS_OS_ALUNOS_TURMAS);
            ps.setInt(1, idAluno);
            ps.setInt(2, idTurma);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AlunoTurmaVO vo = new AlunoTurmaVO();
                    vo.setIdAluno(rs.getInt("ID_ALUNO"));
                    vo.setIdTurma(rs.getInt("ID_TURMA"));
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
    
    public ArrayList<AlunoTurmaVO> pesquisarAlunoTurmaPeloNomeDao(String nomeAluno) {
        System.out.println("Dentro do Metodo pesquisarAlunoTurmaPeloNomeDao ...");
        ArrayList<AlunoTurmaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_TODOS_OS_ALUNOS_TURMAS_PELO_NOME_ALUNO);
            ps.setString(1,nomeAluno);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AlunoTurmaVO vo = new AlunoTurmaVO();
                    vo.setIdAluno(rs.getInt("ID_ALUNO"));
                    vo.setIdTurma(rs.getInt("ID_TURMA"));
                    vo.setNomeAluno(rs.getString("NOME_ALUNO"));
                    vo.setTurma(rs.getString("NOME_TURMA"));
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
