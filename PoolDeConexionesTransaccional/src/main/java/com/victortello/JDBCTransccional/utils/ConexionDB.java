package com.victortello.JDBCTransccional.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static String url = "jdbc:mysql://localhost:3306/Pruebas";
    private static String username = "root";
    private static String pass = "Puma18ar";
    private static Connection connection;

    public static Connection getInstance() throws SQLException{
        if(connection == null){
            connection = DriverManager.getConnection(url,username,pass);

        }

        return connection;
    }
}
