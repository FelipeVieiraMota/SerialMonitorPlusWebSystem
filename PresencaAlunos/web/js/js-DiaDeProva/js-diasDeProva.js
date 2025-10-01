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
$("#lbIdDiaDeProva").hide();
$("#txtIdDiaDeProva").hide();
$("#lbIdTurma").hide();
$("#txtIdTurma").hide();
$("#lbIdDisicplina").hide();
$("#txtIdDisicplina").hide();
$("#lbIdProfessor").hide();
$("#txtIdProfessor").hide();
$("#lbIdSala").hide();
$("#txtIdSala").hide();


function dataAtualFormatada() {
    var data = new Date();
    var dia = data.getDate();
    if (dia.toString().length == 1)
        dia = "0" + dia;
    var mes = data.getMonth() + 1;
    if (mes.toString().length == 1)
        mes = "0" + mes;
    var ano = data.getFullYear();
    return dia + "/" + mes + "/" + ano;
}
;



$(document).ready(buscarTodosOsDiasDeProvasAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodasOsDiasDeProvas",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.prova);
                $("#selectDiaDeProva").append("<option>" + obj.prova + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Nao ha provas agendadas no sistema.");
        }, beforeSend: function () {
        }
    });
});

$(document).ready(buscarDiasDaSemana = function () {
    $.ajax({
        url: "/PresencaAlunos/json/DiaDaSemana.json",
        dataType: "json",
        success: function (retornoJson) {
            $.each(retornoJson, function (index, obj) {
                console.log(obj.dia);
                $("#selectDiaDaSemana").append("<option>" + obj.dia + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Nao foi possivel realizar a buscar por dias da semana, tente novamente ou chame o suporte...");
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
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {
            // $("#txtNomeDaTurma").empty();
            //$("#txtAbreviacaoDaTurma").empty();
            //$("#txtObservacoes").empty();
        }
    });
});

$(document).ready(buscarTodosAsDisciplinasAoCarregarPagina = function () {
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
            //  $("#txtAbreviacaoDaTurma").empty();
            //$("#txtObservacoes").empty();
        }
    });
});

$(document).ready(buscarTodosOsProfessoresAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodosOsProfessores",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeProfessor);
                $("#selectProfessor").append("<option>" + obj.nomeProfessor + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Erro ao buscar registros, contate o suporte! " + errorThrown + " " + textStatus);
        }, beforeSend: function () {
            // $("#txtAbreviacaoDaTurma").empty();
            // $("#txtObservacoes").empty();
        }
    });
});

$(document).ready(buscarTodasAsSalasAoCarregarPagina = function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodasAsSalas",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.nomeSala);
                $("#selectSala").append("<option>" + obj.nomeSala + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Nao ha salas cadastradas!");
        }, beforeSend: function () {
            //$("#txtAbreviacaoDaTurma").empty();
            //$("#txtObservacoes").empty();
        }
    });
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
                    // $("#txtProva").attr("value", selectTurma + "-");
                    /*$("#txtIdCurso").attr("value",obj.idCurso);
                     $("#txtIdSemestre").attr("value",obj.idSemestre);
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
                /*$("#txtCodigoDaTurma").empty();
                 $("#selectAnoSemestre").empty();
                 $("#selectCurso").empty();
                 $("#txtNomeDaTurma").empty();
                 $("#txtAbreviacaoDaTurma").empty();
                 $("#txtCiclo").empty();
                 $("#txtPeriodo").empty();
                 $("#txtObservacoes").empty();*/
            }
        });
    } else {
        window.location.reload();
    }
});

