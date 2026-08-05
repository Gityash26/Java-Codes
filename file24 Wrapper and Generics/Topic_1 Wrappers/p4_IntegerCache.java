/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Integer Cache ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Integer Cache is a memory optimization technique used by Java.

-> Instead of creating a new Integer object every time, Java reuses
   existing Integer objects for commonly used values.

-> This improves performance and reduces memory consumption.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Cached Integer Range ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

By default, Java caches Integer objects having values:

                    -128  to  127

Therefore,

        Integer.valueOf(100)

always returns the same cached object.

However,

        Integer.valueOf(200)

creates a new Integer object.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Why Integer Cache? ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose the following code is executed many times:

        Integer a = 10;

Without caching,

Every statement would create a new Integer object.

This would consume unnecessary memory.

Therefore,

Java stores frequently used Integer objects inside a cache and
reuses them whenever required.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== valueOf() and Cache =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Autoboxing internally uses

        Integer.valueOf()

instead of

        new Integer()

Example:

        Integer num = 100;

Compiler converts it into

        Integer num = Integer.valueOf(100);

Since 100 lies inside the cache range,

the same object is reused.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================| == vs equals() |======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Operator ==

-> Compares object references (memory addresses).

Method equals()

-> Compares actual values stored inside objects.

Example

        Integer a = 100;
        Integer b = 100;

        a == b

returns

        true

because both refer to the same cached object.

------------------------------------------------------------

Example

        Integer a = 200;
        Integer b = 200;

        a == b

returns

        false

because two different objects are created.

However,

        a.equals(b)

returns

        true

because both contain the same value.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Important Notes =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✔ Integer Cache range is

        -128 to 127

✔ Cache works only with Integer.valueOf() and Autoboxing.

✔ new Integer() always creates a new object.

✔ equals() compares values.

✔ == compares references.

✔ Always use equals() when comparing Wrapper objects.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== Frequently Asked Interview Questions ======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. What is Integer Cache?

2. What is the cache range?

3. Why was Integer Cache introduced?

4. Difference between == and equals()?

5. Why does

        Integer a = 100;
        Integer b = 100;

return true using == ?

6. Why does

        Integer a = 200;
        Integer b = 200;

return false using == ?

7. Does Integer Cache work with new Integer()?

Answer:

No.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

public class p4_IntegerCache {

    public static void main(String[] args) {

        // =====================================================
        // Example 1 : Cached Objects
        // =====================================================

        Integer num1 = 100;
        Integer num2 = 100;

        System.out.println("Example 1");

        System.out.println("num1 == num2      : " + (num1 == num2));

        System.out.println("num1.equals(num2) : " + num1.equals(num2));

        // =====================================================
        // Example 2 : Non-Cached Objects
        // =====================================================

        Integer num3 = 200;
        Integer num4 = 200;

        System.out.println("\nExample 2");

        System.out.println("num3 == num4      : " + (num3 == num4));

        System.out.println("num3.equals(num4) : " + num3.equals(num4));

        // =====================================================
        // Example 3 : valueOf()
        // =====================================================

        Integer num5 = Integer.valueOf(120);
        Integer num6 = Integer.valueOf(120);

        System.out.println("\nExample 3");

        System.out.println("num5 == num6      : " + (num5 == num6));

        System.out.println("num5.equals(num6) : " + num5.equals(num6));

        // =====================================================
        // Example 4 : new Integer()
        // =====================================================

        Integer num7 = new Integer(120);
        Integer num8 = new Integer(120);

        System.out.println("\nExample 4");

        System.out.println("num7 == num8      : " + (num7 == num8));

        System.out.println("num7.equals(num8) : " + num7.equals(num8));

        // =====================================================
        // Conclusion
        // =====================================================

        System.out.println("\nConclusion");

        System.out.println("== compares object references.");

        System.out.println("equals() compares object values.");

        System.out.println("Integer Cache works only for values between -128 and 127.");
    }
}