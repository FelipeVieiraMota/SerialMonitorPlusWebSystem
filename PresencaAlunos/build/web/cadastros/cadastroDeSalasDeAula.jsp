<%-- 
    Document   : cadastroDeSalasDeAula
    Created on : Dec 5, 2017, 1:47:10 PM
    Author     : felipe
--%>

<%@taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.IOException"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Salas</title>
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
                                <form id="formPesquisarSalas" class="navbar-form" role="search">
                                    <select id="selectSala" name="selectSala" class="form-control">
                                        <option>Selecione a sala desejada...</option>
                                    </select>
                                </form>
                            </div>
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Opções<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Gerar Relatório em pdf</a></li>
                                        <li><a id="aTagVoltar" href="#">Voltar para o menu principal</a></li>
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
                    <div id="idLoad" class="progress">
                        <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div>
                    </div>
                    <h3 class="text-center text-uppercase">Cadastro de Salas</h3>        
                    <form method="POST" action="" id="formCadastrarSala">
                        <div class="form-group" > 
                            <label id="lbIdSala">IdSala</label>
                            <input  type="text"  id="txtIdSala" name="txtIdSala"  class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Codigo da Sala</label>
                            <input  type="text"  id="txtCodigoDaSala" name="txtCodigoDaSala"  placeholder="Gerado após o cadastro." class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Nome da Sala</label>
                            <input  type="text"  id="txtNomeDaSala" name="txtNomeDaSala"  placeholder="Identificação da Sala de Aula." class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Numero da Sala</label>
                            <input  type="number"  id="txtNumeroDaSala" name="txtNumeroDaSala" placeholder="Nº da Sala." class="form-control" required="required">
                        </div> 
                        <div class="form-group"> 
                            <label>Tipo de Sala</label>
                            <select id="selectTipoDeSala" name="selectTipoDeSala" class="form-control">
                                <option>Selecione...</option>
                            </select>
                        </div>
                        <div class="form-group"> 
                            <label>Andar da Sala</label>
                            <select id="selectAndarDaSala" name="selectAndarDaSala" class="form-control">
                                <option>Selecione...</option>
                            </select>
                        </div>                        
                        <div class="form-group"> 
                            <label>Observações</label>
                            <textarea  id="txtObservacoes" name="txtObservacoes" placeholder="Até 255 caractéres." class="form-control" required="required"></textarea>
                        </div><br>
                        <button type="submit" class="btn btn-success btn-lg btn-block" id="btnCadastrar" name="btnCadastrar" value="Cadastrar">Salvar Cadastro</button>                                
                        <button type="submit" class="btn btn-primary btn-lg btn-block" id="btnAlterar" name="btnAlterar" value="Alterar">Salvar Ateração</button>                            
                    </form>
                </div>                                                        
            </c:otherwise> 
        </c:choose>    
    </body> 
    <script src="/PresencaAlunos/js/js-SalasDeAula/js-salasDeAula.js"></script>
    <c:choose>   
        <c:when test="${statusCadastro == true}">           
            <script>
                    window.alert("Sala cadastrada com sucesso!");
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