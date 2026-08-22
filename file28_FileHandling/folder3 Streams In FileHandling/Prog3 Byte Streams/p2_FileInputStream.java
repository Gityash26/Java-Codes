/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                    UNDERSTANDING BYTE STREAMS                                ║
╚══════════════════════════════════════════════════════════════════════════════╝


════════════════════════════════════════════════════════════════════════════════
                         1. WHAT IS A BYTE?
════════════════════════════════════════════════════════════════════════════════

A computer ultimately stores data in the form of BITS.

        Bit
         │
         ├────────► 0
         │
         └────────► 1


        8 Bits = 1 Byte


                 1 BYTE
        ┌──────────────────────┐
        │ 0 1 0 0 1 0 0 1     │
        └──────────────────────┘
          └──── 8 BITS ─────┘


A byte can represent 256 different values:

        00000000  → 0
        00000001  → 1
        00000010  → 2
        ...
        11111111  → 255



════════════════════════════════════════════════════════════════════════════════
                    2. WHAT DOES A FILE ACTUALLY CONTAIN?
════════════════════════════════════════════════════════════════════════════════

At the lowest level, a File contains BYTES.

For example, suppose:
                        Student.txt

contains:
        ABC


The computer stores this data as bytes.

For simple English characters:

        --------------------------------------------------------
        Character       Byte Value       Binary
        --------------------------------------------------------
            A              65           01000001
            B              66           01000010
            C              67           01000011
        --------------------------------------------------------


Therefore, conceptually:

        Student.txt

        ┌──────────┐ ┌──────────┐ ┌──────────┐
        │01000001  │ │01000010  │ │01000011  │
        └──────────┘ └──────────┘ └──────────┘
             65           66           67
              │            │            │
              A            B            C


IMPORTANT

The File fundamentally contains BYTES.

"A", "B", "C" are interpretations of those bytes
according to a character encoding.



════════════════════════════════════════════════════════════════════════════════
                    3. BYTE STREAM vs CHARACTER STREAM
════════════════════════════════════════════════════════════════════════════════

We have already learned:

        Character Stream

      File
        │
        ▼
    FileReader
        │              -----> Converts bytes into characters
        ▼
    Characters
        │
        ▼
    Java Program


Here Java is interested in the data as CHARACTER DATA.



Byte Stream works differently:

        File
         │
         ▼
 FileInputStream
         │                     ----> Just provide raw bytes as it was 
         ▼
      Raw Bytes
         │
         ▼
    Java Program


Here Java works directly with the BYTES.

Therefore:

        Character Stream
              ↓
        Character-oriented


        Byte Stream
              ↓
        Byte-oriented



════════════════════════════════════════════════════════════════════════════════
                    4. WHY BYTE STREAMS ARE REQUIRED
════════════════════════════════════════════════════════════════════════════════

Not every File is a text File.

Examples:

        Student.txt
        image.jpg
        song.mp3
        video.mp4
        document.pdf
        file.zip


For a text File:

        File
         │
         ▼
    Character Stream
         │
         ▼
     Characters


For binary data:

        File
         │
         ▼
      Byte Stream
         │
         ▼
       Bytes


Byte Streams are especially useful for transferring
raw/binary data without trying to interpret it as text.



════════════════════════════════════════════════════════════════════════════════
                    5. HOW FILEINPUTSTREAM WORKS
════════════════════════════════════════════════════════════════════════════════

FileInputStream simply reads the bytes from the File.

Example:

        Student.txt

        A   B   C


Conceptually:

        File
         │
         │ raw bytes
         ▼
   FileInputStream
         │
         │ bytes
         ▼
    Java Program


It does NOT need to understand:

        "This byte means A."


It simply reads:

        65
        66
        67


If we want to display them as characters:

        (char)65 → A
        (char)66 → B
        (char)67 → C


The conversion is being done by OUR PROGRAM,
not by the byte stream itself.



════════════════════════════════════════════════════════════════════════════════
                    6. WHAT IS A BYTE ARRAY?
════════════════════════════════════════════════════════════════════════════════

A byte array is simply an array whose every element
can store ONE BYTE.

Example:

        byte[] buffer = new byte[5];


This creates space for:

        5 BYTES


Visual representation:

        buffer

        index
          0       1       2       3       4
        ┌───────┬───────┬───────┬───────┬───────┐
        │  1 B  │  1 B  │  1 B  │  1 B  │  1 B  │
        └───────┴───────┴───────┴───────┴───────┘
                  TOTAL = 5 BYTES



════════════════════════════════════════════════════════════════════════════════
                    7. READING USING A BYTE ARRAY
════════════════════════════════════════════════════════════════════════════════

Suppose the File contains:

        ABCDEFGHIJ


Total:

        10 BYTES

