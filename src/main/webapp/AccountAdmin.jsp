<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

  <title>Аккаунт</title>


  <link href="css/StyleAccount.css" rel="stylesheet" type="text/css"/>
  <link href="css/ApplicationStyle.css" rel="stylesheet" type="text/css"/>
  <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
  <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
  <script src="js/AccountScript.js" type="text/javascript"></script>
</head>

<body onload = "SetPictures(); block()">
<p class = "exit"><input type ="button" class ="bn3637 bn36" value ="Выйти"  onclick="Exit()"></p>
<p class = "hello">Текущий пользователь: <%=session.getAttribute("current-user")%></p>
<nav class="navMenu" id = "menu">
  <a href="AccountAdmin.jsp" class = "cur"><p class = "cur">Кабинет</p></a>
  <a href="CreateApplication.jsp">Создать</a>
  <a href="Application.jsp">Заявки</a>
  <a href="News.jsp">Новости</a>
  <a href="ViewingUsers.jsp">База</a>
  <a href="CreateNews.jsp">Создать новость</a>
  <a href="RedactionNews.jsp"> Редакция </a>
  <div class="dot"></div>
</nav>

<img id = "avatarka" src = "" class = "picture">
<form class = "formSend" method="post" action="http://localhost:8080/Cinema_war/FileServlet" enctype="multipart/form-data">
  <input type = "file" name = "file-name" id = "pic">
  <button >Send</button>
</form>



</body>
</html>