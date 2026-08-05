/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------  DataType in Java -------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
Their are two types of data type in Java:
-> primitive Datatype 
-> Non-primitive Datatype


(1) Primitive Datatype
    -> byte   (Takes 1 byte int value)        |     -128 to 127
    -> short  (Takes 2 byte int value)        |     -32,768 to 32,767
    -> int    (Takes 4 byte int value)        |     -2,147,483,648 to 2,147,483,647
    -> long   (Takes 8 byte int value)
    -> float  (Takes 4 byte float value)
    -> double (Takes 8 byte float value)
    -> char   (Takes 2 byte char value)
    -> bool   (True or false)



                                                    Primitive Datatype
                             __________________________________|________________________________
                            |                         |                     |                  |
                         Integral                   Float                 Char(2)         Boolen(True,False)
                ____________|___________           ___|_____
               |       |        |      |          |        |       
          byte(1)   short(2)  int(4)  long(8)   float(4)   double(8)


            
(2) Non-Primitive Datatype
    -> Derived using primitive data type
    ex: Array, String
                                   





    
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------  Variables in Java -----------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
-> A variable is a container that is used to store a value given by user in a  
   static or dynamic way.

   syntax: dataType varName = value;
            int a = 10;



*/

public class file3 
{
    public static void main(String args[]) {
        // integers
        byte a = 5;
        short b = 18;
        int c = 357;
        long d = 57857L;

        // float
        float e = 4.0f;
        double f = 6.0;

        // characters
        char g = 'a';
        String h = "Hello";

        // bool
        boolean i = true;

        System.out.println("\n~~~~~~~~~~~~~~ Integer Datatype ~~~~~~~~~~~~~~~~~~");
        System.out.println("1 Byte variable (byte)  : " + a);
        System.out.println("2 Byte variable (short) : " + b);
        System.out.println("4 Byte variable (int)   : " + c);
        System.out.println("8 Byte variable (long)  : " + d);
        
        System.out.println("\n~~~~~~~~~~~~~~ Float Datatype ~~~~~~~~~~~~~~~~~~");
        System.out.println("4 Byte variable (float) : " + e);
        System.out.println("8 Byte variable (double)  : " + f);
   
        System.out.println("\n~~~~~~~~~~~~~~ Character Datatype ~~~~~~~~~~~~~~~~~~");
        System.out.println("Character variable (char)  : " + g);
        System.out.println("String variable (String)   : " + h);
        
        System.out.println("\n~~~~~~~~~~~~~~ Boolean Datatype ~~~~~~~~~~~~~~~~~~");
        System.out.println("Boolean Variable (boolean) : " + i);
    }
}
