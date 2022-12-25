package com.example.cinema;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ApplicationServlet", value = "/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=Windows-1251");

        String count = request.getParameter("count");
        String row = request.getParameter("row");
        String place = request.getParameter("place");
        String date = request.getParameter("date");
        String movie = request.getParameter("movie");
        String nameFile = request.getParameter("nameFile");

        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> answer = new HashMap<>();

        answer.put("count" ,  CheckInput.check("[1-9]{1}",count,"Цифра от 1 до 9"));
        answer.put("row" ,  CheckInput.check("[1-9]{1,2}",row,"Число от 1 до 99"));
        answer.put("place" ,  CheckInput.check("[1-9]{1,2}",place,"Число от 1 до 99"));
        if (date.equals("Выберите дату"))
            answer.put("date", "Выберете дату");
        else answer.put("date", "ok");

        if (movie.equals("Выберите фильм"))
            answer.put("movie", "Выберете фильм");
        else answer.put("movie", "ok");

        if (answer.get("count").equals("ok") && answer.get("row").equals("ok")
                && answer.get("place").equals("ok") && answer.get("date").equals("ok") && answer.get("movie").equals("ok")){

            HttpSession session = request.getSession();
            BaseUsers base = CheckInput.GetBase();
            User user = base.Base.get(session.getAttribute("current-user"));
            if (!request.getParameter("redaction").equals("null")){
                int redactions = Integer.parseInt(request.getParameter("redaction"));
                user.Applications.set(redactions, new Application(movie, date, row, place, count, nameFile));
            }
            else {
                user.Applications.add(new Application(movie, date, row, place, count, nameFile));
            }
                CheckInput.UpdateUser(user);

            answer.put("status" , "ok");
        }

        String MasAnswer = mapper.writeValueAsString(answer);
        PrintWriter out = response.getWriter();
        out.print(MasAnswer);
        out.flush();
    }
}
