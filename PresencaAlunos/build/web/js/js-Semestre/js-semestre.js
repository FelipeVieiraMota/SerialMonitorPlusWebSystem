$(document).ready(function () {
    $.ajax({
        url: "/PresencaAlunos/ServletConsultarTodosOsSemestres",
        dataType: "json",
        success: function (retornoJsnoDaServlet) {
            $.each(retornoJsnoDaServlet, function (index, obj) {
                console.log(obj.semestre);
                $("#selectAnoSemestre").append("<option>" + obj.semestre + "</option>");
            });
        }, error: function (textStatus, errorThrown) {
            window.alert("Erro ao buscar registros, contate o suporte!");
        }, beforeSend: function () {
            $("#txtSemestre").empty();
            $("#txtObservacoes").empty();
        }
    });
});

$("#selectAnoSemestre").change(function () {
    var selectSemestre = $("#selectAnoSemestre").val();
    if (selectSemestre !== "Selecione o Ano/Semestre desejado...") {
        console.log("aqui em select Semestres");
        console.log("selectSemestre : " + selectSemestre);
        $.ajax({
            type: "POST",
            url: "/PresencaAlunos/ServletConsultaSemestre?selectSemestre=" + selectSemestre,
            dataType: "json",
            success: function (retornoJsnoDaServlet) {
                $.each(retornoJsnoDaServlet, function (index, obj) {
                    $("#txtSemestre").attr("value", obj.semestre);
                    $("#txtObservacoes").val(obj.observacoes);
                });
            }, error: function (textStatus, errorThrown) {
                window.alert("Erro ao buscar registros, contate o suporte! " + textStatus);
            }, beforeSend: function () {

            }
        });
    }
});

$("#btnAlterar").click(function () {
    var txtSemestre = $("#txtSemestre").val();
    var txtObservacoes = $("#txtObservacoes").val();
    if (txtSemestre === "" || txtObservacoes === "") {
        window.alert("Insira valores nos campos!");
    } else {
        $("#formCadastrarSemestre").attr("action", "/PresencaAlunos/ServletAlteraSemestre?txtSemestre=" + txtSemestre + "&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarSemestre").submit();
    }
});

$("#btnCadastrar").click(function () {
    var txtSemestre = $("#txtSemestre").val();
    var txtObservacoes = $("#txtObservacoes").val();
    if (txtSemestre === "" || txtObservacoes === "") {
        window.alert("Insira valores nos campos!");
    } else {
        $("#formCadastrarSemestre").attr("action", "/PresencaAlunos/ServletCadastraSemestre?txtSemestre=" + txtSemestre + "&txtObservacoes=" + txtObservacoes);
        $("#formCadastrarSemestre").submit();
    }
});

$("#aTagVoltar").click(function () {
    var conf = window.confirm("Deseja realmente sair ?");
    if (conf === true) {
        $("#txtSemestre").val("");
        $("#txtObservacoes").val("");
        $("#aTagVoltar").attr("href", "/PresencaAlunos/indexAdm.jsp");
    }
});





/*$("#btnCadastrar").click(function () {
 var txtSemestre = $("#txtSemestre").val();
 var txtObservacoes = $("#txtObservacoes").val();
 $.ajax({
 type: "POST",
 url: "/PresencaAlunos/ServletCadastraSemestre?txtSemestre=" + txtSemestre + "&txtObservacoes=" + txtObservacoes,
 dataType: "json",
 success: function (retorno) {
 $.each(retorno, function (index, obj) {                    
 window.alert("Alteração realizada com sucesso! ");
 });
 }, error: function (textStatus, errorThrown) {
 console.log("Error:" + textStatus + " " + errorThrown);
 //window.alert("Erro ao cadastrar = "+"Error:" + textStatus + " " + errorThrown);
 }, beforeSend: function () {
 //$("#txtSemestre").empty();
 //$("#txtObservacoes").empty();
 /* $("#txtObservacoes").append("<option>selecione...</option>");
 $("#tabelaDados").find("tbody").empty(); 
 $("#tabelaDados").hide();
 }
 });
 });*/
