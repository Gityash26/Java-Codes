/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========== Synchronized Vector Example ============
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

// import java.util.ArrayList;

import java.util.Vector;


class MyThread extends Thread 
{
    Vector<Integer> list = new Vector<>();

    MyThread(Vector<Integer> list)
    {
        this.list = list;
    }

    public void run()
    {
        for(int i=1 ; i<=100 ; i++)
        {
            list.add(i);
        }
    }
}


public class p3_ThreadVector 
{
    public static void main(String[] args) 
    {
        // ------------------------------------------------Trying with ArrayList  
        // ArrayList<Integer> list = new ArrayList<>();

        // -------------------------------------------------Trying witth vector 
        Vector<Integer> list = new Vector<>();

        MyThread t1 = new MyThread(list);
        MyThread t2 = new MyThread(list);

        t1.start();
        t2.start();

        try 
        {
            t1.join();
            t2.join();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Size of the list = " + list.size());
        System.out.println(list);


    }    
}
