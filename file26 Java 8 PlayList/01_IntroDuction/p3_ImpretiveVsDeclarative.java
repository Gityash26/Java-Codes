/*
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
                    IMPERATIVE PROGRAMMING vs DECLARATIVE PROGRAMMING
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Before understanding Lambda Expressions and Stream API, it is important to understand two programming styles:

1. Imperative Programming
2. Declarative Programming

Java supported Imperative Programming from the beginning.
Java 8 introduced support for Declarative Programming.



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
What is Imperative Programming?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

-> Imperative Programming focuses on HOW a task should be performed.
-> The programmer writes every instruction step by step.
-> The computer simply follows those instructions.

Example:

Requirement: Print all even numbers from a list.

Steps:
1. Start loop
2. Read first element
3. Check if it is even
4. If yes, print it
5. Move to next element
6. Repeat until list ends

The programmer controls every step.

Diagram:

Programmer
     │
     │    (writes every instruction)
     │   
     ▼
  Computer

Programmer decides HOW everything should happen.



--------------------------------------------------------------------------------
Characteristics of Imperative Programming
================================================================================

✔ Step-by-step instructions
✔ Explicit loops
✔ Variables are frequently modified
✔ More control over execution
✔ Usually more lines of code

--------------------------------------------------------------------------------
Example (Before Java 8)
================================================================================

List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

for(Integer n : numbers)
{
    if(n % 2 == 0)
    {
        System.out.println(n);
    }
}

Notice that most of the code is explaining HOW to perform the task.


Business requirement:
    Print even numbers.

But most of the code is:
    • loop
    • variable
    • condition
    • iteration



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
What is Declarative Programming?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

-> Declarative Programming focuses on WHAT needs to be done.
-> The programmer describes the desired result.
-> The language or framework decides HOW to achieve it.

Example:

numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);

Now the code directly expresses the requirement.

Business Logic:
    => Filter even numbers
    => Print them

We don't manually write the iteration logic.



--------------------------------------------------------------------------------
Characteristics of Declarative Programming
================================================================================

✔ Focuses on WHAT is required
✔ Less boilerplate code
✔ Better readability
✔ Easier maintenance
✔ Internal iteration
✔ Easier optimization

--------------------------------------------------------------------------------
Diagram Comparison
================================================================================


-------------------------------
Imperative Programming
-------------------------------

        Requirement
            │   
            ▼
Programmer writes every single step
            │   
            ▼
      Computer executes


-------------------------------
Declarative Programming
-------------------------------

        Requirement
            │   
            ▼
Programmer describes desired result
            │   
            ▼
Java decides how to execute it



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Real-Life Example
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Imagine travelling from Delhi to Jaipur.


------------------------------------------
Imperative Style:
==========================================
1. Start bike.
2. Go straight.
3. Turn left.
4. Drive 20 km.
5. Turn right.
6. Continue 50 km.
7. Reach destination.

Every instruction is given.



------------------------------------------
Declarative Style:
==========================================

Open Google Maps.
Enter destination:
Jaipur
Press Start.
Google Maps decides the best route.
You only specify WHAT you want.



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Why Declarative Programming?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Suppose tomorrow Java finds a faster way to process Streams.
Your code remains exactly the same.
Only Java's internal implementation changes.
This is one of the biggest advantages of Declarative Programming.



--------------------------------------------------------------------------------
Imperative vs Declarative
================================================================================

+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+
│ Feature                 │ Imperative                   │ Declarative                │
+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+
│ Focus                   │ HOW to do                    │ WHAT you need              │
│ Programmer controls     │ Every step                   │ Desired result             │
│ Code size               │ More                         │ Less                       │
│ Readability             │ Lower                        │ Higher                     │
│ Maintenance             │ Harder                       │ Easier                     │
│ Iteration               │ External                     │ Internal                   │
│ Optimization            │ Programmer                   │ Java Runtime               │
+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Does Java Replace Imperative Programming?  ====> 'NO'
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Java still fully supports Imperative Programming.
Java 8 simply introduced another option.
Today both styles are commonly used.
Sometimes a simple for-loop is clearer than a Stream.
A good Java developer knows WHEN to use each approach.


--------------------------------------------------------------------------------
Interview Questions
--------------------------------------------------------------------------------

Q1. What is the difference between Imperative and Declarative Programming?

Answer:

Imperative Programming focuses on HOW to perform a task.
Declarative Programming focuses on WHAT result is required.

------------------------------------------------------------

Q2. Which programming style does Stream API follow?

Answer:

Declarative Programming.

------------------------------------------------------------

Q3. Is Declarative Programming always better?

Answer:

No.

For simple tasks, traditional loops are often easier to read.

For collection processing, filtering, mapping, grouping and aggregation,
Streams usually provide cleaner code.

================================================================================
*/