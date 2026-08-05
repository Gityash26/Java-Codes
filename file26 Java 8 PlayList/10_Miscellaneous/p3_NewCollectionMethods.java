/*
===============================================================================
                    New Collection Methods
===============================================================================

Before Java 8,
    We had to write loops manually for the operations like (remove), (replace), (sort) the collection elements.

This increased the amount of code statements.
Java 8 introduced some useful Collection methods to make these tasks simpler.


===============================================================================
New Collection Methods
===============================================================================

Collection
        │
        ├── removeIf()
        │
        ├── forEach()
        │
        └── List
              │
              ├── replaceAll()
              │
              └── sort()


===============================================================================
Method Purpose
===============================================================================

------------------------------------------------------------
removeIf(Predicate)
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=--=-=-=-=-=-=-
    -> Removes all elements that satisfy the given condition.


------------------------------------------------------------
forEach(Consumer)
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=--=-=-=-=-=-=-
    -> Performs an action for every element of the Collection.


------------------------------------------------------------
replaceAll(UnaryOperator)
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=--=-=-=-=-=-=-
    -> Replaces every element with a modified value.

    
------------------------------------------------------------
sort(Comparator)
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=--=-=-=-=-=-=-
    -> Sorts the elements of the List.



===============================================================================
Program
===============================================================================
*/

import java.util.*;

public class p3_NewCollectionMethods
{
    public static void removeIfExample()
    {
        System.out.println("\n -----------------Example of removeIf() method -----------------");

        List<Integer> list = new ArrayList<>(Arrays.asList(10,15,20,25,30,35));

        System.out.println("Before : " + list);
        list.removeIf(num -> num % 2 == 0);          // takes a input returns boolean (T/F   Predicate)
        System.out.println("After  : " + list);
    }

    public static void replaceAllExample()
    {
        System.out.println("\n -----------------Example of replaceAll() method -----------------");

        List<String> names = new ArrayList<>(Arrays.asList("amit","rahul","neha"));

        System.out.println("Before : " + names);

        names.replaceAll(String::toUpperCase);    // takes String return a String (Unary method)
        System.out.println("After  : " + names);

        System.out.println();
    }

    //========================================================

    public static void sortExample()
    {
        System.out.println("\n -----------------Example of sort() method -----------------");
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(40,10,30,20));

        System.out.println("Before : " + numbers);
        numbers.sort(Integer::compareTo);
        System.out.println("After  : " + numbers);
    }

    
    public static void main(String[] args)
    {
        removeIfExample();
        replaceAllExample();
        sortExample();
    }

}

