/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Autoboxing & Unboxing ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Wrapper Classes allow primitive values to be treated as objects.

-> Before Java 5, programmers had to manually convert primitive values
   into Wrapper objects and vice versa.

-> From Java 5 onwards, Java introduced Autoboxing and Auto-Unboxing,
   making these conversions automatic.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Why is it Required? =================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Collections store only objects.

-> Generics work only with reference types.

-> Therefore, primitive values must be converted into Wrapper objects.

Example:

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);

Here,

        10 (primitive int)

is automatically converted into

        Integer.valueOf(10)

This automatic conversion is called Autoboxing.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Manual Boxing (Before Java 5) =========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Manual Boxing means converting a primitive value into a Wrapper object
explicitly.

Example:

        int number = 100;

        Integer obj = Integer.valueOf(number);

Earlier, programmers also used:

        Integer obj = new Integer(number);

Note:
-> The Integer constructor is deprecated.
-> Integer.valueOf() is preferred.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Manual Unboxing (Before Java 5) ========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Manual Unboxing means converting a Wrapper object into a primitive value.

Example:

        Integer obj = Integer.valueOf(200);

        int number = obj.intValue();

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Autoboxing ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Definition

-> Automatic conversion of a primitive value into its corresponding
   Wrapper object.

Example:

        int number = 10;

        Integer obj = number;

Compiler converts it into:

        Integer obj = Integer.valueOf(number);

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Auto-Unboxing ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Definition

-> Automatic conversion of a Wrapper object into its corresponding
   primitive value.

Example:

        Integer obj = 500;

        int number = obj;

Compiler converts it into:

        int number = obj.intValue();

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Autoboxing Flow =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Primitive Value

        int number = 50;

                │
                ▼

        Integer.valueOf(number)

                │
                ▼

        Integer Object

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Unboxing Flow =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Integer Object

        Integer obj = 100;

                │
                ▼

        obj.intValue()

                │
                ▼

        Primitive int

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Advantages ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Reduces unnecessary code.

2. Improves readability.

3. Makes Collection Framework easier to use.

4. Makes Generics easy to use.

5. Automatic conversion by compiler.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Disadvantages =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Small performance overhead.

2. Additional object creation.

3. Excessive boxing/unboxing inside loops may affect performance.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Frequently Asked Questions =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. What is Autoboxing?

2. What is Auto-Unboxing?

3. When were they introduced?

4. Difference between valueOf() and Autoboxing?

5. Difference between intValue() and Unboxing?

6. Why are they important in Collections?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import java.util.ArrayList;

public class p3_AutoboxingAndUnboxing {

    public static void main(String[] args) {

        // =====================================================
        // Manual Boxing (Before Java 5)
        // =====================================================

        int primitiveNumber = 100;

        Integer wrapperObject = Integer.valueOf(primitiveNumber);

        System.out.println("Manual Boxing");
        System.out.println("Primitive : " + primitiveNumber);
        System.out.println("Wrapper Object : " + wrapperObject);

        // =====================================================
        // Manual Unboxing (Before Java 5)
        // =====================================================

        Integer obj = Integer.valueOf(250);

        int number = obj.intValue();

        System.out.println("\nManual Unboxing");
        System.out.println("Wrapper Object : " + obj);
        System.out.println("Primitive : " + number);

        // =====================================================
        // Autoboxing
        // =====================================================

        int marks = 95;

        Integer studentMarks = marks;

        System.out.println("\nAutoboxing");
        System.out.println("Primitive : " + marks);
        System.out.println("Wrapper Object : " + studentMarks);

        // =====================================================
        // Auto-Unboxing
        // =====================================================

        Integer salary = 50000;

        int employeeSalary = salary;

        System.out.println("\nAuto-Unboxing");
        System.out.println("Wrapper Object : " + salary);
        System.out.println("Primitive : " + employeeSalary);

        // =====================================================
        // Collections Example
        // =====================================================

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);   // Autoboxing
        list.add(20);
        list.add(30);

        System.out.println("\nArrayList : " + list);

        int firstElement = list.get(0);   // Auto-Unboxing

        System.out.println("First Element : " + firstElement);
    }
}