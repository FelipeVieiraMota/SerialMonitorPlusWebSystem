/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerSemestres;

import ModelBO.SemestreBO;
import ModelVO.SemestreVO;
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
public class ServletAlteraSemestre extends HttpServlet {

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

        System.out.println("Dentro da servlet alterar semestre =)");
        boolean status;
        int txtIdSemestre = Integer.parseInt(request.getParameter("txtIdSemestre"));
        String txtSemestre = request.getParameter("txtSemestre");
        String txtObservacoes = request.getParameter("txtObservacoes");        
        SemestreVO semestreVO = new SemestreVO(txtIdSemestre, txtSemestre, txtObservacoes);
        SemestreBO semestreBO = new SemestreBO();
        status = semestreBO.alterarSemestre(semestreVO);
        HttpSession session = request.getSession();

        if (status == true) {
            System.out.println("************************************************************");
            System.out.println(" =) Dentro do if (true) da ServletAlteraSemestre semestre ");
            System.out.println("************************************************************");
            session.setAttribute("statusAlteracao", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeSemestres.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da ServletAlteraSemestre  semestre =(");
            session.setAttribute("statusAlteracao", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeSemestres.jsp");
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
