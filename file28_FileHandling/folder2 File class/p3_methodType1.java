
/*
╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                     working with FileClass                                  ║
╚═════════════════════════════════════════════════════════════════════════════╝

════════════════════════════════════════════════════════════════════════════════
Introduction
════════════════════════════════════════════════════════════════════════════════

In the previous file, we understood

    • What File class is.
        
    • Why Java introduced it.

    • Why a File object is required before performing
      any Read or Write operation.

Now it's time to create File objects and start using the methods provided by the File class.


════════════════════════════════════════════════════════════════════════════════
-------------            Creating File Object                  -----------------
════════════════════════════════════════════════════════════════════════════════

Like every other Java class, the File class also requires an object before we can use its methods.

General Syntax
        File referenceVariable = new File(path);

Example
        File f = new File("Student.txt");


Important Observation
──────────────────────────────────────────────────────────────────────────────

Creating a File object DOES NOT create the actual file.
It only creates a Java object that represents the file.

                        File file
                             │
                             ▼
                       "Student.txt"

Even if Student.txt does not exist, the File object is still created successfully.

The actual file will only be created when we explicitly call

                createNewFile()




═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
----------------        Constructors of file class            ------------------
════════════════════════════════════════════════════════════════════════════════

Suppose the following directory structure exists

D:\
 └── Notes
      └── Student.txt


──────────────────────────────────────────────────────────────────────────────
1. File(String path)
──────────────────────────────────────────────────────────────────────────────
This constructor creates a File object by providing the complete path of the file as a String.
Use this constructor when the complete path is already known.

Example

        File f = new File("D:\\Notes\\Student.txt");




──────────────────────────────────────────────────────────────────────────────
2. File(File parent, String child)
──────────────────────────────────────────────────────────────────────────────
This constructor accepts

        Parent Directory  → File Object
        Child             → File Name

Example
        File folder = new File("D:\\Notes");
        File file = new File(folder, "Student.txt");


Internally Java combines

        folder + "Student.txt"

to represent
                D:\Notes\Student.txt


This constructor becomes useful when we already have a Folder object and want to work with multiple files
inside that folder.


Example

        File Folder = new File("D:\\Projects");

        File log     = new File(Folder, "log.txt");
        File users   = new File(Folder, "users.txt");
        File config  = new File(Folder, "config.txt");


──────────────────────────────────────────────────────────────────────────────
3. File(String parent, String child)
──────────────────────────────────────────────────────────────────────────────
This constructor accepts

        Parent Directory → String
        Child File       → String

Example
        File f = new File("D:\\Notes", "Student.txt");


Internally Java combines
                "D:\\Notes"  +  "Student.txt"

to represent
                D:\Notes\Student.txt


Use this constructor when both Parent Path and Child Name are available separately as Strings.





═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
----------------        Methods of file class            ------------------
════════════════════════════════════════════════════════════════════════════════


                           File Class
                               │
        ┌──────────────────────┼───────────────────────┐
        ▼                      ▼                       ▼
   Creation               Checking              Information
-------------           -------------          ----------------
createNewFile()           exists()              getName()
mkdir()                   isFile()              getPath()
mkdirs()                  isDirectory()         getAbsolutePath()
                          canRead()             length()
                          canWrite()
                          canExecute()
                               │
                               ▼
                       ----------------
                        Modification
                       ----------------
                        renameTo()
                        delete()


We will learn these methods category by category.

In this file, we begin with

                    Creation Methods.


                    


═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═
------(1) -----    C R E A T I O N     M E T H O D S    --------------------
═════════════════════════════════════════════════════════════════════════════════


1. createNewFile()
──────────────────────────────────────────────────────────────────────────────
        This method physically creates a new file inside the Operating System.

Return Type boolean

        true   : File created successfully.
        false  :  File already exists.

throws
        IOException


──────────────────────────────────────────────────────────────────────────────
2. mkdir()
──────────────────────────────────────────────────────────────────────────────
Creates only ONE directory.
If the parent directory does not exist, the directory will NOT be created.

Example

        File folder = new File("D:\\Java");
        folder.mkdir();


──────────────────────────────────────────────────────────────────────────────
mkdirs()
──────────────────────────────────────────────────────────────────────────────
Creates multiple directories together.
If parent folders are missing, Java automatically creates them.

Example
        File folder = new File("D:\\Projects\\Java\\Notes");
        folder.mkdirs();


Difference

        mkdir()  :  Creates only one folder.
        mkdirs() :  Creates complete folder hierarchy.


════════════════════════════════════════════════════════════════════════════════
Program Demonstration
════════════════════════════════════════════════════════════════════════════════
*/

import java.io.File;
import java.io.IOException;

public class p3_methodType1
{
    public static void main(String[] args)
    {
        try
        {
        //  creates a new file object 
            File f = new File("DemoFile.txt");


        //  -------------  creating a actual file -----------------------

            if(f.createNewFile())
            {
                System.out.println("✔ File Created Successfully.");
            }
            else
            {
                System.out.println("✔ File Already Exists.");
            }


        //  -------------  creating a actual directory -----------------------

            File folder1 = new File("DemoFolder");

            if(folder1.mkdir())
            {
                System.out.println("✔ Folder Created.");
            }


        //  -------------  creating a actual directory hierarchy -----------------------

            File folder2 = new File("MyProject/SubProject/Project");

            if(folder2.mkdirs())
            {
                System.out.println("✔ Complete Folder Structure Created.");
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
