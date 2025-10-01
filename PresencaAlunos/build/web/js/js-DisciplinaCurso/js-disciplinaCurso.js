/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#divIdCurso").hide();
$("#divIdDisciplina").hide();

$(document).ready(function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodosAsDisciplinasCadastradasNosCursos",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeDisciplina);
                $("#selectDisciplinasJaCadastradasEmAlgumCurso").append("<option>" + obj.disciplinaCurso + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Nao ha cursos vinculados a disciplinas cadastrados no sistema.");
        }, beforeSend: function () {
            $("#txtIdDisciplina").empty();
            $("#txtCodigoDisciplina").empty();
            $("#txtDisciplina").empty();
            $("#txtAbreviacaoDisciplina").empty();
            $("#txtCodigoDisciplina").empty();
            $("#txtCargaHorariaDisciplina").empty();
            $("#txtObservacoes").empty();
        }
    });
});

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
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {
            $("#txtIdDisciplina").empty();
            $("#txtCodigoDisciplina").empty();
            $("#txtDisciplina").empty();
            $("#txtAbreviacaoDisciplina").empty();
            $("#txtCodigoDisciplina").empty();
            $("#txtCargaHorariaDisciplina").empty();
            $("#txtObservacoes").empty();
        }
    });
});

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
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
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

$("#selectDisciplinasJaCadastradasEmAlgumCurso").change(function () {
    var selectDisciplinasJaCadastradasEmAlgumCurso = $("#selectDisciplinasJaCadastradasEmAlgumCurso").val();
    if (selectDisciplinasJaCadastradasEmAlgumCurso !== "Disciplinas já cadastradas nos Cursos") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultaDisciplinaCurso?selectDisciplinasJaCadastradasEmAlgumCurso=" + selectDisciplinasJaCadastradasEmAlgumCurso,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdCurso").attr("value", obj.idCurso); 
                    $("#txtCodigoDoCurso").attr("value", obj.codigoCurso);
                    $("#selectCurso").append("<option>"+obj.curso+"</option>");
                    $("#txtIdDisciplina").attr("value", obj.idDisciplina);                    
                    $("#txtCodigoDisciplina").attr("value", obj.codigoDisciplina);
                    $("#selectDisciplina").append("<option>" + obj.disciplina + "</option>");
                    $("#txtAbreviacaoDisciplina").attr("value", obj.abreviacaoDisciplina);                    
                    $("#txtCargaHorariaDisciplina").attr("value", obj.cargaHorariaDisciplina);                                                            
                    $("#txtDisciplinaCurso").attr("value",obj.disciplinaCurso);
                    $("#txtObservacoes").val(obj.observacoes);
                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
            }, beforeSend: function () {
                $("#selectCurso").empty();
                $("#selectDisciplina").empty();   
            }
        });
    } else {
        window.location.reload();
    }
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
                    //$("#txtCodigoDisciplina").attr("", obj.codigoDisciplina);
                    $("#txtDisciplina").attr("value", obj.nomeDisciplina);
                    $("#txtAbreviacaoDisciplina").attr("value", obj.abreviacaoDisciplina);
                    $("#txtCodigoDisciplina").attr("value", obj.codigoDisicplina);
                    $("#txtCargaHorariaDisciplina").attr("value", obj.cargaHorariaDisciplina);
                    //var selectCurso = $("#selectCurso").val();
                    var txtDisciplinaCurso = $("#txtDisciplinaCurso").val();
                    var jnt = obj.abreviacaoDisciplina + txtDisciplinaCurso;
                    //alert(jnt);
                    $("#txtDisciplinaCurso").attr("value", jnt);
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

$("#selectCurso").change(function () {
    var selectCurso = $("#selectCurso").val();
    if (selectCurso !== "Selecione o Curso desejado...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultaCurso?selectCurso=" + selectCurso,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    var abrDisc = $("#txtCodigoDisciplina").val();
                    $("#txtIdCurso").attr("value", obj.idCurso);
                    $("#txtNomeDoCurso").attr("value", obj.nomeCurso);
                    $("#txtCodigoDoCurso").attr("value", obj.codigoCurso);
                    $("#txtDisciplinaCurso").attr("value", "/" + obj.nomeCurso);
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

$("#btnCadastrar").click(function () {
    var txtIdCurso = $("#txtIdCurso").val();
    var txtIdDisciplina = $("#txtIdDisciplina").val();
    var txtDisciplinaCurso = $("#txtDisciplinaCurso").val();
    var txtObservacoes = $("#txtObservacoes").val();
    if (txtIdCurso === ""
            || txtIdDisciplina === ""
            || txtDisciplinaCurso === ""
            || txtObservacoes === "") {
        window.alert("Insira valores nos campos!");
    } else {
        $("#formCadastrarDisciplinaCurso").attr("action"
                , "/PresencaAlunos/ServletCadastraDisciplinaCurso"
                + "?txtIdCurso=" + txtIdCurso
                + "&txtIdDisciplina=" + txtIdDisciplina,
                +"&txtDisciplinaCurso=" + txtDisciplinaCurso,
                +"&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarDisciplinaCurso").submit();
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