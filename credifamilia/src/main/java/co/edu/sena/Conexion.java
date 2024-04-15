package co.edu.sena;

import java.sql.*;

public class Conexion {

    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver"; // Replace with your actual driver class name
    private static final String DB_URL = "jdbc:mysql://localhost:3306/credifamilia"; // Replace with your actual database URL
    private static final String USERNAME = "root"; // Replace with your actual username
    private static final String PASSWORD = ""; // Replace with your actual password

    private Connection connection;

    public Conexion() {
        try {
            // Register JDBC driver
            Class.forName(DRIVER_CLASS_NAME);

            // Establish connection
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

