/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerProfessor;

import ModelBO.ProfessorBO;
import ModelVO.ProfessorVO;
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
public class ServletCadastrarProfessor extends HttpServlet {

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

        System.out.println("Dentro da ServletCadastrarProfessor  =)");
        boolean status;
        HttpSession session = request.getSession();
        String txtNomeDoProfessor = request.getParameter("txtNomeDoProfessor");
        String txtCodigoDeMatriculaDoProfessor = request.getParameter("txtCodigoDeMatriculaDoProfessor");
        String txtDataDeNascimentoDoProfessor = request.getParameter("txtDataDeNascimentoDoProfessor");
        int txtIdadeDoProfessor = Integer.parseInt(request.getParameter("txtIdadeDoProfessor"));
        String txtFormacaoProfissionalDoProfessor = request.getParameter("txtFormacaoProfissionalDoProfessor");
        String txtEspecializacaoProfissionalDoProfessor = request.getParameter("txtEspecializacaoProfissionalDoProfessor");
        String txtCpfDoProfessor = request.getParameter("txtCpfDoProfessor");
        String txtRgDoProfessor = request.getParameter("txtRgDoProfessor");
        String selectSexoDoProfessor = request.getParameter("selectSexoDoProfessor");
        String txtCelularDoProfessor = request.getParameter("txtCelularDoProfessor");

        ProfessorVO vo = new ProfessorVO(
                txtNomeDoProfessor,
                txtIdadeDoProfessor,
                txtDataDeNascimentoDoProfessor,
                txtFormacaoProfissionalDoProfessor,
                txtEspecializacaoProfissionalDoProfessor,
                txtCpfDoProfessor,
                txtRgDoProfessor,
                selectSexoDoProfessor,
                txtCelularDoProfessor,
                txtCodigoDeMatriculaDoProfessor);
        ProfessorBO bo = new ProfessorBO();
        status = bo.cadastrarObjetoProfessorBO(vo);

        if (status == true) {
            System.out.println("Dentro do if true da ServletCadastrarProfessor =)");
            session.setAttribute("statusCadastro", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeProfessores.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da ServletCadastrarProfessor =(");
            session.setAttribute("statusCadastro", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeProfessores.jsp");
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletCadastrarProfessor");
        System.out.println("Finalizando a servlet");
    }
}
