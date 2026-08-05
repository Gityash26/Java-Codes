/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Methods of LinkedHashMap ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> LinkedHashMap extends HashMap.

-> Therefore, almost all methods available in HashMap are directly inherited
   by LinkedHashMap.

-> The major difference is NOT in the methods,
   but in the iteration order.

        HashMap
            ↓
        No guaranteed order

        LinkedHashMap
            ↓
        Maintains insertion order
        (or access order if enabled)



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
====================== Basic Operations ======================================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

(1) put(K key, V value)
    Associates the specified value with the specified key.

(2) get(Object key)
    Returns the value mapped with the specified key.

(3) remove(Object key)
    Removes the specified key-value mapping.

(4) size()
    Returns the number of key-value pairs.

(5) isEmpty()
    Returns true if the map contains no elements.

(6) clear()
    Removes all mappings.



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
====================== Bulk Operations =======================================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

(1) putAll(Map m)

(2) containsKey(Object key)

(3) containsValue(Object value)



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
====================== Iteration Methods =====================================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

(1) keySet()

(2) values()

(3) entrySet()



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
====================== Comparison & Hashing ==================================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

(1) equals(Object o)

(2) hashCode()



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
====================== Default Methods =======================================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

(1) getOrDefault()

(2) putIfAbsent()

(3) remove(key,value)

(4) replace(key,oldValue,newValue)

(5) replace(key,value)

(6) computeIfAbsent()

(7) computeIfPresent()

(8) compute()

(9) merge()



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
================== LinkedHashMap Specific Feature ============================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

Although LinkedHashMap inherits almost every method from HashMap,

it guarantees that iteration methods

        keySet()

        values()

        entrySet()

always follow

        -> Insertion Order

or

        -> Access Order (if enabled)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================ Example =========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

*/

import java.util.LinkedHashMap;
import java.util.Map;

public class p3_LinkedHMapMethod 
{

    public static void main(String[] args) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        // put()
        map.put(101, "Java");
        map.put(103, "Python");
        map.put(102, "C++");

        System.out.println("After put()");
        System.out.println(map);

        // get()
        System.out.println("\nget(103) : " + map.get(103));

        // containsKey()
        System.out.println("containsKey(102) : " + map.containsKey(102));

        // containsValue()
        System.out.println("containsValue(Java) : " + map.containsValue("Java"));

        // size()
        System.out.println("Size : " + map.size());

        // keySet()
        System.out.println("\nKeys: ");
        System.out.println(map.keySet());

        // values()
        System.out.println("\nValues: ");
        System.out.println(map.values());

        // entrySet()
        System.out.println("\nEntries: ");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // remove()
        map.remove(103);

        System.out.println("\nAfter remove(103)");
        System.out.println(map);

        // replace()
        map.replace(102, "C");

        System.out.println("\nAfter replace()");
        System.out.println(map);

        // putIfAbsent()
        map.putIfAbsent(104, "Spring");
        map.putIfAbsent(101, "Hibernate");

        System.out.println("\nAfter putIfAbsent()");
        System.out.println(map);

        // getOrDefault()
        System.out.println("\ngetOrDefault()");
        System.out.println(map.getOrDefault(200, "Not Found"));

        // clear()
         map.clear();

        System.out.println("\nAfter clear()");
        System.out.println(map);

        // isEmpty()
        System.out.println("isEmpty() : " + map.isEmpty());
    }
}
