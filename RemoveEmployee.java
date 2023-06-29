package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    JLabel empId, name, phone, email, lblemail, lblname, lblphone;
    Choice cempId;
    JButton delete, back;
    RemoveEmployee(){
    getContentPane().setBackground(new Color(0, 184, 184));
        setLayout(null);
        
        empId = new JLabel("Empolyee Id") ;
        empId.setBounds(50, 50, 100, 30);
        add(empId);
        
        cempId = new Choice();
        cempId.setBounds(250, 50, 150, 30);
        add(cempId);
     
        try{
            Conn c = new Conn();
            String query ="select * from employee";
           ResultSet rs   = c.s.executeQuery(query);
           while(rs.next()){
               cempId.add(rs.getString("Emp_Id"));
           }
        }catch(Exception e){
      e.printStackTrace();
        }
        
                name = new JLabel("Name") ;
        name.setBounds(50, 100, 100, 30);
        add(name);
        
        lblname = new JLabel() ;
        lblname.setBounds(250, 100, 100, 30);
        add(lblname);
        
        phone = new JLabel("Phone") ;
        phone.setBounds(50, 150, 100, 30);
        add(phone);
        
        lblphone = new JLabel() ;
        lblphone.setBounds(250, 150, 100, 30);
        add(lblphone);
        
        email = new JLabel("Email") ;
        email.setBounds(50, 200, 100, 30);
        add(email);
        
        lblemail = new JLabel() ;
        lblemail.setBounds(250, 200, 100, 30);
        add(lblemail);
        
     try{
            Conn c = new Conn();
       String query ="select * from employee where Emp_Id = '"+cempId.getSelectedItem()+"'";
           ResultSet rs   = c.s.executeQuery(query);
           while(rs.next()){
               lblname.setText(rs.getString("Name"));
               lblphone.setText(rs.getString("Contact"));
               lblemail.setText(rs.getString("Email"));
           }
        }catch(Exception e){
      e.printStackTrace();
        }
     
     cempId.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
                 try{
            Conn c = new Conn();
       String query ="select * from employee where Emp_Id = '"+cempId.getSelectedItem()+"'";
           ResultSet rs   = c.s.executeQuery(query);
           while(rs.next()){
               lblname.setText(rs.getString("Name"));
               lblphone.setText(rs.getString("Contact"));
               lblemail.setText(rs.getString("Email"));
           }
        }catch(Exception e){
      e.printStackTrace();
        }
        }
    });
     
        delete = new JButton("Delete");
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.setBounds(100,300,150,30);
        delete.addActionListener(this);
        add(delete);
      
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(400,300,150,30);
        back.addActionListener(this);
        add(back);
        
setTitle("Remove_Employee");
setSize(700,400);
setLocation(300,150);
setVisible(true);
 
        
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == delete){
        try{
            Conn c = new Conn();
            String query = "delete from employee where Emp_Id = '"+cempId.getSelectedItem()+"'";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee details deleted successfully");
            setVisible(false);
        }catch(Exception e ){
            e.printStackTrace();
        }
    }else{
        setVisible(false);
        new Home();
    }
}

public static void main(String []args){
    new RemoveEmployee();
}    
}
