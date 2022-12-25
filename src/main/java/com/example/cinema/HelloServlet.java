package com.example.cinema;

import com.example.cinema.CheckInput;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class HelloServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> answer = new HashMap<>();

        answer.put("name" ,  CheckInput.check("[а-яА-Я|a-zA-z]{2,10}",name,"Имя должно содержать только буквы"));
        answer.put("password", CheckInput.check("[a-zA-Z|0-9]{1,20}",password,"Длина должна быть >8"));
        answer.put("email", CheckInput.check("[a-zA-z|0-9|!|$|%|^|&|*]{2,20}@mail.ru",email,"Почта должна иметь вид: example@mail.ru"));

        if (answer.get("name").equals("ok") && answer.get("password").equals("ok") && answer.get("email").equals("ok")) {
            answer.put("email", CheckInput.SetInBase(new User(name,email,password)));
        }

        String MasAnswer = mapper.writeValueAsString(answer);

        PrintWriter out = response.getWriter();

        out.print(MasAnswer);
        out.flush();
    }

    public void destroy() {
    }

}