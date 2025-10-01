/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerTurmas;

import ModelBO.TurmaBO;
import ModelVO.TurmaVO;
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
public class ServletCadastrarTurma extends HttpServlet {

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

        System.out.println("Dentro da ServletCadastrarTurma curso =)");
        boolean status;
        HttpSession session = request.getSession();
        int txtIdSemestre = Integer.parseInt(request.getParameter("txtIdSemestre"));
        int txtIdCurso = Integer.parseInt(request.getParameter("txtIdCurso"));        
        String selectAnoSemestre = request.getParameter("selectAnoSemestre");
        String selectCurso = request.getParameter("selectCurso");
        String txtNomeDaTurma = request.getParameter("txtNomeDaTurma");
        String txtAbreviacaoDaTurma = request.getParameter("txtAbreviacaoDaTurma");
        String txtCiclo = request.getParameter("txtCiclo");
        String txtCodigoTurma = request.getParameter("txtCodigoTurma");
        String txtPeriodo = request.getParameter("txtPeriodo");
        String txtObservacoes = request.getParameter("txtObservacoes");

        TurmaVO vo = new TurmaVO(
                 txtIdSemestre,
                 txtIdCurso,
                 selectAnoSemestre,
                 selectCurso,
                 txtNomeDaTurma,
                 txtAbreviacaoDaTurma,
                 txtCiclo,
                 txtPeriodo,
                 txtCodigoTurma,
                 txtObservacoes);

        TurmaBO bo = new TurmaBO();
        status = bo.cadastrarObjetoTurmaBO(vo);

        if (status == true) {
            System.out.println("Dentro do if true da ServletCadastrarTurma =)");
            session.setAttribute("statusCadastro", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeTurmas.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da ServletCadastrarTurmas =(");
            session.setAttribute("statusCadastro", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeTurmas.jsp");
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletCadastrarTurma");
        System.out.println("Finalizando a servlet");
    }
}
