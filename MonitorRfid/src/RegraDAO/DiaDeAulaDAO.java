/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDAO;

import Conections.ConnectionBdRegra;
import RegraVO.DiaDeProvaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class DiaDeAulaDAO {

    public final String PESQUISAR_DIA_DE_PROVA
            = " SELECT * FROM DIA_DE_PROVA "
            + " WHERE SALA = ?;";

    public final String VERIFICAR_SE_ALUNO_JA_BATEU_PONTO
            = " SELECT A.NOME_ALUNO FROM FREQUENCIA_DO_ALUNO F, ALUNO A, DIA_DE_PROVA DP, DISCIPLINA D "
            + " ,PROFESSOR P ,SALA S ,TURMA T, ALUNO_TURMA ALT"
            + " WHERE "
            + " F.ID_ALUNO = A.ID_ALUNO AND "
            + " F.ID_DIA_DE_PROVA = DP.ID_DIA_DE_PROVA AND "
            + " A.ID_ALUNO = ALT.ID_ALUNO AND "
            + " T.ID_TURMA = ALT.ID_TURMA AND "
            + " T.ID_TURMA = DP.ID_TURMA AND "
            + " D.ID_DISCIPLINA = DP.ID_DISCIPLINA AND "
            + " P.ID_PROFESSOR = DP.ID_PROFESSOR AND "
            + " S.ID_SALA = DP.ID_SALA and "
            + " A.CODIGO_CARTAO_RFID = ?;";

    /*    
     SELECT A.ID_ALUNO,A.NOME_ALUNO FROM FREQUENCIA_DO_ALUNO F, ALUNO A, DIA_DE_PROVA DP, DISCIPLINA D 
            ,PROFESSOR P ,SALA S ,TURMA T, ALUNO_TURMA ALT           
            WHERE 
            F.ID_ALUNO = A.ID_ALUNO AND 
            F.ID_DIA_DE_PROVA = DP.ID_DIA_DE_PROVA AND 
            A.ID_ALUNO = ALT.ID_ALUNO AND 
            T.ID_TURMA = ALT.ID_TURMA AND 
            T.ID_TURMA = DP.ID_TURMA AND
            D.ID_DISCIPLINA = DP.ID_DISCIPLINA AND 
            P.ID_PROFESSOR = DP.ID_PROFESSOR AND 
            S.ID_SALA = DP.ID_SALA and 
            A.CODIGO_CARTAO_RFID = "250118440";
     */
    public boolean verificaSeAlunoJaBateuPonto(String cartao) {
        boolean status = false;
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_DIA_DE_PROVA);
            ps.setString(1, cartao);
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

    public ArrayList<DiaDeProvaVO> consultarDiaDeProva(String sala, String data) {
        ArrayList<DiaDeProvaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_DIA_DE_PROVA);
            ps.setString(1, sala);
            //ps.setString(2,data);

            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    DiaDeProvaVO vo = new DiaDeProvaVO();
                    vo.setIdDiaDeProva(rs.getInt("ID_DIA_DE_PROVA"));
                    vo.setProva(rs.getString("PROVA"));
                    vo.setSala(rs.getString("SALA"));
                    vo.setCodigoDiaDeProva(rs.getString("CODIGO_DIA_DE_PROVA"));
                    vo.setHorarioInicialDaProva(rs.getString("HORARIO_INICIAL"));
                    vo.setHorarioFinalDaProva(rs.getString("HORARIO_FINAL"));
                    vo.setDiaDaSemana(rs.getString("DIA_DA_SEMANA"));
                    array.add(vo);
                    System.out.println("Prova :" + vo.getProva());
                    System.out.println("Sala  :" + vo.getSala());
                    System.out.println("Cod.  :" + vo.getCodigoDiaDeProva());
                    System.out.println("Horario Inicial :" + vo.getHorarioInicialDaProva());
                    System.out.println("Horario Final :" + vo.getHorarioFinalDaProva());
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
