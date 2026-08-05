/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                            LAMBDA PROGRAMS
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Topics Covered

1. No Parameter
2. One Parameter
3. Multiple Parameters
4. Return Value
5. Multiple Statements
6. Runnable
7. Comparator
8. Collections.sort()
9. TreeSet

================================================================================
*/

import java.util.*;




/*=========================================================================
                Functional Interfaces
=========================================================================*/

@FunctionalInterface
interface Greeting
{
    void sayHello();                     // abstract method -> no parameter
}


@FunctionalInterface
interface Message
{
    void print(String name);                     // abstract method -> one parameter
}

@FunctionalInterface
interface Addition
{
    void sum(int a,int b);                     // abstract method -> multiple parameter
}

@FunctionalInterface
interface Multiplication
{
    int multiply(int a,int b);                     // abstract method -> retrun a value
}

@FunctionalInterface
interface Square
{
    int findSquare(int number);
}


public class p3_LambdaPrograms
{

    public static void main(String[] args)
    {

        // Program 1 : No Parameter
        Greeting g = () -> System.out.println("Hello Everyone");
        g.sayHello();


        // Program 2 : One Parameter
        Message m = name -> System.out.println("Hello " + name);
        m.print("Yash");


        // Program 3 : Multiple Parameters
        Addition add = (a,b) -> System.out.println("Sum = " + (a+b));
        add.sum(10,20);


        // Program 4 : Return Value
        Multiplication mul = (a,b) -> a * b;
        System.out.println("Multiplication = " + mul.multiply(10,5));


        // Program 5 : Multiple Statements
        Square sq = number ->
        {
            System.out.println("Finding Square...");
            return number * number;
        };

        System.out.println("Square = " + sq.findSquare(8));



        // Program 6 : Runnable Interface
        Runnable r = () -> System.out.println("Thread Running...");
        r.run();


        // Program 7 : Comparator
        Comparator<Integer> descending =
                (a,b) -> Integer.compare(b,a);

        List<Integer> list = Arrays.asList(40, 10, 60, 20, 30);

        Collections.sort(list, descending);
        System.out.println(list);



        // Program 8 : TreeSet
        TreeSet<Integer> set = new TreeSet<>((a,b) -> b.compareTo(a));

        set.add(10);
        set.add(50);
        set.add(20);
        set.add(40);
        set.add(30);

        System.out.println(set);

    }
}

