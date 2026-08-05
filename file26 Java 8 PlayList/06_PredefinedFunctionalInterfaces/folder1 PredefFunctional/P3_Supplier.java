/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                                SUPPLIER
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

In the previous file we studied Consumer.
            ''' Consumer '''

Input  : YES
Return : NO

Question: What if we don't want to provide any input, but we want some value in return?

Example

• Current Date
• Random Number
• OTP
• Today's Temperature

In all these cases,

Input
    => Nothing

Return
    => Some Value

Java already provides a Functional Interface for this purpose.

    ''' Supplier<T> '''




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
What is Supplier?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Supplier<T> is a predefined Functional Interface present inside

        java.util.function

It does NOT accept any input.
It simply supplies (returns) a value.



Syntax
    Supplier<DataType> variableName;


Abstract Method
                    T get();



Real-Life Example

=> Imagine a Water Cooler.
    You don't give it any input.


You simply press the button.
        ↓
It supplies water.

Supplier works in the same way.

Call
        get()
          ↓
    Receive a value.




When should we use Supplier?

✔ Generate OTP
✔ Random Number
✔ Current Date & Time
✔ Default Values
✔ Object Creation

Whenever our task is
    "Return some value without taking any input."




--------------------------------------------------------------------------------
Program
================================================================================
*/

import java.util.Random;
import java.util.function.Supplier;

public class P3_Supplier
{
    public static void main(String[] args)
    {

        Supplier<String> message = () -> "Welcome to Java 8";    // returns a string 
        System.out.println(message.get());




        Random random = new Random();

        Supplier<Integer> randomNumber = () -> random.nextInt(100);

        System.out.println(randomNumber.get());
        System.out.println(randomNumber.get());
        System.out.println(randomNumber.get());


    }
}

