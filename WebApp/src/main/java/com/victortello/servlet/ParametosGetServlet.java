package com.victortello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/parametrosget")
public class ParametosGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset='UTF-8'>");
        out.print("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("<head>");
        out.print("<title>Hola mundo, parametro get</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>");
        out.print("Hola mundo, parametro get ");
        out.print("</h1");
        out.print("<h4>"); 
        out.print(saludo + " " + nombre);
        out.print("</h4>");
        out.print("</body>");
        out.print("</html>");
        out.close();
    }

}
