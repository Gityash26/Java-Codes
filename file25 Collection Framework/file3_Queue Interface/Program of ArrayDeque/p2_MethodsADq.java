/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Methods of ArrayDeque ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

========================================
 Insertion Operations
========================================
(1) void addFirst(E e):
    Inserts the specified element at the front of the deque.

(2) void addLast(E e):
    Inserts the specified element at the rear of the deque.

(3) boolean offerFirst(E e):
    Inserts the specified element at the front and returns true if successful.

(4) boolean offerLast(E e):
    Inserts the specified element at the rear and returns true if successful.

(5) void push(E e):
    Pushes an element onto the front of the deque (Stack operation).

========================================
 Removal Operations
========================================
(1) E removeFirst():
    Retrieves and removes the first element.
    Throws NoSuchElementException if the deque is empty.

(2) E removeLast():
    Retrieves and removes the last element.
    Throws NoSuchElementException if the deque is empty.

(3) E pollFirst():
    Retrieves and removes the first element, or returns null if empty.

(4) E pollLast():
    Retrieves and removes the last element, or returns null if empty.

(5) E pop():
    Removes and returns the first element (Stack operation).

========================================
 Access Operations
========================================
(1) E getFirst():
    Retrieves the first element without removing it.
    Throws NoSuchElementException if the deque is empty.

(2) E getLast():
    Retrieves the last element without removing it.
    Throws NoSuchElementException if the deque is empty.

(3) E peekFirst():
    Retrieves, but does not remove, the first element,
    or returns null if the deque is empty.

(4) E peekLast():
    Retrieves, but does not remove, the last element,
    or returns null if the deque is empty.

========================================
 Utility Operations
========================================
(1) int size():
    Returns the number of elements present in the deque.

(2) boolean isEmpty():
    Checks whether the deque contains no elements.

(3) void clear():
    Removes all elements from the deque.

(4) boolean contains(Object o):
    Checks whether the specified element exists in the deque.

(5) Iterator<E> iterator():
    Returns an iterator that traverses the deque from front to rear.

(6) Iterator<E> descendingIterator():
    Returns an iterator that traverses the deque from rear to front.
*/


import java.util.ArrayDeque;
import java.util.Iterator;

public class P2_MethodsADq
{
    void insertionOperations()
    {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        // addFirst()
        dq.addFirst(20);
        dq.addFirst(10);
        System.out.println("After addFirst(): " + dq);

        // addLast()
        dq.addLast(30);
        dq.addLast(40);
        System.out.println("After addLast(): " + dq);

        // offerFirst()
        dq.offerFirst(5);
        System.out.println("After offerFirst(): " + dq);

        // offerLast()
        dq.offerLast(50);
        System.out.println("After offerLast(): " + dq);

        // push()
        dq.push(1);
        System.out.println("After push(): " + dq);
    }

    void removalOperations()
    {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.addLast(10);
        dq.addLast(20);
        dq.addLast(30);
        dq.addLast(40);
        dq.addLast(50);

        System.out.println("\nOriginal Deque: " + dq);

        // removeFirst()
        System.out.println("removeFirst(): " + dq.removeFirst());
        System.out.println("Deque: " + dq);

        // removeLast()
        System.out.println("removeLast(): " + dq.removeLast());
        System.out.println("Deque: " + dq);

        // pollFirst()
        System.out.println("pollFirst(): " + dq.pollFirst());
        System.out.println("Deque: " + dq);

        // pollLast()
        System.out.println("pollLast(): " + dq.pollLast());
        System.out.println("Deque: " + dq);

        dq.push(100);
        dq.push(200);
        System.out.println("After push(): " + dq);

        // pop()
        System.out.println("pop(): " + dq.pop());
        System.out.println("Deque: " + dq);
    }

    void accessOperations()
    {
        ArrayDeque<String> dq = new ArrayDeque<>();

        dq.add("Java");
        dq.add("Python");
        dq.add("C++");

        System.out.println("\nDeque: " + dq);

        // getFirst()
        System.out.println("getFirst(): " + dq.getFirst());

        // getLast()
        System.out.println("getLast(): " + dq.getLast());

        // peekFirst()
        System.out.println("peekFirst(): " + dq.peekFirst());

        // peekLast()
        System.out.println("peekLast(): " + dq.peekLast());
    }

    void utilityOperations()
    {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.add(11);
        dq.add(22);
        dq.add(33);
        dq.add(44);

        System.out.println("\nDeque: " + dq);

        // size()
        System.out.println("size(): " + dq.size());

        // isEmpty()
        System.out.println("isEmpty(): " + dq.isEmpty());

        // contains()
        System.out.println("contains(22): " + dq.contains(22));
        System.out.println("contains(99): " + dq.contains(99));

        // iterator()
        System.out.print("iterator(): ");
        Iterator<Integer> itr = dq.iterator();
        while (itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // descendingIterator()
        System.out.print("descendingIterator(): ");
        Iterator<Integer> revItr = dq.descendingIterator();
        while (revItr.hasNext())
        {
            System.out.print(revItr.next() + " ");
        }
        System.out.println();

        // clear()
        dq.clear();
        System.out.println("After clear(): " + dq);
        System.out.println("isEmpty(): " + dq.isEmpty());
    }

    public static void main(String[] args)
    {
        P2_MethodsADq obj = new P2_MethodsADq();

        System.out.println("=============== Insertion Operations ===============");
        obj.insertionOperations();

        System.out.println("\n=============== Removal Operations =================");
        obj.removalOperations();

        System.out.println("\n=============== Access Operations ==================");
        obj.accessOperations();

        System.out.println("\n=============== Utility Operations =================");
        obj.utilityOperations();
    }
