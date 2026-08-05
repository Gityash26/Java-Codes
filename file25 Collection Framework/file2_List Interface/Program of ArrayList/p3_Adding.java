/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Adding Elements ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> When we add a element in the ArrayList following steps are followed internally:

Step1: Check Capacity
       Before adding a new element, ArrayList checks if there is enough space available in the internal array.
       If the array is full, it need to be resized.

Step2: Resize if necessary
       If teh internal array of ArrayList is full, It creates a new array with larger capacity (usually 1.5 times of teh ccurrent array)
       and copy teh elements from the old array to the new array.

Step3: Add the element
       The new element is then added in the internal array at appropriate index, and the size incremented by 1.



--------------------- Methods --------------------------------

(1) boolean add(Element e)
=========================================
->  It is used to insert a single element object at the end of the list 


(2) void add(int index , Object ob)
=========================================
    -> Insert a speified Element at the specific Index 


(3) boolean addAll(Collection c)
=========================================
    -> Appends all of the elements of a specified collection at the end of this list. 


(4) boolean addAll(int index , Collection c)
=========================================
    -> Appends all of the elements of a specified collection at the specific index of the list. 


(5) void addFirst(Element e)
=========================================
    -> Indert a speified Element at the front of the list 


(6) void addLast(Element e)
=========================================
    -> Indert a speified Element at the Last 

*/

import java.util.ArrayList;
import java.util.Arrays;

public class p3_Adding
{

    public static void addElement(ArrayList<String> list)
    {
        // ---------------------------------------- adding single element        
        list.add("Hello");
        System.out.println("\nList after adding 'Hello' : ");
        
        
        // ---------------------------------------- adding single element at index
        list.add(0, "World");
        System.out.println("List after adding 'world' at index 0 : ");
        

        // ---------------------------------------- adding element at starting         
        list.addFirst("Kunal");
        System.out.println("List after adding 'kunal' at first : ");
        
        
        // ---------------------------------------- adding element at ending
        list.addLast("Sachin");
        System.out.println("List after adding 'Sachin' at first : ");
        
    }
    
    public static void addCollection(ArrayList<String> list)
    {
        // Cretaing another collection to add 
        // ==============================================================================
        String[] arr1 = {"Apple", "Orange", "Grapes"};
        String[] arr2 = {"Student1", "Student2", "Student3"};
        
        System.out.println("\nExisting Collection 1 : " + Arrays.asList(arr1));
        System.out.println("Existing Collection 2 : " + Arrays.asList(arr2));
        System.out.println("Our ArrayList : " + list);
        // ==============================================================================
        
        
        // ---------------------------------------- adding collection
        System.out.println("\nAdding collection1 directly...");
        
        list.addAll(Arrays.asList(arr1));
        System.out.println(list);
        
        
        // ---------------------------------------- adding collection at index
        System.out.println("\nAdding collection2 at index 2...");
        
        list.addAll(2, Arrays.asList(arr1));
        System.out.println(list);
    }

    public static void main(String[] args) 
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~ Adding Methods ~~~~~~~~~~~~~~~~~~~~~\n");    

        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<String> l2 = new ArrayList<>();

        addElement(l1);
        addCollection(l2);
    }
}