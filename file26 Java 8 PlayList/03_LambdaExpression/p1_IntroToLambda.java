/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
                    INTRODUCTION TO LAMBDA EXPRESSION
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Definition

A Lambda Expression is a concise way of providing the implementation of the single abstract 
method of a Functional Interface.

Instead of creating a separate class or an anonymous class, we directly write the implementation 
of the method.

In this file we will understand:

✔ Why Lambda was introduced?
✔ What problem existed before Java 8?
✔ How Lambda solves that problem?
✔ How to convert normal code into Lambda step by step?







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Step 1 : Create a Functional Interface
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Suppose we have a Functional Interface.

@FunctionalInterface
interface Greeting
{
    void sayHello();
}

Question: How can we provide the implementation of sayHello() ?




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Step 2 : Traditional Approach (Before Java 8)
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

We create a separate class.

class GreetingImpl implements Greeting
{
    @Override
    public void sayHello()
    {
        System.out.println("Hello");
    }
}

Now create its object.

    Greeting g = new GreetingImpl();




Problem: We only wanted to print one line,
===========================================================
but we had to write

✔ Class  ------------------------------------│
✔ implements --------------------------------│
✔ @Override  --------------------------------│====> Extra work 
✔ Method Declaration ------------------------│
✔ Object Creation ---------------------------│


This is called Boilerplate Code.
    Boilerplate Code means writing a lot of code that does not contain actual business logic.

Business Logic
    System.out.println("Hello");

Everything else is supporting code.





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Step 3 : Anonymous Class
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Java provided another solution.
Basically we are trying to create the interface object along with implementation with it. 

interface Greeting()
{
    void sayHelo();
}

Greeting g = new Greeting()
{
    @Override
    public void sayHello()
    {
        System.out.println("Hello");
    }
};



========================================
Advantage
========================================
✔ No separate class required.

But...

We are still writing

✔ @Override
✔ Method Name
✔ Method Body
✔ Curly Braces

Still too much code for a single statement.





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Step 4 : Java 8 Solution (Lambda Expression)
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Java says,

"I already know you are implementing a Functional Interface."

"I already know there is only ONE abstract method."

"So don't write everything again."

Simply write the implementation.

Greeting g = () ->
{
    System.out.println("Hello");
};

Much shorter.
Much cleaner.
Much easier to read.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
How did we reach Lambda?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Let's convert the Anonymous Class step by step.


Anonymous Class

Greeting g = new Greeting()
{
    @Override
    public void sayHello()
    {
        System.out.println("Hello");
    }
};

                    │
                    ▼

Step 1

Remove
    new Greeting()

because the compiler already knows the target Functional Interface.

                    │
                    ▼

Step 2

Remove
    @Override

because there is no class to override.

                    │
                    ▼

Step 3

Remove
    Method Name

sayHello()

because a Functional Interface has only one abstract method.
The compiler already knows which method is being implemented.

                    │
                    ▼

Step 4

Remove
    Return Type

void

because the compiler already knows the method signature.

                    │
                    ▼


Final Code

Greeting g = () ->
{
    System.out.println("Hello");
};







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Why is Method Name Removed?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Suppose the Functional Interface contains

@FunctionalInterface
interface Demo
{
    void show();
}

There is only one abstract method.

So whenever Java sees  
                 () ->

it immediately understands "This implementation belongs to show()."

There is no confusion.

If there were two abstract methods, Java would not know which method the Lambda belongs to.
That is why Lambda works only with Functional Interfaces.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Advantages of Lambda Expression
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

✔ Less Boilerplate Code
✔ Better Readability
✔ Easier Maintenance
✔ Cleaner Code
✔ Works perfectly with Stream API




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Remember
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Separate Class
        ↓

Anonymous Class
        ↓

Lambda Expression

Java keeps reducing unnecessary code while keeping the business logic the same.
Business Logic never changes.
Only the amount of code changes.




*/