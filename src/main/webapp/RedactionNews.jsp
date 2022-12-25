<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Редакция</title>
    <link href="css/ApplicationStyle.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <script src="js/AccountScript.js" type="text/javascript"></script>
    <script src="js/RedactionNewsScript.js" type="text/javascript"></script>
</head>
<body onload = "checkAdmin(); getBase('News'); block()">
<nav class="navMenu" id = "menu">
    <a href="AccountModerator.jsp" id = "acadmin" >Кабинет</a>
    <a href="CreateApplication.jsp">Создать</a>
    <a href="Application.jsp">Заявки</a>
    <a href="News.jsp">Новости</a>
    <a href="CreateNews.jsp">Создать новость</a>
    <a href="RedactionNews.jsp"><p class = "cur">Редакция</p></a>
    <div class="dot"></div>
</nav>

<div class="login-box">
    <h2>Новость</h2>
    <form>

        <div class = "user-box">
            <input type = "text" id = "NameNew" required=""
                   class = 'text'>
            <label>Заголовок</label>
            <p class = "errors" id = "nameerr"></p>
        </div>

        <textarea id = "NewText"></textarea>
        <p class = "errors" id = "texterr"></p>
        <p class = "ok" id = "ok"></p>
    </form>
    <center>
        <p>
            <input type ="button" class ="bn3637 bn36" value ="Обновить"
                   onclick="RedactionNew()">
        </p>

        <p>
            <input type ="button" class ="bn3637 bn36" value ="<----"
                   onclick="Left()">
            <input type ="button" class ="bn3637 bn36" value ="---->"
                   onclick="Right()">
        </p>
    </center>
</div>

</body>
</html>