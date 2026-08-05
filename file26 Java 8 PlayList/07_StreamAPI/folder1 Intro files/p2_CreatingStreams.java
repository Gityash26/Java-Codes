/*
===============================================================================
                            P2_CreatingStreams
===============================================================================

In the previous file, we learned that Stream API is used to process data stored
inside a Collection.

The first step is to create a Stream.

Syntax

    Stream<DataType> stream = collection.stream();

Here,

Collection
    │
    └── stream()
            │
            ▼
      Stream Object

Question: Does stream() create another Collection?

No.

The stream() method simply creates a Stream object that can process the elements of the Collection. 
The original Collection remains unchanged.


===============================================================================
Memory Representation
===============================================================================

Before stream()

        numbers
           │
           ▼
    +---------------------------+
    | 10 | 20 | 30 | 40 | 50 |
    +---------------------------+
            List Object


After stream()

        numbers                          stream
           │                                │
           ▼                                ▼
    +------------------------+         +----------------+
    │ 10 │ 20 │ 30 │ 40 | 50 │  <======│Stream Object   │
    +------------------------+         +----------------+
                                            │
                                            ▼
                              Reads Collection elements
                              one by one for processing.


Notice

✔ No new List is created.
✔ No data is copied.
✔ Only a Stream object is created.


===============================================================================
Problem
===============================================================================

Requirement:
Print all elements of the List.

Traditional Approach
--------------------
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class p2_CreatingStreams
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(10,20,30,40,50);

        System.out.println("Traditional Approach");

        for(Integer number : list)
        {
            System.out.println(number);
        }





        /*--------------------------------------------------------------------
        The above approach works perfectly.
        But Java 8 allows us to process the same Collection using a Stream.
        --------------------------------------------------------------------*/

        // Creating a stream object 
        Stream<Integer> stream = list.stream();

        System.out.println("\nUsing Stream : ");

        // Terminal method------------>  foreach()
        stream.forEach(System.out::println);
    }
}
 