<%-- 
    Document   : index
    Created on : Jul 13, 2017, 8:19:49 PM
    Author     : felipe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.IOException"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Escola Web</title>
        <meta charset="utf-8">
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
                            <a class="navbar-brand" href="#">Versão 0.0.1(BETA)</a>
                        </div>
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">Home</a></li>
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastros<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/PresencaAlunos/cadastros/cadastroDeSemestres.jsp">Cadastro de Semestre</a></li>
                                        <li><a href="/PresencaAlunos/cadastros/cadastroDeDisciplinas.jsp">Cadastro de Disciplinas</a></li>
                                        <li><a href="/PresencaAlunos/cadastros/cadastroDeCursos.jsp">Cadastro de Cursos</a></li>
                                        <li><a href="/PresencaAlunos/cadastros/cadastroDeTurmas.jsp">Cadastro de Turmas</a></li>                                        
                                        <li><a href="/PresencaAlunos/cadastros/cadastroDeProfessores.jsp">Cadastro de Professores</a></li>
                                        <li><a href="/PresencaAlunos/cadastros/cadastroDeSalasDeAula.jsp">Cadastro de Salas de Aula</a></li>                                                                                                                        
                                        <li><a href="/PresencaAlunos/cadastros/cadastroDeAlunos.jsp">Cadastro de Alunos</a></li>                                                                                                                                                                
                                    </ul>
                                </li>
                                
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Dias de Provas<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/PresencaAlunos/cadastros/cadastroDeDiaDeProva.jsp">Cadastrar Dia de Prova</a></li>                                                 
                                    </ul>
                                </li>   
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Frequencia de Alunos<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/PresencaAlunos/cadastros/consultaDeFrequenciaDeAlunos.jsp">Consultar Frequencia de Alunos</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Opções<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Configurações de Conta</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Sobre</a></li>
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
                <div class="container container-fluid">                   
                    <h2><label class="">Escola Web - Versão 0.0.1(BETA)</label></h2><br>                    
                </div>                
            </c:otherwise>  
        </c:choose>    
    </body>
    <script src="/PresencaAlunos/js/indexAdm/indexAdm.js"></script>
</html>
