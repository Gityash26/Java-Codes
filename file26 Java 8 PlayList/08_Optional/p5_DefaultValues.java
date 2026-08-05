/*

~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~        
                 Default Values And Best Practices
~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~=~=~=~~=~


Till now we have learned

    ✔ How to create an Optional.
    ✔ How to check if a value exists.
    ✔ How to read the value.
    ✔ How to transform the value.


Question
    What should we do if the Optional is empty?

Java provides three methods for such situations.

    • orElse()
    • orElseGet()
    • orElseThrow()




===============================================================================
Method Signatures
===============================================================================

T orElse(T other)

T orElseGet(Supplier)

<T extends Throwable> T orElseThrow(Supplier exceptionSupplier)
        throws X


===============================================================================
Method Definition
===============================================================================



------------------------------------------------------------
orElse(default value)
============================================================
    This method return the default value if the Optional was empty



------------------------------------------------------------
orElseGet(supplier)
============================================================

    This method Returns the value stored inside the Optional.

    If no value is present, 
        => Calls the Supplier to create a default value and returns it.

Useful when creating the default value is expensive.


------------------------------------------------------------
orElseThrow()
============================================================

    This method returns the value stored inside the Optional.

If no value is present,
    => Throws the specified exception.




===============================================================================
Program
===============================================================================
*/

import java.util.Optional;

public class p5_DefaultValues
{
    public static void main(String[] args)
    {
        // creating an optional 
        Optional<String> name = Optional.of("Rahul");

        // creating an empty optional 
        Optional<String> city = Optional.empty();



        /*===============================================================
            ---------- orElse() ----------------------------------------
        ===============================================================*/

        System.out.println("\nUsing orElese method (Optional): " + name.orElse("Unknown user"));
        System.out.println("Using orElese method (Empty Optional): " + city.orElse("Unknown City"));




        /*===============================================================
          ----------- orElseGet() ---------------------------------------
        ===============================================================*/

        System.out.println("\nUsing orEleseGet method (Optional): " + name.orElseGet(() -> "Default supplier name..."));
        System.out.println("Using orElese method (Optional): " + city.orElseGet(() -> "Default empty supplier city name..."));


        /*===============================================================
          ---------- orElseThrow() --------------------------------------
        ===============================================================
        */

        try
        {
            System.out.println("\nUsing elseThrow : " + name.orElseThrow());
            System.out.println("Using elseThrow on empty throable : " + city.orElseThrow());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

