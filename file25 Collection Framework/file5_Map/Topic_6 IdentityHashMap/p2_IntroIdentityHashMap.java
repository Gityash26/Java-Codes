/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== IdentityHashMap =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

IdentityHashMap is an implemented class of the Map Interface.

Package: java.util

It stores data in the form of Key → Value pairs.

Like HashMap, it uses Hashing internally.

However, it compares Keys using  '==' instead of 'equals()'



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============================== Syntax =====================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

IdentityHashMap<K, V> map = new IdentityHashMap<>();


Example

IdentityHashMap<Integer, String> map = new IdentityHashMap<>();
IdentityHashMap<Student, String> map = new IdentityHashMap<>();



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Internal Working ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap

        Key => hashCode() => Bucket Index

        If collision occurs
                │
            equals()
                │
             same key?


------------------------------------------------------------


IdentityHashMap

        Key
         │
    Identity Hash
         │
    Bucket Index
         │
If collision occurs
         │
         ==

         │
    Same Object ?


Notice

HashMap use ===> equals()

IdentityHashMap use ===> ==



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Identity Hash Code ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

IdentityHashMap does NOT use Object.hashCode()

Instead, it internally uses System.identityHashCode(Object)

Purpose, 

    Generate a hash value based on Object Identity
    instead of ''' Object Data '''


Therefore, even if equals()
    returns true,

two different objects may have different identity hash codes.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Equality vs Identity ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Object Equality
↓

equals()
↓

Compares Object Contents



Example

Student(101)

Student(101)
↓

equals()
↓

true


-----------------------------------------------------------

Object Identity
↓

==

↓

Compares Memory References



Example

Student s1 = new Student(101);

Student s2 = new Student(101);


s1 == s2
↓

false

because both references point to different objects in memory.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Properties ==================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Implements Map Interface.
------------------------------------------------------------
(2) Uses Hashing internally.
------------------------------------------------------------
(3) Compares Keys using 

        == instead of equals().
------------------------------------------------------------
(4) Uses
        System.identityHashCode() instead of hashCode().
------------------------------------------------------------
(5) Allows one null Key.
------------------------------------------------------------
(6) Allows multiple null Values.
------------------------------------------------------------
(7) Not Synchronized.
------------------------------------------------------------
(8) Insertion Order is NOT guaranteed.
------------------------------------------------------------
(9) Average Time Complexity

    put()       O(1)
    get()       O(1)
    remove()    O(1)




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Constructors ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) IdentityHashMap()
    Creates an empty IdentityHashMap.

------------------------------------------------------------

(2) IdentityHashMap(int expectedMaxSize)
    Creates an empty IdentityHashMap with the specified expected maximum size.

------------------------------------------------------------


(3) IdentityHashMap(Map<? extends K, ? extends V> m)
    Creates an IdentityHashMap containing all mappings from another Map.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Applications ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

IdentityHashMap is mainly used when

✔ Object Identity is more important than Object Equality.

✔ Debugging object references.

✔ Object Graph Processing.

✔ Serialization Frameworks.

✔ JVM Internal Implementations.

✔ Maintaining metadata for individual objects.

It is NOT commonly used in normal business applications like Student Management,
    Banking Systems or E-commerce projects.


*/