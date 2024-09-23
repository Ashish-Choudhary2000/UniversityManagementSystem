
package universitymanagementsystem;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.net.URL;

public class Project extends JFrame implements ActionListener{
    Project(){
        setSize(1540,850);
       try {
    // Corrected: Use getResource() to get a single URL instead of getSystemResources()
    URL imageUrl = ClassLoader.getSystemResource("icons/third.jpg");
    
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

        JMenuBar mb = new JMenuBar();

        JMenu newInformation  = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setForeground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setForeground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        JMenu details  = new JMenu("View Details");
        details.setForeground(Color.BLUE);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setForeground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setForeground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);
        
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setForeground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);
        
        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setForeground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        
        JMenu leaveDetails  = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        mb.add(leaveDetails);

        JMenuItem facultyleaveDetails = new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setForeground(Color.WHITE);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);

        JMenuItem studentleaveDetails = new JMenuItem("Student Leave Details");
        studentleaveDetails.setForeground(Color.WHITE);
        studentleaveDetails.addActionListener(this);
        leaveDetails.add(studentleaveDetails);
        
        JMenu exam  = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem examinationDetails = new JMenuItem(" Examination Results");
        examinationDetails.setForeground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setForeground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);
        
        JMenu updateInfo  = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLUE);
        mb.add(updateInfo);

        JMenuItem updateFacultyInfo = new JMenuItem(" Update Faculty Details");
        updateFacultyInfo.setForeground(Color.WHITE);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setForeground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);
        
        JMenu fee  = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem(" Fee Structure");
        feeStructure.setForeground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setForeground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);
        
        JMenu utility  = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem(" Notepad");
        notepad.setForeground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setForeground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);
        
        JMenu about  = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setForeground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
        JMenu exit  = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setForeground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
         String msg = ae.getActionCommand();
         if(msg.equals("Exit")){
         setVisible(false);
         }else if(msg.equals("Calculator")){
         try{
            Runtime.getRuntime().exec("calc.exe");
          }catch(Exception e){
          }
        
         }
         else if(msg.equals("Notepad")){
         try{
            Runtime.getRuntime().exec("notepad.exe");
          }catch(Exception e){
          }
        
         }else if(msg.equals("New Faculty Information")){
                new addTeacher();
         }
         else if(msg.equals("New Student Information")){
                new addStudent();
         }else if(msg.equals("View Faculty Details")){
                new teacherDetails();
         }else if(msg.equals("View Student Details")){
                 new StudentDetails();
         }else if(msg.equals("Faculty Leave")){
                new teacherLeave();
         }else if(msg.equals("Student Leave")){
                new studentLeave();
         }else if(msg.equals("Faculty Leave Details")){
                new teacherLeaveDetails();
         }else if(msg.equals("Student Leave Details")){
             new studentLeaveDetails();
         }else if(msg.equals("Update Faculty Details")){
                new updateTeacher();
         }else if(msg.equals("Update Student Details")){
                new updateStudent();
         }else if(msg.equals("Enter Marks")){
                new enterMarks();
         }else if(msg.equals("Examination Results")){
                new examinationDetails();
         }else if(msg.equals("Fee Structure")){
                new feeStructure();
         }else if(msg.equals("About")){
                new about();
         }else if(msg.equals("Student Fee Form")){
                new studentFeesForm();
         }
         
         
    }
       

    public static void  main(String[] args){
        new Project();
    }

}
