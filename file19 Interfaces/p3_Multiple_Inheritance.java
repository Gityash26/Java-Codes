/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-------------------------- Multiple Inheritance ---------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Multiple inheritance is a type of inheritance in which multiple parent classes 
   are inherits their property into a single derived class.
-> Java doesn't support multiple inheritance because it leads to confusion and les maintainability of the code.
-> But we can implement Multiple Inheritance using Interfaces in java.
-> Interfaces only contains final variables and static public methods.


~~~~~~~~~~~~~~~~~~~~~~~~
----- Note -------------
~~~~~~~~~~~~~~~~~~~~~~~~
-> Yes it is true that all the ambiguity occurs due to multiple inheritance can be resolved just like C++
   But In simple way if we wants to define why java not support this is that "JAVA having a better way to resolve it".


    /============\     ________     ____________       ________________
   | Cell_phone  |    |__GPS__|    |__Camera___|      |_Media_Player__|
   \============/        |              |                   |
        |                |              |                   |
        |______________  |   ___________|                   |              
                      |  |  |   ____________________________|
                      |  |  |  | 
                 /==================\
                |    Smartphone     |   <- inherit Cellphone class
                \==================/    <- implement GPS, Camera, MediaPlayer
*/

interface Camera 
{
    void takeSnap();
    void recordVideo();
}

interface Wifi
{
    String[] getNetwork();
    void connectToNetwork(String network);
}

class MyPhone
{
    void callNumber(int number)
    {
        System.out.println("Calling..." + number);
    }
    void reeiveCall()
    {
        System.out.println("Receiving...");
    }
}

class MySmartPhone extends MyPhone implements Camera,Wifi
{
    public void takeSnap()
    {
        System.out.println("Taking snapshot...");
    }

    public void recordVideo()
    {
        System.out.println("Recording Video...");
    }

    public String[] getNetwork()
    {
        String[] networkList={"harry","Prashant","Anjali667"};
        return networkList;
    }

    public void connectToNetwork(String network)
    {
        System.out.println("Connecting to " + network);
    }
} 


public class p3_Multiple_Inheritance 
{
    public static void main(String[] args) 
    {
        MySmartPhone ms = new MySmartPhone();
        String[] network = ms.getNetwork();
        for(String net : network)
        {
            System.out.println("Network -> " + net);
        }
    }
}
