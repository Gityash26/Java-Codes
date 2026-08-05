/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                BI FUNCTIONAL INTERFACES PROGRAMS
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

This file demonstrates all three Bi Functional Interfaces.

1. BiConsumer
2. BiPredicate
3. BiFunction


*/

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class p2_ProgramWithBi
{
    public static void main(String[] args)
    {

        /*
        ------------------------------------------------------------
        Program 1 : BiConsumer
        ------------------------------------------------------------
        Accepts TWO inputs.
        Returns NOTHING.

        Abstract Method
            accept(T,U)
        */

        BiConsumer<String, Integer> student = (name, marks) -> System.out.println(name + " : " + marks);

        student.accept("Rahul", 95);
        student.accept("Amit", 88);

        System.out.println();



        /*
        ------------------------------------------------------------
        Program 2 : BiPredicate
        ------------------------------------------------------------
        Accepts TWO inputs.
        Returns boolean.

        Abstract Method
            test(T,U)
        */

        BiPredicate<Integer, Integer> greater = (a, b) -> a > b;
        System.out.println(greater.test(20, 10));
        System.out.println(greater.test(5, 15));

        System.out.println();



        /*
        ------------------------------------------------------------
        Program 3 : BiFunction
        ------------------------------------------------------------
        Accepts TWO inputs.
        Returns one value.

        Abstract Method
            apply(T,U)
        */

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(10, 20));
        System.out.println(sum.apply(100, 50));

    }
}

