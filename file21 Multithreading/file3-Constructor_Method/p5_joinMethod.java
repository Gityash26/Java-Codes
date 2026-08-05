/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------- join() method -----------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Join method is used when we want to pause the execution of one thread until any other specific 
   thread complete its execution.
-> It is also used to check any thread aliveness
 
BeCareful  It may cause deadlock
*/

class MyThread extends Thread
{
    public void run()
    {
        // try
        // {
        //     this.join();  // In background thread-0 executing an same thread is caling join (self thread sleep untill self thread complete its execution)
        // }
        // catch(InterruptedException e)
        // {
        //     System.out.println("Exception " + e);
        // }

        for(int i=1 ; i<=10 ; i++)
        {
            System.out.println(i + " -> " + Thread.currentThread().getName());
        }
    }
}


public class p5_joinMethod {
    public static void main(String[] args) throws InterruptedException
    {
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.start();
        th1.join();  // main and th2 sleep until the current thread complete its execution
        th2.start();


        for(int i=1 ; i<=10 ; i++)
        {
            System.out.println(i + " -> " + Thread.currentThread().getName());
        }
    }    
}
