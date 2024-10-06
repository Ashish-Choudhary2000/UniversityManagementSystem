package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash() {
        try {
    // Corrected: Use getResource() to get a single URL instead of getSystemResources()
    URL imageUrl = ClassLoader.getSystemResource("icons/first.jpg");
    
    // Ensure the resource is found
    if (imageUrl != null) {
        ImageIcon i1 = new ImageIcon(imageUrl);  // Load the image from the URL
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);  // Scale the image
        ImageIcon i3 = new ImageIcon(i2);  // Create an ImageIcon from the scaled image
        JLabel image = new JLabel(i3);  // Add the ImageIcon to a JLabel
        add(image);  // Add the JLabel to your container
    } else {
        System.out.println("Image resource not found.");
    }
} catch (Exception e) {
    e.printStackTrace();
}

        // Start the thread
        t = new Thread(this);
        t.start();  

        setVisible(true);
    }

    public void run() {
        try {
            int x = 1;
            for (int i = 2; i <= 600; i += 4, x += 1) {
                setLocation(600 - ((i + x) / 2), 350 - (i / 2));
                setSize(i + 3 * x, i + x / 2);
                Thread.sleep(10); // Smooth animation with sleep
            }
            Thread.sleep(7000); // Display splash for 7 seconds
            setVisible(false);
            
            //next Frame
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash(); 
    }
}
