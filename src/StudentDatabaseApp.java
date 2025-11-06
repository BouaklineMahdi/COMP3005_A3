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
    private static final String PASSWORD = "Mahdi0610$";
    
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
     * Retrieves and displays all records from the students table
     * 
     * This function demonstrates the SELECT query using Statement
     */
    public static void getAllStudents() {
        // SQL query to select all students
        String sql = "SELECT * FROM students ORDER BY student_id";
        
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n=== All Students ===");
            System.out.println("--------------------------------------------------");
            
            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                Date enrollmentDate = rs.getDate("enrollment_date");
                
                System.out.printf("ID: %d | Name: %s %s | Email: %s | Enrolled: %s%n",
                                id, firstName, lastName, email, enrollmentDate);
            }
            System.out.println("--------------------------------------------------");
            
        } catch (SQLException e) {
            System.err.println("Error retrieving students:");
            e.printStackTrace();
        }
    }

    /**
     * Inserts a new student record into the students table
     * 
     * This function demonstrates INSERT using PreparedStatement to prevent SQL injection
     * 
     * @param firstName Student's first name
     * @param lastName Student's last name
     * @param email Student's email address
     * @param enrollmentDate Student's enrollment date (format: YYYY-MM-DD)
     */
    public static void addStudent(String firstName, String lastName, 
                                  String email, String enrollmentDate) {
        // SQL INSERT statement with placeholders (?)
        String sql = "INSERT INTO students (first_name, last_name, email, enrollment_date) " +
                     "VALUES (?, ?, ?, ?)";
        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Set parameters for the PreparedStatement
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setDate(4, Date.valueOf(enrollmentDate));
            
            // Execute the INSERT operation
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("Student added successfully: " + firstName + " " + lastName);
            }
            
        } catch (SQLException e) {
            System.err.println("Error adding student:");
            e.printStackTrace();
        }
    }

    /**
     * Updates the email address for a student with the specified student_id
     * 
     * This function demonstrates UPDATE using PreparedStatement
     * 
     * @param studentId The ID of the student to update
     * @param newEmail The new email address
     */
    public static void updateStudentEmail(int studentId, String newEmail) {
        // SQL UPDATE statement with placeholders
        String sql = "UPDATE students SET email = ? WHERE student_id = ?";
        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Set parameters
            pstmt.setString(1, newEmail);
            pstmt.setInt(2, studentId);
            
            // Execute the UPDATE operation
            int rowsUpdated = pstmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("Email updated successfully for student ID " + studentId);
            } else {
                System.out.println("No student found with ID " + studentId);
            }
            
        } catch (SQLException e) {
            System.err.println("Error updating student email:");
            e.printStackTrace();
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
        System.out.println("\n[2] Adding a new student...");
        addStudent("Alice", "Johnson", "alice.j@example.com", "2023-09-03");
        getAllStudents();
        
        // 3. Update a student's email
        System.out.println("\n[3] Updating email for student ID 1...");
        updateStudentEmail(1, "john.updated@example.com");
        getAllStudents();
        
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