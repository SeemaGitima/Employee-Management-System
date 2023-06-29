package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField tf1,tf2;
    JButton login;
    Login(){
        // Set background color
        getContentPane().setBackground(new Color(0, 184, 184));
        setLayout(null);
        
        // Create labels username and password with textfield where we take input 
        JLabel l1 = new JLabel("Username");
        l1.setBounds(50, 50, 120, 40);
        add(l1);
        
        // Text field for username tf1
        tf1 = new JTextField();
        tf1.setBounds(150, 55, 140, 30);
        add(tf1);
        
        // Label for password
        JLabel l2 = new JLabel("Password");
        l2.setBounds(50, 120, 120, 40);
        add(l2);
        
        // Text field for password
        tf2 = new JPasswordField();
   tf2.setBounds(150, 125, 140, 30);
        add(tf2);
        
        // Add image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/female employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 50, 120, 120);
        add(image);
        
        // Create login button & sign up button
        login = new JButton("LOGIN");
        login.setBackground(Color.LIGHT_GRAY);
        login.setForeground(Color.black);
        login.setBounds(150, 190, 140, 30);
        login.addActionListener(this);
        add(login);
        
        // Create frame
        setTitle("Login Page");
        setSize(600, 300);
        setVisible(true);
        setLocation(375, 175);
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            String l1 = tf1.getText();
            String l2 = tf2.getText();
            Conn c = new Conn();
            String query = "SELECT * FROM login WHERE UserName = '" + l1 + "' AND password = '" + l2 + "'";
            ResultSet rs = c.s.executeQuery(query);
            
            if (rs.next()) {
                setVisible(false);
               new Home();
            } else {
    JOptionPane.showMessageDialog(this, "Invalid username or password");
            setVisible(false);
            }
            
                } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}

