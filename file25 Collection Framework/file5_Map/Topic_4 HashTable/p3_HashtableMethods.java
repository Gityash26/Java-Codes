/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
======================== Methods of Hashtable ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Hashtable implements the Map interface.

Therefore, almost all methods are the same as HashMap.

The major difference is that all public methods of Hashtable are synchronized (Thread Safe).



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
============== Basic Operations =============================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) put(K key, V value)
    Associates the specified value with the specified key.

(2) get(Object key)
    Returns the value associated with the specified key.

(3) remove(Object key)
    Removes the mapping of the specified key.

(4) size()
    Returns the number of key-value pairs.

(5) isEmpty()
    Returns true if Hashtable contains no entries.

(6) clear()
    Removes all mappings.



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
============== Searching Operations =========================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) containsKey(Object key)

(2) containsValue(Object value)



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
============== View Methods ================================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) keySet()

(2) values()

(3) entrySet()



=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
============== Default Methods =============================
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

(1) getOrDefault()

(2) putIfAbsent()

(3) replace()

(4) remove(key,value)

(5) replace(key,value)

(6) compute()

(7) computeIfAbsent()

(8) computeIfPresent()

(9) merge()



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
========================= Important Notes ===============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) All public methods are synchronized.

(2) Null key is NOT allowed.

(3) Null value is NOT allowed.

(4) Uses hashing internally.

(5) Average Time Complexity

        put()      O(1)

        get()      O(1)

        remove()   O(1)

*/

import java.util.Hashtable;
import java.util.Map;

public class p3_HashtableMethods
{

    public static void main(String[] args)
    {

        Hashtable<Integer, String> table = new Hashtable<>();

        table.put(101, "Rahul");
        table.put(102, "Amit");
        table.put(103, "Neha");
        table.put(104, "Rohan");



        // --------- put() -----------------------
        table.put(105, "Vikas");

        System.out.println("\nput()");
        System.out.println(table);



        // --------- get() -----------------------
        System.out.println("\nget()");
        System.out.println(table.get(102));



        // --------- remove() -----------------------
        table.remove(105);

        System.out.println("\nremove()");
        System.out.println(table);



        // --------- size() -----------------------
        System.out.println("\nsize()");
        System.out.println(table.size());



        // --------- containsKey() -----------------------
        System.out.println("\ncontainsKey()");
        System.out.println(table.containsKey(103));



        // --------- containsValue() -----------------------
        System.out.println("\ncontainsValue()");
        System.out.println(table.containsValue("Amit"));



        // --------- keySet() -----------------------
        System.out.println("\nkeySet()");
        System.out.println(table.keySet());



        // --------- values() -----------------------
        System.out.println("\nvalues()");
        System.out.println(table.values());



        // --------- entrySet() -----------------------
        System.out.println("\nentrySet()");

        for (Map.Entry<Integer, String> entry : table.entrySet())
        {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }



        // --------- getOrDefault() -----------------------
        System.out.println("\ngetOrDefault()");
        System.out.println(table.getOrDefault(999, "Not Found"));



        // --------- putIfAbsent() -----------------------
        table.putIfAbsent(101, "Changed");
        table.putIfAbsent(120, "Ankit");

        System.out.println("\nputIfAbsent()");
        System.out.println(table);



        // --------- replace() -----------------------
        table.replace(120, "Ankit", "Ritik");

        System.out.println("\nreplace()");
        System.out.println(table);



        // --------- remove(key,value) -----------------------
        table.remove(120, "Ritik");

        System.out.println("\nremove(key,value)");
        System.out.println(table);



        // --------- clear() -----------------------
        table.clear();

        System.out.println("\nclear()");
        System.out.println(table);

    }

}