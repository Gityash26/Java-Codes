/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
                            FUNCTIONAL PROGRAMMING IN JAVA
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

What is Programming?
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Programming is the process of giving instructions to a computer to perform specific tasks.

Over the years, different programming paradigms (styles) have evolved to solve problems in different ways.

Examples:
• Procedural Programming
• Object-Oriented Programming (OOP)
• Functional Programming (FP)



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
What is Functional Programming? (independent blocks of code)
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Functional Programming (FP) is a programming paradigm in which computation is performed by using functions.

Instead of focusing on objects and changing their state, Functional Programming focuses on writing small, reusable 
functions that take input, process it, and produce output.

The emphasis is on:

✔ What needs to be done instead of
✔ How to do it step by step


Think of a function like a mathematical function.

    Input
      │
      ▼
   Function
      │
      ▼
   Output

Example:

square(5) = 25
The same input always produces the same output.

--------------------------------------------------------------------------------
Why was Functional Programming introduced?
--------------------------------------------------------------------------------

As software systems became larger:

• Code became lengthy.
• Logic became repetitive.
• Programs became difficult to maintain.
• Developers spent more time writing loops than business logic.

Example:

Suppose we have a list of employees.

Requirement:
Print employees whose salary is greater than ₹50,000.

Before Java 8:

for(Employee e : employees)
{
    if(e.getSalary() > 50000)
    {
        System.out.println(e);
    }
}

Here, most of the code is about HOW to iterate.

The actual business logic is only:
salary > 50000

Functional Programming tries to make the business logic the main focus.



--------------------------------------------------------------------------------
Functional Programming Philosophy
--------------------------------------------------------------------------------

Instead of telling the computer every step:

Step 1
Step 2
Step 3
Step 4

We describe the operation.

Example:

Filter employees
Sort employees
Print employees

The language decides how to perform these operations efficiently.

--------------------------------------------------------------------------------
Important Characteristics
--------------------------------------------------------------------------------

1. Functions are treated as first-class citizens.
2. Functions can be passed as arguments.
3. Functions can be returned from other functions.
4. Programs become shorter.
5. Programs become easier to understand.
6. Less mutable state (less unnecessary modification of data).



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Does Java Support Pure Functional Programming? ----> "NO"
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Java is NOT a pure Functional Programming language.

Java is primarily an Object-Oriented Programming language.

Java 8 simply borrowed useful Functional Programming concepts.

So Java became a language that supports BOTH:
    • Object-Oriented Programming
    • Functional Programming

This is called a Multi-Paradigm Language.



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
How does Java support Functional Programming?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Java 8 introduced:

✔ Functional Interfaces
✔ Lambda Expressions
✔ Method References
✔ Stream API
✔ Optional

Together these features allow Java developers to write code in a more functional style.



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Real Life Analogy
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Imagine you order food in a restaurant.

Traditional Programming:
-------------------------------------------------------

1. Buy vegetables.
2. Wash vegetables.
3. Cut vegetables.
4. Cook food.
5. Serve food.

You describe every step.


Functional Programming:
-------------------------------------------------------
    "I want Paneer Butter Masala."
    You only describe WHAT you want.
    The chef decides HOW to prepare it.

Similarly,
    Traditional Java focuses on HOW. Functional Programming focuses on WHAT.





~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Advantages
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

✔ Less Boilerplate Code
✔ Better Readability
✔ Easier Maintenance
✔ Reusable Logic
✔ Easier Parallel Processing
✔ Cleaner Collection Processing


~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Disadvantages
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

✔ Learning curve for beginners.
✔ Debugging complex stream pipelines can be harder.
✔ Overusing functional style may reduce readability in simple programs.



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Interview Questions
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Q1. Is Java a Functional Programming language?

Answer:
No.
Java is primarily an Object-Oriented Programming language.
Java 8 only introduced Functional Programming features.

------------------------------------------------------------

Q2. Why did Java introduce Functional Programming?

Answer:
To reduce boilerplate code, improve readability, simplify collection processing,
and support modern programming practices.

------------------------------------------------------------

Q3. Can we write Java programs without Functional Programming?

Answer:
Yes.
Everything possible with Functional Programming can also be done using traditional Java code.
Functional Programming mainly improves readability and developer productivity.

*/