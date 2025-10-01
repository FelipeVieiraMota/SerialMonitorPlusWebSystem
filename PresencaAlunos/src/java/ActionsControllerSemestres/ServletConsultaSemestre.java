/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerSemestres;

import ModelBO.SemestreBO;
import ModelVO.SemestreVO;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
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
public class ServletConsultaSemestre extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws HTTPException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, HTTPException {
        HttpSession session = request.getSession();
        String semestre = request.getParameter("selectSemestre");
        System.out.println(" semestre = " + semestre);
        SemestreBO semestreBO = new SemestreBO();
        ArrayList<SemestreVO> arraySemestre;
        arraySemestre = semestreBO.pesquisarSemestrePeloNome(semestre);
        Gson gson = new Gson();
        if (arraySemestre.isEmpty()) {
            System.out.println("Dentro do if (true) da servlet ServletConsultaSemestre semestre =(");
            //session.setAttribute("statusConsulta", true);
            String retorno = gson.toJson(arraySemestre);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
            //response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeSemestres.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da servlet ServletConsultaSemestre semestre =)");
            //session.setAttribute("statusConsulta", false);
            String retorno = gson.toJson(arraySemestre);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultaSemestre");
        System.out.println("Finalizando a servlet");
    }
}
