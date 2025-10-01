<%-- 
    Document   : cadastroDeAlunos
    Created on : Dec 10, 2017, 10:25:06 AM
    Author     : felipe
--%>

<%@taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.IOException"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Cadastros</title>
        <meta http-equiv="Content-Language" content="pt-br">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="/PresencaAlunos/jquery/jquery-3.2.1.min.js"></script> 
        <script src="/PresencaAlunos/boot-strap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>        
        <link rel="stylesheet" href="/PresencaAlunos/boot-strap/bootstrap-3.3.7-dist/css/bootstrap.min.css">                 
    </head>
    <body>
        <c:choose>
            <c:when test="${(usuarioExiste == null )||(usuarioExiste == false)}">
                <c:set var = "usuarioExiste" scope = "session" value = "${'vazio'}"/>
                <script>
                    window.alert("Por favor, realize o login para continuar...");
                    window.location.replace("/PresencaAlunos/login-password/login-password.jsp");
                </script>                 
            </c:when>        
            <c:otherwise>
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>                        
                            </button>
                            <a class="navbar-brand" href="#">Versão 0.3.2(BETA)</a>
                        </div>
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <div class="col-sm-3 col-md-3">
                                <form id="formPesquisarAlunos" class="navbar-form" role="search">
                                    <select id="selectAluno" name="selectAluno" class="form-control">
                                        <option>Selecione o aluno desejado...</option>
                                    </select>
                                </form>
                            </div>
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Opções<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Gerar Relatório em pdf</a></li>
                                        <li><a id="aTagVoltar" href="#">Voltar para o menu principal</a></li>
                                        <li><a href="/PresencaAlunos/cadastros/cadastroDeAlunoTurma.jsp">Vincular Aluno a Turma</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Sobre o software</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Você é o: Administrador</a></li>
                                <li id="idSair"><a href="#"><span class="glyphicon glyphicon-log-in"></span> Sair</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div class = "container">
                    <h3 class="text-center text-uppercase">Cadastro de Alunos</h3>        
                    <form method="POST" action="" id="formCadastrarAluno">
                        <div class="form-group" > 
                            <label id="lbIdAluno">IdAluno</label>
                            <input  type="text"  id="txtIdAluno" name="txtIdAluno"   class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Codigo  de Matricula do Aluno</label>
                            <input  type="text"  id="txtCodigoDeMatriculaDoAluno" name="txtCodigoDeMatriculaDoAluno" placeholder="Gerado após o cadastro" class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Codigo para o cartão RFID do Aluno</label>
                            <input  type="text"  id="txtCodigoCartaoRfidDoAluno" name="txtCodigoCartaoRfidDoAluno"  placeholder="Ex.123456789"class="form-control" value="" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Nome do Aluno </label>
                            <input  type="text"  id="txtNomeDoAluno" name="txtNomeDoAluno"  placeholder="Nome do Aluno" class="form-control" value="" required="required">
                        </div> 
                        <div class="form-group"> 
                            <label>Nome da Mãe</label>
                            <input type="text" id="txtNomeMaeAluno"name="txtNomeMaeAluno" placeholder="Nome da Mãe do Aluno" class="form-control" required="required">
                        </div> 
                        <div class="form-group"> 
                            <label>Nome do Pai</label>
                            <input type="text" id="txtNomePaiAluno" name="txtNomePaiAluno" placeholder="Nome do Pai do Aluno" class="form-control" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>CPF do Aluno </label>
                            <input  type="number"  id="txtCpfDoAluno" name="txtCpfDoAluno"  placeholder="___.___.___-__" class="form-control" value="" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Sexo do Aluno</label>
                            <select id="selectSexoDoAluno" name="selectSexoDoAluno" class="form-control">
                                <option>Selecione...</option>
                            </select>
                        </div>
                        <div class="form-group"> 
                            <label>Idade do Aluno </label>
                            <input  type="text"  id="txtIdadeDoAluno" name="txtIdadeDoAluno"  placeholder="Idade do Aluno" class="form-control" value="" required="required">
                        </div> 
                        <div class="form-group"> 
                            <label>Data de Nascimento do Aluno </label>
                            <input  type="date"  id="txtDataDeNascimentoDoAluno" name="txtDataDeNascimentoDoAluno"  class="form-control" value="" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>E-mail do Aluno </label>
                            <input  type="email"  id="txtemailDoAluno" name="txtemailDoAluno"  placeholder="email do aluno" class="form-control" value="" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Celular do Aluno </label>
                            <input  type="text"  id="txtCelularDoAluno" name="txtCelularDoAluno"  placeholder="__(__)_____-____" class="form-control" value="" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>RG do Aluno </label>
                            <input  type="text"  id="txtRgDoAluno" name="txtRgDoAluno"  placeholder="__.___.___-__" class="form-control" value="" required="required">
                        </div>  
                        <div class="form-group"> 
                            <button type="submit" class="btn btn-success btn-lg btn-block" id="btnCadastrar" name="btnCadastrar" value="Cadastrar">Salvar Cadastro</button><br>
                            <button type="submit" class="btn btn-primary btn-lg btn-block" id="btnAlterar" name="btnAlterar" value="Alterar">Salvar Ateração</button><br>                             
                        </div>
                    </form>
                </div>
            </c:otherwise> 
        </c:choose>    
    </body> 
    <script src="/PresencaAlunos/js/js-Alunos/js-alunos.js"></script>
    <c:choose>   
        <c:when test="${statusCadastro == true}">           
            <script>
                    window.alert("Aluno cadastrado com sucesso!");
            </script>  
            <c:set var = "statusCadastro" scope = "session" value = "${null}"/> 
        </c:when>
        <c:when test="${statusCadastro == false}">           
            <script>
                window.alert("Erro ao salvar os registros! Registros existentes, insira outros registros, por favor!");
            </script>  
            <c:set var = "statusCadastro" scope = "session" value = "${null}"/> 
        </c:when>    
        <c:when test="${statusConsulta == true}">           
            <script>
                window.alert("Registro não encontrado,tente de novo!");
            </script>  
            <c:set var = "statusConsulta" scope = "session" value = "${null}"/> 
        </c:when> 
        <c:when test="${statusAlteracao == true}">           
            <script>
                window.alert("Alterações salvas  com sucesso!");
            </script>  
            <c:set var = "statusAlteracao" scope = "session" value = "${null}"/> 
        </c:when>
        <c:when test="${statusAlteracao == false}">           
            <script>
                window.alert("Erro ao salvar os registros! Talvez esse registro não exista. Verifique na se o curso \n\
              se encontra cadastrado na barra de pesquisa logo acima se não estiver entre em contato com o suporte.");
            </script>  
            <c:set var = "statusAlteracao" scope = "session" value = "${null}"/> 
        </c:when>    
    </c:choose>  
</html>