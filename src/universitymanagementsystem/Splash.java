package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResources("/icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

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
