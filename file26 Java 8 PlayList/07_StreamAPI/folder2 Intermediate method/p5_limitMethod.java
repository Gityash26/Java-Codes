/*
===============================================================================
                         limit() Method  
===============================================================================

Sometimes a Collection contains many elements, but we only need the first
few elements.

Example

    [10, 20, 30, 40, 50, 60, 70]

Requirement
        Print only the first 3 elements.

Instead of using loops and counters, Stream API provides the limit() method.


===============================================================================
Category
===============================================================================

Stream
    │
    ├── Intermediate Operations
    │       ├── filter()
    │       ├── map()
    │       ├── sorted()
    │       ├── distinct()
    │       └── limit()    ← You are here
    │
    └── Terminal Operations

limit() is an Intermediate Operation because it returns another Stream.


===============================================================================
Problem
===============================================================================
*/

import java.util.Arrays;
import java.util.List;

public class p7_limitMethod
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10,20,30,40,50,60,70);

        System.out.println("Original Collection");
        System.out.println(numbers);

        System.out.println();


        /*
        ===============================================================
        Using Stream API
        ===============================================================

        limit(3)
                Keep only the first 3 elements.
        */

        System.out.println("After limit(3)");

        numbers.stream()
               .limit(3)
               .forEach(System.out::println);
    }
}


/*

===============================================================================
Real World Example
===============================================================================

Suppose a database returns 100 Employees.

You only want to display the first 10.

employees.stream()
         .limit(10)
         .forEach(System.out::println);


===============================================================================
Remember
===============================================================================

✔ limit() is an Intermediate Operation.
✔ It returns another Stream.
✔ It keeps only the first N elements.
✔ If the Stream contains fewer than N elements, all elements are returned.
✔ It never modifies the original Collection.
===============================================================================
*/