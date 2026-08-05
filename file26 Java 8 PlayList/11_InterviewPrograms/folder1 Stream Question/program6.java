/*
===============================================================================
                            Program 6
===============================================================================

Question: Given a List of Integers, create a NEW List containing only the Odd Numbers in Ascending Order.

Input
    [8, 3, 7, 2, 9, 5, 4]

Output
    [3, 5, 7, 9]
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class program6 
{
    public static void main(String[] args) 
    {
        List<Integer> numList = Arrays.asList(8, 3, 7, 2, 9, 5, 4);

        List<Integer> sortedOddNumList = numList.stream()
                                                .filter(num -> (num%2) != 0)
                                                .sorted()
                                                .collect(Collectors.toList());

        System.out.println("\nOriginal list: " + numList);
        System.out.println("\nSorted odd number list: " + sortedOddNumList);
    }    
}
