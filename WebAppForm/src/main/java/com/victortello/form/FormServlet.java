package com.victortello.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");

        String idioma = req.getParameter("idioma");
        String habilitar = req.getParameter("habilitar");
        String secreto = req.getParameter("secreto");

        Map<String, String> errores = new HashMap<>();

        // validar errores

        if (username == null || username.isBlank()) {
            errores.put("username","el username es requerido");
        }

        if (password == null || password.isBlank()) {
            errores.put("password","el password no puede ser vacio");
        }

        if (email == null || !email.contains("@")) {
            errores.put("email","el email es requerido y debe tener un formato de correo");
        }
        if (errores.isEmpty()) {
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

                // mostrar parametros

                out.print(username + " " + password + " " + email + " " + pais + " ");

                // lista de lenguajes

                if (lenguajes != null) {
                    out.println("<li>Lenguajes: <ul>");
                    Arrays.asList(lenguajes).forEach(lenguaje -> {
                        out.print("<li>" + lenguaje + "</li>");
                    });
                    out.print("</ul></li>");

                }
                // lista de roles

                if (roles != null) {
                    out.println("<li>Roles: <ul>");
                    Arrays.asList(roles).forEach(rol -> {
                        out.print("<li>" + rol + "</li>");
                    });
                    out.print("</ul></li>");

                }

                // parametros extras
                out.print("<li>" + idioma + "</li>");
                out.print("<li>" + habilitar + "</li>");
                out.print("<li>" + secreto + "</li>");

                out.print("</body>");
                out.print("</html>");
                out.close();

            }

        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            ;
        }

    }

}
