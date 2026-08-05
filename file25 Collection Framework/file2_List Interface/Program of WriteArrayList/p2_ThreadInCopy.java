// import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class WriterThread extends Thread
{
    List<String> list;

    WriterThread(List<String> list)
    {
        this.list = list;
    }

    public void run()
    {
            try 
            {
                Thread.sleep(500);  // Delay to allow ReadingThread to start first
                list.add("newItem");
                System.out.println("Adding -> newItem");

                Thread.sleep(500);
                list.remove("Item-1");
                System.out.println("Removing -> Item-1");  
            }
            catch (InterruptedException e) 
            {
                System.out.println("Exception in Writing Thread");
            }
    }
}


class ReadingThread extends Thread
{
    List<String> list;

    ReadingThread(List<String> list)
    {
        this.list = list;
    }

    public void run()
    {
        while (true) 
        {    
            try 
            {   
                for(String item : list)
                {
                    System.out.println("Reading item : " + item);
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException e) 
            {
                System.out.println("Exception in Reading Thread");
            }
        }
    }
}


public class p2_ThreadInCopy 
{
    public static void main(String[] args) 
    {
        // List<String> list = new ArrayList<>(); 
        List<String> list = new CopyOnWriteArrayList<>(); 
        list.addAll(List.of("Item-1", "Item-2", "Item-3", "Item-4"));

        WriterThread writer = new WriterThread(list);
        ReadingThread reader = new ReadingThread(list);

        writer.start();
        reader.start();
    }
}
