/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Boundary Methods ======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Boundary methods are used to access the first and last elements present in the sorted TreeMap.

Since TreeMap always stores keys in sorted order, finding the first and last element becomes efficient.


Sorted Keys

10 -------- 20 -------- 30 -------- 40 -------- 50


Boundary Keys

First Key  -----------------> 10
Last Key   -----------------> 50



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Methods ===============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) firstKey()
    Returns the smallest key present in the TreeMap.

------------------------------------------------------------

(2) lastKey()
    Returns the largest key present in the TreeMap.

------------------------------------------------------------

(3) firstEntry()
    Returns the first (key, value) pair as a Map.Entry object.

------------------------------------------------------------

(4) lastEntry()
    Returns the last (key, value) pair as a Map.Entry object.

*/

import java.util.Map;
import java.util.TreeMap;

public class p2_BoundaryMethods
{
    public static void main(String[] args)
    {

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(103, "Rahul");
        map.put(101, "Amit");
        map.put(105, "Neha");
        map.put(102, "Vikas");
        map.put(104, "Rohan");



        // --------- Original TreeMap -----------------------

        System.out.println("\nTreeMap : ");
        System.out.println(map);



        // --------- firstKey() -----------------------------
        System.out.println("\nfirstKey() : " + map.firstKey());



        // --------- lastKey() ------------------------------
        System.out.println("\nlastKey() : " + map.lastKey());



        // --------- firstEntry() ---------------------------
        System.out.println("\nfirstEntry() : " + map.firstEntry());



        // --------- lastEntry() ----------------------------

        System.out.println("\nlastEntry() : " + map.lastEntry());

    }
}


