/* 
=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`==`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=`=
:::::::::::::::::::::: Linked List Deque Methods :::::::::::::::::::::::::::::::::::
=====================================================================================
-> Following methods are inherited from the Deque interface-


==== Adding Elements ===============
=====================================

(1) void addFirst(E e): Inserts the specified element at the beginning.

(2) void addLast(E e): Inserts the specified element at the end.

(3) boolean offerFirst(E e): Inserts the specified element at the beginning.

(4) boolean offerLast(E e): Inserts the specified element at the end.


==== Removing Elements ===============
=====================================

(1) E removeFirst(): Removes and retrieves the first element.

(2) E removeLast(): Removes and retrieves the last element.

(3) E pollFirst(): Removes and retrieves the first element (returns null if the deque is empty).

(4) E pollLast(): Removes and retrieves the last element (returns null if the deque is empty).


==== Retrieving Elements ===============
=====================================

(1) E getFirst(): Retrieves, but does not remove, the first element (throws an exception if the deque is empty).

(2) E getLast(): Retrieves, but does not remove, the last element (throws an exception if the deque is empty).

(3) E peekFirst(): Retrieves, but does not remove, the first element (returns null if the deque is empty).

(4) E peekLast(): Retrieves, but does not remove, the last element (returns null if the deque is empty).

*/

import java.util.LinkedList;

public class p4_MethodsType2 
{
    static void addingElements(LinkedList<String> deque) 
    {
        System.out.println("\n-------------------------- Adding Elements -----------------------------------\n");

        deque.addFirst("Yash");
        System.out.println("After adding 'Yash' at the beginning: " + deque);

        deque.addLast("Harish");
        System.out.println("After adding 'Harish' at the end: " + deque);

        deque.offerFirst("Manish");
        System.out.println("After offering 'Manish' at the beginning: " + deque);

        deque.offerLast("Harshita");
        System.out.println("After offering 'Harshita' at the end: " + deque);
    }

    static void removingElements(LinkedList<String> deque) {
        System.out.println("\n-------------------------- Removing Elements ---------------------------------\n");

        String removedFirst = deque.removeFirst();
        System.out.println("Removed first element ('" + removedFirst + "'): " + deque);

        String removedLast = deque.removeLast();
        System.out.println("Removed last element ('" + removedLast + "'): " + deque);

        String polledFirst = deque.pollFirst();
        System.out.println("Polled first element ('" + polledFirst + "'): " + deque);

        String polledLast = deque.pollLast();
        System.out.println("Polled last element ('" + polledLast + "'): " + deque);
    }

    static void retrievingElements(LinkedList<String> deque) {
        System.out.println("\n-------------------------- Retrieving Elements --------------------------------\n");

        // Re-adding elements for demonstration
        deque.addFirst("A");
        deque.addLast("B");

        System.out.println("Current deque: " + deque);

        System.out.println("First element (getFirst): " + deque.getFirst());
        System.out.println("Last element (getLast): " + deque.getLast());

        System.out.println("First element (peekFirst): " + deque.peekFirst());
        System.out.println("Last element (peekLast): " + deque.peekLast());
    }
    public static void main(String[] args) 
    {
        // creating a linkedlist 
        LinkedList<String> dequeList = new LinkedList<>();

        addingElements(dequeList);
        removingElements(dequeList);

        // Re-adding elements for retrieving methods
        dequeList.addAll(java.util.Arrays.asList("A", "B", "C", "D"));
        retrievingElements(dequeList);
    }
}
