
package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class updateTeacher extends JFrame implements ActionListener{
    
    JTextField tfcourse,tfaddress,tfphone,tfemail,tfbranch;
    JLabel labelEmpId;   
    JButton Submit,Cancel;
    Choice cempId;
    
    updateTeacher(){
        setSize(900,650);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,20));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Employee Id");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollnumber);
        
        cempId  = new Choice();
        cempId.setBounds(250,100,200,20);
        add(cempId);
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select *from teacher");
            while(rs.next()){
                cempId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        lblname.setFont(new Font("THOMA",Font.PLAIN,18));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        add(labelfname);
        
        JLabel lblrollno = new JLabel("Employee Id");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        
        labelEmpId = new JLabel();
        labelEmpId.setBounds(200,200,150,30);
        add(labelEmpId);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        JLabel labeldob  = new JLabel();
        labeldob.setBounds(600,200,150,30);
        add(labeldob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        
        JLabel labelx = new JLabel();
        labelx.setBounds(600,300,150,30);
        add(labelx);
        
        JLabel lblxII = new JLabel("Class XII (%)");
        lblxII.setBounds(50,350,200,30);
        lblxII.setFont(new Font("serif",Font.BOLD,20));
        add(lblxII);
        
        JLabel labelxII = new JLabel();
        labelxII.setBounds(200,350,150,30);
        add(labelxII);
        
        JLabel lblaadharno = new JLabel("Aadhar Number");
        lblaadharno.setBounds(400,350,200,30);
        lblaadharno.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadharno);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        add(labelaadhar);
        
        JLabel lblcourse = new JLabel("Education");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        
        tfcourse = new JTextField();
        tfcourse.setBounds(200,400,150,30);
        add(tfcourse);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        
        tfbranch = new JTextField();
        tfbranch.setBounds(600,400,150,30);
        add(tfbranch);
        
        try{
            Conn c =new Conn();
            String query = "Select * from teacher where empId = '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("x"));
                labelxII.setText(rs.getString("xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelEmpId.setText(rs.getString("empId"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        cempId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
            Conn c =new Conn();
            String query = "Select * from teacher where empId = '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("x"));
                labelxII.setText(rs.getString("xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelEmpId.setText(rs.getString("empId"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
}
    });
        
        Submit = new JButton("Update");
        Submit.setBounds(250,500,120,30);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        Submit.setFont(new Font("serif",Font.BOLD,16));
        add(Submit);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(450,500,120,30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("serif",Font.BOLD,16));
        add(Cancel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Submit){
            
            String empId = labelEmpId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String Course = tfcourse.getText();
            String branch = tfbranch.getText();
            
            try{
                String query = "update teacher set address ='"+address+"',phone ='"+phone+"',email = '"+email+"',course='"+Course+"',branch='"+branch+"' where empId = '"+empId+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully");
                setVisible(false);
            }catch(Exception e ){
                e.printStackTrace();
            }
            
            
        } else{
            setVisible(false); 
        }
            
    }
    
    public static void main(String[] args){
        new updateTeacher();
    }
}
