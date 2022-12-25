package com.example.cinema;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/enterance")
public class EnteranceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        Map<String, String> answer = new HashMap<>();

        answer.put("status", CheckInput.CheckUser(new User("", email, password)));

        if (answer.get("status").equals("ok")){
                HttpSession session = request.getSession();
                BaseUsers baseUsers = CheckInput.GetBase();
                answer.put("role", baseUsers.Base.get(email).role);
                answer.put("current-user" , email);
                session.setAttribute("current-user" , email);
        }
        ObjectMapper mapper = new ObjectMapper();

        String MasAnswer = mapper.writeValueAsString(answer);


        PrintWriter out = response.getWriter();
        out.print(MasAnswer);
        out.flush();

    }

}
