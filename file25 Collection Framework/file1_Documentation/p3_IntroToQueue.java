/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Chapter 3: The Queue Interface ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

====================================================================================
 1. Introduction to Queue Interface
====================================================================================
=>  The Queue interface is a member of the Java Collection Framework (java.util) and extends the 
    core Collection interface.

=>  While List focuses on positional indexing and Set focuses strictly on uniqueness,the Queue interface 
    is dedicated to the "Order of Processing".

=> A standard Queue works on a FIFO (First-In, First-Out) structure.
   - Elements are inserted at the end/tail (Rear) of the queue.
   - Elements are removed or processed from the front (Head) of the queue.

=> Exception to FIFO: PriorityQueue orders elements based on their values/natural sorting
   rather than insertion order.

====================================================================================
 2. Core Hierarchy & Implementations
====================================================================================
                      Collection (Interface)
                                |
                        Queue (Interface)
                        /               \
                       /                 \
             PriorityQueue (Class)     Deque (Interface)
                                       /              \
                                      /                \
                             ArrayDeque (Class)     LinkedList (Class)


==========================================================                             
 (A) PriorityQueue: 
=========================================================
-> An unbounded priority heap structure where elements are constantly sorted using their 
   natural order or a custom Comparator.


=========================================================
 (B) LinkedList: 
=========================================================   
-> A classic implementation that provides pure FIFO queue mechanics under the hood.


=========================================================
 (C) ArrayDeque: 
=========================================================
-> A resizable array implementation of a Double-Ended Queue (Deque). 
-> It allows inserting/removing from both ends seamlessly, making it perfect for both FIFO 
   queues and LIFO stacks.




====================================================================================
    Crucial Architecture: The Two Method Strategies
====================================================================================
 The Queue interface features a highly unique method structure. For every standard
 operation (Insertion, Removal, and Examination), it provides two separate methods. 
 One throws an exception if the action fails (e.g., if the queue is full/empty), 
 while the other safely returns a special value (false or null).

 +-------------------+-----------------------------+-------------------------------+
 | Operation Type    | Throws Exception (On Fail)  | Returns Special Value (Fail)  |
 +-------------------+-----------------------------+-------------------------------+
 | 1. Insert (Tail)  | add(e)                      | offer(e)                      |
 | 2. Remove (Head)  | remove()                    | poll()                        |
 | 3. Examine (Head) | element()                   | peek()                        |
 +-------------------+-----------------------------+-------------------------------+

 Note: In corporate Java development, offer(), poll(), and peek() are highly preferred 
 because managing fallback returns prevents your application from crashing.

 */
