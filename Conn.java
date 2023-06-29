package employee.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Register the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            // Creating the connection string
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","11021994seema@2023");
            
            // Creating the statement class
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData(String firstName, String lastName, String phone, String email, String password) {
        try {
            // Create a prepared statement to insert data into the database
            PreparedStatement ps = c.prepareStatement("INSERT INTO users (firstName, lastName, phone, email, password) VALUES (?, ?, ?, ?, ?)");

            // Set the values for the prepared statement
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, password);

            // Execute the prepared statement
            ps.executeUpdate();

            // Close the prepared statement
            ps.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
