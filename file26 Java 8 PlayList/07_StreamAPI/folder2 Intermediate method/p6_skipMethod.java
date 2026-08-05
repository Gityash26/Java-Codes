/*
===============================================================================
                                skip() method
===============================================================================

In the previous file, we learned that limit() keeps the first N elements.

Question: What if we want to ignore the first few elements?

Example

    [10, 20, 30, 40, 50, 60]

Requirement

Skip the first 2 elements and print the remaining elements.

For this purpose, Stream API provides the skip() method.


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
    │       ├── limit()
    │       └── skip()    ← You are here
    │
    └── Terminal Operations

skip() is an Intermediate Operation because it returns another Stream.


===============================================================================
Problem
===============================================================================
*/

import java.util.Arrays;
import java.util.List;

public class p8_skipMethod
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10,20,30,40,50,60);

        System.out.println("Original Collection");
        System.out.println(numbers);

        System.out.println();


        /*
        ===============================================================
        Using Stream API
        ===============================================================

        skip(2)
            Ignore the first 2 elements.
        */

        System.out.println("After skip(2)");

        numbers.stream()
               .skip(2)
               .forEach(System.out::println);
    }
}

