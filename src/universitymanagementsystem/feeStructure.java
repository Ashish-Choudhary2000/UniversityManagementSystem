package universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.net.URL;

public class feeStructure extends JFrame {

    feeStructure() {
        setSize(1000, 700);
        setLocation(250, 50);
        
        
        JPanel panel = new JPanel() {
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                try {
                    URL imageUrl = getClass().getResource("/icons/icon7.png");  
                    if (imageUrl != null) {
                        ImageIcon backgroundIcon = new ImageIcon(imageUrl);
                        Image backgroundImage = backgroundIcon.getImage();
                        
                        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    } else {
                        System.out.println("Background image not found.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        
        panel.setLayout(null);  
        getContentPane().add(panel);  

        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);  
        panel.add(heading);

        
        JTable table = new JTable() {
            @Override
            public boolean isOpaque() {
                return false;  
            }
        };
        table.setBackground(new Color(255, 255, 255, 100));  
        table.setForeground(Color.BLACK);  
        table.setGridColor(new Color(0, 0, 0, 50)); 

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setOpaque(false);  
        jsp.getViewport().setOpaque(false);  
        jsp.setBounds(50, 60, 900, 600);  
        panel.add(jsp);

        setVisible(true);
    }

    public static void main(String[] args) {
        new feeStructure();
    }
}
