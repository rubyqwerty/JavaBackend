<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Создать заявки</title>


    <link href="css/ApplicationStyle.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <script src="js/AccountScript.js" type="text/javascript"></script>
    <script src="js/CreateApplicationScript.js" type="text/javascript"></script>
</head>
<body onload = "checkAdmin();">
<nav class="navMenu">
    <a href="Account.jsp" id = "acadmin">Кабинет</a>
    <a href="CreateApplication.jsp"><p class = "cur">Создать</p></a>
    <a href="Application.jsp">Заявки</a>
    <a href="News.jsp">Новости</a>
    <div class="dot"></div>
</nav>

<div class="login-box">
    <h2>Заявка</h2>
    <form>

        <div class = "user-box">
            <input type = "number" id = "count" min = "1" required=""
                   class = 'count'  value="1" >
            <label>Количество человек</label>
            <p class = "errors" id = "counterr"></p>
        </div>

        <div class = "user-box">
            <input type = "number" id = "row" min = "1"  required=""
                   class = 'count'  value="1" >
            <label>Ряд</label>
            <p class = "errors" id = "rowerr"></p>
        </div>

        <div class = "user-box">
            <input type = "number" id = "place" min = "1" required=""
                   class = 'count'  value="1" >
            <label>Место</label>
            <p class = "errors" id = "placeerr"></p>
        </div>

        <div>
            <select class="select-css" id = "movie">
                <option>Выберите фильм</option>
                <option>Batmen</option>
                <option>Spider-man</option>
                <option>Tenet</option>
                <option>Inception</option>
                <option>Interstellar</option>
                <option>The boys</option>
                <option>Memento</option>
            </select>
            <p class = "errors" id = "movieerr"></p>
        </div>

        <div>
            <select class="select-css" id = "data">
                <option>Выберите дату</option>
                <option>1.01.2023</option>
                <option>5.01.2023</option>
                <option>20.01.2023</option>
                <option>29.12.2022</option>
                <option>31.12.2022</option>
            </select>
            <p class = "errors" id = "dataerr"></p>
        </div>

        <div class = "user-box">
            <input type = "file" name = "file-name" onchange="showFile(this)">
            <p class = "errors" id = "fileerr"></p>
        </div>


    </form>
    <center>
        <p>
            <input type ="button" class ="bn3637 bn36" value ="Сохранить"
                   onclick="SendApplication()">
        </p>
    </center>
</div>

</body>
</html>