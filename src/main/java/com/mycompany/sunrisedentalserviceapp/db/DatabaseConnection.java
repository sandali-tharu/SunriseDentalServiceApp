package com.mycompany.sunrisedentalserviceapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton Design Pattern for Database Connection
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private final String url = "jdbc:mysql://localhost:3306/sunrise_dental_db";
    private final String username = "root";
    private final String password = "";

    // Private Constructor
    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Driver Not Found: " + ex.getMessage());
        }
    }

    // Thread-safe Singleton Instance Access Method
    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection() == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Returns active database connection
    public Connection getConnection() {
        return connection;
    }
}