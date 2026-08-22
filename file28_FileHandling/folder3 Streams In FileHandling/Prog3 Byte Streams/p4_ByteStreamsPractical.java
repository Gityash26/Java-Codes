import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class p4_ByteStreamsPractical
{
    // ═══════════════════════════════════════════════════════════════════════
    //                     COPY FILE USING BYTE STREAM
    // ═══════════════════════════════════════════════════════════════════════

    public static void copyFile(File sourceFile, File destinationFile)
    {
        try
        {
            // create an source object for reading 
            FileInputStream input = new FileInputStream(sourceFile); 

            // create an destination object for writing 
            FileOutputStream output = new FileOutputStream(destinationFile);

            // Temporary storage used to transfer bytes.
            byte[] buffer = new byte[4096];
            int count;

            // Reading the source file 
            while((count = input.read(buffer)) != -1)
            {
                output.write(buffer, 0, count);
            }


            input.close();
            output.close();

            System.out.println("File copied successfully.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        File sourceFile = new File("Student.txt");
        File destinationFile = new File("Student_Copy.txt");

        copyFile(sourceFile, destinationFile);
    }

}