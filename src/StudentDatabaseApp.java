import java.sql.*;

/**
 * COMP3005 Assignment 3 - Database Interaction with PostgreSQL and JDBC
 * 
 * This application demonstrates CRUD operations on a PostgreSQL database
 * using JDBC (Java Database Connectivity).
 * 
 * @author Mahdi Bouakline
 * @date November 2025
 */
public class StudentDatabaseApp {
    // Database connection credentials
    // Don't really remember my credentials, hoping these are correct
    private static final String URL = "jdbc:postgresql://localhost:5432/students_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Mahdi0610";
    
    /**
     * Establishes and returns a connection to the PostgreSQL database
     * 
     * @return Connection object to the database
     * @throws SQLException if connection fails
     */
    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            
            // Connect to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            if (conn != null) {
                System.out.println("Connected to PostgreSQL successfully!");
            }
            return conn;
            
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
            throw new SQLException("Driver not found");
        }
    }
}