Now we create:

        byte[] buffer = new byte[5];


The array can hold:

        5 BYTES at a time


When we execute:

        int count = input.read(buffer);


Java reads UP TO 5 bytes from the File.

First reading:

        File

        A B C D E F G H I J
        └───────────────┘
             5 bytes
                  │
                  ▼
        ┌───┬───┬───┬───┬───┐
        │ A │ B │ C │ D │ E │
        └───┴───┴───┴───┴───┘
             byte array


The reading position now moves forward:

        A B C D E F G H I J
                └───────────►


Second reading:

        A B C D E F G H I J
                └───────────┘
                   5 bytes
                       │
                       ▼
        ┌───┬───┬───┬───┬───┐
        │ F │ G │ H │ I │ J │
        └───┴───┴───┴───┴───┘


Therefore:

        10-byte File
              │
              ▼
        byte[5] buffer
              │
              ├──── First 5 bytes
              │
              └──── Next 5 bytes



════════════════════════════════════════════════════════════════════════════════
                    8. DOES byte[5] ALWAYS READ 5 BYTES?
════════════════════════════════════════════════════════════════════════════════

It can read UP TO 5 bytes.

Example:

        byte[] buffer = new byte[5];

        int count = input.read(buffer);


Maximum:

        5 bytes


But the actual number can be smaller.

For example, if only 3 bytes are remaining:

        File
        ┌───┬───┬───┐
        │ A │ B │ C │
        └───┴───┴───┘
             3 bytes


then:

        count = 3


Therefore:

        byte[5]

means:

        "I have space for 5 bytes."

It does NOT mean:

        "Exactly 5 bytes will always be read."



════════════════════════════════════════════════════════════════════════════════
                    9. WHAT DOES count REPRESENT?
════════════════════════════════════════════════════════════════════════════════

When we write:

        int count = input.read(buffer);


The variable:

        count

stores the number of bytes ACTUALLY read.

Example:

        byte[] buffer = new byte[5];

        int count = input.read(buffer);


If 5 bytes were read:

        count = 5


If only 3 bytes were available:

        count = 3


If the End Of File has already been reached:

        count = -1



════════════════════════════════════════════════════════════════════════════════
                    10. BYTE ≠ CHARACTER
════════════════════════════════════════════════════════════════════════════════

This is very important.

Do NOT remember:

        1 Byte = 1 Character


That is NOT always true.


For simple English characters using ASCII / UTF-8:

        A → 1 byte
        B → 1 byte
        C → 1 byte


So in this particular case:

        5 bytes ≈ 5 characters


But characters from other languages or symbols
may require multiple bytes depending on the encoding.

For example:

        अ
        你
        😊


may require more than one byte in UTF-8.


Therefore:

        5 BYTES

does NOT necessarily mean:

        5 CHARACTERS



════════════════════════════════════════════════════════════════════════════════
                    11. THE CORRECT MENTAL MODEL
════════════════════════════════════════════════════════════════════════════════

Think of a File as:

                         FILE
                          │
                          ▼
                    RAW BYTES
                          │
              ┌───────────┴───────────┐
              │                       │
              ▼                       ▼
        Byte Stream             Character Stream
              │                       │
              │                       │
              ▼                       ▼
        "Give me bytes"       "Interpret these bytes
                                as characters"


Therefore:

        FileInputStream
              ↓
        works directly with bytes


        FileReader
              ↓
        works with character data
        by decoding the underlying bytes



════════════════════════════════════════════════════════════════════════════════
                    12. PRACTICAL USE IN DEVELOPMENT
════════════════════════════════════════════════════════════════════════════════

One of the most common uses of Byte Streams
is copying binary data.

For example:

        photo.jpg
             │
             ▼
      FileInputStream
             │
             ▼
        byte[4096]
             │
             ▼
      FileOutputStream
             │
             ▼
      new_photo.jpg


The process becomes:

        Read some bytes
              ↓
        Store in buffer
              ↓
        Write those bytes
              ↓
        Read next bytes
              ↓
        Write again
              ↓
        Continue until EOF


Visual:

        ┌──────────────┐
        │   photo.jpg  │
        └──────┬───────┘
               │
               ▼
       FileInputStream
               │
          up to 4096
             bytes
               │
               ▼
       ┌────────────────┐
       │  byte[4096]    │
       └───────┬────────┘
               │
               ▼
      FileOutputStream
               │
               ▼
        new_photo.jpg


This allows Java to transfer binary data
without trying to understand what that data represents.



════════════════════════════════════════════════════════════════════════════════
                         FINAL PICTURE
