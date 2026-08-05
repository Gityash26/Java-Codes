/*

                               Map Interface
            ________________________|_________________________________
           |                        |                                |
      HashMap                   LinkedHashMap                    SortedMap
                              (Insertion order)                     |
                                                                 TreeMap
            
            

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== LinkedHashMap =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> LinkedHashMap is an implemented class of the 'Map' interface in the Java
   Collection Framework.

-> It is present in the java.util package.

-> LinkedHashMap is a direct subclass of HashMap.

-> It stores data in the form of 'key-value' pairs.

-> LinkedHashMap maintains the insertion order of the elements.

-> Internally it uses both:
      1. Hash Table
      2. Doubly Linked List

-> The Hash Table provides fast lookup while the Doubly Linked List maintains
   the insertion order of entries.

-> Since LinkedHashMap extends HashMap, almost all methods available in
   HashMap are also available in LinkedHashMap.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Syntax ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

LinkedHashMap<K, V> map = new LinkedHashMap<>();

=> K = Key
=> V = Value

Examples:

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        LinkedHashMap<String, Integer> marks = new LinkedHashMap<>();

        LinkedHashMap<Character, Double> data = new LinkedHashMap<>();



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Internal Representation =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                    Hash Table

                        │
                        ▼

        ______________________________________

        Bucket -----> [A] ⇄ [B] ⇄ [C] ⇄ [D]

        ______________________________________

Each Node contains:

        hash
        key
        value
        next
        before
        after

where,

next   -> Used for bucket chaining

before -> Previous entry

after  -> Next entry

Hence every entry is connected through a Doubly Linked List,
which preserves insertion order.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Properties ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Maintains Insertion Order

    => Elements are retrieved in the same order in which they were inserted.


(2) Unique Keys

    => Duplicate keys are not allowed.
    => If an existing key is inserted again, only its associated value is updated.


(3) Null Keys and Values

    => Allows only one null key.
    => Allows multiple null values.


(4) Not Synchronized

    => LinkedHashMap is not thread-safe.


(5) Fast Performance

    Average Time Complexity

        put()      -> O(1)

        get()      -> O(1)

        remove()   -> O(1)

(6) Uses Hashing

    => Uses hashCode() and equals() methods of the key object.


(7) Maintains Order

    => Unlike HashMap, iteration always follows insertion order.


(8) Slightly More Memory

    => Requires extra memory because each node stores two additional
    references (before & after).



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== HashMap vs LinkedHashMap ============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


                           HashMap                  LinkedHashMap
|===================================================================================|
|   Order           |    No Order         |     Insertion Order                     |
|-------------------|---------------------|-----------------------------------------|
|   Data Structure  |   Hash Table        |     Hash Table + Doubly Linked List     |
|-------------------|---------------------|-----------------------------------------|
|   Performance     |   Slightly Faster   |     Slightly Slower                     |
|-------------------|---------------------|-----------------------------------------|
|   Memory          |   Less              |     More                                |
|-------------------|---------------------|-----------------------------------------|
|   Iteration       |   Random            |     Predictable                         |
|-------------------|---------------------|-----------------------------------------|
|   Null Key        |   One               |     One                                 |
|-------------------|---------------------|-----------------------------------------|
|   Null Values     |   Multiple          |     Multiple                            |
|===================|=====================|=========================================|



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Applications ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=> Cache Implementation

=> Maintaining insertion order

=> Configuration Storage

=> Recently Visited Pages

=> LRU Cache

=> Student Records

=> Employee Records

=> Ordered Dictionary



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Constructors ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) LinkedHashMap()
    Creates an empty LinkedHashMap with default capacity = 16 and default load factor = 0.75


(2) LinkedHashMap(int initialCapacity)
    Creates an empty LinkedHashMap with specified capacity.


(3) LinkedHashMap(int initialCapacity, float loadFactor)
    Creates an empty LinkedHashMap with specified capacity and load factor.


(4) LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
    Creates a LinkedHashMap whose iteration order is 
    
    => false -> Insertion Order (Default)
    => true  -> Access Order


(5) LinkedHashMap(Map<? extends K, ? extends V> m)
    Creates a LinkedHashMap containing all mappings from the specified Map.

*/

import java.util.LinkedHashMap;

public class p1_IntroToLinkedHashMap 
{

    public static void main(String[] args) 
    {

        // Default Constructor
        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(101, "Java");
        map1.put(102, "Python");
        map1.put(103, "C++");


        // Constructor with Initial Capacity
        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>(10);
        map2.put(1, "One");
        map2.put(2, "Two");


        // Constructor with Initial Capacity and Load Factor
        LinkedHashMap<Integer, String> map3 = new LinkedHashMap<>(5, 0.75f);
        map3.put(11, "Eleven");
        map3.put(12, "Twelve");

        
        // Constructor with another Map
        LinkedHashMap<Integer, String> map4 = new LinkedHashMap<>(map1);

        System.out.println("Default Constructor");
        System.out.println(map1);

        System.out.println("\nInitial Capacity Constructor");
        System.out.println(map2);

        System.out.println("\nCapacity + LoadFactor Constructor");
        System.out.println(map3);

        System.out.println("\nCopy Constructor");
        System.out.println(map4);

        System.out.println("\nInsertion Order Maintained");

        map1.put(104, "Spring");
        map1.put(105, "Hibernate");

        System.out.println(map1);
    }
}