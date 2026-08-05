/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Generic Interface ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> A Generic Interface is an interface that uses one or more Type Parameters.

-> It allows different implementations to work with different data types.

-> Like Generic Classes, Generic Interfaces provide

    ✔ Type Safety

    ✔ Code Reusability

    ✔ Compile-Time Checking

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Why Generic Interface? =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we create an interface for storing data.

Without Generics

        interface Storage
        {
            Object getData();
        }

Every implementation returns Object.
The user must perform Type Casting.
Generics remove this problem.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============================== Syntax =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

interface InterfaceName<T>
{

}

Example

interface Printer<T>
{
    void print(T value);
}

Here,

T represents the data type.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Implementing Generic Interface ==========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Method 1

Specify the data type while implementing.

Example

class StudentPrinter implements Printer<String>

Method 2

Keep the implementing class Generic.

Example

class PrinterClass<T> implements Printer<T>

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Advantages =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Type Safety

2. Code Reusability

3. Eliminates Type Casting

4. Compile-Time Error Checking

5. Flexible Implementations

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Real Java Examples ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Comparable<T>

        Comparable<String>

Comparator<T>

        Comparator<Employee>

List<E>

Set<E>

Map<K, V>

Queue<E>

All of these use Generics.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Important Notes ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✔ Interfaces can also use Type Parameters.

✔ Generic Interfaces can have multiple Type Parameters.

Example

        interface Data<K, V>

✔ Generic Interfaces are widely used in the Collection Framework.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Frequently Asked Interview Questions ====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. What is a Generic Interface?

2. Difference between Generic Class and Generic Interface?

3. Can an Interface be Generic?

4. Name some Generic Interfaces used in Java.

5. How can a Generic Interface be implemented?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

// ==========================================================
// Generic Interface
// ==========================================================

interface Printer<T>
{
    void print(T value);
}

// ==========================================================
// Fixed Type Implementation
// ==========================================================

class StringPrinter implements Printer<String>
{
    @Override
    public void print(String value)
    {
        System.out.println("String : " + value);
    }
}

// ==========================================================
// Generic Implementation
// ==========================================================

class DataPrinter<T> implements Printer<T>
{
    @Override
    public void print(T value)
    {
        System.out.println("Value : " + value);
    }
}

public class p6_GenericInterface
{
    public static void main(String[] args)
    {

        // ======================================================
        // Fixed Type Implementation
        // ======================================================

        StringPrinter obj1 = new StringPrinter();

        obj1.print("Welcome to Java");

        // ======================================================
        // Generic Implementation
        // ======================================================

        DataPrinter<Integer> obj2 = new DataPrinter<>();

        obj2.print(100);

        DataPrinter<Double> obj3 = new DataPrinter<>();

        obj3.print(99.99);

        DataPrinter<Character> obj4 = new DataPrinter<>();

        obj4.print('A');

        DataPrinter<Boolean> obj5 = new DataPrinter<>();

        obj5.print(true);

        // ======================================================
        // Conclusion
        // ======================================================

        System.out.println("\nGeneric Interface executed successfully.");
    }
}