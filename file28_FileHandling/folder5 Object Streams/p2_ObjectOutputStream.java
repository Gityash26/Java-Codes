
/*

                     Object streams
                              │          
                    ┌─────────┴─────────┐
                    ▼                   ▼
    ->   ObjectInputStream          ObjectOutputStream         
     

╔══════════════════════════════════════════════════════════════════════════════╗
║               1.   ObjectOutputStream                                        ║
╚=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═╝

The ObjectOutputStream is a class in java.io package.

Its purpose is to write Java objects into an output stream using Java's serialization mechanism.


┌───────────────┐       ┌────────────────────┐       ┌──────────────────┐       ┌──────────┐
│               │       │                    │       │                  │       │          │
│  Java Object  │ ====> │ ObjectOutputStream │ ====> │ FileOutputStream │ ====> │   File   │
│               │       │                    │       │                  │       │          │
└───────────────┘       └────────────────────┘       └──────────────────┘       └──────────┘
                            Serialization 


In simple words:

        ObjectOutputStream = Object → serialized data


It does NOT directly mean:

        Object → readable text file


Instead:

        Object
          │
          ▼
        ObjectOutputStream
          │
          ▼
        Serialized byte-oriented data
          │
          ▼
        File



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHY CAN'T ObjectOutputStream WORK ALONE?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

The FileOutputStream knows how to send BYTE data to a physical file.

But:
        FileOutputStream does not understand Java objects.

And:
        ObjectOutputStream understands how to serialize Java objects.


Therefore, we combine them.

        Java Object
            │
            ▼
--------------------------------------------
      ObjectOutputStream
"convert object into serialization data"
--------------------------------------------
             │
             ▼
--------------------------------------------
    FileOutputStream
"send byte data to file"
--------------------------------------------
             │
             ▼
            File


This is called STREAM CHAINING.

We are connecting one stream on top of another.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 THE MOST IMPORTANT STRUCTURE
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
Suppose:

        Student s = new Student("Yash", 23, 85);


Our stream structure becomes:

┌────────────────────┐
│  Student Object    │
│--------------------│
│ name  = "Yash"     │
│ age   = 23         │
│ marks = 85         │
└─────────┬──────────┘
          │
          │ writeObject(s)
          ▼
┌─────────────────────────┐
│   ObjectOutputStream    │
│-------------------------│
│ Object-level handling   │
└────────────┬────────────┘
             │
             │ serialized byte data
             ▼
┌─────────────────────────┐
│    FileOutputStream     │
│-------------------------│
│ File-level byte output  │
└────────────┬────────────┘
             │
             ▼
┌─────────────────────────┐
│      student.dat        │
└─────────────────────────┘
 

The important idea:

        ObjectOutputStream
                ↓
        FileOutputStream
                ↓
              File


ObjectOutputStream is the HIGHER-LEVEL layer.
FileOutputStream is the LOWER-LEVEL file-writing layer.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
-------------                C O N S T R U C T O R         ---------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

════════════════════════════════════════════════════════════
1. ObjectOutputStream(OutputStream out)
════════════════════════════════════════════════════════════

It requires an 'OutputStream' object as an parameter

This is important.
The parameter is NOT specifically:

        FileOutputStream

It is:
        OutputStream


Therefore we can provide a FileOutputStream because:

        FileOutputStream
                ↓
        extends OutputStream


So this is valid:

        FileOutputStream fos = new FileOutputStream("student.dat");

        ObjectOutputStream oos = new ObjectOutputStream(fos);


Conceptually:


        FileOutputStream
                │
                │ is an
                ▼
        OutputStream
                │
                │ accepted by
                ▼
        ObjectOutputStream



FileOutputStream fos = new FileOutputStream("student.dat");

        This creates the connection to the actual file.

Then:--------------------------------

ObjectOutputStream oos = new ObjectOutputStream(fos);

        This places ObjectOutputStream on top of that output stream.




        

═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
--------------------            M E T H O D S         ---------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

════════════════════════════════════════════════════════════
1. writeObject()
════════════════════════════════════════════════════════════
This is an important methods of the ObjectStream class that writes an object to the 
ObjectOutputStream using Java's serialization mechanism.


Conceptually:

        writeObject(s)
             │
             └── performs serialization
             └── and writes it to the stream



Syntax:
        oos.writeObject(object);

Returns Void

Example:
        Student s = new Student("Yash", 23, 85);
        oos.writeObject(s);


Meaning:
        "Serialize the object referenced by s and send its serialized representation
         through this output stream."



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
  Only Serializable object -- allowed
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

There is one important condition to write a java object into the file.
The object we try to serialize must be eligible for Java serialization.

Usually, the class implements:

        Serializable interface


Example:

        class Student implements Serializable
        {
            String name;
            int age;
            int marks;
        }


Then:
        Student s = new Student("Yash", 23, 85);

can be passed to:
        oos.writeObject(s);


We will study `Serializable` properly in the NEXT file.

For now remember:

        ObjectOutputStream
                +
        Serializable object
                =
        Object can be serialized



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
                        PRACTICAL PROGRAM
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

*/

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// class that implements Serializable
class Student implements Serializable
{
    String name;
    int age;
    int marks;


    Student(String name, int age, int marks)
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

// ================ main clas ==================
public class p2_ObjectOutputStream
{
    public static void main(String[] args)
    {
        try
        {
            // STEP 1 — Create the Java object
            Student s = new Student("Yash", 23, 85);


            // STEP 2 — Create FileOutputStream
            FileOutputStream fos = new FileOutputStream("student.dat"); // create this file if not exist 
 

            // STEP 3 — Place ObjectOutputStream on top of FileOutputStream
            ObjectOutputStream oos = new ObjectOutputStream(fos);


            // STEP 4 — Serialize the object and write into the file
            oos.writeObject(s);


            // STEP 5 — Close the stream
            oos.close();


            System.out.println("Student object serialized successfully.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

