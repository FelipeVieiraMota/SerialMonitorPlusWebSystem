$("#txtIdCurso").hide();
$("#lbID").hide();

$(document).ready(function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodosOsCursos",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeCurso);
                $("#selectCurso").append("<option>" + obj.nomeCurso + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Nao ha cursos cadastrados no sistema.");
        }, beforeSend: function () {
            $("#txtIdCurso").empty();    
            $("#txtNomeDoCurso").empty();
            $("#txtTipoDeCurso").empty();
            $("#txtDuracaoDoCurso").empty();
            $("#txtQtdSemestres").empty();
            $("#txtCargaHoraria").empty();
            $("#txtCodigoCurso").empty();
            $("#txtObservacoes").empty();
        }
    });
});

$("#selectCurso").change(function () {
    var selectCurso = $("#selectCurso").val();
    if (selectCurso !== "Selecione o Curso desejado...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultaCurso?selectCurso=" + selectCurso,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdCurso").attr("value", obj.idCurso);
                    $("#txtNomeDoCurso").attr("value", obj.nomeCurso);
                    $("#txtTipoDeCurso").attr("value", obj.tipoCurso);
                    $("#txtDuracaoDoCurso").attr("value", obj.duracao);
                    $("#txtQtdSemestres").attr("value", obj.qtdSemestres);
                    $("#txtCargaHoraria").attr("value", obj.cargaHoraria);
                    $("#txtCodigoCurso").attr("value",obj.codigoCurso);
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
    var txtIdCurso = $("#txtIdCurso").val();
    var txtNomeDoCurso = $("#txtNomeDoCurso").val();
    var txtTipoDeCurso = $("#txtTipoDeCurso").val();
    var txtDuracaoDoCurso = $("#txtDuracaoDoCurso").val();
    var txtQtdSemestres = $("#txtQtdSemestres").val();
    var txtCargaHoraria = $("#txtCargaHoraria").val();    
    var txtObservacoes = $("#txtObservacoes").val();

    if (txtNomeDoCurso === ""            
            || txtTipoDeCurso === ""
            || txtDuracaoDoCurso === ""
            || txtQtdSemestres === ""
            || txtCargaHoraria === ""
            || txtObservacoes === "") {
        window.alert("Insira valores nos campos!");
    } else {
        $("#formCadastrarCurso").attr("action"
                , "/PresencaAlunos/ServletAlteraCurso"
                + "?txtNomeDoCurso=" + txtNomeDoCurso
                + "&txtIdCurso="+txtIdCurso,
                + "&txtTipoDeCurso=" + txtTipoDeCurso,
                + "&txtDuracaoDoCurso=" + txtDuracaoDoCurso,
                + "&txtQtdSemestres=" + txtQtdSemestres,
                + "&txtCargaHoraria=" + txtCargaHoraria,               
                + "&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarCurso").submit();
    }
});

$("#btnCadastrar").click(function () {
    var txtIdCurso = $("#txtIdCurso").val();
    var txtNomeDoCurso = $("#txtNomeDoCurso").val();
    var txtTipoDeCurso = $("#txtTipoDeCurso").val();
    var txtDuracaoDoCurso = $("#txtDuracaoDoCurso").val();
    var txtQtdSemestres = $("#txtQtdSemestres").val();
    var txtCargaHoraria = $("#txtCargaHoraria").val();    
    var txtObservacoes = $("#txtObservacoes").val();

    if (txtNomeDoCurso === ""
            || txtTipoDeCurso === ""
            || txtDuracaoDoCurso === ""
            || txtQtdSemestres === ""
            || txtCargaHoraria === ""
            || txtObservacoes === "") {
        window.alert("Insira valores nos campos!");
    } else {
        $("#formCadastrarCurso").attr("action"
                , "/PresencaAlunos/ServletCadastrarCurso"
                + "?txtNomeDoCurso=" + txtNomeDoCurso
                + "&txtIdCurso="+txtIdCurso,
                + "&txtTipoDeCurso=" + txtTipoDeCurso,
                + "&txtDuracaoDoCurso=" + txtDuracaoDoCurso,
                + "&txtQtdSemestres=" + txtQtdSemestres,
                + "&txtCargaHoraria=" + txtCargaHoraria,               
                + "&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarCurso").submit();
    }
});

$("#aTagVoltar").click(function () {
    var conf = window.confirm("Deseja realmente sair ?");
    if (conf === true) {
            $("#txtIdCurso").empty();    
            $("#txtNomeDoCurso").empty();
            $("#txtTipoDeCurso").empty();
            $("#txtDuracaoDoCurso").empty();
            $("#txtQtdSemestres").empty();
            $("#txtCargaHoraria").empty();
            $("#txtCodigoCurso").empty();
            $("#txtObservacoes").empty();
        $("#aTagVoltar").attr("href", "/PresencaAlunos/indexAdm.jsp");
    }
});

$("#aTagVincularUmaDisciplinaAoCurso").click(function () {
    var conf = window.confirm("Deseja realmente sair ?");
    if (conf === true) {
            $("#txtIdCurso").empty();    
            $("#txtNomeDoCurso").empty();
            $("#txtTipoDeCurso").empty();
            $("#txtDuracaoDoCurso").empty();
            $("#txtQtdSemestres").empty();
            $("#txtCargaHoraria").empty();
            $("#txtCodigoCurso").empty();
            $("#txtObservacoes").empty();
        $("#aTagVincularUmaDisciplinaAoCurso").attr("href", "/PresencaAlunos/cadastros/cadastroDeDisciplinaAoCurso.jsp");
    }
});
