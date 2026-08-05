/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
---------------------------- Variable Arguments --------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Suppose we wants to add integers with the help of functions in Java.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------ Method Overriding Approach ---------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Addition of two variable we create a method          ->  sum(int a, int b).
-> Addition of three variable we create a second method ->  sum(int a, int b, int c).
-> Addition of four variable we create a third method   ->  sum(int a, int b, int c, int d).


But if we don't know the exact no. of arguments we wants to add then instead of creating multiple fnction
we can use variable arguments approah.
*/

public class p3_varArgument 
{
    static int sum(int ...arr) 
    {
        int sum = 0;
        for (int val : arr) 
        {
            sum += val;
        }
        return sum;
    }

    public static void main(String[] args) 
    {
        System.out.println("The Sum of 11 + 22 = " + sum(11, 22));
        System.out.println("The Sum of 11 + 22 + 33 = " + sum(11, 22, 33));
        System.out.println("The Sum of 11 + 22 + 33 + 44 = " + sum(11, 22, 33, 44));
        System.out.println("The Sum of 11 + 22 + 33 + 44 + 55 = " + sum(11, 22, 33, 44, 55));
    }
}
