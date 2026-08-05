/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------ Default Methods --------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> An interface can have static and default methods in java.
-> default methods are use to update or change the existing interface.
-> Normally we cannot change or update any inteface but default methods are introduced in java-8 
-> Class implements the interfaces not need to define default methods.  

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------- why default methods -----
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> We all know that interfaces are pure abstract class that only contains abstract methods but still 
   we can define our methods inside the interface.
-> It is just because we don't want to affect other classes using the iterface just for one additional method add on.
-> If we wants to add another methods inside the interface then we require to implement change in all the classes implements 
   that interface that's why using default methods we can simple add our method definition in the interface directly..
-> Private methods can also implement into the interface But private methods can only visible inside that same class.
   It just use with other default methods to seperat the logic.

*/



interface Computer
{
    void code();

    // private methods
    private void Greet()
    {
        System.out.println("Good morning...");
    }

    // default method 
    default void playGames()
    {
        Greet();
        System.out.println("Playing Games...");
    }

}


class Laptop implements Computer
{
    public void code()
    {
        System.out.println("\nStart Code, compile, Run : On Laptop");
    }

}




public class p4_DefaultMethod 
{
    public static void main(String[] args) 
    {
        Laptop lap = new Laptop();
        lap.code();
        lap.playGames();
    }    
}
