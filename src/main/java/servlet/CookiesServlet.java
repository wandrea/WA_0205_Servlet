package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/CookiesServlet")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies= req.getCookies();
        PrintWriter printWriter = resp.getWriter();


        for(Cookie c :cookies){
            printWriter.write("<br> Name: "+ c.getName() + "Value: " + c.getValue() + "<br>");

        }
        printWriter.close();
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        Cookie cookie = new Cookie("testName", "testValue");


        resp.addCookie(cookie);


        //visszairányítson a cookies.html-re
        req.getRequestDispatcher("cookies.html").include(req,resp);
    }

}
