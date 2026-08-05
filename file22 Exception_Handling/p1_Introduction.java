/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----- What is Exception in JAVA ------------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> The Exceptions are unwanted and unexpected event that occurs during program execution.
-> It affect the normal flow of the program and cause the program to terminate abnormally.
-> When an exception occurs within a method in java, it creates an object called the "Exception object".
-> Object contains the information about the exception such as, name, description and state of the program 
    when  exception occured.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 Following reasons can cause Exception 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Invalid user input
-> Device failure
-> Loss of Network connection 
-> Physical limitation (out of disk space)
-> Code Error
-> Opening an unavailable file


Note: Checked Exception   -> Compile time exceptions
      Unchecked Exception -> Run Time exception
          


                                  Throwable
                 _____________________|_____________________________
           _____|______                                        ____|____
          |_Exception_|                                       |_Errors_|
       _________|_______________________                         |    
 _____|______________           _______|______________           |-> StackOverFlowError
|_Checked_Exception_|          |_Unchecked_Exception_|           |            
    |                                  |                         |-> VirtualMachineError
    |-> IOException             [RuntimeException]               |
    |                                 |                          |-> OutOfMemoryError
    |-> SQLException                  |-> ArithmeticException 
    |                                 |-> NullPointerException                             
    |-> ClassNotFoundException        |-> NumberFormatException
                                      |     ___________________________
                                      |->  |_IndexOutOfBoundException_|
                                     _________________|_______________                            
                                    |                                |
                        ArrayIndexOutOfBoundException        StringIndexOutOfBoundException




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------ Exception Handling ----------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
For example:
-> Take an example of a student that follows a normal flow of the work.

      /=====================================================================================\
     |     WakeUp --------> GetReady ---------> PickVehicle ------------>  ReachToSchool    |
     \=====================================================================================/

-> But what if tyre get punchered, Traffic found, Forget School bag, Accident

-> All these list of exceptions may occur but if we don't have any alternative solution that at Java level 
    we just get notified about the exception and furtrher work get stopped and program terminated.

-> But we can handle those exceptions and provide our own defined alternative solution to perform if any exception occured.

-> This approach make our application more efficient and reliable to handle exception and provide a 
    better experience to the user. 

-> Therefore Exception handling is a mechanism that facilitate a programmer to explicitly provide any alternative 
   way that perfromed in case of any exception occured and prevent the application from unwanted termination.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Note: All the exceptions are RunTime Exceptions and no exception will occurs at the Comiplation time.
      Comipler just predict and warn you for a list of exceptions that may occurs at the run time of the program.

      ex: If we are dealing with file I/O or like Database then it is important to handle those exception that may occurs.
          Java enforce you to handle those exceptions and without handling those error we can't compile our program.
          These exceptions we call them as Checked exception or Compile time exception
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


*/

// Program: Compile Time Exception and Run Time Exception
import java.io.FileInputStream;

class CompileTime
{
      public void perform_CompileTimeException()
      {
            /*
            Example 1:
            Unhandled Exception that may cause "FileNotFoundExcxeption"
            */
            try
            {
                  FileInputStream file = new FileInputStream("C:/abc.txt");
                  System.out.println(file);
            }
            catch(Exception e)
            {
                  System.out.println(e);
            }
            System.out.println("Exception Caught and resolveed");
      }

}

class RunTime 
{
      public void perform_RunTimeException()
      {
            // Exception Occur : ArithmeticException -> Divide by zero
            int a=10;
            int b=0;
            System.out.println("Division of a and b : " + (a/b));
      }

}

class p1_Introduction {
      public static void main(String[] args) 
      {
        CompileTime ct = new CompileTime();
        ct.perform_CompileTimeException();
      
        RunTime rt = new RunTime();
        rt.perform_RunTimeException();
        
      //   Program Terminate here... 

        System.out.println("RunTime Exception occured and not handled");
      }
}