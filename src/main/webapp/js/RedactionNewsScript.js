let News;
let COUNTER = 0;
function getBase(typeOfBase){
    $.ajax({
        url: 'http://localhost:8080/Cinema_war/GetBaseServlet',
        method : "GET",
        dataType: 'json',
        data: {
            "type" : typeOfBase
        },
        success: function (data) {
            News = data['Base'];

          //  console.log(News[0]);
            if (News.length == 0) {
                $(".login-box").css("color" , "white");
                $(".login-box").css('font-size', "40px");
                $(".login-box").html("<center>Нет новостей</center>")
            }
            else
                ShowNew(COUNTER);
        }
    });
}

function ShowNew(counter){
    $("#texterr").html("");
    $("#nameerr").html("")
    let nameNew = $("#NameNew");
    let text = $("#NewText");
    nameNew.val(News[counter]["nameOfNew"]);
    text.val(News[counter]["text"]);
    console.log(News[counter])
}

function Left(){
    if (COUNTER > 0)
        COUNTER-=1
    ShowNew(COUNTER)
    $("#ok").html("");

}

function  Right(){
    if (COUNTER < News.length - 1) {
        COUNTER+=1;
    }
    ShowNew(COUNTER)
    $("#ok").html("")
}

function RedactionNew(){
    let nameNew = $("#NameNew");
    let mainText = $("#NewText");

    if (nameNew.val().length < 6){
        $("#nameerr").html("Название должно быть длинее 5 символов!")
    }
    else
        $("#nameerr").html("")

    if (mainText.val().length < 30){
        $("#texterr").html("Новость должна быть больше 30 символов!")
    }
    else $("#texterr").html("")

    if ($("#texterr").html() == "" &&  $("#nameerr").html() == "") {
        $("#ok").html("Новость обновлена!")
        $.ajax({
            url: 'http://localhost:8080/Cinema_war/NewsServlet',
            method: "GET",
            dataType: 'json',
            data: {
                "type": 1,
                "nameOfNew": nameNew.val(),
                "text": mainText.val(),
                "numberOfNew" : COUNTER
            },
            success: function (data) {
              //  console.log(data);
                getBase("News");
            }
        });
    }
}