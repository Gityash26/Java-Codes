/*

Question: Given a List of Strings, calculate the TOTAL number of characters present in all Strings combined.

Rules

✓ Do NOT use loops.
✓ Do NOT use forEach().
✓ Do NOT use count().
✓ Use Stream API.
✓ Use reduce().


Example

Input: ["Java", "AI", "Spring"]

Output: 12

*/

import java.util.Arrays;
import java.util.List;

public class program19 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("Java", "AI", "Spring");

        strList.stream()
                .map(String::length)  // creates a stream of lengths of strings
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);
    }
}
