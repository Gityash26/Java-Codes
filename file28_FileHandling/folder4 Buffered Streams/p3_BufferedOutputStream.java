/*
╔=═=═=═=═=═=═=═=═=═=══=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══=═=═=═=═=═=═=═=═=═=═=═=═=╗
║                       Buffered Output Stream                                ║
╚═════════════════════════════════════════════════════════════════════════════╝


In he previous file, we learned:

    BufferedInputStream
        → used when we want to READ byte data efficiently.


Now the question is:

    If BufferedInputStream improves BYTE READING,
    what can we use for BYTE WRITING?

That is where BufferedOutputStream comes in.


════════════════════════════════════════════════════════════════════════════════
-------- WHAT Is BufferedOutputStream?                 ------------------------
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

BufferedOutputStream is a predefined Java class used to write BYTE data using an 
internal buffer.

Package: java.io


Declaration
                public class BufferedOutputStream extends FilterOutputStream

It is a normal (concrete) class.
It belongs to the BYTE STREAM family.

Its main purpose is:

        BYTE DATA
            ↓
        WRITING
            ↓
        USING BUFFERING


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
    WHY WAS BufferedOutputStream INTRODUCED?
════════════════════════════════════════════════════════════════════════════════

We already have FileOutputStream.

For example:
            FileOutputStream output = new FileOutputStream("Student.txt");

It allows Java to write byte data into the file.

But when a program performs a large number of small write operations, performing direct 
output repeatedly can be inefficient.

So Java provides a buffering layer.

The basic idea is:

┌────────────┐    ┌───────────────────────┐    ┌──────────────────┐
│ Java Code  │───►│ BufferedOutputStream  │───►│ FileOutputStream │
└────────────┘    │                       │    └────────┬─────────┘
                  │   Temporary Buffer    │             │
                  └───────────────────────┘             ▼
                                                     Student.txt


Instead of every small piece immediately being passed to the underlying output stream, 
data can first be collected in the buffer.

Therefore:

        FileOutputStream
            → basic byte output


        BufferedOutputStream
            → byte output + buffering


════════════════════════════════════════════════════════════════════════════════
 HOW DOES IT CONNECT WITH FileOutputStream?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

BufferedOutputStream normally works together with another OutputStream object.

Example:

        FileOutputStream output = new FileOutputStream("Student.txt");
        BufferedOutputStream bos = new BufferedOutputStream(output);


Here:

        output
            → FileOutputStream object

        bos
            → BufferedOutputStream object

    

We are passing the FileOutputStream object into BufferedOutputStream.
This is called WRAPPING.

Meaning:

        BufferedOutputStream   wraps   FileOutputStream



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
---------------          C O N S T R U C T O R S         -----------------------  
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

BufferedOutputStream mainly provides two constructors.

        ┌──────────────────────────────────────────┐
        │ BufferedOutputStream                     │
        ├──────────────────────────────────────────┤
        │ 1. (OutputStream out)                    │
        │ 2. (OutputStream out, int size)          │
        └──────────────────────────────────────────┘


           
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
BufferedOutputStream(OutputStream out)
════════════════════════════════════════════════════════════════════════════════

It creates a BufferedOutputStream around the OutputStream provided to it.

Syntax
        BufferedOutputStream bos = new BufferedOutputStream(output);


Example
        FileOutputStream output = new FileOutputStream("Student.txt");

        BufferedOutputStream bos = new BufferedOutputStream(output);


Default buffer size = 8192 bytes
                    = 8 KB

                    

=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
-----------    BufferedOutputStream(OutputStream out, int size)     --------------
═══════════════════════════════════════════════════════════════════════════════════

It creates a BufferedOutputStream with a buffer size specified by us.

Syntax
        BufferedOutputStream bos = new BufferedOutputStream(output, size);

Example

        FileOutputStream output = new FileOutputStream("Student.txt");
        BufferedOutputStream bos =  new BufferedOutputStream(output, 4096);


Here:
        output
        → underlying OutputStream

        4096
        → buffer capacity in bytes



═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
                   WHAT DOES "BUFFER SIZE" ACTUALLY MEAN?
════════════════════════════════════════════════════════════════════════════════

Suppose:

        BufferedOutputStream bos = new BufferedOutputStream(output, 4096);


This means the internal buffer has space for:

        4096 bytes


Conceptually:

┌─────────────────────────────────────────────────────────┐
│                 Internal Buffer                         │
├─────────────────────────────────────────────────────────┤
│ byte │ byte │ byte │ byte │ ... │ byte  │ byte  │ byte  │
└─────────────────────────────────────────────────────────┘
  ◄──────────────── 4096 bytes ─────────────────────────►

The buffer is temporary.
Once buffered data is sent to the underlying stream, that memory becomes available for more data.





═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
---------------                 M E T H O D S                   ----------------
════════════════════════════════════════════════════════════════════════════════

═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
write(int) method
----------------------------------------------------------------------------------


This write(int) method is used to write ONE BYTE at a time.

Syntax
        bos.write(value);

Example
        bos.write(65);


The value 65 corresponds to: 01000001
and commonly represents: 'A'


So:
        bos.write(65);

means:

        Integer value
              │
              ▼
        lowest 8 bits
              │
              ▼
            1 byte
              │
              ▼
        output stream


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
 write(byte[])
-------------------------------------------------------------------------------
This mehod uses a byte array to store all its contained values inside the BufferedInputStream at ones

Syntax

        bos.write(buffer);


Example

        byte[] data = "Hello Java".getBytes();
        bos.write(data);


Suppose the array contains:

        [H] [e] [l] [l] [o] [ ] [J] [a] [v] [a]


When we write:

        bos.write(data);

all of those bytes are given to the BufferedOutputStream.




═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
write(byte[], offset, length)
--------------------------------------------------------------------------------

This method is used when we DON'T want to write the entire array.

Syntax

        bos.write(buffer, offset, length);


The three parameters mean:

        buffer
        → Which byte array contains the data?


        offset
        → From which INDEX should writing start?


        length
        → How MANY bytes should be written?


Example:

        byte[] data = "HelloJava".getBytes();


Array:

        Index
          0    1    2    3    4    5    6    7    8
        ┌────┬────┬────┬────┬────┬────┬────┬────┬────┐
        │ H  │ e  │ l  │ l  │ o  │ J  │ a  │ v  │ a  │
        └────┴────┴────┴────┴────┴────┴────┴────┴────┘


Now:

        bos.write(data, 5, 4);


means:

        offset = 5
        length = 4


Start at index 5:

                    ┌───┬───┬───┬───┐
                    │ J │ a │ v │ a │
                    └───┴───┴───┴───┘
                      5   6   7   8


So the output will be:

        Java


The easiest way to remember:

        write(buffer, offset, length)
                       │       │
                       │       └───────────────────── how many?
                       └────────── where to start?


═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
flush()
--------------------------------------------------------------------------------

flush() sends the data currently stored in the BufferedOutputStream's buffer to the underlying stream.


Syntax 
        bos.flush();


Suppose: Buffer contains:
        ┌───────────────────────────┐
        │ Hello Java                │
        └───────────────────────────┘


After:
        bos.flush();


the buffered data is pushed to:

        FileOutputStream


Important:

flush()
        → sends buffered data
        → DOES NOT close the stream


Therefore we can still use:

        bos.write(...);


after:

        bos.flush();




════════════════════════════════════════════════════════════════════════════════
                        PRACTICAL PROGRAM
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

Now we will use everything learned above in one program.

Program requirements:

        1. Create FileOutputStream
        2. Wrap it with BufferedOutputStream
        3. Use write(int)
        4. Use write(byte[])
        5. Use write(byte[], offset, length)
        6. Use flush()
        7. Use close()


════════════════════════════════════════════════════════════════════════════════
*/


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class p3_BufferedOutputStream
{
    static final String path = "C:\\CODE FOLDERS\\JAVA Codes\\file28_FileHandling\\folder4 Buffered Streams\\Student.txt";


    public static void main(String[] args)
    {
        try
        {
            // STEP 1 : Create FileOutputStream
            FileOutputStream output = new FileOutputStream(path);

            // STEP 2 : Wrap FileOutputStream using BufferedOutputStream
            BufferedOutputStream bos = new BufferedOutputStream(output);



            // ----------------- Using method ---------> write(int)
            bos.write(65);     // A
            bos.write(66);     // B
            bos.write(67);     // C



            // ----------------- Using method ---------> write(byte[])
            byte[] data = "Hello Java\n".getBytes();
            bos.write(data);


            // ----------------- Using method ---------> write(byte[], offset, length)
            byte[] message = "BufferedOutputStream".getBytes();
            bos.write(message, 0, 8);


            // ----------------- Using method ---------> flush()
            bos.flush();

            // ----------------- Using method ---------> close()
            bos.close();


            System.out.println("Data written successfully.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}


/*
════════════════════════════════════════════════════════════════════════════════

16. WHAT EXACTLY HAPPENED IN THE PROGRAM?
    ═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

First:

        FileOutputStream output =
                new FileOutputStream(FILE_PATH);


This creates the basic byte-output connection to the file.


Then:

        BufferedOutputStream bos =
                new BufferedOutputStream(output);


Now the BufferedOutputStream is placed around that output connection.


The structure is:

┌──────────────┐
│ Java Program │
└───────┬──────┘
        │
        ▼
┌──────────────────────┐
│ BufferedOutputStream │
│                      │
│   Internal Buffer    │
└──────────┬───────────┘
           │
           ▼
┌──────────────────┐
│ FileOutputStream │
└────────┬─────────┘
         │
         ▼
┌─────────────────┐
│   Student.txt   │
└─────────────────┘


Then our different `write()` methods supplied byte data
to the output process.

Finally:

        bos.flush();

sent currently buffered data forward.

And:

        bos.close();

finished the complete output operation.


════════════════════════════════════════════════════════════════════════════════

17. WHAT SHOULD I REMEMBER?
    ═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

        FileOutputStream
        → basic byte writing


        BufferedOutputStream
        → adds buffering to byte writing


        write(int)
        → writes one byte


        write(byte[])
        → writes complete byte array


        write(byte[], offset, length)
        → writes selected part of byte array


        flush()
        → sends currently buffered data forward


        close()
        → flushes remaining data and closes the stream


        Constructor 1
        → default buffer


        Constructor 2
        → custom buffer size


════════════════════════════════════════════════════════════════════════════════
*/