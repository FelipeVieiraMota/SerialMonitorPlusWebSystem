/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelVO.FrequenciaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class FrequenciaAlunoDAO {

    public final String PESQUISAR_FREQUENCIA_DO_ALUNO
            = "SELECT * FROM FREQUENCIA_DO_ALUNO WHERE NOME_ALUNO = ?;";

    public ArrayList<FrequenciaVO> pesquisarFrequenciaDoAlunoDao(String nomeAluno) {
        ArrayList<FrequenciaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_FREQUENCIA_DO_ALUNO);
            ps.setString(1, nomeAluno);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    FrequenciaVO vo = new FrequenciaVO();
                    vo.setIdaluno(rs.getInt("ID_ALUNO"));
                    vo.setNomeAluno(rs.getString("NOME_ALUNO"));
                    vo.setStatus(rs.getBoolean("STATUS"));
                    vo.setSala(rs.getString("SALA"));
                    vo.setProva(rs.getString("PROVA"));
                    vo.setDataDiaDeProva(rs.getString("DATA_DIA_DE_PROVA"));
                    vo.setHorarioDoPonto(rs.getString("HORARIO_DO_PONTO"));
                    vo.setDataDiaDeProva(rs.getString("DIA_DA_SEMANA"));
                    array.add(vo);
                }
                ps.close();
            }            
        } catch (SQLException ex) {
            System.out.println("Erro : " + ex.getMessage());
        }
        return array;
    }
}
