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
public class ServletConsultarTodasAsTurmas extends HttpServlet {

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
        TurmaBO turmaBO = new TurmaBO();
        ArrayList turmaArrya;
        turmaArrya = turmaBO.pesquisarTodosOsObjetosTurmasEmTodosOsRelacionamentosRetornarObjetoTurmaCompletoBo();
        if (!turmaArrya.isEmpty()) {
            String retorno = gson.toJson(turmaArrya);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
        } else {
            System.out.println("Array turma vazio ou nulo = " + turmaArrya);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultarTodasAsTurmas");
        System.out.println("Finalizando a servlet");
    }
}
