/*

                        BYTE I/O STREAMS
                              │          
                    ┌─────────┴─────────┐
                    ▼                   ▼
          FileInputStream       FileOutputStream
                    │                   │
                    ▼                   ▼
        BufferedInputStream     BufferedOutputStream


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
--------------           Buffered Input Stream              --------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

BufferedInputStream is a predefined Java class used to read byte data through an 
internal memory buffer.

Package: java.io

It is a normal (concrete) class.

It belongs to the Byte Stream family because it works with:

        InputStream
            ↓
        byte data
   

════════════════════════════════════════════════════════════════════════════════
 WHY DO WE NEED BufferedInputStream?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

We already know FileInputStream.

        File
        │
        ▼
 FileInputStream
        │
        ▼
      Program


BufferedInputStream adds a buffer around the FileInputStream:

        File
        │
        ▼
 FileInputStream
        │
        ▼
 ┌──────────────────────┐
 │ BufferedInputStream  │
 │      Buffer          │
 └──────────┬───────────┘
            │
            ▼
         Program


The important point:

        FileInputStream
            → connects to the File.

        BufferedInputStream
            → adds buffering to the input process.


════════════════════════════════════════════════════════════════════════════════
 HOW DO WE CREATE BufferedInputStream?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Remember one thing that the BufferedInputStream does not normally work alone.
It is created by providing an InputStream object to its constructor.

Example:

        FileInputStream input = new FileInputStream("Student.txt");

        BufferedInputStream bufferedInput = new BufferedInputStream(input);


Relationship:

        bufferedInput
              │
              │ wraps
              ▼
        FileInputStream
              │
              ▼
             File


════════════════════════════════════════════════════════════════════════════════
-------------                  CONSTRUCTORS                     --------------
=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=


--------------------------------------------------
(1) BufferedInputStream(InputStream in)
═══════════════════════════════════════════════

Creates a BufferedInputStream using the given InputStream object.

Syntax:
            BufferedInputStream bis = new BufferedInputStream(inputStream);


Data flow:
            java <-----------<<- BufferedInputStream <--------------InputStream


Default Size of the buffere:
                            8192 bytes = 8KB

────────────────────────────────────────────────────────────────────────────────


--------------------------------------------------
(2) BufferedInputStream(InputStream in, int size)
═══════════════════════════════════════════════

Creates a BufferedInputStream with a specified buffer size.

Syntax:
        BufferedInputStream bis = new BufferedInputStream(inputStream, size);

Example:
            FileInputStream input = new FileInputStream("Student.txt");
            BufferedInputStream bis = new BufferedInputStream(input, 4096);


Here:
        size = 4096 bytes
             = 4 KB


Therefore, the internal buffer can hold:

        4096 bytes at a time.


════════════════════════════════════════════════════════════════════════════════
----------------                M E T H O D S           ---------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

The most important methods for our learning are:

        ┌──────────────────────────────────────┐
        │ BufferedInputStream                  │
        ├──────────────────────────────────────┤
        │ read()                               │
        │ read(byte[])                         │
        │ read(byte[], offset, length)         │
        │ skip()                               │
        │ available()                          │
        │ close()                              │
        └──────────────────────────────────────┘


════════════════════════════════════════════════════════════════════════════════
1. read()
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
This method Reads one byte from the input stream.

Return type: int

Returns:

        actual byte value
                ↓
            0 to 255

        End of Stream
                ↓
               -1


Syntax:  

        int data = bis.read();


Example:

        int data = bis.read();

        if(data != -1)
        {
            System.out.println((char) data);
        }


Important:

The return type is int, not byte, because the method must also represent the special value -1 for End Of Stream.


════════════════════════════════════════════════════════════════════════════════
2. read(byte[] buffer)
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
Reads multiple bytes at once and stores them inside the given byte array.

Syntax:
        int count = bis.read(buffer);


Suppose:
        byte[] buffer = new byte[4096];


Then:
        bis.read(buffer);


means:

        File
         │
         ▼
 BufferedInputStream
         │
         │ up to 4096 bytes
         ▼
 ┌──────────────────────┐
 │ byte[] buffer        │
 │                      │
 │ [ ][ ][ ][ ] ...     │
 └──────────────────────┘


Example:
--------------------------------
        byte[] buffer = new byte[4096];
        int count = bis.read(buffer);


If 4096 bytes were available:
        count = 4096


If only 850 bytes remained:
        count = 850


If no data remains:
        count = -1


════════════════════════════════════════════════════════════════════════════════
3. read(byte[] buffer, int offset, int length)
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
Reads bytes into a specific portion of the byte array.

Parameters:

        buffer
            ↓
                byte array where data will be stored

        offset
            ↓
                starting index inside the array

        length
            ↓
                maximum number of bytes to read


Syntax:
        int count = bis.read(buffer, offset, length);


Example:

        byte[] buffer = new byte[4096];

        int count = bis.read(buffer, 100, 500);


Meaning:
        Start storing data at index 100 and read at most 500 bytes.


Visual:

        index
          0        100                         599       4095
          │         │                            │          │
          ▼         ▼                            ▼          ▼
        ┌───────────┬────────────────────────────┬──────────┐
        │ unused    │       data received       │ unused   │
        └───────────┴────────────────────────────┴──────────┘
                    └────────── 500 ────────────┘


This method is useful when we want precise control over where the incoming bytes are stored.


════════════════════════════════════════════════════════════════════════════════
4. skip(long n)
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
Skips a specified number of bytes from the input stream.

Syntax:
        long skipped = bis.skip(10);

Meaning:
        Move forward by up to 10 bytes without returning those bytes to the program.


════════════════════════════════════════════════════════════════════════════════
5. available()
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
Returns an estimate of the number of bytes that can be read without blocking.

Return type: int

Syntax:
        int available = bis.available();


Important:

available() should NOT be used as a replacement for checking
End Of Stream.
s also closed.


════════════════════════════════════════════════════════════════════════════════
------------------               METHOD SUMMARY                 ----------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

┌──────────────────────────────┬─────────────────────────────────────────────┐
│ Method                       │ Purpose                                     │
├──────────────────────────────┼─────────────────────────────────────────────┤
│ read()                       │ Reads one byte                              │
│ read(byte[])                 │ Reads multiple bytes into an array          │
│ read(byte[],off,len)         │ Reads bytes into a specific array section   │
│ skip(n)                      │ Skips up to n bytes                         │
│ available()                  │ Returns bytes currently available           │
│ close()                      │ Closes the stream                          │
└──────────────────────────────┴─────────────────────────────────────────────┘


════════════════════════════════════════════════════════════════════════════════
BASIC WORKING
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

        FileInputStream fis = new FileInputStream("Student.txt");

        BufferedInputStream bis = new BufferedInputStream(fis);

        int data;

        while((data = bis.read()) != -1)
        {
            System.out.print((char) data);
        }

        bis.close();


For multiple-byte reading:

        byte[] buffer = new byte[4096];

        int count;

        while((count = bis.read(buffer)) != -1)
        {
            // process count valid bytes
        }


════════════════════════════════════════════════════════════════════════════════
 IMPORTANT UNDERSTANDING
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Remember the responsibility of each object:

        File
         ↓
          Represents the file/location


        FileInputStream
         ↓
         Provides byte input from the file


        BufferedInputStream
         ↓
         Adds buffering around the input stream


        byte[]
         ↓
         Can be used by the program to temporarily hold multiple bytes


So:

        BufferedInputStream is NOT another type of File.
        It is a stream used for buffered byte input.


*/


