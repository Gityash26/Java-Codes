/*
===============================================================================
                            collect Method (important)
===============================================================================

Till now, we have used forEach() to print the processed Stream.

Question: What if we don't want to print the data           
          What if we want to store the processed result into another Collection?


Example

        Original List [10, 15, 20, 25, 30]

Requirement
    Store only the even numbers into another List.
    For this purpose, Stream API provides the collect() method.


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
            └── collect()      ← You are here

collect() is a Terminal Operation because it finishes the Stream pipeline and returns the final 
result.


===============================================================================
Problem
===============================================================================
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p1_collectMethod
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10,15,20,25,30);

        /*===============================================================
        Using forEach()
        ===============================================================*/

        System.out.println("Printing Even Numbers");

        numbers.stream()
               .filter(num -> num % 2 == 0)
               .forEach(System.out::println);

        System.out.println();


        /*===============================================================
        Using collect()
        ===============================================================

        Store the processed Stream into another List. */

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println("New List");
        System.out.println(evenNumbers);
    }
}


/*

===============================================================================
How collect() Works
===============================================================================

Collection

        10, 15, 20, 25, 30
                 │
                 ▼
             stream()
                 │
                 ▼
             filter()
                 │
                 ▼

             (10, 20, 30)
                 │
                 ▼
        collect(Collectors.toList())
                 │
                 ▼
             New List [10, 20, 30]


===============================================================================
Behind the Scenes
===============================================================================

Without collect()

numbers.stream()
       .filter(...)
       .forEach(...)

↓

Only prints the result.
------------------------------------------------------------


With collect()

numbers.stream()
       .filter(...)
       .collect(Collectors.toList())
                ↓

Creates a NEW List containing the processed elements.


===============================================================================
Syntax
===============================================================================

Collect into List

        .collect(Collectors.toList())


Collect into Set

        .collect(Collectors.toSet())




===============================================================================
forEach() vs collect()
===============================================================================

forEach()

✔ Prints or performs an action.
✔ Returns void.
✔ Cannot store the result.


------------------------------------------------------------


collect()

✔ Stores the processed Stream.
✔ Returns a Collection or another result.
✔ Used in real-world applications.



===============================================================================
Memory Visualization
===============================================================================

Original List

10, 15, 20, 25, 30
        │
        ▼
    stream()
        │
        ▼
     filter()
        │
        ▼
    10, 20, 30
        │
        ▼
    collect()
        │
        ▼
    New List (10, 20, 30)


Original List remains unchanged.


===============================================================================
Remember
===============================================================================

✔ collect() is a Terminal Operation.
✔ It consumes the Stream.
✔ It is used to store the processed result.
✔ Original Collection is never modified.
✔ Usually used with Collectors.toList() or Collectors.toSet().
===============================================================================
* / 