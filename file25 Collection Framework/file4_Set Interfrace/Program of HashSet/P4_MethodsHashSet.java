/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===================== Methods of HashSet ===========================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

========================================
 Basic Methods
========================================
(1) boolean add(Element e):
    Insert a specified element in the set if it is not already exist.

(2) boolean remove(Object ob):
    Remove a specified element from the set if it is present.

(3) boolean contains(Object ob):
    Checks for specified element is present in the set.

(4) int size():
    Retruns the no. of elemnet present in the set.

(5) boolean isEmpty():
    Checks if the set is empty.

(6) void clear():
    Remove all the elements from the set.

(7) Iterator<E> iterator:
    Retruns an iterator to traverse over the set element.


    
========================================
 Bulk Operations
========================================

(1) boolean addAll(Collection c)
    Adds all the elements from the specified collection to the set, ignoring duplicates.

(2) boolean removeAll(Collection c)
    Removes all elements in the set that are also contained in the specified collection.

(3) boolean retainAll(Collection c)
    Retains only the elements in the set that are also contained in the specified collection.

(4) boolean containsAll(Collection c)
    Checks if the set contains all the elements in the specified collection.

    
========================================
 Comprision & hashing Operations
========================================

(1) boolean equals(Object o)
    Compares the specified object with the set for equality

(2) int hashCode()
    retruns the hashcode value for the set.


*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class P4_MethodsHashSet 
{
    void basicOperation()
    {
        HashSet<Integer> hash = new HashSet<>();

        // adding element 
        hash.add(22);
        hash.add(44);
        hash.add(66);
        System.out.println("\nAfter adding 22, 44, 66 element : " + hash);

        // removing element 
        hash.remove(22);
        System.out.println("Removing 22 form the set : " + hash);

        // check for contains
        System.out.println("Is 66 present in the set : " + hash.contains(66));
        
        // check for size 
        System.out.println("Total no. of elements in the set : " + hash.size());

        // chekc for empty 
        System.out.println("HashSet is empty? : " + hash.isEmpty());

        // clearing all element 
        hash.clear();
        System.out.println("Clear HashSet : " + hash.isEmpty());

        // Iterating using iterator 
        Iterator<Integer> itr = hash.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        } 
    }

    void bulkOperation()
    {
        HashSet<Integer> hash = new HashSet<>();

        // adding collection 
        hash.addAll(Arrays.asList(22, 33, 44, 55, 66, 77, 88, 99));
        System.out.println("\nAdding Collection of elements : " + hash);
        
        // removing a collection 
        hash.removeAll(Arrays.asList(44, 55));
        System.out.println("Removing Collection of (44, 55) : " + hash);

        // retaining a collection
        hash.retainAll(Arrays.asList(22, 33, 66));
        System.out.println("Retaining Collection of (22, 33, 66) : " + hash);

        // checking if the set contains all elements of a collection
        boolean containsAll = hash.containsAll(Arrays.asList(22, 33));
        System.out.println("HashSet contains all elements of (22, 33) : " + containsAll);
    }

    void comparisionHashOperation()
    {
        HashSet<Integer> hash1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> hash2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // check for equals 
        boolean isEqual = hash1.equals(hash2);
        System.out.println("HashSet1 equals HashSet2 : " + isEqual);

        // get hash code
        System.out.println("HashSet1 hashCode : " + hash1.hashCode());
        System.out.println("HashSet1 hashCode : " + hash2.hashCode());
    }

    public static void main(String[] args) 
    {
        P4_MethodsHashSet obj = new P4_MethodsHashSet();

        obj.basicOperation();
        obj.bulkOperation();
        obj.comparisionHashOperation();
    }    
}
