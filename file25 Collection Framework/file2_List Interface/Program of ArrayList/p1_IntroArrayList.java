/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~ What is ArrayList ~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                    List (Interface) 
                          |
                   AbstractList (Class)
                          |
                  ArrayList (class)
                                           


-----------------------------------------------------------------------------------------------
 Definition            
-----------------------------------------------------------------------------------------------
-> The ArrayList class is an implements of the List Interface and is part of java Collection framework.

-> It provides a 'Resizable array', which means the size can grow and shrink dynamically as elements are added or removed.
   This flexibility makes it popular choice when the number of elements in a list isn't known in advance.
-----------------------------------------------------------------------------------------------


-> ArrayList is located in the java.util package.
-> It is used to store an Ordered collection of elements.
-> It allows duplicate elements to store.
-> Elements are stored in Contiguous memory locations.
-> Provides random access to elements based on the index.
-> ArrayList cannot be used for primitive data types like int, char, etc. Hence we need to use Wrapper class.



-----------------------------------
:::::: Note :::::::::::::::::::::::
-----------------------------------

-> Java ArrayList class uses a dynamic array for storing the elements.
-> It is like an array, but there is no size limit.
-> We can add, remove elements anytime. So it is much more flexible than the traditional array.

---------------------------------------------------
|                                                 |
|    [2]---> [4]---> [6]---> [8]---> [10]         |
|                                                 |
|-------------------------------------------------|
                    heap memory





~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Key Points of ArrayList ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Dynamic Size: 
    ArrayList can grow and shrink in size automatically when elements are added or removed.

(2) Indexed Based: 
    Elements can be accessed directly by their index, making it fast for random access.

(3) Null Values:
    Support the insertion of null values.

(4) Allows Duplicates: 
    ArrayList allows to store duplicate elements.

(5) Non-Synchronized: 
    Not thread-safe by by default so it is not suitable for concurrent access by multiple threads unless synchronized manually 




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Performance Characteristics of ArrayList ===================
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
-> ArrayList internally uses a dynamic array to store its elements.
-> When the capacity is reached, the ArrayList automatically increases its capacity (typically by 50% of the current size).



==============================
 Constructors of ArrayList
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) ArrayList(): 
    Creates an empty list with an initial capacity of 10.

(2) ArrayList(int initialCapacity): 
    Creates an empty list with the specified initial capacity.

(3) ArrayList( Collection c): 
    Creates a list containing the elements of the specified collection.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
List.of(Element1, Element2, Element3) 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> It returns a Un-Modifiable list that does not support addition, deletion of elements.
-> It can be used for making Collections to Insert instead of Arrays.asList() method.




*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p1_IntroArrayList 
{
    public static void main(String[] args) 
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~ Constructor of ArrayList ~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        // Empty Array List 
        ArrayList<String> l1 = new ArrayList<String>();  // default size = 10 (Increase afterwords usually 1.5 times the current)
        l1.add("value1");
        l1.add("value2");
        l1.add("value3");
        l1.add("value4");

        // specified capacity 
        ArrayList<String> l2 = new ArrayList<String>(5);
        l2.add("Student1");
        l2.add("Student2");
        l2.add("Student3");
        l2.add("Student4");
        l2.add("Student5");
        
        // Copy of another collection 
        ArrayList<String> l3 = new ArrayList<String>(l2);
 


        System.out.println("\nFirst ArrayList : " + l1);
        System.out.println("\nSecond ArrayList : " + l2);
        System.out.println("\nThird ArrayList : " + l3);
        System.out.println(l3.getClass().getName());
        
        List<Integer> l4 = new ArrayList<>(Arrays.asList(22, 33, 44, 55, 65));
        System.out.println(l4.getClass().getName());
        
        // Unmodifable List 
        List<Integer> myList = List.of(1, 2, 3, 4, 5);
        System.out.println("Unmodifiable List : " + myList);

        // -------------------------------------------------------------------
        // static private Arrays$ArrayList
        List<Integer> l5 = Arrays.asList(22, 33, 44, 55, 65);
        // l5.add(45); Not supported this methods 
        System.out.println(l5 + l5.getClass().getName());
        // -------------------------------------------------------------------

    }
}
