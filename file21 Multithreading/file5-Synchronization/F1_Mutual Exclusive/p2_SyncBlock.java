/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 Synchronizaed Block
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In this example we are trying to implement synchronization on a class that is not created by the user itself
   it means that we cannot use the synchronized keyword in the method defination.
   Now we have to make a synchronized block and make the statement inside it 
*/



// Non changeble class
class TestClass
{
    void display()
    {
        System.out.println("\nHello Programmer " + Thread.currentThread().getName());

        try 
        {
            Thread.sleep(500);  // sends the thread block state just after msg
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Your Registration successfully done " + Thread.currentThread().getName());   // Remaining msg
    }
}


class Programmers extends Thread
{
    TestClass obj;

    Programmers(String name, TestClass obj)
    {
        super(name);
        this.obj = obj;
        this.start();
    }

    public void run()
    {
        synchronized(obj)
        {
            obj.display();
        }
    }
}

public class p2_SyncBlock 
{
    public static void main(String[] args) 
    {
        System.out.println("\n:::::::::::::::::: Main Thread Started ::::::::::::::::::\n");

        TestClass obj = new TestClass();

        Programmers p1 = new Programmers("Yash", obj);
        Programmers p2 = new Programmers("Byomkesh", obj);
        Programmers p3 = new Programmers("Sanjay", obj);
        
        try 
        {
            p1.join(); // Only p1 thread executs until finish and other goes into waiting state
            p2.join(); // Only p2 thread executs until finish and other goes into waiting state
            p3.join(); // Only p3 thread executs until finish and other goes into waiting state
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
            
        System.out.println("\n:::::::::::::::::: Main Thread Ended ::::::::::::::::::\n");
        }
        
}