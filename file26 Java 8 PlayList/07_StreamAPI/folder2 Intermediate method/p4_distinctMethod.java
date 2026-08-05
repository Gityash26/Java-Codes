/*
===============================================================================
                            distinct() method
===============================================================================

Sometimes a Collection contains duplicate elements.

Example

    [10, 20, 10, 30, 20, 40, 30]

Requirement

Print only the unique elements.

Instead of writing extra logic, Stream API provides the distinct() method.


===============================================================================
Category
===============================================================================

Stream
    │
    ├── Intermediate Operations
    │       ├── filter()
    │       ├── map()
    │       ├── sorted()
    │       └── distinct()   ← You are here
    │
    └── Terminal Operations

distinct() is an Intermediate Operation because it returns another Stream.


===============================================================================
Problem
===============================================================================
*/

import java.util.Arrays;
import java.util.List;

public class p6_distinctMethod
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10,20,10,30,20,40,30);

        System.out.println("Original Collection");
        System.out.println(numbers);

        System.out.println();

        System.out.println("After distinct()");

        numbers.stream()
               .distinct()
               .forEach(System.out::println);
    }
}


/*

===============================================================================
How does distinct() remove duplicates?
===============================================================================

Internally, distinct() uses equals() to determine whether two objects are equal.

For Wrapper classes and String, equals() is already implemented.

Therefore,

10 == 10   → Duplicate

"Java" == "Java" (using equals()) → Duplicate


For Custom Objects

If you want distinct() to remove duplicate Employee or Student objects, you should properly override 
equals() and hashCode().

*/