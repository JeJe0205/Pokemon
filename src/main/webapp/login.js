$(document).ready(function (){
    $("#loginForm").submit(sendLogin);
    $("#logoff").click(sendLogoff);
});

function sendLogin(form){
    form.preventDefault();
    $
        .ajax({
            url: "./restore/user/login",
            dataType: "text",
            type: "POST",
            data: $("#loginForm").serialize()

    })
        .done(function (){
        window.location.href = "./pokemon.html";
    })
        .fail(function (xhr, status, errorThrown){
            if (xhr.status == 404){
                $("#message").text("Benutzername/Passwort unbekannt");
            }else {
                $("#message").text("Es ist ein Fehler aufgetreten")
            }
        })
}

function sendLogoff(){
    $
        .ajax({
            url: "./restore/user/logoff",
            dataType: "text",
            type: "DELETE",

        })
        .done(function (){
            window.location.href = "./login.html";
        })
        .fail(function (xhr, status, errorThrown){

        })
}