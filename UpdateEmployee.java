package employee.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    
    JTextField tf_state,tf_education,tf_email,tf_address,tf_desgination,tf_father_name, tf_contact,tf_salary ,tf_aadhar;
    JComboBox cb_state;
    JLabel lb_empId, lblname, lbl_dob ;
    JButton update_details, back;
    String  Emp_Id;
    
     UpdateEmployee(String Emp_Id){
         this.Emp_Id = Emp_Id;
        // Set background color
        getContentPane().setBackground(new Color(0, 184, 184));
        setLayout(null);
        
        JLabel l = new JLabel("Update Employee Details") ;
        l.setBounds(250, 10, 400,35);
        l.setFont(new Font("TimesnewRoman", Font.PLAIN,20));
        l.setBackground(Color.GRAY);
        add(l);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50,50,150,30);
        add(name);
        lblname = new JLabel();
        lblname.setBounds(150,50,150,30);
        add(lblname);
        
        JLabel f_name = new JLabel("Father's Name");
        f_name.setBounds(350,50,150,30);
        add(f_name);
        tf_father_name = new JTextField();
        tf_father_name.setBounds(480,50,150,30);
        add(tf_father_name); 
       
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,100,150,30);
        add(dob);
        lbl_dob = new JLabel();
        lbl_dob.setBounds(150,100,150,30);
        add(lbl_dob);
        
        JLabel email = new JLabel("Email ");
        email.setBounds(350,100,150,30);
        add(email);
        tf_email = new JTextField();
        tf_email.setBounds(480,100,150,30);
        add(tf_email);
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(50,150,150,30);
        add(salary);
        tf_salary = new JTextField();
        tf_salary.setBounds(150,150,150,30);
        add(tf_salary);
        
        JLabel contact = new JLabel("Contact No.");
        contact.setBounds(350,150,150,30);
        add(contact);
        tf_contact = new JTextField();
        tf_contact.setBounds(480,150,150,30);
        add(tf_contact);
        
        JLabel address = new JLabel("Address");
        address.setBounds(50,200,150,30);
        add(address);
        tf_address = new JTextField();
        tf_address.setBounds(150,200,150,30);
        add(tf_address);
        
        JLabel highest_qualification = new JLabel("Highest Education");
        highest_qualification.setBounds(350,200,150,30);
        add(highest_qualification);
        
        tf_education= new JTextField();
        tf_education.setBounds(480,200,150,30);
        add(tf_education);
        
        JLabel desgination = new JLabel("Desgination");
        desgination.setBounds(50,250,150,30);
        add(desgination);
        tf_desgination = new JTextField();
        tf_desgination.setBounds(150,250,150,30);
        add(tf_desgination);
       
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(350,250,150,30);
        add(aadhar);
        tf_aadhar= new JTextField();
        tf_aadhar.setBounds(480,250,150,30);
        add(tf_aadhar);
        
        JLabel emp_id = new JLabel("Employee ID");
        emp_id.setBounds(50,300,150,30);
        add(emp_id);
        lb_empId = new JLabel();
        lb_empId.setBounds(150,300,150,30);
        add(lb_empId); 
       
        JLabel state = new JLabel("State");
        state.setBounds(350,300,150,30);
        add(state);
       
        tf_state = new JTextField();
        tf_state.setBounds(480,300,150,30);
        add(tf_state);
        
        try{
            Conn c =new Conn();
            String query= "select * from employee where Emp_Id = '"+Emp_Id+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("Name"));
                tf_father_name.setText(rs.getString("FName"));
                lbl_dob.setText(rs.getString("DOB"));
                tf_salary.setText(rs.getString("Salary"));
                tf_address.setText(rs.getString("Address"));
                tf_contact.setText(rs.getString("Contact"));
                tf_education.setText(rs.getString("Education"));
                tf_email.setText(rs.getString("Email"));
                 tf_desgination.setText(rs.getString("Desgination"));
                tf_aadhar.setText(rs.getString("Aadhar"));
                lb_empId.setText(rs.getString("Emp_Id"));
                tf_state.setText(rs.getString("State"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        

        update_details = new JButton(" Update Details");
        update_details.setBackground(Color.LIGHT_GRAY);
        update_details.setForeground(Color.black);
        update_details.setBounds(100,400,150,30);
        update_details.addActionListener(this);
        add(update_details);
      
        back = new JButton("Back");
        back.setBackground(Color.LIGHT_GRAY);
        back.setForeground(Color.black);
        back.setBounds(400,400,150,30);
        back.addActionListener(this);
        add(back);
//        create frame
         setTitle("Update_Employee");
        setSize(700,500);
        setVisible(true);
        setLocation(350,100); 
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update_details) {
        String email = tf_email.getText();
        String f_name = tf_father_name.getText();
        String address = tf_address.getText();
        String desgination = tf_desgination.getText();
        String contact = tf_contact.getText();
        String salary = tf_salary.getText();
        String state = tf_state.getText();
        String highest_qualification = tf_education.getText();
        
        try {
            Conn conn = new Conn();
            // Create a SQL query to insert the employee details into the database
String query = "UPDATE employee SET FName ='" + f_name + "', Email ='" + email + "', Salary ='" + salary + "', Address ='" + address + "', Contact ='" + contact + "', Education ='" + highest_qualification + "', Desgination ='" + desgination + "', State ='" + state + "' WHERE Emp_Id ='" + Emp_Id + "'";
             conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee details updated successfully.");
            setVisible(false);
            new Home();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }else {
        setVisible(false);
        new Home();
    }
    }
    
public static void main(String []args){
      new UpdateEmployee("");
  }  
}     