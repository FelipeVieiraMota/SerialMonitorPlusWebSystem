/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerCursos;

import ModelBO.CursoBO;
import ModelVO.CursoVO;
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
public class ServletCadastrarCurso extends HttpServlet {

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
        
        System.out.println("Dentro da servlet cadastrar curso =)");
        boolean status;
        HttpSession session = request.getSession();
        String curso = request.getParameter("txtNomeDoCurso");
        String tipoCurso = request.getParameter("txtTipoDeCurso");        
        String duracao = request.getParameter("txtDuracaoDoCurso");
        String qtdSemestres = request.getParameter("txtQtdSemestres");
        String cargaHoraria = request.getParameter("txtCargaHoraria");        
        String observacoes = request.getParameter("txtObservacoes");
        
        CursoVO cursoVo = new CursoVO(curso, tipoCurso, duracao, qtdSemestres,cargaHoraria,observacoes);
        CursoBO cursoBO = new CursoBO();

        status = cursoBO.cadastrarCurso(cursoVo);
        if (status == true) {
            System.out.println("Dentro do if true da servlet cadastrar curso =)");
            session.setAttribute("statusCadastro", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeCursos.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da servlet cadastrar curso =(");
            session.setAttribute("statusCadastro", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeCursos.jsp");
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
