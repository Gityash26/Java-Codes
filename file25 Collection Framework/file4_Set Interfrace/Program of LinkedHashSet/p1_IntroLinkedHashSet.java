/* 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Introduction to LinkedHashSet =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> A LinkedHashSet is the second implemented class of Set interfrace.
-> Unlike (HashSet that uses HashTable for storing of elements) 'LinkedHashSet' maintains a "doubly-linked list" across its entries to preserve the order of insertion.
-> Like HashSet, it also does not allow duplicate elements.
-> It is part of the java.util package.
-> It is not synchronized, so it is not thread-safe.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Key Points of LinkedHashSet ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Underlying Data Structure => Combines HashTable (for fast lookup) and Doubly Linked List (for order maintenance).

(2) Unique Elements => Ensures all elements are unique (no duplicates).

(3) Ordered Collection => Preserves the insertion order of elements.

(4) Null Value => Allows only one null value.

(5) Inheritance => LinkedHashSet extends HashSet class.

(6) Performance => Slightly slower than HashSet due to the overhead of maintaining insertion order.

(7) Thread Safety => Not thread-safe. To use in multithreading, it must be synchronized externally.

(8) Load Factor => The default load factor of HashSet is 0.75.

(9) Initial Capacity => The default initial capacity of LinkedHashSet is 16.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Why LinkedHashSet After HashSet? ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--------------------------------
 HashSet Limitation:
--------------------------------
- Un-ordered collection of elemnets
- Not suitable for applciations where insertion order required

--------------------------------
LinkedHashSet:
--------------------------------
    - Provides all the features of HashSet along with order preservation.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== How LinkedHashSet Works ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Internally, LinkedHashSet uses a combination of HashTable (via HashSet) and a Doubly Linked List.

-> The hash table ensures fast access time for operations like add, remove, and contains.

-> The linked list maintains the insertion order by linking elements sequentially.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Storage Mechanism ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> LinkedHashSet uses both the "hashing" to store elements like HashSet but also maintains a "linked list".

=> It links the elements sequentially in the order they are inserted.



(1) Doubly Linked List         
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

 head <-> [Element1] <-> [Element1] <-> [Element1] <-> [Element1] <-> tail 



(2) HashTable
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 
    +--------------------+-----------------+
    |       Key          |      Value     |
    +--------------------+-----------------+
    |    Element1        |      null      |
    |    Element2        |      null      |
    |    Element3        |      null      |
    |    Element4        |      null      |
    +--------------------+-----------------+



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Constructors of LinkedHashSet =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) LinkedHashSet():
    Creates a default empty LinkedHashSet with initial capacity 16 and load factor 0.75.

(2) LinkedHashSet(int initialCapacity):
    Creates an empty LinkedHashSet with specified initial capacity.

(3) LinkedHashSet(int initialCapacity, float loadFactor):
    Creates an empty LinkedHashSet with specified initial capacity and load factor.

(4) LinkedHashSet(Collection c):
    Creates a LinkedHashSet containing elements of the specified collection.


*/

// implements both HashSet and DoublyLinkedList 
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Arrays;

public class p1_IntroLinkedHashSet 
{
    public static void main(String[] args) 
    {
        // default capacity (16) and load factor (0.75)
        LinkedHashSet<Integer> hash1 = new LinkedHashSet<>();

        // specified initial capacity
        LinkedHashSet<Integer> hash2 = new LinkedHashSet<>(10);
        
        // specified initial capacity & load factor
        LinkedHashSet<Integer> hash3 = new LinkedHashSet<>(20, 0.6f);
        
        // initilized with elemnets from a collection 
        LinkedHashSet<Integer> hash4 = new LinkedHashSet<>(List.of(34, 24, 14, 64, 54));


        // adding new elements 
        hash1.addAll(Arrays.asList(2, 3, 4, 5, 6, 7));
        hash2.addAll(Arrays.asList(1, 4, 7, 9, 12));
        hash3.addAll(Arrays.asList(23, 45, 67, 98, 26));


          // Display the hashSets
          System.out.println("HashSet 1 -> " + hash1);
          System.out.println("HashSet 2 -> " + hash2);
          System.out.println("HashSet 3 -> " + hash3);
          System.out.println("HashSet 4 -> " + hash4);
  

    }    
}
