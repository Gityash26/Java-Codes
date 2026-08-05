/*
===============================================================================
                            Program 5
===============================================================================

Question: Given a List of Integers, create a NEW List containing only the Distinct (Unique) elements.

Input
    [10, 20, 10, 30, 40, 20, 50, 30]

Output
    [10, 20, 30, 40, 50]

*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class program5
{
    public static void main(String[] args) 
    {
        // creating a list 
        List<Integer> numList = Arrays.asList(10, 20, 10, 30, 40, 20, 50, 30); 

        List<Integer> newList = numList.stream().distinct().collect(Collectors.toList());
        
        System.out.println("\nOriginal List: " + numList);
        System.out.println("\nList with distinct elements only: " + newList);
    }
}