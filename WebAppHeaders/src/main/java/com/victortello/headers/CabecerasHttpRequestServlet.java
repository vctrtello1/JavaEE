package com.victortello.headers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cabecerasRequest")
public class CabecerasHttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String metodoHttp = req.getMethod();
        String requestUri = req.getRequestURI();
        String requestUrl = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPah = req.getServletPath();

        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {

            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<head>");
            out.print("<title>Cabeceras Http Request</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>");
            out.print("Cabeceras");
            out.print("</h1");
            out.print("<ul");
            out.print("<li>" + metodoHttp + "</li>");
            out.print("<li>" + requestUri + "</li>");
            out.print("<li>" + requestUrl + "</li>");
            out.print("<li>" + contextPath + "</li>");
            out.print("<li>" + servletPah + "</li>");
            out.print("</ul");
            out.print("</body>");
            out.print("</html>");
            out.close();
        }

    }

}
