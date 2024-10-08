
package universitymanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class teacherLeaveDetails extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JTable table;
    JButton search,print,cancel;
    
    teacherLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search By Employee Id");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        cEmpId  = new Choice();
        cEmpId.setBounds(180,20,150,20);
        add(cEmpId);
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select *from teacherleave");
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("Select *from teacher");
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
         
        search  = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print  = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        cancel  = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
            String query = "select * from teacherleave where empId = '"+cEmpId.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace(); 
            }
            
        }   else{
            setVisible(false);
        }
        
    }
    
    public static void main (String[] args){
        new teacherLeaveDetails();
    }
    
}
