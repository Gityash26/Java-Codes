/*  
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------------ Constructors In Java -------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> After creating an object of a class we can use their methods easily with the help of object.
-> But when we create an Object a 'default constructor' invokes that initilize the memory to the Object.
-> Constructor is an special type of method that automatically invokes just after the Object declaration.

Note:
-> We can create our own 'user defined Constructor' and use to execute those important code statements 
   that we wants to execute automatically just after the Object Creation.

   -> ex: Suppose a person wants to signup in an application means creating an Object. 
          So we may require some security checks, database connectivity, or any type  of operation that has to 
          automatically invokes just after the Object creation then we requires constructors.  

syntax:
            class myclass
            {
                // constructor
                myclass()
                {
                    code statements;
                }
            }

=> Important Points about constructors:
(1) Constructors don't have any return type
(2) Their can be multiple constructors in a single class.
(3) Constructor name is same as class name.
(4) In java we can create a constructor private
*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------------ Types of Constructor -------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Default Constructors:
->  When we don't create any constructor in the java program then the javac automatically create and invokes 
    a constructor called a default constructor.
-> Default constructor generally initilize the memory to the object (Attributes and methods).


(2) No args Constructors:
->  Creating a Constructor with no Arguments are known as a 'No arguments Constructor'.


(3) Parameterized Constructors
-> A constructor that accept parameters as Arguments is called as "Parameterized Constructor".  

*/