/*
=========================================
(1) Object set(int index, E element)
=========================================
-> Replaces the element at the specified position in the list with the specified element.
-> Returns the element previously at the specified position.
-> Throws:
    IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size()).

=========================================
(2) void replaceAll(UnaryOperator<E> operator)
=========================================
-> Replaces each element of this list with the result of applying the given operator to that element.
-> The operator is a function that applies a transformation to each element.
-> Throws:
    NullPointerException - if the operator is null.

=========================================
(3) boolean retainAll(Collection<?> c)
=========================================
-> Retains only the elements in this list that are contained in the specified collection.
-> Removes all elements not in the specified collection from this list.
-> Returns true if the list was modified as a result of the operation, otherwise false.
-> Throws:
    NullPointerException - if the specified collection is null.
*/

import java.util.ArrayList;
import java.util.Arrays;


public class p7_modifying 
{

    public static void modifyUsingSet(ArrayList<String> list) 
    {
        // ~~~~~~~~~ Modifying element at a specific index using set method ~~~~~~~~~
        System.out.println("\nModifying element at index 2 (replacing 'Grapes' with 'Pineapple')...");
        list.set(2, "Pineapple");
        System.out.println("Modified List: " + list);
        // ------------------------------------------------
    }

    public static void modifyUsingReplaceAll(ArrayList<String> list) 
    {
        // ~~~~~~~~~ Modifying elements using replaceAll ~~~~~~~~~
        System.out.println("\nModifying all elements using replaceAll (converting to uppercase)...");
        list.replaceAll((String element) -> element.toUpperCase());
        System.out.println("Modified List: " + list);
        // ------------------------------------------------
    }

    public static void modifyUsingRetainAll(ArrayList<String> list) 
    {
        // ~~~~~~~~~ Retaining only specific elements using retainAll ~~~~~~~~~
        System.out.println("\nRetaining only 'APPLE' and 'PINEAPPLE'...");
        ArrayList<String> toRetain = new ArrayList<>(Arrays.asList("APPLE", "PINEAPPLE"));
        list.retainAll(toRetain);
        System.out.println("Modified List: " + list);
        // ------------------------------------------------
    }

    public static void main(String[] args) {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~ Modifying Methods ~~~~~~~~~~~~~~~~~~~~~\n");

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Grapes", "Orange", "Strawberry"));

        modifyUsingSet(list);
        modifyUsingReplaceAll(list);
        modifyUsingRetainAll(list);
    }
}
