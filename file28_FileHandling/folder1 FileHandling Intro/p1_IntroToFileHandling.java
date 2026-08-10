

/*
╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                          FILE HANDLING IN JAVA                               ║
╚══════════════════════════════════════════════════════════════════════════════╝

"Data stored in RAM disappears when the program ends.
 File Handling allows Java to store data permanently."

════════════════════════════════════════════════════════════════════════════════
 1. WHY WAS FILE HANDLING INTRODUCED ?
════════════════════════════════════════════════════════════════════════════════

Imagine we build a Student Management Software.

    Java Program
   --------------------
        Student
        Student
        Student
              │
              ▼
        ArrayList<Student>

Everything works perfectly...
But the moment the program closes,

                ---------> Everything disappears.

Reason ?
    Because all the data was stored inside 'RAM'

RAM is a Temporary Memory.
Whenever
        ✔ Program Ends
        ✔ Computer Restarts
        ✔ Power Failure

all the data stored in RAM gets erased.


So developers wanted

        "A place where data remains even after the program is closed."


Java introduced 'File Handling'


════════════════════════════════════════════════════════════════════════════════
----------- REAL LIFE EXAMPLE ---------------------------------
════════════════════════════════════════════════════════════════════════════════

Think about your Computer.

You have
            Resume.pdf
            Photo.jpg
            Music.mp3
            Movie.mp4
            Excel.xlsx
            Notes.txt

Even after shutting down the computer, all these files still exist.

Why ?
Because they are stored inside      ✔ Hard Disk     ✔ SSD
which are Permanent Storage Devices.

Java provides File Handling APIs to communicate with these files.


════════════════════════════════════════════════════════════════════════════════
-----------  WHAT IS FILE HANDLING ? ---------------------------
════════════════════════════════════════════════════════════════════════════════

The File Handling is the process of

        ✔ Creating Files
        ✔ Reading Data
        ✔ Writing Data
        ✔ Updating Data
        ✔ Deleting Files

using Java.


════════════════════════════════════════════════════════════════════════════════
 VISUALIZATION
════════════════════════════════════════════════════════════════════════════════

Without File Handling

                Java Program
                       │
                       ▼
                     RAM
                       │
                Program Ends
                       │
                       ▼
                  ❌ Data Lost


With File Handling

                Java Program
                       │
                       ▼
              File Handling API
                       │
                       ▼
               Hard Disk / SSD
                       │
                       ▼
               ✔ Data Saved Forever


════════════════════════════════════════════════════════════════════════════════
 WHERE DO COMPANIES USE FILE HANDLING ?
════════════════════════════════════════════════════════════════════════════════

 Banking Systems
        → Transaction Reports
        → Account Statements


 Amazon / Flipkart
        → Invoice PDF
        → Product Images


 Hospital Software
        → Patient Reports
        → X-Ray Images


 Spring Boot Applications
        → application.properties
        → application.yml
        → Log Files


 WhatsApp
        → Images
        → Videos
        → Voice Notes


════════════════════════════════════════════════════════════════════════════════
⚠ IMPORTANT OBSERVATION
════════════════════════════════════════════════════════════════════════════════

Java does NOT directly communicate with SSD Hard Disk

Instead,

                Java Program
                       │
                       ▼
                File Handling API
                       │
                       ▼
              Operating System
                       │
                       ▼
               Hard Disk / SSD


The Operating System finally performs the actual Read / Write operation.


════════════════════════════════════════════════════════════════════════════════
🗂 FILE HANDLING ROADMAP
════════════════════════════════════════════════════════════════════════════════

File Handling
        │
        ├──> File Class
        │       (Create / Delete / Rename / Check File)
        │
        ├──> Character Streams
        │       (Text Files)
        │
        ├──> Byte Streams
        │       (Images / PDF / Audio / Video)
        │
        ├──> Object Serialization
        │
        └──> Modern NIO API
                (Files & Path)


════════════════════════════════════════════════════════════════════════════════
=========== ONE QUESTION... ===================
════════════════════════════════════════════════════════════════════════════════

If Java can already Read and Write files, then why does it provide

        Character Streams and Byte Streams separately ?

We'll answer this in the upcoming files.


════════════════════════════════════════════════════════════════════════════════
*/