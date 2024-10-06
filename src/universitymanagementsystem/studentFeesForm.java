
package universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.net.URL;

public class studentFeesForm extends JFrame implements ActionListener{
    
    Choice crollno;
    JComboBox cbcourse,cbbranch,cbsemester;
    JLabel labeltotal;
    JButton update,payfee,back;
    
    studentFeesForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        try {
    URL imageUrl = getClass().getResource("/icons/fee.jpg");  
    if (imageUrl != null) {
        ImageIcon i1 = new ImageIcon(imageUrl);  
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);  
        ImageIcon i3 = new ImageIcon(i2);  
        JLabel image = new JLabel(i3);  
        image.setBounds(400, 50, 500, 300);  
        add(image);  
    } else {
        System.out.println("Image resource not found.");
    }
} catch (Exception e) {
    e.printStackTrace();
}

      
       
       JLabel lblrollnumber = new JLabel("Select Roll No");
        lblrollnumber.setBounds(40,60,150,20);
        lblrollnumber.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(lblrollnumber);
        
        crollno  = new Choice();
        crollno.setBounds(200,60,150,20);
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
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("TAHOMA",Font.BOLD,16));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        lblname.setFont(new Font("TAHOMA",Font.BOLD,16));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40,140,150,20);
        lblfname.setFont(new Font(" TAHOMA",Font.BOLD,16));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        lblfname.setFont(new Font("TAHOMA",Font.BOLD,16));
        add(labelfname);
        
        try{
            Conn c =new Conn();
            String query = "Select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
            Conn c =new Conn();
            String query = "Select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
}
    });
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40,180,150,20);
        lblcourse.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(lblcourse);
        
        String course[] = {"None","B.Tech","BBA","BCA","BSc","MSc","MBA","MCA","MCom","MA","BA"};
        
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40,220,150,20);
        lblbranch.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(lblbranch);
        
        String branch[] = {"None","Computer Science","Electronic","Mechnical","Civil","IT"};
        
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        add(cbbranch);
        
        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(lblsemester);
        
        String semester[] = {"Semester1", "Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 260, 150, 20);
        cbsemester.setBackground(Color.WHITE);
         add(cbsemester);
         
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labeltotal);
        
        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        payfee = new JButton("Pay Fee");
        payfee.setBounds(150,380,100,25);
        payfee.setBackground(Color.BLACK);
        payfee.setForeground(Color.WHITE);
        payfee.addActionListener(this);
        add(payfee);
        
        back = new JButton("Back");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String course  = (String)cbcourse.getSelectedItem();
            String semester = (String)cbsemester.getSelectedItem();
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from fee where course = '"+course+"'");
                while(rs.next()){
                    labeltotal.setText(rs.getString(semester));
                }
            }catch(Exception e){
                e.printStackTrace();
                
            }
            
            
        }else if(ae.getSource() == payfee){
            String rollno = crollno.getSelectedItem();
            String course  = (String)cbcourse.getSelectedItem();
            String semester = (String)cbsemester.getSelectedItem();
            String branch  = (String)cbbranch.getSelectedItem();
            String total = labeltotal.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "College Fee Submited");
                setVisible(false);
                }catch(Exception e){
                e.printStackTrace();
           
                
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new studentFeesForm();
    }
}
