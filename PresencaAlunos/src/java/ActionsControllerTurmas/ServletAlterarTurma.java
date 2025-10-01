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
public class ServletAlterarTurma extends HttpServlet {

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

        System.out.println("Dentro da servlet alterar turma =)");

        boolean status;
        HttpSession session = request.getSession();

        int txtIdSemestre = Integer.parseInt(request.getParameter("txtIdSemestre"));
        System.out.println("id Semestre = "+txtIdSemestre);
        int txtIdCurso = Integer.parseInt(request.getParameter("txtIdCurso"));
        int txtIdTurma = Integer.parseInt(request.getParameter("txtIdTurma"));
        String selectAnoSemestre = request.getParameter("selectAnoSemestre");
        String selectCurso = request.getParameter("selectCurso");
        String txtNomeDaTurma = request.getParameter("txtNomeDaTurma");
        String txtAbreviacaoDaTurma = request.getParameter("txtAbreviacaoDaTurma");
        String txtCiclo = request.getParameter("txtCiclo");
        String txtCodigoTurma = request.getParameter("txtCodigoTurma");
        String txtPeriodo = request.getParameter("txtPeriodo");
        String txtObservacoes = request.getParameter("txtObservacoes");

        //TurmaVO vo = objetoTurma(txtIdTurma, txtIdSemestre, txtIdCurso, selectAnoSemestre, selectCurso, txtNomeDaTurma, txtAbreviacaoDaTurma, txtCiclo, txtPeriodo, txtCodigoTurma, txtObservacoes);
        TurmaVO vo = new TurmaVO(
                txtIdTurma,
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
        status = bo.alterarObjetoTurmaBo(vo);

        if (status == true) {
            System.out.println("************************************************************");
            System.out.println(" =) Dentro do if (true) da ServletAlteraTurma, tudo ok ! ");
            System.out.println("************************************************************");
            session.setAttribute("statusAlteracao", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeTurmas.jsp");
            destroy();
        } else {
            System.out.println("************************************************************");
            System.out.println(" =( Dentro do else (false) da ServletAlteraTurma, algo está errado! ");
            System.out.println("************************************************************");
            session.setAttribute("statusAlteracao", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeTurmas.jsp");
            destroy();
        }
    }

    private TurmaVO objetoTurma(int txtIdTurma, int txtIdSemestre, int txtIdCurso, String selectAnoSemestre, String selectCurso, String txtNomeDaTurma, String txtAbreviacaoDaTurma, String txtCiclo, String txtPeriodo, String txtCodigoTurma, String txtObservacoes) {
        TurmaVO vo = new TurmaVO(
                txtIdTurma,
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
        return vo;
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletCadastraSemestre");
        System.out.println("Finalizando a servlet");
    }
}
