/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============== HashMap vs Hashtable in Multithreading ===================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

This program demonstrates the behavior of HashMap and Hashtable when multiple threads 
modify them simultaneously.


=======================
HashMap
=======================

-> Not Thread Safe

-> Multiple threads can modify the map simultaneously.

-> Result may become inconsistent.


=======================
Hashtable
=======================

-> Thread Safe

-> Methods are synchronized.

-> Only one thread executes a method at a time.



*/

import java.util.HashMap;
import java.util.Hashtable;

public class p4_ThreadingHashTable
{

    public static void main(String[] args) throws InterruptedException
    {

        System.out.println("=============== HashMap ===============");
        testHashMap();

        System.out.println("\n=============== Hashtable ===============");
        testHashtable();

    }


    // ----------------------------------------------------------
    // HashMap Example
    // ----------------------------------------------------------

    public static void testHashMap() throws InterruptedException
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        Thread t1 = new Thread(() ->
        {
            for (int i = 1; i <= 100000; i++)
            {
                map.put(i, i);
            }
        });


        Thread t2 = new Thread(() ->
        {
            for (int i = 100001; i <= 200000; i++)
            {
                map.put(i, i);
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println("Expected Size : 200000");
        System.out.println("Actual Size   : " + map.size());

    }



    // ----------------------------------------------------------
    // Hashtable Example
    // ----------------------------------------------------------

    public static void testHashtable() throws InterruptedException
    {

        Hashtable<Integer, Integer> table = new Hashtable<>();

        Thread t1 = new Thread(() ->
        {
            for (int i = 1; i <= 100000; i++)
            {
                table.put(i, i);
            }
        });


        Thread t2 = new Thread(() ->
        {
            for (int i = 100001; i <= 200000; i++)
            {
                table.put(i, i);
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println("Expected Size : 200000");
        System.out.println("Actual Size   : " + table.size());

    }

}