/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                        BINARY OPERATOR
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Till now we have studied

    BiFunction<T,U,R>

Question: Can we use BiFunction to

Take two Integers
        ↓
Return one Integer ?

Example
10 + 20 -> 30

Yes.

BiFunction<Integer,Integer,Integer> can do this.

Question: If both Input Types and Return Type are SAME,

why write

BiFunction<Integer,Integer,Integer> again and again?

Java provides a shorter Functional Interface

    BinaryOperator<T>

It is a specialized version of BiFunction.





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
What is BinaryOperator?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

BinaryOperator<T>
↓

Accepts TWO inputs
↓

Returns ONE value

Both Input Types and Return Type must be the SAME.

It is present inside

        java.util.function





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Relationship with BiFunction
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

BiFunction<T,U,R>

↓

Input Types (T , U)
Return Type (R)

All three types may be different.

Example

BiFunction<Integer,String,Double>



------------------------------------------------------------

BinaryOperator<T>

↓

Input Types (T , T)
Return Type (T)

All types must be SAME.

Examples

BinaryOperator<Integer>
BinaryOperator<String>
BinaryOperator<Double>





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Syntax
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

BinaryOperator<Type> variableName;

Abstract Method

    apply(T,T)

Inherited from

    BiFunction<T,T,T>





--------------------------------------------------------------------------------
Program
================================================================================
*/

import java.util.function.BinaryOperator;

public class P2_BinaryOperator
{
    public static void main(String[] args)
    {

        // Program 1 : Add Two Numbers

        BinaryOperator<Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(10, 20));
        System.out.println(sum.apply(50, 30));



        System.out.println();


        // Program 2 : find greater number
        BinaryOperator<Integer> maximum = (a, b) -> (a > b) ? a : b;

        System.out.println(maximum.apply(40, 25));
        System.out.println(maximum.apply(18, 75));



        System.out.println();



        // Program 3 : Jon two strings
        BinaryOperator<String> join = (first, second) -> first + second;

        System.out.println(join.apply("Hello ", "Java"));
        System.out.println(join.apply("Good ", "Morning"));

    }
}

