/*


Before WeakHashMap, we've been asking: 

            ==========> "How are objects stored?"

Now we'll ask:

            =========> "When are objects removed from memory?"


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Why WeakHashMap ? ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Before understanding WeakHashMap, we must first understand an important concept of Java.

                                "Object References"

Whenever an object is created in Java, it is stored inside the Heap Memory.

Example

            Student s = new Student();

                Stack Memory                      Heap Memory
              -----------------               -------------------
              |       s       | ------------> |    Student()     |
              -----------------               -------------------

The variable 's' is called a "Reference Variable".

It stores the address of the object, not the object itself.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Strong Reference ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

By default, every reference in Java is a Strong Reference.

Example

        Student s = new Student();

                Strong Reference
              --------------------
              |        s         | ------------------>
              --------------------                  |
                                                    |
                                                    ▼
                                              ----------------
                                              |   Student()  |
                                              ----------------


As long as a Strong Reference exists,
        ↓
The Garbage Collector (GC)
        ↓
CANNOT remove the object from memory.


Reason:

The object is still being used somewhere in the program.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Garbage Collector (GC) =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Garbage Collector (GC) is a JVM component.

Its job is to automatically free Heap Memory by removing objects that are no longer reachable.

Simply,

                Unused Object

                      ↓

 b            Garbage Collector

                      ↓

             Memory Recovered


This process happens automatically.

Programmers do NOT manually free memory in Java.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Problem with HashMap ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we create a HashMap.

            HashMap<Integer, Student>

                    |
                    ▼

             (101, Student)

Even if our program no longer needs the Student object,

HashMap STILL keeps a Strong Reference to the key and value.

Example

        Student s = new Student();

        HashMap<Student, String> map = new HashMap<>();
        map.put(s, "Java");


Now,

        s = null;

Many beginners think,

        "Now the object will be deleted."

Wrong.

Why?

Because HashMap still contains

                Student Object

HashMap
   |
   | Strong Reference
   ▼
Student Object


Therefore,

Garbage Collector cannot remove it.

The object remains alive inside the HashMap.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Why WeakHashMap ? ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

WeakHashMap solves this problem.

Instead of storing the Key using a Strong Reference, it stores the Key using a Weak Reference.

                WeakHashMap
                     |
               Weak Reference
                     |
                     ▼
                 Student Object


If no Strong Reference to the key exists anywhere else,
        ↓
Garbage Collector is allowed to remove the object.

Once the key is removed,

its corresponding value is also automatically removed from the WeakHashMap.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Strong vs Weak Reference =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

========================================
Strong Reference
========================================
Program Variable
        ↓
     Object
        ↓
  Garbage Collector
        ↓
Cannot remove the object.


------------------------------------------------------------


========================================
Weak Reference
========================================

 WeakHashMap
      ↓
   Object
      ↓
No Strong Reference Exists
      ↓
Garbage Collector
       ↓
 Object Removed
       ↓
Entry Automatically Removed from WeakHashMap.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Real Life Analogy ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Imagine a Library.

HashMap

   ↓

The librarian keeps a permanent record of every borrowed book.

Even if nobody wants the book anymore, the record still exists.

Therefore, the book cannot be removed.

------------------------------------------------------------

WeakHashMap

↓

The librarian keeps only a temporary note.

If nobody owns the book anymore, the note disappears automatically, and 
the book is removed from the record.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Applications ===============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

WeakHashMap is commonly used for

=> Memory-sensitive caches

=> Metadata associated with objects

=> Temporary object mappings

=> Automatic cleanup of unused entries

=> Preventing memory leaks




*/