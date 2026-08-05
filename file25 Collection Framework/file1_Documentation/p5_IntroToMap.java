/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Introduction to Map Interface ============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> In the Java Collection Framework, interfaces like List, Set, and Queue store
   individual elements.

-> Java also provides another interface called Map, which stores data in the
   form of Key-Value pairs.

                    Key  ------->  Value

-> Every key is associated with exactly one value.

-> Map is used whenever data needs to be associated with a unique key.

-> Introduced in JDK 1.2.

Example:

        101  -> "Yash"
        102  -> "Rahul"
        103  -> "Aman"

Each key-value pair is called an ENTRY.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Why Map Interface? =================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Stores data in Key-Value form.
2. Provides fast searching using keys.
3. Keys uniquely identify values.
4. Useful for databases, caching, configuration, student records, etc.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Why Map is NOT a Collection? ============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Collection
----------
Stores only individual elements.

Example:

    [10, 20, 30, 40]

Map
---
Stores mappings between Key and Value.

Example:

    101 -> Yash
    102 -> Aman

Therefore, Map does not extend Collection.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Characteristics of Map Interface =========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Stores data as Key-Value pairs.

2. Keys must be unique.

3. Duplicate values are allowed.

4. Null key support depends on implementation.

5. Null values support depends on implementation.

6. Order depends on implementation.

7. Generic Interface

       Map<K, V>

       K = Key Type
       V = Value Type

Example:

       Map<Integer, String>

       Integer -> Key
       String  -> Value

8. Located in java.util package.

9. Not part of Collection hierarchy.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Null Support ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                    Null Key     Null Values

HashMap               Yes (1)        Yes
LinkedHashMap         Yes (1)        Yes
TreeMap               No             Yes
Hashtable             No             No

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Ordering ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap
--------
No guarantee of insertion order.

LinkedHashMap
-------------
Maintains insertion order.

TreeMap
-------
Maintains sorted order.

Hashtable
----------
No guaranteed order.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Time Complexity ========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap (Average Case)

put()              O(1)
get()              O(1)
remove()           O(1)
containsKey()      O(1)

Worst Case

O(n)

TreeMap

put()              O(log n)
get()              O(log n)
remove()           O(log n)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Internal Working =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HashMap stores data using HASHING.

Process:

Key
 │
 ▼
hashCode()
 │
 ▼
Bucket Index
 │
 ▼
equals()
 │
 ▼
Retrieve Value

-> Internally HashMap stores data inside buckets.
-> Java 8 converts long collision chains into Red-Black Trees to improve
   performance.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Map Interface Hierarchy ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Map
│
├── HashMap
│      │
│      └── LinkedHashMap
│
├── Hashtable
│
├── WeakHashMap
│
├── IdentityHashMap
│
└── SortedMap
       │
       └── NavigableMap
              │
              └── TreeMap

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Common Implementations ==================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. HashMap
-----------
-> Most commonly used implementation.
-> Fast lookup.
-> One null key allowed.
-> Multiple null values allowed.
-> No ordering.

2. LinkedHashMap
----------------
-> Maintains insertion order.
-> One null key allowed.
-> Multiple null values allowed.

3. TreeMap
----------
-> Stores entries in sorted order.
-> Uses Red-Black Tree internally.
-> No null key.
-> Multiple null values allowed.

4. Hashtable
------------
-> Legacy implementation.
-> Thread-safe (Synchronized).
-> No null key.
-> No null values.

5. WeakHashMap
--------------
-> Entries can be removed automatically by Garbage Collector
   when keys become unreachable.

6. IdentityHashMap
------------------
-> Uses == for key comparison instead of equals().

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Common Methods =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Basic Operations

put(K key, V value)
    Adds or updates an entry.

get(Object key)
    Returns value for the given key.

remove(Object key)
    Removes an entry.

containsKey(Object key)
    Checks whether key exists.

containsValue(Object value)
    Checks whether value exists.

size()
    Returns total entries.

isEmpty()
    Checks whether map is empty.

clear()
    Removes all entries.

----------------------------------------------

Bulk Operations

putAll(Map m)
    Copies all mappings.

keySet()
    Returns Set<K> of all keys.

values()
    Returns Collection<V> of all values.

entrySet()
    Returns Set<Map.Entry<K,V>>.

----------------------------------------------

Comparison Methods

equals(Object o)

hashCode()

----------------------------------------------

Java 8 Default Methods

getOrDefault()

putIfAbsent()

replace()

remove(key, value)

compute()

computeIfAbsent()

computeIfPresent()

merge()

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Iterating over a Map ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Using keySet()

2. Using values()

3. Using entrySet()

4. Using Iterator

5. Using forEach() (Java 8)

6. Using Stream API

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====================== Frequently Asked Interview Questions ====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Why is Map not part of Collection?

2. Difference between HashMap and Hashtable?

3. Difference between HashMap and TreeMap?

4. Difference between HashMap and LinkedHashMap?

5. How does HashMap work internally?

6. Why are hashCode() and equals() important?

7. What happens when duplicate keys are inserted?

8. Can duplicate values exist?

9. Difference between keySet() and entrySet()?

10. Why does values() return Collection instead of Set?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~