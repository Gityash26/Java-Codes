/*
===============================================================================
                            Program 2
===============================================================================

Question: A List of Integers was given, create a new Stream containing the Square of every 
          number and print the result.

Example

Input
    [2, 4, 6, 8]

Output
    4 16 36 64


===============================================================================
Understanding the Question
===============================================================================

Step 1: Create a Stream from the List.
Step 2: Convert every number into its Square.
Step 3: Print the transformed Stream.


map()

Purpose: Transforms every element into another value.
        Takes
                ===> Function
                    (Takes one input and returns another value.)

Returns
    A new Stream containing the transformed elements.
*/

import java.util.Arrays;
import java.util.List;

public class program2
{
    public static void main(String[] args) 
    {
        List<Integer> numList = Arrays.asList(2, 4, 6, 8);
        
        System.out.println("\nOriginal List : " + numList);
        System.out.println("\nSquared Values:");

        // creating a stream 
        numList.stream()
               .map(num -> num*num)
               .forEach(System.out::println);

    }
}