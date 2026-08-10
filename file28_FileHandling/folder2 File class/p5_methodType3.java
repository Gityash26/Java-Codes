

/*
                                        
                                        File Class
                                            │
        ┌──────────────────────┼───────────────────────┼───────────────────────────┐
        ▼                      ▼                       ▼                           ▼   
  (1) Creation            (2) Checking           (3) Information           (4) Modification 
╔═════════════════╗    ╔═════════════════╗     ╔════════════════╗       ╔════════════════════╗                        
│                 │    │                 │     │                │       │  renameTo()        │
╚═════════════════╝    ╚═════════════════╝     ╚════════════════╝       │  delete()          │
        done                  done                   done               ╚════════════════════╝
                       



╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                       Modification Methods                                  ║
╚═════════════════════════════════════════════════════════════════════════════╝


═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-
1. renameTo()
════════════════════════════════════════════════════════════════════════════════
This method is used to rename a File or Directory.

Syntax
        boolean renameTo(File destination);

Parameter

        destination
                A File object containing the new name or new location.

Returns
        true  : Rename Successful.
        false : Rename Failed.


──────────────────────────────────────────────────────────────────────────────
How does it work ?
──────────────────────────────────────────────────────────────────────────────

Suppose
-------------------

Current File Student.txt

We create another File object

                File newFile = new File("JavaNotes.txt");

Now
        file.renameTo(newFile);

Result

        Before  :  Student.txt
        After   :  JavaNotes.txt


Notice carefully, renameTo() requires another File object, because Java needs to know

        "What should be the new File?"


═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-═-
2. delete()
════════════════════════════════════════════════════════════════════════════════
This method permanently deletes the File or Directory.

Syntax

        boolean delete();

Returns
        true  :  File deleted successfully.
        false :  Deletion failed.



Important Observation
──────────────────────────────────────────────────────────────────────────────

delete() can delete
        ✔ Files
        ✔ Empty Directories

It CANNOT delete
        ✘ Non-empty Directories


Example

Java
 │
 ╚── Notes.txt

Trying
        delete()

returns
        false

because the directory still contains files.


════════════════════════════════════════════════════════════════════════════════
Program Demonstration
════════════════════════════════════════════════════════════════════════════════
*/

import java.io.File;
import java.io.IOException;

public class p5_methodType3
{
    public static void main(String[] args)
    {
        try
        {

        //  Step 1 : ~~~~~~~~~~~~ Create a file ~~~~~~~~~~~~~~~~~~~~~~

            File f = new File("Student.txt");

            if(f.createNewFile())
            {
                System.out.println("✔ Student file created.");
            }


        //  Step 2 : ~~~~~~~~~~~~ Rename the file ~~~~~~~~~~~~~~~~~~~~~~

            File newFile = new File("JavaNotes.txt");    

            if(f.renameTo(newFile))
            {
                System.out.println("✔ File Renamed Successfully.");
            }
            else
            {
                System.out.println("✘ Rename Failed.");
            }



        //  Step 2 : ~~~~~~~~~~~~ Delete the file  ~~~~~~~~~~~~~~~~~~~~~~

            if(newFile.delete())
            {
                System.out.println("✔ File Deleted Successfully.");
            }
            else
            {
                System.out.println("✘ Delete Failed.");
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

