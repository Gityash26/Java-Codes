/*
===============================================================================
                            Program 23
===============================================================================

Question: A company searches for an Employee by ID.
          If the Employee exists, print the Employee name.

Otherwise,
    throw a RuntimeException with the message

    "Employee Not Found"

Use Optional.orElseThrow().

Rules

✓ Do NOT use if-else.
✓ Do NOT use isPresent().
✓ Do NOT use get().
✓ Use only orElseThrow().

===============================================================================
*/

import java.util.Optional;

public class program3 {
    public static void main(String[] args) {
        Optional<Integer> emp1_Id = Optional.of(1234);
        Optional<Integer> emp2_Id = Optional.empty();

        System.out.println(emp1_Id.orElseThrow());
        System.out.println(emp2_Id.orElseThrow(() -> new RuntimeException("Employee Not Found")));
    }
}
