/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------------------------- Type Conversion -----------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Assigning one value of one datatype into another is called as Type conversion

*/

public class file4 
{
    public static void main(String args[]) 
    {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        int a = 129;
        byte b = (byte) a;
        System.out.println("Int to Byte conversion : " + b);
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        float f = 5.6f;
        int x = (int) f;
        System.out.println("Float to Int conversion : " + x);
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        byte b1 = 127;
        int a1 = (int) b1;
        System.out.println("Byte to Int Conversion : " + a1);
    }
}
  