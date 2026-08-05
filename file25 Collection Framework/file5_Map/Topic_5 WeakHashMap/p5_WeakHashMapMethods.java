/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================= WeakHashMap Methods ==========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

WeakHashMap implements the Map interface.

Therefore, almost all methods are the same as HashMap.

The only difference is that entries may disappear automatically
when their keys become eligible for Garbage Collection.

*/

import java.util.WeakHashMap;

public class p5_WeakHashMapMethods
{
    public static void main(String[] args)
    {

        WeakHashMap<Integer, String> map = new WeakHashMap<>();


        // --------- put() ---------------------------------------

        map.put(101, "Rahul");
        map.put(102, "Amit");
        map.put(103, "Neha");
        map.put(104, "Priya");

        System.out.println("put() : ");
        System.out.println(map);


        // --------- get() ---------------------------------------

        System.out.println("\nget() : ");
        System.out.println(map.get(102));


        // --------- size() --------------------------------------

        System.out.println("\nsize() : ");
        System.out.println(map.size());


        // --------- containsKey() -------------------------------

        System.out.println("\ncontainsKey() : ");
        System.out.println(map.containsKey(103));


        // --------- containsValue() -----------------------------

        System.out.println("\ncontainsValue() : ");
        System.out.println(map.containsValue("Priya"));


        // --------- keySet() ------------------------------------

        System.out.println("\nkeySet() : ");
        System.out.println(map.keySet());


        // --------- values() ------------------------------------

        System.out.println("\nvalues() : ");
        System.out.println(map.values());


        // --------- entrySet() ----------------------------------

        System.out.println("\nentrySet() : ");

        for (var entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


        // --------- putIfAbsent() -------------------------------

        map.putIfAbsent(102, "Changed");
        map.putIfAbsent(105, "Ritik");

        System.out.println("\nputIfAbsent() : ");
        System.out.println(map);


        // --------- replace() -----------------------------------

        map.replace(105, "Ankit");

        System.out.println("\nreplace() : ");
        System.out.println(map);


        // --------- remove() ------------------------------------

        map.remove(105);

        System.out.println("\nremove() : ");
        System.out.println(map);


        // --------- getOrDefault() ------------------------------

        System.out.println("\ngetOrDefault() : ");
        System.out.println(map.getOrDefault(999, "Not Found"));


        // --------- isEmpty() -----------------------------------

        System.out.println("\nisEmpty() : ");
        System.out.println(map.isEmpty());


        // --------- clear() -------------------------------------

        map.clear();

        System.out.println("\nclear() : ");
        System.out.println(map);

    }
}