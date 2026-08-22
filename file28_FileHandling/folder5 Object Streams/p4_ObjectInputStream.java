/* 

                       Object streams
                              │          
                    ┌─────────┴─────────┐
                    ▼                   ▼
        1. ObjectInputStream         2. ObjectOutputStream         

         
╔═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=╗
║                    2. ObjectInputStream class                              ║
╚════════════════════════════════════════════════════════════════════════════╝

In the previous file we understand, how to store the java object into the file using 
serialization mechanism and ObjetcOutputStream.

Now imagine the program terminates.

The object `s` that was in RAM disappears.

But the serialized representation is still stored in:

        student.dat


So our next problem is:

        How do we get the Java object BACK from the file?


This process is called:

        DESERIALIZATION



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
------------  WHAT IS DESERIALIZATION?        -----------------------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Deserialization is the process of reading serialized data and reconstructing the 
Java object from it.

The relationship is simply:


    SERIALIZATION                   DESERIALIZATION
    ----------------------      ----------------------
        Object                          File
           │                              │
           ▼                              ▼
     Serialized                     Deserialized 
           │                              │
           ▼                              ▼
         File                           Java


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 which class perform Deserialization??
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Java provides:
        ObjectInputStream

Package:
        java.io


Its main responsibility is:
        Read serialized object data and reconstruct the Java object.


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHY DOES ObjectInputStream NEED FileInputStream?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Just like ObjectOutputStream worked on top of FileOutputStream,

ObjectInputStream works on top of:

        FileInputStream


Why?
Because:
        FileInputStream
                → reads BYTE data from the file

while:
        ObjectInputStream
                → understands serialized OBJECT data


Therefore:

        student.dat
             │
             ▼
        FileInputStream
     "read bytes from file"
             │
             ▼
        ObjectInputStream
"interpret serialized object"
             │
             ▼
        Java Object


This is another example of STREAM CHAINING.


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
----------------               Construtors                   -------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==


═══════════════════════════════════════════════════════════
1. ObjectInputStream(InputStream in)
═══════════════════════════════════════════════════════════
It accepts an InputStream object as parameter

It does NOT specifically require:

        FileInputStream

But FileInputStream can be passed because:

        FileInputStream
              │
              │ is an
              ▼
        InputStream


Therefore:

        FileInputStream fis = new FileInputStream("student.dat");

        ObjectInputStream ois = new ObjectInputStream(fis);



        
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
----------------             M e t h o d                   -------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

═══════════════════════════════════════════════════════════
1. readObject()
═══════════════════════════════════════════════════════════
This method Reads the serialized data from the input stream and reconstructs the 
stored Java object.


Syntax:
        Object obj = ois.readObject();


Notice something important:
                                readObject()
                                        ↓
                                returns Object

Return type:

        Object


This means Java gives us a reference of the general `Object` type.

If we know that the stored object was a Student, 
we can cast it:

        Student s = (Student) ois.readObject();



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
WHY DOES readObject() RETURN Object?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

ObjectInputStream does not know in advance which class of object is stored in the file.

The file could contain:

        Student
        Employee
        Product
        Account
        etc.


Therefore the method returns the common parent type:

        Object

Example:
        Object obj = ois.readObject();


If we know it is a Student:

        Student s = (Student) obj;


Or directly:


        Student s = (Student) ois.readObject();



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
--------------                PRACTICAL PROGRAM        ---------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

We will perform BOTH operations in one program:

        1. Create Student object
        2. Serialize it
        3. Deserialize it
        4. Get the Student object back


This makes the complete round-trip easy to observe.


        Student Object
              │
              │ writeObject()
              ▼
        student.dat
              │
              │ readObject()
              ▼
        Student Object



*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
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


public class p4_ObjectInputStream
{
    public static void main(String[] args)
    {
        try
        {
            // step1: --------------- Serialization ----------------- 

            Student original = new Student("Yash", 23, 85.5);

            FileOutputStream fos = new FileOutputStream("student.dat");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(original);

            oos.close();


            // Step2: --------- Deserialization -----------------

            FileInputStream fis = new FileInputStream("student.dat");

            ObjectInputStream ois = new ObjectInputStream(fis);

            Student restoredObj = (Student) ois.readObject();

            ois.close();


            // Step3: --------- Display original object -----------------

            System.out.println("Original Object:");
            original.display();

            // Step3: --------- Display restored object -----------------
            System.out.println("\nRestored Object:");
            restoredObj.display();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
