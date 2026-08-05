import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


class Calculator extends JFrame
{
    JLabel mainHead, l1, l2, optLabel;
    JTextField boxNum1, boxNum2;
    JButton addBtn, subBtn, divBtn, multiBtn, clrBtn;

    Calculator(String title)
    {
        super(title);
    }

    public void displayScreen()
    {
        // Main Screen 
        setVisible(true);
        setSize(500, 600);
        
        // Cursor change 
        Cursor c1 = new Cursor(Cursor.HAND_CURSOR);
        Cursor c2 = new Cursor(Cursor.TEXT_CURSOR);

        // Font change
        Font f1 = new Font("Times New Roman", Font.BOLD, 16);
        
        // Lable components
        mainHead = new JLabel("Welcome to Simple Calculator");
        mainHead.setFont(f1);
        mainHead.setForeground(Color.darkGray);

        l1 = new JLabel("Enter number 1");
        l1.setFont(f1);

        l2 = new JLabel("Enter number 2");
        l2.setFont(f1);

        optLabel = new JLabel("Output : ");
        optLabel.setFont(f1);

        // Textfield Components 
        boxNum1 = new JTextField();
        boxNum1.setCursor(c2);

        boxNum2 = new JTextField();
        boxNum2.setCursor(c2);

        // Buttons components
        addBtn = new JButton("+");
        addBtn.setFont(f1);
        addBtn.setCursor(c1);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        
        subBtn = new JButton("-");
        subBtn.setFont(f1);
        subBtn.setCursor(c1);
        subBtn.setBackground(Color.BLACK);
        subBtn.setForeground(Color.WHITE);

        divBtn = new JButton("/");
        divBtn.setFont(f1);
        divBtn.setCursor(c1);
        divBtn.setBackground(Color.BLACK);
        divBtn.setForeground(Color.WHITE);

        
        multiBtn = new JButton("*");
        multiBtn.setFont(f1);
        multiBtn.setCursor(c1);
        multiBtn.setBackground(Color.BLACK);
        multiBtn.setForeground(Color.WHITE);
    
        clrBtn = new JButton("clear");
        clrBtn.setFont(f1);
        clrBtn.setCursor(c1);
        clrBtn.setBackground(Color.BLACK);
        clrBtn.setForeground(Color.WHITE);
 
 
        // make layout null 
        setLayout(null);

        // Add components 
        add(mainHead);
        add(l1);
        add(l2);
        add(optLabel);

        add(boxNum1);
        add(boxNum2);
        
        add(addBtn);
        add(subBtn);
        add(divBtn);
        add(multiBtn);
        add(clrBtn);



        addBtn.addActionListener(new Add());
        subBtn.addActionListener(new Sub());
        multiBtn.addActionListener(new Multi());
        divBtn.addActionListener(new Div());
        clrBtn.addActionListener(new Clear());



        // set boundary of components 
        mainHead.setBounds(150, 10, 300, 100);
        l1.setBounds(100, 100, 140, 40);
        l2.setBounds(100, 150, 140, 40);
        optLabel.setBounds(150, 200,400, 40);

        boxNum1.setBounds(250, 100,150, 30);
        boxNum2.setBounds(250, 150,150, 30);

        addBtn.setBounds(100, 300, 70, 50);
        subBtn.setBounds(180, 300, 70, 50);
        divBtn.setBounds(260, 300, 70, 50);
        multiBtn.setBounds(340, 300, 70, 50);
        clrBtn.setBounds(200, 370, 100, 50);
        
        
        // Closing 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class Add implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                float a = Float.parseFloat(boxNum1.getText());
                float b = Float.parseFloat(boxNum2.getText());
                float res = a + b;
                optLabel.setText("Output :   " + a + " + " + b + " = " + res);
                optLabel.setForeground(Color.DARK_GRAY);
            }
            catch(Exception exp)
            {
                optLabel.setText("!! ERROR Invalid Input type...");
                optLabel.setForeground(Color.gray); // Set the text color to red
            }
        }
    }

    class Sub implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                float a = Float.parseFloat(boxNum1.getText());
                float b = Float.parseFloat(boxNum2.getText());
                float res = a - b;
                optLabel.setText("Output :   " + a + " - " + b + " = " + res);
                optLabel.setForeground(Color.DARK_GRAY);

            }
            catch(Exception exp)
            {
                optLabel.setText("!! ERROR Invalid Input type...");
                optLabel.setForeground(Color.gray); // Set the text color to red


            }
        }
    }    

    class Multi implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                int a = Integer.parseInt(boxNum1.getText());
                int b = Integer.parseInt(boxNum2.getText());
                int res = a * b;
                optLabel.setText("Output :   " + a + " * " + b + " = " + res);
                optLabel.setForeground(Color.DARK_GRAY);

            }
            catch(Exception exp)
            {
                optLabel.setText("!! ERROR Invalid Input type...");
                optLabel.setForeground(Color.gray); // Set the text color to red

            }
        }
    }

    class Div implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                int a = Integer.parseInt(boxNum1.getText());
                int b = Integer.parseInt(boxNum2.getText());
                float res = a / b;
                optLabel.setText("Output :   " + a + " / " + b + " = " + res);
                optLabel.setForeground(Color.DARK_GRAY);

            }
            catch(Exception exp)
            {
                optLabel.setText("!! ERROR Invalid Input type...");
                optLabel.setForeground(Color.gray); // Set the text color to red

            }
        }
    }
    class Clear implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boxNum1.setText("");
            boxNum2.setText("");
            optLabel.setText("");
        }
    }
}

public class p1_Calculator
{
    public static void main(String[] args) 
    {
        Calculator c = new Calculator("Simple Calculator");
        c.displayScreen();    
    }
}
