/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------- Exception Handling -------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Java already have a strong built in exception handling mechanism but when any runtime 
   exception occurs then the java interpreter only specify the name or type of exception 
   and terminate the program.
-> It is helpful that we get to know about the exception but due to termination rest of the 
   instructions fails to excecute.
-> Suppose we are writing 100 lines of code in an IDE and due to some exception the IDE get closed.
   This makes loss of data so there should be some mechanism that runs even in case of any exception and
   autosave the content before closing the application program.

-> That's why java exception handling support handling the exceptions explicity by the programmer and 
   writing our own program to handle the exceptions.
   

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------- Exception Handling Keywords ---------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) try
(2) catch
(3) finally
(4) throw
(5) throws


         ___________________
        |_Exception_Object_|
        |  exception name, |==================>     JVM
        |  description,    |                         |
        |  line            |                  _______|_______________
        |__________________|                 |                       |
                                        (if not handled)        (if handle)
                                            |                        |
                                      Default Exception          User defined              
                                        Handler                   Handler
                                                                [try, catch]


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------- Methods to Exception Class ---------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) printStackTrace method : Returns the {Exception name} , {Description} ,{Stacktrace}
(2) toString method        : Returns the {Exception Name} , {Description}
(3) getMessage method      : Returns the {Description}


*/



public class p2_HandlingException {
   public static void main(String[] args) 
   {
       int a=10, b=0;

       try
       {
           System.out.println("Division : " + (a/b));
       }
       catch(Exception e)
       {
           // getStackTrace() method : return Exception name, Description, Stacktrace 
           System.out.println("\nMethod printStackTrace : ");
           e.printStackTrace();
           
           // toString or e : Description only 
           System.out.println("\nMethod toString : \n" + e.toString());
           
           // getMessage() method : Exception name, Description 
           System.out.println("\nMethod getMessage : \n" + e.getMessage());
           
       }
   }    
}


