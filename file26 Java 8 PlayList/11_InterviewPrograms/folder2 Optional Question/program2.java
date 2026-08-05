/*
===============================================================================
                            Program 22
===============================================================================

Question: A company fetches Employee names from the database.
          If the name is present, print it.

Otherwise,
    call a method named getDefaultEmployee() which returns "Guest User".

Use Optional.orElseGet().

Rules

✓ Do NOT use if-else.
✓ Do NOT use isPresent().
✓ Use only orElseGet().

===============================================================================
*/

import java.util.Optional;

public class program2
{
    static String getDefaultEmployee()
    {
        System.out.println("Default Employee Created...");
        return "Guest User";
    }

    public static void main(String[] args)
    {
        Optional<String> emp1 = Optional.of("Yash");
        Optional<String> emp2 = Optional.empty();

        System.out.println(emp1.orElseGet(() -> getDefaultEmployee()));

        System.out.println(emp2.orElseGet(() -> getDefaultEmployee()));
    }
}