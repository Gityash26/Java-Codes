/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== History of GUI in JAVA ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> The first version of java (JDK 1.0) was launched on 23 Jan 1996 and that time 
   it only support 'character user interface' Application.

-> But in 1996 "Visual Basic" of Microsoft was preferred GUI (Graphical User Interface) programming.

-> So, the JAVA developers developed support for GUI and provide a small library AWT (Abstract window toolkit) 
   that contains classes to provide GUI components such as Buttons, menu, Textfields etc.

-> The JAVA programs that provide GUI components are called "Applets" and require a Browser to execute. 
   At that time only "Internet Explorer" was developed that is owned by microsoft.

-> But the microsoft beleives in monopoly. So, the "sun microsystem" (The company developed JAVA) contracted with other company 
   "Netscape" (which developed Javascript) and now known as "firefox" which is known for browser.

-> Now these two companies have developed "swing" framework and its componets developed by java itself.

-> Therefore "SWING" is a platform independent as well as some additional features added which were not in AWT technology.

-> So, we can say that SWING is more advance that AWT technology.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Types of JAVA Programs ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
               ____________________|_______________________________
              |                                                   |
        Application                                            Applets
        Programs                                               Programs 
       ______|______________                           __________|____________________
      |                    |                          |                              |
    Text based            GUI                       Local                         Remote
    Application           Application               Applets                       Applets




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------- Application Programs ------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> The programs that are execute on a computer and used to provide solution for given problem. 
   These programs are store, compile and run on a same computer and use their resources.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------- Applets Programs ------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> The Applets are small JAVA programs that writtten in java programming language. They are execute 
   on the internet and require a java compatible browser at client side of the computer.
   
-> Applets programs does not require any main function as it does not execute like a JAVA Application.





*/

/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Program: WAP to create a login page using swing package
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


       ___________________________________________________
      |                                                  |
      |         Welcome to Login Page                    |
      |                 ________________                 |
      |    Username    |_______________|                 |
      |                 ________________                 |
      |    Password    |_______________|                 |
      |                                                  |
      |               ____________                       |
      |              |__submit___|                       |
      |__________________________________________________|



*/

import javax.swing.*;
import java.awt.event.*; // action listenert

class LoginPage extends JFrame {
   JLabel l1, l2, l3, l4;
   JTextField t1;
   JPasswordField t2;
   JButton b1, b2, b3;

   LoginPage() 
   {
   }

   LoginPage(String s) {
      super();
   }

   void setComponents() {
      // Creating window frame visible
      setVisible(true);
      setSize(700, 700);


      // Labels
      l1 = new JLabel("Welcome to Login page");
      l2 = new JLabel("Username");
      l3 = new JLabel("Password");
      l4 = new JLabel();

      // Textfields
      t1 = new JTextField();
      t2 = new JPasswordField();

      // Buttons
      b1 = new JButton("Login");
      b2 = new JButton("Clear");
      b3 = new JButton("Add");

      // Make default Layout null
      setLayout(null);

      // Add components on screen
      add(l1);
      add(l2);
      add(l3);
      add(l4);

      add(t1);
      add(t2);

      add(b1);
      add(b2);
      add(b3);

      // Set Boundaries of componets
      l1.setBounds(200, 50, 300, 30); // welcome heading label
      l2.setBounds(100, 200, 100, 30); // username label
      l3.setBounds(100, 300, 100, 30); // password label
      l4.setBounds(100, 550, 600, 30); // Output label

      t1.setBounds(300, 200, 200, 30); // username textfield
      t2.setBounds(300, 300, 200, 30); // password textfield

      b1.setBounds(200, 450, 100, 30);
      b2.setBounds(400, 450, 100, 30);
      b3.setBounds(300, 450, 100, 30);

      // Action Listener
      b1.addActionListener(new Login());
      b2.addActionListener(new ClearField());
      b3.addActionListener(new AddClass());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   class Login implements ActionListener {
      // Code execute after button clicked
      public void actionPerformed(ActionEvent e) {
         String s1 = t1.getText();
         String s2 = t2.getText();

         if (s1.equals("yash6673") && s2.equals("Yash12345")) {
            l4.setText("Login successful");
         } else {
            l4.setText("Login denied !");
         }
      }
   }

   class ClearField implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         t1.setText("");
         t2.setText("");
         l4.setText("");
      }
   }

   class AddClass implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         try
         {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            int c = a+b;
            l4.setText("Addition is : " + c);
         }
         catch(Exception exp)
         {

         }

      }
   }

}

public class IntroToGUI 
{
   public static void main(String[] args) {
      LoginPage obj = new LoginPage("Login page");
      obj.setComponents();
   }
}