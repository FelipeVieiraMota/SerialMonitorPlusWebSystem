/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerTurmas;

import ModelBO.TurmaBO;
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
public class ServletConsultaTurma extends HttpServlet {

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
        String selectTurma = request.getParameter("selectTurma");
        System.out.println("turma = " + selectTurma);
        Gson gson = new Gson();
        TurmaBO turmaBO = new TurmaBO();
        ArrayList turmaArray;
        turmaArray = turmaBO.pesquisarObjetoTurmaPeloNomeRetornarObjetoTurmaBo(selectTurma);
        if (turmaArray.isEmpty()) {
            System.out.println("Array turma vazio ou nulo =( " + turmaArray);
        } else {
            String retorno = gson.toJson(turmaArray);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultaTurma");
        System.out.println("Finalizando a servlet");
    }
}
