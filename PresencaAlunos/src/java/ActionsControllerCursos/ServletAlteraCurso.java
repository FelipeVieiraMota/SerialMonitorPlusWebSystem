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
public class ServletAlteraCurso extends HttpServlet {

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

        System.out.println("Dentro da servlet alterar curso =)");

        boolean status;
        HttpSession session = request.getSession();
        int txtIdCurso = Integer.parseInt(request.getParameter("txtIdCurso"));
        String curso = request.getParameter("txtNomeDoCurso");
        String tipoCurso = request.getParameter("txtTipoDeCurso");        
        String duracao = request.getParameter("txtDuracaoDoCurso");
        String qtdSemestres = request.getParameter("txtQtdSemestres");
        String cargaHoraria = request.getParameter("txtCargaHoraria");        
        String observacoes = request.getParameter("txtObservacoes");

        CursoVO cursoVo = new CursoVO(txtIdCurso,curso, tipoCurso, duracao, qtdSemestres, cargaHoraria, observacoes);
        CursoBO cursoBO = new CursoBO();

        status = cursoBO.alterarCurso(cursoVo);

        if (status == true) {
            System.out.println("************************************************************");
            System.out.println(" =) Dentro do if (true) da ServletAlteraCurso, tudo ok ! ");
            System.out.println("************************************************************");
            session.setAttribute("statusAlteracao", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeCursos.jsp");
            destroy();
        } else {
            System.out.println("************************************************************");
            System.out.println(" =( Dentro do else (false) da ServletAlteraCurso, algo está errado! ");
            System.out.println("************************************************************");
            session.setAttribute("statusAlteracao", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeCursos.jsp");
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletCadastraSemestre");
        System.out.println("Finalizando a servlet");
    }
}
