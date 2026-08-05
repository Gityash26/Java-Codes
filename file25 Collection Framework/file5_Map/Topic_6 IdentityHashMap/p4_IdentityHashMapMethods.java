/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================== IdentityHashMap Methods =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

IdentityHashMap implements the Map Interface.

Therefore,

almost all methods are exactly the same as HashMap.

The only difference is

        Key Comparison

HashMap

↓

equals() + hashCode()


IdentityHashMap

↓

== + System.identityHashCode()

*/

import java.util.IdentityHashMap;
import java.util.Map;

public class p4_IdentityHashMapMethods
{
    public static void main(String[] args)
    {

        IdentityHashMap<Integer, String> map =
                new IdentityHashMap<>();


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

        for (Map.Entry<Integer, String> entry : map.entrySet())
        {
            System.out.println(entry.getKey()
                    + " -> "
                    + entry.getValue());
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