/*
╭──────────────────────────────────────────────────────────────╮
│                  Topic - Random Access File                  │
╰──────────────────────────────────────────────────────────────╯

═══════════════════════════════════════════════════════════════
1. The Idea Behind Random Access
═══════════════════════════════════════════════════════════════

Till now, while working with files, we mostly accessed data sequentially.
That means we move through the data in order.


        Sequential Access
        ┌────────┐     ┌────────┐     ┌────────┐     ┌────────┐
        │ Data 1 │ ──► │ Data 2 │ ──► │ Data 3 │ ──► │ Data 4 │
        └────────┘     └────────┘     └────────┘     └────────┘


Suppose we only need Data 4.

With sequential access, we normally move through:

        Data 1  ──►  Data 2  ──►  Data 3  ──►  Data 4
                                                    ▲
                                                    │
                                                 Required


This becomes inefficient when we already know the position of the data 
we need.

Instead of moving through all previous data, we want to directly move to 
the required position.

This is the basic idea of Random Access.


        Random Access
        ┌────────┐     ┌────────┐     ┌────────┐     ┌────────┐
        │ Data 1 │     │ Data 2 │     │ Data 3 │     │ Data 4 │
        └────────┘     └────────┘     └────────┘     └────────┘
                                                        ▲
                                                        │
                        Directly move ──────────────────┘


So:

        Sequential Access
                → Access data in sequence

        Random Access
                → Directly move to the required position


⚠ Remember:

"Random" does NOT mean that the data itself is random.

It means that we can choose the position from where we want to access the data.



═══════════════════════════════════════════════════════════════
--------------  Random Access in Java     ---------------------
═══════════════════════════════════════════════════════════════

Java provides a class called RandomAccessFile in the java.io package 
for performing random access on files.

It allows us to read and write data at different positions by controlling 
the file pointer.


                         RandomAccessFile
                                │
                ┌───────────────┼───────────────┐
                ▼               ▼               ▼
              Read            Write        Move Position


The important idea is:  

        File
         │
         ▼
    File Pointer
         │
         ▼
    Read / Write
    from this position


So instead of always working from the beginning of the file,
we can move the file pointer to a required position and perform the operation there.



═══════════════════════════════════════════════════════════════
------------  Constructors of Random Access Class ------------
═══════════════════════════════════════════════════════════════


───────────────────────────────────────────────────────────────
1. RandomAccessFile(String fileName, String mode)
───────────────────────────────────────────────────────────────

Syntax:
        RandomAccessFile file = new RandomAccessFile("data.txt", "rw");


Here:

        "data.txt"  --->   File name / path

              "rw"  --->   Access mode


So this constructor tells Java:

        "Open this file using this access mode."


───────────────────────────────────────────────────────────────
2. RandomAccessFile(File file, String mode)
───────────────────────────────────────────────────────────────

Syntax:

        File f = new File("data.txt");

        RandomAccessFile file = new RandomAccessFile(f, "rw");


Here, instead of directly passing the file name,
we pass an already created File object.



═══════════════════════════════════════════════════════════════
------------     Access Modes           -----------------------
═══════════════════════════════════════════════════════════════

The second constructor argument specifies how the file can be accessed.

        ╔══════════╦══════════════════════════════════════════╗
        ║ Mode     ║ Meaning                                  ║
        ╠══════════╬══════════════════════════════════════════╣
        ║ "r"      ║ Read only                                ║
        ║ "rw"     ║ Read + Write                             ║
        ╚══════════╩══════════════════════════════════════════╝


"r"
 │
 └────► Reading allowed
        Writing NOT allowed

Also, the file must already exist in "r" mode.


"rw"
 │
 ├────► Reading allowed
 └────► Writing allowed

If the file does not exist, Java creates the file.



═══════════════════════════════════════════════════════════════
----------------    File Pointer         ----------------------
═══════════════════════════════════════════════════════════════

RandomAccessFile works around an important concept called the File Pointer.

The file pointer represents the position from where the next read or write 
operation will take place.


        File
        ┌────┬────┬────┬────┬────┬────┐
        │ A  │ B  │ C  │ D  │ E  │ F  │
        └────┴────┴────┴────┴────┴────┘
          ▲
          │
       Pointer
       position = 0


When a RandomAccessFile object is newly opened, the file pointer starts at position 0.

As data is read or written, the pointer normally moves forward according to the amount of 
data processed.

This pointer is what allows RandomAccessFile to perform Random Access.



═══════════════════════════════════════════════════════════════
 Important Methods
═══════════════════════════════════════════════════════════════

───────────────────────────────────────────────────────────────
1. seek(long position)
───────────────────────────────────────────────────────────────

Moves the file pointer to the specified position.

Syntax:
        file.seek(10);


Meaning:

        Current Position
               │
               └──────────────► Position 10




───────────────────────────────────────────────────────────────
2. getFilePointer()
───────────────────────────────────────────────────────────────

Returns the current position of the file pointer.

Syntax:
        long position = file.getFilePointer();


Example:

        file.seek(10);
        long position = file.getFilePointer();


        position
            ↓
           10


So:

        seek()    ------→ Moves the pointer

        getFilePointer()   ---- → Tells the current pointer position



═══════════════════════════════════════════════════════════════
Implementation
═══════════════════════════════════════════════════════════════

This program only demonstrates:

        ✓ Creating a RandomAccessFile object
        ✓ Using "rw" access mode
        ✓ Checking the initial pointer position
        ✓ Moving the pointer using seek()
        ✓ Checking the new position


*/

import java.io.RandomAccessFile;

public class p1_IntroToRandomAccessFile
{
    public static void main(String[] args) throws Exception 
    {
        RandomAccessFile file = new RandomAccessFile("data.txt", "rw");

        System.out.println("Initial position: " + file.getFilePointer());

        file.seek(5);

        System.out.println("After seek(5): " + file.getFilePointer());

        file.close();
    }
}