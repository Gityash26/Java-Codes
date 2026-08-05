/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============= (1) Linked List Methods ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

==== Adding Elements ===============
=====================================

(1) boolean add(E e): Appends the specified element to the end of the list.

(2) void add(int index, E element): Inserts the specified element at the specified position in the list.

(3) boolean addAll(Collection<? extends E> c): Appends all of the elements in the specified collection to the end of the list.

(4) boolean addAll(int index, Collection<? extends E> c): Inserts all of the elements in the specified collection into this list at the specified position.


==== Removing Elements ===============
=====================================

(1) E remove(int index): Removes the element at the specified position in the list.

(2) boolean remove(Object o): Removes the first occurrence of the specified element from the list, if it is present.

(3) boolean removeAll(Collection<?> c): Removes from the list all of its elements that are contained in the specified collection.

(4) void clear(): Removes all elements from the list.

(5) removeIf(val -> val%2==0)


==== Retrieving Elements ===============
=====================================

(1) E get(int index): Returns the element at the specified position in the list.

(2) int indexOf(Object o): Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.

(3) int lastIndexOf(Object o): Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.

(4) List<E> subList(int fromIndex, int toIndex): Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.


==== Search Elements ===============
=====================================

(1) boolean contains(Object o): Returns true if the list contains the specified element.

(2) boolean containsAll(Collection<?> c): Returns true if the list contains all of the elements in the specified collection.


==== Query Elements ===============
=====================================

(1) boolean equals(Object o): Compares the specified object with this list for equality.

(2) int size(): Returns the number of elements in the list.

(3) boolean isEmpty(): Returns true if the list contains no elements.


==== Converting to Array ===============
=====================================

(1) Object[] toArray(): Returns an array containing all of the elements in the list in proper sequence.

(2) <T> T[] toArray(T[] a): Returns an array containing all of the elements in the list in proper sequence;
                            the runtime type of the returned array is that of the specified array.




*/

import java.util.Arrays;
import java.util.LinkedList;

public class p3_MethodsType1 
{
    static void addingMethods(LinkedList<String> list) 
    {
        System.out.println("\n-------------------------- Adding Methods ------------------------------------\n");

        list.add("Yash");
        list.add("Harish");
        list.add("Manish");
        System.out.println("Initial list after adding single elements: " + list);

        list.add(2, "Harshita");
        System.out.println("After adding 'Harshita' at index 2: " + list);

        list.addAll(Arrays.asList("Sanjay", "Kunal"));
        System.out.println("After adding a collection of elements: " + list);

        list.addAll(1, Arrays.asList("Manisha", "Sunita"));
        System.out.println("After adding a collection of elements at index 1: " + list);
    }

    static void removingMethods(LinkedList<String> list) 
    {
        System.out.println("\n-------------------------- Removing Methods ----------------------------------\n");

        list.remove(0);
        System.out.println("After removing element at index 0: " + list);

        list.remove("Kunal");
        System.out.println("After removing 'Kunal': " + list);

        list.removeAll(Arrays.asList("Manisha", "Sunita"));
        System.out.println("After removing the collection ('Manisha', 'Sunita'): " + list);

        list.clear();
        System.out.println("After clearing all elements from the list: " + list);
    }

    static void retrievingMethods(LinkedList<String> list) 
    {
        System.out.println("\n-------------------------- Retrieving Methods --------------------------------\n");

        list.addAll(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("Initial list: " + list);

        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("Index of element 'C': " + list.indexOf("C"));
        System.out.println("Last index of element 'C': " + list.lastIndexOf("C"));

        System.out.println("Sublist from index 1 to 4: " + list.subList(1, 4));
    }

    static void searchMethods(LinkedList<String> list) 
    {
        System.out.println("\n-------------------------- Search Methods ------------------------------------\n");

        System.out.println("Does the list contain 'B'? " + list.contains("B"));
        System.out.println("Does the list contain all elements ['A', 'C']? " + list.containsAll(Arrays.asList("A", "C")));
    }

    static void queryingMethods(LinkedList<String> list) 
    {
        System.out.println("\n-------------------------- Querying Methods ----------------------------------\n");

        System.out.println("Size of the list: " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());

        LinkedList<String> anotherList = new LinkedList<>(list);
        System.out.println("Is the list equal to another list with the same elements? " + list.equals(anotherList));
    }

    static void convertToArrayMethods(LinkedList<String> list) 
    {
        System.out.println("\n-------------------------- Convert to Array Methods --------------------------\n");

        Object[] array = list.toArray();
        System.out.println("List converted to Object array: " + Arrays.toString(array));

        String[] stringArray = list.toArray(new String[0]);
        System.out.println("List converted to String array: " + Arrays.toString(stringArray));
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        addingMethods(list);
        removingMethods(list);

        // Adding sample data for further operation
        list.addAll(Arrays.asList("A", "B", "C", "D", "E"));

        retrievingMethods(list);
        searchMethods(list);
        queryingMethods(list);
        convertToArrayMethods(list);
    }
}
