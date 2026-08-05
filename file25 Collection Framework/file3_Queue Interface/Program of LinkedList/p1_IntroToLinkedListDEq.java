/* 


           Collection
                |_______________________________________________________________
                |                                                |             |
        Queue (Interface)                                     List           Set
        /               \
       /                 \
PriorityQueue (Class)   Deque (Interface)
                        /              \
                       /                \
            ArrayDeque (Class)    LinkedList (Class)


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== LinkedList as Queue / Deque (Java) ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=> LinkedList implements Queue, Deque, and List interfaces.
=> In Queue mode, it follows FIFO (First-In First-Out).
=> In Deque mode, insertion and deletion is allowed from BOTH ends.
=> It can also behave like a Stack using push/pop methods.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Queue Operations (FIFO)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) offer(Element e):
    Inserts element at the rear of the queue.

(2) poll():
    Removes and returns the front element.
    Returns null if empty.

(3) peek():
    Returns front element without removing it.
    Returns null if empty.

(4) element():
    Returns front element without removing it.
    Throws exception if empty.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Deque Operations (Double Ended Queue)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) addFirst(E e):
    Inserts element at the front.

(2) addLast(E e):
    Inserts element at the rear.

(3) removeFirst():
    Removes element from front.

(4) removeLast():
    Removes element from rear.

(5) peekFirst():
    Views front element.

(6) peekLast():
    Views last element.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Stack Operations
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) push(E e):
    Inserts element at front (Stack push).

(2) pop():
    Removes and returns front element (Stack pop).

(3) peek():
    Returns top element without removing it.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Traversal Methods
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Iterator:
    Traverses from front to rear.

(2) Descending Iterator:
    Traverses from rear to front.
*/

import java.util.LinkedList;
import java.util.Iterator;

public class p1_IntroToLinkedListDEq 
{
    void queueOperations()
    {
        LinkedList<Integer> q = new LinkedList<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.println("Queue after offer(): " + q);

        System.out.println("peek(): " + q.peek());
        System.out.println("poll(): " + q.poll());

        System.out.println("After poll(): " + q);

        System.out.println("element(): " + q.element());

        System.out.println("size(): " + q.size());
        System.out.println("isEmpty(): " + q.isEmpty());
    }

    void dequeOperations()
    {
        LinkedList<Integer> dq = new LinkedList<>();

        dq.addFirst(10);
        dq.addLast(20);
        dq.addFirst(5);
        dq.addLast(25);

        System.out.println("\nDeque after insertions: " + dq);

        System.out.println("getFirst(): " + dq.getFirst());
        System.out.println("getLast(): " + dq.getLast());

        System.out.println("removeFirst(): " + dq.removeFirst());
        System.out.println("removeLast(): " + dq.removeLast());

        System.out.println("After removals: " + dq);

        System.out.println("peekFirst(): " + dq.peekFirst());
        System.out.println("peekLast(): " + dq.peekLast());
    }

    void stackOperations()
    {
        LinkedList<Integer> st = new LinkedList<>();

        st.push(100);
        st.push(200);
        st.push(300);

        System.out.println("\nStack after push(): " + st);

        System.out.println("pop(): " + st.pop());
        System.out.println("After pop(): " + st);

        System.out.println("peek(): " + st.peek());
    }

    void traversalOperations()
    {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("\nTraversal:");

        System.out.print("Iterator: ");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext())
        {
            System.out.print(it.next() + " ");
        }

        System.out.print("\nDescending Iterator: ");
        Iterator<Integer> dit = list.descendingIterator();
        while (dit.hasNext())
        {
            System.out.print(dit.next() + " ");
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        P1_LinkedListQueueDeque obj = new P1_LinkedListQueueDeque();

        System.out.println("=========== Queue Operations ===========");
        obj.queueOperations();

        System.out.println("\n=========== Deque Operations ===========");
        obj.dequeOperations();

        System.out.println("\n=========== Stack Operations ===========");
        obj.stackOperations();

        System.out.println("\n=========== Traversal Operations ===========");
        obj.traversalOperations();
    }
}