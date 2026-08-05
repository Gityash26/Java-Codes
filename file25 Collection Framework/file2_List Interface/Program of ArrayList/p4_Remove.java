/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------------- Removing Elements ----------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Following steps are followed for removing a elements

Step1: Check Bounds: 
       The ArrayList first checks if the index is within teh valid range.

Step2: Remove the Element: 
       The element is then removed, and all the elements at the right side shifted one position to the left.

Step3: Reduce size:
       The size is decremented by 1



::::::::::::::::::: Methods :::::::::::::::::::::::::::

(1) boolean remove(Element e)
=========================================
-> Removes the first occurrence of the specified element from the list, if it is present.


(2) Element remove(int index)
=========================================
-> Removes the element at the specified index position in the list.


---------------------------------------------------------------
Question: Don't you think remove(index) , remove(object) becomes confusing with a Integer type ArrayList.
          Yes, by default JDK consider it as 'Index' to remove element
          Thats'why we have to typecast it into Object type
---------------------------------------------------------------


(3) boolean removeAll(Collection c)
=========================================
-> Removes all elements from the list that are contained in the specified collection.


(4) boolean removeIf(Predicate filter)
=========================================
-> Removes all elements of the list that satisfy the given predicate.


(5) void clear()
=========================================
-> Removes all elements from the list, leaving it empty.

*/


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class p4_Remove 
{
    
    public static void removeElements(ArrayList<String> list) 
    {
        // ------------------------------------- Removing single element
        list.remove("Apple");
        System.out.println("\nRemoving apple : " + list);

        
        // ------------------------------------- Removing single element at index
        list.remove(1);
        System.out.println("Removing element at index 1 : " + list);
  
        
        // ------------------------------------------------------------ Removing collection
        list.removeAll(Arrays.asList("Banana", "Grapes"));
        System.out.println("Removing collection (Banana, Grapes) : " + list);

        
        // ------------------------------------------------------------ Removing collection at index
        list.removeIf(val -> val.startsWith("S"));
        System.out.println("Removing elements starts with 'S' : " + list);
        

        // ------------------------ clear all elements
        list.clear();
        System.out.println("Clearing all elements : " + list);
        // ------------------------------------------------
    }

    public static void main(String[] args) 
    {
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~ Removing Methods ~~~~~~~~~~~~~~~~~~~~~\n");    

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Grapes", "Orange", "Strawberry", "Kiwi"));
        System.out.println("Original List: \n" + list);

        removeElements(list);


        // -----------------------------------
        // remove(index) and remove(Object)
        // -----------------------------------

        ArrayList<Integer> myList = new ArrayList<>(List.of(1, 3, 5, 7, 9));
        
        // myList.remove(1); // consider 1 as Index (Not Object)

        myList.remove(Integer.valueOf(1));   // int -------> Integer

    }
}
