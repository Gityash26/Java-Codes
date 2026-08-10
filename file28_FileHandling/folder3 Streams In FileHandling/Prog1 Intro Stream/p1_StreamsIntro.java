
/*
╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                   Streams in file handling                                   ║
╚══════════════════════════════════════════════════════════════════════════════╝

In the previous folder, we studied the File class.
Using File class, we learned how to

    • Create a File
    • Check whether a File exists
    • Get File information
    • Check File permissions
    • Create Directories
    • Rename a File
    • Delete a File


But there is one important thing that File class does NOT do.

It does NOT read or write the actual data inside the File.
For example,

        Student.txt
        ┌───────────────────────────────┐
        │ Hello Yash                    │
        │ Welcome to Java               │
        │ File Handling                 │
        └───────────────────────────────┘

File class can tell us

        ✔ File exists
        ✔ File name
        ✔ File path
        ✔ File size

But it cannot directly do

        ✘ Read "Hello Yash"
        ✘ Write "Welcome to Java"


This creates our next requirement.


════════════════════════════════════════════════════════════════════════════════
The Next Problem
════════════════════════════════════════════════════════════════════════════════

We now know HOW to identify and manage a File.

But we need a mechanism through which data can travel

        File  ───────────────►  Java Program

and

        Java Program  ───────►  File


This is where Streams come into the picture.


════════════════════════════════════════════════════════════════════════════════
What is a Stream ?
════════════════════════════════════════════════════════════════════════════════

A Stream is a mechanism through which data flows between a Java program and an external 
source or destination.

In File Handling,

        File
          │
          │  Data
          ▼
        Stream
          │
          ▼
    Java Program

    
The Stream provides a pathway through which data can be Read from or Written to a File.
    
════════════════════════════════════════════════════════════════════════════════
Why is it called a Stream ?
════════════════════════════════════════════════════════════════════════════════

Think about water flowing through a pipe.

        Water Tank
            │
            │
            ▼
        ╔══════════╗
        ║   Pipe   ║
        ╚══════════╝
            │
            ▼
           House


Data behaves similarly.

        File
          │
          ▼
       Stream
          │
          ▼
    Java Program


The data continuously flows through the Stream, just like water flows through a pipe.
This is the basic idea behind the name "Stream".


════════════════════════════════════════════════════════════════════════════════
Direction of Data Flow
════════════════════════════════════════════════════════════════════════════════
Data can flow in two directions.

1. Input
------------------------------------
        External Source
              │
              ▼
           Stream
              │
              ▼
        Java Program

This means Reading Data



──────────────────────────────────────────────────────────────────────────────

2. Output
--------------------------------------
        Java Program
              │
              ▼
           Stream
              │
              ▼
        External Destination

This means Writing Data



════════════════════════════════════════════════════════════════════════════════
Input and Output
════════════════════════════════════════════════════════════════════════════════

From the point of view of our Java program,

        Input = Data coming INTO the program
        Output = Data going OUT of the program


Therefore,

        File ─────────► Java Program
               Input


        Java Program─────────► File
          Output  



════════════════════════════════════════════════════════════════════════════════
Another Classification of Streams
════════════════════════════════════════════════════════════════════════════════

After deciding the direction of data flow, another question arises.

What type of data are we transferring?


A File may contain
                    Text , Images , Audio , Video , PDF , Binary Data

Java therefore provides two major types of Streams.


                         Streams
                            │
              ┌─────────────┴─────────────┐
              │                           │
              ▼                           ▼
      Character Streams              Byte Streams
              │                           │
              ▼                           ▼
        Character Data                Byte Data
              │                           │
              ▼                           ▼
          Text Files               Binary / Raw Data


════════════════════════════════════════════════════════════════════════════════
Character Streams
════════════════════════════════════════════════════════════════════════════════
Character Streams are designed to work with character-based data.
They are mainly used for Text.

Examples
            .txt , .java , .html , .xml , .csv , .json


The main classes are

        Reader
           │
           └── FileReader

        Writer
           │
           └── FileWriter


We will study these in the next section.


════════════════════════════════════════════════════════════════════════════════
Byte Streams
════════════════════════════════════════════════════════════════════════════════
Byte Streams work with raw byte data.

They are suitable for data such as

        • Images
        • Audio
        • Video
        • PDF
        • ZIP
        • Executable Files


The main classes are

        InputStream
             │
             └── FileInputStream

        OutputStream
             │
             └── FileOutputStream


We will study these after Character Streams.


════════════════════════════════════════════════════════════════════════════════
Complete Stream Classification
════════════════════════════════════════════════════════════════════════════════

                              Streams
                                 │
                    ┌────────────┴────────────┐
                    │                         │
                    ▼                         ▼
                  Input                    Output
                    │                         │
              ┌─────┴─────┐             ┌─────┴─────┐
              │           │             │           │
              ▼           ▼             ▼           ▼
         Character       Byte        Character     Byte
           Input         Input        Output       Output
             │             │             │           │
             ▼             ▼             ▼           ▼
        FileReader  FileInputStream  FileWriter   FileOutputStream


This gives us the basic File Handling roadmap.


════════════════════════════════════════════════════════════════════════════════
File Class vs Stream
════════════════════════════════════════════════════════════════════════════════

It is important not to confuse these two.

        File Class  :  Represents and manages the File itself.

        Stream      :  Transfers the actual data between the File and Java.



Example

        File f = new File("Student.txt");

        File object
              │
              └── identifies Student.txt


        FileReader reader = new FileReader(file);

        Reader
            │
            └─── reads data from Student.txt


════════════════════════════════════════════════════════════════════════════════
Our Learning Path
════════════════════════════════════════════════════════════════════════════════

We will now study Streams in this order:


        Streams
           │
           ├── Character Streams
           │      │
           │      ├── Reader
           │      ├── Writer
           │      ├── FileReader
           │      └── FileWriter
           │
           ├── Byte Streams
           │      │
           │      ├── InputStream
           │      ├── OutputStream
           │      ├── FileInputStream
           │      └── FileOutputStream
           │
           ├── Buffered Streams
           │
           └── Object Streams
                  │
                  └── Serialization


════════════════════════════════════════════════════════════════════════════════
Important Takeaways
════════════════════════════════════════════════════════════════════════════════

✔ File class represents and manages a File.

✔ File class does not read or write the actual contents.

✔ Streams provide the pathway for transferring data.

✔ Input means data coming into the Java program.

✔ Output means data going out of the Java program.

✔ Character Streams are mainly used for text data.

✔ Byte Streams are mainly used for raw/binary data.

✔ FileReader and FileWriter belong to Character Streams.

✔ FileInputStream and FileOutputStream belong to Byte Streams.

════════════════════════════════════════════════════════════════════════════════
*/
