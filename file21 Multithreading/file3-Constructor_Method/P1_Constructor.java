/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------------- Thread CLass Constructors -----------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Thread class provide various constructors:

1. Thread()  ->  This creates a new thread object.

2. Thread(String name)  ->  This creates a new thread with a specified name.

3. Thread(Runnable target)  ->  This creates a new thread that executes the specified Runnable target.

4. Thread(Runnable target, String name)  ->  This creates a new thread with a specified name that executes the 
                                             specified Runnable target.
*/

// First Thread class 
class ThreadClass_1 extends Thread 
{
    public void run() 
    {
        System.out.println("\nThread() Constructor Running...");
    }
}

// Second Thread class
class ThreadClass_2 extends Thread 
{
    public ThreadClass_2(String name) 
    {
        super(name);
    }

    public void run() 
    {
        System.out.println("\nThread(String name) Constructor Running... \n Thread Name : " + this.getName());
    }
}

// first Interface
class MyRunnableInterface1 implements Runnable 
{
    public void run() 
    {
        System.out.println("\nThread (Runnable target) Constructor Running...");
    }
}

//  Second Interface 
class MyRunnableInterface2 implements Runnable 
{
    public void run() 
    {
        System.out.println("\nThread (Runnable target , String name) Constructor Running...");
    }
}

// Main Thread class
public class P1_Constructor 
{
    public static void main(String[] args) 
    {
        // Thread() constructor
        ThreadClass_1 T1 = new ThreadClass_1();
        T1.start();

        // Thread(String name) constructor
        ThreadClass_2 T2 = new ThreadClass_2("Harry_Thread");
        T2.start();

        // Thread(Runnable target) constructor
        MyRunnableInterface1 bullet1 = new MyRunnableInterface1();
        Thread Gun1 = new Thread(bullet1);
        Gun1.start();

        // Thread(Runnable terget , String name) constructor
        MyRunnableInterface2 bullet2 = new MyRunnableInterface2();
        Thread Gun2 = new Thread(bullet2, "Kar98");
        Gun2.start();
        System.out.println("Thread name : " + Gun2.getName());
    }
}
