/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                        UNARY OPERATOR
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Till now we have studied the specific predefined functional Interface 

    Function<T,R>

Question: Can we use Function to

    Take one Integer
            ↓
    Return one Integer ?


Example

10
↓
20

Yes, ===> Function<Integer,Integer> can do this.


Question: If the Input Type and Return Type are SAME, why write

Function<Integer,Integer>    =====> again and again?

Java provides a shorter Functional Interface

    ''' UnaryOperator<T>   '''

It is a specialized version of Function.





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
What is UnaryOperator?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

UnaryOperator<T>
        ↓

Accepts ONE input
        ↓

Returns ONE value

The Input Type and Return Type must be the SAME.

It is present inside

        java.util.function





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Relationship with Function
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Function<T,R>
       ↓

Input Type (T)
Return Type (R)

Input and Return types may be different.

Example
    Function<String,Integer>


Input (String)
Return (Integer)



------------------------------------------------------------

UnaryOperator<T>

↓

Input Type (T)
Return Type (T)

Both MUST be same.

Examples

    UnaryOperator<Integer>
    UnaryOperator<String>
    UnaryOperator<Double>





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Syntax
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

UnaryOperator<Type> variableName;

Abstract Method

    apply(T)

Inherited from

    Function<T,T>





--------------------------------------------------------------------------------
Program
================================================================================
*/

import java.util.function.UnaryOperator;

public class P1_UnaryOperator
{
    public static void main(String[] args)
    {
        // Program 1 : double a number 
        UnaryOperator<Integer> doubleNumber = num -> num * 2;

        System.out.println(doubleNumber.apply(10));
        System.out.println(doubleNumber.apply(25));



        System.out.println();


        // Program 2: string to upper case 
        UnaryOperator<String> upper = str -> str.toUpperCase();

        System.out.println(upper.apply("java"));
        System.out.println(upper.apply("lambda"));

    }
}

