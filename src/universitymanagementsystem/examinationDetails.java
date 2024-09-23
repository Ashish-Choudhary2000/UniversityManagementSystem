
package universitymanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class examinationDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton Submit,Cancel;
    JTable table;
    
    examinationDetails(){
        setSize(1000,475);
        setLocation(300,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
       
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80,15,400,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        search = new JTextField();
        search.setBounds(80,90,200,30);
        
        Submit = new JButton("Result");
        Submit.setBounds(300,90,120,30);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.addActionListener(this);
        Submit.setFont(new Font("serif",Font.BOLD,16));
        add(Submit);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(440,90,120,30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("serif",Font.BOLD,16));
        add(Cancel);
        
        
        table = new JTable();
        table.setFont(new Font("Thoma",Font.PLAIN,16));
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
          
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
     setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Submit){
            setVisible(false);
            new Marks(search.getText());
        }else {
            setVisible(false);  
        }
    }
    
    public static void main(String[] args){
        new examinationDetails();
    }
}
