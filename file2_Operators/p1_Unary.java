/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------- Unary Operator -------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Unary Operators are operates on a single variable.

ex: Increment Operator (++)
    Decrement Operator (--)

*/

class Operator 
{
    void display(int a, int b) 
    {
        System.out.println("\nImplementation of Unary Opertors : (++ , --)");

        System.out.println("Increment operator: " + a++);
        System.out.println("Decrement operator: " + a--);
    }
}

public class p1_Unary 
{
    public static void main(String[] args) 
    {
        // Declaring two variables 
        int a = 10, b = 20;

        // creating object of the operator class 
        Operator obj = new Operator();

        // calling method
        obj.display(a, b);
    }
}
