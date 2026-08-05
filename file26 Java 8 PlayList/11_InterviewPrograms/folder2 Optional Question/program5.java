/*
===============================================================================
                            Program 25
===============================================================================

Question: A company stores an Employee name inside an Optional.
Convert the Employee name into UPPERCASE using Optional.map().
*/


import java.util.Optional;

public class program5 
{
    public static void main(String[] args) 
    {
        Optional<String> name = Optional.of("Yash sharma");    

        name.map(String::toUpperCase).ifPresent(System.out::println);
    }
}    
