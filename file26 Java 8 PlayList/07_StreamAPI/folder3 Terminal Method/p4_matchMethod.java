/*
===============================================================================
                        Match() Methods
===============================================================================

Till now, we have learned Terminal Operations that return

✔ Collection
✔ Number
✔ First Element


Question
    we have to check whether a condition is true or false?


Example

    Students [Rahul, Amit, Neha, Ankit]

Requirement
    • Is there ANY student whose name starts with 'A'?
    • Do ALL students have names longer than 3 characters?
    • Does NO student's name start with 'Z'?

For such yes/no questions, Stream API provides three methods.

    • anyMatch()
    • allMatch()
    • noneMatch()


===============================================================================
Category
===============================================================================

Stream
    │
    └── Terminal Operations
            ├── forEach()
            ├── collect()
            ├── count()
            ├── findFirst()
            └── Match Methods     ← You are here (consume 1, return True/False)

All three methods are Terminal Operations because they consume the Stream and return a boolean value.


===============================================================================
Method Signatures
===============================================================================

    boolean anyMatch(Predicate)

    boolean allMatch(Predicate)

    boolean noneMatch(Predicate)


Return Type
    boolean

Parameter
    Predicate<T>



===============================================================================
Program
===============================================================================
*/

import java.util.Arrays;
import java.util.List;

public class p4_matchMethod
{
    public static void main(String[] args)
    {
        List<String> names = Arrays.asList("Rahul","Amit","Neha","Ankit");


        /*===============================================================
                anyMatch()
        ===============================================================*/

        boolean any = names.stream()
                           .anyMatch(name -> name.startsWith("A"));

        System.out.println("Any name starts with A : " + any);
        System.out.println();


        /*===============================================================
                allMatch()
        ===============================================================*/

        boolean all = names.stream()
                           .allMatch(name -> name.length() > 3);

        System.out.println("All names length > 3 : " + all);
        System.out.println();


        /*===============================================================
                noneMatch()
        ===============================================================*/

        boolean none = names.stream()
                            .noneMatch(name -> name.startsWith("Z"));

        System.out.println("No name starts with Z : " + none);
    }
}


/*

===============================================================================
Quick Comparison
===============================================================================

anyMatch()

    At least ONE element satisfies the condition.

---------------------------------------------
allMatch()

    EVERY element must satisfy the condition.

---------------------------------------------

noneMatch()

    NO element should satisfy the condition.


===============================================================================
Remember
===============================================================================

✔ All three are Terminal Operations.
✔ All consume the Stream.
✔ All return boolean.
✔ All take Predicate as a parameter.
✔ Used when we only need True/False.

===============================================================================
*/