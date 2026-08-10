/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                           File Reader                                        ║
╚══════════════════════════════════════════════════════════════════════════════╝

═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
FileReader
════════════════════════════════════════════════════════════════════════════════

FileReader is a predefined class provided by Java for reading character data from a File.
Package: java.io

Hierarchy

        Reader
          │
          ▼
    InputStreamReader
          │
          ▼
      FileReader


FileReader is a concrete class.
It is mainly used to read TEXT / character-based data from a File.


════════════════════════════════════════════════════════════════════════════════
Basic Working
════════════════════════════════════════════════════════════════════════════════

FileReader does not decide what the text means.

For example,
                50000

it always read as characters:

        '5' '0' '0' '0' '0'


════════════════════════════════════════════════════════════════════════════════
                    C O N S T R U C T O R S
════════════════════════════════════════════════════════════════════════════════


──────────────────────────────────────────────────────────────────────────────
(1) FileReader(String fileName)
──────────────────────────────────────────────────────────────────────────────
This method connects the file using the File path for reading.

Example
        FileReader reader = new FileReader("Student.txt");



──────────────────────────────────────────────────────────────────────────────
(2) FileReader(File file)
──────────────────────────────────────────────────────────────────────────────
Creates a FileReader using an existing File object.

Example

        File f = new File("Student.txt");
        FileReader reader = new FileReader(f);




════════════════════════════════════════════════════════════════════════════════
                    M E T H O D S
════════════════════════════════════════════════════════════════════════════════

──────────────────────────────────────────────────────────────────────────────
(1) read()
──────────────────────────────────────────────────────────────────────────────
Reads ONE character at a time from the File.

Return Type : int

Why int instead of char?
        Because read() must represent two different situations:

Character available
        ↓
        returns character value


End Of File
        ↓
        returns -1


Example
        Suppose Student.txt contains:
                                Hello


The calls behave conceptually like:

        read() → (int) H
        read() → (int) e
        read() → (int) l
        read() → (int) l
        read() → (int) o
        read() → -1


The actual return values are integer character values.

Example
        int ch = reader.read();
        System.out.println((char) ch);


Here,

        read()
          ↓
        returns int
          ↓
        (char) converts it
          ↓
        actual character


Syntax

        int ch = reader.read();


════════════════════════════════════════════════════════════════════════════════
Why do we use a Loop with read()?
════════════════════════════════════════════════════════════════════════════════

Because one read() call reads only ONE character.

Therefore,

        read()
        read()
        read()
        read()
        ...


Instead of manually calling it again and again,
we continue until read() returns -1.


Basic Logic

        int ch;

        while((ch = reader.read()) != -1)
        {
            System.out.print((char) ch);
        }




════════════════════════════════════════════════════════════════════════════════
(2) read(char[] cbuf)
════════════════════════════════════════════════════════════════════════════════

Reads multiple characters at once and stores them inside a character array.

Instead of:

        read()
        read()
        read()
        read()


we can provide an array:

        char[] data = new char[5];
        reader.read(data);

The characters are stored inside the array.
Return Type int


The returned int represents the number of characters actually read.

If the End Of File is already reached,

        -1


Example

        char[] data = new char[10];
        int count = reader.read(data);


If 7 characters were read:
                count = 7

Syntax
        int count = reader.read(charArray);


════════════════════════════════════════════════════════════════════════════════
(3) read(char[] cbuf, int off, int len)
════════════════════════════════════════════════════════════════════════════════

Reads characters into a character array starting from a specified position.

Parameters

        cbuf  → Character array
        off   → Starting position inside the array
        len   → Maximum number of characters to read


Example

        char[] data = new char[10];
        reader.read(data, 2, 5);

Meaning:

        Start storing at index 2
        and read maximum 5 characters.


It returns the number of characters actually read.

If EOF is reached: -1



════════════════════════════════════════════════════════════════════════════════
(4) skip(long n)
════════════════════════════════════════════════════════════════════════════════

Skips a specified number of characters while reading.

Example

Suppose the File contains:
                                ABCDEFGHIJ

If we execute:
        reader.skip(3);


then the first three characters are skipped:

        A B C
          └──── skipped


The next read starts from:
                D

Return Type
                long ---> represents the actual number of characters skipped.

Syntax
        long skipped = reader.skip(3);


════════════════════════════════════════════════════════════════════════════════
(5) ready()
════════════════════════════════════════════════════════════════════════════════

Checks whether the Reader is ready to be read.

Return Type: 
 
        true  → Reader is ready for reading
        false → Reader is not ready

Syntax
        boolean status = reader.ready();

Example

        if(reader.ready())
        {
            System.out.println("Reader is ready.");
        }


Important

ready() does NOT mean:
        "Is there definitely more data in the File?"

It only indicates whether the Reader is ready for a read operation without blocking.



════════════════════════════════════════════════════════════════════════════════
                    C O M P L E T E   P R O G R A M
════════════════════════════════════════════════════════════════════════════════
*/


import java.io.File;
import java.io.FileReader;

public class p2_FileReader
{
    public static void main(String[] args)
    {
        try
        {
            File f = new File("file28_FileHandling\\folder3_Streams In FileHandling\\Prog2 Character Streams\\Student.txt"
            );

            // Creates the physical file if it does not already exist
            f.createNewFile();

            // Creates FileReader using File object
            FileReader reader = new FileReader(f);

            int ch;

            // Read one character at a time until EOF
            while((ch = reader.read()) != -1)
            {
                System.out.print((char) ch);
            }

            // Close the FileReader
            reader.close();
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

        Student.txt
             │
             ▼
        File object
             │
             ▼
        FileReader
             │
             ▼
        reader.read()
             │
             ▼
       One character
             │
             ▼
       (char) conversion
             │
             ▼
          print()
             │
             └────────────────┐
                              │
                              ▼
                         read again
                              │
                              ▼
                            -1 ?
                          /     \
                        No       Yes
                        │         │
                        └────►   Stop
                                   │
                                   ▼
                            reader.close()


════════════════════════════════════════════════════════════════════════════════
FileReader Method Summary
════════════════════════════════════════════════════════════════════════════════

        read()
            → Reads one character.

        read(char[])
            → Reads multiple characters into an array.

        read(char[], off, len)
            → Reads characters into a selected part of an array.

        skip(n)
            → Skips characters.

        ready()
            → Checks whether Reader is ready.

        close()
            → Closes the Reader.


════════════════════════════════════════════════════════════════════════════════
Important Takeaways
════════════════════════════════════════════════════════════════════════════════

✔ FileReader is a concrete class.

✔ FileReader extends InputStreamReader.

✔ InputStreamReader extends Reader.

✔ FileReader is used to read character data from a File.

✔ read() returns int.

✔ -1 represents End Of File.

✔ (char) converts the returned character value into a character.

✔ read(char[]) can read multiple characters at once.

✔ skip() moves forward by skipping characters.

✔ ready() checks whether the Reader is ready.

✔ close() closes the FileReader.

══════════════════════════════════════════════════════════════════════════════
*/