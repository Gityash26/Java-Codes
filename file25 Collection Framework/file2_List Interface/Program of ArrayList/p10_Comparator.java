/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================ Sorting a ArrayList ================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In this concept we are going to learn how a ArrayList can be sort.


~~~~~~~~~~~~~~ Method 1 ~~~~~~~~~~~~~~~~~~~~~~

--------------------------------------
Collections class : 
--------------------------------------
=> Java Collection framework provides a Collections class that contains various static methods 
that are mostly used on Collection framework classes.

=> It provides a 'sort()' method 



~~~~~~~~~~~~~~ Method 2 ~~~~~~~~~~~~~~~~~~~~~~

--------------------------------------
List Interface method : 
--------------------------------------
=> List interface also provides a methods 'sort(comparator)'



~~~~~~~~~~~~~~ Method 3 ~~~~~~~~~~~~~~~~~~~~~~

--------------------------------------
Compartor Inteface : 
--------------------------------------
=> In the List.sort() method we seen that either we are passing 'null' or a 'Comparator.reverseOrder' that
   sort our ArrayList.
=> But don't you wonder what is "Comparator" that we are using.

-> Comparator is an Interface that provides some methods declaration and we can override them to provide 
   our own sorting logic.

-> Compartor inteface contains a method 'compare(T obj1, T obj2)' that takes two argumets of same type
   and comapare their order. 
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class StringlengthComparator implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) 
    {
        // sorting based on string length 
        return o1.length() - o2.length();

    }
    
}


class IntegerComparator implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2) 
    {
        // if (o1 - o2) zero --> equal preference 
        // if (o1 - o2) +ve  --> first o2 then o1 (o1 is greater)
        // if (o1 - o2) -ve  --> first o1 then o2 (o2 is greater)

        // ascending 
        return o1 - o2; 
        
        // descending 
        // return o2 - o1; 
    }
    
}

public class p10_Comparator 
{

    public static void main(String[] args) 
    {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(2, 5, 8, 1, 3, 9, 4, 5));
        ArrayList<String> list2 = new ArrayList<>(List.of("yash", "snajay", "kunal", "deepika", "manisha"));


        // ------------------------------- Collections Class sort() methods ------------------------
        // ===============================================================================
        // Collections.sort(list1);
        // Collections.sort(list2);
        // System.out.println("\nSorted list1 : " + list1);
        // System.out.println("\nSorted list2 : " + list2);
        



        // ------------------------------- List sort() methods ------------------------
        // ===============================================================================
    
        // // -------------------- sort in asscending ---------------------------

        // list1.sort(Comparator.naturalOrder());  // null -> default ascending
        // System.out.println("\nSorted list1 : " + list1);
        
        // list2.sort(Comparator.naturalOrder());
        // System.out.println("\nSorted list2 : " + list2);

        // // -------------------- sort in Descending ---------------------------

        // list1.sort(Comparator.reverseOrder());
        // System.out.println("\nDescending Sorted list1 : " + list1);

        // list2.sort(Comparator.reverseOrder());
        // System.out.println("\nDescending Sorted list2 : " + list2);
        
        
        
    
        // ------------------------------- Implementing Comparator ------------------------
        // ===============================================================================
        list1.sort(new IntegerComparator());
        list2.sort(new StringlengthComparator());        
        System.out.println("\nUser define Comparator Sorted list1 : " + list1);
        System.out.println("\nUser defined Comparator Sorted list2 : " + list2);



            
        // ------------------------------- Using Lamba expression ------------------------
        // ===============================================================================
    //     list1.sort((a, b) -> a-b);
    //     System.out.println("\nlambda sorting of List1 : " + list1);

    //     list2.sort((a, b) -> b.length() - a.length() );
    //     System.out.println("\nlambda sorting of List2 : " + list2);
    }
}
