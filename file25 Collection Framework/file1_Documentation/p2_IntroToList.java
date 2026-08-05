/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== List Interface =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

~~~~~~~~~~~~~~ Definition ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------------------------------------------------------------------------
-> The List interface is a part of the Collection Framework that represents an 'ordered collection' 
   (also known as a sequence) of elements.

-> Unlike sets, lists can contain 'duplicate elements' and are indexed, meaning elements can be accessed 
   by their position in the list.
----------------------------------------------------------------------------------


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Key Points of List Interface ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=======================================================================
1. Duplicates Allowed
=======================================================================
-> Lists allow duplicate elements, meaning the same value can appear multiple times in the same list.

=======================================================================
2. Ordered Collection
=======================================================================
-> Lists maintain the order in which elements are inserted. 
   The order of elements will be the same as the order in which they were added.

=======================================================================
3. Positional Access and Manipulation
=======================================================================
-> Elements can be accessed using an integer index, starting from 0.
-> It allows adding, updating, and removing elements at specific positions in the list.

=======================================================================
4. Allows Null Values
=======================================================================
-> Lists can store null values.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Common Implementations of List Interface ===================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                                                       ----------------------------------------------------------------------------------------------------
                                        List Interface | sequential | ordered | duplicates Allowed | Specific location - Insert, delete, update, retrieve | 
                                            |          ----------------------------------------------------------------------------------------------------
                ____________________________|_____________________________________
               |                            |                                    |
            ArrayList                  LinkedList                             Vector
                                                                                |
                                                                              Stack


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Methods of List Interface ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

------------------------------------------
(1) void add(int index, Element e)
------------------------------------------
(2) Element get(int index)
------------------------------------------
(3) Element set(int index, Element e)
------------------------------------------
(4) List<Element> subList(int fromIndex, int toIndex)
------------------------------------------
(5) int indexOf(Object obj)
------------------------------------------
(6) int lastIndexOf(Object obj)
------------------------------------------
(7) ListIterator<Element> listIterator()
------------------------------------------
(8) boolean remove(Object obj)
------------------------------------------



::::::::::::::::::::::: Note ::::::::::::::::::::::::::::

-> We can clearly seen that Collection as a parent Interface provides very basic and general methods for all the data structures
   but the 'List Interface' as per their promised properties provide various other methods.

-> List focuses more on positional add, remove, update, Iterate, indexed access of the element.

=========================================================



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== When to use which List Implementation ======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--------------------
== ArrayList =======
--------------------
-> Use when you need fast access to elements by index, and insertions/deletions are rare.


--------------------
=== LinkedList =====
--------------------
-> Use when you have frequent insertions and deletions, especially in the middle of the list.


--------------------
=== Vector =========
--------------------
-> Use in multi-threaded environments when synchronization is required.


--------------------
=== Stack ========= 
--------------------
Use when you need a LIFO (Last-In-First-Out) data structure.



*/

import java.util.*;

public class p2_IntroToList 
{
   public static void main(String[] args) 
   {
      List<String> l1 = new ArrayList<>();   

      // ------------- Adding method ----------------------- 
      l1.add(0, "Yash");
      l1.add(1, "Sanjay");
      l1.add(2, "Kunal");

      System.out.println("\nList using add() method : " + l1);


      // ------------- get method ----------------------- 
      System.out.println("\nget index 0 element : " + l1.get(0));
      System.out.println("get index 1 element : " + l1.get(1));
      System.out.println("get index 2 element : " + l1.get(2));
      
      
      // ------------- set method ----------------------- 
      l1.set(1, "Anjali");
      System.out.println("\nSet Anjali at index 1 : " + l1);
      
      
      // ------------- sublist method ----------------------- 
      System.out.println("\nSublist form 0 to 1 : " + l1.subList(0, 1));
      

      // ------------- index method ----------------------- 
      System.out.println("\nIndex of Sanjay : " + l1.indexOf("Sanjay"));
      
      
      // ------------- listIterator method ----------------------- 
      ListIterator<String> itr = l1.listIterator();
      
      System.out.println("\nIteration using List Iterator...");
      
      System.out.println("\n=> In forward direction : ");
      while(itr.hasNext())
      {
         System.out.print(itr.next()+ " | ");
      }
      
      System.out.println("\n\n=> In backward direction : ");
      while(itr.hasPrevious())
      {
         System.out.print(itr.previous()+ " | ");
      }
    
      

      // ------------- remove method ----------------------- 
      l1.remove("Yash");
      System.out.println("\n\nRemove Yash : " + l1);

   }
}