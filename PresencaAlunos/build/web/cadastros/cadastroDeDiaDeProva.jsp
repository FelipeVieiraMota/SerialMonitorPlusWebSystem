<%-- 
    Document   : cadastroDeDiasDeProva
    Created on : Nov 4, 2017, 11:45:28 AM
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
                            <a class="navbar-brand" href="#">Versão 0.3.2(BETA)</a>
                        </div>
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <div class="col-sm-3 col-md-3">
                                <form id="formPesquisarDiasDeProva" class="navbar-form" role="search">
                                    <select id="selectDiaDeProva" name="selectDiaDeProva" class="form-control">
                                        <option>Selecione o Dia De Prova desejado...</option>
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
                    <h3 class="text-center text-uppercase">Cadastro de Dias De Prova</h3>        
                    <form method="POST" action="" id="formCadastrarDiaDeProva">
                        <div class="form-group" > 
                            <label id="lbIdDiaDeProva">IdDiaDeProva</label>
                            <input  type="text"  id="txtIdDiaDeProva" name="txtIdDiaDeProva"  class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group" > 
                            <label id="lbIdTurma">IdTurma</label>
                            <input  type="text"  id="txtIdTurma" name="txtIdTurma"  class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group" > 
                            <label id="lbIdDisicplina">IdDisciplina</label>
                            <input  type="text"  id="txtIdDisicplina" name="txtIdDisicplina"  class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group" > 
                            <label id="lbIdProfessor">IdProfessor</label>
                            <input  type="text"  id="txtIdProfessor" name="txtIdProfessor"  class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group" > 
                            <label id="lbIdSala">IdSala</label>
                            <input  type="text"  id="txtIdSala" name="txtIdSala"  class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Codigo Dia De Prova</label>
                            <input  type="text"  id="txtCodigoDaDiaDeProva" name="txtCodigoDaDiaDeProva" placeholder="Gerado após o cadastro."  class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Prova</label>
                            <input  type="text"  id="txtProva" name="txtProva" placeholder="Prova." class="form-control" value="" readonly="true" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Turma</label>
                            <select id="selectTurma" name="selectTurma" class="form-control">
                                <option>Selecione a Turma desejada...</option>
                            </select>
                        </div>
                        <div class="form-group"> 
                            <label>Disciplina</label>
                            <select id="selectDisciplina" name="selectDisciplina" class="form-control">
                                <option>Selecione a Disciplina desejada...</option>
                            </select>
                        </div>
                        <div class="form-group"> 
                            <label>Data</label>
                            <input  type="date"  id="txtData" name="txtData"  class="form-control" value="" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Sala</label>
                            <select id="selectSala" name="selectSala" class="form-control">
                                <option>Selecione a Sala desejada...</option>
                            </select> 
                        </div> 
                        <div class="form-group"> 
                            <label>Professor</label>
                            <select id="selectProfessor" name="selectProfessor" class="form-control">
                                <option>Selecione o Professor desejado...</option>
                            </select>
                        </div> 
                        <div class="form-group"> 
                            <label>Dia da Semana</label>
                            <select id="selectDiaDaSemana" name="selectDiaDaSemana" class="form-control">
                                <option>Selecione o dia desejado...</option>
                            </select> 
                        </div>
                        <div class="form-group"> 
                            <label>Hora Inicial</label>
                            <input  type="text"  id="txtHoraInicioDaProva" name="txtHoraInicioDaProva" placeholder="Horario Inicial : HH:mm:ss" class="form-control" value="" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Hora Final </label>
                            <input  type="text"  id="txtHoraFinalDaProva" name="txtHorafinalDaProva"  placeholder="Horario Final : HH:mm:ss" class="form-control" value="" required="required">
                        </div>
                        <div class="form-group"> 
                            <label>Observações</label>
                            <textarea  id="txtObservacoes" name="txtObservacoes" placeholder="Até 255 caractéres." class="form-control" required="required"></textarea>
                        </div><br>
                        <div class="form-group"> 
                            <button type="submit" class="btn btn-success btn-lg btn-block" id="btnCadastrar" name="btnCadastrar" value="Cadastrar">Salvar Cadastro</button><br>
                            <button type="submit" class="btn btn-primary btn-lg btn-block" id="btnAlterar" name="btnAlterar" value="Alterar">Salvar Ateração</button><br>                             
                        </div>
                    </form>
                </div>                                                         
            </div>
        </c:otherwise> 
    </c:choose>    
</body> 
<script src="/PresencaAlunos/js/js-DiaDeProva/js-diasDeProva.js"></script>
<c:choose>   
    <c:when test="${statusCadastro == true}">           
        <script>
                    window.alert("DiaDeProva cadastrada com sucesso!");
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