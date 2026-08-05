/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~ What is LinkedList ~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



        List(Interface)                              Queue(Interface)
            |                                          |
 Abstract Sequential list                           Dequeue
         (class)                                  (Interface)
             |__________________    __________________|
                               |   |         
                        ---------------------       
                        |     LinkedList    |                         
                        ---------------------
                                                                              



----------------------------------------------------------------------------------------------
Definition: JAVA Collection framework - LinkedList
----------------------------------------------------------------------------------------------

-> Java LinkedList is an implementation class of the 'List' and 'Deque' interfaces.

-> Internally, it is implemented using a Doubly Linked List data structure, meaning each node contains a reference 
   to both the **previous** and **next node**, allowing for efficient insertion and deletion in both directions.

-> It does not support Random Access - elements can only be accessed sequentially.

-> When accessing an element, the search starts from either the beginning or end of the LinkedList. 

-> It is an **ordered** collection that provides **sequential access**.
-> Supports **duplicate elements**.
-> Supports adding **null elements**.
-> Supports **index-based operations**.
-> Elements are stored in **non-contiguous memory locations**.

----------------------------------------------------------------------------------------------



===================================================
---------- Note -----------------------------------
===================================================

-> LinkedList is located in the `java.util` package.

-> It can be used as both a **List** and a **Deque** (double-ended queue).

-> More flexible than arrays since it allows dynamic memory allocation without a fixed size.

-------------------------------------------------------



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
::::::::::::::::: Doubly Linked List Structure ::::::::::::::
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

          _______________        _______________        _______________
head---> |___|_Data_|___| <---> |___|_Data_|___| <---> |___|_Data_|___| 

### Explanation:
- A **Doubly Linked List** is composed of nodes, each containing:
  - A **previous pointer** to the previous node.
  - A **data** section for storing the actual value.
  - A **next pointer** to the next node.
- Nodes are stored in non-contiguous memory, allowing efficient **insertion** and **deletion** without shifting data.
- Supports traversal in both **forward** and **backward** directions but does not support random access.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
:::::::::::::::::::: Double-Ended Queue (Deque) ::::::::::::::
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

          __________________________________________________
front -> |____|____|____|____|____|____|____|____|____|____| <- rear
        (enque, deque)                                      (enque, deque)

- Supports insertion and deletion from both **ends**.
- Unlike a regular queue, which follows **FIFO**, `LinkedList` used as a dequeue allows both ends to be used for enqueue (insertion) and dequeue (removal) operations.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Key Points of LinkedList ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=======================================================================
(1) Doubly-Linked List
=======================================================================
-> LinkedList is internally implemented as a doubly-linked list, where each element (node) is connected to its previous and next elements.
-> This structure allows for efficient insertion and removal of elements from both the beginning and the end of the list.


=======================================================================
(2) Non-Indexed: 
=======================================================================
-> Elements are accessed sequentially, making it slower than ArrayList for random access.
-> Due to non Indexed, Linked list does not provide random access (O(1)).
-> It takes O(n) accessing time for an element.


=======================================================================
(3) Allows Null Values
=======================================================================
-> LinkedList supports the insertion of Null values.


=======================================================================
(4) Duplicates Allowed
=======================================================================
-> LinkedList allows for storing duplicates elements.


=======================================================================
(5) Non-Synchronized: 
=======================================================================
-> Not thread-safe by default, so it is not suitable for concurrent access by multiple threads unless synchronized manually.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== Performance Characteristics of LinkedList ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=======================================================================
1. Time Complexity
=======================================================================
-> Access (get) by index: O(n)            - needs traversal from the head or tail.
-> Insertion at beginning: O(1)           - adding a new head node.
-> Insertion at end: O(1)                 - adding a new tail node.
-> Insertion/removal in the middle: O(n)  - requires traversal to find the position.
-> Removal by index: O(n)                 - requires traversal to find the node.


=======================================================================
2. Memory Management
=======================================================================
-> LinkedList internally uses nodes to store its elements.
-> Each node contains references to the next and previous nodes, which makes insertion and deletion operations efficient than ArrayList.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Constructors of LinkedList ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) LinkedList(): 
    Creates an empty list.

(2) LinkedList(Collection c): 
    Creates a list containing the elements of the specified collection.



*/


import java.util.LinkedList;
import java.util.Arrays;

public class p1_IntroLinkedList 
{
    public static void main(String[] args) 
    {

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~ Constructor of LinkedList ~~~~~~~~~~~~~~~~~~~~~~~\n");

        // Creating an Empty linkedlist
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Yash");
        list1.add("Sanjay");
        list1.add("Kunal");
        list1.add("Byomkesh");
        list1.add("Navikant");


        // Creating Linkedlist with Existing Collection
        String[] arr = { "Hello", "World", "Java", "Python" };
        LinkedList<String> list2 = new LinkedList<>(Arrays.asList(arr));

        System.out.println("\nLinkedlist 1 : " + list1);
        System.out.println("\nLinkedlist 2 : " + list2);

    }
}
