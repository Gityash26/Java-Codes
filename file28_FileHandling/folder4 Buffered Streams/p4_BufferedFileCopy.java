/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                    Buffered Streams — File Copy                             ║
╚══════════════════════════════════════════════════════════════════════════════╝


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
1. WHAT ARE WE PRACTICING?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

In the previous files, we learned:

    FileInputStream  → basic BYTE input
    FileOutputStream → basic BYTE output

    BufferedInputStream   → buffered BYTE input
    BufferedOutputStream  → buffered BYTE output

Now we will combine them in one practical program.

The practical problem:

        Copy the contents of one file into another file.


┌──────────────┐
│ Source File  │
└──────┬───────┘
       │
       ▼
┌─────────────────────┐
│ FileInputStream     │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ BufferedInputStream │
└──────────┬──────────┘
           │
           │ read()
           ▼
┌─────────────────────┐
│ byte[] buffer       │
│                     │
│ temporary data      │
└──────────┬──────────┘
           │
           │ write()
           ▼
┌──────────────────────┐
│ BufferedOutputStream │
└──────────┬───────────┘
           │
           ▼
┌─────────────────────┐
│ FileOutputStream    │
└──────────┬──────────┘
           │
           ▼
┌──────────────┐
│ Destination  │
│ File         │
└──────────────┘


The important point:
                        byte[] buffer

is OUR temporary array.

It is separate from the internal buffer maintained by BufferedInputStream / BufferedOutputStream.


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══== 
  WHY DO WE USE byte[] BUFFER?
════════════════════════════════════════════════════════════════════════════════

We don't want to read only one byte and immediately write only one byte again and again.

Instead, we create an array:

        byte[] buffer = new byte[4096];


This gives our program space for:

        4096 bytes


The program can repeatedly:

        READ a group of bytes
                ↓
        STORE them in buffer
                ↓
        WRITE those bytes
                ↓
        READ next group
                ↓
        WRITE next group
                ↓
        ...



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
4. THE MOST IMPORTANT PART OF THE PROGRAM
════════════════════════════════════════════════════════════════════════════════

        byte[] buffer = new byte[4096];

        int count;

        while((count = input.read(buffer)) != -1)
        {
            output.write(buffer, 0, count);
        }


Let's understand this carefully.


──────────────────────────────────────────────────────────────────────────────
STEP 1 — Create the array
──────────────────────────────────────────────────────────────────────────────

        byte[] buffer = new byte[4096];


Our array has: 4096 byte positions

Conceptually:

        buffer
        ┌────┬────┬────┬────┬────┬────┬────┬───────┐
        │ 0  │ 1  │ 2  │ 3  │ 4  │ 5  │ 6  │ ...   │
        └────┴────┴────┴────┴────┴────┴────┴───────┘
        ◄────────────── 4096 bytes ────────────────►


──────────────────────────────────────────────────────────────────────────────
STEP 2 — Read into the array
──────────────────────────────────────────────────────────────────────────────

        input.read(buffer)


This means:

        "Read bytes from the input stream and place them inside buffer."


Suppose the source file still has at least 4096 bytes available.

Then:
        input.read(buffer)

can fill the buffer with 4096 bytes.


For example:

        Source File
        ┌──────────────────────────────────────────────┐
        │ A B C D E F G H I J K L ...                  │
        └──────────────────────┬───────────────────────┘
                               │
                         read(buffer)
                               │
                               ▼
        buffer
        ┌──────────────────────────────────────────────┐
        │ A B C D E F G H I J K L ...                  │
        └──────────────────────────────────────────────┘


──────────────────────────────────────────────────────────────────────────────
STEP 3 — What does read() return?
──────────────────────────────────────────────────────────────────────────────

        input.read(buffer)

does TWO things:

        1. Puts the bytes inside buffer.
        2. Returns the NUMBER of bytes actually read.


That returned number is stored in:
                                        count

Example:
        count = 4096


means: 4096 bytes were actually read.


But suppose the file has only 1500 bytes remaining.

Then:
        input.read(buffer)

may read:
        1500 bytes 

and: count = 1500

This is why we need `count`.



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
WHY DON'T WE SIMPLY WRITE THE ENTIRE BUFFER?
════════════════════════════════════════════════════════════════════════════════

This is VERY important.

Suppose:
        byte[] buffer = new byte[4096];


But the final read gives only:
        count = 1500


The first 1500 positions contain NEW data.

The remaining positions may contain: old data or unused positions


Therefore, we should NOT do:

        output.write(buffer);


because that would attempt to write the entire 4096-byte array.


Instead:
        output.write(buffer, 0, count);


means:

        buffer
        → use this array

        0
        → start from index 0

        count
        → write only the number of bytes actually read


════════════════════════════════════════════════════════════════════════════════
-------------------            COMPLETE PROGRAM              -------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

*/


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class p4_BufferedFileCopy
{
    static final String SOURCE_PATH = "C:\\CODE FOLDERS\\JAVA Codes\\file28_FileHandling\\folder4_BufferedStreams\\Source.txt";
    static final String DESTINATION_PATH = "C:\\CODE FOLDERS\\JAVA Codes\\file28_FileHandling\\folder4_BufferedStreams\\Copy.txt";


    public static void main(String[] args)
    {
        try
        {
            // STEP 1 : Open source file and add bufer for reading
            FileInputStream fileInput = new FileInputStream(SOURCE_PATH);
            BufferedInputStream input = new BufferedInputStream(fileInput);


            // STEP 2 : Open destination file and add buffer for writing
            FileOutputStream fileOutput = new FileOutputStream(DESTINATION_PATH);
            BufferedOutputStream output = new BufferedOutputStream(fileOutput);


            
            // STEP 3 : Create our byte array
            byte[] buffer = new byte[4096];
            
            
            // STEP 4 : Read and write until the complete file is copied

            int count;
            while((count = input.read(buffer)) != -1)
            {
                output.write(buffer, 0, count);
            }

            //  Step 5 : Sent writen buffered data into the memory 
            output.flush();


            // STEP 5 : Close streams
            input.close();
            output.close();


            System.out.println("File copied successfully.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

