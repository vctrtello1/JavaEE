package com.victortello.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import com.victortello.services.LoginService;
import com.victortello.services.LoginServiceSessionsImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/login", "/login.htnl" })
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "victorT";
    final static String PASSWORD = "Marruco$67";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            resp.setContentType("text/html;charset=UTF-8");

            req.getSession().setAttribute("username", username);

            resp.sendRedirect(req.getContextPath() + "/login");

        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Lo sentimos no esta autorizado para ingresar a esta página!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionsImpl();

        Optional<String> usernameOptional = auth.getUsername(req);

        if (usernameOptional.isPresent()) {

            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Hola " + usernameOptional.get() + "</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Login correcto!</h1>");
                out.println("<p><a href='" + req.getContextPath() + "/index.html'>volver</a></p>");
                out.println("<p><a href='" + req.getContextPath() + "/logout'>cerrar sesión</a></p>");
                out.println("</body>");
                out.println("</html>");
            }

        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

}
