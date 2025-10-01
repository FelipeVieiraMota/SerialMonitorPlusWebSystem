/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerProfessor;

import ModelBO.ProfessorBO;
import com.google.gson.Gson;
import java.io.IOException;
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
public class ServletConsultarTodosOsProfessores extends HttpServlet {

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
        Gson gson = new Gson();
        ProfessorBO professorBO = new ProfessorBO();
        ArrayList professorArrya;
        professorArrya = professorBO.pesquisarTodosOsObjetosProfessoresSemParametroSomenteNaTabelaProfessorRetornarObjetoProfessorCompletoBo();
        if (!professorArrya.isEmpty()) {
            String retorno = gson.toJson(professorArrya);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
        } else {
            System.out.println("Array turma vazio ou nulo = " + professorArrya);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultarTodasAsTurmas");
        System.out.println("Finalizando a servlet");
    }
}
