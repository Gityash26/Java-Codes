
/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------- Nested Try Catch Block ------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Try catch can be nested in which we can write another try catch in the existing Try catch block.
for example:
-> Assume you are drunk and driving your car and by any mistake you got an accident with a shopkeeper.
-> Then there are two possibility:
   (1) Generally this matter solved in the police station 
   (2) You and shopkeeper find a middle way and solve the matter on spot.

   police_With_Shopkeeper
   {
        You_With_Shopkeeper
        {
            // Tring to compensate with Shopkeeper
        }
        Shopkeeper (Exception)
        {
            Matter solved in Shop
        }
   }
   police station( Exception )
   {
    //   Matter solved in police station
   }


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------- Try Catch Block in finally ------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> We can also write try catch block in finally block 
for example:

        try{
            // code 
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            try{

            }
            catch(Exception e)
            {

            }
        }
                 
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p5_NestedTryCatch 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Trtying to open a file 
            FileInputStream file = new FileInputStream("C:/Example.txt");
            
            try 
            {
                // Trying to read the file 
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) 
                {
                    String data = sc.nextLine();
                    System.out.println(data);
                }
                sc.close();
            } 
            catch (Exception e) 
            {
                // If any excewption occured during reading the file 
                System.out.println("Reading the file is not available");
            }
        }
        catch (FileNotFoundException e) 
        {
            // If any exception occured during opening a file 
            System.out.println("File not found");
        }
    }
}
