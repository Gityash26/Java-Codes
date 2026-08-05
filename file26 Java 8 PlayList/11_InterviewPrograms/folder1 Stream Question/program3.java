/*
===============================================================================
                            Program 3
===============================================================================

Question: Given a List of Integers, create a NEW List containing only the Even Numbers using Stream API.

Input
    [10, 15, 20, 25, 30]

Output
    [10, 20, 30]


===============================================================================
Understanding the Question
===============================================================================

Step 1: Create a Stream from the List.

Step 2: Filter only the Even Numbers.

Step 3: Collect the filtered elements into a NEW List.

Step 4: Print the New List.


===============================================================================
Quick Revision
===============================================================================

stream()
====================================
Purpose  :   Creates a Stream from a Collection.
Returns  :Stream<T>
------------------------------------------------------------

filter()
====================================
Purpose  : Keeps only those elements which satisfy the given condition.
Takes    : Predicate
Returns  : A new Stream
------------------------------------------------------------

collect()
====================================
Purpose  : Collects the Stream elements into another form (List, Set, Map, etc.)
Returns: A Collection (depending on the Collector used)


*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class program3 
{
    public static void main(String[] args) 
    {
        List<Integer> originalList = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
        
        List<Integer> newEvenList = originalList.stream()
                                            .filter(num -> num%2==0)
                                            .collect(Collectors.toList());
        
        System.out.println("\nOriginal List : " + originalList);
        System.out.println("\nEven number List : " + newEvenList);
    }    
}