import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class p2_BufferedInputStream
{
    static final String path = "C:\\CODE FOLDERS\\JAVA Codes\\file28_FileHandling\\folder4 Buffered Streams\\Student.txt";


    // ─────────────────────────────────────────────────────────────────────────
    // Demonstrates Constructor 1 + read()
    // ─────────────────────────────────────────────────────────────────────────

    static void demonstrateRead() throws Exception
    {
        FileInputStream input = new FileInputStream(path);

        // default buffer size 
        BufferedInputStream bis = new BufferedInputStream(input);

        System.out.println("----- read() method demonstration -----");

        int data;
        while((data = bis.read()) != -1)
        {
            System.out.print((char) data);
        }

        System.out.println();

        bis.close();
    }


    // ─────────────────────────────────────────────────────────────────────────
    // Demonstrates Constructor 2 + read(byte[])
    // ─────────────────────────────────────────────────────────────────────────

    static void demonstrateByteArrayRead() throws Exception
    {
        FileInputStream input = new FileInputStream(path);

        // buffer with 500 bytes of size 
        BufferedInputStream bis = new BufferedInputStream(input, 500);

        System.out.println("\n----- read(byte[]) method demonstration -----");

        byte[] buffer = new byte[10];

        int count;
        while((count = bis.read(buffer)) != -1)
        {
                // cout tells us that how many characters were read 
            System.out.print(new String(buffer, 0, count));
        }

        System.out.println();
        bis.close();
    }


    // ─────────────────────────────────────────────────────────────────────────
    // Demonstrates skip()
    // ─────────────────────────────────────────────────────────────────────────

    static void demonstrateSkip() throws Exception
    {
        FileInputStream input = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(input);

        System.out.println("\n----- skip() demonstration -----");

        // Skip first 5 bytes.
        long skipped = bis.skip(5);

        System.out.println("Bytes skipped = " + skipped);

        int data;
        while((data = bis.read()) != -1)
        {
            System.out.print((char) data);
        }

        System.out.println();

        bis.close();
    }


    // ─────────────────────────────────────────────────────────────────────────
    // Demonstrates available()
    // ─────────────────────────────────────────────────────────────────────────

    static void demonstrateAvailable() throws Exception
    {
        FileInputStream input = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(input);

        System.out.println("\n----- available() demonstration -----");

        System.out.println("Bytes available = " + bis.available());
        bis.close();
    }


    public static void main(String[] args)
    {
        try
        {
            demonstrateRead();

            demonstrateByteArrayRead();

            demonstrateSkip();

            demonstrateAvailable();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}