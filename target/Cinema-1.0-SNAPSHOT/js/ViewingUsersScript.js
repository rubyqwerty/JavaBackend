
const ru = new Intl.Locale('ru-RU')

var BASEUSERS

let COUNT = 0

function getBase(typeOfBase){
    $.ajax({
        url: 'http://localhost:8080/Cinema_war/GetBaseServlet',
        method : "GET",
        dataType: 'json',
        data: {
            "type" : typeOfBase
        },
        success: function (data) {
           BASEUSERS = []
           for (var i in data['Base']){
               BASEUSERS.push(data['Base'][i])
           }
           console.log(BASEUSERS);
           console.log(localStorage['current-user'])
            showUsers(COUNT);
        }
    });
}

function showUsers(number){
    let name = $('#name')
    let email = $('#email')
    let passowrd = $("#password")
    let role = $("#role")
    name.val(BASEUSERS[number]['name']);
    email.val(BASEUSERS[number]['email'])
    passowrd.val(BASEUSERS[number]['password'])
    role.val(BASEUSERS[number]['role'])
}

function Left(){
    if (COUNT > 0)
        COUNT-=1;
    showUsers(COUNT);
    $("#ok").html("")
}

function Right(){
    if (COUNT < BASEUSERS.length-1)
        COUNT+=1;
    showUsers(COUNT);
    $("#ok").html("")
}

function sendChange(){

    if (localStorage['current-user'] != BASEUSERS[COUNT]['email']) {
        let email = $('#email')
        let name = $('#name')
        let passowrd = $("#password")
        let role = $("#role")
        $.ajax({
            url: 'http://localhost:8080/Cinema_war/RedactionUserServlet',
            method: "GET",
            dataType: 'json',
            data: {
                "email": email.val(),
                "name": name.val(),
                "password": passowrd.val(),
                "role": role.val()
            },
            success: function (data) {
                console.log(data);
                if (data['name'] != "ok")
                    $("#nameerr").html(data['name']);
                else
                    $("#nameerr").html("");

                if (data['password'] != "ok")
                    $("#passworderr").html(data['password']);
                else
                    $("#passworderr").html("");

                if (data['name'] == "ok" && data['password'] == "ok") {
                    $("#ok").css("color", '#acff8e');
                    $("#ok").html("Пользователь обновлен")
                    getBase('AllUserData');
                } else
                    $("#ok").html("")
            }
        });
    }
    else
    {
        $("#ok").css("color", 'red');
        $("#ok").html("Вы не можете отредактировать себя!")
    }
}

function createUser(){
    if ( $("#creareUser").val() != "      Добавить      ") {
        $("#creareUser").val("      Добавить      ");
        let email = $('#email')
        let name = $('#name')
        let passowrd = $("#password")
        $(".create").css("top", "23%")
        $(".create").css("left", "43%")
        $("#buttons").html("");
        $("#email").attr("readonly", false)
        $("#emaillabel").html("Почта")
        $("#ID").html("");
        email.val("");
        name.val("");
        passowrd.val("");
    }
    else{
        let name = $('#name');
        let email = $('#email');
        let password = $('#password');

        $.ajax({
            url: 'http://localhost:8080/Cinema_war/hello-servlet',
            method : "GET",
            dataType: 'json',
            data: {"name": name.val(), "password": password.val(), "email": email.val()},
            success: function (data) {
                console.log(data);
                let errors = data;

                $('#nameerr').html(errors["name"]);
                $('#emailerr').html(errors['email']);
                $('#passworderr').html(errors['password']);

                if (errors["name"] == "ok" && errors['email'] == "ok" && errors['password'] == 'ok')
                {
                    window.location.href = 'ViewingUsers.jsp';
                }
            }
        });
    }

}