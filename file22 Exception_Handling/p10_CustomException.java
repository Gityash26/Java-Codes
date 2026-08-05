/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------------------------- Custom Exception ----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Sometimes we require to raise our own exception because there is no available 
   predefined exception in java.
-> Defining custom exception means programmer require to create a new class for custom 
   Exception and extend the Exception class.

   
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--- Why we reqired Custom Exception --------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Customizing Predefined Exception:
    Sometimes predefined exception handling output does not clear the exact reason behind the Exception cause.
    Therefore we can provide our own defined solution if same exception occured.
    Example: Let us take an example of calculator if we are dividing a number with zero then the JVM will
             be throw "ArithmeticException" by default. But it does not clearify the reason properly.


(2) Generating new Exception:
    We all come across some situation where we require to throw an exception but we don't have any predefined 
    exception in the Java Exception class.
    ex: => Enter valid phone no.
        => Enter correct password
        => Enter correct Captcha 



   
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--- Creating Custom Exception --------------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                 Object
                                  |
                              Throwable
                      ____________|________________________
                     |                                    |
                  Exception                             Error
         ____________|_______________
        |                           |
 Checked Exception            Unchecked Exception
  (Compile Time)                   (Run time)


Step1: Create your own Custom Exception class (such as MyException) that extends the "Exception Class".
Step2: Create a constructor that takes String statement as an argument It helps to provide our own message to be displayed 
       each time when an objet is created.
Step3: call super(statement) inside the constructor.



   
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--- Constructors of Superclass --------------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
->  Superclass provide four types of constructors that we can call in our custom exception class



(1) Constructor with => No argument :_____________________________________________
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public MyCustomException()
{
    //  code
}
-> It just create a new instance of the custom exception with no message.
-> Used when we just require a simple exception without any specific error message.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



(2) Constructor with => String argument : ________________________________________
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public MyCustomException(String)
{ 
    //  code
}
-> It is used to create a new instance of the exception with a specific error message.
-> Useful when we can provide addition information context related to exception occured.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



(3) Constructor with => Throwable argument :______________________________________
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public MyCustomException( Throwable )
{
    //  code
}
-> It is used when our custom exception is a result of another exception and we want 
   to chain them together.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



(4) Constructor with => String and Throwable :____________________________________
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public MyCustomException( String , Throwable)
{
    //  code
}
-> It initilize a new instance of the exception with a specific error message and a cause.
-> It is useful when we want to provide both the custom error messgage and specify the underlying 
    cause of the exception.




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
___________________We can create both the type Exception_____________________
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Checked Custom Exception 
    => extends Exception class

(2) Unchecked Custom Exception 
    => extends RuntimeException Class


*/

class CustomExceptionConst extends Exception {
    // COnstructor with no argument
    public CustomExceptionConst() {
        super();
    }

    // Constructor with String argument
    public CustomExceptionConst(String msg) {
        super(msg);

    }

    // Constructor with Throwable cause
    public CustomExceptionConst(Throwable th) {
        super(th);
    }

    // Constructor with String and Throwable cause
    public CustomExceptionConst(String msg, Throwable th) {
        super(msg, th);
    }
}

public class p10_CustomException {
    public static void main(String[] args) {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        try 
        {
            throw new CustomExceptionConst();
        } 
        catch (CustomExceptionConst e) 
        {
            System.out.println("\n~~~~~~~~~~~~~ Caught Exception with no message..~~~~~~~~~~~~~~~");
            e.printStackTrace();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        try {
            throw new CustomExceptionConst("!! Custom Message Exception !!");
        } 
        catch (CustomExceptionConst e) {
            System.out.println("\n~~~~~~~~~~~~~ Caught Exception with String message..~~~~~~~~~~~~~~~");
            e.printStackTrace();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        try {
            Throwable cause = new ArithmeticException("!! Arithmetic Cause !!");
            throw new CustomExceptionConst(cause);
        } 
        catch (CustomExceptionConst e) {
            System.out.println("\n~~~~~~~~~~~~~ Caught Exception with Throwable cause..~~~~~~~~~~~~~~~");
            e.printStackTrace();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        try {
            Throwable cause = new ArrayIndexOutOfBoundsException("!! Cause !!");
            throw new CustomExceptionConst("!! Custom Message !!",cause);
        } 
        catch (CustomExceptionConst e) {
            System.out.println("\n~~~~~~~~~~~~~ Caught Exception with Custom Message and Throwable cause..~~~~~~~~~~~~~~~");
            e.printStackTrace();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    }                                                                                                                                                                                                
}
