<%-- 
    Document   : index
    Created on : May 5, 2017, 11:08:31 AM
    Author     : felipevieiramota
    https://www.youtube.com/watch?v=Ux8B3P9y5WE
--%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.ArrayList"%>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   
    </head>
    <body>
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>                        
                </button>
                <a class="navbar-brand" href="#">Escola Web v0.3.2(BETA)</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">PAGINA DE CONSULTA DE FREQUENCIA DE ALUNOS</a></li>
                    <li><a href="/PresencaAlunos/indexAdm.jsp">Voltar</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span>Administrador</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> LogOff</a></li>      
                </ul>
            </div>
        </div>
     </nav>               
        <div class = "container">
            <h3 class="text-center text-uppercase">Consultar Dados do Aluno</h3>
                <form method="POST" action="/Escola/ServletConsultarAlunos" name="consultar">
                    <div id="contato"> <!--Criar uma borda ou mudar contato p/cadastro-->
                        <div class="form-group">                     
                            <div class="form-group">
                                <label>Codigo de Matricula</label>
                                <input type="number" name="codigoMatriculaNome" class="form-control" required="required">
                            </div>  
                            <button class="btn btn-primary" type="submit" name="consultar">CONSULTAR</button>                                
                        </div>                                                           
                    </div>
                </form>
        </div>       
        <div class="container">            
            <div class="table-responsive">            
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>MATRICULA</th>
                            <th>NOME</th>
                            <th>SOBRE NOME</th>
                            <th>NOME DA MAE</th>
                            <th>NOME DO PAI</th>
                            <th>IDADE</th>
                            <th>CPF</th>
                            <th>SEXO</th>
                            <th>EMAIL</th>
                            <th>CELULAR</th>
                        </tr>
                    </thead>                    
                    <c:forEach var ="lista" items="${aluno}">       
                        <tr>
                            <td><c:out value="${lista.idAluno}"/></td>
                            <td><c:out value="${lista.codigoMatricula}"/></td>                            
                            <td><c:out value="${lista.nome}"/></td>
                            <td><c:out value="${lista.sobreNome}"/></td>
                            <td><c:out value="${lista.nomeMae}"/></td>
                            <td><c:out value="${lista.nomePai}"/></td>
                            <td><c:out value="${lista.idade}"/></td>
                            <td><c:out value="${lista.cpf}"/></td>
                            <td><c:out value="${lista.sexo}"/></td>
                            <td><c:out value="${lista.email}"/></td>
                            <td><c:out value="${lista.celular}"/></td>                         
                        </tr>
                    </c:forEach>    
                </table>
                                     
           </div>   
        </div>
    </body>
</html>
