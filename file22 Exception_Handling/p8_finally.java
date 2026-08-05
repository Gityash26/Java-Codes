/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== finally block ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> finally block in java contains the code that is always executed no matter exception occured or not.
-> Remember either we break, return or done anything in the try or catch that terminate the program or method 
   then also finally never left to execute.
*/

public class p8_finally 
{
    public static void Greet() 
    {
        int a = 10, b = 0;
        try 
        {
            System.out.println("\nDivision : " + (a / b));
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            return;
        } 
        finally 
        {
            System.out.println("\n~~~~~~~~~~~~~ Finally Executed ~~~~~~~~~~~~~~~\n");
        }
    }

    public static void main(String[] args) 
    {
        Greet();
    }
}
