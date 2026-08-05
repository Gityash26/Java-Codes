/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Navigation Methods =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Navigation methods are used to move around the sorted keys stored inside a TreeMap.

Instead of traversing the TreeMap manually, we can directly find

-> Next Greater Key
-> Previous Smaller Key
-> Closest Greater Key
-> Closest Smaller Key



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Visual Representation ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Sorted Keys

10 ------- 20 ------- 30 ------- 40 ------- 50



===================================
Current Key = 30
===================================


higherKey(30)    -----------> 40
lowerKey(30)     -----------> 20
ceilingKey(30)   -----------> 30
floorKey(30)     -----------> 30



===================================
Current Key = 35
===================================

higherKey(35)    -----------> 40
lowerKey(35)     -----------> 30
ceilingKey(35)   -----------> 40
floorKey(35)     -----------> 30



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Methods =============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) higherKey(K key)

    Returns the least key that is strictly greater than the specified key.
------------------------------------------------------------

(2) lowerKey(K key)

    Returns the greatest key that is strictly smaller than the specified key.

------------------------------------------------------------

(3) ceilingKey(K key)

    Returns the specified key if it exists, otherwise returns the least greater key.

------------------------------------------------------------

(4) floorKey(K key)

    Returns the specified key if it exists, otherwise returns the greatest smaller key.

------------------------------------------------------------



=======================================
Entry Versions
=======================================

1. higherEntry()

2. lowerEntry()

3. ceilingEntry()

4. floorEntry()

These methods work exactly the same, but return the complete key-value pair
instead of only the key.


*/

import java.util.Map;
import java.util.TreeMap;

public class p3_NavigationMethods
{
    public static void main(String[] args)
    {

        TreeMap<Integer,String> map = new TreeMap<>();

        map.put(10,"Ten");
        map.put(20,"Twenty");
        map.put(30,"Thirty");
        map.put(40,"Forty");
        map.put(50,"Fifty");



        // --------- Original TreeMap -----------------------

        System.out.println("\nTreeMap : ");
        System.out.println(map);



        // --------- higherKey() ----------------------------

        System.out.println("\nhigherKey() : ");

        System.out.println("higherKey(30) = " + map.higherKey(30));
        System.out.println("higherKey(35) = " + map.higherKey(35));



        // --------- lowerKey() -----------------------------

        System.out.println("\nlowerKey() : ");

        System.out.println("lowerKey(30) = " + map.lowerKey(30));
        System.out.println("lowerKey(35) = " + map.lowerKey(35));



        // --------- ceilingKey() ---------------------------

        System.out.println("\nceilingKey() : ");

        System.out.println("ceilingKey(30) = " + map.ceilingKey(30));
        System.out.println("ceilingKey(35) = " + map.ceilingKey(35));



        // --------- floorKey() -----------------------------

        System.out.println("\nfloorKey() : ");

        System.out.println("floorKey(30) = " + map.floorKey(30));
        System.out.println("floorKey(35) = " + map.floorKey(35));



        // --------- higherEntry() --------------------------

        System.out.println("\nhigherEntry() : ");

        Map.Entry<Integer,String> higher = map.higherEntry(30);

        System.out.println(higher);



        // --------- lowerEntry() ---------------------------

        System.out.println("\nlowerEntry() : ");

        Map.Entry<Integer,String> lower = map.lowerEntry(30);

        System.out.println(lower);



        // --------- ceilingEntry() -------------------------

        System.out.println("\nceilingEntry() : ");

        Map.Entry<Integer,String> ceiling = map.ceilingEntry(35);

        System.out.println(ceiling);



        // --------- floorEntry() ---------------------------

        System.out.println("\nfloorEntry() : ");

        Map.Entry<Integer,String> floor = map.floorEntry(35);

        System.out.println(floor);

    }

}



/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Internal Understanding ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Keys

10 ----- 20 ----- 30 ----- 40 ----- 50



higherKey(30)

↓

40


------------------------------------------------------------


lowerKey(30)

↓

20


------------------------------------------------------------


ceilingKey(30)

↓

30

(Equal key exists)



------------------------------------------------------------


ceilingKey(35)

↓

40

(Equal key not found)



------------------------------------------------------------


floorKey(30)

↓

30

(Equal key exists)



------------------------------------------------------------


floorKey(35)

↓

30

(Equal key not found)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Key vs Entry ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

higherKey()

↓

Returns only the key.

Example

40



------------------------------------------------------------


higherEntry()

↓

Returns complete entry.

Example

40=Forty



Same concept applies to

lower

ceiling

floor



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Time Complexity =======================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

higherKey()        O(log n)

lowerKey()         O(log n)

ceilingKey()       O(log n)

floorKey()         O(log n)

higherEntry()      O(log n)

lowerEntry()       O(log n)

ceilingEntry()     O(log n)

floorEntry()       O(log n)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== Easy Trick ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

higher

↓

Strictly Greater (>)



lower

↓

Strictly Smaller (<)



ceiling

↓

Greater than OR Equal (>=)



floor

↓

Smaller than OR Equal (<=)



Remember

higher  -> >

lower   -> <

ceiling -> >=

floor   -> <=

*/