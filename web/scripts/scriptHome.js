$(document).ready(function () {
    getUser();
    document.getElementById("e").style.display = "none";
    document.getElementById("f").style.display = "none";    
    document.getElementById("g").style.display = "none";
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
}
function obtenerData() {
    document.getElementById("f").style.display = "block"; 
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



