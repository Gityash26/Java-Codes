/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Methods of PriorityQueue =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

========================================
 Basic Queue Operations
========================================
(1) boolean offer(Element e):
    Inserts the specified element into this priority queue if possible (Preferred over add()).

(2) E poll():
    Retrieves and removes the head (smallest element) of this queue, or returns null if empty.

(3) E peek():
    Retrieves, but does not remove, the head of this queue, or returns null if empty.

(4) int size():
    Returns the total number of elements present in the queue.

(5) boolean isEmpty():
    Checks if the priority queue contains no elements.

(6) void clear():
    Removes all elements from the priority queue.

(7) Iterator<E> iterator():
    Returns an iterator over the elements. (Note: Does not traverse in sorted order).

    
========================================
 Bulk Operations
========================================
(1) boolean addAll(Collection c):
    Adds all the elements from the specified collection into the priority queue.

(2) boolean remove(Object o):
    Removes a single instance of the specified element from this queue, if it is present.

(3) boolean contains(Object o):
    Checks if the queue contains the specified element.
*/

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Iterator;

public class P8_MethodsPriorityQueue 
{
    void basicOperation()
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 1. Adding elements via offer()
        pq.offer(66);
        pq.offer(22);
        pq.offer(44);
        System.out.println("\nAfter adding 66, 22, 44 elements (Raw layout): " + pq);

        // 2. Checking head via peek()
        System.out.println("Peeking head element (Should be lowest): " + pq.peek());

        // 3. Removing head via poll()
        System.out.println("Polling (Extracting) head element: " + pq.poll());
        System.out.println("PriorityQueue after poll: " + pq);
        
        // 4. Check size
        System.out.println("Total elements in queue: " + pq.size());

        // 5. Check if empty
        System.out.println("Is PriorityQueue empty? : " + pq.isEmpty());

        // 6. Clearing the queue
        pq.clear();
        System.out.println("After clear(), is it empty? : " + pq.isEmpty());
    }

    void bulkAndSearchOperations()
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding a collection
        pq.addAll(Arrays.asList(88, 33, 55, 11, 99));
        System.out.println("\nAfter addAll of collection: " + pq);

        // Checking for standard presence
        System.out.println("Does queue contain 33? : " + pq.contains(33));

        // Removing a specific non-head element
        pq.remove(55);
        System.out.println("After removing specific element (55): " + pq);

        // Traversing using iterator
        System.out.print("Traversing via Iterator (Warning: Order is not guaranteed sorted): ");
        Iterator<Integer> itr = pq.iterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // Standard way to process elements in strict sorted priority order
        System.out.print("Processing via poll() (Guaranteed sorted order): ");
        while(!pq.isEmpty())
        {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        P8_MethodsPriorityQueue obj = new P8_MethodsPriorityQueue();

        obj.basicOperation();
        obj.bulkAndSearchOperations();
    }    
}

```