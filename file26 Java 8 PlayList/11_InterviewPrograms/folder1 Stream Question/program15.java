/*
===============================================================================
                            Program 15
===============================================================================

Question: Given a List of Integers, calculate the SUM of the SQUARES of ONLY EVEN Numbers using Stream API.

Example

Input
    [2, 3, 4, 5, 6]

Output
    56

*/


import java.util.Arrays;
import java.util.List;

public class program15 
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6);
        
        list.stream()
            .filter(num -> num%2 ==0)
            .map(num -> num*num)
            .reduce((a,b) -> a+b)
            .ifPresent(System.out::println);
    }
}