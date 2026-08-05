/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------------------- Constructor in Inheritence ----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> When we inherit the class A into Derived class B, and create the object of derived class then the 
   constructor of Base class execute fist and then the constructor of the derived class,
   
   class A  (Base constructor)
      |
      |
    Class B (Derived Constructor)


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------------------- super() keyword -------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> super keyword in java is used to refer the immediate parrent class Object.
-> It is used to call the parrent method, Access field or invokes the parent class constructor.

for exampleL: (In the derive class we can use)

(1) super.method_name();
    To call the specific method of the parent class

(2) super();
    To call the specific constructor




 
=======================================================================================================================
                this keyword                        |                    super keyword                                |
======================================================================================================================| 
                                                    |                                                                 |
-> 'this' is an implicit reference variable         | -> 'super' is an implicit reference varibale keyword used to    |
    keyword used to represent the current class.    |     represent the immediate parent class.                       |
----------------------------------------------------|-----------------------------------------------------------------|
-> 'this' is used to invoke the method of the       | -> 'super' is used to invoke methods of the immediate parent    |
    current class.                                  |     class.                                                      |
----------------------------------------------------|-----------------------------------------------------------------|
-> 'this' is used to invoke the constructor of the  | -> 'super' is used to invoke the constructor of the immediate   |
    current class.                                  |     parent class.                                               |
----------------------------------------------------|-----------------------------------------------------------------|
-> 'this' refers tothe instance and static variable | -> 'super' refers tothe instance and static variable os the     |
    of the current class.                           |     immediate parent class.                                     |
----------------------------------------------------|-----------------------------------------------------------------|
-> 'this' can be used to return and pass as argument| -> 'super' can be used to return and pass as argument in the    |
    in the context of current class object.         |     context of an immediate parent class.                       |
=======================================================================================================================




*/

class Base {
    public int x;

    // No args constructor 
    public Base() {
        System.out.println("\n====> I am a Constructor of Base class <====");
    }
    
    // Parameterized Constructor 
    public Base(int num) {
        System.out.println("\n====> I am a Parameterized Constructor of Base class <====");
    }

    // Display Method 
    public void display() {
        System.out.println("\n=====> Base Class -> (Display Method) <=====");
    }

}

class Derived extends Base {
    public int y;

    public Derived() {
        super(30);
        System.out.println("\n====> I am a Constructor of Derived class <====");
    }

}

public class p5_Const_In_Inheritence {
    public static void main(String[] args) {

        // Derived d1 = new Derived(); // Base(No args) -> Derived(No args) [without using super()]

        Derived d2 = new Derived(); // Base(args) -> Derived(No args) [with using super()]
        d2.display();
    }
}
