/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Sorting Methods ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=========================================
(1) void sort(Comparator<? super E> c)
=========================================
-> Sorts the list according to the order induced by the specified comparator.
-> If the comparator is null, all elements must implement Comparable, and the list will be sorted in natural order.
-> Throws:
        ClassCastException - if the list contains elements that are not mutually comparable using the specified comparator.

        UnsupportedOperationException - if the list is unmodifiable.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Searching Methods ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=========================================
(1) int binarySearch(List<? extends T> list, T key)
=========================================
-> Searches the specified list for the specified object using the binary search algorithm.
-> The list must be sorted into ascending order.
-> Returns the index of the search key if it is contained in the list; otherwise, returns -(insertion point) - 1.
-> Throws:
        ClassCastException - if the list contains elements that cannot be compared to the search key.
    
        IllegalArgumentException - if the list is not sorted.
-> Note: This method is available in `Collections` class.


=========================================
(2) boolean contains(Object o)
=========================================
-> Returns 'true' if the list contains the specified element, otherwise 'false'.
-> Uses the equals() method to compare elements.
-> Throws:
    NullPointerException - if the specified element is null and the list does not permit null elements.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Comparision Methods ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=========================================
(1) boolean equals(Object o)
=========================================
-> Compares the specified object with this list for equality.
-> Returns 'true' if:
    -> the specified object is also a list,
    -> both lists have the same size,
    -> and all corresponding pairs of elements in the two lists are equal.
-> Throws:
    NullPointerException - if the compared object is null.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Capacity Methods ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=========================================
(1) int size()
=========================================
-> Returns the number of elements in the list.

=========================================
(2) boolean isEmpty()
=========================================
-> Returns 'true' if the list contains no elements, otherwise 'false'.


*/



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class p8_Querying
{
    // ------------- Sorting  methods ------------------
    public static void sortingMethods(ArrayList<String> list) 
    {
        System.out.println("\n~~~~~~~~~~~~~~~~ Sorting Methods ~~~~~~~~~~~~~~~~\n");

        System.out.println("Original List : " + list);
        list.sort(Comparator.reverseOrder());
        System.out.println("Sorted in reverse order: " + list);
    }
    

    // ------------- Searching methods ------------------
    public static void searchingMethods(ArrayList<String> list) 
    {
        System.out.println("\n~~~~~~~~~~~~~~~~ Searching Methods ~~~~~~~~~~~~~~~~\n");

        // Using contains() method
        System.out.println("List contains Apple : " + list.contains("Apple"));


        // ---------------------------------------------------------------------------------
        // Binary search (only works if the list is sorted in ascending order)
        Collections.sort(list);  // Sorting in ascending order for binary search
        // ---------------------------------------------------------------------------------
        
        System.out.println("Sorted List for Binary Search : " + list);
        int index = Collections.binarySearch(list, "Orange");
        System.out.println("Index of 'Orange' using binarySearch : " + index);
    }
    
    
    
    // ------------- Comparision methods ------------------
    public static void comparisonMethods(ArrayList<String> list1, ArrayList<String> list2) 
    {
        System.out.println("\n~~~~~~~~~~~~~~~~ Comparison Methods ~~~~~~~~~~~~~~~~\n");
        
        // Using equals() method
        System.out.println("List1 equals to List2 ? :  " + list1.equals(list2));
    }
    
    
    
    // ------------- Capacity methods ------------------
    public static void capacityMethods(ArrayList<String> list) 
    {
        System.out.println("\n~~~~~~~~~~~~~~~~ Capacity Methods ~~~~~~~~~~~~~~~~\n");

        // Using size() method
        System.out.println("Size of the list : " + list.size());

        // Using isEmpty() method
        System.out.println("List is Empty ? : " + list.isEmpty());
    }


    // main method 
    public static void main(String[] args) 
    {
        // Creating an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("Banana");
        list.add("Grapes");

        
        // Demonstrating Sorting Methods
        sortingMethods(list);

        // Demonstrating Searching Methods
        searchingMethods(list);

        // Creating a second list for comparison
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Apple");
        list2.add("Orange");
        list2.add("Banana");
        list2.add("Grapes");

        // Demonstrating Comparison Methods
        comparisonMethods(list, list2);

        // Demonstrating Capacity Methods
        capacityMethods(list);
    }
}
