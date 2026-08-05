/*
===============================================================================
                            Program 1
===============================================================================

Question: Given a List of Integers, print only the Even Numbers using Stream API.

Input    
    [10, 15, 20, 25, 30]

Output
    10 20 30


===============================================================================
Approach to follow
===============================================================================

Step 1: Create a Stream from the List.
Step 2: Keep only the Even Numbers.
Step 3: Print every remaining element.

*/

import java.util.List;
import java.util.Arrays;

public class program1
{
    public static void main(String[] args) 
    {
        // creating a list   
        List<Integer> numList = Arrays.asList(2, 5, 8, 3, 9, 4, 7);

        System.out.println("\nOriginal List: " + numList);

        System.out.println("\nEven numbers: ");

        // creating a stream 
        numList.stream()
               .filter(num -> num%2==0)
               .forEach(System.out::println);
        
    }
}