

let nameFile = "";
function SendApplication() {
    let count = $("#count")
    let row = $("#row")
    let place = $("#place")
    let movie = $("#movie")
    let date = $("#data")

    if (nameFile == "")
        $("#fileerr").html("Загрузите файл")
    else {
        $("#fileerr").html("")
        $.ajax({
            url: 'http://localhost:8080/Cinema_war/ApplicationServlet',
            method: "GET",
            dataType: 'json',
            data: {
                "count": count.val(),
                "row": row.val(),
                "place": place.val(),
                "movie": movie.val(),
                "date": date.val(),
                "redaction": "null",
                "nameFile" : nameFile
            },
            success: function (data) {
                console.log(data)
                if (data['count'] != "ok")
                    $("#counterr").html(data['count']);
                else $("#counterr").html("");

                if (data['row'] != "ok")
                    $("#rowerr").html(data['row']);
                else $("#rowerr").html("");

                if (data['place'] != "ok")
                    $("#placeerr").html(data['place']);
                else $("#placeerr").html("");

                if (data['movie'] != "ok")
                    $("#movieerr").html(data['movie']);
                else $("#movieterr").html("");

                if (data['date'] != "ok")
                    $("#dataerr").html(data['date']);
                else $("#dataerr").html("");

                if (data['status'] == "ok")
                    window.location.href = 'CreateApplication.jsp';
            }
        });
    }
}

function showFile(input) {
    let file = input.files[0];
    console.log(file.name)
    nameFile = file.name
}