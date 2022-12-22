package com.victortello.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionJDBC {
    private static String url = "jdbc:mysql://localhost:3306/Pruebas";
    private static String username = "root";
    private static String pass = "Puma18ar";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {

        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(pass);

            // configuraciones de pool iniciales
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(10);
            pool.setMaxTotal(12);
        }

        return pool;
    }

    public static Connection getConnection() throws SQLException {

        return getInstance().getConnection();

    }
}
