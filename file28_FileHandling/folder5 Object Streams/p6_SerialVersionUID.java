/*
╔=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=╗
║                          SerialVersionUID                                   ║
╚═════════════════════════════════════════════════════════════════════════════╝


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══===
 WHAT PROBLEM ARE WE SOLVING?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

So far we know:

    Serialization
            ↓
        Java Object → .dat file


    Deserialization
            ↓
        .dat file → Java Object


Now imagine this situation:

    STEP 1
    ──────

    We have a Student class:

        class Student implements Serializable
        {
            String name;
            int age;
        }

    We create an object:

        Student s = new Student("Yash", 23);


    We serialize it:

        oos.writeObject(s);


    The object's serialized information is now stored inside:

        student.dat



    STEP 2
    ──────

    Later, we MODIFY the Student class.

    For example:

        class Student implements Serializable
        {
            String name;
            int age;
            double marks;
        }


    Now the class structure has changed.


    STEP 3
    ──────

    We try to read the OLD student.dat file using the NEW Student class.

    This creates an important question:
        "How does Java know whether the class used to read the object is compatible with the
         class that originally created the object?"


    This is the problem solved by:

                    serialVersionUID



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHAT IS serialVersionUID?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

`serialVersionUID` is a unique version identifier associated with a Serializable class.

Think of it as:
        "Which version of this class is this?"


For example:

        class Student implements Serializable
        {
            private static final long serialVersionUID = 1L;

            String name;
            int age;
        }


Here:

        1L  ---> is the version number of this Serializable class.


It allows Java to compare:

        Class version used during serialization

                        VS

        Class version used during deserialization



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHY DOES JAVA NEED A VERSION?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

A serialized file may survive much longer than the Java program that created it.

For example:

    Monday

        Student class
        ┌───────────────────────┐
        │ name                  │
        │ age                   │
        └───────────────────────┘
                    │
                    │ serialize
                    ▼
              student.dat


    Friday

        Student class is changed

        ┌───────────────────────┐
        │ name                  │
        │ age                   │
        │ marks                 │
        └───────────────────────┘


    Then:

        NEW Student class
                +
        OLD student.dat


Java needs to determine:

        "Are these two class versions compatible?"



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHERE IS serialVersionUID STORED?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

When an object is serialized, Java stores information about its class along with the 
serialized object data.


Conceptually:


        Student Object
              │
              │ writeObject()
              ▼
        ┌─────────────────────────────┐
        │ Serialized Data             │
        │                             │
        │ Class information           │
        │ serialVersionUID            │
        │ Object field values         │
        └─────────────────────────────┘
                     │
                     ▼
                student.dat


Later:


        student.dat
             │
             │ readObject()
             ▼
        Current Student class
             │
             │ compare version
             ▼
        Compatible?
             │
          ┌──┴──┐
         YES    NO
          │      │
          ▼      ▼
       Restore  Exception


The important comparison is:

        stored serialVersionUID  ==  current class serialVersionUID



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══== 
 WHAT HAPPENS IF WE DO NOT WRITE serialVersionUID?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

This is an important point.

We are NOT forced to manually write:

        private static final long serialVersionUID = 1L;

If we don't provide one, Java can generate a serialVersionUID automatically from the class structure.


Conceptually:


        Student class
             │
             │ Java calculates
             ▼
        generated version ID


The problem is that if the class structure changes, the automatically generated ID may also change.


For example:


        Version 1

        Student
        ┌───────────────┐
        │ name          │
        │ age           │
        └───────────────┘
                │
                ▼
        generated ID = X


        Version 2

        Student
        ┌───────────────┐
        │ name          │
        │ age           │
        │ marks         │
        └───────────────┘
                │
                ▼
        generated ID = Y


Now:
        X != Y


Java may reject the old serialized object during deserialization.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 InvalidClassException
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

If Java detects that the serialized class version does not match the current class version, an exception
can occur:

        java.io.InvalidClassException


The basic situation is:


        OLD CLASS
            │
            │ serialize
            ▼
        student.dat   
            │
            ▼
        NEW CLASS
            │
            │ version mismatch
            ▼
        InvalidClassException



The message may contain something similar to:

        local class incompatible:
        stream classdesc serialVersionUID = 1,
        local class serialVersionUID = 2


The important information is:

        stream version
              ≠
        local/current version



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 HOW DOES EXPLICIT serialVersionUID HELP?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Instead of allowing Java to automatically generate the version ID, we can explicitly define it.


Example:
        private static final long serialVersionUID = 1L;

Now the class has an explicitly controlled version:

        Student
             │
             ▼
        serialVersionUID = 1L



Suppose we make a compatible change:


        Version 1

        String name;           // already having serialVersionUID = 1L
        int age;


        Version 2

        String name;
        int age;                // intentionally keep serialVersionUID = 1L
        double marks;


We can intentionally keep:
        serialVersionUID = 1L


This tells Java:
        "I consider this class version compatible with the previously serialized version."


If we make an incompatible change, we can change it:

        serialVersionUID = 2L;


Now Java understands:

        Version 1 data
              ≠
        Version 2 class


This is why manually declaring serialVersionUID gives us control over serialization compatibility.





═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 PRACTICAL EXAMPLE
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

We can define:

        class Student implements Serializable
        {
            private static final long serialVersionUID = 1L;

            String name;
            int age;
        }


Then serialize:

        Student s = new Student("Yash", 23);

        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("student.dat"));
        oos.writeObject(s);


Later:


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"));
        Student restored = (Student) ois.readObject();


Both sides use:
        serialVersionUID = 1L


Therefore Java sees:


        Stored version       Current version
             1L                    1L
              │                     │
              └──────────┬──────────┘
                         │
                         ▼
                      MATCH



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
                         COMPLETE PRACTICAL PROGRAM
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==


*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Student implements Serializable
{
    private static final long serialVersionUID = 1L;

    String name;
    int age;
//     float marks = 78;   // uncomment incase of changing version of the class

    Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }


    void display()
    {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        // System.out.println("Marks  : " + marks);
    }
}


public class p6_SerialVersionUID
{
    public static void main(String[] args)
    {
        try
        {
             // STEP 1 — Create object of serialized class 
            Student original = new Student("Yash", 23);


            // STEP 2 — Serialize
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"));
            oos.writeObject(original);

            oos.close();


            // STEP 3 — Deserialize
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"));
            Student restored = (Student) ois.readObject();

            ois.close();


            // STEP 4 — Display restored object
            System.out.println("Restored Student:");
            restored.display();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

