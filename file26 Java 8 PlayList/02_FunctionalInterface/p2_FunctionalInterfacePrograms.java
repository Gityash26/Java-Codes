/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                FUNCTIONAL INTERFACE - PROGRAMS
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

This file demonstrates all important concepts of Functional Interface.

Topics Covered:
1. Simple Functional Interface
2. @FunctionalInterface Annotation
3. Default Method
4. Static Method
5. Constants
6. Object Class Methods
7. Invalid Functional Interface (Commented)
*/

public class p2_FunctionalInterfacePrograms 
{
    public static void main(String[] args) 
    {
        // ~~~~~~~~~~~~~~~~~~~~~~~~ Program 1 ~~~~~~~~~~~~~~~~~~~~~~~~~
        Greeting g = new GreetingImpl();
        g.sayHello();

        // ~~~~~~~~~~~~~~~~~~~~~~~~ Program 2 ~~~~~~~~~~~~~~~~~~~~~~~~
        Dog d = new Dog();
        d.sound();
        d.eat();

        // ~~~~~~~~~~~~~~~~~~~~~~~~ Program 3 ~~~~~~~~~~~~~~~~~~~~~~~~
        Test.info();

        // ~~~~~~~~~~~~~~~~~~~~~~~~ Program 4 ~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.println("College Fee : " + College.FEE);

        // ~~~~~~~~~~~~~~~~~~~~~~~~ Program 5~~~~~~~~~~~~~~~~~~~~~~~~
        Student s = new StudentImpl();
        s.study();
    }
}

/*
=========================================================================
 Program 1 : Simple Functional Interface
=========================================================================
*/

@FunctionalInterface
interface Greeting 
{
    void sayHello();
}

class GreetingImpl implements Greeting 
{
    @Override
    public void sayHello() 
    {
        System.out.println("Hello Everyone\n");
    }
}

/*
=========================================================================
 Program 2 : Default Method
=========================================================================
*/

@FunctionalInterface
interface Animal 
{
    void sound();

    default void eat() 
    {
        System.out.println("Animal is Eating...\n");
    }
}

class Dog implements Animal 
{
    @Override
    public void sound() 
    {
        System.out.println("Dog Barks...\n");
    }
}

/*
=========================================================================
 Program 3 : Static Method
=========================================================================
*/

@FunctionalInterface
interface Test 
{
    void display();

    static void info() 
    {
        System.out.println("Static Method inside Interface\n");
    }
}

/*
=========================================================================
 Program 4 : Constants
=========================================================================
*/

@FunctionalInterface
interface College 
{
    int FEE = 50000;
    void details();
}

/*
 =========================================================================
  Program 5 : Object Class Methods
=========================================================================
*/

@FunctionalInterface
interface Student 
{
    void study();
    String toString();
    boolean equals(Object obj);
    int hashCode();
}

class StudentImpl implements Student 
{
    @Override
    public void study() 
    {
        System.out.println("Student is Studying...\n");
    }
}
