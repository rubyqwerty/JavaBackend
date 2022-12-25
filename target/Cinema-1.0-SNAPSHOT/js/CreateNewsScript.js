function SendNew(){

    let nameNew = $("#NameNew");
    let mainText = $("#NewText");
    console.log(mainText.val())

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

        $.ajax({
            url: 'http://localhost:8080/Cinema_war/NewsServlet',
            method: "GET",
            dataType: 'json',
            data: {
                "type": 0,
                "nameOfNew": nameNew.val(),
                "text": mainText.val()
            },
            success: function (data) {
                console.log(data);
                nameNew.val("");
                mainText.val("");
            }
        });
    }
}

