/*
===============================================================================
                        Creating Optional
===============================================================================

Before Java 8

Method
   │
   ├── Value found → Value
   └── Value not found → null

After Java 8

Method
   │
   ├── Value found → Optional[value]
   └── Value not found → Optional.empty()



There are three static methods used to create Optional in java  

    • of()
    • ofNullable()
    • empty()


===============================================================================
Methods to Create Optional
===============================================================================

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Optional.empty()
-----------------------------
    Creates an empty Optional object.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Optional.of(value)
-----------------------------
    Creates an Optional containing a NON-NULL value.

    
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Optional.ofNullable(value)
------------------------------
Creates an Optional If the value is NOT null

            Optional[value]

If the value is null

            Optional.empty
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~





===============================================================================
Method Signatures
===============================================================================

static <T> Optional<T> of(T value)

static <T> Optional<T> ofNullable(T value)

static <T> Optional<T> empty()


===============================================================================
Program
===============================================================================
*/

import java.util.Optional;

public class p2_CreatingOptional
{
    public static void main(String[] args)
    {
        /* ===============================================================
                Optional.of(value)
        ===============================================================*/

        Optional<String> name = Optional.of("Rahul");
        System.out.println("\nUsing Optional.of method ---> name = " + name);


        /*===============================================================
                Optional.ofNullable()
        ===============================================================*/

        String city = null;

        Optional<String> location = Optional.ofNullable(city);
        System.out.println("\nUsing Optional.ofNullable method ---> city_name = " + location);


        /*===============================================================
            Optional.empty()
        ===============================================================*/

        Optional<String> empty = Optional.empty();
        System.out.println("\nUsing Optional.empty method ---> " + empty);
    }
}
