/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
---------------------------- Method Overriding -------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> When we inherit a base class into the derived class and we have methods of same name in both the classes.
-> Now if we call the method using derive object then the parent method gets override with child method.

 __________________________
|__Base (display method)__| <---------------------
              |                                   \
 ____________|_______________                      \
|__Derived(display method)__|  <-----------------\
           \\                                     \ <------------(override)
            =========================> {Object.display()}





__________ @Override notation: ____________________________________________________________________________
-> Override notation is used to specify that we are overriding a method from base to child class in java.
-> It is used when we have a method in parent class and we inherit parent to child class. 
   Now we have another same name method in child class also then we require to specify that now 
   we no longer require parent method and child method is consiered by java compiler.

Note: static method, private method, are never be override

*/

class Base{
    public void display()
    {
        System.out.println("I am Base class");
    }
}

class Derived extends Base{
    @Override
    public void display()
    {
        System.out.println("I am Derived class");
    }
}


public class p1_MethodOverriding {
    public static void main(String[] args) {
        
        // Base class Object 
        Base b=new Base();
        b.display();
        
        // Derived class object 
        Derived d=new Derived();
        d.display();
    }
}
