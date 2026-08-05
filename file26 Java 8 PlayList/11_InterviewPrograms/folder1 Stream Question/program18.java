/*

Question: Given a List of Integers, find the SMALLEST odd number
greater than 10.

Rules

--------------- Not allowed ---------------
✓ Do NOT use loops.
✓ Do NOT use min().
✓ Do NOT use sorted().

--------------- Allowed ---------------
✓ Use Stream API.
✓ Use reduce().


Example

Input
    [3, 18, 15, 7, 21, 30, 13]

Output
    13

*/

import java.util.Arrays;
import java.util.List;

public class program18 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 18, 15, 7, 21, 30, 13);
        list.stream().filter(num -> (num % 2 != 0) && (num>10)).reduce((a, b) -> (a < b) ? a : b).ifPresent(System.out::println);
    }
}
