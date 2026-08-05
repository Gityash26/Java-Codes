
/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Input using Scanner class ============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Scanner class supports various methods that are used to take input from the user at the run time.
-> We can get specific type of value using Scanner class such as int, float, Boolean, String 

-> In this method we can ask for user to input value at any moment during processing.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================ Scanner class Method =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> sc.next()                 // Reads the input unil space encounterd
-> sc.nextLine()             // Reads the next line of input as a string
-> sc.nextInt()              // Reads the next token as an int
-> sc.nextFloat()            // Reads the next token as a float
-> sc.nextDouble()           // Reads the next token as a double
-> sc.nextBoolean()          // Reads the next token as a boolean
-> sc.nextByte()             // Reads the next token as a byte
-> sc.nextShort()            // Reads the next token as a short
-> sc.nextLong()             // Reads the next token as a long

-> sc.hasNext()              // Returns true if there is another token in the input
-> sc.hasNextLine()          // Returns true if there is another line of input
-> sc.hasNextInt()           // Returns true if the next token is an int
-> sc.hasNextFloat()         // Returns true if the next token is a float
-> sc.hasNextDouble()        // Returns true if the next token is a double
-> sc.hasNextBoolean()       // Returns true if the next token is a boolean

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===== syntax:===================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Step1: import Scanner class (import java.util.Scanner)
Step2: Create an object of Scanner class
Step3: Display your message if you wants (Before getting user input)
Step4: call the Scanner method using its object for getting user input for (String, float, int, boolean) type.
Step5: close the object. (obj.close())


*/

// Import statement 
import java.util.Scanner;


public class p2_Type2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // By default java don't have any method for input character
        System.out.print("\nEnter a Character : ");
        char c = sc.next().charAt(0);  // charAt() method is used to take out first haracter from a string
        System.out.println("Your character [next().charAt method] : " + c);
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("\nEnter a String (without_Space) : ");
        String s = sc.next();
        System.out.println("Your String using [next() method] : " + s);
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("\nEnter a String (Spaces Accepts) : ");
        sc.nextLine(); // This line Remove input buffer
        s = sc.nextLine();
        System.out.println("Your String using [nextLine() method] : " + s);
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("\nEnter a Integer value : ");
        int i = sc.nextInt();
        System.out.println("Your Integer using [nextInt() method] : " + i);
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("\nEnter a float value : ");
        float f = sc.nextFloat();
        System.out.println("Your float using [nextFloat() method] : " + f);
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("\nEnter a Double value : ");
        double d = sc.nextDouble();
        System.out.println("Your Double using [nextDouble() method] : " + d);
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("\nEnter a Boolean value : ");
        boolean b = sc.nextBoolean();
        System.out.println("Your Boolean using [nextBoolean() method] : " + b);
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("\nEnter a Byte value : ");
        byte by = sc.nextByte();
        System.out.println("Your Byte using [nextByte() method] : " + by);
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("\nEnter a Short value : ");
        short sh = sc.nextShort();
        System.out.println("Your Short using [nextShort() method] : " + sh);
        
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("\nEnter a Long value : ");
        long l = sc.nextLong();
        System.out.println("Your Long using [nextLong() method] : " + l);
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        sc.close(); // Close the Scanner object
    }
}