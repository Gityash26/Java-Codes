/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Command line Argument =================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In the command line user input method we require to pass all the required arguments at 
   the time of 'run command' (when program start interpreting).

-> This methods uses the "String args[]" array in the main method that store all the arguments 
   we pass in indexed order with String Datatype.

-> Example: 
   It is similar like we carry all our required details or documents and submit them at the cyber cafe to fillup and form.
   And then the owner or the operator start the procedure of filling details.
   So that, in our absense the operator can easily processed the processing.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================ Syntax ==========================================================b
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Step1: Write a java program that uses the args[] array

Step2: Compile your code at command prompt using 
        -> compilation command :
           (javac <fileName>.java)

Step3: Run the program using run command and pass you arguments
        -> Run command : 
            (java <fileName> arg1 arg2 arg3 _ _ _ etc)


-> Now those arguments assign into "String args[]" array and can be accessed using index value 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============ Disadvantage ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> It support directly input all the arguments at the run time at once.
-> We can not input value frequently or in the middle of the processing

*/

public class p1_Type1 
{
    public static void main(String[] args) 
    {
        if (args.length >= 2) 
        {
            int firstValue = Integer.parseInt(args[0]);
            int secondValue = Integer.parseInt(args[1]);
            System.out.println(" Sum : " + (firstValue + secondValue));
        } 
        else 
        {
            System.out.println("No command line arguments to display");
        }
    }
}

