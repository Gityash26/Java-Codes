/*
===============================================================================
                            Program 21
===============================================================================

Question: A company stores Employee names inside an Optional.

If the Employee name is present, print the name.

Otherwise print

    "Guest User"

Use Optional.orElse().

*/

import java.util.Optional;

public class program1 
{
    public static void main(String[] args) 
    {
        // optional objects 
        Optional<String> emp1 = Optional.of("Yash");
        Optional<String> emp2 = Optional.empty();

        // try to read 
        System.out.println("Employee_1 name : " + emp1.orElse("Guest User"));
        System.out.println("Employee_2 name : " + emp2.orElse("Guest User"));
    }    
}
