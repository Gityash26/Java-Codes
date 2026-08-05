/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                                PREDICATE
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

=> The Predicate is the predefined interface in  java.util.function that is used when we want to 
   check for some condition.

Examples

• Is the number even?
• Is age greater than or equal to 18?
• Is salary greater than 50000?
• Does the name start with 'A'?
• Is the String empty?

Notice something.
    Every question has only TWO possible answers.


TRUE or FALSE
--------------------------

Java already provides a Functional Interface for this purpose.

        ''' Predicate<T> ''''



=======================================================
=> It accepts ONE input
=> returns a boolean value.


Syntax
    Predicate<DataType> variableName;



Abstract Method

    boolean test(T t);




When should we use Predicate?

✔ Validation
✔ Filtering Data
✔ Checking Eligibility
✔ Searching
✔ Conditions

Whenever our task is "Check a condition and return true or false."




--------------------------------------------------------------------------------
Program
================================================================================
*/

import java.util.function.Predicate;

public class p4_Predicate
{
    public static void main(String[] args)
    {

        // ---------- check for even number --------------
        Predicate<Integer> isEven = number -> number % 2 == 0;

        System.out.println(isEven.test(10));
        System.out.println(isEven.test(15));



        // ---------- check for string length ius greater than 5 --------------
        Predicate<String> longName = name -> name.length() >= 5;

        System.out.println(longName.test("Rahul"));
        System.out.println(longName.test("Ram"));



    }
}

