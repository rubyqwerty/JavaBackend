<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Новости</title>
    <link href="css/PageNews.css" rel="stylesheet" type="text/css"/>
    <link href="css/ApplicationStyle.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <script src="js/AccountScript.js" type="text/javascript"></script>
    <script src="js/NewsScript.js" type="text/javascript"></script>
</head>
<body onload = "checkAdmin(); getBase('News');">
<nav class="navMenu" id = "menu">
    <a href="Account.jsp" id = "acadmin" >Кабинет</a>
    <a href="CreateApplication.jsp">Создать</a>
    <a href="Application.jsp">Заявки</a>
    <a href="News.jsp"><p class = "cur">Новости</p></a>
    <div class="dot"></div>
</nav>

<center>


<p id = "All"></p>
</center>

</body>
</html>