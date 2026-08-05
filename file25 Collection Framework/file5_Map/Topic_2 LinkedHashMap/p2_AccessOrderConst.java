/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------- (4) Constructor of AccessOrder -------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



Syntax:

   LinkedHashMap (initialCapacity , loadFactor , accessOrder );


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Parameters =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) initialCapacity

    => Initial number of buckets required.

(2) loadFactor

    => Determines when the Hash Table should resize.

(3) accessOrder

    => Decides how the iteration order will be maintained.

        false  -> Insertion Order (Default)
        true   -> Access Order



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Insertion Order =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

When accessOrder = false

Elements are iterated in the same order
in which they were inserted.

Example:
-----------------------------------------
put(1,"Java")
put(2,"Python")
put(3,"C++")


Output
------------------------------------------
(1 -> Java) ===> (2 -> Python) ===> (3 -> C++)


Even after calling

get(1)

Output remains

1 -> Java
2 -> Python
3 -> C++



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Access Order ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

When accessOrder = true

Whenever an element is accessed using

    get()

or updated using

    put()

that element is moved to the end of the Doubly Linked List.


Example
------------------------------
Initially

1 -> Java
2 -> Python
3 -> C++

After

get(1)

2 -> Python
3 -> C++
1 -> Java


After

get(2)

3 -> C++
1 -> Java
2 -> Python



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Internal Working =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Initially

(Head) 1 <----> 2 <----> 3 (Tail)


After get(1)

(Head) 2 <----> 3 <----> 1 (Tail)


The accessed node is removed from its current position and attached to the Tail of the Doubly Linked List.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Applications =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=> LRU Cache

=> Recently Opened Files

=> Browser History

=> Cache Memory

=> Session Management



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Time Complexity =================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

put()      -> O(1)

get()      -> O(1)

remove()   -> O(1)

Moving the node in the Doubly Linked List also takes constant time O(1).

*/

import java.util.LinkedHashMap;

public class p2_AccessOrderConst 
{

    public static void main(String[] args) 
    {

        System.out.println("============== Insertion Order ==============\n");

        LinkedHashMap<Integer, String> insertionMap = new LinkedHashMap<>(16, 0.75f, false);  // insertion order remains

        insertionMap.put(1, "Java");
        insertionMap.put(2, "Python");
        insertionMap.put(3, "C++");

        System.out.println("Before accessing : " + insertionMap);
        insertionMap.get(1);
        System.out.println("After get(1)     : " + insertionMap);



        System.out.println("\n============== Access Order ==============\n");

        LinkedHashMap<Integer, String> accessMap = new LinkedHashMap<>(16, 0.75f, true);  // Access order remains 

        accessMap.put(1, "Java");
        accessMap.put(2, "Python");
        accessMap.put(3, "C++");

        System.out.println("Before accessing : " + accessMap);
        
        accessMap.get(1);
        System.out.println("After get(1)     : " + accessMap);
        
        accessMap.get(2);
        System.out.println("After get(2)     : " + accessMap);

        accessMap.get(3);
        System.out.println("After get(3)     : " + accessMap);
    }
}