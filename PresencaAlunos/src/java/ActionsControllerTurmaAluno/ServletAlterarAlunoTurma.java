/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerTurmaAluno;

import ModelBO.AlunoTurmaBO;
import ModelVO.AlunoTurmaVO;
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
public class ServletAlterarAlunoTurma extends HttpServlet {
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

        System.out.println("Dentro da ServletAlterarAlunoTurma  =)");
        boolean status;
        HttpSession session = request.getSession();
        int txtIdAluno = Integer.parseInt(request.getParameter("txtIdAluno"));
        int txtIdTurma = Integer.parseInt(request.getParameter("txtIdTurma"));       
        AlunoTurmaVO vo = new AlunoTurmaVO(txtIdAluno,txtIdTurma);
        AlunoTurmaBO bo = new AlunoTurmaBO();
        status = bo.alterarAlunoBo(vo);

        if (status == true) {
            System.out.println("Dentro do if true da ServletAlterarAlunoTurma =)");
            session.setAttribute("statusAlterar", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeAlunoTurma.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da ServletAlterarAlunoTurma =(");
            session.setAttribute("statusAlterar", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeAlunoTurma.jsp");
            destroy();
        }
    }
    
    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletAlterarAlunoTurma");
        System.out.println("Finalizando a servlet");
    }
}
