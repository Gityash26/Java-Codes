/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Checked Custom Exception ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> If we want to create a "Custom Exception Class" of Checked Exception then we require 
   to extend the 'Exception class'.

-> Checked exception Identified by the compiler at the time of compilation and we cannot compile 
   our program until we handle the check exception.

-> We can simple handle the Custom Checked Exception using the try-catch block or declare the method using throws keyword.
*/

import java.util.Scanner;

class UnderAgeException extends Exception 
{
    UnderAgeException(String msg)
    {
        super(msg);
    }
}

class Voter
{
    Scanner sc = new Scanner(System.in);
    String name;
    int age;

    Voter()
    {
        System.out.print("\nEnter voter name : ");
        name = sc.nextLine();
        System.out.print("\nEnter your age : ");
        age = sc.nextInt();
    }

    public void checkVoter()
    {
        if(age>=1 && age < 18)
        {
            try{
                throw new UnderAgeException("!! Sorry You are Under Age !!");
            }
            catch(UnderAgeException e)
            {
                System.out.println("\n~~~~~~~~~~~~~~~~ Custom Checked Exception Caught ~~~~~~~~~~~~~~~~~~~~");
                e.printStackTrace();
            }
        }
        else if(age>=18 && age<=110)
        {
            System.out.println("\nHello Voter " + name);
            System.out.println("Your are Eligible to vote...");
        }
        else
        {
            System.out.println("\n!! You Enterned an Invalid Age");
        }
    }
}
public class p11_CheckedCustom 
{
    public static void main(String[] args) {
        Voter v = new Voter();
        v.checkVoter();        
    }    
}
