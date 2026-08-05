/*
===============================================================================
                            findFirst() method
===============================================================================

Till now, we have learned different Terminal Operations.

Question: What if we only need the FIRST element of the Stream?

Example

    [10, 20, 30, 40, 50]

Requirement
    Get only the first element.

For this purpose, Stream API provides the findFirst() method.


===============================================================================
Category
===============================================================================

Stream
    │
    └── Terminal Operations
            ├── forEach()
            ├── collect()
            ├── count()
            └── findFirst()      ← You are here

findFirst() is a Terminal Operation because it consumes the Stream and returns only the first element.



===============================================================================
Return Type of findFirst()
===============================================================================

Method Signature

    Optional<T> findFirst()


Return Type
    Optional<T>


Question: Why doesn't findFirst() return T (e.g., Integer, String...)?

Because the Stream may be empty.

In such a case, there is no first element to return.
Instead of returning null, Java returns an Optional object.
This makes the API safer and helps avoid NullPointerException.


Examples

Collection [10, 20, 30]
        ↓

   findFirst()
        ↓

   Optional[10]

------------------------------------------------------------

Collection []
      ↓

  findFirst()
      ↓

Optional.empty()




===============================================================================
What is Optional?
===============================================================================

=> Optional is a final class introduced in Java 8.

=> It acts as a wrapper (container) that may or may not contain a value.

=> Instead of returning null, many Java 8 methods return an Optional object to safely represent 
   the presence or absence of a value.


It can represent two states:

    1. Value Present
        Optional[10]


    2. No Value Present
        Optional.empty()


Problem
===============================================================================
*/

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class p3_findFirstMethod
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);


        // Find First Element
        Optional<Integer> first = numbers.stream()
                                         .findFirst();

        System.out.println("\nFirst element of the ArrayList: " + first);


        
        // Get First Even Number

        Optional<Integer> even = numbers.stream()
                                        .filter(num -> num % 2 == 0)
                                        .findFirst();

        System.out.println("\nFirst even number of the ArrayList: " + even);



        /*
        ===============================================================
        Read the Value
        ===============================================================
        */

        if(first.isPresent())
        {
            System.out.println("\nFirst Element value : " + first.get());
        }
    }
}

