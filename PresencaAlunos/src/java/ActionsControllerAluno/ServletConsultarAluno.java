/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerAluno;

import ModelBO.AlunoBO;
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
public class ServletConsultarAluno extends HttpServlet {

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
        String selectAluno = request.getParameter("selectAluno");
        System.out.println("Aluno = "+selectAluno);
        Gson gson = new Gson();
        AlunoBO bo = new AlunoBO();
        ArrayList array;
        array = bo.pesquisarSomenteNaTabelaAlunoPeloNomeBo(selectAluno);
        if (!array.isEmpty()) {
            String retorno = gson.toJson(array);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
        } else {
            System.out.println("Array aluno vazio ou nulo =( " + array);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultaAluno");
        System.out.println("Finalizando a servlet");
    }
}
