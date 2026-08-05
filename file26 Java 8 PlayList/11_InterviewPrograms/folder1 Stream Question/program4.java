/*
===============================================================================
                            Program 4
===============================================================================

Question: Given a List of Integers, create a NEW List containin the Square of only the Even Numbers.

Example

Input: [2, 3, 4, 5, 6]

Output: [4, 16, 36]


===============================================================================
Understanding the Question
===============================================================================

Operation 1: Consider only the Even Numbers.

Operation 2: Convert every remaining number into its Square.

Opration 3: Store the final result into a NEW List.
*/

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class program4 
{
    public static void main(String[] args) 
    {
        List<Integer> numList = Arrays.asList(2, 3, 4, 5, 6);

        List<Integer> evenSquareList = numList.stream()
                                              .filter(num -> num % 2==0)
                                              .map(num -> num*num)
                                              .collect(Collectors.toList());
        
        System.out.println("\nOriginal List: " + numList);
        System.out.println("\nEven Number Squares : " + evenSquareList);

    }    
}
