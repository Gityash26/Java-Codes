/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================= Synchronized Counter =========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> We are trying to create a program in which their is a counter and every thread increment the counter variable by 1.
*/

class Test
{
    int counter;

    Test()
    {
        counter = 0;
    }

    synchronized void increment()
    {
        counter++;
    }
    
    int getCounter()
    {
        return counter;
    }
} 

class ThreadClass implements Runnable 
{
    Thread th;
    Test obj;

    ThreadClass(Test ob)
    {
        obj = ob;
        th = new Thread(this);
        th.start();
    }

    public void run()
    {
        for(int i=1 ; i<= 5000 ; i++)
        {
            obj.increment();
        }
    }

}


public class p4_SyncCounter 
{
    public static void main(String[] args) {
        System.out.println("\n::::::::::::::::::::: Main Thread Started :::::::::::::::::::::::: \n");

        Test obj = new Test();

        ThreadClass t1 = new ThreadClass(obj);
        ThreadClass t2 = new ThreadClass(obj);
        ThreadClass t3 = new ThreadClass(obj);

        try 
        {
            t1.th.join(); // 100 increment
            t2.th.join(); // 100 increment
            t3.th.join(); // 100 increment
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Total Counter = " + obj.getCounter());

        System.out.println("\n::::::::::::::::::::: Main Thread Ended :::::::::::::::::::::::: \n");
    }
}