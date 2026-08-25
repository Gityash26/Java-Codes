/*
╭──────────────────────────────────────────────────────────────╮
│          Topic - Writing Using RandomAccessFile              │
╰──────────────────────────────────────────────────────────────╯


═══════════════════════════════════════════════════════════════
1. Writing Data
═══════════════════════════════════════════════════════════════
The write method of RandomAccessFile will be used to write data into the file 
at current file pointer location.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=
 write(int data) method
═══════════════════════════════════════════════════════════════

The method writes the lowest 8 bits of the given int as one byte.

Syntax:
        file.write(65);

For example:
        file.write(65);

        65
         │
         ▼
       byte ----> 'A'


So:
        write(65)
            → writes the byte representing 'A'


Similarly:

        write(66)   → 'B'
        write(67)   → 'C'


The file pointer then moves forward by one byte.



═══════════════════════════════════════════════════════════════
 Writing a Character
═══════════════════════════════════════════════════════════════

A character can also be written by passing its value to write().

Example:
        file.write('A');


Conceptually:

        'A'
         │
         ▼
       value
         │
         ▼
      write()
         │
         ▼
       1 byte



═══════════════════════════════════════════════════════════════
4. Writing at a Specific Position
═══════════════════════════════════════════════════════════════

This is where writing becomes useful with Random Access.

We can first move the file pointer using seek() and then write at that position.

        file.seek(4);
        file.write('X');


Writing does NOT necessarily mean adding data only at the end of the file.
If we write at an existing position, the existing byte at that position can be replaced.



═══════════════════════════════════════════════════════════════
--------------  how to write multiple characters   ------------
═══════════════════════════════════════════════════════════════

To write multiple characters, we can use:

        write(byte[] data)

Example:
        file.write("Java".getBytes());


The String is first converted into bytes:

        "Java"
           │
           ▼
      getBytes()
           │
           ▼
       byte[ ]
           │
           ▼
        write()
           │
           ▼
         File


This allows us to write multiple bytes together.



═══════════════════════════════════════════════════════════════
Implementation
═══════════════════════════════════════════════════════════════

This program demonstrates:

        ✓ Opening a file in "rw" mode
        ✓ Moving to a specific position
        ✓ Writing a character
        ✓ Writing multiple characters
        ✓ Closing the file


*/

import java.io.RandomAccessFile;

public class p3_WritingUsingRandomAccessFile
{

    public static void main(String[] args) throws Exception 
    {

        RandomAccessFile file = new RandomAccessFile("data.txt", "rw");
        
        file.seek(5);
        file.write('X');

        file.write("Java".getBytes());

        file.close();
    }
}