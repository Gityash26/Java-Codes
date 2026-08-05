/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Comparable Interface ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Before learning Comparator, we must first understand

                        '''  Comparable  '''

because it is the default mechanism used by Java to compare and sort objects.

TreeMap, TreeSet and many sorting algorithms internally depend upon Comparable whenever no custom Comparator 
is provided.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Why Comparable ? ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we create a TreeMap.

        TreeMap<Integer, String> map = new TreeMap<>();

Now we insert

        map.put(50, "A");
        map.put(20, "B");
        map.put(70, "C");
        map.put(40, "D");


Question: How does TreeMap know that (40) should be placed between (20) and (50) ?

Answer
->  TreeMap compares every key with the existing keys.


For comparison, it calls the method.

        ''' compareTo()  '''

Therefore, Comparable tells Java "How should two objects be compared?"



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Definition ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=> Comparable is an Interface present inside java.lang package.

=> It is used to define the  ''' Natural Ordering '''  of objects.

=> Natural Ordering means the default sorting order which Java already knows.



=======================================================
Example,
=======================================================

Integer: Ascending Order (1-> 2-> 3-> 4-> 5)

String: Alphabetical Order (Apple, Ball, Cat, Dog)

Character: Ascending ASCII / Unicode Order (A-> B-> C->D)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Syntax ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public interface Comparable<T>
{

    int compareTo(T obj);

}

Where 'T' represents the type of object being compared.



Example

class Student implements Comparable<Student>
{
    public int compareTo(Student s)
    {

    }
}



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== compareTo() Method ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Method Signature

        int compareTo(T obj) 

Purpose is to Compares the Current Object with Specified Object.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Return Values =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

compareTo() always returns an integer.


Case 1: 
        Current Object < Specified Object
        Returns (-ve Number)

Example, 

        20.compareTo(40)
        returns (-20) 

Meaning 
        20 comes before 40



---------------------------------------------------------


Case 2:
        Current Object == Specified Object

        Returns 0

Example, 

        20.compareTo(20)
        returns 0

---------------------------------------------------------


Case 3: 
        Current Object > Specified Object
        Returns (+ve Number)

Example
        40.compareTo(20)
        returns 20

Meaning
        40 comes after 20



Remember

        Negative -> (Go Left)

        Positive -> (Go Right)

        Zero -> (Already Exists)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== TreeMap Internal Working ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose

TreeMap<Integer,String>

Insert  -> (50)

        50



Insert  -> (30)

TreeMap asks,  30.compareTo(50)
                returns (Negative)

↓
=====================
Go Left
=====================


        50
       /
     30



---------------------------------------------------------
Insert -> (70)

TreeMap asks, 70.compareTo(50)
              ====> Positive

↓
=====================
Go Right
=====================

        50
       /  \
     30    70



---------------------------------------------------------
Insert -> (40)


TreeMap asks, 40.compareTo(50)
               ===> Negative

↓
=====================
Go Left
=====================


             50
            /
50--->     30



Again, TreeMap asks 40.compareTo(30)
                    ===> Positive

↓
=====================
Go Right
=====================
↓


        50
       /
     30
       \
        40 (inserted)



Observe carefully, TreeMap never calculates bucket numbers.

TreeMap never uses hashing.

Instead, it repeatedly asks compareTo() until it finds the correct position.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== HashMap vs TreeMap =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap
=====================================================
Question: Where should I store this key?
=====================================================

Answer:  hashCode() -> Bucket Number -> Store

-----------------------------------------------------


TreeMap
=====================================================
Question
=====================================================

Should I go Left or Right ?

↓
compareTo()

↓
Left or Right

↓
Insert Node



This is the biggest difference between HashMap and TreeMap.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== Classes implementing Comparable ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Java already provides Comparable implementation for many classes.

Integer
String
Character
Double
Float
Long
Short
Byte
Boolean
BigInteger
BigDecimal
LocalDate
LocalDateTime
File
Enum


Therefore,

objects of these classes can directly be used inside TreeMap.


Example

TreeMap<Integer,String>     ✓ Allowed

TreeMap<String,Integer>     ✓ Allowed

TreeMap<Character,String>   ✓ Allowed


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Why Student cannot be compared ? =======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose

class Student
{

    int roll;
    String name;
}

Now

TreeMap<Student,String> map = new TreeMap<>();


Question: How should Java compare Student Objects?
By Roll Number ?
By Name ?
By Age ?
By CGPA ?


Java has NO IDEA.

Hence, TreeMap throws

        ''' ClassCastException '''

because Student does NOT implement Comparable.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================ Implementing Comparable ===============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Now let us teach Java ===> HOW Student objects should be compared.


class Student implements Comparable<Student>
{
    int rollNo;
    String name;
    double marks;

    @Override
    public int compareTo(Student s)
    {

    }

}


