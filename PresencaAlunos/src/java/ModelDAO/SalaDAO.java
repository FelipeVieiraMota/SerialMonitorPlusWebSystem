/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBdRegra;
import ModelBO.SalaBO;
import ModelVO.SalaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class SalaDAO {

    public final String CONSULTAR_TODAS_AS_SALA
            = " SELECT * FROM SALA ORDER BY ID_SALA;";

    public final String CONSULTAR_SALA_PELO_NUMERO
            = " SELECT * FROM SALA WHERE NUMERO_SALA = ? ORDER BY NUMERO_SALA;";

    public final String CONSULTAR_SALA_PELO_NOME
            = " SELECT * FROM SALA WHERE NOME_SALA = ? ORDER BY NOME_SALA;";
    
    public final String CONSULTAR_SALA_PELO_ID
            = " SELECT * FROM SALA WHERE ID_SALA = ? ORDER BY ID_SALA;";

    public final String CADASTRAR_NOVA_SALA
            = " INSERT INTO SALA( "
            + " TIPO_DE_SALA "
            + ",NUMERO_SALA "
            + ",ANDAR_SALA "
            + ",CODIGO_SALA "
            + ",NOME_SALA "
            + ",OBSERVACOES)"
            + "VALUES(?,?,?,?,?,?); ";
    
    public final String ALTERAR_SALA
            = "  UPDATE SALA SET "
            + "  TIPO_DE_SALA = ? "
            + " ,NUMERO_SALA = ? "
            + " ,ANDAR_SALA = ? "
            + " ,CODIGO_SALA = ? "
            + " ,NOME_SALA = ? "            
            + " ,OBSERVACOES = ? "
            + "  WHERE ID_SALA = ?; ";

    public final String CADASTRAR_CODIGO_DA_SALA
            = " UPDATE SALA SET CODIGO_SALA = ? "
            + " WHERE ID_SALA = ?; ";

    public ArrayList<SalaVO> consultarTodasAsSalas() {
        System.out.println("Dentro do Metodo DAO consultarTodasAsSalas ...");
        ArrayList<SalaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_TODAS_AS_SALA);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Sala: " + rs.getInt("ID_SALA"));
                    System.out.println("TIPO DE SALA: " + rs.getString("TIPO_DE_SALA"));
                    System.out.println("NUMERO DA SALA: " + rs.getString("NUMERO_SALA"));
                    System.out.println("Observações: " + rs.getString("OBSERVACOES"));
                    System.out.println("*****************************************");
                    SalaVO vo = new SalaVO();
                    vo.setIdSala(rs.getInt("ID_SALA"));
                    vo.setTipoDeSala(rs.getString("TIPO_DE_SALA"));
                    vo.setNumeroDaSala(rs.getString("NUMERO_SALA"));
                    vo.setAndarDaSala(rs.getString("ANDAR_SALA"));
                    vo.setCodigoDaSala(rs.getString("CODIGO_SALA"));
                    vo.setNomeSala(rs.getString("NOME_SALA"));
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

    public ArrayList<SalaVO> pesquisarSalaPeloIdDao(int idSala) {
        System.out.println("Dentro do Metodo DAO pesquisarSalaPeloIdDao ...");
        System.out.println("*** Sala Digitada = " + idSala + " ***");
        ArrayList<SalaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_SALA_PELO_ID);
            ps.setInt(1, idSala);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Sala: " + rs.getInt("ID_SALA"));
                    System.out.println("Sala: " + rs.getString("NUMERO_SALA"));
                    System.out.println("Observações: " + rs.getString("OBSERVACOES"));
                    System.out.println("*****************************************");
                    SalaVO vo = new SalaVO();
                    vo.setIdSala(rs.getInt("ID_SALA"));
                    vo.setNomeSala(rs.getString("NOME_SALA"));
                    vo.setTipoDeSala(rs.getString("TIPO_DE_SALA"));
                    vo.setNumeroDaSala(rs.getString("NUMERO_SALA"));
                    vo.setAndarDaSala(rs.getString("ANDAR_SALA"));
                    vo.setCodigoDaSala(rs.getString("CODIGO_SALA"));
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

    public ArrayList<SalaVO> consultarSalaPeloNumeroDaSalaDao(String numeroSala) {
        System.out.println("Dentro do Metodo DAO consultarSalaPeloNome ...");
        System.out.println("*** Sala Digitada = " + numeroSala + " ***");
        ArrayList<SalaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_SALA_PELO_NUMERO);
            ps.setString(1, numeroSala);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Sala: " + rs.getInt("ID_SALA"));
                    System.out.println("Sala: " + rs.getString("NUMERO_SALA"));
                    System.out.println("Observações: " + rs.getString("OBSERVACOES"));
                    System.out.println("*****************************************");
                    SalaVO vo = new SalaVO();
                    vo.setIdSala(rs.getInt("ID_SALA"));
                    vo.setNomeSala(rs.getString("NOME_SALA"));
                    vo.setTipoDeSala(rs.getString("TIPO_DE_SALA"));
                    vo.setNumeroDaSala(rs.getString("NUMERO_SALA"));
                    vo.setAndarDaSala(rs.getString("ANDAR_SALA"));
                    vo.setCodigoDaSala(rs.getString("CODIGO_SALA"));
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

    public ArrayList<SalaVO> consultarSalaPeloNomeDaSalaDao(String nomeSala) {
        System.out.println("Dentro do Metodo DAO consultarSalaPeloNome ...");
        System.out.println("*** Sala Digitada = " + nomeSala + " ***");
        ArrayList<SalaVO> array = new ArrayList();
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_SALA_PELO_NOME);
            ps.setString(1, nomeSala);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Sala: " + rs.getInt("ID_SALA"));
                    System.out.println("Sala: " + rs.getString("NOME_SALA"));
                    System.out.println("Observações: " + rs.getString("OBSERVACOES"));
                    System.out.println("*****************************************");
                    SalaVO vo = new SalaVO();
                    vo.setIdSala(rs.getInt("ID_SALA"));
                    vo.setNomeSala(rs.getString("NOME_SALA"));
                    vo.setTipoDeSala(rs.getString("TIPO_DE_SALA"));
                    vo.setNumeroDaSala(rs.getString("NUMERO_SALA"));
                    vo.setAndarDaSala(rs.getString("ANDAR_SALA"));
                    vo.setCodigoDaSala(rs.getString("CODIGO_SALA"));
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

    public int consultarSalaPeloNumeroRetornarIdSalaDao(String numeroSala) {
        System.out.println("Dentro do Metodo DAO consultarSalaPeloNome ...");
        System.out.println("*** Sala Digitado = " + numeroSala + " ***");
        int retorno = 0;
        try {
            PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CONSULTAR_SALA_PELO_NUMERO);
            ps.setString(1, numeroSala);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("*****************************************");
                    System.out.println("ID Sala: " + rs.getInt("ID_SALA"));
                    System.out.println("Sala: " + rs.getString("NUMERO_SALA"));
                    System.out.println("*****************************************");
                    SalaVO vo = new SalaVO();
                    vo.setIdSala(rs.getInt("ID_SALA"));
                    vo.setNomeSala(rs.getString("NUMERO_SALA"));
                    if (vo.getNomeSala().equals(numeroSala)) {
                        return vo.getIdSala();
                    }
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
        return retorno;
    }

    public boolean cadastrarSalaDao(SalaVO vo) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_NOVA_SALA)) {
                ps.setString(1, vo.getTipoDeSala());
                ps.setString(2, vo.getNumeroDaSala());
                ps.setString(3, vo.getAndarDaSala());
                ps.setString(4, vo.getCodigoDaSala());
                ps.setString(5, vo.getNomeSala());
                ps.setString(6, vo.getObservacoes());
                ps.execute();
                ps.close();
            }
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(CADASTRAR_CODIGO_DA_SALA)) {
                SalaBO bo = new SalaBO();
                int idSala = consultarSalaPeloNumeroRetornarIdSalaDao(vo.getNumeroDaSala());
                String codigoDaSala = bo.gerarCodigoDaSalaBo(idSala);
                if (idSala > 0) {
                    System.out.println("Codigo da Sala = " + codigoDaSala);
                    ps.setString(1, codigoDaSala);
                    ps.setInt(2, idSala);
                    ps.execute();
                    ps.close();
                    System.out.println(" =) dentro da classe SalaDAO");
                    System.out.println(" =) codigo gerado para a sala : " + codigoDaSala);
                    System.out.println(" =) cadastro de Sala realizado com sucesso!");
                    status = true;
                }
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
        }
        return status;
    }
    
        public boolean alterarSalaDao(SalaVO vo) {
        boolean status = false;
        try {
            try (PreparedStatement ps = ConnectionBdRegra.conectarBdRegra().prepareStatement(ALTERAR_SALA)) {
                ps.setString(1, vo.getTipoDeSala());
                ps.setString(2, vo.getNumeroDaSala());
                ps.setString(3, vo.getAndarDaSala());
                ps.setString(4, vo.getCodigoDaSala());
                ps.setString(5, vo.getNomeSala());
                ps.setString(6, vo.getObservacoes());
                ps.setInt(7, vo.getIdSala());
                ps.execute();
                ps.close();
                status = true;
            }
        } catch (SQLException sql) {
            System.out.println("=( Erro Mensagem : " + sql.getMessage());
            System.out.println("=( Erro Codigo: " + sql.getErrorCode());
        }
        return status;
    }
}
