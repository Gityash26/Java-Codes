/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------ Thread States: ---------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-----------------------------------------------------------------------------------------------------------------------

=> New State : constructor has been called
-----------------------------------------------------------------------------------------------------------------------

Runnable State : start() method has been called
-----------------------------------------------------------------------------------------------------------------------
________________________________________________________________________________________
| Running State : Thread scheduler schedule Thread over CPU  + Execution of run() start |  --> Not any official state
|_______________________________________________________________________________________|
-----------------------------------------------------------------------------------------------------------------------

Time Waiting State : sleep(args) or join(args) method called 
-----------------------------------------------------------------------------------------------------------------------

Waiting State : wait() or join() method has been called
-----------------------------------------------------------------------------------------------------------------------

Blocked State : Thread waits to acquire lock
-----------------------------------------------------------------------------------------------------------------------

Terminated State : Execution of run() method has been finished
-----------------------------------------------------------------------------------------------------------------------


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------------------- Thread Synchronization -----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Synchronization is a mechanism that is used to control the access of the multiple threads accessing 
   'shared Resources'.  

for example: 

    (1) Suppose there is a method that takes a number as an argument and print its table.
        If two threds are using same method then they should be mutual exclusive because if 
        one thread is printing table of 5 then other one should wait till first one complete its table.

    (2) Suppose Kunal had a bank account with the balance of Rs -> 50000,
        Ramesh trying to deposite Rs500 and Suresh wants to withdraw Rs 500 from Kunal's account at the same time
        
        In that case,                    |=====================\
                                        | Kunal Account (5000) |
        In that case,                   \=====================/
                                         
                _____________________________            _____________________________
               |      Ramesh ( + 500)       |           |       Suresh ( - 500)      |
               |============================|           |============================|
               |                            |           |                            |
               |   bal = Kunal_bal          |           |   bal = kunal_bal          |
               |                            |           |                            |
               | In actual,                 |           |  In actual,                |
               |    bal + 500 = 5500        |           |     bal - 500 = 4500       |
               |                            |           |                            |
               |  Update,                   |           |  update,                   |
               |     kunal_bal = bal        |           |      kunal_bal = bal       |
               |                            |           |                            |
               |  Result -> 5500            |           |     Result -> 4500         |
               |____________________________|           |____________________________|


Note: If Ramesh and Suresh both deposite and withdraw at the same time then their is a chnace of getting false output
       becuase both access the amount at the same time and update at the Real account details

       Ramesh (5000 + 500 = 5500) -> Suresh (5500 - 500 = 5000)

       !! But !!

       We are getiing the Account balance Either (5500) OR (4500) after updation


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
===== Synchronization ===================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Therefore we have to ensure that multiple Thread access to same resources should be Mutually exclusive
   So that, only one thread access allowed at a time 
   
-> Java support very strong support to the multithreading so we have to know about the Mutual Exclusion and Synchronization properly
   Importatnt for the majority of sectors like Banking Transactions

----------------------------------------------------------
-> It is achieved through the "synchronized" keyword
----------------------------------------------------------

-> synchronized keyword ensure that only one thread can execute a 'specific method' or a 'block of code' at a time

-> It maintains data consistency and ensure Thread Sefety.






~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------Types of Thread Synchronization --------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                             |
         ____________________|________________________________
        |                                                    | 
 Mutual Exclusive                                   Inter Thread Communication





======================================
 (1) Mutual Exclusive
======================================
-> While sharing any resources, this will keep the thread interfering with one anotrher 
   i.e, mutual exclusive


Two ways to implement mutual exclusive_______________
=====================================================
(A) Synchronized Method
(B) Synchronized Block



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 (A) Synchronized Method ------------------------------------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Note: Making an entire method synchronized is useful when the method is created by the user itself and we have the 
       access to change the method defination 

-> It uses `synchronized` keyword before the method declaration 
-> Locks the entire method for other threads
-> Only one thread can execute the method at a time


==================================================
syntax: (To make entire method citical)
__________________________________________________

public synchronized void method_Name()
{
    ..............
    ..............
    }
    
    
    
    
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(B) Synchronized BLock ------------------------------------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Note: Making a synchronized block is used when we are using an import class and we can not change the method defination 
so that we can make a synchronized block
    
-> Uses the `synchronized` keyword before a block of code 
-> Locks a specific block of code
-> Can be used to lock any object, not just current object (this)
    
    
=====================================================
 syntax: (To make some statements of method citical)
__________________________________________________

public void method_Name()
{
    ..............
    ..............
    synchronized (lockObject)
    {
        // code to be synchronized
    }
    ..............
    ..............
}

*/


class Test
{
    // Without synchronized current thread gets sleep and other thread get the control 
    // With synchronized current thread sleeps but no other thread allowed until execution not finished 

    synchronized void printMsg(String msg)
    {
        System.out.println("\nHello " + msg);
        try 
        {
            Thread.sleep(500);  // sends the thread block state just after msg
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Continue of " + Thread.currentThread().getName() + " statement...");   // Remaining msg
    }
}


class ChildThread implements Runnable
{
    Thread t;
    String msg;
    Test obj;

    ChildThread(String msg, Test obj)
    {
        this.msg = msg;
        this.obj = obj;
        t = new Thread(this, msg);     // (Runnable , Thread name)
        t.start();
    }

    public void run()
    {
        obj.printMsg(msg);
    }
}

public class p1_ThreadSync
{
    public static void main(String[] args) 
    {
        System.out.println("\n:::::::::::::::::: Main Thread Started ::::::::::::::::::\n");
        Test obj = new Test();
        
        ChildThread th1 = new ChildThread("Good morning", obj);
        ChildThread th2 = new ChildThread("Good evening", obj);
        ChildThread th3 = new ChildThread("Good night", obj);

        try 
        {
            th1.t.join(); // Only th1 thread executs until finish and other goes into waiting state
            th2.t.join(); // Only th2 thread executs until finish and other goes into waiting state
            th3.t.join(); // Only th3 thread executs until finish and other goes into waiting state
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("\n:::::::::::::::::: Main Thread Ended ::::::::::::::::::\n");
    }
}


