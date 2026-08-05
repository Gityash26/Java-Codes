/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Unchecked Custom Exception ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> If we want to create a "Custom Exception Class" of Unchecked Exception then we require 
   to extend the 'RuntimeException class'.

-> Unchecked exception does not Identified by the compiler at the time of compilation and we can easily compile our code
   but unchecked (Run Time) exception occured at Run Time.

-> We can simple handle the Custom Unchecked Exception using the try-catch block or declare the method using throws keyword.
*/

import java.util.Scanner;

class UnderAgeException extends RuntimeException 
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
            throw new UnderAgeException("!! Sorry You are Under Age !!");
        }
        else
        {
            System.out.println("\nHello Voter " + name);
            System.out.println("Your are Eligible to vote...");
        }
    }
}

public class p12_UncheckedCustom 
{
    public static void main(String[] args) {
        Voter v = new Voter();

        try{
            v.checkVoter();        
        }
        catch(UnderAgeException e)
        {
            System.out.println("\n~~~~~~~~~~~~~~ Unchecked Custom Exception Caught ~~~~~~~~~~~~~~");
            e.printStackTrace();
        }
    }    
}

    

