/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------------------- Throws keyword ---------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> Main method()----\ 
                 Calculator()--\ 
                              Average() --\ 
                                         Sum() --\
                                                display() 

-> Suppose there is an Exception occurs in the display method and we can handle it using try catch block and if
  we are not handling then the JVM move to its caller method and check if it was handling the exception occured 
  in the display().
  It happens until any method handle it or the JVM reach to the main method.

-> Throws keyword is used to indicate the JVM that my method is not handling the exception but the method calling my method 
  (caller) handling this.

-> Throws keyword is used to declare a method as it throw a specific exception.

-> We can declare a method that throws multiple exceptions using throws keyword and comma(,) in every Exception type.

            main
            {
              // code
                 A()   ---------------\
            }                         |
                                    A()
                                    {
                                        try
                                        {
                                            // code
                                            B() --------------------------------------------\ 
                                            C() -------------------\                        |
                                        }                          |                        |
                                        catch(Exception)          B() throws Exception    C() throws Exception
                                        { ....                    {                       {
                                        }                           //   code                 // code
                                    }                            }                       }

=> Advantage of throws:
   Suppose a developer A working on some class (Ex Open_file & save_File) and second developer using those classes
   In this case developer A mark there classes with throws and its a responsibility of second developer to manage 
   those Exception.

*/

import java.io.FileNotFoundException;

class ReadAndWrite
{
    public void readFile()  throws FileNotFoundException
    {
        throw new FileNotFoundException();
    }

    public void saveFile() throws FileNotFoundException
    {
        throw new FileNotFoundException();
    }
}

public class p7_Throws 
{
    public static void main(String[] args) 
    {
        ReadAndWrite obj = new ReadAndWrite();
                                            
        try
        {
            obj.readFile();
            obj.saveFile();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("\n~~~~~~~~ Sorry File Not Found ~~~~~~~~~~~~\n");
            e.printStackTrace();
        }
    }
}
