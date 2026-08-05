/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--- History ------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Before the introduction of the Collection Framework in JDK 1.2, Java used to rely on a variety of classes like 
Vector, Stack, Hashtable, and arrays to store and manipulate groups of objects.


============= Drawbacks ================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
(1) Inconsistency:
    Each class has a different way of managing collections, leading to create confusion

(2) Lack of Inter-operatibility:
    These classes were not designed to work together seamlessly 

(3) No common Interface
    There were no common interface  for all these classes, which means you could not make generic algorithms 
    that can operates on different types of collections.


:::::::::::::: To solve this problem Collection Framework arrives :::::::::::::::::::


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== What is Collection =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

----------------------------------------------------------------------------------------------------------------------------------            
Definition: A Collection in Java is an 'Object' which is used to represent a group of Objects (Elements) into a single unit.
            Collection are used to standardize the way in which objects are handled.
----------------------------------------------------------------------------------------------------------------------------------            

===============================
Why Collection are required
===============================
-> So, we all know about the benefits of having a Object Oriented programming language that provides a way to 
   create a complex data type that can encapsulate the data as well as the methods operate on them.
-> Overall the meaning is that Oops provide the concept of 'Objects', An encapsulated form of Attributes & Behaviour.

-> While dealing with objects we come across a situation where we are having multiple objects in our program and the single 
   way we know about to manage all those objects is Array.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
::::: Arrays :::::::::::::::::::
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> A simplest data-structure used to store the homogeneous type of data or objects.
-> Fixed size with contiguous memory allocation of blocks.

 int[] arr = new arr[8];

          ____________________________________________________________
         |    ________________________________________               |
   arr-> |   |____|____|____|____|____|____|____|____|   length[8]   |
         |      0   1    2    3    4    5    6    7                  |
         |___________________________________________________________|
                                

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
::::::::::: note:::::::::::::::
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> No Doubt array is a perfect data structure to manage the data but some limitations we are facing 

=======================
(1) Contiguous Memory : It is not always possible to have a Contiguous Memory.
=======================
(2) Fixed Size        : Array Size needs to be declare at the compile time 
=======================
(3) Un-Synchronized   : Arrays are not synchronized to deal with mutithreaded environment
=======================
(4) Memory Wastage    : We can not extends or reduce the array size at run time that can cause memory wastage or lack 
=======================



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Collection Framework =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Collection framework in java is a collection of pre-defined classes and Intefaces that provides a way to 
   'Store', 'Manage' and 'Manipulate' a group of Objects.

-> There is a hierarchy of Interface and Classes helps to manage a group of objects.

-> Java.util package contains the collection framework.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Advantages of Collection Framework =========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=======================================================================
1. Standardized Data Structures
=======================================================================
-> The Collection Framework provides a standardized way to handle groups of objects, allowing for consistent 
   manipulation of collections like lists, sets, and maps.


=======================================================================
2. Built-in Data Manipulation Algorithms
=======================================================================
-> The framework includes built-in methods for searching, sorting, and manipulating data, which reduces the need 
   to implement these algorithms from scratch.


=======================================================================
3. Improved Performance
=======================================================================
-> Java Collections are highly optimized for performance. 
   For example, data structures like HashMap and ArrayList are designed for fast access and modification.


=======================================================================
4. Increased Code Reusability
=======================================================================
-> The framework allows you to reuse common data structures and algorithms, making code more modular and 
   reducing redundancy.


=======================================================================
5. Easy to Learn and Use
=======================================================================
-> The framework provides a well-organized hierarchy of interfaces and classes that is relatively easy to understand. 
   This makes it simpler for developers to implement common data-handling tasks.


=======================================================================
6. Enhanced Maintainability
=======================================================================
-> With a common API for collections, code is easier to read, maintain, and modify. 
-> The standardized interfaces also make it easy to switch between different implementations without affecting code.


=======================================================================
7. Type Safety (with Generics)
=======================================================================
-> By using generics, the Collection Framework ensures type safety at compile time, reducing runtime errors and eliminating 
   the need for typecasting.


=======================================================================
8. Thread-Safety
=======================================================================
-> The framework includes synchronized collection classes (e.g., Vector, Hashtable) and provides wrappers for synchronized 
   collections, making it easier to work with collections in multi-threaded environments.


=======================================================================
9. Support for Null Values
=======================================================================
-> Many collection classes allow null values, providing flexibility when dealing with nullable data.


=======================================================================
10. Extensibility
=======================================================================
-> The Collection Framework is designed to be extensible, allowing developers to create custom implementations if the 
   built-in ones don’t meet specific requirements.





~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Hierarchiy of Collection Framework =========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


                                                              Iterable
                                                                 |
                                                             Collection
                        _________________________________________|_________________________________________
                        |                                        |                                        |
                      List                                      Set                                     Queue
      _________________|______________                     ______|______________                   _______|___________
      |                |             |                     |                   |                   |                  |
    ArrayList      LinkedList      Vector               HashSet              SortedSet         PriorityQueue        Deque
                                     |                     |                    |                            _________|_____________
                                   stack              LinkedHashSet       NavigableSet                      |         |            |
                                                                                |                       ArrayDeque  LinkedList  Concurrent                
                                                                             TreeSet                                            LinkedDeque
                                  





                
                                                        Map
                 ________________________________________|_______________________________________
                |                    |                   |                    |                  |
            HashMap               WeakHashmap         IdentityHashMap     HashTable          SortedMap
                |                                                             |                  |
            LinkedHasMap                                                    Properties      NavigableHashmap
                                                                                                 |
                                                                                              TreeMap
                




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------- Iterable Interface ----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> This is the root interface for the entire collection framework.
-> Collection Interface extends the Iterable Interface hence all the further sub-classes also implements the iterable interface.


