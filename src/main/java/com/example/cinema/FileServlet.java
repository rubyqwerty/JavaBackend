package com.example.cinema;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "FileServlet", value = "/FileServlet")
@MultipartConfig()
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String namePage = "";
        for (Part part : request.getParts())
        {
            if (part != null) {
                HttpSession session = request.getSession();
                BaseUsers base = CheckInput.GetBase();
                User user = base.Base.get(session.getAttribute("current-user"));
                if (user.role.equals("Admin"))
                    namePage = "AccountAdmin.jsp";
                else if (user.role.equals("Moderator"))
                    namePage = "AccountModerator.jsp";
                else
                    namePage = "Account.jsp";
                user.nameOfPicture = part.getSubmittedFileName();
                CheckInput.UpdateUser(user);
                String nameFile = part.getSubmittedFileName();
                part.write( getServletContext().getRealPath("/Pictures/") + part.getSubmittedFileName());
                CheckInput.copyFile(new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema_war\\Pictures\\"+nameFile),
                        new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema\\src\\main\\webapp\\Pictures\\"+nameFile));
            }
        }




        String url = "http://localhost:8080/Cinema_war/" + namePage;
        response.sendRedirect(url);
    }
}

