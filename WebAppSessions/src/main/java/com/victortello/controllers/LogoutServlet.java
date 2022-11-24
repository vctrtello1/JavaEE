package com.victortello.controllers;

import java.io.IOException;
import java.util.Optional;

import com.victortello.services.LoginService;
import com.victortello.services.LoginServiceSessionsImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionsImpl();
        Optional<String> username = auth.getUsername(req);

        if (username.isPresent()) {
            HttpSession session = req.getSession();
            session.invalidate();

        }
        resp.sendRedirect(req.getContextPath() + "/login.htnl");

    }

}
