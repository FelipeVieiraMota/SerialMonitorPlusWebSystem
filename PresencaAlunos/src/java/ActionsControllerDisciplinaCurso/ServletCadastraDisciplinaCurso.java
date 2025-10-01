/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerDisciplinaCurso;

import ModelBO.DisciplinaCursoBO;
import ModelVO.DisciplinaCursoVO;
import java.io.IOException;
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
public class ServletCadastraDisciplinaCurso extends HttpServlet {

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

        System.out.println("Dentro da servlet cadastraDisciplinaCurso curso =)");
        boolean status;
        int txtIdCurso = Integer.parseInt(request.getParameter("txtIdCurso"));
        int txtIdDisciplina = Integer.parseInt(request.getParameter("txtIdDisciplina"));
        System.out.println("id Curso = " + txtIdCurso);
        System.out.println("id Disciplina = " + txtIdDisciplina);
        String txtDisciplinaCurso = request.getParameter("txtDisciplinaCurso");
        String observacoes = request.getParameter("txtObservacoes");
        HttpSession session = request.getSession();

        DisciplinaCursoVO disciplinaCursoVO = new DisciplinaCursoVO(txtIdDisciplina,txtIdCurso, txtDisciplinaCurso, observacoes);
        DisciplinaCursoBO disciplinaCursoBO = new DisciplinaCursoBO();

        status = disciplinaCursoBO.cadastrarDisciplinaCurso(disciplinaCursoVO);
        if (status == true) {
            System.out.println("Dentro do if true da servlet cadastraDisciplinaCurso curso =)");
            session.setAttribute("statusCadastro", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeDisciplinaAoCurso.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da servlet cadastrar curso =(");
            session.setAttribute("statusCadastro", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeDisciplinaAoCurso.jsp");
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletCadastrarCurso");
        System.out.println("Finalizando a servlet");
    }
}
