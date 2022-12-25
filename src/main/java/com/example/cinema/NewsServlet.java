package com.example.cinema;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "NewsServlet", value = "/NewsServlet")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String nameOfNew = request.getParameter("nameOfNew");
        String text = request.getParameter("text");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> answer = new HashMap<>();
        answer.put("status", "ok");
        if (request.getParameter("type").equals("0")) {
            CheckInput.SetNewInBase(new News(nameOfNew, text));
        }
        else{
            String numberOfNew = request.getParameter("numberOfNew");
            CheckInput.UpdateNew(Integer.parseInt(numberOfNew), new News(nameOfNew, text));
        }
        String MasAnswer = mapper.writeValueAsString(answer);
        PrintWriter out = response.getWriter();
        out.print(MasAnswer);
        out.flush();
    }


}
