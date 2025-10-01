/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDAO;

import Conections.ConnectionBdRegra;
import RegraVO.FrequenciaAlunoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class FrequenciaAlunoDAO {

    public final String CADASTRAR_FREQUENCIA_DO_ALUNO
            = " INSERT INTO FREQUENCIA_DO_ALUNO("
            + " ID_ALUNO, "
            + " NOME_ALUNO, "
            + " STATUS, "
            + " PROVA, "
            + " DATA_DIA_DE_PROVA, "
            + " HORARIO_DO_PONTO,"
            + " DIA_DA_SEMANA,"
            + " SALA)"
            + " VALUES(?,?,?,?,?,?,?,?);";

    public final String PESQUISAR_STATUS
            = " select * from FREQUENCIA_DO_ALUNO WHERE PROVA = ?  AND ID_ALUNO = ?;";

    public final String PESQUISAR_NA_TABELA_FREQUENCIA_DO_ALUNO
            = " SELECT * FROM FREQUENCIA_DO_ALUNO WHERE ID_ALUNO = ?;";

    public boolean cadastrarFrequenciaDoAluno(FrequenciaAlunoVO vo) {
        System.out.println("*** =) dentro do metodo cadastrarFrequenciaDoAluno ***");
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_FREQUENCIA_DO_ALUNO)) {
                System.out.println("********************************");
                System.out.println("ID ALUNO : " + vo.getIdAluno());
                System.out.println("ID Dia de Prova: " + vo.getIdDiaDeprova());
                System.out.println("Status  : " + vo.getStatus());
                System.out.println("********************************");
                ps.setInt(1, vo.getIdAluno());
                ps.setString(2, vo.getNomeAluno());
                ps.setBoolean(3, vo.getStatus());
                ps.setString(4, vo.getProva());
                ps.setString(5, vo.getDataDiaDeProva());
                ps.setString(6, vo.getHorarioDoPonto());
                ps.setString(7, vo.getDiaDaSemana());
                ps.setString(8, vo.getSala());
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

    public boolean verificaSeAlunoJaBateuPonto(String prova, int idAluno) {
        boolean status = false;
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_STATUS);
            ps.setString(1, prova);
            ps.setInt(2, idAluno);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("Já bateu o ponto!!!!!!!!!!!!!!!");
                    status = true;
                }
                ps.close();
            } else {
                System.out.println("rs está null");
                status = false;
            }
        } catch (SQLException e) {
            int code = e.getErrorCode();
            String msg = e.getMessage();
            System.out.println("Erro code Nº: " + code + "\n" + "ErrorMSG: " + msg);
        }
        return status;
    }

    public ArrayList<FrequenciaAlunoVO> pesquisarNaTabelaFrequenciaDoAluno(int idAluno) {
        ArrayList<FrequenciaAlunoVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_NA_TABELA_FREQUENCIA_DO_ALUNO);
            ps.setInt(1, idAluno);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    FrequenciaAlunoVO freq = new FrequenciaAlunoVO();
                    freq.setIdAluno(rs.getInt("ID_ALUNO"));
                    freq.setHorarioDoPonto(rs.getString("HORARIO_DO_PONTO"));
                    freq.setDataDiaDeProva(rs.getString("DATA_DIA_DE_PROVA"));
                    array.add(freq);
                }
                ps.close();
            } else {
                System.out.println("rs está null");
            }
        } catch (SQLException ex) {
            System.out.println("Erro : " + ex.getMessage());
        }
        return array;
    }

}
