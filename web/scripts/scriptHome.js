$(document).ready(function () {
    getUser();
    document.getElementById("e").style.display = "none";
    document.getElementById("f").style.display = "none";
    document.getElementById("g").style.display = "none";
    document.getElementById("h").style.display = "none";
    document.getElementById("i").style.display = "none";
    document.getElementById("links").style.display = "none";
    document.getElementById("perfil").style.display = "none";    
    document.getElementById("Fotico").style.display = "none";
});
function getUser() {
    $.ajax({
        url: "Sesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if (response == "false") {
            window.location.href = "index.html";
        } else {
            document.getElementById('ident').innerHTML = response.identificador;
            document.getElementById('nombre').innerHTML = response.nombreSol;
            document.getElementById('col').innerHTML = response.colegio;
            document.getElementById('curso').innerHTML = response.cursoArea;
            var a = response.imagenUsuario;
            document.getElementById('imageUser').src = a;
        }
    });
}
function closeSesion() {
    $.ajax({
        url: "CloseSesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if (response == "false") {
            window.location.href = "index.html";
        }
    });
}

function showListados() {
    $("#a").remove();
    $("#b").remove();
    $("#c").remove();
    $("#d").remove();
    document.getElementById("e").style.display = "block";
    document.getElementById("links").style.display = "block";
    document.getElementById("perfil").style.display = "none";
}
function obtenerData() {
    document.getElementById("f").style.display = "block";
    document.getElementById("g").style.display = "none";
    $.ajax({
        url: "Listar",
        type: "GET"

    }).done(function (data) {
        console.log(data);
        var inventario = data;
        $("#tabla1").show();
        $("#tabla2").show();
        $("#tabla2").empty();

        for (var i in inventario) {
            $("#tabla2").append(
                    '<tr>' +
                    '<td style="width:400px">' + inventario[i].nombre + '</td>' +
                    '<td style="width:200px">' + inventario[i].cantidadDisponible + '</td>' +
                    '<td style="width:200px">' + inventario[i].ubicacion + '</td>' +
                    '<td style="width:200px">' + inventario[i].area + '</td>' +
                    '</tr>'
                    );
        }


    });
}
function selectArea() {
    document.getElementById("h").style.display = "block";
    document.getElementById("f").style.display = "none";
    document.getElementById("g").style.display = "none";
}

function check() {
    console.log($("#test").val());
    var parametros = {
        "valor1": $("#test").val()
    };


    $.ajax({
        data: parametros,
        url: "ListarPorArea",
        type: "GET"

    }).done(function (data) {
        console.log(data);
        document.getElementById("g").style.display = "block";

        var inventario = data;
        $("#tabla3").show();
        $("#tabla4").show();
        $("#tabla4").empty();

        for (var i in inventario) {
            $("#tabla4").append(
                    '<tr>' +
                    '<td style="width:400px">' + inventario[i].nombre + '</td>' +
                    '<td style="width:200px">' + inventario[i].cantidadDisponible + '</td>' +
                    '<td style="width:200px">' + inventario[i].ubicacion + '</td>' +
                    '<td style="width:200px">' + inventario[i].area + '</td>' +
                    '</tr>'
                    );
        }


    });
}

function mostrarPerfil() {
    $.ajax({
        url: "Sesion",
        type: "GET"

    }).done(function (response) {
        document.getElementById("perfil").style.display = "block";
        document.getElementById("i").style.display = "block";
        document.getElementById("f").style.display = "none";
        document.getElementById("g").style.display = "none";
        document.getElementById("e").style.display = "none";
        document.getElementById("h").style.display = "none";
        document.getElementById("links").style.display = "none";
        $("#a").remove();
        $("#b").remove();
        $("#c").remove();
        $("#d").remove();
        document.getElementById('1').innerHTML = response.identificador;
        document.getElementById('2').innerHTML = response.nombreSol;
        document.getElementById('3').innerHTML = response.colegio;
        document.getElementById('4').innerHTML = response.tipo;
        document.getElementById('5').innerHTML = response.cursoArea;
        alert(response.imagenUsuario);
        document.getElementById('ima').src = response.imagenUsuario;

    });



}
function activeChangeImage(){
    
    document.getElementById("Fotico").style.display = "block";
    
}



