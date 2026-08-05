/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Polling & Reverse View Methods ============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Until now, we have only accessed the elements of TreeMap.

Sometimes, we also need to 'remove' the boundary elements or 'traverse' the TreeMap in reverse order.

NavigableMap provides methods for these operations.




==================================
Mujhe dekhna bhi h boundary element 
              or 
saath k saath remove bhi krna h 
==================================



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Polling Methods =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Polling methods return the boundary entry and simultaneously remove it from the TreeMap.

------------------------------------------------------------

(1) pollFirstEntry()

    -> Returns the first (smallest) entry.
    -> Removes that entry from the TreeMap.

------------------------------------------------------------

(2) pollLastEntry()

    -> Returns the last (largest) entry.
    -> Removes that entry from the TreeMap.



Example

Original TreeMap

10 ----- 20 ----- 30 ----- 40 ----- 50


pollFirstEntry()

↓
Returns 10 = Ten

Remaining
20 ----- 30 ----- 40 ----- 50


------------------------------------------------------------


pollLastEntry()

↓
Returns 50 = Fifty

Remaining
20 ----- 30 ----- 40



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Reverse View Methods ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Sometimes we want to traverse the TreeMap from largest key to smallest key.

Instead of creating another TreeMap, NavigableMap provides reverse views.

------------------------------------------------------------
(1) descendingMap()

    Returns a reverse-order view of the TreeMap.
------------------------------------------------------------

(2) descendingKeySet()

    Returns all keys in descending order.
------------------------------------------------------------

(3) navigableKeySet()

    Returns all keys in ascending order as a NavigableSet.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Visual Representation =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

------------------------------------------------------------

Original Order
        `       10 ----- 20 ----- 30 ----- 40 ----- 50

------------------------------------------------------------

descendingMap()
                50 ----- 40 ----- 30 ----- 20 ----- 10

------------------------------------------------------------

descendingKeySet()
                    [50, 40, 30, 20, 10]

------------------------------------------------------------

navigableKeySet()
                    [10, 20, 30, 40, 50]

------------------------------------------------------------

*/

import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

public class p4_PollingAndReverseViewMethods
{
    public static void main(String[] args)
    {

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(10, "Ten");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");



        // --------- Original TreeMap -----------------------

        System.out.println("\nTreeMap : ");
        System.out.println(map);



        // --------- pollFirstEntry() -----------------------

        System.out.println("\npollFirstEntry() : ");
        System.out.println(map.pollFirstEntry());

        System.out.println(map);



        // --------- pollLastEntry() ------------------------

        System.out.println("\npollLastEntry() : ");
        System.out.println(map.pollLastEntry());

        System.out.println(map);



        // Reinsert removed entries
        map.put(10, "Ten");
        map.put(50, "Fifty");



        // --------- descendingMap() ------------------------

        System.out.println("\ndescendingMap() : ");

        NavigableMap<Integer, String> reverseMap =
                map.descendingMap();

        System.out.println(reverseMap);



        // --------- descendingKeySet() ---------------------

        System.out.println("\ndescendingKeySet() : ");

        NavigableSet<Integer> descendingKeys =
                map.descendingKeySet();

        System.out.println(descendingKeys);



        // --------- navigableKeySet() ----------------------

        System.out.println("\nnavigableKeySet() : ");

        NavigableSet<Integer> ascendingKeys =
                map.navigableKeySet();

        System.out.println(ascendingKeys);

    }

}


/*
