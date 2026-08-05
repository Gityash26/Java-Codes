/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Map Interface =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                               Map Interface
            ________________________|__________________________________________
            |                       |                   |                      |
       ------------          ----------------     -------------         ----------------
       | HashMap |          | LinkedHashMap |     | Hashtable |         |  SortedMap   |
       ------------          ----------------     -------------         ----------------
       (Unordered)           (Insertion Order)     (Thread Safe)                |
       (Hash Table)      (Hash Table + LinkedList) (Hash Table)          ----------------
                                                                       |    TreeMap     |
                                                                       ----------------
                                                                       (Sorted Order)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Hashtable =================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Hashtable is a legacy implemented class of the Map interface.

-> It is present in the java.util package.

-> Hashtable stores data in the form of key-value pairs.

-> It uses Hashing internally to store and retrieve entries.

-> Hashtable was introduced to provide thread-safe key-value storage.

-> Every public method of Hashtable is synchronized, making it safe to use in multi-threaded environments.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Syntax ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Hashtable<K, V> table = new Hashtable<>();

Where,

K -> Type of Key
V -> Type of Value



Example

Hashtable<Integer, String> table = new Hashtable<>();

Hashtable<String, Double> table = new Hashtable<>();




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Internal Representation ==========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                            Hash Function

        (Key, Value)
              │
              ▼
        +-------------+
        | hashCode()  |
        +-------------+
              │
              ▼
        Bucket Index
              │
              ▼
        +-------------------+
        | Bucket 0          |
        | Bucket 1          |
        | Bucket 2          |
        | Bucket 3          |
        +-------------------+

Hashtable uses Hashing to calculate the bucket where an entry should be stored.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Properties ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

------------------------------------------------------------
(1) Key-Value Collection
------------------------------------------------------------
    Stores data in the form of key-value pairs.



------------------------------------------------------------
(2) Thread Safe
------------------------------------------------------------
    All public methods are synchronized.
    Multiple threads cannot modify the Hashtable simultaneously.

    
------------------------------------------------------------
(3) No Null Key
------------------------------------------------------------
    Hashtable does not allow a null key.

    Attempting to insert a null key throws
        ==> NullPointerException


------------------------------------------------------------
(4) No Null Value
------------------------------------------------------------
    Hashtable does not allow null values.

    Attempting to insert a null value throws
        => NullPointerException


------------------------------------------------------------
(5) Unordered Collection
------------------------------------------------------------
    Hashtable does not maintain insertion order.
    Entries are stored according to hashing.


------------------------------------------------------------
(6) Uses Hashing
------------------------------------------------------------
    Hashtable uses hashCode() and equals() to determine the storage location of keys.




------------------------------------------------------------
(7) Performance
------------------------------------------------------------
    Average Time Complexity

    put()      O(1)

    get()      O(1)

    remove()   O(1)

    Due to synchronization, Hashtable is generally slower than HashMap.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== HashMap vs Hashtable =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

+----------------------+-------------------------+---------------------------+
| Feature              | HashMap                 | Hashtable                 |
+----------------------+-------------------------+---------------------------+
| Thread Safe          | No                      | Yes                       |
| Synchronization      | No                      | Yes                       |
| Null Key             | One Allowed             | Not Allowed               |
| Null Values          | Multiple Allowed        | Not Allowed               |
| Performance          | Faster                  | Slightly Slower           |
| Introduced In        | JDK 1.2                | JDK 1.0 (Legacy)          |
+----------------------+-------------------------+---------------------------+




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Constructors ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Hashtable()

    Creates an empty Hashtable with default capacity and load factor.

------------------------------------------------------------

(2) Hashtable(int initialCapacity)

    Creates an empty Hashtable with the specified initial capacity.

------------------------------------------------------------

(3) Hashtable(int initialCapacity, float loadFactor)

    Creates an empty Hashtable with specified initial capacity and load factor.

------------------------------------------------------------


(4) Hashtable(Map<K,V> m)

    Creates a Hashtable containing all mappings from the specified Map.

------------------------------------------------------------
*/

import java.util.Hashtable;

public class p2_IntroHashtable
{
    public static void main(String[] args)
    {

        // Default Constructor
        Hashtable<Integer,String> table1 = new Hashtable<>();

        table1.put(101,"Rahul");
        table1.put(102,"Amit");


        // Initial Capacity

        Hashtable<Integer,String> table2 = new Hashtable<>(20);

        table2.put(103,"Neha") ;
        table2.put(104,"Rohan");


        // Initial Capacity + Load Factor

        Hashtable<Integer,String> table3 =
                new Hashtable<>(15,0.75f);

        table3.put(105,"Vikas");


        // Constructor using another Map

        Hashtable<Integer,String> table4 =
                new Hashtable<>(table1);



        System.out.println("\nDefault Constructor");
        System.out.println(table1);


        System.out.println("\nInitial Capacity");
        System.out.println(table2);


        System.out.println("\nCapacity + Load Factor");
        System.out.println(table3);


        System.out.println("\nUsing Another Map");
        System.out.println(table4);

    }

}