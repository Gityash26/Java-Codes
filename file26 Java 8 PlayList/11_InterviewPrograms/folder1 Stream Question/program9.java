/*
===============================================================================
                            Program 9
===============================================================================

Question: Given a List of Integers, count how many Even Numbers are present using Stream API.

Example

Input: [10, 15, 20, 25, 30, 35, 40]

Output: 4
*/

import java.util.Arrays;
import java.util.List;

public class program9 
{
    public static void main(String[] args) 
    {
        List<Integer> numList = Arrays.asList(10, 15, 20, 25, 30, 35, 40);
        
        long listCount = numList.stream()
                                .filter(num -> num%2 == 0)                        
                                .count();
        System.out.println(listCount);
                
    }
    
    
}
