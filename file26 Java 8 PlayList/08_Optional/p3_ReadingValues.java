/*
===============================================================================
                    Reading Values From Optional
===============================================================================

=> Since we alreay understand how to create or insert value inside the optional Now, in this file 
    we are trying to learn how to read date from the optional 

Java provides several methods.

    • isPresent()
    • get()
    • orElse()


===============================================================================
Methods to Read Value
===============================================================================


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. isPresent() method
============================================

Checks whether a value exists inside the Optional.

Return Type
    boolean



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. get() method
============================================

Returns the stored value.
Return Type ==> 'T'

Important
    Never call get() without checking isPresent().

Otherwise,
   ===> NoSuchElementException


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
orElse(defaultValue)
============================================

Returns the stored value.

If no value is present,
    ===> Returns the default value.


===============================================================================
Program
===============================================================================
*/

import java.util.Optional;

public class p3_ReadingValues
{
    public static void main(String[] args)
    {
        // creating optional with value 
        Optional<String> name = Optional.of("Rahul");

        // creating empty optional 
        Optional<String> city = Optional.empty();

        
        
        // -----------  isPresent() method -------------------------
        System.out.println("\nUsing isPresent : " + name.isPresent());   // true
        System.out.println("Using isPresent : " + city.isPresent());   // false 



        // -------------- get() ------------------
        if(name.isPresent())
            System.out.println("\nUsing get method : " + name.get());
        

        // ------------- orElse() ----------------
        System.out.println("\nCheck with orElese : " + name.orElse("Unknown"));
        System.out.println("\nCheck with orElese : " + city.orElse("Unknown"));
    }
}


/*
                Optional Box

          +----------------------+
          |      Rahul           |
          +----------------------+
        ┌──────────┼──────────────┐
        │          │              │
        ▼          ▼              ▼

  isPresent()     get()      orElse("Unknown")
      │            │              │
      ▼            ▼              ▼

    true         Rahul         Rahul


If Box is Empty            
      |____________________________
      │            │              │
      ▼            ▼              ▼

    false     Exception       Unknown
*/