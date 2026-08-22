/*

╔=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═╗
║                  Introdution to Object Stream                                ║
╚=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═╝


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHAT PROBLEM ARE WE SOLVING?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Until now, we learned how Java can work with data inside files.

We learned:

    Character Streams
        → FileReader
        → FileWriter

    Byte Streams
        → FileInputStream
        → FileOutputStream

    Buffered Streams
        → BufferedInputStream
        → BufferedOutputStream


But there is one important problem still remaining.


Suppose our Java program contains an object:

        Student s = new Student("Yash", 23, 85);


The object exists in MEMORY.

Conceptually:

        ┌──────────────────────────────┐
        │          Student s           │
        ├──────────────────────────────┤
        │ name  → "Yash"               │
        │ age   → 23                   │
        │ marks → 85                   │
        └──────────────────────────────┘


Now imagine:

        Program terminates
                ↓
                Object disappears from memory


So the problem is:
        How can we save this object's state into a file?

And later:

        How can we recreate the same object from that file?


This is where OBJECT STREAMS come into the picture.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 why normal file read or write were not enough ?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
Suppose:

        Student s = new Student("Yash", 23, 85);

We could manually extract its data:
        name  → Yash
        age   → 23
        marks → 85

Then write these values into a file.

For example:
        Yash 23 85


But now, while reading the file again, Java needs to know:

        Which value represents name?
        Which value represents age?
        Which value represents marks?


And imagine a much larger object:

        Student
        ├── name
        ├── age
        ├── marks
        ├── address
        │    ├── city
        │    ├── state
        │    └── pincode
        ├── subjects
        └── ...

Manually storing and reconstructing all this information becomes complicated.

Therefore Java provides a mechanism where the OBJECT itself can be converted into a form that can be stored and later reconstructed.

That mechanism is called:

        SERIALIZATION



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
  WHAT IS SERIALIZATION?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Serialization means:

        Converting the STATE of a Java object into a byte-stream representation so that 
        it can be stored or transferred.


In simple words:

        Java Object
             │
             ▼
        Serialization
             │
             ▼
        Byte Stream
             │
             ▼
           File


Example:

        Student Object
        ┌──────────────────┐
        │ Yash             │
        │ 23               │
        │ 85               │
        └────────┬─────────┘
                 │
                 │ Serialization
                 ▼
        ┌──────────────────┐
        │ Serialized Data  │
        │   (byte data)    │
        └────────┬─────────┘
                 │
                 ▼
             student.data


IMPORTANT:

Serialization does NOT mean simply converting the object into normal readable text.
The serialized representation is binary/byte-oriented data.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHAT IS DESERIALIZATION?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Serialization stores the object into te Byte-Oriented data.
But we also need the opposite operation.


DESERIALIZATION means:
--------------------------------
        Reading the serialized data and reconstructing the Java object.


Conceptually:

        File
         │
         ▼
        Serialized Data
         │
         │ Deserialization
         ▼
        Java Object


Therefore:

    Serialization
===========================================================
        OBJECT  ──────────────────►  FILE
===========================================================


    Deserialization
===========================================================
        FILE    ──────────────────►  OBJECT
===========================================================



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
----------------               OBJECT STREAMS              --------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=

Java provides special streams for working with objects.

There are two important classes:


                        Object streams
                              │          
                    ┌─────────┴─────────┐
                    ▼                   ▼
        ObjectInputStream          ObjectOutputStream         


Their responsibilities are opposite.

┌────────────────────────────┬──────────────────────────────┐
│ ObjectOutputStream         │ ObjectInputStream            │
├────────────────────────────┼──────────────────────────────┤
│ Object → File              │ File → Object                │
│                            │                              │
│ Serialization              │ Deserialization              │
│                            │                              │
│ writeObject()              │ readObject()                 │
└────────────────────────────┴──────────────────────────────┘



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHERE DO OBJECT STREAMS FIT INTO WHAT WE ALREADY KNOW?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

This is VERY important because Object Streams are not completely separate from the Byte 
Stream concept we already learned.


For writing:
--------------------------------------------
┌───────────────┐       ┌────────────────────┐       ┌──────────────────┐       ┌──────────┐
│               │       │                    │       │                  │       │          │
│  Java Object  │ ====> │ ObjectOutputStream │ ====> │ FileOutputStream │ ====> │   File   │
│               │       │                    │       │                  │       │          │
└───────────────┘       └────────────────────┘       └──────────────────┘       └──────────┘
                            Serialization 



For reading:
--------------------------------------------
┌───────────────┐       ┌────────────────────┐       ┌───────────────────┐       ┌──────────┐
│               │       │                    │       │                   │       │          │
│  Java Object  │ <==== │  FileInputStream   │ <==== │ ObjectInputStream │ <==== │   File   │
│               │       │                    │       │                   │       │          │
└───────────────┘       └────────────────────┘       └───────────────────┘       └──────────┘
                                                        Deserialization 






═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 CAN EVERY JAVA OBJECT BE SERIALIZED?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

NO — there is an important requirement.

A class generally needs to implement:

                                Serializable


Example:

        class Student implements Serializable
        {
            String name;
            int age;
            int marks;
        }


`Serializable` is an interface from:

        java.io


We will study this interface separately.

Do NOT worry yet about:

        serialVersionUID
        transient
        inheritance rules
        static fields
        serialization exceptions


Those will be introduced when they become relevant.
This keeps the learning sequence clean.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
  THE COMPLETE FOUNDATION
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Everything we have learned can now be connected:


NORMAL FILE DATA
============================
       Java
        │
        ▼
        Character / Byte Stream
                  │
                  ▼
                File



OBJECT DATA
=============================
     Java Object
        │
        ▼
        ObjectOutputStream
             │
             ▼
        Byte Stream
             │
             ▼
           File



The main difference is:

        Normal File I/O
                → We explicitly handle characters or bytes.


        Object Streams
                → Java handles the serialization and reconstruction 
                  of an object's state.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 IMPORTANT TERMS TO REMEMBER
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Serialization   :  Object ----------→ serialized byte representation

Deserialization :  serialized data ----------→ Object


ObjectOutputStream 
        → used for serialization

ObjectInputStream
        → used for deserialization

writeObject()
        → writes an object to an ObjectOutputStream

readObject()
        → reads/reconstructs an object from an ObjectInputStream

Serializable
        → marks a class as eligible for Java's default serialization mechanism



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHAT WE WILL DO NEXT
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Now that the foundation is clear, we will NOT jump directly into a huge serialization program.

Next we will learn:

        ObjectOutputStream
                │
                ├── What exactly it is
                ├── Why it extends OutputStream
                ├── Constructor
                ├── How it connects with FileOutputStream
                ├── writeObject()
                └── Small practical program


Then we will introduce:

        Serializable


This way each concept will be:

        UNDERSTAND
             ↓
        IMPLEMENT
             ↓
        OBSERVE
             ↓
        MOVE TO NEXT CONCEPT


*/