$("#selectDisciplina").change(function () {
    var selectDisciplina = $("#selectDisciplina").val();
    var selectTurma = $("#selectTurma").val();
    if (selectDisciplina !== "Selecione a Disciplina desejada...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultaDisciplinas?selectDisciplina=" + selectDisciplina,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdDisicplina").attr("value", obj.idDisciplina);
                    $("#txtProva").attr("value", selectDisciplina);
                    /*$("#txtCodigoDisciplina").attr("",obj.codigoDisciplina);
                     $("#txtDisciplina").attr("value", obj.nomeDisciplina);
                     $("#txtAbreviacaoDisciplina").attr("value", obj.abreviacaoDisciplina);
                     $("#txtCodigoDisicplina").attr("value", obj.codigoDisicplina);
                     $("#txtCargaHorariaDisciplina").attr("value", obj.cargaHorariaDisciplina);                    
                     $("#txtObservacoes").val(obj.observacoes);*/
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
                    /*$("#txtNomeDoProfessor").attr("value", obj.nomeProfessor);
                     $("#txtCodigoDeMatriculaDoProfessor").attr("value", obj.codigomatriculaProfessor);
                     $("#txtDataDeNascimentoDoProfessor").attr("type", "text");
                     $("#txtDataDeNascimentoDoProfessor").attr("value", obj.dataNascimentoProfessor);
                     $("#txtIdadeDoProfessor").attr("value", obj.idadeProfessor);
                     $("#txtFormacaoProfissionalDoProfessor").attr("value", obj.formacaoProfissionalProfessor);
                     $("#txtEspecializacaoProfissionalDoProfessor").attr("value", obj.especializacaoProfissionalProfessor);
                     $("#txtCpfDoProfessor").attr("value", obj.cpfProfessor);
                     $("#txtRgDoProfessor").attr("value", obj.rgProfessor);
                     $("#selectSexoDoProfessor").append("<option selected>" + obj.sexoProfessor + "</option>");
                     $("#txtCelularDoProfessor").attr("value", obj.celularProfessor);*/
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

$("#selectSala").change(preencherCamposComOsDadosDaSala = function () {
    var selectDisciplina = $("#selectDisciplina").val();
    var selectTurma = $("#selectTurma").val();
    var selectSala = $("#selectSala").val();
    var txtData = $("#txtData").val();
    if (selectSala !== "Selecione a sala desejada...") {
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultarSala?selectSala=" + selectSala,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    //$("#idLoad").hide();
                    $("#txtIdSala").attr("value", obj.idSala);
                    // $("#txtProva").attr("value", selectTurma + "-" + selectDisciplina + "-" + txtData + "-"+selectSala);
                    /*$("#txtNomeDaSala").attr("value", obj.nomeSala);
                     $("#txtCodigoDaSala").attr("value", obj.codigoDaSala);
                     $("#selectTipoDeSala").append("<option selected>" + obj.tipoDeSala + "</option>");
                     $("#txtNumeroDaSala").attr("value", obj.numeroDaSala);
                     $("#selectAndarDaSala").append("<option selected>" + obj.andarDaSala + "</option>");
                     $("#txtObservacoes").val(obj.observacoes);*/
                });
            }, error: function (textStatus, errorThrown) {
                // $("#idLoad").hide();
                window.alert("Erro ao buscar registros, contate o suporte! " + textStatus);
            }, beforeSend: function () {
                // $("#idLoad").show();
            }
        });
    } else {
        window.location.reload();
    }
});

$("#selectDiaDeProva").change(function () {
    var selectDiaDeProva = $("#selectDiaDeProva").val();
    if (selectDiaDeProva !== "Selecione o Dia De Prova desejado...") {
        console.log("aqui em select selectDiaDeProva");
        console.log("selectDiaDeProva : " + selectDiaDeProva);
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultarDiaDeProva?selectDiaDeProva=" + selectDiaDeProva,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtIdDiaDeProva").attr("value", obj.idDiaDeProva);
                    $("#txtIdTurma").attr("value", obj.idTurma);
                    $("#txtIdDisicplina").attr("value", obj.idDisciplina);
                    $("#txtIdProfessor").attr("value", obj.idProfessor);
                    $("#txtIdSala").attr("value", obj.IdSala);
                    $("#txtCodigoDaDiaDeProva").attr("value", obj.codigoDiaDeProva);
                    $("#txtProva").attr("value", obj.prova);
                    $("#selectTurma").append("<option selected>" + obj.turma + "</option>");
                    $("#selectDisciplina").append("<option selected>" + obj.disciplina + "</option>");
                    $("#selectProfessor").append("<option selected>" + obj.professor + "</option>");
                    $("#selectSala").append("<option selected>" + obj.sala + "</option>");
                    $("#txtData").attr("type", "text");
                    $("#txtData").attr("value", obj.dataDaProva);
                    $("#selectDiaDaSemana").append("<option selected>" + obj.diaDaSemana + "</option>");
                    $("#txtHoraInicioDaProva").attr("value", obj.horarioInicialDaProva);
                    $("#txtHoraFinalDaProva").attr("value", obj.horarioFinalDaProva);
                    $("#txtObservacoes").val(obj.observacoes);
                    //var txtHoraFinalDaProva = $("#txtHoraFinalDaProva").val();
                    //alert("Hora final : " + txtHoraFinalDaProva + " -- Dia de Prova: " + selectDiaDeProva);
                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Erro ao buscar registros, contate o suporte! " + textStatus);
            }, beforeSend: function () {
                /* $("#selectDisciplina").empty();
                 $("#selectTurma").empty();
                 $("#selectProfessor").empty();
                 $("#selectSala").empty();*/
            }
        });
    } else {
        window.location.reload();
    }
});

