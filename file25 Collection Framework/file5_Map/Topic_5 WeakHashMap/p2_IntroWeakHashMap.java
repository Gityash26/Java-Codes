/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Garbage Collector (GC) ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Before understanding WeakHashMap, we must understand

                "Garbage Collector"

because WeakHashMap completely depends on it.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== What is Garbage Collector ? ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Garbage Collector (GC) is a JVM component responsible for

        -> Finding unused objects.

        -> Removing them from Heap Memory.

        -> Recovering memory automatically.

Programmer does NOT manually delete objects in Java.

This is one of the biggest advantages of Java.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Why Garbage Collector ? =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose Java had no Garbage Collector.

Student s1 = new Student();

        Heap

        +----------------+
        |   Student()    |
        +----------------+

Later,

s1 = null;

The object still occupies Heap Memory.

If thousands of such unused objects remain,

        ↓

Memory keeps filling.

        ↓

Application becomes slower.

        ↓

Eventually,

        OutOfMemoryError


Garbage Collector prevents this problem by removing unreachable objects automatically.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Reachable Object ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

An object is called Reachable if at least one Strong Reference points to it.



                Stack Memory                    Heap Memory

            -------------------           ---------------------
            |   Student s1     | -------> |    Student Object  |
            -------------------           ---------------------

Since 's1' points to the object,
        ↓

Object is Reachable.
        ↓

GC cannot remove it.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Unreachable Object ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Now suppose,

Student s1 = new Student();

s1 = null;


                Stack Memory                    Heap Memory

            -------------------           ---------------------
            |   s1 = null      |           |   Student Object  |
            -------------------           ---------------------

Now, No Strong Reference exists.

Therefore,

        Object becomes

                UNREACHABLE
                     ↓

    Eligible for Garbage Collection.


Important:

        Eligible for GC ≠ Immediately Deleted

The JVM decides when to actually run the Garbage Collector.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ How Garbage Collector Works ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                    Program Execution
                            │
                            ▼

                    Objects Created
                            │
                            ▼

                Some Objects Become Unreachable
                            │
                            ▼

              JVM decides to run Garbage Collector
                            │
                            ▼

               Finds Unreachable Objects
                            │
                            ▼

                   Frees Heap Memory



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Can We Force GC ? ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Java provides

        System.gc();

Example

        System.gc();

This only REQUESTS the JVM to perform Garbage Collection.

It does NOT guarantee that GC will run immediately.

The JVM makes the final decision.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Important Points ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) GC removes only unreachable objects.
----------------------------------------------------------
(2) Reachable objects can never be collected.
----------------------------------------------------------
(3) Calling System.gc() is only a request, not a guarantee.
----------------------------------------------------------
(4) Java automatically manages memory. Unlike C/C++, programmers do not manually free memory.
----------------------------------------------------------
(5) WeakHashMap relies on Garbage Collector to automatically remove entries whose keys
are no longer strongly referenced.
----------------------------------------------------------



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Example ====================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class Student
{
    // context 
}

public class p2_GarbageCollector
{
    public static void main(String[] args)
    {

        Student s = new Student();

        System.out.println("Object Created...");
        s = null;

        System.out.println("Reference Removed");

        System.gc();
        System.out.println("GC Requested");

    }
}



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Summary =====================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Object Created
        ↓

Strong Reference Exists
        ↓

Object is Reachable
        ↓

GC Cannot Remove


----------------------------------------------------------


Reference Removed
        ↓

Object becomes Unreachable
        ↓

Eligible for Garbage Collection
        ↓

JVM may remove it later



*/