package universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class addTeacher extends JFrame implements ActionListener {
    
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxII, tfaadhar;
    JLabel labelempId;  // Class-level variable for Employee ID
    
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton Submit, Cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    addTeacher() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 200, 200, 30);
        labelempId.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempId);
        
        // Set Employee ID
        labelempId = new JLabel("2024" + first4);
        labelempId.setBounds(200, 200, 150, 30);
        add(labelempId);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);
        
        JLabel lblxII = new JLabel("Class XII (%)");
        lblxII.setBounds(50, 350, 200, 30);
        lblxII.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxII);
        
        tfxII = new JTextField();
        tfxII.setBounds(200, 350, 150, 30);
        add(tfxII);
        
        JLabel lblaadharno = new JLabel("Aadhar Number");
        lblaadharno.setBounds(400, 350, 200, 30);
        lblaadharno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadharno);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String course[] = {"None", "B.Tech", "BBA", "BCA", "BSc", "MSc", "MBA", "MCA", "MCom", "MA", "BA"};
        
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(200, 400, 150, 30);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String branch[] = {"None", "Computer Science", "Electronic", "Mechanical", "Civil", "IT"};
        
        cbbranch = new JComboBox<>(branch);
        cbbranch.setBounds(600, 400, 150, 30);
        add(cbbranch);
        
        Submit = new JButton("Submit");
        Submit.setBounds(250, 550, 120, 30);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        Submit.setFont(new Font("serif", Font.BOLD, 16));
        add(Submit);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(450, 550, 120, 30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(Cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String empId = labelempId.getText();  // Use class-level variable
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxII.getText();
            String aadhar = tfaadhar.getText();
            String Course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            
            try {
                String query = "INSERT INTO teacher VALUES('" + name + "','" + fname + "','" + empId + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + x + "','" + xii + "','" + aadhar + "','" + Course + "','" + branch + "')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new addTeacher();
    }
}
