/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
-------------------- Runnable Interface --------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Java provides Runnable interface to create multiple thread in our java program 
-> Runnable Interface only provides a single method Run()

Runnable Interface (run())
     |
 Thread Class (start(), currentThread(), sleep() ----- etc)
     |
  MyThread (user defined)



  Note: In the runnable interface it only provides run() method.
         And we know we don't call it directly otherwise the main thread execute it instead of our defined thread.
         Therefore we create a Thread class object and send our Interface derivd class object as argument.


===========================================================================================================================
-> In The below program example we use a terminology that A 'Bullet' is only single functionality run(). 
   So we considere bullet as a Runnable Interface.

-> And without gun we can't use a bullet for any purpose so now we have to create a gun objet. Means Thread class 
   object that provides various functionlities like start(), setname(), currentName() ------- etc.
   We have to insert the bullet in its gun.
===========================================================================================================================

*/

class Runnable_Thread_1 implements Runnable 
{
    public void run() 
    {
        for (int i = 1; i <= 10; i++)
            System.out.println("Runnable Thread 1 ");
    }
}

class Runnable_Thread_2 implements Runnable 
{
    public void run() 
    {
        for (int i = 1; i <= 10; i++)
            System.out.println("Runnable Thread 2 ");
    }
}

public class p1_Runnable_Interface 
{
    public static void main(String[] args) 
    {
        Runnable_Thread_1 bullet1 = new Runnable_Thread_1();
        Thread gun1 = new Thread(bullet1);

        Runnable_Thread_2 bullet2 = new Runnable_Thread_2();
        Thread gun2 = new Thread(bullet2);

        gun1.start();
        gun2.start();
    }
}
