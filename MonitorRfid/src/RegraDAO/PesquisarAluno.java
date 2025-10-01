/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDAO;

import Conections.ConnectionBdRegra;
import RegraVO.AlunoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class PesquisarAluno {

    public final String PESQUISAR_ALUNO
            = " SELECT * FROM ALUNO A, TURMA T, ALUNO_TURMA ALT, CURSO C "
            + " WHERE "
            + " A.CODIGO_CARTAO_RFID = ? AND "
            + " A.ID_ALUNO = ALT.ID_ALUNO AND "
            + " T.ID_TURMA = ALT.ID_TURMA AND "
            + " C.ID_CURSO = T.ID_CURSO; ";            

    
    public ArrayList<AlunoVO> consultarAluno(String rfid) {
        System.out.println("Dentro do metodo consultarAluno");
        ArrayList<AlunoVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(PESQUISAR_ALUNO);
            ps.setString(1, rfid);
            ResultSet rs = ps.executeQuery();
            //if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    AlunoVO vo = new AlunoVO();
                    vo.setIdAluno(rs.getInt("ID_ALUNO"));
                    vo.setIdCurso(rs.getInt("ID_CURSO"));
                    vo.setIdTurma(rs.getInt("ID_TURMA"));
                    vo.setAbreviacaoTurma(rs.getString("ABREVIACAO_TURMA"));
                    vo.setNomeCurso(rs.getString("NOME_CURSO"));
                    vo.setNomeAluno(rs.getString("NOME_ALUNO"));
                    vo.setNomeMaeAluno(rs.getString("NOME_MAE_ALUNO"));
                    vo.setNomePaiAluno(rs.getString("NOME_PAI_ALUNO"));
                    vo.setCpfAluno(rs.getString("CPF_ALUNO"));
                    vo.setSexoAluno(rs.getString("SEXO_ALUNO"));
                    vo.setIdadeAluno(rs.getString("IDADE_ALUNO"));
                    vo.setDataNascimentoAluno(rs.getString("DATA_NASCIMENTO_ALUNO"));
                    vo.setEmailAluno(rs.getString("EMAIL_ALUNO"));
                    vo.setCelularAluno(rs.getString("CELULAR_ALUNO"));
                    vo.setRgAluno(rs.getString("RG_ALUNO"));
                    vo.setCodigoCartaoRfidAluno(rs.getString("CODIGO_CARTAO_RFID"));
                    vo.setCodigoMatriculaAluno(rs.getString("CODIGO_MATRICULA_ALUNO"));
                    array.add(vo);                    
                    System.out.println("Acesso liberado!");                    
                }
                ps.close();
            //} else {
              //  System.out.println("rs está null");
            //}
        } catch (SQLException e) {
            int code = e.getErrorCode();
            String msg = e.getMessage();
            System.out.println("Erro code Nº: " + code + "/n" + "ErrorMSG: " + msg);
        }
        return array;
    }
}
