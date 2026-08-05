/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================= Methods of HashMap ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
========== Basic Operations ===========================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) put(K key, V value): 
    Associates the specified value with the specified key in this map.

(2) get(Object key): 
    Returns the value mapped with the specified key, or null if no mapping exist

(3) remove(Object key): 
    Removes the specified key-value mapping from the map

(4) size(): 
    Returns the number of key-value mappings in this map.

(5) isEmpty(): 
    Returns true if this map contains no key-value mappings.

(6) clear(): 
    Removes all of the mappings from this map.

 

=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
========== Bulk Operations ===========================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) putAll(Map m): 
    Copies all of the mappings from the specified map to this map.

(2) containsKey(Object key): 
    Returns true if the mapping exist for a specified key.

(3) containsValue(Object value): 
    Returns true if one or more keys mapped to a specified value
  




=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
========== Iteration methods ========================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) values(): 
        Returns a Collection view of the values contained in the map.

(2) keySet(): 
    Returns a Set view of all the keys present in the map

(3) entrySet(): 
    Returns a Set view of all the entries present in the map


=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
========== Comparision &  hashing ========================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 
(1) equals(Object o)
    Compares the specified map with the this map for equality

(2) hashcode()
    Returns the hascode value for this map 





=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
========== Defualt methods ===========
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) V getOrDefault(Object key, V defaultValue)	
    Returns associated mapped value with the specified key, 
    Otherwise returns the defaultValue provided.

(2) V putIfAbsent(K key, V value)	
    Mapped specified key and value only if not already exist.
    
(3) boolean remove(Object key, Object value)	
    Removes the key-value pair if the key is mapped to the specified value.

(4) boolean replace(K key, V oldValue, V newValue)	
    Replace the associated old value with the newValue if mapped with the specified key

(5) V replace(K key, V value)	
    Replaces the entry for the specified key with the specified value, if it exists.

(6) V computeIfAbsent(K key, mappingFunction)	
    Computes a mapping if the key is not already associated with a value.

(7) V computeIfPresent(K key, remappingFunction)	
    Computes a new value if the key is already mapped.

(8) V compute(K key, remappingFunction)	
    Computes a new mapping for the specified key.

(9) V merge(K key, V value, remappingFunction)	
    Merges the specified value with the existing value for the key.

*/

import java.util.*;
import java.util.function.*;


public class p3_MethodsHashMap 
{

    public static void main(String[] args) 
    {

        HashMap<Integer, String> map = new HashMap<>();

        // =====================================================
        // Basic Operations
        // =====================================================

        // put()
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");

        // get()
        System.out.println(map.get(2)); // Python

        // remove(key)
        map.remove(3);

        // size()
        System.out.println(map.size());

        // isEmpty()
        System.out.println(map.isEmpty());

        // clear()
        // map.clear();




        // =====================================================
        // Bulk Operations
        // =====================================================

        HashMap<Integer, String> anotherMap = new HashMap<>();
        anotherMap.put(4, "Spring");
        anotherMap.put(5, "Hibernate");

        // putAll()
        map.putAll(anotherMap);

        // containsKey()
        System.out.println(map.containsKey(1));

        // containsValue()
        System.out.println(map.containsValue("Java"));





        // =====================================================
        // Iteration Methods
        // =====================================================

        // values()
        Collection<String> values = map.values();
        System.out.println(values);

        // keySet()
        Set<Integer> keys = map.keySet();
        System.out.println(keys);

        // entrySet()
        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }





        // =====================================================
        // Comparison & Hashing
        // =====================================================

        HashMap<Integer, String> map2 = new HashMap<>(map);

        // equals()
        System.out.println(map.equals(map2));

        // hashCode()
        System.out.println(map.hashCode());






        // =====================================================
        // Default Methods
        // =====================================================

        // getOrDefault()
        System.out.println(map.getOrDefault(10, "Not Found"));

        // putIfAbsent()
        map.putIfAbsent(2, "JavaScript"); // won't replace
        map.putIfAbsent(6, "React");

        // remove(key,value)
        System.out.println(map.remove(6, "React"));

        // replace(key, oldValue, newValue)
        map.replace(2, "Python", "Python 3");

        // replace(key, value)
        map.replace(1, "Java 21");

        // computeIfAbsent()
        map.computeIfAbsent(7, k -> "Generated Value");

        // computeIfPresent()
        map.computeIfPresent(2,
                (k, v) -> v.toUpperCase());

        // compute()
        map.compute(1,
                (k, v) -> v + " Developer");

        // merge()
        map.merge(1,
                " Course",
                (oldValue, newValue) -> oldValue + newValue);






        // =====================================================
        // Final Output
        // =====================================================

        System.out.println("\nFinal Map:");

        map.forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }
}