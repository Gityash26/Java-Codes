/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------------------- Loops In Java -------------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Loops are used to automate the repeated task in programming so that if their is any task to perform
   a similar code of statement multiple times then we can use loops.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- Types of Loops -------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) for loop
(2) while loop
(3) do while loop
*/

public class p1_Loops 
{
    public static void main(String[] args) 
    {

        // for loop
        System.out.println("\nImplementation of for loop : ");

        for (int i = 0; i < 10; i++) 
        {
            System.out.println("Iteration: " + i);
        }

        // while loop
        System.out.println("\nImplementation of while loop : ");

        int j = 0;
        while (j < 5) {
            System.out.println("Iteration: " + j);
            j++;
        }

        // do while loop
        System.out.println("\nImplementation of do while loop : ");

        int k = 0;
        do {
            System.out.println("Iteration: " + k);
            k++;
        } while (k < 3);
    }
}
