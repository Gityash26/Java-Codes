
/*


                                        File Class
                                            │
        ┌──────────────────────┼───────────────────────┼───────────────────────────┐
        ▼                      ▼                       ▼                           ▼   
  (1) Creation            (2) Checking            (3) Information         (4) Modification 
╔═════════════════╗    ╔═════════════════╗     ╔════════════════════╗    ╔════════════════════╗                        
│    ----------   │    │  exists()       │     │  getName()         │    │                    │
│    ----------   │    │  isFile()       │     │  getPath()         │    │                    │
╚═════════════════╝    │  isDirectory()  │     │  getAbsolutePath() │    ╚════════════════════╝
                       │  canRead()      │     │  length()          │          waiting
     completed         │  canWrite()     │     ╚════════════════════╝
                       │  canExecute()   │                       
                       ╚═════════════════╝




╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                (2)  Checking And Information Methods                         ║
╚══════════════════════════════════════════════════════════════════════════════╝


════════════════════════════════════════════════════════════════════════════════
Introduction
════════════════════════════════════════════════════════════════════════════════
After creation methods, 
The File class provides next two categories of methods:.

        1. Checking Methods
        2. Information Methods


════════════════════════════════════════════════════════════════════════════════
-------------------          Checking Methods            -----------------------
════════════════════════════════════════════════════════════════════════════════
These methods are mainly used to verify the current state of a File.

For example,
        • Does the file exist ?
        • Is it a File or Directory ?
        • Can we Read it ?
        • Can we Write into it ?
        • Can we Execute it ?


─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-
1. exists()
──────────────────────────────────────────────────────────────────────────────
Checks whether the File actually exists or not.

Returns
        true  :  File exists.
        false :  File does not exist.


─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-
2. isFile()
──────────────────────────────────────────────────────────────────────────────
Checks whether the current object represents a normal File.

Example
        Student.txt   ✔ true
        Java Folder   ✘ false


─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-
3. isDirectory()
──────────────────────────────────────────────────────────────────────────────
Checks whether the current object represents a Directory (Folder).

Example
        Student.txt   ✘ false
        Java Folder   ✔ true


─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-
4. canRead()
──────────────────────────────────────────────────────────────────────────────
Checks whether the program has permission to Read the file.

Return 
        True  ----> permission 
        false ----> no permission


─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-
5. canWrite()
──────────────────────────────────────────────────────────────────────────────
Checks whether the program has permission to Write into the file.

Return 
        True  ----> permission 
        false ----> no permission


─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-─-──-─-
6. canExecute()
──────────────────────────────────────────────────────────────────────────────
Checks whether the file can be Executed.

Mostly useful for
        • Executable Programs
        • Script Files
        • Command Files

Return Type
        boolean



════════════════════════════════════════════════════════════════════════════════
-----------              Information Methods                 -------------------
════════════════════════════════════════════════════════════════════════════════
These methods return useful information about the File.


──────────────────────────────────────────────────────────────────────────────
1. getName()
──────────────────────────────────────────────────────────────────────────────
Thsi will returns the name of the file.
Example : Student.txt


──────────────────────────────────────────────────────────────────────────────
2. getPath()
──────────────────────────────────────────────────────────────────────────────
Returns the same path that was used while creating the File object.

Example : Student.txt
             or
          D:\Notes\Student.txt


──────────────────────────────────────────────────────────────────────────────
3. getAbsolutePath()
──────────────────────────────────────────────────────────────────────────────
Returns the complete path of the File inside the Operating System.

Example
        C:\Users\Yash\Desktop\Student.txt


──────────────────────────────────────────────────────────────────────────────
4. length()
──────────────────────────────────────────────────────────────────────────────
Returns the size of the File.

Unit         :   Bytes
Return Type  :   long

Example
        Student.txt
        Size = 125 Bytes



════════════════════════════════════════════════════════════════════════════════
Program Demonstration
════════════════════════════════════════════════════════════════════════════════
*/

import java.io.File;

public class p4_methodType2 
{
        public static void main(String[] args) 
        {
                try 
                {
                        File f = new File("Student.txt");
                        f.createNewFile();

                        System.out.println("\n---------------- Checking methods -------------------------");

                        System.out.println("If file exists   : " + f.exists());
                        System.out.println("Is File          : " + f.isFile());
                        System.out.println("Is Directory     : " + f.isDirectory());
                        System.out.println("Can Read         : " + f.canRead());
                        System.out.println("Can Write        : " + f.canWrite());
                        System.out.println("Can Execute      : " + f.canExecute());



                        System.out.println("\n---------------- Information methods -------------------------");

                        System.out.println("File Name        : " + f.getName());
                        System.out.println("Path             : " + f.getPath());
                        System.out.println("Absolute Path    : " + f.getAbsolutePath());
                        System.out.println("File Size        : " + f.length() + " Bytes");
                } 
                catch (Exception e) 
                {
                        e.printStackTrace();
                }

        }
}
