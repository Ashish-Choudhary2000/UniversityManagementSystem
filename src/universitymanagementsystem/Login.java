
package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,cancel;
    JTextField tfusername;
    JPasswordField tfPassword;
    JLabel forgetPassword;
    
    Login(){
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        JLabel labelUserName =  new JLabel("UserName");
        labelUserName.setBounds(40,20,100,20);
        add(labelUserName);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        JLabel labelPassword =  new JLabel("Password"); 
        labelPassword.setBounds(40,70,100,20);
        add(labelPassword);
        
        tfPassword = new JPasswordField();
        tfPassword.setBounds(150, 70, 150, 20);
        add(tfPassword);
        
        login = new JButton("Login");
        login.setBounds(60,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.BOLD,16));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,16));
        
        add(cancel);
        
        forgetPassword = new JLabel("Forgot Password?");
        forgetPassword.setBounds(150, 180, 150, 20);
        forgetPassword.setForeground(Color.BLUE);
        forgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        forgetPassword.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Makes it look clickable
        add(forgetPassword);

        forgetPassword.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Password recovery feature coming soon!");
            }
        });
        
    try {
    // Load the image from the classpath
    URL imageUrl = getClass().getResource("/icons/second.jpg");  
    if (imageUrl != null) {
        ImageIcon i1 = new ImageIcon(imageUrl);  // Load the image
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);  // Scale the image
        ImageIcon i3 = new ImageIcon(i2);  // Create an ImageIcon from the scaled image
        JLabel image = new JLabel(i3);  // Add the ImageIcon to a JLabel
        image.setBounds(350, 20, 200, 200);  // Set position and size
        add(image);  // Add JLabel to JFrame
    } else {
        System.out.println("Image not found.");
    }
} catch (Exception e) {
    e.printStackTrace();
}

        
       /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResources("/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);*/
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == login  ){
         String username = tfusername.getText();
         String password = new String(tfPassword.getPassword());
         String query = "SELECT * FROM login WHERE username='" + username + "' AND password='" + password + "'";
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery(query);
             if(rs.next()){
                 setVisible(false);
                 new Project();
             } else{
                 JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                 setVisible(false);
             }
             
             
             
         }catch(Exception e){
          e.printStackTrace();
         }
     }else if(ae.getSource() == cancel){
         setVisible(false);
     }
    }
    
    public static void main(String[] args){
        new Login();
    }
            
    
    
}
