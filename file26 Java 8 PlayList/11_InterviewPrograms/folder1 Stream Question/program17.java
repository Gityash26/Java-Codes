/*
===============================================================================
                            Program 17
===============================================================================

Question: Given a List of Integers, find the Largest Number using Stream API.

Rules

✓ Do NOT use loops.
✓ Do NOT use max().
✓ Do NOT use sorted().
✓ Use reduce() only.   ------------------ just use reduce


Input: [12, 5, 90, 33, 44]

Output: 90
*/

import java.util.Arrays;
import java.util.List;

public class program17 
{
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(12, 5, 90, 33, 44);        
        list.stream().reduce((a,b) -> (a>b)?a:b).ifPresent(System.out::println);
    }    
}
