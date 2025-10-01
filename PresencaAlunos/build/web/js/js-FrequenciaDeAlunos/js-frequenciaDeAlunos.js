/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(buscarTodasOsAlunosAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodosOsAlunos",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeAluno);
                $("#selectAluno").append("<option>" + obj.nomeAluno + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            alert("Nao ha alunos cadastrados no sistema.");
        }, beforeSend: function () {
        }
    });
});


$("#selectAluno").change(preencherTabela = function () {
    var selectAluno = $("#selectAluno").val();
    if (selectAluno !== "Selecione o Aluno Desejado...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultarFrequenciaDoAluno?selectAluno=" + selectAluno,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {                    
                    //alert(obj.sala);
                    $('#tabela > tbody').append(
                            '<tr><td>'+obj.idaluno+'</td>\n\
                            <td>'+obj.nomeAluno+'</td>\n\
                            <td>'+obj.status+'</td><\n\
                            <td>'+obj.sala+'</td>\n\
                            <td>'+obj.prova+'</td>\n\
                            <td>'+obj.horarioDoPonto+'</td>\n\
                            <td>'+obj.dataDiaDeProva+'</td></tr>');  
                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Nao ha registros para o Aluno pesquisado!");
            }, beforeSend: function () {
                $("#tabela > tbody > tr").empty();
            }
        });
    } else {
        window.location.reload();
    }
});


$("#aTagVoltar").click(function () {
    var conf = window.confirm("Deseja realmente sair ?");
    if (conf === true) {
        $("#txtIdAluno").empty();
        $("#txtIdturma").empty();
        $("#aTagVoltar").attr("href", "/PresencaAlunos/indexAdm.jsp");
    }
});