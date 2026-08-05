/*

~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
                                JAVA 8 - INTRODUCTION
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=


What is Java 8?
=================================
=> Java 8 is one of the most important versions of Java released by Oracle in March 2014.

=> It introduced a completely new programming style called "Functional Programming" while still  supporting Java's traditional 
   Object-Oriented Programming (OOP).

=> Because of the large number of powerful features it introduced, Java 8 is considered one of the  biggest and most influential 
    releases in Java's history.



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Why was Java 8 introduced?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Problems Before Java 8, Java programs were becoming:
===========================================================================
1. Lengthy
2. Difficult to read
3. Difficult to maintain
4. Repetitive (Boilerplate Code)


Simple tasks often required writing too many lines of code.

Example:
-> Printing every element of a List required using loops.
-> Filtering employees based on salary required manually iterating through every object.

Sorting custom objects required creating separate Comparator classes.



Oracle wanted Java developers to write: (Intension behind java8)
============================================================================
• Less code
• More readable code
• More maintainable code
• Better performing code



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Major Features introduced in Java 8
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

1. Lambda Expressions
2. Functional Interfaces
3. Method References
4. Stream API
5. Default Methods
6. Static Methods in Interfaces
7. Optional Class
8. New Date & Time API
9. Parallel Streams
10. Base64 API




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Why is Java 8 called a Game Changer?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Before Java 8:
    • Java mainly supported Object-Oriented Programming.

After Java 8:

    • Java supported both:
        1. Object-Oriented Programming
        2. Functional Programming

        

~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
What problems did Java 8 solve?
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=


--------------------------------------------------
✔ Reduced Boilerplate Code
--------------------------------------------------
Old Java required writing many unnecessary lines.
Java 8 introduced Lambda Expressions to reduce this code.


--------------------------------------------------
✔ Improved Collection Processing
--------------------------------------------------
Earlier, collections had to be processed using loops.
Java 8 introduced Stream API for cleaner and more powerful collection operations.


--------------------------------------------------
✔ Better Readability
--------------------------------------------------
Programs became easier to understand.


--------------------------------------------------
✔ Easier Parallel Processing
--------------------------------------------------
Parallel Streams made multi-core processing much easier.


--------------------------------------------------
✔ Better Date & Time API
--------------------------------------------------
The old Date and Calendar classes were difficult to use.
Java 8 introduced a modern Date & Time API.




~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Applications of Java 8
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

    • Spring Boot
    • Microservices
    • Enterprise Applications
    • REST APIs
    • Banking Applications
    • E-Commerce Applications
    • Android (partially through desugaring)
    • Backend Development



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Advantages of Java 8
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

✔ Cleaner Code
✔ Less Boilerplate
✔ Better Performance
✔ Easier Collection Processing
✔ Functional Programming Support
✔ Improved Date & Time Handling
✔ Better Maintainability



~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=
Disadvantages
~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Although Java 8 is extremely useful, beginners often find:

    • Streams difficult initially.

    • Functional Programming different from OOP.

However, once understood, Java 8 greatly improves productivity.

*/