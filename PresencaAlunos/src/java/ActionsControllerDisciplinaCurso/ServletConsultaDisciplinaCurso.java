/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerDisciplinaCurso;

import ModelBO.CursoBO;
import ModelBO.DisciplinaCursoBO;
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
public class ServletConsultaDisciplinaCurso extends HttpServlet {

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
        String selectDisciplinasJaCadastradasEmAlgumCurso = request.getParameter("selectDisciplinasJaCadastradasEmAlgumCurso");
        Gson gson = new Gson();
        DisciplinaCursoBO disciplinaCursoBO = new DisciplinaCursoBO();
        ArrayList arrayDisciplinaCurso;
        arrayDisciplinaCurso = disciplinaCursoBO.pesquisarDisciplinaCursoPeloNome(selectDisciplinasJaCadastradasEmAlgumCurso);
        if (!arrayDisciplinaCurso.isEmpty()) {
            String retorno = gson.toJson(arrayDisciplinaCurso);
            System.out.println("JSON: " + retorno);
            response.setContentType("application/json");
            response.getWriter().write(retorno);
        } else {
            System.out.println("Array curso vazio ou nulo = " + arrayDisciplinaCurso);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletConsultarCurso");
        System.out.println("Finalizando a servlet");
    }
}
