package com.company;

/**
 * Created by Andrei 30.04.2017.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Servletic extends HttpServlet  {

    private static final long serialVersionUID = 1L;
    public Servletic() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String title = "Simple Servlet Output";
        response.setContentType("text/html");
        out.println("<HTML><HEAD><TITLE>");
        out.println(title);
        out.println("</TITLE></HEAD><BODY>");
        out.println("<H1>" + title + "</H1>");
        out.print("<P>This is ");
        out.print(this.getClass().getName());
        out.print(", using the GET method");
        out.println("</BODY></HTML>");
        out.close();
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}




