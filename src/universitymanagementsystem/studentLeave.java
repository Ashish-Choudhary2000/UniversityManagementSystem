
package universitymanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.ResultSet;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;


public class studentLeave extends JFrame implements ActionListener{ 
Choice crollno,ctime;
JDateChooser dcdate;
JButton Submit,Cancel;
 
    studentLeave(){
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblrollno = new JLabel("Search By Roll No");
        lblrollno.setBounds(60,100,200,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblrollno);
        
        crollno  = new Choice();
        crollno.setBounds(60,130,200,20);
        add(crollno);
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select *from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbldate);
        
        dcdate  = new JDateChooser();
        dcdate.setBounds(60,210,200,20);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltime);
        
        ctime  = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half-Day");
        add(ctime);
        
        Submit = new JButton("Submit");
        Submit.setBounds(60, 350, 100,25);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        Submit.setFont(new Font("serif", Font.BOLD, 16));
        add(Submit);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(200, 350, 100,25);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(Cancel);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource()== Submit){
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into studentleave values('"+rollno+"','"+date+"','"+duration+"' )";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception e ){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
 public static void  main(String[] args ) {    
     new studentLeave();
    }
}