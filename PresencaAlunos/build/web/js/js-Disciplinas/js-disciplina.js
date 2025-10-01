
$("#txtIdDisciplina").hide();
$("#lbID").hide();

$(document).ready(function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodasAsDisciplinas",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeDisciplina);
                $("#selectDisciplina").append("<option>" + obj.nomeDisciplina + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Nao ha disciplinas cadastradas no sistema.");
        }, beforeSend: function () {
            $("#txtIdDisciplina").empty();
            $("#txtCodigoDisciplina").empty();
            $("#txtDisciplina").empty();
            $("#txtAbreviacaoDisciplina").empty();
            $("#txtCodigoDisicplina").empty();
            $("#txtCargaHorariaDisciplina").empty();
            $("#txtObservacoes").empty();
        }
    });
});

$("#selectDisciplina").change(function () {
    var selectDisciplina = $("#selectDisciplina").val();
    if (selectDisciplina !== "Selecione a Disciplina desejada...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultaDisciplinas?selectDisciplina=" + selectDisciplina,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdDisciplina").attr("value", obj.idDisciplina);
                    $("#txtCodigoDisciplina").attr("",obj.codigoDisciplina);
                    $("#txtDisciplina").attr("value", obj.nomeDisciplina);
                    $("#txtAbreviacaoDisciplina").attr("value", obj.abreviacaoDisciplina);
                    $("#txtCodigoDisicplina").attr("value", obj.codigoDisicplina);
                    $("#txtCargaHorariaDisciplina").attr("value", obj.cargaHorariaDisciplina);                    
                    $("#txtObservacoes").val(obj.observacoes);
                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
            }, beforeSend: function () {

            }
        });
    } else {
        window.location.reload();
    }
});

$("#btnAlterar").click(function () {
    var txtIdDisciplina = $("#txtIdDisciplina").val();
    var txtDisciplina = $("#txtDisciplina").val();
    var txtAbreviacaoDisciplina = $("#txtAbreviacaoDisciplina").val();    
    var txtCargaHorariaDisciplina = $("#txtCargaHorariaDisciplina").val();
    var txtObservacoes = $("#txtObservacoes").val();
    if (txtDisciplina === ""
            || txtAbreviacaoDisciplina === ""
            || txtCargaHorariaDisciplina === ""
            || txtObservacoes === "") {
        window.alert("Insira valores nos campos!");
    } else {
        $("#formCadastrarDisciplina").attr("action"
                , "/PresencaAlunos/ServletAlteraDisciplinas"
                + "?txtDisciplina=" + txtDisciplina
                + "&txtIdDisciplina=" + txtIdDisciplina,
                + "&txtAbreviacaoDisciplina=" + txtAbreviacaoDisciplina,                
                +"&txtCargaHorariaDisciplina=" + txtCargaHorariaDisciplina,
                +"&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarDisciplina").submit();
    }
});

$("#btnCadastrar").click(function () {    
    var txtDisciplina = $("#txtDisciplina").val();
    var txtAbreviacaoDisciplina = $("#txtAbreviacaoDisciplina").val();    
    var txtCargaHorariaDisciplina = $("#txtCargaHorariaDisciplina").val();
    var txtObservacoes = $("#txtObservacoes").val();
    if (txtDisciplina === ""
            || txtAbreviacaoDisciplina === ""                       
            || txtCargaHorariaDisciplina === ""
            || txtObservacoes === "") {
        window.alert("Insira valores nos campos!");
    } else {
        $("#formCadastrarDisciplina").attr("action"
                , "/PresencaAlunos/ServletCadastraDisciplina"
                + "?txtDisciplina=" + txtDisciplina
                + "&txtAbreviacaoDisciplina=" + txtAbreviacaoDisciplina,                
                +"&txtCargaHorariaDisciplina=" + txtCargaHorariaDisciplina,
                +"&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarDisciplina").submit();
    }
});

$("#aTagVoltar").click(function () {
    var conf = window.confirm("Deseja realmente sair ?");
    if (conf === true) {
            $("#txtIdDisciplina").empty();
            $("#txtCodigoDisciplina").empty();
            $("#txtDisciplina").empty();
            $("#txtAbreviacaoDisciplina").empty();
            $("#txtCodigoDisicplina").empty();
            $("#txtCargaHorariaDisciplina").empty();
            $("#txtObservacoes").empty();
        $("#aTagVoltar").attr("href", "/PresencaAlunos/indexAdm.jsp");
    }
});

