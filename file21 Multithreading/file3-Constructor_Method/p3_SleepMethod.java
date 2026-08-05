/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------- sleep() method ------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> It is a static method and used to pause the execution of the thread for some miliseconds.
-> It is a method of thread class that takes milisecond value as an argument and stop the execution of the thread.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------- currentThread() method --------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> It will return the current running thread
syntax: 
    public static Thread currentThread()





*/
class MyThread extends Thread 
{
    public void run() 
    {
        
        String Name = Thread.currentThread().getName();
        for (int i = 1; i <= 10; i++) 
        {
            System.out.println(i + " -> " + Name);
            try 
            {
                Thread.sleep(250);
            } 
            catch (InterruptedException e) 
            {
                System.out.println("Exception : " + e);
            }
        }
    }
}

public class p3_SleepMethod 
{
    public static void main(String[] args) 
    {
        MyThread th1 = new MyThread();
        th1.start();

        String Name = Thread.currentThread().getName();

        for (int i = 1; i <= 10; i++) 
        {
            System.out.println(i + " -> " + Name);
            try 
            {
                Thread.sleep(250);
            } 
            catch (InterruptedException e) 
            {
                System.out.println("Exception : " + e);
            }
        }
    }
}
