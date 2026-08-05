/*
===============================================================================
                            Program 7
===============================================================================

Question: Given a List of Integers, find the Maximum element using Stream API.

Example

Input
    [12, 45, 7, 89, 23, 56]

Output
    89

*/

import java.util.Arrays;
import java.util.List;

public class program7 {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(12, 45, 7, 89, 23, 56);

        numList.stream()
                .max(Integer::compareTo)
                .ifPresent(System.out::println);

    }
}
