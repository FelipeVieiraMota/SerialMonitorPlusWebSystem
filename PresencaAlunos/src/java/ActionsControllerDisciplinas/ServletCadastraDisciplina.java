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
public class ServletCadastraDisciplina extends HttpServlet {

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
        
        System.out.println("Dentro da servlet cadastrar disciplina =)");
        boolean status;
        HttpSession session = request.getSession();
        String txtDisciplina = request.getParameter("txtDisciplina");
        String txtAbreviacaoDisciplina = request.getParameter("txtAbreviacaoDisciplina");                
        String txtCargaHorariaDisciplina = request.getParameter("txtCargaHorariaDisciplina");
        String txtObservacoes = request.getParameter("txtObservacoes");
        
        DisciplinaVO disciplinaVO = new DisciplinaVO(txtDisciplina,txtAbreviacaoDisciplina,txtCargaHorariaDisciplina,txtObservacoes);
        DisciplinaBO disciplinaBO = new DisciplinaBO();

        status = disciplinaBO.cadastrarDisciplina(disciplinaVO);
        if (status == true) {
            System.out.println("Dentro do if true da servlet cadastrar disciplina =)");
            session.setAttribute("statusCadastro", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeDisciplinas.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da servlet cadastrar disciplina =(");
            session.setAttribute("statusCadastro", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeDisciplinas.jsp");
            destroy();
        }
    }
    
    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletCadastraDisciplina");
        System.out.println("Finalizando a ServletCadastraDisciplina");
    }
}
