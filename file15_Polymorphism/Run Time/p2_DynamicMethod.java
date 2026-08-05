

/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=================================== Dynamic Method Dispatch =======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
->  base obj = new child();

-> we are taking reference of base class but object creating of child class.
-> In this approach when we use the object to call the methods :

* Same name function are called of child class. (Overrided methods)
* Other named function are only runs of parent class.


*/

class phone
{
    // Common method 
    public void Turn_on()
    {
        System.out.println("\nTurning on phone...");
    }

    // Different method 
    public void showTime()
    {
        System.out.println("=> The time is 8:00 AM");
    }
}

class Smartphone extends phone
{
    @Override 
    public void Turn_on()
    {
        System.out.println("\nTurning on Smarphone...");
    }

    // Different method
    public void playMusic()
    {
        System.out.println("=> Playing music on Smartphone");        
    }
}


public class p2_DynamicMethod {
    public static void main(String[] args) {

        phone ph;
        Smartphone sp;

        // Base class methods calling 
        ph = new phone();
        ph.Turn_on();
        ph.showTime();

        // Derived class method calling 
        sp=new Smartphone();
        sp.Turn_on();
        sp.playMusic();

        // 'Parent' reference but 'child' class Object 
        ph=new Smartphone();
        ph.Turn_on();
        ph.showTime();
    }
}
