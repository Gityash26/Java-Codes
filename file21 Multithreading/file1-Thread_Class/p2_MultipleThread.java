
class MyThread extends Thread 
{
    @Override
    public void run() 
    {
        String n = Thread.currentThread().getName();
        for (int i = 1; i <= 10; i++) 
        {
            System.out.println(n + "-> " + i);
        }
    }
}

public class p2_MultipleThread 
{
    public static void main(String[] args) 
    {

        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.setName("Thread_1");
        th1.setName("Thread_2");

        th1.start();
        th2.start();

    }
}
