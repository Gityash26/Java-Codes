/*

                Byte Streams
                    │
            ┌───────┴─────────┐
            ▼                 ▼
    FileInputStream      FileOutputStream
            │                 │
            ▼                 ▼
           READ              WRITE
            │                 │
            ▼                 ▼
        File → Java       Java → File



╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                         File Output Stream                                 ║
╚════════════════════════════════════════════════════════════════════════════╝

The FileOutputStream is a predefined class provided by Java for WRITING BYTE data 
into a File.

Package :  java.io


Hierarchy

        OutputStream
            │
            └──────────────► FileOutputStream



════════════════════════════════════════════════════════════════════════════════
                    How does FileOutputStream work?
════════════════════════════════════════════════════════════════════════════════

Suppose our Java program has some byte data.

        Java Program
             │
             │ bytes data 
             ▼
     FileOutputStream
             │
             │ write into file
             ▼
           File


For example:

        byte[] data = { 65, 66, 67 };


These values represent:

        65 → A
        66 → B
        67 → C


FileOutputStream writes those BYTE VALUES into the File.

Conceptually:

        Java Program

        01000001
        01000010
        01000011
             │
             ▼
     FileOutputStream
             │
             ▼
        Student.txt


════════════════════════════════════════════════════════════════════════════════
                         C O N S T R U C T O R S
════════════════════════════════════════════════════════════════════════════════


──────────────────────────────────────────────────────────────────────────────
(1) FileOutputStream(String path / File obj)
──────────────────────────────────────────────────────────────────────────────
This will creates a new file automatically if not already exists
This constructor Creates a FileOutputStream using the 



File path
-----------------------------------------------------------
    FileOutputStream output = new FileOutputStream("Student.txt");
-----------------------------------------------------------


File object.
-----------------------------------------------------------
    File f = new File("Student.txt");
    FileOutputStream output = new FileOutputStream(f);
-----------------------------------------------------------



──────────────────────────────────────────────────────────────────────────────
(3) FileOutputStream(String path, boolean append)
──────────────────────────────────────────────────────────────────────────────

This constructor is used when we want to control whether new data should REPLACE the old data
or be ADDED after the existing data.

The second parameter is:

        append


If: append = false
    then existing data is overwritten.

If: append = true
    then new data is added at the end.

    
    
════════════════════════════════════════════════════════════════════════════════
                         M E T H O D S
════════════════════════════════════════════════════════════════════════════════


──────────────────────────────────────────────────────────────────────────────
(1) write(int b)
──────────────────────────────────────────────────────────────────────────────

This method writes ONE BYTE at a time into the File.

Example:
        output.write(65);

The value: 65
represents the byte:  01000001


For a text example:

        65 → A


So conceptually:

        Java Program
             │
             │ 65
             ▼
     FileOutputStream
             │
             ▼
          File


Syntax
        output.write(65);


IMPORTANT

Although the parameter type is:

        int

the method writes only the LOW 8 BITS as a byte.

For normal byte values: 0 → 255
you can think of it as writing that byte value.


Example:

        output.write(65);
        output.write(66);
        output.write(67);


The File will contain:

        ABC



──────────────────────────────────────────────────────────────────────────────
(2) write(byte[] b)
──────────────────────────────────────────────────────────────────────────────

Instead of writing one byte at a time, this method writes the bytes stored inside
a byte array.

Example:
        byte[] data = { 65, 66, 67 };

Then:
        output.write(data);


The three bytes are written together.

             byte[]
        ┌────┬────┬────┐
        │ 65 │ 66 │ 67 │
        └────┴────┴────┘
           │    │    │
           └────┼────┘
                ▼
        FileOutputStream
                │
                ▼
             File


Result:

        ABC


Syntax

        output.write(data);


Why is this useful?

Because we can prepare a group of bytes inside an array and write them together
instead of calling write() repeatedly.



──────────────────────────────────────────────────────────────────────────────
(3) write(byte[] b, int off, int len)
──────────────────────────────────────────────────────────────────────────────
It allows us to write only a selected portion of a byte array.

Suppose:
        byte[] data = { 65, 66, 67 };

Indexes:

        index
          0    1    2    3    4
        ┌────┬────┬────┬────┬────┐
        │ 65 │ 66 │ 67 │ 68 │ 69 │
        └────┴────┴────┴────┴────┘


Now:

        output.write(data, 1, 3);


means:

        start from index 1
                  │
                  ▼
             66  67  68
             └───────┘
              3 bytes


Therefore only: (66) (67) (68) are written.


════════════════════════════════════════════════════════════════════════════════
                    COMPLETE PRACTICAL PROGRAM
════════════════════════════════════════════════════════════════════════════════

*/


import java.io.File;
import java.io.FileOutputStream;

public class p3_FileOutputStream
{
    public static void main(String[] args)
    {
        try
        {
            File f = new File("Student.txt");

            FileOutputStream output = new FileOutputStream(f);


            output.write(65);  // -----> char(65) = A 
            output.write(66);  // -----> char(66) = B
            output.write(67);  // -----> char(67) = C

            output.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
