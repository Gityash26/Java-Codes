/* 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------Types of Thread Synchronization --------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                             |
         ____________________|________________________________
        |                                                    | 
 Mutual Exclusive                                   Inter Thread Communication






~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------------- Inter Thread Communication -------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Inter Thread Communication is also known as "Cooperation"

-> Inter Thread Communication is needed when we develop an application where two or more threads exchange some set of information.

-> To utilise shared resources, synchronize thread activities prevent data corruption or inconsistent states.

-> It is aciheved by using three final methods 'wait()', 'notify', and 'notifyAll()'. 

-> Example: A producer - consumer sceneario where one thread [Produce data] and another thread [Consumes] it .




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------------- Three Methods -------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> wait(), notify() and notifyAll() methods are final (no overriden allowed)

-> These methods are defined in Object class (not in Thread class)

-> These method can be called using synchronized context only. 



=======================
-- wait() -------------
=======================
-> It causes the current thread to wait untill another thread invokes 'notify()'

syntax:
    public void wait()


=======================
-- notify() -----------
=======================
-> It notify() or activate the specific single thread that is in blocked state due to wait() and waiting for the notify()

syntax:
    public void notify()


=======================
-- notifyAll() ---------
=======================
-> It activates all the threads that are waiting for the notify signal due to calling wait()

syntax:
    public void notifyAll()





~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Question: why wait(), notify() and notifyAll() methods are defined in the Object class 
           and not in the Thread class.
----------------------------------------------------------------------------------------
Ans: As every object in java has only one lock (monitor) and wait(), notify() & notifyAll() 
     are used for lock (monitor) sharing
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

*/



/* 
In this program we are creating two threads one is 'Data Producer Thread' and other  is "COnsumer Thread"


                ____________________               ___________________
               |                   |              |                  |
               |    TestClass      |              |   Producer       |
               |                   |             /|   Thread         |
               |                   |           /  |__________________|
               |                   |         /
               |     getValue()    |<------/
               |                   |
               |                   |               ___________________
               |     putValue()    |------\       |                  |
               |                   |       \----> |   Consumer       |
               |                   |              |   Thread         |
               |___________________|              |__________________|






*/ 

class TestClass 
{
    int counter;
    boolean flag = false;

    synchronized void putValue(int c)
    {
        while(flag) // false -> No value updated , True-> Value updated
        {
            try
            {
                wait();
            } 
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        counter = c;
        System.out.println("putValue() : " + counter);    
        flag = true;
        notify();
    }
    
    synchronized void getValue()
    {
        while(!flag) // flag == false
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("getValue() : " + counter);    
        flag = false;
        notify();
    }
}

class Producer implements Runnable 
{
    TestClass obj;
    Thread th;
    Producer(TestClass ob)
    {
        obj = ob;
        th = new Thread(this, "Producer");
        th.start();
    }

    public void run()
    {
        int counter = 1;
        for(int i=1 ; i<= 10 ; i++)
        {
            obj.putValue(counter++);
            try 
            {
                Thread.sleep(100);    
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable 
{
    TestClass obj;
    Thread th;
    Consumer(TestClass ob)
    {
        obj = ob;
        th = new Thread(this, "Consumer");
        th.start();
    }

    public void run()
    {
        for(int i=1 ; i<= 10 ; i++)
        {
            obj.getValue();
            try 
            {
                Thread.sleep(500);    
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

public class p1_ProducerConsumer
{
    public static void main(String[] args) 
    {
        System.out.println("\n::::::::::::::::::::: Main thread started :::::::::::::::::::\n");
        
        TestClass obj = new TestClass();

        Producer p = new Producer(obj);
        Consumer c = new Consumer(obj);

        try 
        {
            p.th.join();
            c.th.join();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

        System.out.println("\n::::::::::::::::::::: Main thread started :::::::::::::::::::\n");
    }
    
}
