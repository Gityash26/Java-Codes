/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Introduction to Generics ============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Generics is a feature introduced in Java 5 (JDK 1.5).

-> Generics allow classes, interfaces and methods to work with different
   data types while providing compile-time type safety.

-> Instead of specifying a fixed data type, Generics use type parameters.

Example

        ArrayList<String>

Here,

        String

is the type parameter.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Why Generics? =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Before Java 5, Collection Framework stored everything as Object.

Example

        ArrayList list = new ArrayList();

        list.add("Yash");

        list.add(100);

        list.add(true);

Since every object was stored as Object,

-> Different data types could be mixed.

-> Explicit type casting was required.

-> Runtime errors were more common.

Generics solved these problems.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Problems Before Generics ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Without Generics

        ArrayList list = new ArrayList();

        list.add("Java");

        list.add(100);

Retrieving data

        String str = (String) list.get(0);

Problems

1. Manual Type Casting

2. Runtime ClassCastException

3. Less Readable Code

4. Less Type Safety

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Advantages of Generics ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Type Safety

-> Detects incompatible data types during compilation.

------------------------------------------------------------

2. Eliminates Type Casting

Without Generics

        String name = (String) list.get(0);

With Generics

        String name = list.get(0);

------------------------------------------------------------

3. Code Reusability

One Generic class can work with multiple data types.

------------------------------------------------------------

4. Compile-Time Error Checking

Most type-related mistakes are detected before program execution.

------------------------------------------------------------

5. Better Readability

Code becomes easier to understand and maintain.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Generic Syntax =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Class

        class Box<T>

Interface

        interface Printer<T>

Method

        public <T> void display(T value)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Common Type Parameter Names ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

------------------------------------------------------------
Letter                  Meaning
------------------------------------------------------------

T               Type

E               Element

K               Key

V               Value

N               Number

R               Return Type

------------------------------------------------------------

Example

        HashMap<K, V>

K -> Key

V -> Value

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Where Generics are Used ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Collection Framework

        ArrayList<String>

        HashSet<Integer>

        HashMap<Integer, String>

------------------------------------------------------------

2. Generic Classes

------------------------------------------------------------

3. Generic Methods

------------------------------------------------------------

4. Generic Interfaces

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Important Notes =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✔ Introduced in Java 5.

✔ Works only with Reference Types (Objects).

✔ Primitive Data Types are NOT allowed.

Correct

        ArrayList<Integer>

Incorrect

        ArrayList<int>

Reason

        int is primitive.

        Integer is Wrapper Class.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Frequently Asked Interview Questions ========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. What are Generics?

2. Why were Generics introduced?

3. What problems existed before Generics?

4. What is Type Safety?

5. Why can't Generics use primitive data types?

6. Difference between

        ArrayList

and

        ArrayList<String>

7. Explain T, E, K and V.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import java.util.ArrayList;

public class p1_IntroToGenerics {

    public static void main(String[] args) {

        // =====================================================
        // Generic ArrayList of String
        // =====================================================

        ArrayList<String> names = new ArrayList<>();

        names.add("Yash");
        names.add("Rahul");
        names.add("Aman");

        System.out.println("String List : " + names);

        // =====================================================
        // Generic ArrayList of Integer
        // =====================================================

        ArrayList<Integer> marks = new ArrayList<>();

        marks.add(95);
        marks.add(88);
        marks.add(76);

        System.out.println("Integer List : " + marks);

        // =====================================================
        // Retrieving Data
        // =====================================================

        String student = names.get(0);

        Integer score = marks.get(0);

        System.out.println("\nFirst Student : " + student);

        System.out.println("First Score   : " + score);

        // =====================================================
        // Compile-Time Type Safety
        // =====================================================

        // names.add(100);
        // Compilation Error

        // marks.add("Java");
        // Compilation Error

        System.out.println("\nGenerics provide Compile-Time Type Safety.");
    }
} 