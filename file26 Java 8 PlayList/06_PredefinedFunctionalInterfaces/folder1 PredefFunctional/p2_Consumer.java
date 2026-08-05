/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                                CONSUMER
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Till now, whenever we wanted to use a Lambda Expression, we created our own 
Functional Interface.

Example

@FunctionalInterface
interface Greeting
{
    void greet(String name);
}

Greeting g = (name) -> System.out.println(name);



------------------------------------------------------------------------------
Question If our only requirement is to accept one value and perform some operation on it,
Do we really need to create our own Functional Interface every time?

Answer NO.

Java 8 already provides one.
    Consumer<T>
------------------------------------------------------------------------------




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
What is Consumer?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Consumer<T> is a 'predefined Functional Interface' present inside

    java.util.function

It accepts ONE input, performs some operation on it,  and returns NOTHING.


Syntax

    Consumer<DataType> variableName;


Abstract Method

    void accept(T t);
            ↓
    T (Type of Input)


accept()
        Method used to consume the input.

Return Type
    void



Real-Life Example

Think of a Printer.

Document
    ↓
Printer
    ↓
Printed

The printer accepts the document, prints it, and does not return anything.
Consumer works in the same way.



When should we use Consumer?

✔ Printing Data
✔ Saving Data
✔ Sending Email
✔ Writing into File
✔ Logging

Whenever our task is
    "Accept some data and perform an action."




--------------------------------------------------------------------------------
Program
================================================================================
*/

import java.util.function.Consumer;

public class p2_Consumer
{
    public static void main(String[] args)
    {
        
        // ------------ Consumper <String type> --------------
        Consumer<String> print = name -> System.out.println("Hello " + name);
        print.accept("Rahul");
        print.accept("Amit");
        print.accept("Neha");


        
        // ------------ Consumper <Integer type> --------------
        Consumer<Integer> square = number -> System.out.println(number * number);
        square.accept(5);
        square.accept(10);
        square.accept(20);
    }
}

