/*
===============================================================================
                            Program 16
===============================================================================

Question: Given a List of Strings, find the Longest String using Stream API.

Input ["Java", "SpringBoot", "AI", "Microservices", "Cloud"]

Output : Microservices

*/

import java.util.Arrays;
import java.util.List;

public class program16 
{
    public static void main(String[] args) 
    {
        List<String> strList = Arrays.asList("Java", "SpringBoot", "AI", "Microservices", "Cloud");

        strList.stream().reduce((s1,s2) -> s1.length() > s2.length()? s1:s2).ifPresent(System.out::println);

    }    
}
