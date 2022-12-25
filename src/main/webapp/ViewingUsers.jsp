<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>База пользователей</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="css/ApplicationStyle.css" rel="stylesheet" type="text/css"/>
  <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
  <link href="css/StyleAccount.css" rel="stylesheet" type="text/css"/>
  <script src="js/AccountScript.js" type="text/javascript"></script>
  <script src="js/ViewingUsersScript.js" charset="utf-8" type="text/javascript"></script>
</head>
<body onload = "getBase('AllUserData'); block()">

<nav class="navMenu" id = "menu">
  <a href="AccountAdmin.jsp">Кабинет</a>
  <a href="CreateApplication.jsp">Создать</a>
  <a href="Application.jsp">Заявки</a>
  <a href="News.jsp">Новости</a>
  <a href="ViewingUsers.jsp" class = "cur"><p class = "cur">База</p></a>
  <a href="CreateNews.jsp">Создать новость</a>
  <a href="RedactionNews.jsp">Редакция</a>
  <div class="dot"></div>
</nav>
<p class = "create"> <input type ="button" class ="bn3637 bn36" id = "creareUser" value ="Создать пользователя" onclick="createUser()"></p>
<div class="login-box">
  <h2>Пользователи</h2>
  <form>

    <div class = "user-box">
      <input type = "text" id = "email" class = 'count' readonly>
      <label id = "emaillabel"></label>
      <p class = "errors" id = "emailerr"></p>
    </div>

    <div class = "user-box">
      <input type = "text" id = "name" class = 'count'>
      <label>Имя пользователя</label>
      <p class = "errors" id = "nameerr"></p>
    </div>

    <div class = "user-box">
      <input type = "text" id = "password" class = 'count'>
      <label>Пароль</label>
      <p class = "errors" id = "passworderr"></p>
    </div>

    <div id = "ID">
      <select class="select-css" id = "role" >
        <option>user</option>
        <option>Admin</option>
        <option>Moderator</option>
      </select>
    </div>
    <p class = "ok" id = "ok"></p>
  </form>

  <center>
    <div id = "buttons">
    <p>
      <input type ="button" class ="bn3637 bn36" value ="Сохранить"
             onclick="sendChange()">
    </p>
    <p>
      <input type ="button" class ="bn3637 bn36" value ="<----"
             onclick="Left()">
      <input type ="button" class ="bn3637 bn36" value ="---->"
             onclick="Right()">
    </p>
  </div>
  </center>
</div>

</body>
</html>