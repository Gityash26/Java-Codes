/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============= LinkedHashSet Doubly LinkedList method =================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) addFirst method: Add element at starting
(2) addLast method: Add element at last 

(3) removeFirst method: Remove first elemnet 
(4) removeLast method: Remove last element

(5) getFirst method: retrieve first elemnet
(6) getLast method: retrieve last element


*/

import java.util.LinkedHashSet;
import java.util.List;

public class p2_LHSDoublyMethod 
{
    static void displayMethods(LinkedHashSet<String> hash)
    {
        // add element at first & Last 
        hash.addFirst("Yash");
        System.out.println("\nAdding yash at first : " + hash);

        hash.addLast("sanjay");
        System.out.println("Adding sanjay at last : " + hash);

        // getting first and last element 
        System.out.println("\nGetting first element : " + hash.getFirst());
        System.out.println("Getting last element : " + hash.getLast());
        
        // removing first and last element 
        System.out.println("\nRemoving first element : " + hash.removeFirst());
        System.out.println("Removing last element : " + hash.removeLast());
    }

    public static void main(String[] args) 
    {
        LinkedHashSet<String> hash = new LinkedHashSet<>(List.of("sample1", "sample2", "sample3", "sample4"));    
        displayMethods(hash);
    }    
}
