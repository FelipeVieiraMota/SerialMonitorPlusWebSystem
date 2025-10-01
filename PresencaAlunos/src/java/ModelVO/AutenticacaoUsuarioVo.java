/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelVO;

/**
 *
 * @author felipe
 */
public class AutenticacaoUsuarioVo {
    private int autenticacaoUsuarioVo;
    private String usuario;
    private String senha;
    
    public AutenticacaoUsuarioVo(){/*In this place is necessary stay void*/}

    public AutenticacaoUsuarioVo(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public int getAutenticacaoUsuarioVo() {
        return autenticacaoUsuarioVo;
    }

    public void setAutenticacaoUsuarioVo(int autenticacaoUsuarioVo) {
        this.autenticacaoUsuarioVo = autenticacaoUsuarioVo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
