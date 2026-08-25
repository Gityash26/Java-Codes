/*
╭──────────────────────────────────────────────────────────────╮
│      Topic - Read + Write Using RandomAccessFile             │
╰──────────────────────────────────────────────────────────────╯


═══════════════════════════════════════════════════════════════
1. Reading and Writing Together
═══════════════════════════════════════════════════════════════

So far, we have seen how RandomAccessFile can:

        Read data
            +
        Write data
            +
        Move the file pointer


When the file is opened in "rw" mode, we can perform both operations using the 
same RandomAccessFile object.


        RandomAccessFile
               │
               ▼
           "rw" mode
               │
        ┌──────┴──────┐
        ▼             ▼
      Read          Write
        │             │
        └──────┬──────┘
               ▼
           Same File



═══════════════════════════════════════════════════════════════
2. Read → Move → Write
═══════════════════════════════════════════════════════════════

A common Random Access operation can be performed as:

        Read existing data
               ↓
        Move to required position
               ↓
        Write new data
               ↓
        Read again to verify


For example, suppose the file contains:

        ┌────┬────┬────┬────┬────┬────┐
        │ H  │ e  │ l  │ l  │ o  │ !  │
        └────┴────┴────┴────┴────┴────┘


We want to replace the character at position 4.

        seek(4)
           ↓
        position 4
           ↓
        write('X')


Result:

        ┌────┬────┬────┬────┬────┬────┐
        │ H  │ e  │ l  │ l  │ X  │ !  │
        └────┴────┴────┴────┴────┴────┘


The important point is that we are not creating a
separate read object and write object.

The same RandomAccessFile object can perform both operations
when opened using "rw".



═══════════════════════════════════════════════════════════════
3. Practical Example
═══════════════════════════════════════════════════════════════

Suppose data.txt contains:

        Hello!


We will:

        1. Open the file using "rw"
        2. Read and display the original content
        3. Move to position 4
        4. Replace 'o' with 'X'
        5. Read and display the updated content



Original:

        H e l l o !
        0 1 2 3 4 5
                ▲
                │
             position 4


After writing 'X':

        H e l l X !
        0 1 2 3 4 5
                ▲
                │
             position 4



═══════════════════════════════════════════════════════════════
Implementation
═══════════════════════════════════════════════════════════════

*/

import java.io.RandomAccessFile;

public class p4_ReadWriteUsingRAS 
{

    public static void main(String[] args) throws Exception {

        RandomAccessFile file =
                new RandomAccessFile("data.txt", "rw");


        // Read the original content

        System.out.println("Before modification:");

        int data;

        while ((data = file.read()) != -1) {
            System.out.print((char) data);
        }


        // Move to position 4

        file.seek(4);


        // Write new data

        file.write('X');


        // Move back to the beginning

        file.seek(0);


        // Read the updated content

        System.out.println("\n\nAfter modification:");

        while ((data = file.read()) != -1) {
            System.out.print((char) data);
        }


        file.close();
    }
}