/*

╔══════════════════════════════════════════════════════════════════════════════╗
║                     Writing data using FileWriter                            ║
╚══════════════════════════════════════════════════════════════════════════════╝


═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
FileWriter
════════════════════════════════════════════════════════════════════════════════
FileWriter is a concrete class used to write character data into a File.

Note: 
    => If file not exists FileWriter automatically creates a new actual file 
    => If it exists by default FileWriter Override the previous content 
    => If Override (status=true), simple appends after existing data  

Package
        java.io

Hierarchy

        Writer
           │
           └── FileWriter


FileWriter provides a connection between

        Java Program
              │
              ▼
         FileWriter
              │
              ▼
             File


════════════════════════════════════════════════════════════════════════════════
----------------               Constructors                      ---------------
════════════════════════════════════════════════════════════════════════════════

~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
(1) FileWriter(String fileName)
──────────────────────────────────────────────────────────────────────────────

Creates a FileWriter object using the File path.

Example
        FileWriter writer = new FileWriter("Student.txt");



~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
(2) FileWriter(File f)
──────────────────────────────────────────────────────────────────────────────

Creates a FileWriter object using an existing File object.

Example
        File f = new File("Student.txt");

        FileWriter writer = new FileWriter(f);



~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
(3) FileWriter(String fileName, boolean append)
──────────────────────────────────────────────────────────────────────────────

Creates a FileWriter object and allows us to decide whether existing data should be 
overwritten or preserved.

append = false
            ↓
        Overwrite existing content

append = true
            ↓
        Add new content after existing content


Example
        FileWriter writer = new FileWriter("Student.txt", true);





════════════════════════════════════════════════════════════════════════════════
-----------------                 METHODS                  ---------------------
════════════════════════════════════════════════════════════════════════════════

──────────────────────────────────────────────────────────────────────────────
(1) write(String str)
──────────────────────────────────────────────────────────────────────────────
This method writes the given String into the File.
It retrun void 

Example
        writer.write("Hello Java");
                        │
                        │
                     "Hello Java" ────────> FILE 


Important
    The data is written as character data.


Example ------------------------------------------------------
        writer.write(String);

            writer.write("Welcome to Java");

Example ------------------------------------------------------
        writer.write("50000");

            return as '5' '0' '0' '0' '0'




──────────────────────────────────────────────────────────────────────────────
(2) write(int ch)
──────────────────────────────────────────────────────────────────────────────
Writes a single character into the File.

The method accepts an int, but the value represents a character.

Example
        writer.write('A');

Example
        writer.write('H');
        writer.write('i');

File content
                Hi


Syntax
        writer.write(int);


Important

        writer.write(65);

writes the character represented by 65, --------> A
because 65 is the character code for 'A'.


──────────────────────────────────────────────────────────────────────────────
(3) write(char[] data)
──────────────────────────────────────────────────────────────────────────────

Writes an entire character array into the File.

syntax:
        writer.write(char[]);


Example

        char[] data = {'J', 'a', 'v', 'a'};
        writer.write(data);


File content -----> Java





──────────────────────────────────────────────────────────────────────────────
(4) flush()
──────────────────────────────────────────────────────────────────────────────

Ensures that any data currently waiting in the Writer's buffer is sent to its destination.

In simple words:

        flush()
             ↓
            "Send the pending data now."


Syntax
        writer.flush();


Important
        flush() does NOT close the Writer.
        After flush(), we can continue writing.


        write()
           ↓
        flush()
           ↓
        write()
           ↓
        close()



════════════════════════════════════════════════════════════════════════════════
Overwrite vs Append
════════════════════════════════════════════════════════════════════════════════

By default:

        new FileWriter("Student.txt")

works in overwrite mode.

Suppose the File already contains:
                                            Hello

Then
        writer.write("Java");

Result:
        Java

The old content is replaced.


════════════════════════════════════════════════════════════════════════════════
Complete Program
════════════════════════════════════════════════════════════════════════════════
*/

import java.io.FileWriter;
import java.io.File;

public class p3_FileWriter
{
    public static void main(String[] args)
    {
        try
        {
            // ----------- creating a file object ------------------
            File f = new File("file28_FileHandling\\folder3 Streams In FileHandling\\Prog2 Character Streams\\Student.txt");

            // ----------- writing in the file ------------------
            FileWriter writer = new FileWriter(f, true);

            // write (char) 
            writer.write(65);

            // write character 
            writer.write('Y');

            // write String  
            writer.write(" Hello Yash ");

            // write char array  
            char[] array = {'A', 'P', 'P', 'L', 'E'};
            writer.write(array);

            // flush the data 
            writer.flush();

            // close the FileWriter
            writer.close();

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
Program Flow
════════════════════════════════════════════════════════════════════════════════

        FileWriter Object
                │
                ▼
            write()
                │
                ▼
        Character Data
                │
                ▼
             flush()
                │
                ▼
             File
                │
                ▼
             close()


════════════════════════════════════════════════════════════════════════════════
Important Takeaways
════════════════════════════════════════════════════════════════════════════════

FileWriter
    → Writes character data into a File.

write()
    → Writes character data.

flush()
    → Sends pending data to the destination.

close()
    → Closes the Writer and releases resources.

append = false
    → Existing content is overwritten.

append = true
    → New content is added after existing content.

══════════════════════════════════════════════════════════════════════════════
*/