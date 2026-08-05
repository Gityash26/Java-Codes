/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------ StringBuffer class --------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> StringBuffer class in Java is a mutable sequence of characters. It is similar to String, but unlike String, 
   it can be modified. 
-> It is part of the java.lang package and provides methods for modifying, appending, inserting, and deleting 
   characters in the sequence.
-> Java provides both the String and StringBuffer class in which we know that String class is Immutable
   but StringBuffer class facilitate to create a mutable string in java.
-> StringBuffer provides a Buffer memory size of 16 bytes that remains reserved all the time.


*/

public class p2_StringBuffer 
{
   public static void main(String[] args) 
   {
    
      // Empty StringBuffer
      StringBuffer s = new StringBuffer();
      System.out.println("\nStringBuffer() Size : " + s.capacity());

      // Specific size StringBuffer
      s = new StringBuffer(10);
      System.out.println("\nStringBuffer (int) Size : " + s.capacity());

      // StringBuffer with a string
      s = new StringBuffer("Harry");
      System.out.println("\nStringBuffer (string) Size : " + s.capacity());

   }

} 
      