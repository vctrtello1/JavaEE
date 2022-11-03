package com.victortello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/holamundo")
public class HolaMundoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset='UTF-8'>");
        out.print("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("<head>");
        out.print("<title>Hola mundo, servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>");
        out.print("Hola mundo, servlet");
        out.print("</h1");
        out.print("</body>");
        out.print("</html>");
        out.close();

    }

}
