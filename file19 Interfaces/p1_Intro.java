/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------- Introduction to Interfaces -----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In english meaning of 'Inerfaces' a medium that help for interaction of two systems is called a Interface.

for example: 
    -> Operating system act as an interface between user and computer harware.
    -> Keyword and mouse provide intrface for writing code

-> In java Interfaces are similar like Abstract classes but an abstract class can have normal methods as well 
    as abstract methods but Interface only contains abstract methods (declared only).

-> Interfaces are group of related methods without any body or definition.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------- Interfaces properties -----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Interfaces are just similar like a normal class that contains Data_Member and Member_functions but in interfaces 
    -> All the Data_members are "final static variable" (constant).
    -> All the methods are abstract methods (only declaration)

(2) A Normal concrete class can implement multiple interface (implements) in java that helps to implement the feature 
      "Multiple inheritance" feature of Oops.


*/

interface A 
{
    // Interface variables 
    String name="yash";  // final and static
    int age=21;

    // Interface methods 
    void process(); // Public and Abstract

    void show(); // Public and Abstract
}

class B implements A 
{
    public void process() 
    {
        System.out.printf("\nStart processing...");
    }

    public void show() 
    {
        System.out.printf("\nDisplay Result -> Name : %s and Age : %d", name,age);
    }
}

public class p1_Intro 
{
    public static void main(String[] args) 
    {
        // Method 1 : Creating a deived class
        B obj1 = new B();
        obj1.process();
        obj1.show();

        // Method 2 : Implementing Anonymous class
        A obj2 = new A() 
        {
            public void process() 
            {
                System.out.println("\nProcess method Override...");
            }

            public void show() 
            {
                System.out.printf("\nOverrided Display -> Name : %s and Age : %d", name,age);

            }
        };
        obj2.process();
        obj2.show();
    }
}
