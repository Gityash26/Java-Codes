/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Introduction of PriorityQueue ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> PriorityQueue is an unbounded queue that insert elements based on a priority.
-> It does NOT follow the traditional FIFO order. 
-> Instead, elements are ordered according to their natural sorting order (ascending), 
   or by a custom 'Comparator' provided at the time of construction.
-> The element at the absolute head of the queue is always the SMALLEST element.
-> It does not permit 'null' elements and is not thread-safe.

========================================
 Constructors
========================================
(1) PriorityQueue(): 
    Creates a PriorityQueue with default initial capacity (11) and natural ordering.

(2) PriorityQueue(int initialCapacity): 
    Creates a PriorityQueue with a custom specified initial capacity and natural ordering.

(3) PriorityQueue(Comparator comp): 
    Creates a PriorityQueue with default capacity that sorts elements via a custom comparator.

(4) PriorityQueue(Collection c): 
    Creates a PriorityQueue initialized with elements from the specified collection.


*/
import java.util.PriorityQueue;
import java.util.List;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class P1_PriorityQueueConst
{
    public static void main(String[] args) 
    {
        // (1) Default constructor -----------------------------------------------------
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        pqA.offer(50);
        pqA.offer(10);
        pqA.offer(30);
        System.out.println("\n(1) Default Constructor (Natural Order Peek): " + pqA.peek()); 
        System.out.println("Full state (Internal tree array representation): " + pqA);


        // (2) Constructor with comparator ---------------------------------------------
        Comparator<Integer> descendingComp = new Comparator<Integer>() 
        {
            @Override
            public int compare(Integer a, Integer b) 
            {
                return b.compareTo(a); // Reverses natural order to make a Max-Heap
            }
        };

        PriorityQueue<Integer> pqB = new PriorityQueue<>(descendingComp);
        pqB.offer(50);
        pqB.offer(10);
        pqB.offer(30);
        System.out.println("\n(2) Comparator Constructor (Descending Order Peek): " + pqB.peek()); 
        System.out.println("Full state (Internal tree array representation): " + pqB);


        // (3) Constructor with collection --------------------------------------------------- 
        // Creates a PriorityQueue containing the elements in the specified collection
        PriorityQueue<Integer> pqC = new PriorityQueue<>(List.of(40, 20, 40, 10));
        System.out.println("\n(3) Collection Constructor (Min-Heap processing): ");
        while(!pqC.isEmpty()) {
            System.out.print(pqC.poll() + " "); // Prints in sorted order as elements are polled
        }
        System.out.println();
        
        
        // (4) Constructor with SortedSet ------------------------------------------
        // Creates a PriorityQueue containing elements from a SortedSet, preserving its sorting strategy
        SortedSet<Integer> oldSortedSet = new TreeSet<>(descendingComp);
        oldSortedSet.add(100);
        oldSortedSet.add(300);
        oldSortedSet.add(200);

        PriorityQueue<Integer> pqD = new PriorityQueue<>(oldSortedSet);
        System.out.println("\n(4) SortedSet Constructor (Inherits Order Peek): " + pqD.peek()); 
        System.out.println("Full state (Internal tree array representation): " + pqD);
    }
}