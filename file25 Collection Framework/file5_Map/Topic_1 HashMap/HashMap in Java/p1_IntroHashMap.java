/* 

                               Map Interface
            ________________________|_________________________________
            |                       |                                |
       ----------           ------------------                 ---------------
       | HashMap |          | LinkedHashmap |                  |    SortedMap |
       ----------           ------------------                 ---------------
        (unordered)           (Insertion order)                         |
        (uses HashTable)      (HashTable & LinkedList)        ----------------
                                                              |     TreeMap  |
                                                              ---------------
                                                                (Sorted order)
                                                                (uses tree data structure)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================= HashMap ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> HashMap is an implemented class of the 'Map interface' in Java Collection framework.
-> It is present in the java.util package

-> Hash is used to store the collection of objects in the form of 'key-value' pairs.

-> HashMap uses underlying data structure "Hash Table" to store the unique key.

-> It is widely used for 'fast lookup' and 'effective storage' where a 'unique key' is mapped
   with the specified 'value'.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================= Syntax ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap<K, V> map = new HashMap<>();

=> 'K' stands for key
=> 'V' stands for value

example: 
            HashMap <int, int> map = new HashMap<>();

            HashMap <int, String> map = new HashMap<>();


Note: we can use any datatype for key and value.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================= Representation ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                              HashTable
                       ______________       ______________
                      |             |      |_____________|
  (key, value) =====> |Hash function| ===> |_k1_|_value1_|
                      |_____________|      |_k2_|_value2_| 
                                           |_k3_|_value3_|

                                              


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================= Properties of HashMap ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Un-ordered Collection:
    HashMap does not follow any insertion order of objects becuase of Hashing.

(2) Unique keys:
    Duplicates keys are not allowed, if same key with another value inserted then it overrides the 
    previous associated value.

(3) Null keys and Values:
    Allows only one null key
    Allows multiple null values

(4) Not synchronized:
    hashMap methods are not synchronized therefore not thread-safe.

(5) Peformance:
    HashMap provides an avarage time complexity of O(1) for the operation like 'put', 'get' & 'remove'.
    This performance is achieved using Hashing to store and retrieve the Objects.

(6) Uses hashing mechanism:
    Hashmap uses the hashcode() and equals methods oof the key to determine the location of the 
    key-value pairs in the map.

(7) Hetrogeneous elements:
    Hashmap allows hetrogeneous elemnets to store as key and value




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================= Applications of HashMap ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=> Problems related to frequency of an item
=> Mapping problems
=> Storage optimization
=> Dictionary
=> Phonebook



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================= Constructors of HashMap ==================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) HashMap(): 
    creates an empty hashmap with (default initial capacity 16) & (default loadFactor 0.75)
    
(2) HashMap(int initialCapacity):
    creates an empty hashmap with (specified initial capacity) & (default loadFactor 0.75)
    
(3) HashMap(int initialCapacity, float loadFactor):
    creates an empty hashmap with (specified initial capacity) & (specified loadFactor)

(4) HashMap(Map<K, V> m):
    creates an hashMap with all the entries of specified map.


*/

import java.util.HashMap;

public class p1_IntroHashMap 
{
    public static void main(String[] args) 
    {
        // Default Constructor
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "One");
        map1.put(2, "Two");

        // Constructor with Initial Capacity
        HashMap<Integer, String> map2 = new HashMap<>(10);
        map2.put(3, "Three");
        map2.put(4, "Four");
        
        // Constructor with Initial Capacity and Load Factor
        HashMap<Integer, String> map3 = new HashMap<>(5, 0.5f);
        map3.put(5, "Five");
        map3.put(6, "Six");

        // Constructor with Another Map
        HashMap<Integer, String> map4 = new HashMap<>(map1);


        // displaying all the HashMaps 
        System.out.println("\n---------- Defualt map ------------\n" + map1);
        System.out.println("\n---------- Initial capacity map ------------\n" + map2);
        System.out.println("\n---------- Initial capacity with load factor map ------------\n" + map3);
        System.out.println("\n---------- specified map ------------\n" + map4);

    }    
}




