/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
=========== isAlive() method ===================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
-> Thgis method is used to check if a Thread is alive or not finished its execution.


===================================
    Syntax
-----------------------------------
boolean isAlive()
===================================



-> Returns 'True' is the thread is alive and 'False' otherwise




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
=========== join() method ===================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
-> Waits a thread to finish execution before proceeding


===================================
    Syntax
-----------------------------------
join()
===================================

-> Throws InterruptedException if the thread is Interrupted
*/

class myThreadClass implements Runnable
{
    Thread t;

    myThreadClass(String name)
    {
        t = new Thread(this, "ChildThread" + name);
        t.start();
    }

    public void run()
    {
        System.out.println("Thread " + Thread.currentThread().getName() + " started...");

        try{
            for(int i=1 ; i<= 10 ; i++)
            {
                System.out.println("Thread " + Thread.currentThread().getName() + " : " + i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}


public class p4_isAlive_Method 
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("::::::::: Main Thread Started :::::::::");
        
        myThreadClass Th1 = new myThreadClass("One");
        myThreadClass Th2 = new myThreadClass("Two");
        myThreadClass Th3 = new myThreadClass("Three");
        
       
        System.out.println(Th1.t.isAlive());
        System.out.println(Th2.t.isAlive());
        System.out.println(Th3.t.isAlive());
        
        
        Th1.t.join();
        Th2.t.join();
        Th3.t.join();


        System.out.println(Th1.t.isAlive());
        System.out.println(Th2.t.isAlive());
        System.out.println(Th3.t.isAlive());
        
        System.out.println("::::::::: Main Thread Ended :::::::::");
    }    
}
