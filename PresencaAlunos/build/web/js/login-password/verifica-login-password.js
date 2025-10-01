/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*window.onload = function () {
 window.alert("aqui!");
 if (sessionScope.resultado == "usuario inexistente!") {
 window.alert("Usuario inexistente! Tente de novo por favor.");
 }
 };*/

var submitarUsuarioSenha = function () {
    var usuario = document.getElementById("usuario").value;
    var senha = document.getElementById("senha").value;
    //alert("apos o submitar"+" usr = "+usuario+" senha = "+senha );
    var caminho = "/PresencaAlunos/ServletLoginPassword?usuario=" + usuario + "&senha=" + senha;
    // alert("apos o submitar");
    document.getElementById("formUsuarioSenha").method = "POST";
    document.getElementById("formUsuarioSenha").action = caminho;
    // alert(caminho);
    document.getElementById("formUsuarioSenha").onsubmit;
};

var assimilarComandos = function () {
    document.getElementById("btnEntrar").onclick = submitarUsuarioSenha;
    //alert("teste");
};

assimilarComandos();