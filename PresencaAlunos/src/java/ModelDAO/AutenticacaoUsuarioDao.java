/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDAO;

import Conections.ConnectionBDAUTENTICACAO;
import ModelVO.AutenticacaoUsuarioVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class AutenticacaoUsuarioDao {
    
    public final String PESQUISAR_AUTENTICACAO = 
             " SELECT * FROM AUTENTICACAO_USUARIO "
            +" WHERE USUARIO = ? AND SENHA = ?; ";
    
    public final String PESQUISAR_STATUS = 
             " SELECT * FROM AUTENTICACAO_USUARIO "
            +" WHERE USUARIO = ? AND SENHA = ?; ";
    
    public ArrayList<AutenticacaoUsuarioVo> pesquisarUsuario(String usuario,String senha){        
        ArrayList<AutenticacaoUsuarioVo> array = new ArrayList();
        try{
            PreparedStatement ps = ConnectionBDAUTENTICACAO.conectarBDAUTENTICACAO().prepareStatement(PESQUISAR_AUTENTICACAO);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while(rs.next()){
                    AutenticacaoUsuarioVo autenticacaoUsuarioVo = new AutenticacaoUsuarioVo();
                    autenticacaoUsuarioVo.setUsuario(rs.getString("USUARIO"));
                    autenticacaoUsuarioVo.setSenha(rs.getString("SENHA"));
                    autenticacaoUsuarioVo.setAutenticacaoUsuarioVo(rs.getInt("STATUS_DE_PREVILEGIO"));
                    array.add(autenticacaoUsuarioVo);
                }
            }
        }catch(SQLException sql){
            System.out.print(" Error MSG: "+sql.getMessage());
            System.out.print(" Error MSG: "+sql.getErrorCode());
        }
        return array;
    }
    
    public ArrayList<AutenticacaoUsuarioVo> pesquisarStatusUsuario(String usuario,String senha){        
        ArrayList<AutenticacaoUsuarioVo> array = new ArrayList();
        try{
            PreparedStatement ps = ConnectionBDAUTENTICACAO.conectarBDAUTENTICACAO().prepareStatement(PESQUISAR_STATUS);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while(rs.next()){
                    AutenticacaoUsuarioVo autenticacaoUsuarioVo = new AutenticacaoUsuarioVo();
                    autenticacaoUsuarioVo.setAutenticacaoUsuarioVo(rs.getInt("STATUS_DE_PREVILEGIO"));
                    array.add(autenticacaoUsuarioVo);
                }
            }
        }catch(SQLException sql){
            System.out.print(" Error MSG: "+sql.getMessage());
            System.out.print(" Error MSG: "+sql.getErrorCode());
        }
        return array;
    }
}
