package com.victorTello.Pool.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static String url = "jdbc:mysql://localhost:3306/Pruebas";
    private static String username = "root";
    private static String pass = "Puma18ar";

    public static Connection getInstance() throws SQLException {

        return DriverManager.getConnection(url, username, pass);
    }
}
