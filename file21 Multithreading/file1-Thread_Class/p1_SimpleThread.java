/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------ Thread ----------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Thread is a smallest unit of processing that can be execute by the processor.
-> Any thread in the system if require to execute first loads into the thread pool.
-> And then the thread scheduler schedule one by one threads from the thread pool to the processor.
-> Basically we associate some code with thread to execute our code. 


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Implementing Multithrading in java
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Thread class
(2) Runnable Interface

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Thread clasd in JAVA
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Thread class provided by java.lang package in java.
-> Thread class provide various "Constructors" and "Methods" to create and manipulate threads in java



interface Runnable
{
    void run();

}

class Thread implements Runnable
{
    Thread()
    { ........
      ........
    }

    Thread(string)
    { ........
      ........
    }

    Thread(runnable)
    { ........
      ........
    }

    Thread(string, runnable)
    { ........
      ........
    }

    void setPriority(int)
    { ........
      ........
    }

    void getPriority()
    { ........
      ........
    }
    
    void setName(String)
    {
      ........
      ........

    }
    String getName()
    {
      ........
      ........
    }
    void start()
    {
        .......
        .......
        run()
    }

}
    

*/
class MyThread extends Thread 
{
    @Override
    public void run() 
    {
        System.out.println("\nRun method called...");
    }
}

public class p1_SimpleThread
{
    public static void main(String[] args) 
    {
        MyThread th = new MyThread(); // ---> new state
        th.start();
    }
}
