/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBO;

import ModelDAO.AutenticacaoUsuarioDao;
import ModelVO.AutenticacaoUsuarioVo;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class AutenticacaoUsuarioBo {

    public boolean autenticarUsuario(String usuario, String senha) {
        boolean retorno = false;
        ArrayList<AutenticacaoUsuarioVo> array;
        AutenticacaoUsuarioDao autenticacaoUsuarioDao = new AutenticacaoUsuarioDao();
        array = autenticacaoUsuarioDao.pesquisarUsuario(usuario, senha);

        for (AutenticacaoUsuarioVo autenticacaoUsuarioVo : array) {
            if (autenticacaoUsuarioVo.getUsuario().equals(usuario)
                    && autenticacaoUsuarioVo.getSenha().equals(senha)) {
                retorno = true;
            }
        }
        return retorno;
    }

    public int verificarStatusUsuario(String usuario, String senha) {
        int flag = 0;
        ArrayList<AutenticacaoUsuarioVo> array;
        AutenticacaoUsuarioDao autenticacaoUsuarioDao = new AutenticacaoUsuarioDao();
        array = autenticacaoUsuarioDao.pesquisarStatusUsuario(usuario, senha);

        for (AutenticacaoUsuarioVo autenticacaoUsuarioVo : array) {
           flag = autenticacaoUsuarioVo.getAutenticacaoUsuarioVo();
           System.out.println("Verificando o Status = "+flag);
        }
        return flag;
    }
}
