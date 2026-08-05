/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= Constructors of TreeMap ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

TreeMap provides 4 constructors.

Depending upon the constructor used,

TreeMap decides

    • How the map should be created.
    • Which keys should be inserted.
    • How the keys should be compared.
    • Which ordering should be followed.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Constructor Summary ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) TreeMap()

    Creates an empty TreeMap.

    -> Uses Natural Ordering.
    -> Keys must implement Comparable.
    -> Most commonly used constructor.


------------------------------------------------------------


(2) TreeMap(Comparator<? super K> comparator)

    Creates an empty TreeMap using the specified Comparator.

    -> Uses Custom Ordering.
    -> compareTo() is NOT used.
    -> Comparator.compare() decides the ordering.


------------------------------------------------------------


(3) TreeMap(Map<K,V> map)

    Creates a TreeMap containing all mappings from another Map.

    -> Copies all key-value pairs.
    -> Keys are automatically sorted.
    -> Uses Natural Ordering.


------------------------------------------------------------


(4) TreeMap(SortedMap<K,V> map)

    Creates a TreeMap containing all mappings from another SortedMap.

    -> Copies all entries.
    -> Preserves the ordering of the specified SortedMap.

*/


import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class p7_TreeMapConstructors
{

    public static void main(String[] args)
    {

        /*
        ============================================================
                        1. Default Constructor
        ============================================================
        */

        TreeMap<Integer,String> map1 = new TreeMap<>();

        map1.put(103,"Rahul");
        map1.put(101,"Amit");
        map1.put(105,"Neha");
        map1.put(102,"Vikas");

        System.out.println("Default Constructor");
        System.out.println(map1);



/*
=============================================================
2. Comparator Constructor
============================================================
        
        class descending implements Comparator<Integer>
        {
                @Override
                public int compare(Integer a, Integer b)
                {
                        return Integer.compare(b, a);
                }
        }

 
                        
                                 OR

Lambda approach..............

        Comparator<Integer> descending = (a, b) -> Integer.compare(b, a);


*/






        Comparator<Integer> descending = (a,b) -> Integer.compare(b,a);

        TreeMap<Integer,String> map2 = new TreeMap<>(descending);

        map2.put(103,"Rahul");
        map2.put(101,"Amit");
        map2.put(105,"Neha");
        map2.put(102,"Vikas");

        System.out.println("\nComparator Constructor");
        System.out.println(map2); 



        /*
        ============================================================
                    3. Constructor using another Map
        ============================================================
        */

        HashMap<Integer,String> hashMap = new HashMap<>();

        hashMap.put(40,"Forty");
        hashMap.put(10,"Ten");
        hashMap.put(30,"Thirty");
        hashMap.put(20,"Twenty");

        TreeMap<Integer,String> map3 = new TreeMap<>(hashMap);

        System.out.println("\nConstructor using HashMap");
        System.out.println(map3);



        /*
        ============================================================
                4. Constructor using SortedMap
        ============================================================
        */

        TreeMap<Integer,String> source = new TreeMap<>();

        source.put(4,"Four");
        source.put(2,"Two");
        source.put(1,"One");
        source.put(3,"Three");

        TreeMap<Integer,String> map4 = new TreeMap<>(source);

        System.out.println("\nConstructor using SortedMap");
        System.out.println(map4);
    }
}
