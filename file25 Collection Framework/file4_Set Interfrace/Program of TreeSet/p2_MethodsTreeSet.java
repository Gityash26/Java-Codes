
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Methods of TreeSet ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

========================================
 Basic & Sorted Operations
========================================

(1) boolean add(Element e):
    -> Inserts element in sorted order if not already present.

(2) boolean remove(Object o):
    -> Removes specified element if present.

(3) E first():
    -> Returns the first (lowest/smallest) element currently in the set.

(4) E last():
    Returns the last (highest/largest) element currently in the set.


========================================
 Navigational Operations
========================================
(1) E lower(Element e):
    Returns the greatest element strictly less than e, or null if none.

(2) E floor(Element e):
    Returns the greatest element less than or equal to e, or null if none.

(3) E ceiling(Element e):
    Returns the least element greater than or equal to e, or null if none.

(4) E higher(E e):
    Returns the least element strictly greater than e, or null if none.

(5) E pollFirst():
    Retrieves and removes the first (lowest) element, or null if empty.

(6) E pollLast():
    Retrieves and removes the last (highest) element, or null if empty.

========================================
 Sub-Set Operations (Views)
========================================
(1) SortedSet<E> subSet(E fromElement, E toElement):
    Returns a view of the portion of this set ranging from fromElement (inclusive) to toElement (exclusive).

(2) SortedSet<E> headSet(E toElement):
    Returns a view of the portion of this set strictly less than toElement.

(3) SortedSet<E> tailSet(E fromElement):
    Returns a view of the portion of this set greater than or equal to fromElement.

========================================
 Reverse View Operations
========================================
(1) NavigableSet<E> descendingSet():
    Returns a reverse order view of the elements contained in this set.

(2) Iterator<E> descendingIterator():
    Returns an iterator over the elements in this set in descending order.
*/

import java.util.Arrays;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.SortedSet;

public class p2_MethodsTreeSet  
{
    void basicAndSortedOperations()
    {
        TreeSet<Integer> tree = new TreeSet<>();

        // Elements are automatically sorted upon insertion
        tree.addAll(Arrays.asList(40, 10, 30, 20, 50));
        System.out.println("\nTreeSet (Automatically Sorted): " + tree);

        // Fetching boundaries
        System.out.println("First (Lowest) element: " + tree.first());
        System.out.println("Last (Highest) element: " + tree.last());
    }

    void navigationalOperations()
    {
        TreeSet<Integer> tree = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("\nCurrent TreeSet: " + tree);

        // Lower and Floor
        System.out.println("Lower than 30 (< 30): " + tree.lower(30));
        System.out.println("Floor of 30 (<= 30): " + tree.floor(30));

        // Higher and Ceiling
        System.out.println("Ceiling of 35 (>= 35): " + tree.ceiling(35));
        System.out.println("Higher than 40 (> 40): " + tree.higher(40));

        // Polling elements (Retrieves + Removes)
        System.out.println("Poll First: " + tree.pollFirst());
        System.out.println("Poll Last: " + tree.pollLast());
        System.out.println("After polling: " + tree);
    }

    void subSetOperations()
    {
        TreeSet<Integer> tree = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50, 60));
        System.out.println("\nOriginal TreeSet: " + tree);

        // SubSet view (from inclusive, to exclusive)
        SortedSet<Integer> sub = tree.subSet(20, 50);
        System.out.println("SubSet [20, 50): " + sub);

        // HeadSet view (strictly less than element)
        SortedSet<Integer> head = tree.headSet(40);
        System.out.println("HeadSet (< 40): " + head);

        // TailSet view (greater than or equal to element)
        SortedSet<Integer> tail = tree.tailSet(40);
        System.out.println("TailSet (>= 40): " + tail);
    }

    void reverseOperations()
    {
        TreeSet<Integer> tree = new TreeSet<>(Arrays.asList(5, 15, 25, 35));
        System.out.println("\nOriginal TreeSet: " + tree);

        // Descending Set View
        System.out.println("Descending Set: " + tree.descendingSet());

        // Descending Iterator
        System.out.print("Descending Iterator output: ");
        Iterator<Integer> descItr = tree.descendingIterator();
        while(descItr.hasNext())
        {
            System.out.print(descItr.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        P5_MethodsTreeSet obj = new P5_MethodsTreeSet();

        obj.basicAndSortedOperations();
        obj.navigationalOperations();
        obj.subSetOperations();
        obj.reverseOperations();
    }    
}

