package com.victortello.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.victortello.utils.ConexionJDBC;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class ConexionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try (Connection connection = ConexionJDBC.getConnection()) {

            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }

            try {
                request.setAttribute("connection", connection);
                chain.doFilter(request, response);
                connection.commit();
            } catch (SQLException exception) {
                connection.rollback();
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, exception.getMessage());
                exception.printStackTrace();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

}
