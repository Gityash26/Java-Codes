import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class p4_ByteStreams_Practical
{
    public static void main(String[] args)
    {
        File sourceFile = new File("Student.txt");
        File destinationFile = new File("Student_Copy.txt");

        copyFile(sourceFile, destinationFile);
    }


    // ═══════════════════════════════════════════════════════════════════════
    //                     COPY FILE USING BYTE STREAM
    // ═══════════════════════════════════════════════════════════════════════

    public static void copyFile(File sourceFile, File destinationFile)
    {
        try
        {
            FileInputStream input =
                    new FileInputStream(sourceFile);

            FileOutputStream output =
                    new FileOutputStream(destinationFile);


            // Temporary storage used to transfer bytes.
            byte[] buffer = new byte[4096];

            int count;


            /*
             * Read bytes from source file
             * and immediately write them into
             * the destination file.
             */

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
}