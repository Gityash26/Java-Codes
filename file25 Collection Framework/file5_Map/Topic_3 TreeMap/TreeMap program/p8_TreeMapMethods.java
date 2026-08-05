/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=============================== Methods of TreeMap ==============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

TreeMap implements the Map interface.

Therefore, almost all methods of TreeMap are inherited from the Map interface.

The only difference is

        '' TreeMap always stores keys in Sorted Order '''

Hence, after every insertion, deletion or replacement, the TreeMap automatically maintains the sorted 
order of keys.



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
======================= Basic Operations =============================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) put(K key, V value)
    -> Associates the specified value with the specified key.
    -> If key already exists, old value is replaced.

------------------------------------------------------------

(2) get(Object key)
    -> Returns the value associated with the specified key.

------------------------------------------------------------

(3) remove(Object key)
    -> Removes the specified key and its corresponding value.

------------------------------------------------------------

(4) size()
    -> Returns the total number of key-value mappings.

------------------------------------------------------------

(5) isEmpty()
    -> Returns true if the map contains no elements.

------------------------------------------------------------

(6) clear()
    -> Removes all mappings from the TreeMap.





=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
======================= Search Operations ============================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) containsKey(Object key)
    -> Returns true if the specified key exists.

------------------------------------------------------------

(2) containsValue(Object value)
    Returns true if the specified value exists.



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
======================= Bulk Operations ==============================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) putAll(Map m)
    Copies all mappings from another map.
    After copying, TreeMap automatically arranges all keys in sorted order.



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
======================= View Methods =================================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) keySet()
    -> Returns all keys as a Set.

------------------------------------------------------------

(2) values()
    -> Returns all values as a Collection.

------------------------------------------------------------

(3) entrySet()
    -> Returns all entries as a Set.



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
================== Comparison & Hashing ==============================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) equals(Object obj)
    -> Compares two maps.

------------------------------------------------------------

(2) hashCode()
    -> Returns the hashcode of the TreeMap.



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
===================== Default Methods ================================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) getOrDefault()

(2) putIfAbsent()

(3) replace()

(4) remove(key,value)

(5) compute()

(6) computeIfAbsent()

(7) computeIfPresent()

(8) merge()

These methods behave exactly like HashMap.

Only difference, TreeMap always keeps the keys sorted.

*/

import java.util.Map;
import java.util.TreeMap;

public class p8_TreeMapMethods
{

    public static void main(String[] args)
    {

        TreeMap<Integer,String> map = new TreeMap<>();


        // --------- put() method -----------------------

        map.put(103,"Rahul");
        map.put(101,"Amit");
        map.put(105,"Neha");
        map.put(102,"Vikas");

        System.out.println("put() : ");
        System.out.println(map);


        // --------- get() method -----------------------
        System.out.println("\nget(103) : " + map.get(103));


        // --------- containsKey() method -----------------------  
        System.out.println("\ncontainsKey(101) : " + map.containsKey(101));
        
        
        // --------- containsValue() method -----------------------  
        System.out.println("\ncontainsValue()" + map.containsValue("Neha"));
        
        
        // --------- remove() method -----------------------  
        map.remove(102);        
        System.out.println("\nremove(102) : " + map);

        
        // --------- size() method -----------------------  
        System.out.println("\nsize()" + map.size());
        

        // --------- isEmpty() method -----------------------  
        System.out.println("\nisEmpty() : " + map.isEmpty());



        // --------- putAll() method -----------------------  
        TreeMap<Integer,String> map2 = new TreeMap<>();
        
        map2.put(110, "Rohan");
        map2.put(111, "Sohan");

        map.putAll(map2);
        System.out.println("\nputAll() : " + map);


       // --------- keySet() method -----------------------  
        System.out.println("\nkeySet() : ");

        for(Integer key : map.keySet())
        {
            System.out.print(key + ", ");
        }


       // --------- values() method -----------------------  
        System.out.println("\nvalues() : ");

        for(String value : map.values())
        {
            System.out.print(value + " ");
        }



        
       // --------- entrySet() method -----------------------  
        System.out.println("\nentrySet() : ");

        for(Map.Entry<Integer,String> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }



       // --------- getOrDefault() method -----------------------  
        System.out.println("\ngetOrDefault() : ");
        System.out.println(map.getOrDefault(999, "Not Found"));



    // --------- putIfAbsent() method -----------------------
        System.out.println("\nputIfAbsent() : ");

        map.putIfAbsent(101, "Changed");   // Key already exists
        map.putIfAbsent(120, "Ritik");     // New key inserted

        System.out.println(map);


        // --------- replace() method -----------------------
        System.out.println("\nreplace() : ");

        map.replace(120, "Ritik", "Ankit");
        System.out.println(map);


        // --------- remove(key, value) method -----------------------
        System.out.println("\nremove(key, value) : ");

        map.remove(120, "Ankit");
        System.out.println(map);


        // --------- clear() method -----------------------
        System.out.println("\nclear() : ");

        map.clear();
        System.out.println(map);

    }

}