/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerDisciplinas;

import ModelBO.CursoBO;
import ModelBO.DisciplinaBO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author felipe
 */
public class ServletConsultaDisciplinas extends HttpServlet {


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
        String selectDisciplina = request.getParameter("selectDisciplina");
        Gson gson = new Gson();
        DisciplinaBO disciplinaBO = new DisciplinaBO();
        ArrayList disciplinaArray;
        disciplinaArray = disciplinaBO.pesquisarsDisciplinaPeloNome(selectDisciplina);
        if (!disciplinaArray.isEmpty()) {
            String retorno = gson.toJson(disciplinaArray);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
        } else {
            System.out.println("Array curso vazio ou nulo = " + disciplinaArray);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultaDisciplinas");
        System.out.println("Finalizando a ServletConsultaDisciplinas");
    }

}
