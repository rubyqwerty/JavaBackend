function SetPictures(){
    $.ajax({
        url: 'http://localhost:8080/Cinema_war/GetBaseServlet',
        method : "GET",
        dataType: 'json',
        data: {
            "type" : "userData",

        },
        success: function (data) {
            console.log(data['nameOfPicture'])
            localStorage['role'] = data['role'];
            if (data['nameOfPicture'] != "") {
                let urlpic ="http://localhost:8080/Cinema_war/Pictures/"+ data['nameOfPicture']
                console.log(urlpic);
                $("#avatarka").attr("src", urlpic);
                $("#avatarka").attr("height" , 300);
            }
        }
    });
}

function checkAdmin(){
    if (localStorage['role'] == 'Admin') {
        $("#acadmin").attr("href", "AccountAdmin.jsp");
    }
    else if (localStorage['role'] == "Moderator")
        $("#acadmin").attr("href", "AccountModerator.jsp");
}

function block(){
    $("#menu").css("left" , "40%");
}

function Exit(){
    localStorage['current-user'] = "";
    window.location.href = 'index.jsp';
}
