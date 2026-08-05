/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== History of Legacy Classes =========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In this journey of learning Collection framework we are finally here to learn about what is 'Vector' & 'Satck'
   implementation classes of List Interface after follwed by 'ArrayList' and 'LinkeList'.

-> The Interesting thing is that these 'Vector' & 'Stack' classes are already present in the java before that 
   Collection framework and after the JDK 1.2 they are included in the Collection framework as "Legacy classes".

---------------------------
   JDK 1.0
===========================
=> In this version java provides classes & Interfaces in which we can store the data/ Objects.
   example: Vector, Stack, Hashtable, Properties, & Dictionary

   
---------------------------
   JDK 1.2
===========================
-> Collection framework introduced, And  the old existing classes are re-engineered to include inside Collection framework
   that provide a generic way to deals with collection of objects.

-> Those classes that are remodified to include are known as Legacy classes.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Introduction to Vector class ======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> The `Vector` class is an implementation of the `List` Interface and part of the Java Collection Framework.

-> It provides a **resizable array**, similar to an `ArrayList`, meaning its size can dynamically grow or shrink 
   as elements are added or removed.

-> Unlike `ArrayList`, `Vector` is **synchronized**, making it thread-safe for concurrent access. However, 
   this makes it slower in single-threaded environments.
-----------------------------------------------------------------------------------------------



---------------------------------------------------
|                                                 |
|    [10]---> [20]---> [30]---> [40]---> [50]     |
|                                                 |
|-------------------------------------------------|
                    heap memory



-> 'Vector' is located in java.util package.
-> It is used to store 'ordered collection' of elements.
-> It allows 'duplicates' elements to stored.
-> Elements are stored in the 'contiguous memeory location'
-> provide 'Random access' to elements based on the index.
-> vector uses 'Wrapper classes'


    [Thread-1]              [Thread-2]
        |                       |
    ____|_______________________|_____
    |                                |
    |         Vector                 | =========> ConcurrentModificationException
    |________________________________|
         __________|___________
        |        Stack        |
        |_____________________|
          

~~~~~~~~~~~~ Note ~~~~~~~~~~~
However, due to its synchronization overhead it is generally recommended to use modern alternative like
ArrayList in 'single threaded scenarios'.
Despite this vector is still very usefull in certain situation, particularly in multi-threaded environment
where thread safety is a concern.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Key Points of Vector =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Dynamic Array:
    Like ArrayList, Vector also uses a Dynamic Array that grows or shrink automatically when elements are needed.
        
(2) Synchronized: 
    All methods in `Vector` are synchronized, making it **thread-safe** but slower compared to `ArrayList`.

(2) Indexed Based: 
    Elements can be accessed directly using their index, making it fast for random access.

(3) Null Values:
    Supports the insertion of `null` values.

(4) Allows Duplicates: 
    `Vector` allows storing duplicate elements.

(6) Legacy Class: 
    Introduced in JDK 1.0, re-engineered in JDK 1.2, but still exists for backward compatibility.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Performance Characteristics of Vector ======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=======================================================================
1. Time Complexity
=======================================================================
-> Access (get) by index: O(1) - due to its array-based structure.
-> Insertion at end: O(1) - unless resizing is needed, in which case it can be O(n).
-> Insertion/removal in the middle: O(n) - elements need to be shifted to maintain order.
-> Removal by index: O(n) - also involves shifting elements.

=======================================================================
2. Memory Management
=======================================================================
-> Internally uses a **dynamic array** to store its elements.
-> When the capacity is reached, the `Vector` automatically **doubles its size** to accommodate more elements.



==============================
 Constructors of Vector
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Vector(): 
    Creates an empty vector with an initial capacity of 10.

(2) Vector(int initialCapacity): 
    Creates a vector with the specified initial capacity. 

(3) Vector(int initialCapacity, int capacityIncrement): 
    Creates a vector with the specified initial capacity and capacity increment.

(4) Vector(Collection c): 
    Creates a vector containing the elements of the specified collection.






*/

import java.util.Vector;
import java.util.List;

public class p1_IntroDuction 
{
    public static void main(String[] args) 
    {
        // Empty vector -> capacity 10
        Vector<Integer> list1 = new Vector<>();
        System.out.println("\nVector() initial capacity : " + list1.capacity());

        
        // Empty vector -> initial capacity 5
        Vector<Integer> list2 = new Vector<>(5);
        System.out.println("\nVector(capacity) initial capacity : " + list2.capacity());


        // Empty vector -> initial_capacity , increment_capacity
        Vector<Integer> list3 = new Vector<>(10, 5);
        System.out.println("\nVector(capacity, increment) initial capacity : " + list3.capacity());

        

        // Vector with collection 
        Vector<Integer> list4 = new Vector<>(List.of(22, 33, 44, 55, 66, 99));
        System.out.println("\nVector(collection) initial capacity : " + list4.capacity());


        

    }
    
}
