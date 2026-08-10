

/*
╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                               File Class                                     ║
╚══════════════════════════════════════════════════════════════════════════════╝

File is a predefined class available in the java.io package.

It is used to represent a File or a Directory (Folder) inside a Java program.

When we create an object of the File class, Java does NOT load the contents of that file 
into memory. Instead, the object simply represents that particular file and provides useful 
information about it.

For example, a File object can tell us

        • Does the file exist ?
        • Where is it located ?
        • Is it a File or a Directory ?
        • Can it be Read or Written ?
        • What is its Size ?

Notice that all these operations are related to the File itself,
not to the data stored inside the file.

Since File class belongs to the java.io package, we must import it before using it.

        import java.io.File;


════════════════════════════════════════════════════════════════════════════════
Understanding File Class through OOP
════════════════════════════════════════════════════════════════════════════════

Everything in Java is represented using Objects.

For example,

        Employee Class
                │
                ▼
        Employee Object

represents one Employee.
Similarly,

        File Class
                │
                ▼
        File Object

represents one File or one Directory.

Just as an Employee object represents an Employee, a File object represents a File.
It does NOT become the actual file.


════════════════════════════════════════════════════════════════════════════════
Why was File Class introduced ?
════════════════════════════════════════════════════════════════════════════════

Suppose we want to read a file named

        student.txt

Before Java starts reading the data, it first needs some basic information.

        • Does student.txt actually exist ?
        • Is it a normal file or a folder ?
        • Does the program have permission to read it ?
        • Where is it stored ?

Without knowing these details, Java cannot safely perform any Read or Write operation.

To solve this problem, Java introduced the File class.



════════════════════════════════════════════════════════════════════════════════
Internal Working
════════════════════════════════════════════════════════════════════════════════

                    Java Program
                           │
                           ▼
                     File Object
                           │
                           ▼
                  Operating System
                           │
                           ▼
                   Hard Disk / SSD


The File object simply acts as a bridge between the Java Program
and the Operating System.

Whenever we ask

        exists()
        length()
        canRead()

Java requests the Operating System, and the Operating System returns the required information.


════════════════════════════════════════════════════════════════════════════════
What can File Class do ?
════════════════════════════════════════════════════════════════════════════════

File class mainly performs File Management operations.

Examples include

        ✔ Create a File
        ✔ Delete a File
        ✔ Rename a File
        ✔ Check whether File exists
        ✔ Check File permissions
        ✔ Get File name
        ✔ Get File path
        ✔ Get File size

These operations help Java manage files before actually reading or writing data.



════════════════════════════════════════════════════════════════════════════════
Important Observation
════════════════════════════════════════════════════════════════════════════════

The File class never reads or writes data.

Its responsibility is only to represent a File and manage its information.

Reading and Writing are performed later by

        FileReader
        FileWriter
        FileInputStream
        FileOutputStream

and other Stream classes.


════════════════════════════════════════════════════════════════════════════════
Industry Usage
════════════════════════════════════════════════════════════════════════════════

Before accessing any file, almost every Java application first creates a File object.

Examples

        • Reading Configuration Files
        • Uploading Images
        • Creating Log Files
        • Reading CSV Files
        • Generating PDF Reports

This is why File class becomes the entry point of almost every File Handling operation.

════════════════════════════════════════════════════════════════════════════════
*/