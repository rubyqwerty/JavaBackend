const ru = new Intl.Locale('ru-RU')

let nameFile = ""

let Application
function getBase(typeOfBase){
    $.ajax({
        url: 'http://localhost:8080/Cinema_war/GetBaseServlet',
        method : "GET",
        dataType: 'json',
        data: {
            "type" : typeOfBase
        },
        success: function (data) {
            Application = data["Applications"];
            if (Application.length == 0) {
                $(".login-box").css("color" , "white");
                $(".login-box").css('font-size', "40px");
                $(".login-box").html("<center>Нет заявок</center>")
            }
            else
             ShowApp(COUNTER);
        }
    });
}
let COUNTER = 0;
function ShowApp(number){
        $("#counterr").html("");
        $("#dataerr").html("");
        $("#rowerr").html("");
        $("#placeerr").html("");
        let applic  = Application
        console.log(applic)
        $("#count").val(applic[number]['countGuests'])
        $("#row").val(applic[number]['row'])
        $("#place").val(applic[number]['place'])
        document.querySelector('#data').value = applic[number]['date']
        document.querySelector('#movie').value   = applic[number]['nameOfMovie']
        $("#curfile").html(applic[number]['nameFile'])
        nameFile = applic[number]['nameFile']
}

function Right(){
    if (COUNTER < Application.length - 1) {
        COUNTER+=1;
    }
    ShowApp(COUNTER)
    $("#ok").html("")

}

function Left(){
    if (COUNTER > 0)
        COUNTER-=1
    ShowApp(COUNTER)
    $("#ok").html("")
}


function RedactionApplication() {
    let count = $("#count")
    let row = $("#row")
    let place = $("#place")
    let movie = $("#movie")
    let date = $("#data")

    $.ajax({
        url: 'http://localhost:8080/Cinema_war/ApplicationServlet',
        method : "GET",
        dataType: 'json',
        data: {
            "count": count.val(),
            "row": row.val(),
            "place": place.val(),
            "movie": movie.val(),
            "date": date.val(),
            "redaction" : COUNTER,
            "nameFile" : nameFile
        },
        success: function (data) {
            console.log(data)
            if (data['count'] != "ok")
                $("#counterr").html(data['count']);
            else  $("#counterr").html("");

            if (data['row'] != "ok")
                $("#rowerr").html(data['row']);
            else  $("#rowerr").html("");

            if (data['place'] != "ok")
                $("#placeerr").html(data['place']);
            else  $("#placeerr").html("");

            if (data['movie'] != "ok")
                $("#movieerr").html(data['movie']);
            else  $("#movieterr").html("");

            if (data['date'] != "ok")
                $("#dataerr").html(data['date']);
            else  $("#dataerr").html("");

            if (data['status'] == "ok"){
                $("#ok").html("Заявка отредактирована!")
                getBase('userData')
            }
        }
    });
}

function showFile(input) {
    let file = input.files[0];
    console.log(file.name)
    nameFile = file.name
}