/*
 $("#btnAlterar").click(function () {
 var txtSemestre = $("#txtSemestre").val();
 var txtObservacoes = $("#txtObservacoes").val();
 $.ajax({
 type: "POST",
 url: "/PresencaAlunos/ServletAlteraSemestre?txtSemestre=" + txtSemestre + "&txtObservacoes=" + txtObservacoes,
 dataType: "json",
 success: function (retorno) {
 $.each(retorno, function (index, obj) {
 window.alert("Alteração realizada com sucesso! ");
 });
 }, error: function (textStatus, errorThrown) {
 console.log("Error:" + textStatus + " " + errorThrown);
 //window.alert("Erro ao cadastrar = "+"Error:" + textStatus + " " + errorThrown);
 }, beforeSend: function () {
 alert(txtSemestre + txtObservacoes);
 // $("#txtSemestre").empty();
 //$("#txtObservacoes").empty();
 /* $("#txtObservacoes").append("<option>selecione...</option>");
 $("#tabelaDados").find("tbody").empty(); 
 $("#tabelaDados").hide();*/
/*      }
 });
 });*/
/*
 var limparCamposAntesDeRealizarSubmitOuSairDaPagina = function () {
 document.getElementById("txtSemestre").value = "";
 document.getElementById("txtObservacoes").value = "";    
 };
 
 var submitarCadastroDeSemestres = function () {
 var txtSemestre = document.getElementById("txtSemestre").value;
 var txtObservacoes = document.getElementById("txtObservacoes").value;
 var caminho = "/PresencaAlunos/ServletCadastraSemestre?txtSemestre=" + txtSemestre + "&txtObservacoes=" + txtObservacoes;
 limparCamposAntesDeRealizarSubmitOuSairDaPagina();
 document.getElementById("formCadastrarSemestre").method = "POST";
 document.getElementById("formCadastrarSemestre").action = caminho;
 document.getElementById("formCadastrarSemestre").onsubmit;
 };
 
 
 var submitarAlteracaoDeSemestres = function () {
 var txtSemestre = document.getElementById("txtSemestre").value;
 var txtObservacoes = document.getElementById("txtObservacoes").value;
 var caminho = "/PresencaAlunos/ServletAlteraSemestre?txtSemestre=" + txtSemestre + "&txtObservacoes=" + txtObservacoes;
 limparCamposAntesDeRealizarSubmitOuSairDaPagina();
 document.getElementById("formCadastrarSemestre").method = "POST";
 document.getElementById("formCadastrarSemestre").action = caminho;
 document.getElementById("formCadastrarSemestre").onsubmit;
 };
 
 var submitarPesquisaDeSemestres = function () {
 var txtPesquisarSemestres = document.getElementById("txtPesquisarSemestres").value;
 var caminho = "/PresencaAlunos/ServletConsultaSemestre?txtPesquisarSemestres=" + txtPesquisarSemestres;
 limparCamposAntesDeRealizarSubmitOuSairDaPagina();
 document.getElementById("formPesquisarSemestres").method = "POST";
 document.getElementById("formPesquisarSemestres").action = caminho;
 document.getElementById("formPesquisarSemestres").onsubmit;
 };
 
 var filtrarCadastroSemestre = function () {
 var txtSemestre = document.getElementById("txtSemestre").value;
 var txtObservacoes = document.getElementById("txtObservacoes").value;
 if (txtSemestre === "") {
 window.alert("Ensira algum registro para o campo semestre, por favor!");
 } else if (txtObservacoes === "") {
 window.alert("Ensira algum registro para o campo observações, por favor!");
 } else {
 submitarCadastroDeSemestres();
 }
 };
 
 var filtrarAlteracaoSemestre = function () {
 var txtSemestre = document.getElementById("txtSemestre").value;
 var txtObservacoes = document.getElementById("txtObservacoes").value;
 
 if (txtSemestre === "") {
 window.alert("Ensira algum registro para o campo semestre, por favor!");
 } else if (txtObservacoes === "") {
 window.alert("Ensira algum registro para o campo observações, por favor!");
 } else {
 submitarAlteracaoDeSemestres();
 }
 };
 
 var filtrarPesquisaSemestre = function () {
 var txtPesquisarSemestres = document.getElementById("txtPesquisarSemestres").value;
 if (txtPesquisarSemestres === "") {
 window.alert("Digite algum registro, por favor!");
 } else {
 submitarPesquisaDeSemestres();
 }
 };
 
 var voltarParaPaginaIndexAdm = function () {
 limparCamposAntesDeRealizarSubmitOuSairDaPagina();
 alert("saindo...");
 document.getElementById("aTagVoltar").setAttribute("href", "/PresencaAlunos/indexAdm.jsp");
 };
 
 
 
 var assimilarComandos = function () {
 document.getElementById("btnAlterar").onclick = filtrarAlteracaoSemestre;
 document.getElementById("btnCadastrar").onclick = filtrarCadastroSemestre;    
 document.getElementById("aTagVoltar").onclick = voltarParaPaginaIndexAdm;
 };
 
 assimilarComandos();
 
 */