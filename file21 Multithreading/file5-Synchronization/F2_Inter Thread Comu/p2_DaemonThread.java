/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=========================== Daemon Thread ====================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Daemon Threads runs in the background
-> It has lower priority than the user defined child threads.
-> They are responsible for task like garbage collection, memory management, or other system related tasks.
-> It is created by JVM or other system processes, but can also creates by user applications.
-> It can be used to write logs to files or database.
-> If a daemon thread throws an exception , the JVM does not print stacktace.





~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------- Crerate Daemon Thread -------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Create a new Thread object
-> Call the setDaemon(true) on the thread object before starting it.

Example: 

            DaeThread d1 = new DaeThread();
            d1.setDaemon(true);
            d1.start();


========================================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~ Daemon Thread Methods ~~~~~~~~~~~~~~~~~~~~~~~            
========================================================================

------------------------------
(1) setDaemon() method 
------------------------------
-> This method is used to create a normal thread object as a Daemon thread

------------------------------
(2) start() method 
------------------------------
-> As similarly start a Daemon Thread object execution 

------------------------------
(3) isDaemon() method 
------------------------------
-> Checks if the thread is Daemon thread or not and return a Boolean value





*/

class NormalThreadClass implements Runnable
{
    Thread t;

    NormalThreadClass()
    {
        t = new Thread(this);
    }

    public void run()
    {
        for(int i=1 ; i<=10 ; i++)
        {
            System.out.println("Normal Thread : " + i);
        }
    }
}



class DaemonThreadClass implements Runnable
{
    Thread t;
    DaemonThreadClass()
    {
        t = new Thread(this);
    }
    public void run()
    {
        for(int i=1 ; i<=20 ; i++)
        {
            System.out.println("Daemon Thread : " + i);
         
        }
    }
}

public class p2_DaemonThread 
{
    public static void main(String[] args) 
    {
        System.out.println("\n::::::::::::::::::: Main Thread started ::::::::::::::::::::\n");

        NormalThreadClass th1 = new NormalThreadClass();
        th1.t.start();
        
        DaemonThreadClass d1 = new DaemonThreadClass();
        d1.t.setDaemon(true);
        d1.t.start();
        System.out.println("Check Daemon : " + d1.t.isDaemon());
        

        System.out.println("\n::::::::::::::::::: Main Thread ended ::::::::::::::::::::\n");
    }    
}
