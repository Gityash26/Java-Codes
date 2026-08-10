/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                   Introduction to Character Streams                          ║
╚══════════════════════════════════════════════════════════════════════════════╝

In the previous file, we learned that Streams provide a pathway through which data can move 
between Java program and an external resource.

We also classified Streams into

                            Streams
                               │
                ┌──────────────┴──────────────┐
                │                             │
                ▼                             ▼
        Character Streams               Byte Streams
                │                             │
                ▼                             ▼
           Character Data                  Byte Data


Now we will focus on

                    CHARACTER STREAMS


════════════════════════════════════════════════════════════════════════════════
What is a Character Stream?
════════════════════════════════════════════════════════════════════════════════

A Character Stream is a Stream designed to read and write character-based data.

It is mainly used for Text data.

Example

        Student.txt
        ┌───────────────────────────────┐
        │ Hello Yash                    │
        │ Welcome to Java               │
        │ File Handling                 │
        └───────────────────────────────┘

This type of data is character-based data.

Therefore,

        Character Stream
                │
                ▼
        Character / Text Data


════════════════════════════════════════════════════════════════════════════════
Why do we need Character Streams?
════════════════════════════════════════════════════════════════════════════════

Suppose Java needs to read a text file contains...

                     "Hello Java"


The data is made up of characters:

        H  e  l  l  o     J  a  v  a


Therefore, Java provides a Stream family specifically designed for character-based data.

This family is represented by

                    'Reader'   and    'Writer'


════════════════════════════════════════════════════════════════════════════════
Reader and Writer
════════════════════════════════════════════════════════════════════════════════
Java provides two important abstract classes for Character Streams.

        Reader:
                Used for reading character data.

        Writer:
                Used for writing character data.


Therefore,

                    Character Streams
                           │
                 ┌─────────┴─────────┐
                 │                   │
                 ▼                   ▼
              Reader              Writer
                 │                   │
                 │                   │
             Reading              Writing


════════════════════════════════════════════════════════════════════════════════
Reader
════════════════════════════════════════════════════════════════════════════════
Reader is an abstract class provided by Java.
Package : java.io

Declaration

        public abstract class Reader

Its responsibility is to define the general mechanism for reading character data.

It does NOT represent one particular source.

Different classes can extend Reader to read characters from different sources.


For example,

        Reader
           │
           ├── FileReader
           │
           └── Other Reader classes


When our source is a File,
we use
        FileReader


════════════════════════════════════════════════════════════════════════════════
Writer
════════════════════════════════════════════════════════════════════════════════
Writer is an abstract class provided by Java.

Package
        java.io

Declaration
        public abstract class Writer

Its responsibility is to define the general mechanism for writing character data.
Different classes can extend Writer for different destinations.


For example,

        Writer
           │
           ├── FileWriter
           │
           └── Other Writer classes


When our destination is a File,
we use

        FileWriter


════════════════════════════════════════════════════════════════════════════════
Complete Character Stream Hierarchy
════════════════════════════════════════════════════════════════════════════════


                         Character Streams
                                │
                   ┌────────────┴────────────┐
                   │                         │
                   ▼                         ▼
                Reader                    Writer
                   │                         │
                   │                         │
              Reading                    Writing
                   │                         │
                   ▼                         ▼
              FileReader                 FileWriter
                   │                         │
                   ▼                         ▼
              Reads from                 Writes to
                 File                       File


So remember:

        Reader
            ↓
        General Character Reading

        Writer
            ↓
        General Character Writing

        FileReader
            ↓
        Character Reading from File

        FileWriter
            ↓
        Character Writing to File


════════════════════════════════════════════════════════════════════════════════
Why FileReader instead of Reader?
════════════════════════════════════════════════════════════════════════════════

Reader is abstract.

Therefore, we cannot directly create its object.

We cannot normally write

        Reader r = new Reader();


Instead, we use a concrete subclass according to the source of our data.

For a File,

        FileReader reader = new FileReader("Student.txt");


Similarly,

        Writer writer = new FileWriter("Student.txt");


The relationship is

        Reader
          ▲
          │ extends
          │
     FileReader


        Writer
          ▲
          │ extends
          │
     FileWriter


════════════════════════════════════════════════════════════════════════════════
File Class vs FileReader
════════════════════════════════════════════════════════════════════════════════

These two classes have completely different responsibilities.


        File
         │
         └── Represents the File


        FileReader
         │
         └── Reads characters from the File


Example
        File f = new File("Student.txt");

Here,
        File
          ↓
        "Which file?"


Then,
        FileReader reader = new FileReader(file);

Here,

        FileReader
             ↓
"Read the characters from this file."


Visual

        ┌──────────────────────┐
        │     Student.txt      │
        │                      │
        │    Hello Java        │
        │    Welcome           │
        └──────────┬───────────┘
                   │
                   │ Characters
                   ▼
             ┌───────────┐
             │ FileReader│
             └─────┬─────┘
                   │
                   ▼
             Java Program


════════════════════════════════════════════════════════════════════════════════
Character Stream Reading vs Writing
════════════════════════════════════════════════════════════════════════════════

Reading

        File
         │
         │ Characters
         ▼
     FileReader
         │
         ▼
    Java Program


Writing

    Java Program
         │
         ▼
     FileWriter
         │
         │ Characters
         ▼
        File


Therefore,

        FileReader → File → Java

        FileWriter → Java → File


════════════════════════════════════════════════════════════════════════════════
Important Takeaways
════════════════════════════════════════════════════════════════════════════════

✔ Character Streams are designed for character/text data.

✔ Reader is an abstract class for character reading.

✔ Writer is an abstract class for character writing.

✔ FileReader reads character data from a File.

✔ FileWriter writes character data to a File.

✔ Reader and Writer belong to java.io.

✔ FileReader extends Reader.

✔ FileWriter extends Writer.

✔ File class represents the File itself.

✔ FileReader/FileWriter are responsible for transferring
  character data.

════════════════════════════════════════════════════════════════════════════════
Next
════════════════════════════════════════════════════════════════════════════════

Now the concept is clear:

        File
         │
         ▼
    FileReader
         │
         ▼
    Java Program

So the next question is:

        "How exactly does FileReader read
         characters from a File?"

That will be demonstrated practically
in the next file.


════════════════════════════════════════════════════════════════════════════════

                    FILE HANDLING
                        │
                        ▼
                    File Class
                        │
             "Which file / location?"
                        │
                        ▼
                      Stream
                        │
              "How does data move?"
                        │
             ┌──────────┴───────────┐
             │                      │
             ▼                      ▼
           Input                  Output
             │                      │
             ▼                      ▼
       Data → Java              Java → Data
             │                      │
             └──────────┬───────────┘
                        │
                  What kind of data?
                        │
              ┌─────────┴──────────┐
              │                    │
              ▼                    ▼
         Character               Byte
           Stream               Stream
              │                    │
        ┌─────┴─────┐         ┌────┴─────┐
        ▼           ▼         ▼          ▼
     Reader       Writer   InputStream OutputStream
        │           │
        ▼           ▼
   FileReader   FileWriter
*/