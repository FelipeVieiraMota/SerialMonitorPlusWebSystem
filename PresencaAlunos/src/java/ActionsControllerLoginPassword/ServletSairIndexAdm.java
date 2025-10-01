/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerLoginPassword;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author felipe
 */
public class ServletSairIndexAdm extends HttpServlet {

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
        HttpSession session = request.getSession();
        RequestDispatcher rd;
         session.setAttribute("usuarioExiste", null);
         response.sendRedirect("/PresencaAlunos/login-password/login-password.jsp");
        //rd = request.getRequestDispatcher("/login-password/login-password.jsp");
        //rd.forward(request, response);
        destroy();
    }
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
        log("Destruindo a servlet");
        System.out.println("Finalizando a servlet");
    }
}
