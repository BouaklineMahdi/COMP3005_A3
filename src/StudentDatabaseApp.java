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

    /**
     * Main method - demonstrates all CRUD operations
     * 
     * This method executes each function and shows the results
     */
    public static void main(String[] args) {
        System.out.println("__________________________________________________________");
        System.out.println("   COMP3005 Assignment 3 - Student Database Manager       ");
        System.out.println("   Mahdi Bouakline                                        ");
        System.out.println("__________________________________________________________");
        
        // 1. Display initial students
        System.out.println("\n[1] Displaying all students (Initial Data):");
        getAllStudents();
        
        // 2. Add a new student
        // INCOMPLETE
        //System.out.println("\n[2] Adding a new student...");
        //addStudent("Alice", "Johnson", "alice.j@example.com", "2023-09-03");
        //getAllStudents();
        
        // 3. Update a student's email
        // INCOMPLETE
        //System.out.println("\n[3] Updating email for student ID 1...");
        //updateStudentEmail(1, "john.updated@example.com");
        //getAllStudents();
        
        // 4. Delete a student
        // INCOMPLETE
        //System.out.println("\n[4] Deleting student ID 3...");
        //deleteStudent(3);
        //getAllStudents();
        
        System.out.println("\n__________________________________________________________");
        System.out.println("   All operations completed successfully!                ");
        System.out.println("__________________________________________________________");
    }
}