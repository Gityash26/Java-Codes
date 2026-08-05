/*
===============================================================================
                            Program 11
===============================================================================

Question: Given a List of Integers, find the First Number greater than 50 using Stream API.

Example

Input: [12, 25, 40, 55, 60, 70]

Output: 55
*/

import java.util.Arrays;
import java.util.List;

public class program11 
{
    public static void main(String[] args)
    {
        List<Integer> numList = Arrays.asList(12, 25, 40, 55, 60, 70);

        numList.stream()
               .filter(num -> num>50)
               .findFirst()
               .ifPresent(System.out::println);
        
    }    
}
