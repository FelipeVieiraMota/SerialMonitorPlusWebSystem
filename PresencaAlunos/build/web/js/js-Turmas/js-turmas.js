/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("#txtIdTurma").hide();
$("#lbIdTurma").hide();
$("#txtIdCurso").hide();
$("#lbIdCurso").hide();
$("#txtIdSemestre").hide();
$("#lbIdSemestre").hide();

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

$(document).ready(buscarTodosOsSemestresAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodosOsSemestres",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.semestre);
                $("#selectAnoSemestre").append("<option>" + obj.semestre + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {
            $("#txtAbreviacaoDaTurma").empty();
            $("#txtObservacoes").empty();
        }
    });
});

$(document).ready(buscarTodosOsCursosAoCarregarPagina = function () {
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
            $("#txtAbreviacaoDaTurma").empty();
            $("#txtObservacoes").empty();
        }
    });
});


$(document).ready(buscarTodosOsTermosAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/json/Termo.json",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeCurso);
                $("#txtCiclo").append("<option>" + obj.termo + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {
            $("#txtAbreviacaoDaTurma").empty();
            $("#txtObservacoes").empty();
        }
    });
});


$(document).ready(buscarTodosOsPeriodosAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/json/Periodo.json",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeCurso);
                $("#txtPeriodo").append("<option>" + obj.periodo + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {
            $("#txtAbreviacaoDaTurma").empty();
            $("#txtObservacoes").empty();
        }
    });
});


