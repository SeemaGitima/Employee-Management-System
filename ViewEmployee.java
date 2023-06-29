package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice cemployeeId;
    JButton search, print,update, back;

    ViewEmployee(){
        JLabel searchLb1 = new JLabel("Search by EmpId");
        searchLb1.setBounds(10, 20, 100, 20);
        add(searchLb1);

        cemployeeId = new Choice();
        cemployeeId.setBounds(150,20, 150,20);
        add(cemployeeId);


        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                cemployeeId.add(rs.getString("Emp_Id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        table = new JTable();

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
      
search = new JButton("Search");
search.setBounds(60, 60, 100, 30);
search.addActionListener(this);
add(search);

print = new JButton("Print");
print.setBounds(230, 60, 100, 30);
print.addActionListener(this);
add(print);

back = new JButton("Back");
back.setBounds(560, 60, 100, 30);
back.addActionListener(this);
add(back);

update = new JButton("Update");
update.setBounds(400, 60, 100, 30);
update.addActionListener(this);
add(update);

        JScrollPane jsp = new JScrollPane(table);
        add(jsp);
        jsp.setBounds(0, 100, 1200, 600);

        // Set background color
        getContentPane().setBackground(new Color(0, 184, 184));
        setLayout(null);
        setTitle("View_Employee");
        setSize(1200, 550);
        setVisible(true);
        setLocation(100, 100);
    }
public void actionPerformed (ActionEvent ae){
    if(ae.getSource() == search){
     String query = "select * from employee where Emp_Id = '"+cemployeeId.getSelectedItem()+"'" ;
     try{
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery(query);
         table.setModel(DbUtils.resultSetToTableModel(rs));
     }catch(Exception e){
         e.printStackTrace();
     }
    }
    else if(ae.getSource() == print){
        try{
            table.print();
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if(ae.getSource() == update){
        setVisible(false);
        new UpdateEmployee(cemployeeId.getSelectedItem());
    }else{
        setVisible(false);
        new Home();
    }
}
    public static void main(String []args){
        new ViewEmployee();
    }
}
