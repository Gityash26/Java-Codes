/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
==================== HashMap in DSA ============================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Although HashMap is already predefined in the Collection framework map.
-> Now we are trying to implement basic functionality of HashMap using our own efforts..


======= Basic Operations ===============

(1) put()           : Insert a key-value pair
(2) get()           : Retrieve that associated value with the key
(3) containsKey()   : Check for the existence of a key in the map
(4) containsValue() : Check for the existence of a value in the map
(5) remove()        : Remove a entry
(6) size()          : check for no. of elements present in the map
(7) keySet()        : Returns all the Keys


================
Note:
================
=> All the keys must be unique
=> Values can be same for multiple keys
=> In java, internally we can implemnets Hashmap with the help of [Array of LinkedList]




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================= Implementation of HashMap in DSA =============
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Data structures can be used to implemnet Hashmap data structure

(1) Array of LinkedList
    Each block of arrays contains a linkedList object

    ____     ______________     ______________     ______________
   | 0 |--> |_key1_|_val1_|--> |_key2_|_val2_|--> |_key3_|_val3_|-->  null
   |___|     ______________     ______________
   | 1 |--> |_key5_|_val5_|--> |_key7_|_val7_|--> null
   |___|     ______________     ______________      ______________
   | 2 |--> |_key4_|_val4_|--> |_key6_|_val6_|-->  |_key8_|_val8_|-->  null
   |___|     ______________       ________________
   | 3 |--> |_key15_|_val15_|--> |_key28_|_val28_|--> null
   |___|     ______________     ______________      _________________
   | 4 |--> |_key9_|_val9_|--> |_key22_|_val22_|--> |_key29_|_val29_|--> null
   |___|

   Array                Linkedlist    




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Rehashing  ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

:::::::::::::::::::::::::::::::::::::::::::::::
==== When was rehashing required ===========
-----------------------------------------------

-> Rehasing is only required if ('n' -> total no. of nodes) evenly spread inside the (buckets -> no. of buckets)
    derived as, 
                                          Total no. of nodes 
                ThreshHold (lambda)  =  ---------------------
                                          Available buckets


=================
 Lambda: 
=================
-> It will be the avarage size of the linkedlist a bucket index can hold
-> The value of lambda is always 'less' or 'equal' to a constant Value

           (lambda value) <= (constant value k)
              

for example;
-------------------
-> There is a bucket of size 4 and total no. of nodes inserted are 7, Check when was the rehashing required if 
   the constant value k is 2,

   n (no. of nodes) = 7          ____________________
   N (bucket size)  = 4         |____|____|____|____| --> bucket size = 4
   ThreshHold value = 2           |    |    |    |
                                 []   []   []    []    --> number of nodes = 7
                                 |         |
                                []        []            --> ThreshHold value = 2



-----------------------------------------------------------------------------                                
                                
                 n            7
    Lambda =   -----    =>  -----  =>  1.75      So, 1.75 <= 2 (true)
                 N            4
-----------------------------------------------------------------------------                                

                 n+1          8
    Lambda =   -----    =>  -----  =>  2      So, 1.75 <= 2 (true)
                 N            4
-----------------------------------------------------------------------------                                

                 n+1          9
    Lambda =   -----    =>  -----  =>  2.25   So, 2.25 <= 2 (false)
                 N            4
-----------------------------------------------------------------------------                                




