/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================================= Wildcards ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Wildcards are represented by the question mark (?).

-> They are used in Generics when the exact type is unknown.

-> Wildcards provide flexibility while working with Generic Classes
   and Collections.

Syntax

        <?>

        <? extends ClassName>

        <? super ClassName>

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Why Wildcards? ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we have

        ArrayList<Integer>

and

        ArrayList<Double>

Both are different Generic Types.

If we want one method to accept both,

Wildcards are used.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Types of Wildcards =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Unbounded Wildcard

        <?>

2. Upper Bounded Wildcard

        <? extends ClassName>

3. Lower Bounded Wildcard

        <? super ClassName>

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Unbounded Wildcard ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Syntax

        <?>

Meaning

-> Accepts objects of any reference type.

Example

        List<?>

It can accept

        List<Integer>

        List<String>

        List<Double>

        List<Character>

Use Case

-> When the data type is not important.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Upper Bounded Wildcard ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Syntax

        <? extends Number>

Meaning

-> Accepts Number and all its subclasses.

Allowed

        Integer

        Double

        Float

        Long

Not Allowed

        String

Use Case

-> Mostly used for reading data.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Lower Bounded Wildcard ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Syntax

        <? super Integer>

Meaning

-> Accepts Integer or any superclass of Integer.

Allowed

        Integer

        Number

        Object

Use Case

-> Mostly used for inserting data.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ PECS Rule =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

PECS stands for

        Producer Extends
        Consumer Super

Producer

-> If a collection only provides data (Read),

use

        <? extends T>

Consumer

-> If a collection accepts data (Write),

use

        <? super T>

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Important Notes ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✔ <?> means Unknown Type.

✔ <? extends T> provides an Upper Bound.

✔ <? super T> provides a Lower Bound.

✔ Wildcards improve flexibility.

✔ Frequently used in Collection Framework APIs.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Frequently Asked Interview Questions =====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. What is a Wildcard?

2. Difference between

        <T>

and

        <?>

3. Difference between

        <? extends Number>

and

        <? super Integer>

4. Explain the PECS Rule.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import java.util.ArrayList;
import java.util.List;

public class p5_Wildcards
{

    // ==========================================================
    // Unbounded Wildcard
    // ==========================================================

    static void printList(List<?> list)
    {
        System.out.println("List : " + list);
    }

    // ==========================================================
    // Upper Bounded Wildcard
    // ==========================================================

    static void printNumbers(List<? extends Number> list)        // Number -> Integer, Float, Double, Long allowed
    {
        System.out.println("Numbers : " + list);
    }

    // ==========================================================
    // Lower Bounded Wildcard
    // ==========================================================

    static void addNumbers(List<? super Integer> list)     // Integer => Number => Object allowed
    {
        list.add(100);
        list.add(200);

        System.out.println("After Adding : " + list);
    }

    public static void main(String[] args)
    {

        // ======================================================
        // Integer List
        // ======================================================

        ArrayList<Integer> integerList = new ArrayList<>();

        integerList.add(10);
        integerList.add(20);
        integerList.add(30);

        // ======================================================
        // Double List
        // ======================================================

        ArrayList<Double> doubleList = new ArrayList<>();

        doubleList.add(11.5);
        doubleList.add(22.5);
        doubleList.add(33.5);

        // ======================================================
        // String List
        // ======================================================

        ArrayList<String> stringList = new ArrayList<>();

        stringList.add("Java");
        stringList.add("Python");
        stringList.add("C++");

        // ======================================================
        // Unbounded Wildcard
        // ======================================================

        System.out.println("=========== Unbounded Wildcard ===========");

        printList(integerList);

        printList(doubleList);

        printList(stringList);

        // ======================================================
        // Upper Bounded Wildcard
        // ======================================================

        System.out.println("\n=========== Upper Bounded Wildcard ===========");

        printNumbers(integerList);

        printNumbers(doubleList);

        // printNumbers(stringList);
        // Compilation Error

        // ======================================================
        // Lower Bounded Wildcard
        // ======================================================

        System.out.println("\n=========== Lower Bounded Wildcard ===========");

        ArrayList<Number> numberList = new ArrayList<>();

        addNumbers(numberList);

    }
}