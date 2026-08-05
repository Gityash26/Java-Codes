/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Generic Method ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> A Generic Method is a method that can work with different data types.

-> Unlike a Generic Class, only the method is generic.

-> A Generic Method can be declared inside

   1. Normal Class
   2. Generic Class

-> The type parameter is declared before the return type.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Why Generic Method? ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we want to print different types of values.

Without Generics

        printInteger()

        printString()

        printDouble()

A separate method is required for every data type.

Using Generic Methods,

a single method can work with all data types.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Syntax ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public static <T> void display(T value)
{

}

Explanation

public          -> Access Modifier

static          -> Static Method

<T>             -> Type Parameter

void            -> Return Type

display()       -> Method Name

T value         -> Parameter

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Generic Method with Return Type =======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Syntax

public static <T> T getValue(T value)
{
    return value;
}

-> The method returns the same type that is passed.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Generic Method with Multiple Parameters =================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Syntax

public static <T> void print(T value1, T value2)

Example

print("Java", "Python");

print(10, 20);

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Advantages ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Eliminates Duplicate Methods.

2. Improves Code Reusability.

3. Provides Type Safety.

4. Detects Errors at Compile Time.

5. Easy to Maintain.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Important Notes =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✔ Generic Method can exist inside a Normal Class.

✔ Generic Method can also exist inside a Generic Class.

✔ Type Parameter is written before the return type.

Correct

        public static <T> void display(T value)

Incorrect

        public static void <T> display(T value)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== Frequently Asked Interview Questions ======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. What is a Generic Method?

2. Difference between Generic Class and Generic Method?

3. Where is <T> written?

4. Can Generic Methods return values?

5. Can Generic Methods have multiple parameters?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

public class p3_GenericMethod
{
    // ==========================================================
    // Generic Method
    // ==========================================================

    public static <T> void display(T value)
    {
        System.out.println("Value : " + value);
    }

    // ==========================================================
    // Generic Method with Return Type
    // ==========================================================

    public static <T> T getValue(T value)
    {
        return value;
    }

    // ==========================================================
    // Generic Method with Multiple Parameters
    // ==========================================================

    public static <T> void print(T first, T second)
    {
        System.out.println("First Value  : " + first);
        System.out.println("Second Value : " + second);
    }

    public static void main(String[] args)
    {
        // ======================================================
        // Calling display()
        // ======================================================

        display(100);

        display("Yash");

        display(99.99);

        display('A');

        display(true);

        // ======================================================
        // Calling getValue()
        // ======================================================

        Integer number = getValue(500);

        String name = getValue("Java");

        Double salary = getValue(65000.50);

        System.out.println("\nReturned Integer : " + number);

        System.out.println("Returned String  : " + name);

        System.out.println("Returned Double  : " + salary);

        // ======================================================
        // Calling print()
        // ======================================================

        System.out.println("\nPrinting Two Integers");

        print(10, 20);

        System.out.println("\nPrinting Two Strings");

        print("Hello", "World");

        System.out.println("\nPrinting Two Characters");

        print('X', 'Y');
    }
}