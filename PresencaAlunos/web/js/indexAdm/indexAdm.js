/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var sairDaTelaDeIndexAdm = function () {
    var resposta = window.confirm("Deseja realmente sair ?");
    if (resposta) {
        window.location.replace("/PresencaAlunos/ServletSairIndexAdm");
    }
};

var assimilarComandos = function () {
    document.getElementById("idSair").onclick = sairDaTelaDeIndexAdm;
};

assimilarComandos();