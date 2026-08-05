/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 Final Method
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Cannot be override by a subclass

*/

class Calc 
{

    public final void display_Developer() 
    {
        System.out.println("\n-> This is a Simple Calculator");
    }

    public void add(int a, int b) 
    {
        System.out.println("\nThe Sum is : " + (a + b));
    }
}

class Adv_Calc extends Calc 
{
    /*-----> (final method) */
    // public void display_Developer()     
    // {
    //     System.out.println("\n-> This is a Advance Calculator");
    // }

    public void Average(int... arr) 
    {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        System.out.println("The Average is : " + (sum / arr.length));
    }
}

public class p2_final_Method {
    public static void main(String[] args) {
        Adv_Calc ac = new Adv_Calc();

        ac.display_Developer();
        ac.add(45, 67);
        ac.Average(10, 60, 30, 88);
    }
}
