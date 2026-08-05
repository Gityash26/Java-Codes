/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------- Multiple Catch Block ------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
for example:
                 try{

                 }
                 catch(Exception e)
                 {

                 }

-> In this approach we mention one try block and one catch block with argument of Exception class.
-> And this is a single alternative solution for every exception occured in the try block.
-> We can also provide multiple solution by creating multiple catch blocks and instead of providing 
   Exception class object now we use to write specific Exception that may occurs.

   for example:
   
        ========================== Multiple Catch ======================= 
        try{
            // code 
        }
        catch (ArithmeticException e)
        {
            // solution
        }
        catch (FileNotFoundException e)
        {
            // solution 
        }

   
        ======================== Nested try Catch ========================= 
        try{
            // code 
        }
        catch (Exception e)
        {
            try
            {

            }
            catch{

            }
        }
        
        
        ========================== try Catch in finally ===================== 
        try{
            // code 
        }
        catch (Exception e)
        {
            
        }
        finally{
            try{

            }
            catch(Exception e)
            {

            }
        }
                 
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class p4_MultipleCatch {
    int[] marks = new int[10];

    p4_MultipleCatch() {
        marks[0] = 40;
        marks[1] = 70;
        marks[2] = 84;
    }

    public void display() {
        System.out.println("\nArray Values are : ");
        for (int i = 0; i < marks.length; i++)
            System.out.printf("\nmarks[%d] : %d", i, marks[i]);
    }

    public void insertion() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("\n\nEnter Index number : ");
            int id = sc.nextInt();

            System.out.print("\nEnter Value to Insert : ");
            int value = sc.nextInt();

            marks[id] = value;
            System.out.println("Value Inserted...");

            display();
        } 
        catch (ArithmeticException e) {
            System.out.println("\n-> Arithmetic Exception Occured !");
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n-> Array Index Out of Bound Exception Occured !");
        } 
        catch (InputMismatchException e) {
            System.out.println("\n-> Input value is mismatch !");
        } 
        catch (Exception e) {
            System.out.println("\n-> Some Other Exception Occured" + e);
        }
        
        sc.close();

    }

    public static void main(String[] args) 
    {
        p4_MultipleCatch obj = new p4_MultipleCatch();
        obj.display();
        obj.insertion();
    }
}
