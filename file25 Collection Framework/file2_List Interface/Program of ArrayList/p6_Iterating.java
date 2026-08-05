/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
::::::::::::::::::::::::::::: Cursors :::::::::::::::::::::::::::::::
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Cursors are used in java collection framework to access the collection elements one by one.
-> There are three cursors provided-

    (1) Iterator
    (2) ListIterator
    (3) Enumerator


=========================================
(1) Iterator<E> iterator()
=========================================
-> Returns an Iterator object that can be used to iterate over the list elements.
-> Throws:
        No exceptions.


=========================================
(2) ListIterator<E> listIterator()
=========================================
-> Returns a list iterator over the elements in this list (in proper sequence).
-> Returns a ListIterator object that can traverse in both forward and backward directions.
-> Throws:
            No exceptions.


=========================================
(3) ListIterator<E> listIterator(int index)
=========================================
-> Returns a list iterator over the elements in this list, starting at the specified position in the list.
-> Returns a ListIterator object starting at the specified index.
-> Throws:
    IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size()).

=========================================
(4) void forEach(Consumer<? super E> action)
=========================================
-> Performs the given action for each element of the list until all elements have been processed or the action throws an exception.
-> The action can be a lambda expression, method reference, or an object that implements the Consumer interface.
-> Throws:
    NullPointerException - if the specified action is null.

    
=========================================
(5) Spliterator<E> spliterator()
=========================================
-> Returns a Spliterator over the elements in this list.
-> Returns a Spliterator object that can traverse and partition the elements for parallel processing.
-> Throws:
    No exceptions.
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;


public class p6_Iterating 
{

    public static void Using_Iterator(ArrayList<String> list) 
    {
        // ~~~~~~~~~ Iterating using Iterator ~~~~~~~~~
        System.out.println("\nIterating using Iterator...");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            System.out.println("Element: " + iterator.next());
        }
    }

    public static void Using_ListIterator(ArrayList<String> list) 
    {
        // ~~~~~~~~~ Iterating using ListIterator ~~~~~~~~~
        System.out.println("\nIterating using ListIterator (forward)...");

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) 
        {
            System.out.println("Element: " + listIterator.next());
        }

        System.out.println("\nIterating using ListIterator (backward)...");
        while (listIterator.hasPrevious()) 
        {
            System.out.println("Element: " + listIterator.previous());
        }
    }


    public static void Using_ForEach(ArrayList<String> list) 
    {
        // ~~~~~~~~~ Iterating using forEach ~~~~~~~~~
        System.out.println("\nIterating using forEach...");

        list.forEach((element) -> System.out.println("Element: " + element));
    }


    public static void Using_Spliterator(ArrayList<String> list) 
    {
        // ~~~~~~~~~ Iterating using Spliterator ~~~~~~~~~
        System.out.println("\nIterating using Spliterator...");

        Spliterator<String> spliterator = list.spliterator();
        spliterator.forEachRemaining((element) -> System.out.println("Element: " + element));
        // ------------------------------------------------
    }

    public static void main(String[] args) 
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~ Iterating Methods ~~~~~~~~~~~~~~~~~~~~~\n");

        ArrayList<String> list = new ArrayList<>();
        list.add("Yash");
        list.add("Sanjay");
        list.add("Kunal");
        list.add("Sipika");
        list.add("Shivani");

        // Iterator 
        Using_Iterator(list);

        // List Iterator 
        Using_ListIterator(list);

        // For each iteration
        Using_ForEach(list);
        
        // Split Iterator 
        Using_Spliterator(list);
    }
}
