
/*
╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                   Today's Topic -  Serializable                              ║
╚══════════════════════════════════════════════════════════════════════════════╝

Suppose when we create:

        class Student
        {
            String name;
            int age;
        }

and then:
        Student s = new Student("Yash", 23);

Now we try:
        oos.writeObject(s);


Java does NOT automatically assume that every Java object is allowed to be serialized.


So Java needs a way for a class to declare:
        "Objects of this class are allowed to be serialized."

That is the purpose of:
        Serializable



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHAT IS Serializable?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

`Serializable` is an interface provided by java.io package.

Any class that implements it like this:

        class Student implements Serializable
        {
            ...
        }

tells Java:

        "Objects of this class can participate
         in Java's default serialization mechanism."


IMPORTANT:
    `Serializable` does NOT contain methods that we normally have
     to implement.

It is a MARKER INTERFACE.


Note: If class don't implements Serializable interface then ObjectOutputStream
write() mehod throws 

        'NotSerializableException'


The important idea is:

        ObjectOutputStream
                │
                │ checks 
                ▼
Does class implement Serializable?
        ╱                ╲
      YES                NO
        │                 │
        ▼                 ▼
    Serialize       NotSerializableException




    Serializable
        → tells Java WHAT is allowed

    ObjectOutputStream
        → performs the ACTUAL serialization



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHAT EXACTLY GETS SERIALIZED?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

This is an important concept.

Suppose:

        class Student implements Serializable
        {
            String name;
            int age;
            double marks;
        }

and:

        Student s = new Student("Yash", 23, 85.5);

When we serialize the object `s`, Java stores the object's SERIALIZABLE STATE.


Conceptually:

        Student Object
        ┌────────────────────────┐
        │ name  → "Yash"         │
        │ age   → 23             │
        │ marks → 85.5           │
        └───────────┬────────────┘
                    │
                    │ Serialization
                    ▼
        Serialized representation
                    │
                    ▼
                 File


The goal is NOT to store the exact memory (RAM) address of the object.
Java stores information necessary to reconstruct the object's state later.



 DOES THE OBJECT ITSELF MOVE INTO THE FILE?
==================================================

NO. This distinction is very important.

Suppose:
        Student s


The object remains in memory.


        RAM
        ┌───────────────────────────┐
        │ Student object            │
        │                           │
        │ name = "Yash"             │
        │ age  = 23                 │
        └─────────────┬─────────────┘
                      │
                      │ serialize
        Disk          ▼
        ┌───────────────────────────┐
        │ student.dat               │
        │ serialized representation │
        └───────────────────────────┘


Serialization creates a REPRESENTATION of the object's state that can be stored.
The original object is not physically moved from RAM to disk.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
Important: Serialization OF Object reference
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Objects can contain references to other objects.

Example:

        class Address implements Serializable
        {
            String city;
        }

        class Student implements Serializable
        {
            String name;
            Address address;
        }

Here:

        Student
           │
           └──────► Address


If the referenced object is also serializable,
Java can serialize that object as part of the object graph.


Conceptually:

        Student
        ├── name
        │
        └── address
              └── city


This collection of connected objects is commonly called the OBJECT GRAPH.
We will study this more carefully later.


-----------------------------------------------------------
Serializable DOES NOT MEAN "SAVE EVERYTHING"
-----------------------------------------------------------
Later we will learn that Java has rules about what actually participates in serialization.

For example:
        transient fields
        static fields
        referenced objects

have special behavior.


We will NOT mix those concepts into this file.

For now, the foundation is:

        implements Serializable
                ↓
        class becomes eligible
                ↓
        ObjectOutputStream can serialize
        its serializable state



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 PRACTICAL PROGRAM
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
*/

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Student implements Serializable
{
    String name;
    int age;
    double marks;


    Student(String name, int age, double marks)
    {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }


    void display()
    {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Marks : " + marks);
    }
}


public class p3_Serializable
{
    public static void main(String[] args)
    {
        try
        {
            // Step 1: Create object
            Student s = new Student("Yash", 23, 85.5);


            // Step 2: Create connection to file
            FileOutputStream fos = new FileOutputStream("student.dat");


            // Step 3: Add ObjectOutputStream layer
            ObjectOutputStream oos = new ObjectOutputStream(fos);


            // Step 3: Serialize object
            oos.writeObject(s);


            // Step 5 — Close stream
            oos.close();


            System.out.println("Object serialized successfully.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
