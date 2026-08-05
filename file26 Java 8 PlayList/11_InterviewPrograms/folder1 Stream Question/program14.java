/*
===============================================================================
                            Program 14
===============================================================================

Question: Given a List of Integers, check whether NONE of the numbers are Negative using Stream API.

Example 1

Input: [10, 20, 30, 40]

Output: true
*/

import java.util.Arrays;
import java.util.List;

public class program14 
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(0, 20, 30, 40);
        
        System.out.println(list.stream().noneMatch(num -> num<0));
    }    
}
