/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------- Anonymous class --------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In this example we already have a class-A that contain a method show(). And 
-> if we wants to change its method implementation without affecting the actual class.

There are two ways --

Method 1: -> Creating a derived class-B and override the method show()
          ->But an entire class just for one use (inefficient) because it also makes it own class file.

Method 2: -> Override the method without creating any derived class.
          -> A class without having ay name but contains a method is called Anonymous class   
*/

class A 
{
    public void show() 
    {
        System.out.println("\n-> Show method...");
    }
}

/* Method 1 Approach of creating a derived class */

class B extends A 
{
    @Override
    public void show() 
    {
        System.out.println("\n-> Overrided show method.. (Derived class)");
    }
}

// Method 2 Approach of creating a Anonymous class
public class p3_Anonymous 
{
    public static void main(String[] args) 
    {
        // creating object of Derived class
        B obj1 = new B();
        obj1.show();

        // creating object of Base class but override its method
        A obj2 = new A() 
        {
            public void show() 
            {
                System.out.println("\n-> Overrided Show method...(Anonymous class)");
            }
        };

        obj2.show();
    }
}
