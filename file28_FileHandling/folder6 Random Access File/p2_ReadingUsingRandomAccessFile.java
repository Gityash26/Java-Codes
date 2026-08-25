/*
╭──────────────────────────────────────────────────────────────╮
│          Topic - Reading Using RandomAccessFile              │
╰──────────────────────────────────────────────────────────────╯


═══════════════════════════════════════════════════════════════
1. Reading Data
═══════════════════════════════════════════════════════════════


═══════════════════════════════════════════════════════════════
 read() method
═══════════════════════════════════════════════════════════════
read() reads one byte from the current file-pointer position and returns that 
byte as an int.

Syntax:

        int data = file.read();


        File
        ┌────┬────┬────┬────┬────┐
        │ H  │ e  │ l  │ l  │ o  │
        └────┴────┴────┴────┴────┘
          ▲
          │
          H
          ↓
       read()  returns----> int data


The return type is int, not char.

For a valid byte:

        0 ─────────────────────► 255
              valid byte


When the end of the file is reached:

        read() ─────────────────────► -1

So:

        0 to 255
            → Valid byte

        -1
            → End of File (EOF)



═══════════════════════════════════════════════════════════════
Type conversion     (int) ---> char
═══════════════════════════════════════════════════════════════

If the file contains text, the returned byte can be converted to a character.

Example:

        int data = file.read();
        char ch = (char) data;




═══════════════════════════════════════════════════════════════
Implementation
═══════════════════════════════════════════════════════════════

This program demonstrates:

        ✓ Opening a file in "r" mode
        ✓ Moving to a specific position
        ✓ Reading bytes using read()
        ✓ Converting bytes to characters
        ✓ Reading until EOF
        ✓ Closing the file


*/

import java.io.RandomAccessFile;

public class p2_ReadingUsingRandomAccessFile 
{

    public static void main(String[] args) throws Exception 
    {

        RandomAccessFile file = new RandomAccessFile("data.txt", "rw");

        file.seek(6);

        int data;

        while ((data = file.read()) != -1) 
        {
            System.out.print((char) data);
        }

        file.close();
    }
}