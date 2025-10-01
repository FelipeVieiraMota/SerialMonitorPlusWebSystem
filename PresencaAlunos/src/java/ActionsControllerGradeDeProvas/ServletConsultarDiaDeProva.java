/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerGradeDeProvas;

import ModelBO.DiaDeProvaBO;
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
public class ServletConsultarDiaDeProva extends HttpServlet {

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
        String selectDiaDeProva = request.getParameter("selectDiaDeProva");
        System.out.println("selectDiaDeProva = " + selectDiaDeProva);
        Gson gson = new Gson();
        DiaDeProvaBO turmaBO = new DiaDeProvaBO();
        ArrayList array;
        array = turmaBO.pesquisarDiaDeProvaBo(selectDiaDeProva);
        if (array.isEmpty()) {
            System.out.println("Array turma vazio ou nulo =( " + array);
        } else {
            String retorno = gson.toJson(array);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultarDiaDeProva");
        System.out.println("Finalizando a servlet");
    }
}
