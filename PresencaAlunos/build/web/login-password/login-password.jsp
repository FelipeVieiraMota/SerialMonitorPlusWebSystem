<%-- 
    Document   : login-password
    Created on : Oct 21, 2017, 2:02:59 PM
    Author     : felipe
--%>

<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Sempre organizar nessa ordem-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <script src="/PresencaAlunos/jquery/jquery-3.2.1.min.js"></script>               
        <script src="/PresencaAlunos/boot-strap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>        
        <script src="/PresencaAlunos/js/login-password/profile-login-password.js"></script>        
        <link   rel="stylesheet" href="/PresencaAlunos/boot-strap/bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link   rel="stylesheet" href="/PresencaAlunos/my-css/login-password-css.css">
        <title>Sistema para Controle de Presença e Falta de Alunos</title>
    </head>
    <body>  
        <c:choose>
            <c:when test="${usuarioExiste == false}">   
                <c:set var = "usuarioExiste" scope = "session" value = "${null}"/> 
                VarUser: <c:out value="${usuarioExiste}"></c:out>                    
                    <script>
                        window.alert("Usuario inexistente!");
                        window.location.replace("/PresencaAlunos/login-password/login-password.jsp");
                    </script>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <div class="card card-container">                       
                        <img id="profile-img" class="profile-img-card" src="/PresencaAlunos/imgs/login.png" />
                        <p id="profile-name" class="profile-name-card"></p>
                        <div class="container-fluid">                            
                            <form id="formUsuarioSenha" class="form-signin">                                
                                <center><label><font color="#4682B4">Sistema para Controle de Presença de Alunos em Dias de Aplicações de Provas</font></label></center>
                                <span id="reauth-email" class="reauth-email"></span>
                                <input type="text" id="usuario" class="form-control" placeholder="usuario" required autofocus>
                                <input type="password" id="senha" class="form-control" placeholder="senha" required>
                                <div id="remember" class="checkbox">
                                    <font color="#4682B4">
                                        <input type="checkbox" value="lembre-me"> lembre-me
                                    </font>
                                </div>
                                <button id="btnEntrar" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Entre</button>
                            </form><!-- /form -->
                            <a href="#" class="forgot-password">
                                Esqueceu a sua senha?
                            </a><br><br><br>
                            <center></center>        
                        </div><!-- /card-container -->
                    </div><!-- /container -->        
                </div> 
            </c:otherwise>
        </c:choose>    
    </body>
    <script src="/PresencaAlunos/js/login-password/verifica-login-password.js"></script>
</html>
