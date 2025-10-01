/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerSemestres;

import ModelBO.SemestreBO;
import ModelVO.SemestreVO;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author felipe
 */
public class ServletCadastraSemestre extends HttpServlet {

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
        boolean status;
        System.out.println("Dentro da servlet cadastrar semestre =)");
        String txtSemestre = request.getParameter("txtSemestre");
        String txtObservacoes = request.getParameter("txtObservacoes");                
        HttpSession session = request.getSession();
        SemestreVO semestreVO = new SemestreVO(txtSemestre,txtObservacoes);
        SemestreBO semestreBO = new SemestreBO();
        status = semestreBO.cadastrarSemestre(semestreVO);
        
        if (status == true) {
            System.out.println("Dentro do if true da servlet cadastrar semestre =)");
            session.setAttribute("statusCadastro", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeSemestres.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da servlet cadastrar semestre =(");
            session.setAttribute("statusCadastro", false);
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
