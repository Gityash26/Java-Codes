/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Bounded Types ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> By default, Generics can accept any Reference Type.

Example

        Box<String>

        Box<Integer>

        Box<Double>

        Box<Character>

Sometimes, we want to restrict the Generic Type so that only
certain data types are allowed.

This restriction is called Bounded Type.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Why Bounded Types? ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we create a method to calculate the square of a number.

The method should accept only numeric data types.

Allowed

        Integer

        Double

        Float

        Long

Not Allowed

        String

        Character

        Boolean

Bounded Types solve this problem.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Syntax ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class ClassName<T extends ParentClass>
{

}

Example

class Box<T extends Number>
{

}

Here,

T can be

        Integer

        Double

        Float

        Long

But cannot be

        String

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== extends Keyword ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The extends keyword is used to define an upper bound.

Syntax

        <T extends Number>

means

T must be

        Number

or

any subclass of Number.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Number Class =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The Number class is the parent class of

        Byte

        Short

        Integer

        Long

        Float

        Double

Therefore,

all these Wrapper Classes satisfy

        <T extends Number>

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Advantages ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Restricts unwanted data types.

2. Improves Type Safety.

3. Prevents invalid operations.

4. Detects errors during compilation.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Important Notes ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✔ extends defines an Upper Bound.

✔ Only subclasses of the specified class are allowed.

✔ String cannot satisfy

        <T extends Number>

✔ Primitive types are not allowed.

Correct

        Box<Integer>

Incorrect

        Box<int>

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=================== Frequently Asked Interview Questions =======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. What is a Bounded Type?

2. Why are Bounded Types required?

3. What does

        <T extends Number>

mean?

4. Can String satisfy

        <T extends Number> ?

Answer

No.

5. Difference between Generic Type and Bounded Type?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

class Calculator<T extends Number>
{
    private T number;

    public Calculator(T number)
    {
        this.number = number;
    }

    public T getNumber()
    {
        return number;
    }

    public double square()
    {
        return number.doubleValue() * number.doubleValue();
    }

    public double cube()
    {
        return number.doubleValue()
                * number.doubleValue()
                * number.doubleValue();
    }
}

public class p4_BoundedType
{
    public static void main(String[] args)
    {
        // =====================================================
        // Integer Example
        // =====================================================

        Calculator<Integer> integerObject = new Calculator<>(10);

        System.out.println("Integer Value : " + integerObject.getNumber());

        System.out.println("Square : " + integerObject.square());

        System.out.println("Cube   : " + integerObject.cube());

        // =====================================================
        // Double Example
        // =====================================================

        Calculator<Double> doubleObject = new Calculator<>(5.5);

        System.out.println("\nDouble Value : " + doubleObject.getNumber());

        System.out.println("Square : " + doubleObject.square());

        System.out.println("Cube   : " + doubleObject.cube());

        // =====================================================
        // Float Example
        // =====================================================

        Calculator<Float> floatObject = new Calculator<>(4.0f);

        System.out.println("\nFloat Value : " + floatObject.getNumber());

        System.out.println("Square : " + floatObject.square());

        System.out.println("Cube   : " + floatObject.cube());

        // =====================================================
        // Invalid Example
        // =====================================================

        // Calculator<String> obj = new Calculator<>("Java");

        // Compilation Error
        // String is not a subclass of Number.
    }
}