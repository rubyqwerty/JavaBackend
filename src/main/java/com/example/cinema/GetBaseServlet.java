package com.example.cinema;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetBaseServlet", value = "/GetBaseServlet")
public class GetBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");

        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = request.getSession();
        if (type.equals("userData")) {
            User user = CheckInput.GetBase().Base.get(session.getAttribute("current-user"));
            String Answer = mapper.writeValueAsString(user);
            out.print(Answer);
            out.flush();
        }
        else if (type.equals("AllUserData")){
            BaseUsers baseUsers = CheckInput.GetBase();
            String Answer = mapper.writeValueAsString(baseUsers);
            out.print(Answer);
            out.flush();
        }
        else if (type.equals("News")){
            BaseNews baseNews = CheckInput.GetBaseNews();
            String Answer = mapper.writeValueAsString(baseNews);
            out.print(Answer);
            out.flush();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
