/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============================== Why IdentityHashMap ? ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Till now, we have studied the following implemented classes of Map Interface.

                                Map Interface
        ____________________________|__________________________________________
        |               |               |               |                     |
    HashMap      LinkedHashMap      Hashtable      WeakHashMap          SortedMap
                                                                       |
                                                                    TreeMap
                                                                       |
                                                                  NavigableMap

Question

If HashMap already compares keys and stores Key-Value pairs efficiently,

        Then,

Why did Java introduce IdentityHashMap ?



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Problem with HashMap ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap compares Keys using

        equals() and hashCode()

If two objects are logically equal,

HashMap treats them as the SAME Key.


Example

Student s1 = new Student(101);

Student s2 = new Student(101);


Suppose,

s1.equals(s2)
    ====> returns true

Then, HashMap considers s1 and s2 as the SAME Key.

Even though they are two different objects in memory.



Diagram


                Heap Memory

        +------------------------+
        | Student Object (101)   |   <-- s1
        +------------------------+

        +------------------------+
        | Student Object (101)   |   <-- s2
        +------------------------+

Different Objects

↓
equals() returns true

↓
HashMap stores only ONE logical Key.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== But Sometimes We Need =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

In some applications,

Two different objects should always remain different,

even if equals() returns true.


In such cases,
    Object Identity is more important than Object Equality.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= IdentityHashMap ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

IdentityHashMap is an implemented class of Map Interface.

Instead of comparing Keys using

        equals()

it compares Keys using

        == 
(reference equality).


This means, IdentityHashMap checks

"Are both references pointing to the EXACT SAME object?"

instead of "Do both objects contain equal data?"


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Object Equality vs Identity =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Object Equality

↓
equals()

↓
Compares Object Data


------------------------------------------------------------


Object Identity

↓
==

↓
Compares Memory References



Example

Student s1 = new Student(101);
Student s2 = new Student(101);


Memory


                Heap

      +-------------------+
      | Student(101)      |   <-- s1  (memory location: #34578)
      +-------------------+

      +-------------------+
      | Student(101)      |   <-- s2  (memory location: #14270)
      +-------------------+




HashMap ===> (equals())

↓
Treats both Keys as SAME (if equals() returns true)


------------------------------------------------------------



IdentityHashMap  ==> (==)

↓
Treats both Keys as DIFFERENT because s1 != s2



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= When to Use ==================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

IdentityHashMap is useful when

✔ Object Identity matters.

✔ Every object should be treated as unique.

✔ We want to distinguish between two different objects even if they contain the same data.

✔ Frameworks and JVM internals where object references are more important than object values.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================================ Summary ===================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap

        equals() + hashCode()

            ↓

       Logical Equality

------------------------------------------------------------

IdentityHashMap (==)

            ↓

Reference Equality



*/