package employee.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tf_name,tf_email,tf_address,tf_desgination,tf_father_name, tf_contact,tf_salary ,tf_aadhar;
    JDateChooser dc_dob;
    JComboBox cb_highest_qualification, cb_state;
    JLabel lb_empId;
    JButton add_details, back;
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    AddEmployee(){
        // Set background color
        getContentPane().setBackground(new Color(0, 184, 184));
        setLayout(null);
        
        JLabel l = new JLabel("Add Employee Details") ;
        l.setBounds(250, 10, 400,35);
        l.setFont(new Font("TimesnewRoman", Font.PLAIN,20));
        l.setBackground(Color.GRAY);
        add(l);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50,50,150,30);
        add(name);
        tf_name = new JTextField();
        tf_name.setBounds(150,50,150,30);
        add(tf_name);
        
        JLabel f_name = new JLabel("Father's Name");
        f_name.setBounds(350,50,150,30);
        add(f_name);
        tf_father_name = new JTextField();
        tf_father_name.setBounds(480,50,150,30);
        add(tf_father_name); 
       
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,100,150,30);
        add(dob);
        dc_dob = new JDateChooser();
        dc_dob.setBounds(150,100,150,30);
        add(dc_dob);
        
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
        String courses[] = {"Select","BSC","BCA","BTECH","BBA","B.COM", "MSC","MCA","MTECH","M.COM","MBA","Ph.d"};
        cb_highest_qualification= new JComboBox(courses);
        cb_highest_qualification.setBackground(Color.white);
        cb_highest_qualification.setBounds(480,200,150,30);
        add(cb_highest_qualification);
        
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
        lb_empId = new JLabel("" + number);
        lb_empId.setBounds(150,300,150,30);
        add(lb_empId); 
        
        JLabel state = new JLabel("State");
        state.setBounds(350,300,150,30);
        add(state);
        String states [] = {"Select","Assam","Arunachal Pradesh","Bihar","Chattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Meghalaya","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telegana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
        cb_state = new JComboBox(states);
        cb_state.setBackground(Color.white);
        cb_state.setBounds(480,300,150,30);
        add(cb_state);
        
        add_details = new JButton("Add Details");
        add_details.setBackground(Color.LIGHT_GRAY);
        add_details.setForeground(Color.black);
        add_details.setBounds(100,400,150,30);
        add_details.addActionListener(this);
        add(add_details);
      
        back = new JButton("Back");
        back.setBackground(Color.LIGHT_GRAY);
        back.setForeground(Color.black);
        back.setBounds(400,400,150,30);
        back.addActionListener(this);
        add(back);
//        create frame
         setTitle("Add_Employee");
        setSize(700,500);
        setVisible(true);
        setLocation(350,100); 
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add_details) {
            String name = tf_name.getText();
        String email = tf_email.getText();
        String f_name = tf_father_name.getText();
        String address = tf_address.getText();
        String desgination = tf_desgination.getText();
        String dob = ((JTextField) dc_dob.getDateEditor().getUiComponent()).getText();
        String contact = tf_contact.getText();
        String aadhar = tf_aadhar.getText();
        String salary = tf_salary.getText();
        String state = (String) cb_state.getSelectedItem();
        String highest_qualification = (String) cb_highest_qualification.getSelectedItem();
        String empId = lb_empId.getText();
        
        try {
            Conn conn = new Conn();
            // Create a SQL query to insert the employee details into the database
 String query = "INSERT INTO employee VALUES('"+name+"','" +f_name+ "', '" +dob+ "','"+email+"', '"+salary + "', '"+address + "', '" + contact + "', '"+ highest_qualification + "', '" + desgination + "', '" + aadhar + "', '"+empId+"','"+state+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee details added successfully.");
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
      new AddEmployee();
  }  
}