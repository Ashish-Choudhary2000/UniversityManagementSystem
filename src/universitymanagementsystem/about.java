
package universitymanagementsystem;

import java.awt.*;
import javax.swing.*;

public class about extends JFrame{
    about(){
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);
        
       /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResources("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);  */
        
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel name = new JLabel("Developed By: Code for College Project");
        name.setBounds(70,220,550,40);
        name.setFont(new Font("serif",Font.BOLD,30));
        add(name);
        
        JLabel rollno = new JLabel("Roll Number:22CSFMC604");
        rollno.setBounds(70,280,550,40);
        rollno.setFont(new Font("serif",Font.PLAIN,30));
        add(rollno);
        
        setLayout(null);
        
        setVisible(true);
        
        
        
        JTable table = new JTable();
        
    }
    public static void main(String[] args){
        new about();
    }
}