════════════════════════════════════════════════════════════════════════════════

                    FILE
                     │
                     ▼
                  BYTES
                     │
          ┌──────────┴──────────┐
          │                     │
          ▼                     ▼
    FileInputStream         FileReader
          │                     │
          ▼                     ▼
     Raw Bytes             Character Data
          │                     │
          ▼                     ▼
     byte[] buffer          Characters
          │                     │
          └──────────┬──────────┘
                     ▼
                Java Program


Remember:

        8 bits
          ↓
        1 byte

        byte[]
          ↓
        collection of bytes

        byte[4096]
          ↓
        space for 4096 bytes

        read(buffer)
          ↓
        reads UP TO buffer.length bytes

        bytes ≠ characters

        1 character may use 1 or more bytes
        depending on character encoding.

══════════════════════════════════════════════════════════════════════════════
*/

/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                         FileInputStream                                      ║
╚══════════════════════════════════════════════════════════════════════════════╝

                     Stream
                        │
              ┌─────────┴──────────┐
              │                    │
              ▼                    ▼
         Character               Byte
           Stream               Stream
        (already done)             │
                                   │
                         ┌─────────┴──────────┐
                         │                    │
                         ▼                    ▼
                    InputStream          OutputStream
                         │                    │
                FileInputStream           FileOutputStream



════════════════════════════════════════════════════════════════════════════════
FileInputStream
════════════════════════════════════════════════════════════════════════════════

FileInputStream is a predefined class provided by Java for reading BYTE data from a File.

FileInputStream does NOT try to interpret the data as characters.

It simply reads the raw bytes.

Therefore it can be used for:
        image, audio, video, PDF, ZIP, text etc..


Hierarchy

        InputStream
             └──────────► FileInputStream



════════════════════════════════════════════════════════════════════════════════
Basic Working
════════════════════════════════════════════════════════════════════════════════

Suppose a File contains raw data:

        ┌─────────────────────────────────┐
        │  72   101   108   108   111     │
        └────────────────┬────────────────┘
                         │
                         ▼
                 FileInputStream
                         │
                         ▼
                  Java Program


Each read operation retrieves byte data.


════════════════════════════════════════════════════════════════════════════════
                         C O N S T R U C T O R S
════════════════════════════════════════════════════════════════════════════════


──────────────────────────────────────────────────────────────────────────────
(1) FileInputStream(String/File)
──────────────────────────────────────────────────────────────────────────────

Creates a FileInputStream using the, 

File path: (String type)
----------------------------------------------------------------------
        FileInputStream input = new FileInputStream("Student.txt");
----------------------------------------------------------------------


file object: (Object type)
----------------------------------------------------------------------
        File f = new File(String path);

        FileInputStream input = new FileInputStream(f);
----------------------------------------------------------------------




════════════════════════════════════════════════════════════════════════════════
                         M E T H O D S
════════════════════════════════════════════════════════════════════════════════


──────────────────────────────────────────────────────────────────────────────
(1) read()
──────────────────────────────────────────────────────────────────────────────
This method is used to Reads ONE byte from the File.

Return Type
                int

Byte available
              ↓
            returns byte value


End Of File
          ↓
        returns -1


Therefore:

        read() != -1  --------->  More bytes available

        read() == -1  --------->   End Of File


Example

Suppose the File contains:
                                ABC

Conceptually:

        read() → 65
        read() → 66
        read() → 67
        read() → -1


Because:

        A → 65
        B → 66
        C → 67


Syntax

        int data = inputObj.read();


If we want to display the byte as a character:

        System.out.print((char)data);


But remember:

FileInputStream itself is returning BYTE data.
The character conversion is something we are doing only for displaying text.


════════════════════════════════════════════════════════════════════════════════
Reading the Complete File
════════════════════════════════════════════════════════════════════════════════

Since read() reads only ONE byte at a time, we normally use a loop.

        int data;

        while((data = input.read()) != -1)
        {
            System.out.print((char)data);
        }


Visual

        ┌──────────────────────┐
        │ File                 │
        │ A B C D E ...        │
        └──────────┬───────────┘
                   │
                   ▼
          FileInputStream
                   │
                   ▼
               read()
                   │
              ┌────┴────┐
              ▼         ▼
            Byte       -1
              │         │
              ▼         ▼
            Print      Stop
              │
              └──────────────┐
                             │
                             ▼
                         read() again


─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-
(2) read(byte[] b)
──────────────────────────────────────────────────────────────────────────────

Instead of reading only one byte at a type, this method allows us to read MULTIPLE bytes at once.

Suppose:
        byte[] data = new byte[5];

and the File contains:
                        HELLO

Now:
        int count = input.read(data);   ------> read into the data 


The bytes are stored inside the array:

                        data

        index     0    1    2    3    4
                  ─────────────────────
        value     H    E    L    L    O


The method also tells us how many bytes were actually read.

        count = 5


It returns: Number of bytes actually read

or

-1  --------> End Of File already reached


