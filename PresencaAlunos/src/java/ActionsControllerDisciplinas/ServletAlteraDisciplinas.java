/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerDisciplinas;

import ModelBO.DisciplinaBO;
import ModelVO.DisciplinaVO;
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
public class ServletAlteraDisciplinas extends HttpServlet {

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
        
        System.out.println("Dentro da servlet alterara disciplina =)");
        boolean status;
        HttpSession session = request.getSession();
        int idDisciplina = Integer.parseInt(request.getParameter("txtIdDisciplina"));
        String txtDisciplina = request.getParameter("txtDisciplina");
        String txtAbreviacaoDisciplina = request.getParameter("txtAbreviacaoDisciplina");                
        String txtCargaHorariaDisciplina = request.getParameter("txtCargaHorariaDisciplina");
        String txtObservacoes = request.getParameter("txtObservacoes");

        DisciplinaVO disciplinaVO = new DisciplinaVO(idDisciplina,txtDisciplina,txtAbreviacaoDisciplina,txtCargaHorariaDisciplina,txtObservacoes);
        DisciplinaBO disciplinaBO = new DisciplinaBO();

        status = disciplinaBO.alterarDisciplina(disciplinaVO);

        if (status == true) {
            System.out.println("************************************************************");
            System.out.println(" =) Dentro do if (true) da ServletAlteraDisciplinas, tudo ok ! ");
            System.out.println("************************************************************");
            session.setAttribute("statusAlteracao", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeDisciplinas.jsp");
            destroy();
        } else {
            System.out.println("************************************************************");
            System.out.println(" =( Dentro do else (false) da ServletAlteraDisciplinas, algo está errado! ");
            System.out.println("************************************************************");
            session.setAttribute("statusAlteracao", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeDisciplinas.jsp");
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
