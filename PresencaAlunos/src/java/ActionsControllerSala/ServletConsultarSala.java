/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerSala;

import ModelBO.ProfessorBO;
import ModelBO.SalaBO;
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
public class ServletConsultarSala extends HttpServlet {

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
        String selectSala = request.getParameter("selectSala");
        System.out.println("Sala = "+selectSala);
        Gson gson = new Gson();
        SalaBO bo = new SalaBO();
        ArrayList array;
        array = bo.pesquisarSalaPeloNome(selectSala);
        if (!array.isEmpty()) {
            String retorno = gson.toJson(array);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
        } else {
            System.out.println("Array sala vazio ou nulo =( " + array);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultarSala");
        System.out.println("Finalizando a servlet");
    }
}
