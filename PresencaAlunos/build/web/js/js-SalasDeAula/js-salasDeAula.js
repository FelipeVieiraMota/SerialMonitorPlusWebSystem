/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#lbIdSala").hide();
$("#txtIdSala").hide();
$("#idLoad").hide();
$(document).ready(buscarTodasAsSalasAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodasAsSalas",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                $("#selectSala").append("<option>" + obj.nomeSala + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Nao ha salas cadastradas...");
        }, beforeSend: function () {
        }
    });
});

$(document).ready(buscarTiposDeSalas = function () {
    $.ajax({
        url: "/PresencaAlunos/json/TiposDeSalas.json",
        dataType: "json",
        success: function (retornoJsnoDoJson) {
            $.each(retornoJsnoDoJson, function (index, obj) {
                console.log(obj.tipoDeSala);
                $("#selectTipoDeSala").append("<option>" + obj.tipoDeSala + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {

        }
    });
});

$(document).ready(buscarAndarDasSalas = function () {
    $.ajax({
        url: "/PresencaAlunos/json/AndarDasSalas.json",
        dataType: "json",
        success: function (retornoJsnoDoJson) {
            $.each(retornoJsnoDoJson, function (index, obj) {
                console.log(obj.andar);
                $("#selectAndarDaSala").append("<option>" + obj.andar + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {
        }
    });
});

/*
$("#selectAndarDaSala").change(function () {
    var txtNumeroDaSala = $("#txtNumeroDaSala").val();
    var selectTipoDeSala = $("#selectTipoDeSala").val();
    var selectAndarDaSala = $("#selectAndarDaSala").val();   
    if(txtNumeroDaSala !== "" || selectTipoDeSala !=="Selecione..." || selectTipoDeSala !==""){
            $("#txtNomeDaSala").attr("value", selectTipoDeSala + "-(" + txtNumeroDaSala + ")-" + selectAndarDaSala);
    }
});*/

$("#selectTipoDeSala").change(function () {
    var txtNumeroDaSala = $("#txtNumeroDaSala").val();
    var selectTipoDeSala = $("#selectTipoDeSala").val();
    //var selectAndarDaSala = $("#selectAndarDaSala").val();   
    if(txtNumeroDaSala !== "" || selectTipoDeSala !=="Selecione..." || selectTipoDeSala !==""){
            $("#txtNomeDaSala").attr("value", selectTipoDeSala + "-" + txtNumeroDaSala );
    }
});

$("#selectSala").change(preencherCamposComOsDadosDaSala = function () {
    var selectSala = $("#selectSala").val();
    if (selectSala !== "Selecione a sala desejada...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultarSala?selectSala=" + selectSala,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#idLoad").hide();
                    $("#txtIdSala").attr("value", obj.idSala);
                    $("#txtNomeDaSala").attr("value", obj.nomeSala);
                    $("#txtCodigoDaSala").attr("value", obj.codigoDaSala);
                    $("#selectTipoDeSala").append("<option selected>" + obj.tipoDeSala + "</option>");
                    $("#txtNumeroDaSala").attr("value", obj.numeroDaSala);
                    $("#selectAndarDaSala").append("<option selected>" + obj.andarDaSala + "</option>");
                    $("#txtObservacoes").val(obj.observacoes);
                });
            }, error: function (textStatus, errorThrown) {
                $("#idLoad").hide();
                window.alert("Erro ao buscar registros, contate o suporte! " + textStatus);
            }, beforeSend: function () {
                $("#idLoad").show();
            }
        });
    } else {
        window.location.reload();
    }
});

$("#btnCadastrar").click(function () {
    
    var selectTipoDeSala = $("#selectTipoDeSala").val();
    var txtNumeroDaSala = $("#txtNumeroDaSala").val();
    var selectAndarDaSala = $("#selectAndarDaSala").val();
    var txtObservacoes = $("#txtObservacoes").val();

    if (selectTipoDeSala === "Selecione..."
            || txtNumeroDaSala === ""
            || selectAndarDaSala === "Selecione..."
            || txtObservacoes === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarSala").attr("action"
                , "/PresencaAlunos/ServletCadastrarSala"
                + "?selectTipoDeSala=" + selectTipoDeSala,
                +"&txtNumeroDaSala=" + txtNumeroDaSala,
                +"&selectAndarDaSala=" + selectAndarDaSala,
                +"&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarSala").submit();
    }
});

$("#btnAlterar").click(function () {
    var txtIdSala = $("#txtIdSala").val();
    var selectTipoDeSala = $("#selectTipoDeSala").val();
    var txtNumeroDaSala = $("#txtNumeroDaSala").val();
    var selectAndarDaSala = $("#selectAndarDaSala").val();
    var txtObservacoes = $("#txtObservacoes").val();

    if (selectTipoDeSala === "Selecione..."
            || txtNumeroDaSala === ""
            || selectAndarDaSala === "Selecione..."
            || txtIdSala === ""
            || txtObservacoes === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarSala").attr("action"
                , "/PresencaAlunos/ServletAlterarSala"
                + "?selectTipoDeSala=" + selectTipoDeSala,
                +"&txtNumeroDaSala=" + txtNumeroDaSala,
                +"&selectAndarDaSala=" + selectAndarDaSala,
                +"&txtIdSala="+txtIdSala,
                +"&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarSala").submit();
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