<%@ page import="java.util.Date" %>
<%@ page import="com.example.cinema.CheckInput" %>
<%@ page import="com.example.cinema.NumberOfVisit" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Кинотеатр</title>
    <link href="css/StyleForm.css" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="stylesheet">
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <script src="js/enterance.js" type="text/javascript"></script>

</head>

<%
    Integer count = (Integer) session.getAttribute("count");
    if (count == null){
        NumberOfVisit num = CheckInput.GetNumber();
        session.setAttribute("count" , num.count + 1);
    }
    else {
        session.setAttribute("count", count + 1);
    }
    CheckInput.SetNumberOfVisit((Integer)session.getAttribute("count"));
%>
<p class = "info"><%= new Date() %> Количество посещений: <%=session.getAttribute("count")%></p>

<body>

<div class="main">
    <input type="checkbox" id="chk" aria-hidden="true">

    <div class="signup">
        <form>
            <label for="chk" aria-hidden="true">Регистрация</label>
            <input type="text" name="txt" placeholder="User name" required="" id = "NAME">
            <center><p class = "error" id = "errorName">.</p></center>
            <input type="email" name="email" placeholder="Email" required="" id = "MAIL">
            <center><p class = "error" id = "errorMail">.</p></center>
            <input type="password" name="pswd" placeholder="Password" required="" id = "PASSWORD">
                <center><p class = "error" id = "errorPass">.</p></center>

        </form>
        <button onclick="SetDataToRegisrtation()">Sign up</button>
    </div>
<br>
    <div class="login">
        <form>
            <label for="chk" aria-hidden="true">Войти</label>
            <input type="email" name="email" placeholder="Email" required="" id = "MAILTOENTER">
            <input type="password" name="pswd" placeholder="Password" required="" id = "PASSWORDTOENTER">
            <center><p id = "errorEnter">`</p></center>
        </form>
        <button onclick = "CheckDataToEnterance()">Login</button>
    </div>
</div>
</body>
</html>