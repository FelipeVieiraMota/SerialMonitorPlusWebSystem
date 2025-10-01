/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionsControllerGradeDeProvas;

import ModelBO.DiaDeProvaBO;
import ModelVO.DiaDeProvaVO;
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
public class ServletAlterarDiaDeProva extends HttpServlet {

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

        System.out.println("Dentro da ServletAlterarDiaDeProva  =)");
        boolean status;
        HttpSession session = request.getSession();
        
        int txtIdDiaDeProva = Integer.parseInt(request.getParameter("txtIdDiaDeProva"));
        int txtIdTurma = Integer.parseInt(request.getParameter("txtIdTurma"));
        int txtIdDisicplina = Integer.parseInt(request.getParameter("txtIdDisicplina"));
        int txtIdProfessor = Integer.parseInt(request.getParameter("txtIdProfessor"));
        int txtIdSala = Integer.parseInt(request.getParameter("txtIdSala"));

        String selectTurma = request.getParameter("selectTurma");
        String selectDisciplina = request.getParameter("selectDisciplina");
        String selectSala = request.getParameter("selectSala");
        String selectProfessor = request.getParameter("selectProfessor");
        String txtProva = request.getParameter("txtProva");
        String txtCodigoDaDiaDeProva = request.getParameter("txtCodigoDaDiaDeProva");
        String txtData = request.getParameter("txtData");
        String selectDiaDaSemana = request.getParameter("selectDiaDaSemana");
        String txtHoraInicioDaProva = request.getParameter("txtHoraInicioDaProva");
        String txtHoraFinalDaProva = request.getParameter("txtHoraFinalDaProva");
        String txtObservacoes = request.getParameter("txtObservacoes");                
        
        System.out.println("H I = "+txtHoraInicioDaProva);
        System.out.println("H F = "+txtHoraFinalDaProva);
        
        
        DiaDeProvaVO vo = new DiaDeProvaVO(
                txtIdDiaDeProva,
                txtIdTurma,
                txtIdDisicplina,
                txtIdProfessor,
                txtIdSala,
                txtData,
                txtHoraInicioDaProva,
                txtHoraFinalDaProva,
                selectTurma,
                selectDisciplina,
                selectProfessor,
                selectSala,
                txtProva,
                selectDiaDaSemana,
                txtCodigoDaDiaDeProva,                                                
                txtObservacoes);

        DiaDeProvaBO bo = new DiaDeProvaBO();
        status = bo.alterarObjetoDiaDeProvaBo(vo);

        if (status == true) {
            System.out.println("Dentro do if true da ServletAlterarDiaDeProva =)");
            session.setAttribute("statusAlteracao", true);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeDiaDeProva.jsp");
            destroy();
        } else {
            System.out.println("Dentro do else (false) da ServletAlterarDiaDeProva =(");
            session.setAttribute("statusAlteracao", false);
            response.sendRedirect("/PresencaAlunos/cadastros/cadastroDeDiaDeProv.jsp");
            destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Destruindo a servlet ServletAlterarDiaDeProva");
        System.out.println("Finalizando a servlet");
    }
}
