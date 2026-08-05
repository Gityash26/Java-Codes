/*

=========================================
(1) Element get(int index)
=========================================
-> Retrieves the element at the specified position (index) in the list.
-> Returns the element at the specified index.
-> Throws:
            IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size()).


=========================================
(2) int indexOf(Element e)
=========================================
-> Returns the index of the first occurrence of the specified element in the list.
-> Returns -1 if the element is not found.
-> Throws:
            NullPointerException - if the specified element is null and the list does not allow null elements.


=========================================
(3) int lastIndexOf(Object o)
=========================================
-> Returns the index of the last occurrence of the specified element in the list.
-> Returns -1 if the element is not found.
-> Throws:
            NullPointerException - if the specified element is null and the list does not allow null elements.


=========================================
(4) List subList(int fromIndex, int toIndex)
=========================================
-> Returns a portion of this list between the specified fromIndex (inclusive) and toIndex (exclusive).
-> Returns a List that contains the elements in the specified range.
-> Throws:
            IndexOutOfBoundsException - if the fromIndex or toIndex is out of range 
                                        (fromIndex < 0 || toIndex > size || fromIndex > toIndex).


=========================================
(5) boolean contains(Object o)
=========================================
-> Returns 'true' if the list contains the specified element.
-> Returns 'false' if the element is not present in the list.
-> Throws:
            NullPointerException - if the specified element is null and the list does not allow null elements.


=========================================
(6) Object[] toArray()
=========================================
-> Returns an array containing all of the elements in the list in proper sequence (from first to last element).
-> The returned array will be "safe", as it does not affect the list.


=========================================
(7) <T> T[] toArray(T[] a)
=========================================
-> Returns an array containing all of the elements in the list in the proper order, the runtime type of the returned array is that of the specified array.
-> If the list fits in the specified array, it is returned therein.
-> If the list is larger than the specified array, a new array of the same runtime type is allocated for this purpose.

*/



import java.util.ArrayList;
import java.util.Arrays;

public class p5_Retrieving 
{

    public static void retrieveElements(ArrayList<String> list) 
    {
        // ~~~~~~~~~ Retrieve element by index ~~~~~~~~~
        System.out.println("\nRetrieving element at index 2...");
        System.out.println("Element: " + list.get(2));
        // ------------------------------------------------

        // ~~~~~~~~~ Find index of the first occurrence ~~~~~~~~~
        System.out.println("\nFinding index of 'Orange'...");
        System.out.println("Index: " + list.indexOf("Orange"));
        // ------------------------------------------------

        // ~~~~~~~~~ Find index of the last occurrence ~~~~~~~~~
        System.out.println("\nFinding last index of 'Apple'...");
        System.out.println("Last Index: " + list.lastIndexOf("Apple"));
        // ------------------------------------------------

        // ~~~~~~~~~ Create a sublist from the list ~~~~~~~~~
        System.out.println("\nCreating sublist from index 1 to 3...");
        System.out.println("Sublist: " + list.subList(1, 3));
        // ------------------------------------------------

        // ~~~~~~~~~ Check if list contains a specific element ~~~~~~~~~
        System.out.println("\nChecking if list contains 'Banana'...");
        System.out.println("Contains 'Banana': " + list.contains("Banana"));
        // ------------------------------------------------

        // ~~~~~~~~~ Convert list to array ~~~~~~~~~
        System.out.println("\nConverting list to an array...");
        Object[] array = list.toArray();
        System.out.println("Array: " + Arrays.toString(array));
        // ------------------------------------------------
        
        String[] stringArray = list.toArray(new String[0]);
        System.out.println("String Array: " + Arrays.toString(stringArray));
    }

    public static void main(String[] args) 
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~ Retrieving Methods ~~~~~~~~~~~~~~~~~~~~~\n");    

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Grapes", "Orange", "Strawberry"));
        System.out.println("Original List: " + list);

        retrieveElements(list);
    }
}