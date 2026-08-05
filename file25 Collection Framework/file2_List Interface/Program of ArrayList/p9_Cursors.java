/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=================== cursors in java ============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Cursors in java are used to retrieve the elements one by one from the Collection object.
-> There are three cursors in java collection framework:

==========================
(1) Iterator cursor
==========================
-> get from the iterator() method
-> Can be used with any collection 
-> Retrieving in forward direction only (===>)
-> Can be used for {Read} , {Remove} , {Retrieve}

:::::::::::::::: Iterator methods :::::::::::::::: 
(1) next()
(2) hasNext()
(3) remove()
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:


==========================
(2) ListIterator cursor
==========================
-> get from the listIterator() method
-> Can be used with only List Implemented classes (ArrayList, LinkedList, Vector, Stack)
-> Retrieving in forward & Backward direction (<===>)
-> Can be used for {Read} , {Retrieve} , {Replace} , {Add}


:::::::::::::::: ListIterator methods :::::::::::::::: 
(1) next()
(2) hasNext()
(3) previous()
(4) hasPrevious()
(5) set()
(6) remove()
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:



==========================
(3) Enumeration cursor
==========================
-> get from the getElement()
-> Can be used with only legacy classes (Vector, Stack)
-> Retrieving in forward direction only (===>)
-> Can be used for {Read} only.


:::::::::::::::: Enumeration methods :::::::::::::::: 
(1) hashMoreElement()
(2) nextElement()
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:






*/

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class p9_Cursors 
{
    static void Type1(ArrayList<String> list)
    {
        System.out.println("\n~~~~~~~~~~~~~~~~~ Display using Iterator Cursor ~~~~~~~~~~~~~~~~~~~\n");
        
        // Iterator cursor
        Iterator<String> itr = list.iterator(); 

        while(itr.hasNext())
        {
            System.err.println("Element : " + itr.next());
        }
    }
    
    static void Type2(ArrayList<String> list)
    {
        // ListIterator cursor
        System.out.println("\n~~~~~~~~~~~~~~~~~ Display using Iterator Cursor ~~~~~~~~~~~~~~~~~~~\n");
        
        ListIterator<String> listItr = list.listIterator();
        
        // displaying in forward direction 
        while(listItr.hasNext())
        {
            System.out.println("Element ["+ listItr.nextIndex() +"] : " + listItr.next());
        } 
        
        // displaying in backward direction 
        System.out.println("\nBackward direction...\n");

        while(listItr.hasPrevious())
        {
            System.out.println("Element ["+ listItr.previousIndex() +"] : " + listItr.previous());
        } 

    }
    
    static void Type3()
    {
        // Enumeration cursor
        System.out.println("\n\n~~~~~~~~~~~~~~~~~ Display using Iterator Cursor ~~~~~~~~~~~~~~~~~~~\n");

        Vector<String> v = new Vector<>();
        v.add("Red");
        v.add("Blue");
        v.add("Green");
        v.add("Gray");

        Enumeration<String> enumItr = v.elements();

        while (enumItr.hasMoreElements()) 
        {
            System.err.println(enumItr.nextElement());
        }
    }

    
    public static void main(String[] args) 
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("Yash");
        list.add("Kunal");
        list.add("Snajay");

        Type1(list);
        Type2(list);
        Type3();
    }    
}
