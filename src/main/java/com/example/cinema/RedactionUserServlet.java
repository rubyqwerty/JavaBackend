package com.example.cinema;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RedactionUserServlet", value = "/RedactionUserServlet")
public class RedactionUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Map<String, String> answer = new HashMap<>();
        answer.put("name" ,  CheckInput.check("[а-яА-Я|a-zA-z]{2,10}",name,"Имя должно содержать только буквы"));
        answer.put("password", CheckInput.check("[a-zA-Z|0-9]{8,20}",password,"Длина должна быть >8"));

        if (answer.get("name").equals("ok") && answer.get("password").equals("ok")){
            BaseUsers baseUsers = CheckInput.GetBase();
            User user = baseUsers.Base.get(email);
            user.name = name;
            user.role = role;
            user.password = password;
            CheckInput.UpdateUser(user);
            answer.put("status" , "ok");
        }

        ObjectMapper mapper = new ObjectMapper();
        String MasAnswer = mapper.writeValueAsString(answer);
        PrintWriter out = response.getWriter();
        out.print(MasAnswer);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
