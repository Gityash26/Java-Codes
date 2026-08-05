/*
===============================================================================
                            Program 12
===============================================================================

Question: Given a List of Integers, check whether there is ANY Negative Number present using Stream API.

Example 1

Input: [10, 20, -5, 30, 40]

Output: true
*/

import java.util.Arrays;
import java.util.List;

public class program12
{
    public static void main(String[] args)
    {
        
        List<Integer> list = Arrays.asList(10, 20, -5, 30, 40);

        System.out.println(list.stream()
            .anyMatch(num -> num<0)); 
                           
    }    
}
