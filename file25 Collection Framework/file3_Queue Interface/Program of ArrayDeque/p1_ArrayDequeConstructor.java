/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Introduction to ArrayDeque =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=> ArrayDeque stands for "Array Double-Ended Queue".
=> It is a resizable-array implementation of the Deque interface.
=> Unlike a standard Queue, it allows insertion and removal of elements from BOTH
   the front (head) and the back (tail).

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Special Characteristics:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   (1) No Fixed Capacity:
       Automatically grows as needed.

   (2) Null Restriction:
       ArrayDeque does NOT permit null elements.

   (3) High Performance:
       Generally performs better than Stack when used as a stack and better than
       LinkedList when used as a queue because of lower memory overhead and
       better cache locality.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Memory & Dynamic Resizing Architecture:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   (1) Circular Array Mechanism:
       ArrayDeque internally stores elements in a circular array.
       It maintains two pointers:
         - head : points to the first element.
         - tail : points to the position where the next element will be inserted
                  at the rear.
       When either pointer reaches the last index of the array, it wraps around
       to the beginning, forming a logical circle.

   (2) How Resizing Works:

       - Trigger Condition:
         When an insertion would make the internal array full, ArrayDeque
         automatically expands its storage.

       - Expansion:
         In the current OpenJDK implementation, the internal array size is
         typically doubled to accommodate more elements.

       - Data Rearrangement:
         Existing elements are copied into the new larger array in their
         logical order, after which the head starts at index 0.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Visual Representation
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

          FRONT (Head)                           BACK (Tail)

addFirst()  ---> | E1 | E2 | E3 | E4 | E5 | <--- addLast()
removeFirst() <--                     --> removeLast()

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Working Modes:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(A) FIFO Queue Mode (First-In, First-Out)

    Insert : addLast() / offerLast()
    Remove : removeFirst() / pollFirst()

(B) LIFO Stack Mode (Last-In, First-Out)

    Push : addFirst() / push()
    Pop  : removeFirst() / pop()

===========================================================
 Constructors of ArrayDeque
===========================================================

(1) ArrayDeque()
    Creates an empty ArrayDeque with an initial capacity  16 elements.

(2) ArrayDeque(int initialCapacity)
    Creates an ArrayDequeue with the initial capacity.

(3) ArrayDeque(Collection c)
    Creates an ArrayDeque containing copies of all elements from the specified collection while preserving their iteration order.
*/

import java.util.ArrayDeque;
import java.util.List;

             
public class p1_ArrayDequeConstructor
{
    public static void main(String[] args)
    {
        System.out.println("=========================================================");
        System.out.println("------------ ArrayDeque Constructor Blueprint ------------");
        System.out.println("=========================================================");



        // (1) Default Constructor -----------------------------------------------------
        ArrayDeque<Integer> dqA = new ArrayDeque<>();

        dqA.addFirst(50); // Inserts at the front
        dqA.addLast(90);  // Inserts at the back
        dqA.addFirst(10); // Inserts at the front again

        System.out.println("\n(1) Default Constructor Output: " + dqA);



        // (2) Initial Capacity Constructor -------------------------------------------
        ArrayDeque<String> dqB = new ArrayDeque<>(64);

        dqB.add("Task-1");
        dqB.add("Task-2");

        System.out.println("\n(2) Capacity Constructor Output: " + dqB);



        // (3) Collection Constructor --------------------------------------------------
        List<Integer> initialData = List.of(100, 200, 300);

        ArrayDeque<Integer> dqC = new ArrayDeque<>(initialData);

        System.out.println("\n(3) Collection Constructor Output: " + dqC);

    }
}