/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-------------------- StringBuffer class Methods ----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. append(String str): 
   Appends the specified string to the end of the StringBuffer.

2. insert(int offset, String str): 
   Inserts the specified string at the specified position in the StringBuffer.

3. delete(int start, int end): 
   Removes the characters in a substring of the StringBuffer.

4. reverse(): 
   Reverses the characters in the StringBuffer.

5. length(): 
   Returns the length (character count) of the StringBuffer.

6. capacity(): 
   Returns the current capacity of the StringBuffer.

7. charAt(int index): 
   Returns the character at the specified index.

8. setCharAt(int index, char ch): 
   Sets the character at the specified index to the specified character.

9. substring(int start): 
   Returns a new String that contains a subsequence of characters from the StringBuffer.

10. substring(int start, int end): 
   Returns a new String that contains a subsequence of characters from the StringBuffer.

*/

public class p3_SB_Methods 
{
    public static void main(String[] args) 
    {

        StringBuffer s = new StringBuffer("Hello");
        System.out.println("\nOriginal String : " + s);

        // append method
        s.append(" World");
        System.out.println("\nAppend() method : " + s);

        // insert method
        s.insert(5, " Java");
        System.out.println("\ninsert (index, str) method : " + s);

        // delete method
        s.delete(5, 10);
        System.out.println("\ndelete (start , end) method : " + s);

        // reverse method
        s.reverse();
        System.out.println("\nreverse() method : " + s);
        s.reverse();

        // length method
        System.out.println("\nlength() method : " + s.length());

        // capacity method
        System.out.println("\ncapacity() method : " + s.capacity());

        // charAt method
        System.out.println("\ncharAt(index) method : " + s.charAt(2));

        // setCharAt method
        s.setCharAt(2, 'X');
        System.out.println("\nsetCharAt(index, char) method : " + s);

        // subString method
        System.out.println("\nsubstring(3) method : " + s.substring(3));

        // subString method
        System.out.println("\nsubstring(3, 7) method : " + s.substring(3, 7));

    }
}
