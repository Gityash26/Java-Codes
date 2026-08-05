/*
______________________________________________
================ Thread Life cycle============
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

          t.start()              ThreadScheduler             t.stop()
 [Born] ------------> [Runnable] ---------------> [Running] ----------------> [Terminated]
                           \                      /
                           \                     /
                           \<-----[Blocked]<----/   t.join()
                     t.resume()                     t.sleep()
                                                    t.wait()
                                                    t.suspend()



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------- Main Thread -----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> By default JVM automatically created a main thread using the main method of the java program.
-> So, the very first thread loads into the thread pool is the main thread.
-> Every other child thread are spawne by the Main Thread.

Note: All the child class are by default name as thread-0, threat-1 ------ thread-n




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------- Calling run() -----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> We all know that when we call the Thread start() method then internally it create an Thread object 
   inside the thread pool and automatically call the run() method that start the thread execution.
-> But what happens when we directly call the run() method.
-> Basically Main Thread already present inside the Thread pool and when we don't call the start() method 
    than no child object created and run() method is called using the Main Thread directly.

*/

class MyThread extends Thread
{
    public void run()
    {
        int c = 10/0;
        System.out.println("\nDivision : " + c);
    }
}

public class p3_ThreadCycle {
    
    public static void main(String[] args) {
        MyThread th = new MyThread();

        th.start();   // Exception in thread-0
        
        th.run();       // Exception in thread "main"
    }

}
