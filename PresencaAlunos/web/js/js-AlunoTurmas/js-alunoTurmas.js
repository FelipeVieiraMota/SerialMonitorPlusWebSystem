/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 $("#lbIdTurma").hide();
 $("#txtIdTurma").hide();
 $("#lbIdAluno").hide();
 $("#txtIdAluno").hide();
 

$(document).ready(buscartodosOsAlunosCadastradosEmTurmas = function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodosOsAlunosEmTodasAsTurmas  ",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeAluno);
                $("#selectAlunoCadastrado").append("<option>" + obj.nomeAluno + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            alert("Nao ha alunos cadastrados no sistema.");
        }, beforeSend: function () {
        }
    });
});

$(document).ready(buscarTodasAsTurmasAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodasAsTurmas",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeTurma);
                $("#selectTurma").append("<option>" + obj.nomeTurma + "</option>");

            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Nao ha turmas cadastradas no sistema.");
        }, beforeSend: function () {
            $("#txtNomeDaTurma").empty();
            $("#txtAbreviacaoDaTurma").empty();
            $("#txtObservacoes").empty();
        }
    });
});

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

$("#selectAlunoCadastrado").change(preencherCamposComOsDadosDoAluno = function () {
    var selectAlunoCadastrado = $("#selectAlunoCadastrado").val();
    //alert(selectAlunoCadastrado);
    if (selectAlunoCadastrado !== "Selecione...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultarAlunoEmRelacaoTurma?selectAluno=" + selectAlunoCadastrado,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdAluno").attr("value", obj.idAluno);
                    $("#txtIdTurma").attr("value", obj.idTurma);
                    $("#selectAluno").append("<option selected>" + obj.nomeAluno + "</option>");
                    $("#selectTurma").append("<option selected>" + obj.turma + "</option>");
                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Erro ao buscar registros, contate o suporte! " + textStatus);
            }, beforeSend: function () {
                
            }
        });
    } else {
        window.location.reload();
    }
});

$("#selectAluno").change(preencherCamposComOsDadosDoAluno = function () {
    var selectAluno = $("#selectAluno").val();
    if (selectAluno !== "Selecione o Aluno desejado...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultarAluno?selectAluno=" + selectAluno,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdAluno").attr("value", obj.idAluno);
                    /* $("#txtCodigoDeMatriculaDoAluno").attr("value", obj.codigoMatriculaAluno);
                     $("#txtCodigoCartaoRfidDoAluno").attr("value", obj.codigoCartaoRfidAluno);
                     $("#txtNomeDoAluno").attr("value", obj.nomeAluno);
                     $("#txtNomeMaeAluno").attr("value", obj.nomeMaeAluno);
                     $("#txtNomePaiAluno").attr("value", obj.nomePaiAluno);
                     $("#txtCpfDoAluno").attr("value", obj.cpfAluno);
                     $("#selectSexoDoAluno").append("<option selected>" + obj.sexoAluno + "</option>");
                     $("#txtIdadeDoAluno").attr("value", obj.idadeAluno);
                     $("#txtDataDeNascimentoDoAluno").attr("type", "text");
                     $("#txtDataDeNascimentoDoAluno").attr("value", obj.dataNascimentoAluno);
                     $("#txtemailDoAluno").attr("value", obj.emailAluno);
                     $("#txtCelularDoAluno").attr("value", obj.celularAluno);
                     $("#txtRgDoAluno").attr("value", obj.rgAluno);*/

                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Erro ao buscar registros, contate o suporte! " + textStatus);
            }, beforeSend: function () {

            }
        });
    } else {
        window.location.reload();
    }
});

$("#selectTurma").change(function () {
    var selectTurma = $("#selectTurma").val();
    if (selectTurma !== "Selecione a Turma desejada...") {
        console.log("aqui em select selectTurma");
        console.log("selectTurma : " + selectTurma);
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultaTurma?selectTurma=" + selectTurma,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdTurma").attr("value", obj.idTurma);
                    /*$("#txtIdCurso").attr("value", obj.idCurso);
                     $("#txtIdSemestre").attr("value", obj.idSemestre);
                     $("#txtCodigoDaTurma").attr("value", obj.codigoTurma);
                     $("#selectAnoSemestre").append("<option>" + obj.anoSemestre + "</option>");
                     $("#selectCurso").append("<option>" + obj.curso + "</option>");
                     $("#txtNomeDaTurma").attr("value", obj.nomeTurma);
                     $("#txtAbreviacaoDaTurma").attr("value", obj.abreviacaoTurma);
                     $("#txtCiclo").append("<option>" + obj.ciclo + "</option>");
                     $("#txtPeriodo").append("<option>" + obj.periodo + "</option>");
                     $("#txtObservacoes").val(obj.observacoes);*/
                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Erro ao buscar registros, contate o suporte! " + textStatus);
            }, beforeSend: function () {
                $("#txtCodigoDaTurma").empty();
                $("#selectAnoSemestre").empty();
                $("#selectCurso").empty();
                $("#txtNomeDaTurma").empty();
                $("#txtAbreviacaoDaTurma").empty();
                $("#txtCiclo").empty();
                $("#txtPeriodo").empty();
                $("#txtObservacoes").empty();
            }
        });
    } else {
        window.location.reload();
    }
});

$("#btnCadastrar").click(function () {
    var txtIdTurma = $("#txtIdTurma").val();
    var txtIdAluno = $("#txtIdAluno").val();

    if (txtIdTurma === "" && txtIdAluno === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarAlunoTurma").attr("action"
                , "/PresencaAlunos/ServletVincularAlunoTurma"
                + "?txtIdTurma=" + txtIdTurma
                + "&txtIdAluno=" + txtIdAluno);
        $("#formCadastrarAlunoTurma").submit();
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