/*
 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------ Difference between List & Set Interface -----------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

__________________________________________________________________________________________
|       List Interface                    |           Set Interface                       |
|-----------------------------------------|-----------------------------------------------|
|   List is an ordered collection.        |   Set is an unordered collection.             |
|_________________________________________|_______________________________________________|
|   List is indexed-based                 |   Set is non-index based data structure       |
|_________________________________________|_______________________________________________|
|   List allows duplicate elements        |   Set does not allow duplicate elements       |
|_________________________________________|_______________________________________________|
|   List allows null elements             |   Set allows only one null element            |
|_________________________________________|_______________________________________________|
|   List follows insertion order(Indexed) |   Set does not follow any order (hashcode)    |
|_________________________________________|_______________________________________________|
|   Iterator & ListIterator can be used   |   Only Iterator can be used                   |
|_________________________________________|_______________________________________________|




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Set Interface in Java =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Set is the second interface of the java collection framework that extends the collection interface
   and provide features to implement a Set data structure..

-> Set is used to represent a collection of elements where all the elements are unique 
   and no duplicates are allowed.

-> Elements are Un-ordered and Non-indexed based like Arrays or ArrayList.

-> Suitable for scenarios where uniqueness is a primary requirements.

   
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Key Points of Set Interface ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=======================================================================
1. Unique Elements
=======================================================================
-> The **Set Interface** ensures that all elements are unique. 
-> If an attempt is made to insert duplicate elements, the existing element remains, and the duplicate is ignored.

=======================================================================
2. No Positional Access
=======================================================================
-> Unlike the **List Interface**, Set does not maintain any specific order of elements or provide indexed access.

=======================================================================
3. Allows Null
=======================================================================
-> The **Set Interface** allows at most one `null` element.

=======================================================================
4. Unordered or Sorted
=======================================================================
-> Some implementations of Set (e.g., `HashSet`) do not maintain order, while others (e.g., `TreeSet`) maintain a sorted order.

=======================================================================
5. Heterogeneous Elements
=======================================================================
-> Allows heterogeneous elements (different types) unless restricted by generics.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Common Implementations of Set Interface =========== =========
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

======================================================================================================================
| Implementation      | Ordering     | Null Allowed  | Thread Safety |     Notes                                     |
|====================================================================================================================|
| HashSet             | Unordered    | Yes (1 null)  | No            | Fast, uses hashing.                           |
|====================================================================================================================|
| LinkedHashSet       | Insertion    | Yes (1 null)  | No            | Maintains insertion order.                    |
|====================================================================================================================|
| TreeSet             | Sorted (ASC) | No            | No            | Elements must be comparable.                  |
|====================================================================================================================|
| CopyOnWriteArraySet | Insertion    | Yes (1 null)  | Yes           | Thread-safe, used in concurrent environments. |
|====================================================================================================================|


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Methods of Set Interface ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Set interface inherits all the features of Colelction interface but modified them to ensure uniqueness.



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
(1) boolean add(Element e)
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
-> Adds the specified element to the set if it is not already present.


=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
(2) boolean remove(Object o)
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
-> Removes the specified element if it exists in the set.


=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
(3) boolean contains(Object o)
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
-> Checks if the specified element exists in the set.


=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
(4) int size()
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
-> Returns the number of elements in the set.


=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
(5) void clear()
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
-> Removes all elements from the set.


=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
(6) Iterator<Element> iterator()
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
-> Returns an iterator to traverse the elements.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== When to Use Which Set Implementation =======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--------------------
=== HashSet ========
--------------------
-> Use when you need fast lookups and do not care about the order of elements.

--------------------
=== LinkedHashSet ==
--------------------
-> Use when you need to maintain the insertion order of elements.

--------------------
=== TreeSet ========
--------------------
-> Use when you need a sorted collection or need to perform range queries.

--------------------
=== CopyOnWriteArraySet ==
--------------------
-> Use in multi-threaded environments when you need a thread-safe Set implementation.



*/



import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class p4_IntroToSet 
{
    public static void main(String[] args) 
    {
        Set<String> set = new HashSet<>();

        // Adding elements into set
        set.add("Apple");
        set.add("Orange");
        set.add("Banana");
        set.add("Grapes");
        System.out.println("\nAdding elements into set : " + set);

        // Removing elemnets from set
        set.remove("Banana");
        System.out.println("\nAfter removing banana from set : " + set);

        // Checking if element exists in set
        System.out.println("\nIS Appple present in set : " + set.contains("Apple"));

        // Size of set
        System.out.println("\nSize of set : " + set.size());

        // Clearing all elements from set
        set.clear();

        // Checking if set is empty
        System.out.println("\nIs set empty : " + set.isEmpty());

        // Traversing a set using iterator
        Iterator<String> itr = set.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }
}

