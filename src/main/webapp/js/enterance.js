function SetDataToRegisrtation() {
    let name = $('#NAME');
    let email = $('#MAIL');
    let password = $('#PASSWORD');

    $.ajax({
        url: 'http://localhost:8080/Cinema_war/hello-servlet',
        method : "GET",
        dataType: 'json',
        data: {"name": name.val(), "password": password.val(), "email": email.val()},
        success: function (data) {
            console.log(data);
            let errors = data;
            $('#errorMail').css("color" , "red");
            $('#errorName').css("color" , "red");
            $('#errorPass').css("color" , "red");

            if ( errors['name'] != "ok")
                $('#errorName').html(errors["name"]);
            else
                $('#errorName').html("`");

            if (errors['email'] != "ok")
                $('#errorMail').html(errors['email']);
            else
                $('#errorMail').html("`");

            if ( errors['password'] != "ok")
                 $('#errorPass').html(errors['password']);
            else
                $('#errorPass').html("`");
            if (errors["name"] == "ok" && errors['email'] == "ok" && errors['password'] == "ok")
            {
                $('#errorName').html("");
                $('#errorMail').html("");
                $('#errorPass').html("Вы успешно зарегистрировались!");
            }
        }
    });
}

function CheckDataToEnterance(){

    let email = $('#MAILTOENTER');
    let password = $('#PASSWORDTOENTER');

    $.ajax({
        url: 'http://localhost:8080/Cinema_war/enterance',
        method : "GET",
        dataType: 'json',
        data: {"password": password.val(), "email": email.val()},
        success: function (data) {
            console.log(data);
            $('#errorEnter').css("color" , "red");
            $('#errorEnter').html(data['status']);
            console.log(data['current-user']);
            if (data["status"] == "ok") {
                localStorage['current-user'] = data['current-user']
                if (data['role'] == "Admin")
                    window.location.href = 'AccountAdmin.jsp';
                else if (data['role'] == "user")
                    window.location.href = 'Account.jsp';
                else if (data['role'] == "Moderator")
                    window.location.href = 'AccountModerator.jsp';
            }

        }
    });

}


