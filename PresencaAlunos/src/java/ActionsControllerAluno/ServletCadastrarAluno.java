/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerAluno;

import ModelBO.AlunoBO;
import ModelVO.AlunoVO;
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
public class ServletCadastrarAluno extends HttpServlet {

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

        System.out.println("Dentro da ServletCadastrarAluno  =)");
        boolean status;
        HttpSession session = request.getSession();
        String txtCodigoCartaoRfidDoAluno = request.getParameter("txtCodigoCartaoRfidDoAluno");
        String txtNomeDoAluno = request.getParameter("txtNomeDoAluno");
        String txtNomeMaeAluno = request.getParameter("txtNomeMaeAluno");
        String txtNomePaiAluno = request.getParameter("txtNomePaiAluno");
        String txtCpfDoAluno = request.getParameter("txtCpfDoAluno");
        String selectSexoDoAluno = request.getParameter("selectSexoDoAluno");
        String txtIdadeDoAluno = request.getParameter("txtIdadeDoAluno");
        String txtDataDeNascimentoDoAluno = request.getParameter("txtDataDeNascimentoDoAluno");
        String txtemailDoAluno = request.getParameter("txtemailDoAluno");
        String txtCelularDoAluno = request.getParameter("txtCelularDoAluno");
        String txtRgDoAluno = request.getParameter("txtRgDoAluno");

        AlunoVO vo = new AlunoVO(
                txtNomeDoAluno,
                txtNomeMaeAluno,
                txtNomePaiAluno,
                txtCpfDoAluno,
                selectSexoDoAluno,
                txtIdadeDoAluno,
                txtDataDeNascimentoDoAluno,
                txtemailDoAluno,
                txtCelularDoAluno,
                txtRgDoAluno,
                txtCodigoCartaoRfidDoAluno);

        AlunoBO bo = new AlunoBO();
        status = bo.cadastrarObjetoAlunoBO(vo);

        if (status == true) {
            System.out.println("Dentro do if true da ServletCadastrarAluno =)");
            session.setAttribute("statusCadastro", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeAlunos.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da ServletCadastrarAluno =(");
            session.setAttribute("statusCadastro", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeAlunos.jsp");
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletCadastrarAluno");
        System.out.println("Finalizando a servlet");
    }
}
