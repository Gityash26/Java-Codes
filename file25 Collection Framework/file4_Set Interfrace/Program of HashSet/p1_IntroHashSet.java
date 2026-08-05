/* 

                                        Collection
             _______________________________|_________________________________
            |                               |                                |
          List                            Queue                             Set
                                                     ________________________|_______________________
                                                    |                        |                      |
                                                  HashSet               LinkedHashSet           SortedSet
                                            => unordered               => insertion order          |
                                            => unique                  => LinkedList +           TreeSet
                                            => hashing internally         HasTable               => Sorted order
                                                                                                 => self-balancing BST
                                                                                                 => Red Blood Tree

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Introduction to HashSet ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> A HashSet is a class that implements the Set interface in Java.
-> Internally it is implemented using a hash table (actually a HashMap instance).
-> It does not allows to store duplicate elements.
-> It is a part of java.util package.
-> It is not synchronized, so it is not thread safe.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Key points of HashSet =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Underlying Data Structure => It is based on a HashMap.

(2) Unique Elements => It does not allow duplicate elements.

(3) Un-Ordered Collection => do not maintain the insertion order.

(4) Null Values => HashSet allows only one null value.

(5) Performance => generally faster than 'TreeSet' but slower than 'ArrayList'.

(6) Thread Safety => HashSet is not thread safe (Not synchronized).

(7) Initial Capacity => The default initial capacity of HashSet is 16.

(8) Load Factor => The default load factor of HashSet is 0.75.

(9) Implementation => HashSet is implemented using a hash table.





~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== How it Works =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> We already know that a hashmap is used to store the data in the form of "Key":"Value" pair.
-> And our HashSet internally uses a HashMap to store its elements.
-> But terminology is that, 

      HashMap --->    {key1:value1, key2:value2, key3:value3, key4:value4, .......} 

               but

      Set     --->    {value1, value2, value3, value4, .......}

-> So, the question arrise that how single-single values stored in a data structure which is designed 
   to store "Key":"Value" pair.

-> The Solution is that, in HashSet, Set elements are stored as a "key" in the "HashMap" and dummy values (usually null) 
   are stored as "value".

-> This approach make the use of Unique Key property of HashMap to store the unique elements in the HashSet.


================================
 Storage mechanism
================================
=> When we add an element in the HashSet, it calculate a hashCode for the element and then stores the element in the HashMap using this hashCode as the key.
=> The HashCode determines the bucket location (memory location) where the element will be stored.
    
                      ___________
    Element ------>  |          |--------------------------\  
                     | hashCode |                    _______\_______________
                     |__________|                   |       HashMap        |
                          |                         |______________________|
            (determine Bucket location)            |                      |
                                                   |   Key1    :   Value1-|--> (null)
                                                   |   Key2    :   Value2-|--> (null)
                                                   |   Key3    :   Value3-|--> (null)
                                                   |   Key4    :   Value4-|--> (null)
                                                   |   Key5    :   Value5-|--> (null)
                                                   |______________________|


================================
 No Order
================================
=> Since the HashCode determines the bucket location, the elements are not stored in the order in which they are added.


================================
 Uniqueness
================================
=> Before adding an element in the HashSet, it checks if the element is already exist (using equals() and hashCode() method).
=> If the element is already exist, it does not add the element again.


============ Analogy for better understanding ============
-> Suppose think of a Hashset as a locker room.
-> Each locker has a unique locker number (hashCode).
-> When you wants to store an item in the locker room, you first calculate the locker number (hashCode) and put the corresponding item in the locker.
-> If two item has the same locker due to same hashCode, then the system organize them to avoid the collision.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Why HashSet =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Reason 1 : HashSet is effecient for storing unique elements. 

Reason 2 : Elements are stored based on their hashCode, so the search, insert and delete operations are fast.

Reason 3 : It uses hasing technique to ensure quick lookup.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Performace =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Fast Operations: 
=> Provides constant-time complexity (O(1)) for basic operations like 
   adding, removing, and checking elements.

(2) Depends on Hashing: 
=> Poor hash function performance may degrade due to collisions.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============== Constructors of HashSet =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) HashSet():
    Creates a default empty hashSet (initial capacity is 16 and load factor is 0.75).

(2) HashSet(int initialCapacity):
    Creates an empty hashSet with the specified initial capacity.

(3) HashSet(int initialCapacity, float loadFactor):
    Creates an empty hashSet with the specified initial capacity and load factor.

(4) HashSet(Collection c):
    Creates a hashSet containing the elements of the specified collection.
  
*/


import java.util.*;

public class p1_IntroHashSet 
{
    public static void main(String[] args) 
    {
        // HashSet with default capacity (16) and load factor (0.75)
        HashSet<Integer> hash1 = new HashSet<>();
        
        // HashSet with specified initial capacity
        HashSet<Integer> hash2 = new HashSet<>(10);
        
        // HashSet with specified initial capacity and load factor
        HashSet<Integer> hash3 = new HashSet<>(20, 0.5f);
        
        // HashSet initialized with elements from a collection
        HashSet<Integer> hash4 = new HashSet<>(List.of(22, 33, 44, 55, 66, 77));


        // Adding elements
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
