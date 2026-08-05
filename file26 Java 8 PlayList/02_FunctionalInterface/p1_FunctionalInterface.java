/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
                        FUNCTIONAL INTERFACE
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Before learning Lambda Expressions, we must first understand 'Functional Interfaces'

Reason:

        A Lambda Expression ALWAYS works with a Functional Interface.
        
        Without a Functional Interface, there can be NO Lambda Expression.

Think of it like this:

            Functional Interface
                    │
                    ▼
            Lambda Expression
                    │
                    ▼
             Method Reference
                    │
                    ▼
               Stream API

So, Functional Interface is the foundation of Java 8.






~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
What is an Interface?     ...... quick revision
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

An Interface is a blueprint that specifies WHAT a class should do, not HOW it should do it.

Before Java 8, an Interface mainly contained:

-> Abstract Methods (methods without body)
-> Public Static Final Variables (Constants)


From Java 8 onwards, Interfaces can also contain:

✔ Default Methods
✔ Static Methods

(Java 9 further introduced Private Methods.)



Example:

interface Animal
{
    void sound();
}

Here,

Animal                  sound()
    │                      │
    ▼                      ▼
Interface             Abstract Method




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Why was Functional Interface introduced?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Before Java 8, whenever we wanted to pass some behaviour (logic) to a method, we usually had 
to create:

✔ Separate Class
        or
✔ Anonymous Inner Class

Example:

Comparator<Integer> c = new Comparator<Integer>()
{
    @Override
    public int compare(Integer a, Integer b)
    {
        return a - b;     // main business login 
    }
};


Observe carefully.

The actual business logic is only:
        return a - b;

Everything else is boilerplate code.

Java developers had to write many unnecessary lines just to implement ONE method.

Oracle wanted to reduce this boilerplate code.

But before introducing Lambda Expressions, Java first needed a target where a Lambda could be stored.

That target became the Functional Interface.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
What is a Functional Interface?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Definition:

A Functional Interface is an Interface that contains EXACTLY ONE Abstract Method.

It may also contain:

        ✔ Any number of Default Methods
        ✔ Any number of Static Methods
        ✔ Constants
        ✔ Object Class Methods

But only ONE Abstract Method.

Example:

@FunctionalInterface
interface Greeting
{
    void sayHello();
}

This is a Functional Interface because there is only ONE abstract method.





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Why Exactly ONE Abstract Method?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

This is the most important concept.

Suppose an interface has:

interface Test
{
    void method1();
    void method2();
}

Now imagine writing:

        () -> System.out.println("Hello");



Question: Which method should this Lambda implement?

        method1() ?   or    method2() ?

Java cannot decide.

This creates ambiguity.

Now consider:

        interface Greeting
        {
            void sayHello();
        }

Lambda:
        () -> System.out.println("Hello");

Now there is only ONE possible method.

No confusion.

Therefore,

One Abstract Method
        │
        ▼
One Lambda Target

This is why a Functional Interface MUST contain exactly one abstract method.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Characteristics of Functional Interface
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

✔ Contains exactly ONE abstract method.

✔ Can contain multiple default methods.

✔ Can contain multiple static methods.

✔ Can contain constants.

✔ Can extend another interface
   (provided only one abstract method exists overall).

✔ Supports Lambda Expressions.

✔ Supports Method References.







--------------------------------------------------------------------------------
What Can a Functional Interface Contain?
================================================================================

+=======================================================================+
│ Member                                        │ Allowed ?             │
+=======================================================================+
│ One Abstract Method                           │ ✔ Yes                 │
│ Two Abstract Methods                          │ ❌ No                 │
│ Default Methods                               │ ✔ Yes                 │
│ Static Methods                                │ ✔ Yes                 │
│ Constants                                     │ ✔ Yes                 │
│ Object Class Methods                          │ ✔ Yes                 │
│ Constructors                                  │ ❌ No                 │
+=======================================================================+






~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
@FunctionalInterface Annotation
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Java provides the annotation: 

                ''' @FunctionalInterface '''

Purpose:

It tells the compiler that this Interface MUST remain a Functional Interface.

If someone accidentally adds another abstract method,

Compiler
    │
    ▼
Compilation Error

Without this annotation, The Interface can still be a Functional Interface.

Therefore,

        @FunctionalInterface is OPTIONAL, but highly recommended just to notify.







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Internal Working
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Lambda Expression
        │
        ▼

Compiler checks the Target Type
        │
        ▼

Target must be a Functional Interface
        │
        ▼

Compiler maps the Lambda to the only Abstract Method
        │
        ▼

Object is created internally
        │
        ▼

Program executes ✔



This process is called:
---------------------------------------------
Target Typing
(We will study it in detail during Lambda Expressions.)







~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Real Life Analogy
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Imagine a TV Remote.

The remote has one button:

Power

Pressing the button always performs one clear action.

Now imagine the same button had to perform:

Power ON
Volume Up
Channel Change

Which action should happen? => Nobody knows.

Exactly the same confusion would happen if a Functional Interface had multiple abstract methods.






~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Common Mistakes
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

❌ Every Interface is a Functional Interface.

✔ No.
Only Interfaces having exactly ONE abstract method are Functional Interfaces.

----------------------------------------------------

❌ @FunctionalInterface is mandatory.

✔ No.
It is optional.

----------------------------------------------------

❌ Functional Interface cannot contain default methods.

✔ Wrong.
It can contain multiple default methods.

----------------------------------------------------

❌ Functional Interface cannot contain static methods.

✔ Wrong.
Static methods are also allowed.






~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
Interview Questions
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~

Q1. What is a Functional Interface?

Ans: An Interface containing exactly one abstract method.

----------------------------------------------------
Q2. Why only one abstract method?

Ans: To remove ambiguity while assigning Lambda Expressions.

----------------------------------------------------
Q3. Is @FunctionalInterface mandatory?

Ans: No.
It is optional but recommended.

----------------------------------------------------

Q4. Can Functional Interfaces contain default methods?

Ans: Yes.

----------------------------------------------------

Q5. Can Functional Interfaces contain static methods?

Ans: Yes.



================================================================================
*/