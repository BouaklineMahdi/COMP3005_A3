# COMP3005 Assignment 3 - Student Database Management

**Author:** Mahdi Bouakline  
**Course:** COMP3005 - Database Management Systems  
**Date:** November 2025

## Overview
This application connects to a PostgreSQL database and performs CRUD (Create, Read, Update, Delete) operations on a `students` table using Java and JDBC.

## Prerequisites
- **Java Development Kit (JDK)** - Version 8 or higher
- **PostgreSQL** - Version 12 or higher
- **PostgreSQL JDBC Driver** - Download from: https://jdbc.postgresql.org/download/

## Project Structure
```
COMP3005_Assignment3/
├── lib/
│   └── postgresql-42.7.0.jar       # JDBC driver
├── src/
│   └── StudentDatabaseApp.java     # Main application
├── db_setup.sql                     # Database creation script
├── README.md                        # This file
└── demo_video_link.txt             # Link to demonstration video
```

### Compile the Application
The easiest way to compile the project is to on StudentDatabaseApp.java and run the program, but it can be done through terminal/command prompt.

Open a terminal/command prompt in the project root directory and run:

**Windows:**
```bash
javac -cp "lib/postgresql-42.7.0.jar" src/StudentDatabaseApp.java
```

**Mac/Linux:**
```bash
javac -cp "lib/postgresql-42.7.0.jar" src/StudentDatabaseApp.java
```

### Run the Application
**Windows:**
```bash
java -cp "lib/postgresql-42.7.0.jar;src" StudentDatabaseApp
```

**Mac/Linux:**
```bash
java -cp "lib/postgresql-42.7.0.jar:src" StudentDatabaseApp
```

## Functions Implemented

### 1. `getAllStudents()`
- **Purpose:** Retrieves and displays all student records from the database
- **SQL Operation:** `SELECT`
- **Implementation:** Uses `Statement` to execute query and `ResultSet` to process results

### 2. `addStudent(String firstName, String lastName, String email, String enrollmentDate)`
- **Purpose:** Inserts a new student record into the database
- **SQL Operation:** `INSERT`
- **Implementation:** Uses `PreparedStatement` to prevent SQL injection
- **Parameters:**
  - `firstName`: Student's first name
  - `lastName`: Student's last name
  - `email`: Student's email (must be unique)
  - `enrollmentDate`: Enrollment date in format `YYYY-MM-DD`

### 3. `updateStudentEmail(int studentId, String newEmail)`
- **Purpose:** Updates the email address for a specific student
- **SQL Operation:** `UPDATE`
- **Implementation:** Uses `PreparedStatement` with parameterized query
- **Parameters:**
  - `studentId`: The ID of the student to update
  - `newEmail`: The new email address

### 4. `deleteStudent(int studentId)`
- **Purpose:** Deletes a student record from the database
- **SQL Operation:** `DELETE`
- **Implementation:** Uses `PreparedStatement` for safe deletion
- **Parameters:**
  - `studentId`: The ID of the student to delete

## Demonstration Video
**Link:** https://youtu.be/5lL9dfpRBMs

The video demonstrates:
1. Database setup with initial data in pgAdmin
2. Execution of all four CRUD operations
3. Verification of results

## Technologies Used
- **Java** - Programming language
- **JDBC (Java Database Connectivity)** - Database connection API
- **PostgreSQL** - Relational database management system
- **PreparedStatement** - For secure, parameterized SQL queries


## Database Schema

## Initial Data
The database is populated with three initial student records:
1. John Doe - john.doe@example.com - Enrolled: 2023-09-01
2. Jane Smith - jane.smith@example.com - Enrolled: 2023-09-01
3. Jim Beam - jim.beam@example.com - Enrolled: 2023-09-02

## Notes
- All database connections are properly closed using try-with-resources
- Error messages are printed to System.err for better debugging
- The application demonstrates best practices for JDBC as taught in the lecture

## Contact
**Student:** Mahdi Bouakline  
**Student ID:** 101257788
**Email:** mahdibouakline@cmail.carleton.ca