package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public final class indexAdm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_scope_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_scope_nobody.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("    <head>\n");
      out.write("        <title>Escola Web</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <script src=\"/PresencaAlunos/jquery/jquery-3.2.1.min.js\"></script> \n");
      out.write("        <script src=\"/PresencaAlunos/boot-strap/bootstrap-3.3.7-dist/js/bootstrap.min.js\"></script>        \n");
      out.write("        <link rel=\"stylesheet\" href=\"/PresencaAlunos/boot-strap/bootstrap-3.3.7-dist/css/bootstrap.min.css\">                \n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("        ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("    \n");
      out.write("    </body>\n");
      out.write("    <script src=\"/PresencaAlunos/js/indexAdm/indexAdm.js\"></script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("  \n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(usuarioExiste == null )||(usuarioExiste == false)}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_set_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                <script>\n");
        out.write("                    window.alert(\"Por favor, realize o login para continuar...\");\n");
        out.write("                    window.location.replace(\"/PresencaAlunos/login-password/login-password.jsp\");\n");
        out.write("                </script>                 \n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_set_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_c_set_0.setVar("usuarioExiste");
    _jspx_th_c_set_0.setScope("session");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${'vazio'}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <nav class=\"navbar navbar-inverse\">\n");
        out.write("                    <div class=\"container-fluid\">\n");
        out.write("                        <div class=\"navbar-header\">\n");
        out.write("                            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
        out.write("                                <span class=\"icon-bar\"></span>\n");
        out.write("                                <span class=\"icon-bar\"></span>\n");
        out.write("                                <span class=\"icon-bar\"></span>                        \n");
        out.write("                            </button>\n");
        out.write("                            <a class=\"navbar-brand\" href=\"#\">Versão 0.0.1(BETA)</a>\n");
        out.write("                        </div>\n");
        out.write("                        <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
        out.write("                            <ul class=\"nav navbar-nav\">\n");
        out.write("                                <li class=\"active\"><a href=\"#\">Home</a></li>\n");
        out.write("                                <li class=\"dropdown\">\n");
        out.write("                                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Cadastros<span class=\"caret\"></span></a>\n");
        out.write("                                    <ul class=\"dropdown-menu\">\n");
        out.write("                                        <li><a href=\"/PresencaAlunos/cadastros/cadastroDeSemestres.jsp\">Cadastro de Semestre</a></li>\n");
        out.write("                                        <li><a href=\"/PresencaAlunos/cadastros/cadastroDeDisciplinas.jsp\">Cadastro de Disciplinas</a></li>\n");
        out.write("                                        <li><a href=\"/PresencaAlunos/cadastros/cadastroDeCursos.jsp\">Cadastro de Cursos</a></li>\n");
        out.write("                                        <li><a href=\"/PresencaAlunos/cadastros/cadastroDeTurmas.jsp\">Cadastro de Turmas</a></li>                                        \n");
        out.write("                                        <li><a href=\"/PresencaAlunos/cadastros/cadastroDeProfessores.jsp\">Cadastro de Professores</a></li>\n");
        out.write("                                        <li><a href=\"/PresencaAlunos/cadastros/cadastroDeSalasDeAula.jsp\">Cadastro de Salas de Aula</a></li>                                                                                                                        \n");
        out.write("                                        <li><a href=\"/PresencaAlunos/cadastros/cadastroDeAlunos.jsp\">Cadastro de Alunos</a></li>                                                                                                                                                                \n");
        out.write("                                    </ul>\n");
        out.write("                                </li>\n");
        out.write("                                \n");
        out.write("                                <li class=\"dropdown\">\n");
        out.write("                                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Dias de Provas<span class=\"caret\"></span></a>\n");
        out.write("                                    <ul class=\"dropdown-menu\">\n");
        out.write("                                        <li><a href=\"/PresencaAlunos/cadastros/cadastroDeDiaDeProva.jsp\">Cadastrar Dia de Prova</a></li>                                                 \n");
        out.write("                                    </ul>\n");
        out.write("                                </li>   \n");
        out.write("                                <li class=\"dropdown\">\n");
        out.write("                                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Frequencia de Alunos<span class=\"caret\"></span></a>\n");
        out.write("                                    <ul class=\"dropdown-menu\">\n");
        out.write("                                        <li><a href=\"/PresencaAlunos/cadastros/consultaDeFrequenciaDeAlunos.jsp\">Consultar Frequencia de Alunos</a></li>\n");
        out.write("                                    </ul>\n");
        out.write("                                </li>\n");
        out.write("                            </ul>\n");
        out.write("                            <ul class=\"nav navbar-nav navbar-right\">\n");
        out.write("                                <li class=\"dropdown\">\n");
        out.write("                                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Opções<b class=\"caret\"></b></a>\n");
        out.write("                                    <ul class=\"dropdown-menu\">\n");
        out.write("                                        <li><a href=\"#\">Configurações de Conta</a></li>\n");
        out.write("                                        <li class=\"divider\"></li>\n");
        out.write("                                        <li><a href=\"#\">Sobre</a></li>\n");
        out.write("                                    </ul>\n");
        out.write("                                </li>\n");
        out.write("                            </ul>\n");
        out.write("                            <ul class=\"nav navbar-nav navbar-right\">\n");
        out.write("                                <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Você é o: Administrador</a></li>\n");
        out.write("                                <li id=\"idSair\"><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Sair</a></li>\n");
        out.write("                            </ul>\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("                </nav>                \n");
        out.write("                <div class=\"container container-fluid\">                   \n");
        out.write("                    <h2><label class=\"\">Escola Web - Versão 0.0.1(BETA)</label></h2><br>                    \n");
        out.write("                </div>                \n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }
}
