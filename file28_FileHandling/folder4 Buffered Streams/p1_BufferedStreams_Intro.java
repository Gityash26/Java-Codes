/*
╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                         Buffered Streams                                     ║
╚══════════════════════════════════════════════════════════════════════════════╝

                 STREAMS
                    │
          ┌─────────┴─────────┐
          │                   │
          ▼                   ▼
    CHARACTER STREAMS      BYTE STREAMS
          │                   │
          ▼                   ▼
     Reader / Writer      InputStream / OutputStream
                              │
                    ┌─────────┴─────────┐
                    ▼                   ▼
          FileInputStream       FileOutputStream
                    │                   │
                    ▼                   ▼
        BufferedInputStream   BufferedOutputStream

        
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==
1. WHAT PROBLEM ARE WE SOLVING?
═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=═=══==

So far, we learned how Java reads and writes files using streams.

For example:

        java --------- (FileInputStream) --------> File
and
        java <-------- (FileInputStream) -------- File


These streams work correctly.

But file operations involve communication between the Java program and the underlying 
operating system / storage.

If a program performs many small I/O operations, repeatedly accessing the underlying 
stream can be inefficient.

So we need an intermediate memory area where data can be temporarily
kept and transferred in larger blocks.

That temporary memory area is called a:

                                        BUFFER


════════════════════════════════════════════════════════════════════════════════
2. WHAT IS A BUFFER?
════════════════════════════════════════════════════════════════════════════════

A buffer is a temporary area in memory used to hold data while it is being transferred 
between the program and a file.

For example:

        File
         │
         ▼
    ┌───────────────┐
    │    BUFFER     │
    │ A B C D E ... │
    └───────┬───────┘
            │
            ▼
         Program


Instead of constantly dealing with the file directly, data can first be collected inside 
the buffer.

The program can then read from or write to this memory area.


════════════════════════════════════════════════════════════════════════════════
3. WHY DID JAVA INTRODUCE BUFFERED STREAMS?
════════════════════════════════════════════════════════════════════════════════

We already have:

        FileInputStream
        FileOutputStream

So why do we need another class?

Because these streams provide the basic connection with the file,
while Buffered Streams provide an additional buffering layer.

The idea is:

          Direct I/O
            ↓
  ═════════════════════════════
        File Stream
  ═════════════════════════════
            ↓
           File


------- can become -------------

        Program
            ↓  
  ═════════════════════════════
        Buffered Stream                <----- extra layer
  ═════════════════════════════
            ↓
  ═════════════════════════════
        File Stream
  ═════════════════════════════
            ↓
           File



The Buffered Stream keeps data in memory temporarily and reduces the need for frequent 
interaction with the underlying file stream.


════════════════════════════════════════════════════════════════════════════════
 --------------               BUFFERED STREAMS?          ------------------------
════════════════════════════════════════════════════════════════════════════════

The Buffered Streams are Java classes that add a buffer between the program and an 
existing input/output stream.

Java provides two important byte-based buffered stream classes:

 
                    Buffered Streams
                           │
             ┌─────────────┴─────────────┐
             ▼                           ▼
   BufferedInputStream         BufferedOutputStream
    (used for Reading)          (used for Writing)


Both belong to: java.io


════════════════════════════════════════════════════════════════════════════════
 BUFFERED STREAMS do not replace FileInputStreams
════════════════════════════════════════════════════════════════════════════════
This is very important.
BufferedInputStream does not directly replace FileInputStream.

Instead, it wraps it.

      File
        ↓
       FileInputStream
                    ↓
                BufferedInputStream
                            ↓
                            Program


Similarly:

      Program
        ↓
        BufferedOutputStream
                        ↓
                FileOutputStream
                            ↓
                            File


Therefore:

    -----------------------------------------------
        FileInputStream + BufferedInputStream
    ══════════════════════════════════════════════
                        ↓
    -----------------------------------------------
                Buffered reading
    ══════════════════════════════════════════════


    -----------------------------------------------
        FileOutputStream + BufferedOutputStream
    ══════════════════════════════════════════════
                        ↓
    -----------------------------------------------
                Buffered writing
    ══════════════════════════════════════════════


════════════════════════════════════════════════════════════════════════════════
WHAT DOES "WRAP" MEAN HERE?
════════════════════════════════════════════════════════════════════════════════

When we create a BufferedInputStream, we provide another InputStream
to its constructor.

Example:

        FileInputStream fs = new FileInputStream("Student.txt");

        BufferedInputStream bs = new BufferedInputStream(fs);


Relationship:

        bs
        │
        │ wraps
        ▼
        fs
        │
        ▼
       File


The BufferedInputStream uses the FileInputStream underneath it.

So data still ultimately comes from the FileInputStream,
but BufferedInputStream manages an internal buffer while reading it.


════════════════════════════════════════════════════════════════════════════════
7. BUFFERED INPUT STREAM
════════════════════════════════════════════════════════════════════════════════

BufferedInputStream is used when we want to READ byte data through a buffer.

Basic structure:

        File
        │
        ▼
 FileInputStream
        │
        ▼
BufferedInputStream
         │
         ▼
      Program


Example:

        FileInputStream fis = new FileInputStream("Student.txt");

        BufferedInputStream bis = new BufferedInputStream(fis);


The important idea is:

        FileInputStream
        → provides connection to the file

        BufferedInputStream
        → adds buffering to the reading process


════════════════════════════════════════════════════════════════════════════════
8. BUFFERED OUTPUT STREAM
════════════════════════════════════════════════════════════════════════════════

BufferedOutputStream is used when we want to WRITE byte data through a buffer.

Basic structure:

      Program
        │
        ▼
BufferedOutputStream
        │
        ▼
 FileOutputStream
        │
        ▼
        File


Example:

        FileOutputStream fos = new FileOutputStream("Student.txt");

        BufferedOutputStream bos = new BufferedOutputStream(fos);


Here:

        FileOutputStream
        → provides connection to the file

        BufferedOutputStream
        → adds buffering to the writing process


════════════════════════════════════════════════════════════════════════════════
9. BUFFERED STREAMS VS FILE STREAMS
════════════════════════════════════════════════════════════════════════════════

┌──────────────────────────┬───────────────────────────────────────────────┐
│ FileInputStream          │ Reads byte data directly through the stream. │
├──────────────────────────┼───────────────────────────────────────────────┤
│ BufferedInputStream      │ Adds buffering to input operations.          │
├──────────────────────────┼───────────────────────────────────────────────┤
│ FileOutputStream         │ Writes byte data directly through the stream.│
├──────────────────────────┼───────────────────────────────────────────────┤
│ BufferedOutputStream     │ Adds buffering to output operations.         │
└──────────────────────────┴───────────────────────────────────────────────┘


The important relationship:

        Buffered Stream
              │
              ▼
        wraps another stream
              │
              ▼
        underlying stream


════════════════════════════════════════════════════════════════════════════════
10. WHERE DOES BUFFERING HAPPEN?
════════════════════════════════════════════════════════════════════════════════

The buffer is maintained in memory.

For reading:

        File
        │
        ▼
 FileInputStream
        │
        ▼
 ┌─────────────────────┐
 │ BufferedInputStream │
 │                     │
 │   Internal Buffer   │
 │  ┌───────────────┐  │
 │  │ bytes ...     │  │
 │  └───────────────┘  │
 └──────────┬──────────┘
            │
            ▼
         Program


For writing:

         Program
            │
            ▼
 ┌──────────────────────┐
 │ BufferedOutputStream │
 │                      │
 │   Internal Buffer    │
 │  ┌────────────────┐  │
 │  │ bytes ...      │  │
 │  └────────────────┘  │
 └──────────┬───────────┘
            │
            ▼
    FileOutputStream
            │
            ▼
           File


The buffered classes manage this internal buffer for us.


════════════════════════════════════════════════════════════════════════════════
11. OUR LEARNING PLAN
════════════════════════════════════════════════════════════════════════════════

                    Buffered Streams
                           │
             ┌─────────────┴─────────────┐
             ▼                           ▼
   BufferedInputStream         BufferedOutputStream
             │                           │
             ▼                           ▼
          READING                     WRITING
             │                           │
             ▼                           ▼
       Constructors                Constructors
             │                           │
             ▼                           ▼
          Methods                     Methods
             │                           │
             └─────────────┬─────────────┘
                           ▼
                    Practical Programs
                           │
                           ▼
                 Final Comparison


════════════════════════════════════════════════════════════════════════════════
KEY IDEA TO REMEMBER
════════════════════════════════════════════════════════════════════════════════

FileInputStream / FileOutputStream
        ↓
Basic byte-level file I/O


BufferedInputStream / BufferedOutputStream
        ↓
Add a memory buffer around the underlying stream


Therefore:

        BufferedInputStream
                ↓
        FileInputStream
                ↓
              File


        BufferedOutputStream
                ↓
        FileOutputStream
                ↓
              File


The next file will focus completely on:

        BufferedInputStream

We will learn its definition, class relationship,
constructors, important methods, and finally use it
in a program.

════════════════════════════════════════════════════════════════════════════════
*/