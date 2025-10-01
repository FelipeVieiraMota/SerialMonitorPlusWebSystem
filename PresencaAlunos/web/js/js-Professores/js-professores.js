/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#lbIdProfessor").hide();
$("#txtIdProfessor").hide();

$(document).ready(buscarTodasOsProfessoresAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodosOsProfessores",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeProfessor);
                $("#selectProfessor").append("<option>" + obj.nomeProfessor + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
           window.alert("Nao ha professores cadastrados no sistema.");
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
                $("#selectSexoDoProfessor").append("<option>" + obj.sexo + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {
        }
    });
});

$("#selectProfessor").change(preencherCamposComOsDadosDoProfessor = function () {
    var selectProfessor = $("#selectProfessor").val();
    if (selectProfessor !== "Selecione o professor desejado...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultaProfessor?selectProfessor=" + selectProfessor,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdProfessor").attr("value", obj.idProfessor);
                    $("#txtNomeDoProfessor").attr("value", obj.nomeProfessor);
                    $("#txtCodigoDeMatriculaDoProfessor").attr("value", obj.codigomatriculaProfessor);
                    $("#txtDataDeNascimentoDoProfessor").attr("type", "text");
                    $("#txtDataDeNascimentoDoProfessor").attr("value", obj.dataNascimentoProfessor);
                    $("#txtIdadeDoProfessor").attr("value", obj.idadeProfessor);
                    $("#txtFormacaoProfissionalDoProfessor").attr("value", obj.formacaoProfissionalProfessor);
                    $("#txtEspecializacaoProfissionalDoProfessor").attr("value", obj.especializacaoProfissionalProfessor);
                    $("#txtCpfDoProfessor").attr("value", obj.cpfProfessor);
                    $("#txtRgDoProfessor").attr("value", obj.rgProfessor);
                    $("#selectSexoDoProfessor").append("<option selected>" + obj.sexoProfessor + "</option>");
                    $("#txtCelularDoProfessor").attr("value", obj.celularProfessor);
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

    var txtNomeDoProfessor = $("#txtNomeDoProfessor").val();
    var txtDataDeNascimentoDoProfessor = $("#txtDataDeNascimentoDoProfessor").val();
    var txtIdadeDoProfessor = $("#txtIdadeDoProfessor").val();
    var txtFormacaoProfissionalDoProfessor = $("#txtFormacaoProfissionalDoProfessor").val();
    var txtEspecializacaoProfissionalDoProfessor = $("#txtEspecializacaoProfissionalDoProfessor").val();
    var txtCpfDoProfessor = $("#txtCpfDoProfessor").val();
    var txtRgDoProfessor = $("#txtRgDoProfessor").val();
    var selectSexoDoProfessor = $("#selectSexoDoProfessor").val();
    var txtCelularDoProfessor = $("#txtCelularDoProfessor").val();

    if (txtNomeDoProfessor === ""
            || txtDataDeNascimentoDoProfessor === ""
            || txtIdadeDoProfessor === ""
            || txtFormacaoProfissionalDoProfessor === ""
            || txtEspecializacaoProfissionalDoProfessor === ""
            || txtCpfDoProfessor === ""
            || txtRgDoProfessor === ""
            || selectSexoDoProfessor === "Selecione..."
            || txtCelularDoProfessor === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarProfessor").attr("action"
                , "/PresencaAlunos/ServletCadastrarProfessor"
                + "?txtNomeDoProfessor=" + txtNomeDoProfessor
                + "&txtDataDeNascimentoDoProfessor=" + txtDataDeNascimentoDoProfessor,
                +"&txtIdadeDoProfessor=" + txtIdadeDoProfessor,
                +"&txtFormacaoProfissionalDoProfessor=" + txtFormacaoProfissionalDoProfessor,
                +"&txtEspecializacaoProfissionalDoProfessor=" + txtEspecializacaoProfissionalDoProfessor,
                +"&txtCpfDoProfessor=" + txtCpfDoProfessor,
                +"&txtRgDoProfessor=" + txtRgDoProfessor,
                +"&selectSexoDoProfessor=" + selectSexoDoProfessor
                + "txtCelularDoProfessor" + txtCelularDoProfessor);
        $("#formCadastrarProfessor").submit();
    }
});

$("#btnAlterar").click(function () {

    var txtIdProfessor = $("#txtIdProfessor").val();
    var txtNomeDoProfessor = $("#txtNomeDoProfessor").val();
    var txtDataDeNascimentoDoProfessor = $("#txtDataDeNascimentoDoProfessor").val();
    var txtIdadeDoProfessor = $("#txtIdadeDoProfessor").val();
    var txtFormacaoProfissionalDoProfessor = $("#txtFormacaoProfissionalDoProfessor").val();
    var txtEspecializacaoProfissionalDoProfessor = $("#txtEspecializacaoProfissionalDoProfessor").val();
    var txtCpfDoProfessor = $("#txtCpfDoProfessor").val();
    var txtRgDoProfessor = $("#txtRgDoProfessor").val();
    var selectSexoDoProfessor = $("#selectSexoDoProfessor").val();
    var txtCelularDoProfessor = $("#txtCelularDoProfessor").val();

    if (txtNomeDoProfessor === ""
            || txtDataDeNascimentoDoProfessor === ""
            || txtIdadeDoProfessor === ""
            || txtFormacaoProfissionalDoProfessor === ""
            || txtEspecializacaoProfissionalDoProfessor === ""
            || txtCpfDoProfessor === ""
            || txtRgDoProfessor === ""
            || selectSexoDoProfessor === "Selecione..."
            || txtCelularDoProfessor === ""
            || txtIdProfessor === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarProfessor").attr("action"
                , "/PresencaAlunos/ServletAlteraProfessor"
                + "?txtNomeDoProfessor=" + txtNomeDoProfessor
                + "&txtDataDeNascimentoDoProfessor=" + txtDataDeNascimentoDoProfessor,
                +"&txtIdadeDoProfessor=" + txtIdadeDoProfessor,
                +"&txtFormacaoProfissionalDoProfessor=" + txtFormacaoProfissionalDoProfessor,
                +"&txtEspecializacaoProfissionalDoProfessor=" + txtEspecializacaoProfissionalDoProfessor,
                +"&txtCpfDoProfessor=" + txtCpfDoProfessor,
                +"&txtRgDoProfessor=" + txtRgDoProfessor,
                +"&selectSexoDoProfessor=" + selectSexoDoProfessor,
                +"&txtIdProfessor=" + txtIdProfessor,
                +"txtCelularDoProfessor" + txtCelularDoProfessor);
        $("#formCadastrarProfessor").submit();
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