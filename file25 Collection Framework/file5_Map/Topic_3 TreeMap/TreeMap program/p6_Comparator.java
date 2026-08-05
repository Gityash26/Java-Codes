/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Comparator Interface =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

In the previous file, we learned Comparable that provides Natural Ordering for a class.

But sometimes, one class may require multiple sorting logics.


Example

Student

↓
Sort by Roll Number

↓
Sort by Name

↓
Sort by Marks

↓
Sort by Age

↓
Sort by CGPA


Can Comparable handle all these?  ====> (NO)

Because a class can have only ONE compareTo() method.

Therefore, Java introduced Comparator.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Why Comparator ? ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we have

class Student
{
    int rollNo;
    String name;
    double marks;
    int age;
}


Now different departments require different sorting.


--------------------------------------------------
University => (Sort by Roll Number)
--------------------------------------------------
HR Department => (Sort by Name)
--------------------------------------------------
Placement Cell => (Sort by CGPA)
--------------------------------------------------
Examination Branch => (Sort by Marks)
--------------------------------------------------


Question: Should we modify compareTo() every time?

        ''' NO ''''


-> One class can have only one Natural Ordering.
-> For every other sorting, Comparator is used.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Definition ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Comparator is an interface present inside java.util package.

It is used to define Custom Ordering of objects.

Unlike Comparable, Comparator is implemented outside the target class.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Syntax ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public interface Comparator<T>
{
    int compare(T o1, T o2);

}

Where T represents the object type.



Example

class NameComparator implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {

    }
}



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= compare() Method =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Method Signature

        int compare(T o1, T o2)

Purpose, 
        Compares 'Object1' with 'Object2'


Return Values
                Negative => First Object comes first

                Zero => Both are equal

                Positive => Second Object comes first



Exactly like, compareTo()



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Comparable vs Comparator ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Comparable

            => Inside the Class
            => compareTo()
            => Natural Ordering
            => Only ONE sorting logic

--------------------------------------------------------


Comparator
            => Outside the Class
            => compare()
            => Custom Ordering
            => Unlimited sorting logics



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Internal Working in TreeMap =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

TreeMap<Integer,String> map = new TreeMap<>();

TreeMap uses => compareTo()

--------------------------------------------------------


TreeMap<Integer,String> map = new TreeMap<>(comparator);

Now TreeMap ignores compareTo() Instead, it calls compare(o1,o2)

Every insertion depends upon Comparator.compare()


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Visual Representation ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Insert 40

Existing Tree


                50
               /
             30


TreeMap asks
            => Comparator.compare(40,50)
            => Negative


↓
=========================
Go Left
=========================



Again, Comparator.compare(40,30)
       => Positive


↓
========================
Go Right
========================



Final Tree


                50
               /
             30
               \
                40



Comparator decides where every node will be inserted.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Comparator by Roll Number ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class RollComparator implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {
        return Integer.compare(s1.rollNo, s2.rollNo);
    }
}



Sorting (101, 102, 103, 104)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Comparator by Name ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class NameComparator implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {
        return s1.name.compareTo(s2.name);
    }
}





~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Descending Order =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Ascending, 
            Integer.compare(s1.rollNo,s2.rollNo);

Descending
            Integer.compare(s2.rollNo,s1.rollNo);

Simply swap the parameters.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== Lambda Comparator =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Java 8 allows Comparator to be written using Lambda expression.


---------------------------------------------------------------------------------------------
Comparator<Student> cmp = (s1, s2) -> Integer.compare(s1.rollNo, s2.rollNo);
---------------------------------------------------------------------------------------------

or

---------------------------------------------------------------------------------------------
Comparator<Student> cmp = (s1, s2) -> s1.name.compareTo(s2.name);
---------------------------------------------------------------------------------------------


Less code Same functionality.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== TreeMap Constructor ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

TreeMap<Student,String> map = new TreeMap<>(new NameComparator());

TreeMap now sorts according to name.

-----------------------------------------------------


TreeMap<Student,String> map = new TreeMap<>(new RollComparator());

TreeMap now sorts according to Roll Number.

Only Comparator changed but Student class remains unchanged.

*/



// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ======================= Complete Example =======================================
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

import java.util.*;

class Student
{
    int rollNo;
    String name;

    Student(int rollNo,String name)
    {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return rollNo + " " + name;
    }
}



class NameComparator implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {
        return s1.name.compareTo(s2.name);

    }
}



public class Demo
{
    public static void main(String[] args)
    {

        TreeMap<Student,String> map = new TreeMap<>(new NameComparator());


        map.put(new Student(103,"Rahul"), "Java");

        map.put(new Student(101,"Amit"), "Python");

        map.put(new Student(105,"Neha"), "C++");

        System.out.println(map);

    }

}



// Output 
//             101 Amit
//             105 Neha
//             103 Rahul


// Notice

// Roll Numbers are NOT sorted.
// Names are sorted.

