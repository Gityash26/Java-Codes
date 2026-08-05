/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Methods of Vector Class =====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-------------------- Adding Elements ----------------------------------
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) add(Element e): Appends an element to the end of the vector.

(2) add(int index, E element): Inserts an element at the specified index.

(3) addAll(Collection<? extends E> c): Appends all elements from a collection.


-------------------- Removing Elements ----------------------------------
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) remove(Object o): Removes the first occurrence of the specified element.

(2) remove(int index): Removes the element at the specified index.

(3) clear(): Removes all elements from the vector.


-------------------- Accessing Elements ----------------------------------
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

(1) get(int index): Returns the element at the specified index.

(2) firstElement(): Returns the first element in the vector.

(3) lastElement(): Returns the last element in the vector.



-------------------- Modifying Elements ----------------------------------
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) set(int index, E element): Replaces the element at the specified index.



-------------------- Searching Elements ----------------------------------
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) contains(Object o): Checks if the vector contains the specified element.

(2) indexOf(Object o): Returns the index of the first occurrence of the specified element.

(3) lastIndexOf(Object o): Returns the index of the last occurrence of the specified element.



-------------------- Iterating Elements ----------------------------------
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) iterator(): Returns an iterator for traversing elements.

(2) listIterator(): Returns a list iterator for bidirectional traversal.



-------------------- Capacity Elements ----------------------------------
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) capacity(): Returns the current capacity of the vector.

(2) ensureCapacity(int minCapacity): Ensures the vector can hold at least the specified number of elements without resizing.

(3) trimToSize(): Trims the vector's capacity to its current size.


-------------------- Legacy method ----------------------------------
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) elements(): Returns an enumeration of the vector's components.
*/

import java.util.Vector;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Enumeration;

public class p2_Methods 
{

    static void addingMethods(Vector<String> list) 
    {
        // Adding elements at the end
        list.add("Yash");
        list.add("Sanjay");

        // Adding elements by index
        list.add(2, "Harsh");
        list.add(1, "Vishaka");

        // Adding a collection
        list.addAll(List.of("Apple", "Orange", "Grapes"));

        // Adding a collection at specific index
        list.addAll(1 , List.of("Hello" , "World"));

        System.out.println("\nList after adding elements: \n\t" + list);
    }

    static void removingMethods(Vector<String> list) 
    {
        System.out.println("\nOriginal List: " + list);

        list.remove(1);
        System.out.println("Removing index-1 element: " + list);

        list.remove("Orange");
        System.out.println("Removing element Orange: " + list);

        list.removeAll(List.of("Harsh", "Grapes"));
        System.out.println("Removing collection (Harsh, Grapes): " + list);

        list.clear();
        System.out.println("Clearing all elements: " + list);
    }

    static void accessingMethods(Vector<String> list) 
    {
        // Adding elements for demonstration
        list.addAll(List.of("Red", "Blue", "Green", "Yellow"));

        System.out.println("\nGet index-2 Element: " + list.get(2));

        System.out.println("First element: " + list.firstElement());

        System.out.println("Last element: " + list.lastElement());
    }

    static void modifyingMethods(Vector<String> list) 
    {
        list.set(0, "Blossom Pink");
        System.out.println("\nModifying index-0 element: " + list);
    }

    static void searchingMethods(Vector<String> list) 
    {
        list.addAll(List.of("Red", "Blue", "Green", "Yellow"));

        System.out.println("\nIs list contains 'Blue'? " + list.contains("Blue"));

        System.out.println("Index of 'Green': " + list.indexOf("Green"));

        System.out.println("Last index of 'Yellow': " + list.lastIndexOf("Yellow"));
    }

    static void iteratingMethods(Vector<String> list) 
    {
        System.out.println("\nIterating using Iterator:");
    
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\n\nIterating using ListIterator (both directions):");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) 
        {
            System.out.print(listIterator.next() + " ");
        }

        System.out.println("\nBackward iteration:");
        while (listIterator.hasPrevious()) 
        {
            System.out.print(listIterator.previous() + " ");
        }
    }

    static void capacityMethod(Vector<String> list) 
    {
        System.out.println("\n\nCapacity of vector: " + list.capacity());

        list.ensureCapacity(20);
        System.out.println("Capacity after ensuring capacity for 20: " + list.capacity());

        list.trimToSize();
        System.out.println("Capacity after trimming to size: " + list.capacity());
    }

    static void legacyMethod(Vector<String> list) 
    {
        list.addAll(List.of("A", "B", "C"));

        System.out.println("\nUsing legacy method 'elements':");
    
        Enumeration<String> enumeration = list.elements();
        while (enumeration.hasMoreElements()) 
        {
            System.out.print(enumeration.nextElement() + " ");
        }
    }

    public static void main(String[] args) {
        Vector<String> vect = new Vector<>();

        addingMethods(vect);

        removingMethods(vect);

        accessingMethods(vect);

        modifyingMethods(vect);

        searchingMethods(vect);

        iteratingMethods(vect);

        capacityMethod(vect);

        legacyMethod(vect);
    }
}
