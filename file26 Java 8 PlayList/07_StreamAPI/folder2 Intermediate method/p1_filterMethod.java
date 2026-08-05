/*
===============================================================================
                                P3_filter()
===============================================================================

After creating a Stream, the first common requirement is to select only those elements that 
satisfy a particular condition.

Suppose we have the following Collection.

        [10, 15, 20, 25, 30, 35, 40]

Requirement

Print only EVEN numbers.

Instead of checking every element manually using an if-condition,
Stream API provides the filter() method.


===============================================================================
Category
===============================================================================

Stream
    │
    ├── Intermediate Operations
    │       └── filter()   ← You are here
    │
    └── Terminal Operations

filter() is an Intermediate Operation because it only processes the data.
It does not produce the final output.


===============================================================================
Traditional Approach
===============================================================================

*/

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class p3_filterMethod
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10,15,20,25,30,35,40);

        System.out.println("\nTraditional Approach");

        for(Integer number : numbers)
        {
            if(number % 2 == 0)
            {
                System.out.println(number);
            }
        }

        System.out.println();


        /*
        ===============================================================
        Using Stream API
        ===============================================================

        filter() accepts a Predicate.         ----> predicate<datatype> object =  (var) -> Condition

        Predicate

                boolean test(T value)

        For every element,

            true  → Keep the element.
            false → Discard the element.

        */

        System.out.println("\nUsing Stream API ---> Long approach");


        // -----------------------------------------------
        // long approach 
        // -----------------------------------------------
        Stream<Integer> s = numbers.stream();                 // creating a stream object on list 
        Stream<Integer> filtered = s.filter(num -> num%2==0;);                // creating second stream object --> to store the filter returned stream 
        filtered.forEach(System.out::println);                   // using foreach to print each element 




        System.out.println("\nUsing Stream API ---> short approach");

        /*-----------------------------------------------
            Short approach 
        -----------------------------------------------
        ust create stream obuject on the collection and start putting Operations

        numbers (Collection)
                │
                ▼
             stream()                      ← Creates a Stream
                │
                ▼
             filter()                      ← Intermediate Operation
                │
                ▼
             forEach()                     ← Terminal Operation
                │
                ▼
              Output

        */ 
        numbers.stream()
               .filter(num -> num % 2 == 0)
               .forEach(System.out::println);
    }
}


/*

===============================================================================
How filter() Works
===============================================================================

Collection

10, 15, 20, 25, 30, 35, 40
        │
        ▼
     stream()
        │
        ▼
filter(number -> number % 2 == 0)
        │
        ▼

        ┌───────────────┐
10  ───▶│   true  ✔     │
15  ───▶│   false ✘     │
20  ───▶│   true  ✔     │
25  ───▶│   false ✘     │
30  ───▶│   true  ✔     │
35  ───▶│   false ✘     │
40  ───▶│   true  ✔     │
        └───────────────┘

        │
        ▼
  10, 20, 30, 40
        │
        ▼
    forEach()
        │
        ▼
   '''Output''''

*/