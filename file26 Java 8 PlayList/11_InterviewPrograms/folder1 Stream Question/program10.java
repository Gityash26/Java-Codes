/*
===============================================================================
                            Program 10
===============================================================================

Question: Given a List of Integers, find the First Even Number using Stream API.

Example
    Input: [11, 15, 18, 20, 22, 25]
    Output: 18


====*/

import java.util.Arrays;
import java.util.List;

public class program10 
{
    public static void main(String[] args) 
    {
        List<Integer> numList = Arrays.asList(11, 15, 18, 20, 22, 25);

        System.out.println(numList.stream()
               .filter(num -> num % 2 == 0)
               .findFirst()
               .get());
            
    }    
}
