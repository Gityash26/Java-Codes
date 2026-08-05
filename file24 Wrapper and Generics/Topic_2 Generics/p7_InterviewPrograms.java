/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Generics Interview Programs ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> This file contains some commonly asked interview programs based on
   Java Generics.

Topics Covered

1. Generic Class
2. Generic Method
3. Generic Method with Return Type
4. Bounded Generic
5. Generic Interface
6. Wildcards
7. Generic Pair Class

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import java.util.ArrayList;
import java.util.List;

// ==========================================================
// Program 1 : Generic Class
// ==========================================================

class Box<T>
{
    private T value;

    public Box(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }
}

// ==========================================================
// Program 2 : Generic Interface
// ==========================================================

interface Printer<T>
{
    void print(T value);
}

class DataPrinter<T> implements Printer<T>
{
    @Override
    public void print(T value)
    {
        System.out.println("Printing : " + value);
    }
}

// ==========================================================
// Program 3 : Bounded Generic Class
// ==========================================================

class Calculator<T extends Number>
{
    private T number;

    public Calculator(T number)
    {
        this.number = number;
    }

    public double square()
    {
        return number.doubleValue() * number.doubleValue();
    }
}

public class p7_InterviewPrograms
{

    // ==========================================================
    // Generic Method
    // ==========================================================

    public static <T> void display(T value)
    {
        System.out.println("Value : " + value);
    }

    // ==========================================================
    // Generic Method with Return Type
    // ==========================================================

    public static <T> T getData(T value)
    {
        return value;
    }

    // ==========================================================
    // Unbounded Wildcard
    // ==========================================================

    public static void printList(List<?> list)
    {
        System.out.println(list);
    }

    // ==========================================================
    // Generic Pair Class
    // ==========================================================

    static class Pair<K, V>
    {
        private K key;
        private V value;

        public Pair(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public void display()
        {
            System.out.println("Key   : " + key);
            System.out.println("Value : " + value);
        }
    }

    public static void main(String[] args)
    {

        // ======================================================
        // Program 1 : Generic Class
        // ======================================================

        System.out.println("========== Program 1 ==========");

        Box<String> box = new Box<>("Java");

        System.out.println("Stored Value : " + box.getValue());

        // ======================================================
        // Program 2 : Generic Method
        // ======================================================

        System.out.println("\n========== Program 2 ==========");

        display(100);

        display("Generics");

        display(25.5);

        // ======================================================
        // Program 3 : Generic Return Method
        // ======================================================

        System.out.println("\n========== Program 3 ==========");

        Integer number = getData(500);

        String language = getData("Java");

        System.out.println("Returned Integer : " + number);

        System.out.println("Returned String  : " + language);

        // ======================================================
        // Program 4 : Bounded Generic
        // ======================================================

        System.out.println("\n========== Program 4 ==========");

        Calculator<Integer> calculator = new Calculator<>(12);

        System.out.println("Square : " + calculator.square());

        // ======================================================
        // Program 5 : Generic Interface
        // ======================================================

        System.out.println("\n========== Program 5 ==========");

        DataPrinter<String> printer = new DataPrinter<>();

        printer.print("Hello Java");

        // ======================================================
        // Program 6 : Wildcards
        // ======================================================

        System.out.println("\n========== Program 6 ==========");

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);

        list.add(20);

        list.add(30);

        printList(list);

        // ======================================================
        // Program 7 : Generic Pair Class
        // ======================================================

        System.out.println("\n========== Program 7 ==========");

        Pair<Integer, String> student = new Pair<>(101, "Yash");

        student.display();

        Pair<String, Double> product = new Pair<>("Laptop", 79999.99);

        product.display();

        // ======================================================
        // Final Message
        // ======================================================

        System.out.println("\nGenerics Interview Programs Completed Successfully.");
    }
}