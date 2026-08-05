/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Equals() vs Reference Equality ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The goal of this file is to understand

        equals()

                    VS

            == (Reference Equality)

and how this affects

        HashMap

                    VS

        IdentityHashMap

*/


import java.util.HashMap;
import java.util.IdentityHashMap;

class Student
{
    int roll;

    Student(int roll)
    {
        this.roll = roll;
    }

    @Override
    public boolean equals(Object obj)
    {
        Student s = (Student)obj;    // Typecase
        return this.roll == s.roll;
    }

    @Override
    public int hashCode()
    {
        return Integer.hashCode(roll);
    }

    @Override
    public String toString()
    {
        return "Student-" + roll;
    }
}

public class p3_EqualsVsReferenceEquality
{
    public static void main(String[] args)
    {

        /*
        ============================================================
                        Program 1
        ============================================================

        Same Reference

        */

        Student s1 = new Student(101);

        Student s2 = s1;

        System.out.println("Program 1: ");

        System.out.println(s1 == s2);   // true -> same memory address reference

        System.out.println(s1.equals(s2));   // true -> same value




        /*
        ============================================================
                        Program 2
        ============================================================

        Different Objects
        Same Data

        */

        Student s3 = new Student(101);
        Student s4 = new Student(101);

        System.out.println("\nProgram 2: ");

        System.out.println(s3 == s4);   // false -> different memory references

        System.out.println(s3.equals(s4));   // true -> same value 


        /*
        ============================================================
                        Program 3
        ============================================================

        HashMap

        */

        HashMap<Student,String> hashMap = new HashMap<>();

        hashMap.put(s3,"Java");
        hashMap.put(s4,"Python");      // s3 and s4 having same key, hence instead of put another entry it will update its value 

        System.out.println("\nProgram 3: ");
        System.out.println(hashMap);


        /*

        /*
        ============================================================
                        Program 4
        ============================================================

        IdentityHashMap

        */

        IdentityHashMap<Student,String> identityMap = new IdentityHashMap<>();

        identityMap.put(s3,"Java");
        identityMap.put(s4,"Python");

        System.out.println("\nProgram 4");
        System.out.println(identityMap);



        /*
        ============================================================
                        Program 5
        ============================================================

        Same Object
        IdentityHashMap

        */

        Student s5 = new Student(500);
        Student s6 = s5;

        IdentityHashMap<Student,String> map = new IdentityHashMap<>();

        map.put(s5,"First");
        map.put(s6,"Second");     // updateion of value due to same memory reference ==

        System.out.println("\nProgram 5");

        System.out.println(map);


    }
}


