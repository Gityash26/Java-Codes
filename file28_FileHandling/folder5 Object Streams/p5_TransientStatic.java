/*
╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                      Transient AND static Fields                          ║
╚═══════════════════════════════════════════════════════════════════════════╝


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
1. WHAT PROBLEM ARE WE SOLVING?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

We already know:

        class Student implements Serializable
        {
            String name;
            int age;
            double marks;
        }


When we do:

        oos.writeObject(student);
        Java serializes the object's state.

But now consider:

        class Student implements Serializable
        {
            String name;
            int age;

            String password;
            int loginAttempts;
        }


Do we ALWAYS want every field to be stored inside
the serialized file?

NO.


Sometimes a field contains information that we DO NOT want to serialize.

For example:

        password
        temporary calculation
        cache data
        session information
        security-sensitive information


So Java provides:

        transient


And there is another important case:

        static


Static fields belong to the CLASS rather than to an individual object.

Therefore static fields also have special behavior during serialization.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 NORMAL INSTANCE FIELD
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

First understand the normal case.

        class Student implements Serializable
        {
            String name;
            int age;
        }

These are INSTANCE FIELDS.


Every Student object gets its own values:


        Student s1
        ┌─────────────────┐
        │ name = "Yash"   │
        │ age  = 23       │
        └─────────────────┘


        Student s2
        ┌─────────────────┐
        │ name = "Rahul"  │
        │ age  = 25       │
        └─────────────────┘


Each object has its own state.

Therefore these fields normally participate in serialization.


        Object
          │
          ├── name
          │
          └── age
                 │
                 ▼
           Serialized



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHAT IS transient?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

The `transient` is a keyword in Java.

When a field is declared:

        transient

Java is instructed: "Do NOT serialize this field."


Example:


        class Student implements Serializable
        {
            String name;
            int age;

            transient String password;
        }


Here:

        name, age     →    serialized
        password      →    NOT serialized



The important point:

        transient applies to FIELDS.

It does NOT mean:

        "delete the variable"

It means:

        "exclude this field from default serialization."



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 VISUAL UNDERSTANDING OF transient
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Suppose:

        Student
        ┌─────────────────────────────┐
        │ name     = "Yash"           │
        │ age      = 23               │
        │ marks    = 85.5             │
        │ password = "abc123"         │
        └─────────────────────────────┘
                         │
                         │ serialize
                         ▼

        ┌─────────────────────────────┐
        │ name     = "Yash"           │
        │ age      = 23               │
        │ marks    = 85.5             │
        │                             │
        │ password → NOT STORED       │
        └─────────────────────────────┘
                         │
                         ▼
                      File


So `transient` creates a boundary:

        NORMAL FIELD
             │
             ▼
        participates in serialization


        transient FIELD
             │
             ▼
        excluded from default serialization



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHAT HAPPENS AFTER DESERIALIZATION?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

This is very important.

Suppose:

        class Student implements Serializable
        {
            String name;
            transient String password;
        }

And:
        Student s = new Student("Yash", "abc123");


After serialization:

        name     → stored
        password → NOT stored


When the object is later deserialized:

        name      → restored
        password  → gets its default value


For a reference type like String:
        default value = null

So:

        BEFORE SERIALIZATION
                password = "abc123"

        AFTER DESERIALIZATION
                password = null


This is one of the most important behaviors of transient fields.


For primitive fields the default values are:

        int      → 0
        double   → 0.0
        boolean  → false
        char     → '\u0000'


For reference types:

        String
        Student
        Object
        etc.

        → null



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 WHY WOULD WE USE transient?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Common reasons:

        1. Sensitive information
                transient String password;

        2. Temporary information
                transient int temporaryResult;

        3. Data that can be recreated
                transient Cache cache;

        4. Data that should not be persisted
                transient Session session;


The basic idea is:

        "This field belongs to the current runtime state, 
        but I don't want it stored in the serialized representation."



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
--------------------        WHAT ABOUT static?                    -------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=

Now consider:

        class Student implements Serializable
        {
            String name;
            static String college;
        }

We know:

        name
                → belongs to each Student object

        college
                → belongs to the CLASS


Visualize it:


        Student Object 1
        ┌─────────────────┐
        │ name = "Yash"   │
        └─────────────────┘


        Student Object 2
        ┌─────────────────┐
        │ name = "Rahul"  │
        └─────────────────┘
                 │
                 │
                 ▼
           Student CLASS
        ┌─────────────────────────┐
        │ college = "MCA Univ."   │
        └─────────────────────────┘


There is only ONE `static college` associated with the class.

It is NOT part of the individual object's state.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 ARE static FIELDS SERIALIZED?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Normally: NO.
Static fields are NOT serialized as part of the individual object's state.

Example:
        class Student implements Serializable
        {
            String name;
            static String college;
        }


Suppose before serialization:

        college = "ABC University"

Then:

        serialize Student


The value of `college` is not saved as part of the Student object's serialized state.

When the object is deserialized, the static field comes from the CURRENT CLASS, not from the serialized
object data.


This distinction is important:

        instance field
                → belongs to object


        static field
                → belongs to class



═=═=═=═=═=═=═=══=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 transient vs static
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Remember:

        transient
        → explicitly says "don't serialize this field"


        static
        → field belongs to class, not object state



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
-------------------         PRACTICAL PROGRAM              ---------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

We will create one Student object containing:

        name
        age
        marks
        password
        college


Then we will serialize and deserialize it.

We will observe:

        name
        age
        marks
        → restored


        password
        → null


        college
        → NOT restored from serialized object data



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

    transient String password;

    static String college;


    Student(String name, int age, double marks, String password)
    {
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.password = password;
    }


    void display()
    {
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Marks    : " + marks);
        System.out.println("Password : " + password);
        System.out.println("College  : " + college);
    }
}


public class p5_TransientStatic
{
    public static void main(String[] args)
    {
        try
        {
            // Step1: Set static field
            Student.college = "ABC University";


            // Step2 — Create Student object
            Student original = new Student("Yash", 23, 85.5, "secret123");


            System.out.println("BEFORE SERIALIZATION");
            System.out.println("--------------------");

            original.display();


            // Step3 — Serialize

            FileOutputStream fos = new FileOutputStream("student.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(original);
            oos.close();


            // Step 4 — Change static field AFTER serialization
            Student.college = "XYZ University";


            // STEP 5 — Deserialize
            FileInputStream fis = new FileInputStream("student.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student restored = (Student) ois.readObject();
            ois.close();


            // =========================================================
            // STEP 6 — Display restored object
            // =========================================================

            System.out.println("\nAFTER DESERIALIZATION");
            System.out.println("---------------------");

            restored.display();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}


/*
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
. UNDERSTANDING THE PRACTICAL RESULT
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Before serialization:

        name     = "Yash"
        age      = 23
        marks    = 85.5
        password = "secret123"
        college  = "ABC University"


During serialization:

        name     ───────────────► STORED
        age      ───────────────► STORED
        marks    ───────────────► STORED
        password ───────────────► NOT STORED
        college  ───────────────► NOT STORED


Then we deliberately change:


        Student.college = "XYZ University";


The file still contains the old serialized state.

But `college` was never part of that state.


Therefore after deserialization:


        restored.name
        → "Yash"


        restored.age
        → 23


        restored.marks
        → 85.5


        restored.password
        → null


        restored.college
        → "XYZ University"


This demonstrates the difference very clearly.

*/