$("#selectAnoSemestre").change(selecionarAnoSemestreBuscarIdSemestreParaCadastroDeTurma = function () {
    $("#txtNomeDaTurma").empty();
    var selectAnoSemestre = $("#selectAnoSemestre").val();
    if (selectAnoSemestre === "Selecione o Ano/Semestre desejado...") {
        window.location.reload();
    } else {
        $.ajax({
            url: "/PresencaAlunos/ServletConsultaSemestre?selectSemestre=" + selectAnoSemestre,
            dataType: "json",
            success: function (retornoJsonDaServlet) {
                $.each(retornoJsonDaServlet, function (index, obj) {
                    console.log(obj.semestre);
                    //$("#selectAnoSemestre").append("<option>" + obj.semestre + "</option>");
                    $("#txtNomeDaTurma").attr("value", selectAnoSemestre);
                    $("#txtIdSemestre").attr("value", obj.idSemestre);
                    //$("#txtIdSemestre").show();
                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
            }, beforeSend: function () {
                $("#txtAbreviacaoDaTurma").empty();
                $("#txtObservacoes").empty();
            }
        });
    }
});

$("#selectCurso").change(selecionarCursoBuscarIdCursoParaCadastroDeTurma = function () {
    var selectAnoSemestre = $("#selectAnoSemestre").val();
    var selectCurso = $("#selectCurso").val();
    if (selectCurso === "Selecione o Ano/Semestre desejado...") {
        window.location.reload();
    } else {
        $.ajax({
            url: "/PresencaAlunos/ServletConsultaCurso?selectCurso=" + selectCurso,
            dataType: "json",
            success: function (retornoJsonDaServlet) {
                $.each(retornoJsonDaServlet, function (index, obj) {
                    console.log(obj.semestre);
                    $("#txtNomeDaTurma").attr("value", selectAnoSemestre + "-" + selectCurso + "-");                                        
                    $("#txtIdCurso").attr("value", obj.idCurso);
                    //$("#txtIdCurso").show();
                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
            }, beforeSend: function () {
                $("#txtAbreviacaoDaTurma").empty();
                $("#txtObservacoes").empty();
            }
        });
    }
});

$("#txtCiclo").change(function () {
    //$("#txtNomeDaTurma").empty();
    var selectAnoSemestre = $("#selectAnoSemestre").val();
    var selectCurso = $("#selectCurso").val();
    var txtCiclo = $("#txtCiclo").val();
    $("#txtNomeDaTurma").attr("value", selectAnoSemestre + "-" + selectCurso + "-" + txtCiclo);
});

$("#txtPeriodo").change(function () {
    //$("#txtNomeDaTurma").empty();
    var selectAnoSemestre = $("#selectAnoSemestre").val();
    var selectCurso = $("#selectCurso").val();
    var txtCiclo = $("#txtCiclo").val();
    var txtPeriodo = $("#txtPeriodo").val();
    $("#txtNomeDaTurma").attr("value", selectAnoSemestre + "-" + selectCurso + "-" + txtCiclo + "(" + txtPeriodo + ")");
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
                    $("#txtIdCurso").attr("value",obj.idCurso);
                    $("#txtIdSemestre").attr("value",obj.idSemestre);
                    $("#txtCodigoDaTurma").attr("value", obj.codigoTurma);
                    $("#selectAnoSemestre").append("<option>" + obj.anoSemestre + "</option>");
                    $("#selectCurso").append("<option>" + obj.curso + "</option>");
                    $("#txtNomeDaTurma").attr("value", obj.nomeTurma);
                    $("#txtAbreviacaoDaTurma").attr("value", obj.abreviacaoTurma);
                    $("#txtCiclo").append("<option>" + obj.ciclo + "</option>");
                    $("#txtPeriodo").append("<option>" + obj.periodo + "</option>");
                    $("#txtObservacoes").val(obj.observacoes);
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


$("#btnAlterar").click(function () {
    var txtIdTurma = $("#txtIdTurma").val();
    var txtIdCurso = $("txtIdCurso").val();
    var txtIdSemestre = $("txtIdSemestre").val();
    var selectAnoSemestre = $("#selectAnoSemestre").val();
    var selectCurso = $("#selectCurso").val();
    var txtNomeDaTurma = $("#txtNomeDaTurma").val();
    var txtAbreviacaoDaTurma = $("#txtAbreviacaoDaTurma").val();
    var txtCiclo = $("#txtCiclo").val();
    var txtPeriodo = $("#txtPeriodo").val();
    var txtObservacoes = $("#txtObservacoes").val();

    if (selectAnoSemestre === "Selecione o Ano/Semestre desejado..."
            || selectCurso === "Selecione o Curso desejado..."
            || txtNomeDaTurma === ""
            || txtAbreviacaoDaTurma === ""
            || txtCiclo === ""
            || txtPeriodo === ""
            || txtIdTurma === ""
            || txtIdCurso === ""
            || txtIdSemestre === ""
            || txtObservacoes === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarTurma").attr("action"
                , "/PresencaAlunos/ServletAlterarTurma"
                + "?selectAnoSemestre=" + selectAnoSemestre
                + "&selectCurso=" + selectCurso,
                +"&txtNomeDaTurma=" + txtNomeDaTurma,
                +"&txtAbreviacaoDaTurma=" + txtAbreviacaoDaTurma,
                +"&txtCiclo=" + txtCiclo,
                +"&txtPeriodo=" + txtPeriodo,
                +"&txtIdTurma=" + txtIdTurma,
                +"&txtIdCurso=" + txtIdCurso,
                +"&txtIdSemestre=" + txtIdSemestre,
                +"&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarTurma").submit();
    }
});

$("#btnCadastrar").click(function () {
    var txtIdCurso = $("#txtIdCurso").val();
    var txtIdSemestre = $("#txtIdSemestre").val();
    var selectAnoSemestre = $("#selectAnoSemestre").val();
    var selectCurso = $("#selectCurso").val();
    var txtNomeDaTurma = $("#txtNomeDaTurma").val();
    var txtAbreviacaoDaTurma = $("#txtAbreviacaoDaTurma").val();
    var txtCiclo = $("#txtCiclo").val();
    var txtPeriodo = $("#txtPeriodo").val();
    var txtObservacoes = $("#txtObservacoes").val();

    if (selectAnoSemestre === "Selecione o Ano/Semestre desejado..."
            || selectCurso === "Selecione o Curso desejado..."
            || txtNomeDaTurma === ""
            || txtAbreviacaoDaTurma === ""
            || txtCiclo === ""
            || txtPeriodo === ""
            || txtObservacoes === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarTurma").attr("action"
                , "/PresencaAlunos/ServletCadastrarTurma"
                + "?selectAnoSemestre=" + selectAnoSemestre
                + "&selectCurso=" + selectCurso,
                +"&txtNomeDaTurma=" + txtNomeDaTurma,
                +"&txtAbreviacaoDaTurma=" + txtAbreviacaoDaTurma,
                +"&txtCiclo=" + txtCiclo,
                +"&txtPeriodo=" + txtPeriodo,
                +"&txtIdCurso=" + txtIdCurso,
                +"&txtIdSemestre=" + txtIdSemestre,
                +"&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarTurma").submit();
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