$("#btnAlterar").click(function () {
    var txtIdDiaDeProva = $("#txtIdDiaDeProva").val();
    var txtIdTurma = $("#txtIdTurma").val();
    var txtIdDisicplina = $("#txtIdDisicplina").val();
    var txtIdProfessor = $("#txtIdProfessor").val();
    var txtIdSala = $("#txtIdSala").val();
    var txtCodigoDaDiaDeProva = $("#txtCodigoDaDiaDeProva").val();
    var txtProva = $("#txtProva").val();
    var selectTurma = $("#selectTurma").val();
    var selectDisciplina = $("#selectDisciplina").val();
    var selectProfessor = $("#selectProfessor").val();
    var selectSala = $("#selectSala").val();
    var txtData = $("#txtData").val();
    var selectDiaDaSemana = $("#selectDiaDaSemana").val();
    var txtHoraInicioDaProva = $("#txtHoraInicioDaProva").val();
    var txtHoraFinalDaProva = $("#txtHoraFinalDaProva").val();
    var txtObservacoes = $("#txtObservacoes").val();
   // window.alert("h f = " + txtHoraFinalDaProva);

    if (txtIdDiaDeProva === ""
            || txtCodigoDaDiaDeProva === ""
            || txtIdTurma === ""
            || txtIdDisicplina === ""
            || txtIdProfessor === ""
            || txtIdSala === ""
            || txtProva === ""
            || selectTurma === "..."
            || selectDisciplina === "..."
            || selectProfessor === "..."
            || selectSala === "..."
            || txtData === ""
            || selectDiaDaSemana === ""
            || txtHoraInicioDaProva === ""
            || txtHoraFinalDaProva === ""
            || txtObservacoes === "") {
        //window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarDiaDeProva").attr("action"
                , "/PresencaAlunos/ServletAlterarDiaDeProva"
                + "?txtIdTurma=" + txtIdTurma
                + "&txtHoraFinalDaProva=" + txtHoraFinalDaProva,
                +"&txtIdDiaDeProva=" + txtIdDiaDeProva,
                +"&txtIdDisicplina=" + txtIdDisicplina,
                +"&txtIdProfessor=" + txtIdProfessor,
                +"&txtCodigoDaDiaDeProva=" + txtCodigoDaDiaDeProva,
                +"&txtIdSala=" + txtIdSala,
                +"&txtProva=" + txtProva,
                +"&selectTurma=" + selectTurma,
                +"&selectDisciplina=" + selectDisciplina,
                +"&selectProfessor=" + selectProfessor,
                +"&selectSala=" + selectSala,
                +"&txtData=" + txtData,
                +"&selectDiaDaSemana=" + selectDiaDaSemana,
                +"&txtHoraInicioDaProva=" + txtHoraInicioDaProva,
                +"&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarDiaDeProva").submit();
    }
});

$("#btnCadastrar").click(function () {
    //var txtIdDiaDeProva = $("#txtIdDiaDeProva").val();
    var txtIdTurma = $("#txtIdTurma").val();
    var txtIdDisicplina = $("#txtIdDisicplina").val();
    var txtIdProfessor = $("#txtIdProfessor").val();
    var txtIdSala = $("#txtIdSala").val();
    //var txtCodigoDaDiaDeProva = $("#txtCodigoDaDiaDeProva").val();
    var txtProva = $("#txtProva").val();
    var selectTurma = $("#selectTurma").val();
    var selectDisciplina = $("#selectDisciplina").val();
    var selectProfessor = $("#selectProfessor").val();
    var selectSala = $("#selectSala").val();
    var txtData = $("#txtData").val();
    var selectDiaDaSemana = $("#selectDiaDaSemana").val();
    var txtHoraInicioDaProva = $("#txtHoraInicioDaProva").val();
    var txtHoraFinalDaProva = $("#txtHoraFinalDaProva").val();
    var txtObservacoes = $("#txtObservacoes").val();
    //alert("Hora final : "+txtHoraFinalDaProva+" -- Dia de Prova: "+selectDiaDaSemana);

    if (txtIdTurma === ""
            || txtIdDisicplina === ""
            || txtIdProfessor === ""
            || txtIdSala === ""
            || txtProva === ""
            || selectTurma === "..."
            || selectDisciplina === "..."
            || selectProfessor === "..."
            || selectSala === "..."
            || txtData === ""
            || selectDiaDaSemana === ""
            || txtHoraInicioDaProva === ""
            || txtHoraFinalDaProva === ""
            || txtObservacoes === "") {
        window.alert("Insira valores validos nos campos!");
    } else {
        $("#formCadastrarDiaDeProva").attr("action"
                , "/PresencaAlunos/ServletCadastrarDiaDeProva"
                + "?txtIdTurma=" + txtIdTurma
                + "&txtIdDisicplina=" + txtIdDisicplina
                + "&txtIdProfessor=" + txtIdProfessor
                + "&txtIdSala=" + txtIdSala
                + "&txtProva=" + txtProva
                + "&selectTurma=" + selectTurma
                + "&selectDisciplina=" + selectDisciplina
                + "&selectProfessor=" + selectProfessor
                + "&selectSala=" + selectSala
                + "&txtData=" + txtData
                + "&selectDiaDaSemana=" + selectDiaDaSemana
                + "&txtHoraInicioDaProva=" + txtHoraInicioDaProva
                + "&txtHoraFinalDaProva=" + txtHoraFinalDaProva
                + "&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarDiaDeProva").submit();
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