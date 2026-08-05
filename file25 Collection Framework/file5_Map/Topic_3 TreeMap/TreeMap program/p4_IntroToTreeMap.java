/*

                                Map Interface
             -----------------------|_______________________________________
            |                       |                                      |
         HashMap             LinkedHashMap                            SortedMap     
                                                                           |
                                                                       NavigableMap   
                                                                           |
                                                                       TreeMap   



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============================== TreeMap ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> TreeMap is an implemented class of the Map Interface in the Java Collection Framework.

-> It is present inside the java.util package.

-> TreeMap implements the NavigableMap interface which further extends
   the SortedMap interface.

-> TreeMap stores the data in the form of Key-Value pairs.

-> TreeMap automatically stores all keys in Sorted (Ascending) Order.

-> TreeMap internally uses a Self-Balancing Red-Black Tree.

-> Sorting is performed on the Keys only.

-> Values are NOT sorted.

-> TreeMap is widely used when data must always remain sorted.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================== Syntax ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

TreeMap<K, V> map = new TreeMap<>();

Where,

K -> Key
V -> Value


Examples

TreeMap<Integer, String> map = new TreeMap<>();

TreeMap<String, Integer> marks = new TreeMap<>();

TreeMap<Character, Double> data = new TreeMap<>();



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Internal Representation ====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Suppose we insert

put(50,"A")

put(20,"B")

put(70,"C")

put(10,"D")

put(40,"E")



Internally TreeMap stores


                    50
                  /    \
                20      70
               /  \
             10   40



During Iteration: (Left ->  Root -> Right)
-----------------------------------------------------
Output:  10 20 40 50 70
-----------------------------------------------------




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Properties ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) Sorted Collection

    TreeMap stores all keys in Ascending Order by default.

-------------------------------------------------------

(2) Duplicate Keys

    Duplicate keys are NOT allowed.
    If an existing key is inserted again, the old value is replaced.

-------------------------------------------------------

(3) Null Keys

    TreeMap DOES NOT allow null keys.

    Because comparison between null and other keys is not possible.

-------------------------------------------------------

(4) Null Values

    Multiple null values are allowed.

-------------------------------------------------------

(5) Not Synchronized

    TreeMap is not thread-safe.

-------------------------------------------------------

(6) Natural Sorting

    By default, TreeMap sorts according to the natural ordering of the key.

Example

Integer ===> 1 2 3 4 5
String ===> Apple, Ball, Cat, Dog


-------------------------------------------------------

(7) Custom Sorting

    TreeMap also supports custom sorting using Comparator.

-------------------------------------------------------

(8) Performance

Search: O(log n)

Insertion: O(log n)

Deletion: O(log n)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Applications ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

=> Dictionary
=> Leaderboard
=> Student Ranking
=> Employee Database
=> Banking Systems
=> Product Sorting
=> Event Scheduling
=> Phone Directory


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Constructors ===============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


-------------------------------------------------------
(1) TreeMap()
-------------------------------------------------------
Creates an empty TreeMap using Natural Ordering.


-------------------------------------------------------
(2) TreeMap(Comparator<? super K> comparator)
-------------------------------------------------------
Creates an empty TreeMap using the specified Comparator.


-------------------------------------------------------
(3) TreeMap(Map<? extends K, ? extends V> map)
-------------------------------------------------------
Creates a TreeMap containing all mappings from the specified Map.


-------------------------------------------------------
(4) TreeMap(SortedMap<K, ? extends V> map)
------------------------------------------------------- 
Creates a TreeMap containing all mappings from the specified SortedMap.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Comparison ================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

==============================================================================================
                  HashMap              LinkedHashMap             TreeMap
==============================================================================================

Ordering            No                   Insertion                Sorted
______________________________________________________________________________________________

Data Structure      Hash Table           Hash Table + DLL         Red-Black Tree
______________________________________________________________________________________________

Search              O(1)                 O(1)                     O(log n)
______________________________________________________________________________________________

Null Key            One                  One                      Not Allowed
______________________________________________________________________________________________

Null Values         Multiple             Multiple                 Multiple
______________________________________________________________________________________________

Sorting             No                   No                       Yes
______________________________________________________________________________________________


*/

import java.util.HashMap;
import java.util.TreeMap;

public class p4_IntroToTreeMap 
{

    public static void main(String[] args) 
    {

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(50, "Fifty");
        map.put(10, "Ten");
        map.put(40, "Forty");
        map.put(20, "Twenty");
        map.put(30, "Thirty");

        System.out.println("TreeMap");
        System.out.println(map);
   }

}