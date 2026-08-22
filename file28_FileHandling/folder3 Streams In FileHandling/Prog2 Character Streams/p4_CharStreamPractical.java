/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                    Practical Ques of Character Stream                        ║
╚══════════════════════════════════════════════════════════════════════════════╝

══════════════════════════════════════════════════════════════════════════════
                                 Task
══════════════════════════════════════════════════════════════════════════════

So far we learned both sides separately:

        FileWriter
             ↓
        Java → File


        FileReader
             ↓
        File → Java


Now we will combine both in one program.

Task

        1. Create a source file.
        2. Write some text into it.
        3. Read the same text using FileReader.
        4. Display it on the console.



══════════════════════════════════════════════════════════════════════════════
Important Observation
══════════════════════════════════════════════════════════════════════════════

FileWriter automatically creates the File if it does not exist.

Therefore, we don't need:

        File f = new File(...);
        f.createNewFile();

before using FileWriter.


FileReader then reads the data from that File.


══════════════════════════════════════════════════════════════════════════════
Program
══════════════════════════════════════════════════════════════════════════════
*/


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class p4_CharStreamPractical
{
    public static void main(String[] args)
    {
    
        File f = new File("C:\\CODE FOLDERS\\JAVA Codes\\file28_FileHandling\\folder3 Streams In FileHandling\\Prog2 Character Streams\\Student.txt");
        
        try
        {
            // ------------------------------------------------------------
            // STEP 1 : Write data into the File
            // ------------------------------------------------------------

            FileWriter writer = new FileWriter(f);

            writer.write("Hello Yash\n");
            writer.write("This is Character Stream practice.\n");
            writer.write("FileWriter is used for writing data.");

            writer.close();


            // ------------------------------------------------------------
            // STEP 2 : Read data from the File
            // ------------------------------------------------------------

            FileReader reader = new FileReader(f);

            int ch;

            while((ch = reader.read()) != -1)
            {
                System.out.print((char) ch);
            }

            f.delete();
            reader.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}


/*
══════════════════════════════════════════════════════════════════════════════
Program Flow
══════════════════════════════════════════════════════════════════════════════

        FileWriter
             │
             ▼
    ┌─────────────────────┐
    │     Student.txt     │
    │                     │
    │ Hello Yash          │
    │ This is Character   │
    │ Stream practice.    │
    └──────────┬──────────┘
               │
               │ FileReader
               ▼
        Java Program
               │
               ▼
            Console


══════════════════════════════════════════════════════════════════════════════
What We Used
══════════════════════════════════════════════════════════════════════════════

        FileWriter
            → Writes character data into File.

        write()
            → Writes the given text.

        FileReader
            → Reads character data from File.

        read()
            → Reads one character at a time.

        -1
            → Indicates End Of File.

        close()
            → Closes the Reader / Writer.


══════════════════════════════════════════════════════════════════════════════
Final Character Stream Picture
══════════════════════════════════════════════════════════════════════════════

                    Character Streams
                           │
              ┌────────────┴────────────┐
              │                         │
              ▼                         ▼
         FileReader                FileWriter
              │                         │
              ▼                         ▼
            READ                     WRITE
              │                         │
              ▼                         ▼
        File → Java               Java → File


══════════════════════════════════════════════════════════════════════════════
*/