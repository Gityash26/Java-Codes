/*
===============================================================================
                                sorted method
===============================================================================

Sometimes our Collection is not arranged in the required order.

Example

    [40, 10, 30, 20, 50]

Requirement

Print the numbers in ascending order.

Instead of sorting the Collection manually, Stream API provides the sorted() method.


===============================================================================
Category
===============================================================================

Stream
    │
    ├── Intermediate Operations
    │       ├── filter()
    │       ├── map()
    │       └── sorted()    ← You are here
    │
    └── Terminal Operations

sorted() is an Intermediate Operation because it returns another Stream containing the sorted elements.


===============================================================================
Problem
===============================================================================

Requirement
    Print all numbers in ascending order.

Traditional Approach
===============================================================================
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p5_sortedMethod
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(40,10,30,20,50);

        System.out.println("Original List");
        System.out.println(numbers);

        System.out.println();


        /*
        ===============================================================
        Traditional Approach
        ===============================================================
        */

        Collections.sort(numbers);

        System.out.println("After Collections.sort()");

        for(Integer number : numbers)
        {
            System.out.println(number);
        }

        System.out.println();


        /*
        ===============================================================
        Using Stream API
        ===============================================================

        sorted() arranges the Stream elements in their natural order.

        */

        List<Integer> numbers2 = Arrays.asList(40,10,30,20,50);

        System.out.println("Using Stream API - sort() method");

        numbers2.stream()
                .sorted()
                .forEach(System.out::println);
    }
}


/*


===============================================================================
How does sorted() know the order?
===============================================================================

sorted() uses the natural ordering of the elements.

Examples

Integer  → Comparable
String   → Comparable
Double   → Comparable

These classes already know how to compare themselves.

That's why this works automatically.

    numbers.stream()
           .sorted()


===============================================================================
What about Custom Objects?
===============================================================================

If the Collection contains custom objects like Employee or Student,
sorted() will not know how to compare them.

In that case, we provide a Comparator.

Example

employees.stream()
         .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

We'll study this in detail later.


===============================================================================
Syntax
===============================================================================

Natural Order
    stream.sorted()

Descending Order
    stream.sorted(Comparator.reverseOrder())

Custom Sorting
    stream.sorted(comparator)


===============================================================================
Output
===============================================================================

Original List: [40, 10, 30, 20, 50]

After Collections.sort()

10. 20, 30, 40, 50

Using Stream API

10, 20, 30, 40, 50

*/