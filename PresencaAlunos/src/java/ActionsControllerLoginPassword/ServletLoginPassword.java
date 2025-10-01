/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerLoginPassword;

import ModelBO.AutenticacaoUsuarioBo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author felipe
 */
public class ServletLoginPassword extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws HTTPException
     * @throws ServletException
     * @throws IOException
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws HTTPException, ServletException, IOException {

        boolean retorno;
        String usuario = (String) request.getParameter("usuario");
        String senha = (String) request.getParameter("senha");
        HttpSession session = request.getSession();

        /* Cria uma instância nova para AutenticacaoUsuarioBo */
        AutenticacaoUsuarioBo autenticacaoUsuarioBo = new AutenticacaoUsuarioBo();
        /*return true or false*/
        retorno = autenticacaoUsuarioBo.autenticarUsuario(usuario, senha);

        System.out.println("usuario: " + usuario + "  " + "senha: " + senha);

        if (retorno == true) {
            /*Retorna o status(flag)*/
            int flag = autenticacaoUsuarioBo.verificarStatusUsuario(usuario, senha);
            RequestDispatcher rd;
            switch (flag) {
                case 1:
                    System.out.println("Administrador logado (status == 1)");
                    session.setAttribute("usuarioExiste", true);
                    response.sendRedirect("/PresencaAlunos/indexAdm.jsp");    
                    destroy();
                    break;
                case 2:
                    System.out.println("Professor logado (status == 2)");
                    destroy();
                    break;
                case 3:
                    System.out.println("Aluno logado (status == 3)");
                    destroy();
                    break;
                default:

                    break;
            }
        } else {
            System.out.println("Error of autentication status!");
            System.out.println("Erro ao autententicar!!! =(");
            RequestDispatcher rd;
            session.setAttribute("usuarioExiste", false);
            rd = request.getRequestDispatcher("/login-password/login-password.jsp");
            rd.forward(request, response);
            session.invalidate();
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletLoginPassword");
        System.out.println("Finalizando a servlet");
    }
}
