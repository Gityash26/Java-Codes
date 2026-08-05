/*
===============================================================================
                            Program 8
===============================================================================

Question: Given a List of Integers, find the Minimum element using Stream API.

Example

Input
    [12, 45, 7, 89, 23, 56]

Output
    7

*/

import java.util.Arrays;
import java.util.List;

public class program8 
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(12, 45, 7, 89, 23, 56);
        
        list.stream()
            .min(Integer::compareTo)
            .ifPresent(System.out::println);
    }    
}
