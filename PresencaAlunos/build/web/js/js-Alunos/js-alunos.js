/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#lbIdAluno").hide();
$("#txtIdAluno").hide();

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

$(document).ready(buscarSexo = function () {
    $.ajax({
        url: "/PresencaAlunos/json/Sexo.json",
        dataType: "json",
        success: function (retornoJsnoDoJson) {
            $.each(retornoJsnoDoJson, function (index, obj) {
                console.log(obj.sexo);
                $("#selectSexoDoAluno").append("<option>" + obj.sexo + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {
        }
    });
});

$("#selectAluno").change(preencherCamposComOsDadosDoAluno = function () {
    var selectAluno = $("#selectAluno").val();
    if (selectAluno !== "Selecione o aluno desejado...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultarAluno?selectAluno=" + selectAluno,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdAluno").attr("value", obj.idAluno);
                    $("#txtCodigoDeMatriculaDoAluno").attr("value", obj.codigoMatriculaAluno);
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
                    $("#txtRgDoAluno").attr("value", obj.rgAluno);

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

$("#btnCadastrar").click(function () {
    // var txtIdAluno = $("#txtIdAluno").val();
    // var txtCodigoDeMatriculaDoAluno = $("#txtCodigoDeMatriculaDoAluno").val();
    var txtCodigoCartaoRfidDoAluno = $("#txtCodigoCartaoRfidDoAluno").val();
    var txtNomeDoAluno = $("#txtNomeDoAluno").val();
    var txtNomeMaeAluno = $("#txtNomeMaeAluno").val();
    var txtNomePaiAluno = $("#txtNomePaiAluno").val();
    var txtCpfDoAluno = $("#txtCpfDoAluno").val();
    var selectSexoDoAluno = $("#selectSexoDoAluno").val();
    var txtIdadeDoAluno = $("#txtIdadeDoAluno").val();
    var txtDataDeNascimentoDoAluno = $("#txtDataDeNascimentoDoAluno").val();
    var txtemailDoAluno = $("#txtemailDoAluno").val();
    var txtCelularDoAluno = $("#txtCelularDoAluno").val();
    var txtRgDoAluno = $("#txtRgDoAluno").val();

    if (txtCodigoCartaoRfidDoAluno === ""
            || txtNomeDoAluno === ""
            || txtNomeMaeAluno === ""
            || txtNomePaiAluno === ""
            || txtCpfDoAluno === ""
            || selectSexoDoAluno === "Selecione..."
            || txtIdadeDoAluno === ""
            || txtDataDeNascimentoDoAluno === ""
            || txtemailDoAluno === ""
            || txtCelularDoAluno === ""
            || txtRgDoAluno === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarAluno").attr("action"
                , "/PresencaAlunos/ServletCadastrarAluno"
                + "?txtCodigoCartaoRfidDoAluno=" + txtCodigoCartaoRfidDoAluno,
                +"&txtNomeDoAluno=" + txtNomeDoAluno,
                +"&txtNomeMaeAluno=" + txtNomeMaeAluno,
                +"&txtNomePaiAluno=" + txtNomePaiAluno,
                +"&txtCpfDoAluno=" + txtCpfDoAluno,
                +"&selectSexoDoAluno=" + selectSexoDoAluno
                + "&txtIdadeDoAluno=" + txtIdadeDoAluno,
                +"&txtDataDeNascimentoDoAluno=" + txtDataDeNascimentoDoAluno,
                +"&txtemailDoAluno=" + txtemailDoAluno,
                +"&txtCelularDoAluno=" + txtCelularDoAluno,
                +"&txtRgDoAluno=" + txtRgDoAluno);
        $("#formCadastrarAluno").submit();
    }
});

$("#btnAlterar").click(function () {
    var txtIdAluno = $("#txtIdAluno").val();
    var txtCodigoDeMatriculaDoAluno = $("#txtCodigoDeMatriculaDoAluno").val();
    var txtCodigoCartaoRfidDoAluno = $("#txtCodigoCartaoRfidDoAluno").val();
    var txtNomeDoAluno = $("#txtNomeDoAluno").val();
    var txtNomeMaeAluno = $("#txtNomeMaeAluno").val();
    var txtNomePaiAluno = $("#txtNomePaiAluno").val();
    var txtCpfDoAluno = $("#txtCpfDoAluno").val();
    var selectSexoDoAluno = $("#selectSexoDoAluno").val();
    var txtIdadeDoAluno = $("#txtIdadeDoAluno").val();
    var txtDataDeNascimentoDoAluno = $("#txtDataDeNascimentoDoAluno").val();
    var txtemailDoAluno = $("#txtemailDoAluno").val();
    var txtCelularDoAluno = $("#txtCelularDoAluno").val();
    var txtRgDoAluno = $("#txtRgDoAluno").val();

    if (txtIdAluno === ""
            || txtCodigoDeMatriculaDoAluno === ""
            || txtCodigoCartaoRfidDoAluno === ""
            || txtNomeDoAluno === ""
            || txtNomeMaeAluno === ""
            || txtNomePaiAluno === ""
            || txtCpfDoAluno === ""
            || selectSexoDoAluno === "Selecione..."
            || txtIdadeDoAluno === ""
            || txtDataDeNascimentoDoAluno === ""
            || txtemailDoAluno === ""
            || txtCelularDoAluno === ""
            || txtRgDoAluno === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarAluno").attr("action","/PresencaAlunos/ServletAlterarAluno"
                + "&txtIdAluno=" + txtIdAluno,
                +"&txtCodigoDeMatriculaDoAluno=" + txtCodigoCartaoRfidDoAluno,
                +"&txtCodigoCartaoRfidDoAluno=" + txtCodigoCartaoRfidDoAluno,
                +"&txtNomeDoAluno=" + txtNomeDoAluno,
                +"&txtNomeMaeAluno=" + txtNomeMaeAluno,
                +"&txtNomePaiAluno=" + txtNomePaiAluno,
                +"&txtCpfDoAluno=" + txtCpfDoAluno,
                +"&selectSexoDoAluno=" + selectSexoDoAluno
                + "&txtIdadeDoAluno=" + txtIdadeDoAluno,
                +"&txtDataDeNascimentoDoAluno=" + txtDataDeNascimentoDoAluno,
                +"&txtemailDoAluno=" + txtemailDoAluno,
                +"&txtCelularDoAluno=" + txtCelularDoAluno,
                +"&txtRgDoAluno=" + txtRgDoAluno);
        $("#formCadastrarAluno").submit();
    }
});

$("#aTagVoltar").click(function () {
    var conf = window.confirm("Deseja realmente sair ?");
    if (conf === true) {
        $("#selectAnoSemestre").empty();
        $("#selectCurso").empty();
        $("#txtNomeDaTurma").empty();
        $("#txtAbreviacaoDaTurma").empty();
        $("#txtCiclo").empty();
        $("#txtPeriodo").empty();
        $("#txtObservacoes").empty();
        $("#aTagVoltar").attr("href", "/PresencaAlunos/indexAdm.jsp");
    }
});
