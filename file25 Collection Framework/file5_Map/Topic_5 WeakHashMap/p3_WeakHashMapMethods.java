/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================================= Map Interface ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                               Map Interface
            ________________________|_______________________________________________
            |                       |                    |                          |
      -------------          ----------------      ---------------          ----------------
      | HashMap |           | LinkedHashMap |      | Hashtable |          |  SortedMap    |
      -------------          ----------------      ---------------          ----------------
       (Hashing)          (Insertion Order)        (Thread Safe)                 |
                                                                             -------------
                                                                             | TreeMap |
                                                                             -------------
                                                                             (Sorted)
                                                                                    |
                                                                                    |
                                                                              NavigableMap

                                           |
                                           |
                                           ▼

                                    ----------------
                                    | WeakHashMap |
                                    ----------------
                                      (Weak Keys)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== WeakHashMap ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> WeakHashMap is an implemented class of the Map interface.

-> It is present inside java.util package.

-> It stores data in the form of Key-Value pairs.

-> It uses Hashing internally, just like HashMap.

-> The major difference is that WeakHashMap stores its KEYS using Weak References instead of Strong References.

-> If a key has no Strong Reference outside the map, the Garbage Collector may remove that key automatically.

-> When the key is removed, its corresponding value is also removed from the map.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Syntax ======================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

WeakHashMap<K,V> map = new WeakHashMap<>();

Example

WeakHashMap<Integer,String> map = new WeakHashMap<>();

WeakHashMap<Student,String> map = new WeakHashMap<>();



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Internal Working ===============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap

               Strong Reference
                     │
                     ▼
               +-------------+
               |    Key      |
               +-------------+
                     │
                     ▼
               Hash Function
                     │
                     ▼
              Bucket (Key,Value)

As long as the key exists inside HashMap,
Garbage Collector CANNOT remove it.



------------------------------------------------------------

WeakHashMap

              Weak Reference
                    │
                    ▼

               +-------------+
               |    Key      |
               +-------------+
                     │
                     ▼
               Hash Function
                     │
                     ▼
              Bucket (Key,Value)


If no Strong Reference exists,
            ↓

Garbage Collector removes the Key.
            ↓

WeakHashMap automatically removes the complete entry.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Strong vs Weak Reference ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap

Student s = new Student();

HashMap<Student,String> map = new HashMap<>();

map.put(s,"Java");
s = null;



            Heap

HashMap
   │
Strong Reference
   │
   ▼
Student Object
    ↓
Object still exists.
    ↓
GC cannot remove it.



------------------------------------------------------------



WeakHashMap

Student s = new Student();

WeakHashMap<Student,String> map = new WeakHashMap<>();

map.put(s,"Java");

s = null;


            Heap

WeakHashMap
     │
Weak Reference
     │
     ▼
Student Object
     ↓
No Strong Reference Exists
     ↓
Garbage Collector
     ↓
Student Object Removed
     ↓
Entry Automatically Removed



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============================== Properties ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Stores data in Key-Value pairs.

(2) Uses Hashing internally.

(3) Stores Keys using Weak References.

(4) Values are stored normally.

(5) Entries are removed automatically when Keys become unreachable.

(6) Does NOT guarantee when an entry will disappear because it depends
    on Garbage Collector.

(7) Allows one null key.

(8) Allows multiple null values.

(9) Not synchronized.

(10) Average lookup time is O(1).



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Applications ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=> Memory-sensitive caches

=> Image cache

=> Metadata associated with objects

=> Temporary object mappings

=> Preventing memory leaks

=> Frameworks that automatically
   clean unused objects



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Constructors ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) WeakHashMap()

Creates an empty WeakHashMap.


------------------------------------------------------------


(2) WeakHashMap(int initialCapacity)

Creates an empty WeakHashMap
with specified capacity.


------------------------------------------------------------


(3) WeakHashMap(int initialCapacity, float loadFactor)

Creates an empty WeakHashMap with specified capacity and load factor.



------------------------------------------------------------


(4) WeakHashMap(Map<K, V> m)

Creates a WeakHashMap containing all mappings from another Map.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Important Observation ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap controls only HOW data is stored.

WeakHashMap controls

        HOW

and also

        HOW LONG

the data remains inside the map.

Its lifetime depends on the Garbage Collector.


*/