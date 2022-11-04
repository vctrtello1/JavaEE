package com.victortello.form;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        try (PrintWriter out = resp.getWriter()) {

            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<head>");
            out.print("<title>Resultado Form</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>");
            out.print("Resultado Form");
            out.print("</h1>");
            out.print("parametros" + username + " " + password + " " + email);
            out.print("</body>");
            out.print("</html>");
            out.close();
        }
    }

}
