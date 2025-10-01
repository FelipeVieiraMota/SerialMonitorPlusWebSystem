/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerSala;

import ModelBO.SalaBO;
import ModelVO.SalaVO;
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
public class ServletCadastrarSala extends HttpServlet {

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

        System.out.println("Dentro da ServletCadastrarSala =)");
        boolean status;
        HttpSession session = request.getSession();        
        String selectTipoDeSala = request.getParameter("selectTipoDeSala");
        String txtNumeroDaSala = request.getParameter("txtNumeroDaSala");
        String selectAndarDaSala = request.getParameter("selectAndarDaSala");
        String txtCodigoDaSala = request.getParameter("txtCodigoDaSala");                
        String txtNomeDaSala = request.getParameter("txtNomeDaSala");
        String observacoes = request.getParameter("txtObservacoes");
        
        SalaVO vo = new SalaVO(selectTipoDeSala,txtNumeroDaSala,selectAndarDaSala,txtCodigoDaSala,txtNomeDaSala,observacoes);
        SalaBO bo = new SalaBO();
        status = bo.cadastrarSalaBo(vo);
        
        if (status == true) {
            System.out.println("Dentro do if true da ServletCadastrarSala =)");
            session.setAttribute("statusCadastro", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeSalasDeAula.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da ServletCadastrarSala =(");
            session.setAttribute("statusCadastro", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeSalasDeAula.jsp");
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletCadastrarSala");
        System.out.println("Finalizando a servlet");
    }
}
