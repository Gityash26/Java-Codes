/* 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====== Insertion in HashMap =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                put(key, value)
            ___________|________________
            |                          |
         (exist)                    (not exist) 
            |                          |
      update value              inserted new pair


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====== Searching in HashMap =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             
                contains(key)
             _________|_________________
            |                          |
         (exist)                    (not exist) 
            |                          |
      return true                   return false


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====== Retrieve mapped Value in HashMap =================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                  get(key)
             _________|_________________
            |                          |
         (exist)                    (not exist) 
            |                          |
      return value                   return null


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====== Iteration in HashMap =============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

(1) values() : Retruns all the mapped Values (Collection view)
(2) keySet() : Retruns all the mapped keys in (Set view)
(3) entrySet : Retruns all the entries pairs (Set view)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====== Remove entry from the HashMap ====================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            remove(key)                                 remove(key, value)
    _____________|___________________               _____________|___________________
    |                               |               |                               |
(key exist)                  (key not-exist)     (pair exist)                 (pair not-exist)
    |                               |               |                               |
Remove pair                       null          Remove pair                        null




*/


import java.util.HashMap;
import java.util.Map;


public class p2_BasicOperation 
{
    // Inserting method 
    static void insertData(HashMap<Integer, String> map)
    {
        String arr[] = {"one", "two", "three", "four", "five", "Six", "seven", "eight", "nine", "ten"};

        for(int i=0 ; i<arr.length ; i++)
        {
            map.put(i+1, arr[i]);
        }
        System.out.println("\nMap after inserting entries : " + map);
    }

    // searching method 
    static void search(HashMap<Integer, String> map)
    {
        System.out.println("\nkey 3 exist in the map? : " + map.containsKey(3));
        System.out.println("\nValue Grapes exist in the map? : " + map.containsValue("Grapes"));
    }

    static void retrieve(HashMap<Integer, String> map)
    {
        System.out.println("\nRetrieving value at key 3 : " + map.get(3));
        System.out.println("\nRetrieving value at key 7 : " + map.get(7));
        System.out.println("\nRetrieving value at key 24 : " + map.get(24));
    }

    static void iterateHashMap(HashMap<Integer, String> map)
    {
        System.out.println("\nIterate all the values : ");
        for(String val : map.values())
        {
            System.out.println("=> " + val);
        }


        System.out.println("\nIterate all the keys : ");
        for(Integer key : map.keySet())
        {
            System.out.println("=> " + key);
        }


        System.out.println("\nIterate all the entries : ");
        for(Map.Entry<Integer, String> e : map.entrySet())
        {
            System.out.println("=> key : " + e.getKey() + ", value : " + e.getValue());
        }
        
    }

    static void removeEntry(HashMap<Integer, String> map)
    {
        map.remove(9);
        System.out.println("\nremoving key-9 entry : " + map);
        
        map.remove(10, "ten");
        System.out.println("\nremoving key-value (10-'ten') entry : " + map);

    }
    public static void main(String[] args) 
    {
        HashMap<Integer, String> map = new HashMap<>();
        insertData(map);
        search(map);
        retrieve(map);
        iterateHashMap(map);
        removeEntry(map);
    }    
}
