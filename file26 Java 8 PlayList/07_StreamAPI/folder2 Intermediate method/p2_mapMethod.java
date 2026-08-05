/*
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                        map() method
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

In the previous file, we learned that filter() selects only those elements that satisfy a condition.


Question: What if we don't want to remove any element?
          What if we simply want to change every element into another value?

Example

    10  → 100
    20  → 400
    30  → 900
    40  → 1600

For such transformations, Stream API provides the map() method.


=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Category
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Stream
    │
    ├── Intermediate Operations
    │       ├── filter()
    │       └── map()    ← You are here
    │
    └── Terminal Operations

map() is an Intermediate Operation because it transforms the data and
returns another Stream.




=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Problem
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Requirement, 
    Convert every number into its square.


Traditional Approach
===============================================================================
*/

import java.util.Arrays;
import java.util.List;

public class p4_mapMethod
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        System.out.println("Traditional Approach");

        for(Integer number : numbers)
        {
            System.out.println(number * number);
        }

        System.out.println();


        /*
        ===============================================================
        Using Stream API
        ===============================================================

        map() accepts a Function.

        Function

                R apply(T value)

        It receives one element and returns another value.
        */

        System.out.println("Using Stream API");

        numbers.stream()
               .map(number -> number * number)       // takes a number -> returns a number 
               .forEach(System.out::println);
    }
}

