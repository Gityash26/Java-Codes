/*
===============================================================================
                            Program 24
===============================================================================

Question: A company searches for an Employee by ID.
If the Employee exists, print

    Employee Found : <Employee Name>

Otherwise print

    Employee Not Found

Use Optional.ifPresentOrElse().

Rules

✓ Do NOT use if-else.
✓ Do NOT use isPresent().
✓ Do NOT use get().
*/



import java.util.Optional;

public class program4
{
    public static void main(String[] args)
    {
        Optional<String> emp1 = Optional.of("Yash");
        Optional<String> emp2 = Optional.empty();

        emp1.ifPresentOrElse((name) -> System.out.println("Employee found : " + name) , () -> System.out.println("Employee Not Found\r\n"));
        
        emp2.ifPresentOrElse((name) -> System.out.println("Employee found : " + name) , () -> System.out.println("Employee Not Found\r\n"));

    }
}