/*
===============================================================================
                                count() method
===============================================================================

Till now, we have learned that collect() returns a new Collection.

Question: What if we only want to know how many elements are present?

Example

    [10, 20, 30, 40, 50]

Requirement

    Find the total number of elements.
    For this purpose, Stream API provides the count() method.


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
    │       └── skip()
    │
    └── Terminal Operations
            ├── forEach()
            ├── collect()
            └── count()      ← You are here

count() is a Terminal Operation because it consumes the Stream and
returns the total number of elements.


===============================================================================
Problem
===============================================================================
*/

import java.util.Arrays;
import java.util.List;

public class p2_countMethod
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60);

        
        // ============= Count All Elements ================

        long total = numbers.stream()
                            .count();

        System.out.println("Total Elements : " + total);
        System.out.println();


        // ============= Count Even Numbers ================= 

        long evenCount = numbers.stream()
                                .filter(num -> num % 2 == 0)
                                .count();

        System.out.println("Even Numbers : " + evenCount);
    }
}

