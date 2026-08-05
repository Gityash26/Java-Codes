/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------------------- Try Catch Exception Handling  -----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

try
{
    // critical section
}
catch(Exception obj)
{
    // user defined alternative solution
}
finally
{
    // Important code
}

(1) Try Block:
    The try block is used to enclose the code that might thrown an exception.
    And if any exception occured then the try block throws the Exception.

(2) Catch Block:
    When an Exception occured in the try block then catch block is used to caught that exception.
    The catch block contains the block of code that is used to handle that exception and provide an alternative way.

(3) Finally block:
    The finally block is used to contain the code that is always execute and no matter Exception occured or not in the try block.
    Generally finally block is used to contains the statement for releasing the resources, such as closing file or database connectivity.



*/

import java.util.Scanner;

public class p3_TryCatch 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;
        
        
        try
        {
            System.out.print("\nEnter first number : ");
            a = sc.nextInt();
            
            System.out.print("\nEnter Second number : ");
            b = sc.nextInt();

            System.out.println("\n Division of a and b : " + a / b);
        }

        catch (Exception e) 
        {
            System.out.println("\n!! Exception Occured !! =>  " + e);
        }
        
        finally
        {
            sc.close();
            System.out.println("\nFinally Block Executed...\n");
        }
        
        System.out.println("Statement after finally ");
    }
}