_____________________________________________________________________
=-=-=-=-=-=-=-=-=-=-=-=-=-= Methods =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
=====================================================================

------------------------------------------
(1) Iterator <E> iterator()
------------------------------------------
->  Returns an iterator of type <E> (any wrapper class object) for the collection. 
-> It can be used to iterate over the elements of the collection.  




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------- Collection Interface ----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> The Collection interface provides the foundation on which the collection framework is built.

:::: syntax ::::  
                  interface Collection <E>

-> Here, 'E is the type of object that the collection hold.

-> It provides basic operations like adding, removing, clearing the elements in a collection, and checking whether the collection is empty or not.

-> "List", "Set" and "Queue" are the three components that extends the 'Collection interface'.



_____________________________________________________________________
=-=-=-=-=-=-=-=-=-=-=-=-=-= Methods =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
=====================================================================


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~ Adding  ~~~~~~~~~~~~~~~~~~~~~~~
=======================================================

(1) boolean add(Element e)

(2) boolean addAll(Collection<? extends E> c)	


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~ Removing  ~~~~~~~~~~~~~~~~~~~~~~~
=======================================================

(1) boolean remove(Object obj)	

(2) boolean removeAll(Collection c)	

(3) void clear()	

(4) boolean retainAll(Collection c)	


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~ Iteration ~~~~~~~~~~~~~~~~~~~~~~~
=======================================================

(1) Iterator iterator()	

(2) default Spliterator spliterator()	



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~ Querying ~~~~~~~~~~~~~~~~~~~~~~~
=======================================================

(1) int size()	

(2) boolean contains(Object obj)	

(3) boolean containsAll(Collection c)	

(4) boolean equals(Object obj)	

(5) boolean isEmpty()	

(6) int hashCode()	




{:::::::::::::::::: Note :::::::::::::::::}

-> So, before moving further Interfaces after completing 'collection Interface' 
   let me ask you one question.

-> Don't you think being a parent class of various types of 'Data Structures' like ArrayList, 
   Stack, LinkedList, Queue, Set the Collection Interface requires to provide some methods that 
   are common for all of them to implement accordingly.

-> That's why Collection Interface provide several necessary operations that are required by every data structure.

===========================================



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------  Classification of Collection Elements ------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> In java collection framework, elements are classified on two main aspects:

=====================================================
(1) Order ----------
=====================================================

   -------------------------------
   Ordered Collection
   -------------------------------
   -> These collections maintain the order of the elements in which they are inserted.
   -> List like (ArrayList, LinkedList) keeps the elements in insertion order and allow access by index. 

   ----------------------------------
   Unordered Collection
   ----------------------------------
   -> These collections do not maintain any specific order.
   -> for example: Sets (like HashSet) do not gurantee any order for their elements.




=====================================================
(2) Duplication ----
=====================================================


   -------------------------------
   ~~~~~ Allow Duplicates ~~~~~~
   -------------------------------
   -> Lists allows duplicate elements, so you can have tthe same elements multiple times in a list.

   -------------------------------------
   ~~~~~ Do not Allow Duplicates ~~~~~~
   -------------------------------------
   -> Sets do not allow duplicate elements.
      for example: HashSet contains only unique elements.




*/

import java.util.*;

public class p1_Collection 
{
    public static void main(String args[])
    { 

      Collection<Integer> c = new ArrayList<>();

      // -------------- Adding methods ----------------- 
      
      // Adding single element 
      c.add(20);
      c.add(50);
      c.add(60);
      System.out.println("\nUsing add() methods : " + c);
      
      // Adding Collection of element 
      c.addAll(Arrays.asList(11, 22, 33, 44, 55));
      System.out.println("\nUsing addAll() methods : " + c);
      
      
      
      // -------------- Removing methods ----------------- 
      c.remove(50);
      System.out.println("\nRemove 50 using remove() methods : " + c);
      
      c.removeAll(Arrays.asList(22, 33, 44));
      System.out.println("\nRemoving (22, 33, 44) using removeAll() methods : " + c);

      

        // -------------- Iteration methods ----------------- 
        System.out.println("\nIterating using Iterator:");

        // Using an Iterator to traverse the collection
        Iterator<Integer> itr = c.iterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }       

        // Using a for-each loop
        System.out.println("\n\nIterating using for-each loop:");
        for (Integer num : c) 
        {
            System.out.print(num + " ");
        }

        // -------------- Querying methods ----------------- 
        System.out.println("\n\nCollection Size: " + c.size());

        System.out.println("\nDoes collection contain 20? " + c.contains(20));
        
        System.out.println("\nIs collection empty? " + c.isEmpty());
    }
}



