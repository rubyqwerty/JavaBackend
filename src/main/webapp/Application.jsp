<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Мои заявку</title>

  <link href="css/ApplicationStyle.css"  rel="stylesheet" type="text/css"/>
  <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
  <script src="js/ApplicationScript.js" charset="utf-8" type="text/javascript"></script>
  <script src="js/AccountScript.js" type="text/javascript"></script>
</head>

<body onload = "checkAdmin(); getBase('userData');">
<nav class="navMenu">
  <a href="Account.jsp" id = "acadmin">Кабинет</a>
  <a href="CreateApplication.jsp">Создать</a>
  <a href="Application.jsp"><p class = "cur">Заявки</p></a>
  <a href="News.jsp">Новости</a>
  <div class="dot"></div>
</nav>



<div class="login-box">
  <h2>Мои заявки</h2>
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
      <select class="select-css" id = "movie" >
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
    <label id = "curfile" class = "file"></label>
    <p class = "ok" id = "ok"></p>
  </form>
  <center>
    <p>
      <input type ="button" class ="bn3637 bn36" value ="Сохранить"
             onclick="RedactionApplication()">
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