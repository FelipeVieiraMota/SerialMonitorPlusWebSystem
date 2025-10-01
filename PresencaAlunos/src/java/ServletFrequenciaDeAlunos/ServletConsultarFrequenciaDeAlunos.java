/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletFrequenciaDeAlunos;

import ModelBO.FrequenciaBO;
import ModelVO.FrequenciaVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author felipe
 */
public class ServletConsultarFrequenciaDeAlunos extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, HTTPException {           

            System.out.println("dentro da servlet consultar");              
            String valor = request.getParameter("codigoMatriculaNome");
            System.out.println("***********************");
            System.out.println("VALOR: "+valor);              
            System.out.println("***********************");
            String regra = "[0-9]*";
            boolean teste = valor.matches(regra);
            System.out.println("teste = "+teste);
            FrequenciaBO bo = new FrequenciaBO();
            ArrayList <FrequenciaVO>array;
            String nomeAluno="";
            int codigoMatriculaNome=0;
           /*             
            if(teste){
                 codigoMatriculaNome = Integer.parseInt(valor);
                 System.out.println("codigo matricula = "+codigoMatriculaNome);
            }else{
                 nomeAluno = String.valueOf(valor);
                 System.out.println("nome = "+nomeAluno);
            }                               
                            */          
           // array= bo.consultarFrequencia(codigoMatriculaNome); 
            
           // System.out.println("array de retorno: "+array);

          /* if(array == null){
                System.out.println("if array null =(");
                request.getSession().setAttribute("codigomatricula",codigoMatriculaNome);
                response.sendRedirect("/Escola/Aluno/AcoesAluno/consultaErro.jsp");
                destroy();
           }else if(array.isEmpty()) {
            System.out.println("if array vazio =(");    
                request.getSession().setAttribute("codigomatricula",codigoMatriculaNome);
                response.sendRedirect("/Escola/Aluno/AcoesAluno/consultaErro.jsp");
                destroy();
           }else{
                System.out.println("Estamos no else , está tudo ok ....");  
                request.getSession().setAttribute("aluno",array);
                response.sendRedirect("/PresencaAlunos/cadastros/consultarFrequenciaDeAlunos.jsp");
                destroy();
            }*/
        destroy();   
    }
    /**
     * Destroy our class
     */
   @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destroying our Servlet Class on the server");
    }
}
