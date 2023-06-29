package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Splash extends JFrame implements ActionListener {
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JLabel calendarIconLabel;
    private JLabel clockIconLabel;
  

    Splash() {
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        
        // Image layout...
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 100, 1100, 450);
        add(image);
        
        // Calendar icon label
        calendarIconLabel = new JLabel();
        ImageIcon calendarIcon = new ImageIcon(ClassLoader.getSystemResource("icons/calendar.png"));
        Image calendarImage = calendarIcon.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
        calendarIconLabel.setIcon(new ImageIcon(calendarImage));
        calendarIconLabel.setBounds(20, 580, 30, 30);
        add(calendarIconLabel);
        
        // Date label
        dateLabel = new JLabel();
        dateLabel.setBounds(60, 580, 100, 30);
        dateLabel.setForeground(Color.WHITE);
        add(dateLabel);
        
        // Clock icon label
        clockIconLabel = new JLabel();
        ImageIcon clockIcon = new ImageIcon(ClassLoader.getSystemResource("icons/clock.png"));
        Image clockImage = clockIcon.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
        clockIconLabel.setIcon(new ImageIcon(clockImage));
        clockIconLabel.setBounds(160, 580, 30, 30);
        add(clockIconLabel);
        
        // Time label
        timeLabel = new JLabel();
        timeLabel.setBounds(200, 580, 400, 30);
        timeLabel.setForeground(Color.WHITE);
        add(timeLabel);
        
             
        // Button layout
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(150, 400, 200, 40);
        clickhere.setBackground(Color.LIGHT_GRAY);
        clickhere.setForeground(Color.BLACK);
        clickhere.addActionListener(this);
        image.add(clickhere);

        setSize(1100, 650);
        setLocation(100, 40);
        setVisible(true);
        
        // Update date and time
        updateDateTime();

        // Update date and time every second
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDateTime();
            }
        });
        timer.start();
        
    }

    private void updateDateTime() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);
        String formattedTime = timeFormat.format(currentDate);
        dateLabel.setText(formattedDate);
        timeLabel.setText(formattedTime);
    }
    
    public void actionPerformed(ActionEvent ae) {
        new Login();
        setVisible(false);
    }

    public static void main(String[] args) {
        new Splash();
    }
}