*/
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class p1_Implement 
{
    // Define a simple key-value pair node
    static class HashMap<K, V> 
    {
        private class Node 
        {
            K key;
            V value;

            public Node(K key, V value) 
            {
                this.key = key;
                this.value = value;
            }
        }

        private int bucketSize;                                // Track of array blocks
        private int totalNodes;                                // Track of number of elements 
        private LinkedList<Node> bucket[];



        // construcor of the hashmap class
        @SuppressWarnings("unchecked")
        public HashMap() 
        {
            this.bucketSize = 16;
            this.totalNodes = 0;  
            this.bucket = new LinkedList[bucketSize];  // [*]---> [*]---> []---> []---> [] linkedlist of bucket size 

            for (int i = 0; i < bucket.length; i++) 
            {
                bucket[i] = new LinkedList<>();          // each node now ponts to a new linked list object 
            }
        }

        private int hashFunction(K key) 
        {
            int bi = key.hashCode();               // calculate bucket index[]
            return Math.abs(bi) % bucketSize;
        }

        private int searchInLL(K key, int bucketIndex) 
        {
            LinkedList<Node> list = bucket[bucketIndex];             // []--> []--> [index]--> [] 

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key.equals(key)) { // Use equals() for comparison
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehashing() 
        {
            totalNodes = 0;
            LinkedList<Node> oldBucket[] = bucket;

            bucketSize *= 2;
            bucket = new LinkedList[bucketSize];

            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> li = oldBucket[i];

                for (Node obj : li) {
                    put(obj.key, obj.value);
                }
            }
        }

        public void put(K key, V value) 
        {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if (dataIndex == -1) 
            {
                bucket[bucketIndex].add(new Node(key, value)); 
                totalNodes++;
            } else {
                Node data = bucket[bucketIndex].get(dataIndex);
                data.value = value;
            }

            double lambda = (double) totalNodes / bucketSize;
            if (lambda > 2.0) {
                rehashing();
            }
        }

        public V get(K key) 
        {
            int bucketIndex = hashFunction(key);
            int nodeIndex = searchInLL(key, bucketIndex);

            if (nodeIndex == -1) 
            {
                return null;
            } else {
                Node node = bucket[bucketIndex].get(nodeIndex);
                return node.value;
            }
        }

        public boolean containsKey(K key) 
        {
            int bucketIndex = hashFunction(key);
            int nodeIndex = searchInLL(key, bucketIndex);

            return nodeIndex != -1;
        }

        public boolean containsValue(V value) 
        {
            for (LinkedList<Node> block : bucket) {
                for (Node dataObj : block) {
                    if (dataObj.value.equals(value))
                        return true;
                }
            }
            return false;
        }

        public V remove(K key) 
        {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if (dataIndex == -1)
            {
                return null;
            } else 
            {
                Node node = bucket[bucketIndex].remove(dataIndex);
                totalNodes--;
                return node.value;
            }
        }

        public ArrayList<K> keyset() 
        {
            ArrayList<K> keyList = new ArrayList<>();

            for (int i = 0; i < bucket.length; i++) 
            {
                LinkedList<Node> li = bucket[i];
                for (Node nodeObj : li) 
                {
                    keyList.add(nodeObj.key);
                }
            }
            return keyList;
        }

        public ArrayList<V> values() 
        {
            ArrayList<V> valueList = new ArrayList<>();

            for (int i = 0; i < bucket.length; i++) 
            {
                LinkedList<Node> li = bucket[i];
                for (Node nodeObj : li) 
                {
                    valueList.add(nodeObj.value);
                }
            }
            return valueList;
        }

        public boolean isEmpty() 
        {
            return totalNodes == 0;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while (true) 
        {
            System.out.println("\n=== HashMap Operations Menu ===");
            System.out.println("1. Put");
            System.out.println("2. Get");
            System.out.println("3. Contains Key");
            System.out.println("4. Contains Value");
            System.out.println("5. Remove");
            System.out.println("6. Key Set");
            System.out.println("7. Values");
            System.out.println("8. Is Empty");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter key: ");
                    String key = sc.nextLine();
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    map.put(key, value);
                    System.out.println("Key-Value pair added.");
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    key = sc.nextLine();
                    Integer retrievedValue = map.get(key);
                    System.out.println("Value: " + (retrievedValue != null ? retrievedValue : "Key not found"));
                    break;
                case 3:
                    System.out.print("Enter key: ");
                    key = sc.nextLine();
                    System.out.println("Contains Key: " + map.containsKey(key));
                    break;
                case 4:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    System.out.println("Contains Value: " + map.containsValue(value));
                    break;
                case 5:
                    System.out.print("Enter key: ");
                    key = sc.nextLine();
                    Integer removedValue = map.remove(key);
                    System.out.println("Removed Value: " + (removedValue != null ? removedValue : "Key not found"));
                    break;
                case 6:
                    System.out.println("Keys: " + map.keyset());
                    break;
                case 7:
                    System.out.println("Values: " + map.values());
                    break;
                case 8:
                    System.out.println("Is Empty: " + map.isEmpty());
                    break;
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
