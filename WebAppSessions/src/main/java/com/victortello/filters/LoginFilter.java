package com.victortello.filters;

import java.io.IOException;
import java.util.Optional;

import com.victortello.services.LoginService;
import com.victortello.services.LoginServiceSessionsImpl;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter({ "/verCarro", "agregarCarro", "/actualizarCarro" })
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LoginService loginService = new LoginServiceSessionsImpl();
        Optional<String> username = loginService.getUsername((HttpServletRequest) request);

        if (username.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
        }

    }

}
