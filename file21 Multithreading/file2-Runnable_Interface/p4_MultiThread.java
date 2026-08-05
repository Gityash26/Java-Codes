
class childThread implements Runnable
{
    String name;
    Thread t;

    childThread(String name)
    {
        this.name = name;
        t = new Thread(this);
        t.start();
    }

    public void run()
    {
        System.out.println("Child Thread " + name + " Started...");
        try 
        {
            for(int i=1 ; i <= 10 ; i++)
            {
                System.out.println("Child Thread " + name + " : " + i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Child Thread " + name + " Ended...");
    }    
}


public class p4_MultiThread 
{
    public static void main(String[] args) 
    {
        System.out.println(":::::::::: Main Thread Started ::::::::::");
        
        new childThread("One");        
        new childThread("Two");        
        new childThread("Three");        

        System.out.println(":::::::::: Main Thread Ended ::::::::::");
    }    
}
