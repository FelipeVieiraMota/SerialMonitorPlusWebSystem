/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerTurmaAluno;

import ModelBO.AlunoTurmaBO;
import ModelVO.AlunoTurmaVO;
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
public class ServletConsultarTodosOsAlunosEmTodasAsTurmas extends HttpServlet {

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
        AlunoTurmaBO bo = new AlunoTurmaBO();
        ArrayList<AlunoTurmaVO> array;
        array = bo.pesquisarTodosOsAlunosTurmaBo();
        if (!array.isEmpty()) {
            String retorno = gson.toJson(array);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
        } else {
            System.out.println("Array vazio ou nulo = " + array);
        }
        destroy();
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultarTodosOsAlunosEmTodasAsTurmas");
        System.out.println("Finalizando a servlet");
    }
}
