/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================== What is CopyOnWriteArrayList ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> CopyOnWriteArrayList is not a part of Collection Framework. But it is a part of concurrent package.

-> It is a thread safe version of ArrayList in which all mutative operations (add, set, and so on) 
   are implemented by making a fresh copy of the underlying array.

Note: 
=> ArrayList and LinkedList are not synchronized. So, they are not thread safe.
=> Stack and Vector are synchronized so, they are suitable for multi-threaded environment. But make the performance slow
   due to locking mechanism.

-> That's why CopyOnWriteArrayList is better option where read operations are more frequent than write operations.
   So, that read operations can be concurrently performed without any locking mechanism and write operations are performed
    by making a fresh copy of the underlying array and then updating the reference.



==================================
 Key Points:
==================================

(1) Thread-Safety: 
    It is designed for use in multi-threaded environments without requiring explicit synchronization.

(2) Copy-On-Write Mechanism: 
     Whenever a modification is made (e.g., adding or removing an element), it creates a new copy of the 
     underlying array, ensuring thread safety without locks.

(3) Iterators: 
    Iterators over a CopyOnWriteArrayList reflect the state of the list at the time they were created and 
    are not affected by modifications to the list after the iterator is created.


Example: A group of friends reading from a shared list of books. 
         They can read the books concurrently without any synchronization. 
         But if someone wants to add or remove something in the book, a new copy of the noteBook is created, 
         and the modification is made to the new list. 
         The reference to the new list is then updated, and the original list remains unchanged. 


*/

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class p1_IntroToCopyOnWrite 
{
    public static void main(String[] args) 
    {
        // Shopiing list of ArrayList
        // List<String> list = new ArrayList<>();  // throws cuncurrentModificationException
        
        
        // Shopiing list of CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<>();  // throws cuncurrentModificationException
        
        
        list.add("Egg");
        list.add("Milk");
        list.add("Rice");
        list.add("flour");


        // Reading shoping list 
        for(String item : list)
        {
            System.out.println(item);

            // Trying to midifying while reading the list
            if(item.equals("Egg"))
            {
                list.add("Butter");
                System.out.println("=> Butter added");
            }
        }

        System.out.println("\nFinal list: " + list);
    }
}
