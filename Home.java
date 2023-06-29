package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton add, view, remove, update;

    Home() {
        setSize(800, 500);
        setLocation(300, 150);
        setVisible(true);
        getContentPane().setBackground(new Color(0, 184, 184));
        setLayout(null);

        
        add = new JButton("Add_Employee");
        add.setBounds(50, 20, 130, 30);
        add.addActionListener(this);
        add(add);

        view = new JButton("View_Employees");
        view.setBounds(200, 20, 150, 30);
        view.addActionListener(this);
        add(view);

        update = new JButton("Update_Employee");
        update.setBounds(380, 20, 150, 30);
        update.addActionListener(this);
        add(update);

        remove = new JButton("Remove_Employee");
        remove.setBounds(550, 20, 150, 30);
        remove.addActionListener(this);
        add(remove);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
              setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == remove) {
            setVisible(false);
            new RemoveEmployee();
        } else {
             setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