Syntax
        int count = input.read(data);


Why use this?
Imagine a large File.

Instead of:

        read one byte
        read one byte
        read one byte
        read one byte
        ...


we can use a byte array:

        ┌───────────────────────────┐
        │ byte[] buffer             │
        │                           │
        │  A   B   C   D   E ...    │
        └───────────────────────────┘
                    ▲
                    │
              read multiple
                bytes together


This is more useful when processing larger Files.


──────────────────────────────────────────────────────────────────────────────
(3) read(byte[] b, int offset, int length)
──────────────────────────────────────────────────────────────────────────────
Sometimes we don't want to fill the entire array.

We may want to:
                • start storing from a particular index
                • read only a limited number of bytes


Suppose:
        byte[] data = new byte[10];

Now:
        input.read(data, 2, 5);  --> data : read into data, 
                                 --> 2    : from index 2
                                 --> 5    : Only 5 bytes 


means:

        data
        index
          0   1   2   3   4   5   6   7   8   9
                  └───────────────┘
                     5 bytes



Parameters

        data   : byte array where data will be stored
        offset : starting index inside the array
        length : maximum number of bytes to read




──────────────────────────────────────────────────────────────────────────────
(4) skip(long n)
──────────────────────────────────────────────────────────────────────────────

skip() is used when we want to move the reading position forward WITHOUT reading those bytes.

Suppose the File contains:

        A   B   C   D   E   F   G
        ↑
        current position


Now:

        input.skip(3);


The first three bytes are skipped:

        A   B   C   D   E   F   G
        ─────────
           skipped
                    ↑
                    next position


The next read() will start from:

        D


Return Type
        long


It returns the actual number of bytes skipped.

Syntax

        long skipped = input.skip(3);


──────────────────────────────────────────────────────────────────────────────
(5) available()
──────────────────────────────────────────────────────────────────────────────

available() tells us approximately how many bytes can currently be read without waiting.

Example:
        int n = input.available();


If:
        n = 20


it means approximately 20 bytes are currently available for reading without blocking.


Return Type
                int


Syntax
        int n = input.available();


Important:

available() does NOT mean:
        "What is the total size of my File?"

It only tells us about bytes that can currently be read without waiting.


════════════════════════════════════════════════════════════════════════════════
                    C O M P L E T E   P R O G R A M
════════════════════════════════════════════════════════════════════════════════

*/


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class p2_FileInputStream
{
    public static void main(String[] args)
    {
        try
        {
           // creating a new file 
            File f = new File("Student.txt");
            FileWriter file = new FileWriter(f);
            file.append("HELLO APPPLE BANANA ORANGE");
            file.close();


           // creating FileInputStream Object  
            FileInputStream input = new FileInputStream(f);


            int data;
            while((data = input.read()) != -1)
            {
                System.out.print((char)data);
            }

            // closing InputStreamObject
            input.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}


/*
════════════════════════════════════════════════════════════════════════════════
                         COMPLETE FLOW
════════════════════════════════════════════════════════════════════════════════

        Student.txt
             │
             │
             ▼
    FileInputStream
             │
             │ read()
             ▼
        One Byte
             │
             ▼
       Use / Process
             │
             │
             └──────────────────────┐
                                    │
                                    ▼
                                read again
                                    │
                                    ▼
                                  -1 ?
                                /     \
                              No       Yes
                              │         │
                              └───►   Stop
                                        │
                                        ▼
                                   close()


════════════════════════════════════════════════════════════════════════════════
                 FileReader vs FileInputStream
════════════════════════════════════════════════════════════════════════════════

        FileReader                    FileInputStream
            │                              │
            ▼                              ▼
      Character Stream                Byte Stream
            │                              │
            ▼                              ▼
      Reads characters                 Reads bytes
            │                              │
            ▼                              ▼
       Text-oriented                 Binary-oriented


Example:

        Student.txt
            ↓
        FileReader


        image.jpg
            ↓
        FileInputStream


But remember:

FileInputStream can also read a text File.

It simply treats the File as bytes rather than interpreting it as characters.


════════════════════════════════════════════════════════════════════════════════
Important Takeaways
════════════════════════════════════════════════════════════════════════════════

✔ FileInputStream is a concrete class.

✔ It extends InputStream.

✔ It is present inside java.io.

✔ It is used to read byte data from a File.

✔ read() reads one byte.

✔ read(byte[]) reads multiple bytes into an array.

✔ read(byte[], offset, length) reads bytes into
  a selected part of an array.

✔ skip() moves the reading position forward.

✔ available() tells us how many bytes can currently
  be read without blocking.

✔ close() closes the stream.

✔ FileInputStream does not automatically create
  a missing File.

✔ -1 from read() means End Of File.

══════════════════════════════════════════════════════════════════════════════
*/