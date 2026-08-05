/* 
=============================================
---- (1) Chaining ---------------------------
=============================================

            _________________________________________________
  keys --> |__k1__|__k2__|__k3__|__k4__|__k5__|__k6__|__k7__|



---------------------------------------
Hash function (key)  ====> return key % 7              
---------------------------------------              


     index          keys
     ________________________________
    |  0  |   k2---> k4 ---> k6     |
    |_____|_________________________|
    |  1  |   k1                    |
    |_____|_________________________|
    |  2  |                         |    
    |_____|_________________________|    LinkedList to store nodes at each slot
    |  3  |   k3--> k7              |    -------------------------------------------------------------------
    |_____|_________________________|    [index slot]=========[node1]--> [node2]--> [node3]--> [node4] 
    |  4  |   k5                    |
    |_____|_________________________|
    |  5  |                         |
    |_____|_________________________|


-> Chaining technique is basically cretaing a Hash Table using a Array of fixed size and Array size should be 
   large enough to cover the range of generated index numbers comes form the hash function.

-> And if two or more generated index of different keys are collapse then simply we 'chain' them at their corresponding
   array index using linkedList or any other data structure.


=============================================
---- Performance of Chaining ----------------
=============================================

-> 'M' is the size(slots) of the hash table in which keys are going to distribute.
-> 'N' is the number of keys to be inserted in the hash table.

-> Load Factor = N/M      

Note: We always try to keep the Load Factor as low as possible, And incase of load factor is high then 
      we increase the slot size of the hash table.
      

-> Expected time to search a key = O(1 + Load Factor)
-> Expected chain length = Load Factor



=============================================
---- Limitation of Chaining----------------
=============================================

(1) As no. of entries increases, each 

*/

import java.util.LinkedList;

public class Type1_Chaining 
{
    public static void main(String[] args) 
    {
        int[] array = {50, 21, 58, 17, 15, 49, 56, 22, 23, 25};

        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] hashTable = new LinkedList[10];

        for(int val : array)
        {
            int index = val % 7;

            if(hashTable[index] == null)
                hashTable[index] = new LinkedList<>();
            
            hashTable[index].add(val);
        }

        for(int i=0 ; i<hashTable.length ; i++)
        {
            if (hashTable[i] != null) 
            {
                System.out.println("Index " + i + " -----------> " + hashTable[i].toString());
            }
        }

    }
    
}
