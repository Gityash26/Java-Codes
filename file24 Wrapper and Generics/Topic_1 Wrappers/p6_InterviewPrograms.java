/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Wrapper Class Interview Programs =========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> This file contains some commonly asked interview programs based on
   Wrapper Classes.

Topics Covered

1. String to int Conversion
2. int to String Conversion
3. Find Maximum & Minimum
4. Compare Two Numbers
5. Character Validation
6. Boolean Conversion
7. Autoboxing & Auto-Unboxing
8. Wrapper Classes with Collections

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import java.util.ArrayList;

public class p6_InterviewPrograms {

    // ==========================================================
    // Method used for Autoboxing & Auto-Unboxing demonstration
    // ==========================================================

    static void display(Integer number) {
        System.out.println("Received Number : " + number);
    }

    public static void main(String[] args) {

        // ==========================================================
        // Program 1 : String to int
        // ==========================================================

        System.out.println("========== Program 1 ==========");

        String str = "150";

        int number = Integer.parseInt(str);

        System.out.println("String : " + str);
        System.out.println("Primitive int : " + number);

        // ==========================================================
        // Program 2 : int to String
        // ==========================================================

        System.out.println("\n========== Program 2 ==========");

        int marks = 95;

        String converted = Integer.toString(marks);

        System.out.println("Primitive int : " + marks);
        System.out.println("String : " + converted);

        // ==========================================================
        // Program 3 : Maximum & Minimum
        // ==========================================================

        System.out.println("\n========== Program 3 ==========");

        int a = 80;
        int b = 45;

        System.out.println("Maximum : " + Integer.max(a, b));
        System.out.println("Minimum : " + Integer.min(a, b));

        // ==========================================================
        // Program 4 : Compare Two Numbers
        // ==========================================================

        System.out.println("\n========== Program 4 ==========");

        System.out.println("Compare(80,45) : " + Integer.compare(a, b));
        System.out.println("Compare(45,80) : " + Integer.compare(b, a));
        System.out.println("Compare(80,80) : " + Integer.compare(a, a));

        // ==========================================================
        // Program 5 : Character Methods
        // ==========================================================

        System.out.println("\n========== Program 5 ==========");

        char ch = 'A';

        System.out.println("isLetter()    : " + Character.isLetter(ch));
        System.out.println("isDigit()     : " + Character.isDigit(ch));
        System.out.println("isUpperCase() : " + Character.isUpperCase(ch));
        System.out.println("isLowerCase() : " + Character.isLowerCase(ch));

        // ==========================================================
        // Program 6 : Boolean Conversion
        // ==========================================================

        System.out.println("\n========== Program 6 ==========");

        boolean flag = Boolean.parseBoolean("true");

        System.out.println("Boolean Value : " + flag);

        // ==========================================================
        // Program 7 : Autoboxing & Auto-Unboxing
        // ==========================================================

        System.out.println("\n========== Program 7 ==========");

        int primitive = 500;

        Integer wrapper = primitive;      // Autoboxing

        int primitiveAgain = wrapper;     // Auto-Unboxing

        System.out.println("Primitive : " + primitive);

        System.out.println("Wrapper : " + wrapper);

        System.out.println("Primitive Again : " + primitiveAgain);

        // ==========================================================
        // Program 8 : Wrapper with Collection Framework
        // ==========================================================

        System.out.println("\n========== Program 8 ==========");

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("ArrayList : " + list);

        // ==========================================================
        // Program 9 : Wrapper as Method Parameter
        // ==========================================================

        System.out.println("\n========== Program 9 ==========");

        display(999);

        // ==========================================================
        // Program 10 : Null Value Support
        // ==========================================================

        System.out.println("\n========== Program 10 ==========");

        Integer salary = null;

        System.out.println("Wrapper Object : " + salary);

        // int salary = null;
        // Not Allowed

        // ==========================================================
        // Final Message
        // ==========================================================

        System.out.println("\nWrapper Class Interview Programs Completed Successfully.");
    }
}