/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================ Primitive Data Types vs Wrapper Classes ========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Primitive Data Types are the basic built-in data types provided by Java.

-> Wrapper Classes are predefined classes that wrap primitive values into
   objects.

-> Both are used to store data, but they differ in several aspects.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Primitive Data Types ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Definition

-> Primitive Data Types store actual values directly in memory.

Examples

    byte
    short
    int
    long
    float
    double
    char
    boolean

Example

    int age = 22;

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Wrapper Classes =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Definition

-> Wrapper Classes store primitive values as objects.

Examples

    Byte
    Short
    Integer
    Long
    Float
    Double
    Character
    Boolean

Example

    Integer age = 22;

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Comparison Table ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

----------------------------------------------------------------------------
Primitive Data Types              Wrapper Classes
----------------------------------------------------------------------------

Store actual values               Store values as objects

Built into Java language          Predefined classes (java.lang)

Faster                            Slightly slower

Less memory                       More memory

Cannot store null                 Can store null

No methods available              Many built-in methods

Cannot be used directly
with Collections                  Can be used with Collections

Cannot be used as Generic type    Can be used as Generic type

Mutable value                     Immutable objects

Default values:
0, false, '\0'                    Default value is null
(for fields)

----------------------------------------------------------------------------
Example

Primitive

    int number = 100;

Wrapper

    Integer number = 100;

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== When to Use Primitive? ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Use Primitive Data Types when

✔ High performance is required.

✔ Less memory usage is important.

✔ Mathematical calculations are frequent.

✔ Null values are not required.

Example

    int marks = 95;

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== When to Use Wrapper? ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Use Wrapper Classes when

✔ Working with Collection Framework.

✔ Using Generics.

✔ Calling Wrapper utility methods.

✔ Null values are required.

✔ Object representation is needed.

Example

    ArrayList<Integer> list = new ArrayList<>();

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Important Notes =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✔ Wrapper Classes are immutable.

✔ Wrapper Classes belong to java.lang package.

✔ Collections cannot store primitive data types.

✔ Generics work only with reference types.

✔ Autoboxing automatically converts primitive values into Wrapper objects.

✔ Auto-Unboxing automatically converts Wrapper objects into primitive values.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Frequently Asked Interview Questions ====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Difference between int and Integer?

2. Which one is faster?

3. Which one consumes more memory?

4. Why can't Collections store primitive types?

5. Which one supports null values?

6. Which one should be used inside Generics?

7. Are Wrapper Classes immutable?

8. When should Wrapper Classes be preferred over primitives?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import java.util.ArrayList;

public class p5_ComparisonBetweenPrimitiveAndWrapper {

    public static void main(String[] args) {

        // ==========================================================
        // Primitive Data Type
        // ==========================================================

        int primitiveAge = 22;

        System.out.println("Primitive int : " + primitiveAge);

        // ==========================================================
        // Wrapper Class
        // ==========================================================

        Integer wrapperAge = 22;

        System.out.println("Wrapper Integer : " + wrapperAge);

        // ==========================================================
        // Null Support
        // ==========================================================

        Integer marks = null;

        System.out.println("\nWrapper can store null : " + marks);

        // Primitive variables cannot store null.
        // int number = null;      // Compilation Error

        // ==========================================================
        // Collections Example
        // ==========================================================

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("\nArrayList using Wrapper Class : " + list);

        // ArrayList<int> list = new ArrayList<>();
        // Not Allowed because Generics work only with objects.

        // ==========================================================
        // Wrapper Utility Method
        // ==========================================================

        int maximum = Integer.max(50, 100);

        System.out.println("\nMaximum Number : " + maximum);

        // ==========================================================
        // Autoboxing Example
        // ==========================================================

        int number = 500;

        Integer object = number;

        System.out.println("\nAutoboxing");

        System.out.println("Primitive : " + number);

        System.out.println("Wrapper   : " + object);

        // ==========================================================
        // Auto-Unboxing Example
        // ==========================================================

        Integer salary = 45000;

        int employeeSalary = salary;

        System.out.println("\nAuto-Unboxing");

        System.out.println("Wrapper   : " + salary);

        System.out.println("Primitive : " + employeeSalary);

        // ==========================================================
        // Final Conclusion
        // ==========================================================

        System.out.println("\n================ Conclusion ================");

        System.out.println("Primitive Data Types are faster and consume less memory.");

        System.out.println("Wrapper Classes provide object-oriented features and");

        System.out.println("are required for Collections and Generics.");
    }
}