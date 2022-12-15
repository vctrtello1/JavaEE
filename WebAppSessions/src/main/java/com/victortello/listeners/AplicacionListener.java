package com.victortello.listeners;

import com.victortello.models.Carro;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    private ServletContext servletContext;

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        servletContext.log("Terminando la applicacion");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Iniciando la applicacion");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensajeApp", "Hola app");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("Terminando el request");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Iniciando el request");
        sre.getServletRequest().setAttribute("mensajeRequest", "Hola request");

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Iniciando session");
        Carro carro = new Carro();
        HttpSession httpSession = se.getSession();
        httpSession.setAttribute("carro", carro);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Terminando session");

    }

}
