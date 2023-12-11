package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {


    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/job";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Nithish14112004";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
