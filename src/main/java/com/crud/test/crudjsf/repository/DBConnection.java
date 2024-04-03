package com.crud.test.crudjsf.repository;

import java.sql.*;

/**
 *
 * @author Rishabh
 */
public class DBConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    // Static block to load the JDBC driver class
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception appropriately, such as logging an error message or throwing a RuntimeException
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

}