Notice, Comparable<Student> 
        means "This class knows how to compare Student objects with another Student object."



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= compareTo() by Roll Number ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class Student implements Comparable<Student>
{
    int rollNo;

    @Override
    public int compareTo(Student s)
    {
        return this.rollNo - s.rollNo;
    }
}


Suppose, 
-> Student A roll = 101
-> Student B roll = 105

compareTo()
101 - 105 = -4

(Negative)-> Student A comes first.



------------------------------------------------------
Student A
    roll = 105

Student B
    roll = 101


compareTo() 
    105 - 101 = 4


(Positive)--> Student B comes first.


------------------------------------------------------
Student A
    roll = 101


Student B
    roll = 101


compareTo()
    101 - 101 = 0

Both objects are considered equal according to TreeMap.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=================== Visualizing TreeMap ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Insert 
    Student (Roll = 105)

Tree

        105


---------------------- ----------------------------

Insert
    Student (Roll = 101)


TreeMap asks, 101.compareTo(105)
            =====>  Negative


==================
Go Left
==================



       105
      /
    101



--------------------------------------------------


Insert
    Student (Roll = 110)


TreeMap asks, 110.compareTo(105)
            ====> Positive


==================
Go Right 
==================
      
       105 <----- 110 
      /   \
    101   110



Every insertion follows compareTo() until the correct position is found.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= compareTo() by Name ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Instead of Roll Number we may compare Names.


@Override
public int compareTo(Student s)
{
    return this.name.compareTo(s.name);
}


Suppose (Rahul , Amit)


Rahul.compareTo("Amit")
            =====> Positive (Amit comes first)


Output
        (Amit , Rahul)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== compareTo() by Marks ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

@Override
public int compareTo(Student s)
{
    if(this.marks > s.marks)
        return 1;

    if(this.marks < s.marks)
        return -1;

    return 0;
}


or

return Double.compare(this.marks,s.marks);

(Double.compare() is safer than subtraction.)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Ascending & Descending =================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Ascending
        return this.rollNo - s.rollNo;



Output

101, 102, 103, 104

------------------------------------------------------


Descending
        return s.rollNo - this.rollNo;



Output
        (104, 103, 102, 101)


Simply reverse the comparison.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== compareTo() vs equals() ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Many beginners think compareTo() and equals() are the same.

   ... They are NOT ...


equals() 
        Checks whether two objects are equal.


compareTo()
        Decides which object should come before or after.


Example

Student A -> Roll = 101
Student B -> Roll = 101


equals()
        true


compareTo()
            0


------------------------------------------------------


Student A -> Roll = 101
Student B -> Roll = 105


equals()
            false


compareTo()
            Negative



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Common Mistakes =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Mistake 1

Forgetting implements Comparable<Student>
                ====> ClassCastException



------------------------------------------------------


Mistake 2

        Wrong compareTo()
        Always returning 0


All objects become equal.
TreeMap stores only one entry.



------------------------------------------------------

Mistake 3
        Returning random values compareTo() must always produce consistent results.



------------------------------------------------------


Mistake 4
        Comparing incompatible fields.


Example
    Roll Number with Name Never do this.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Interview Questions ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Q1. Why does TreeMap require Comparable?
Answer
    Because TreeMap needs to compare keys to maintain sorted order.

------------------------------------------------------


Q2. Can TreeMap store Student objects?
Answer
        Yes, only if Student implements Comparable or a Comparator is provided.

------------------------------------------------------


Q3. Can compareTo() return 100 or -500 ?

        Yes. Only the sign matters.
Negative

Zero

Positive



------------------------------------------------------


Q4. Which method does TreeMap call internally?

compareTo()

or

Comparator.compare()



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Best Practices ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

✓ Always override compareTo() carefully.

✓ Keep compareTo() consistent.

✓ Use Integer.compare() instead of subtraction for integer comparison.


Example

    return Integer.compare(this.rollNo, s.rollNo);
    This avoids integer overflow.

✓ Use Double.compare() for decimal values.

✓ Never modify the fields used inside compareTo() after inserting objects into TreeMap.

*/

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ====================== Complete Example ========================================
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

import java.util.TreeMap;

class Student implements Comparable<Student>
{

    int rollNo;
    String name;

    Student(int rollNo,String name)
    {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Student s)
    {
        return Integer.compare(this.rollNo,s.rollNo);
    }

    @Override
    public String toString()
    {
        return rollNo + " " + name;
    }

}


public class Demo
{

    public static void main(String[] args)
    {

        TreeMap<Student,String> map = new TreeMap<>();

        map.put(new Student(103,"Rahul"),"Java");

        map.put(new Student(101,"Amit"),"Python");

        map.put(new Student(105,"Neha"),"C++");

        System.out.println(map);

    }

}




