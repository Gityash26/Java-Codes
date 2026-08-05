/*
===============================================================================
                            Program 13
===============================================================================

Question: Given a List of Integers, check whether ALL the numbers are Even using Stream API.

Input: [2, 4, 6, 8, 10]

Output: true

*/

import java.util.Arrays;
import java.util.List;

public class program13 
{    
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);

        System.out.println(list.stream().allMatch(num -> num%2==0));
    }
}
