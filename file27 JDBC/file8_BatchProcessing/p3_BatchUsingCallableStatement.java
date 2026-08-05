
/*
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═
        Batch Processing using CallableStatement Interface
═══════════════════════════════════════════════════════════════════════

We already know that CallableStatement is used to call Stored Procedures from Java.

Example,

        CallableStatement cst = con.prepareCall("{CALL insertEmployee(?,?,?,?)}");
        cst.executeUpdate();


In the above approach, every Stored Procedure call is executed immediately.

Now,

instead of calling the Stored Procedure one by one, CallableStatement allows us to first 
collect multiple procedure calls inside a Batch and then execute all of them together.


Observation
-------------------------------
Unlike Statement,

the Stored Procedure remains SAME.
Only the Parameter Values change before every addBatch() call.

══════════════════════════════════════════════════════════════════════
*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class p3_BatchUsingCallableStatement
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);


            // ================ RESET EMPLOYEE TABLE ================== 
            con.createStatement().executeUpdate("DELETE FROM Employee");


            // ================ CALLABLE STATEMENT ================
            CallableStatement cst = con.prepareCall("{CALL insertEmployee(?,?,?,?)}");


            /*
            =====================================================
                        EMPLOYEE 1
            =====================================================
            */

            cst.setInt(1,101);
            cst.setString(2,"Yash");
            cst.setDouble(3,50000);
            cst.setString(4,"yash@gmail.com");

            cst.addBatch();


            /*
            =====================================================
                        EMPLOYEE 2
            =====================================================
            */

            cst.setInt(1,102);
            cst.setString(2,"Aman");
            cst.setDouble(3,42000);
            cst.setString(4,"aman@gmail.com");

            cst.addBatch();


            /*
            =====================================================
                        EMPLOYEE 3
            =====================================================
            */

            cst.setInt(1,103);
            cst.setString(2,"Rahul");
            cst.setDouble(3,61000);
            cst.setString(4,"rahul@gmail.com");

            cst.addBatch();


            /*
            =====================================================
                        EMPLOYEE 4
            =====================================================
            */

            cst.setInt(1,104);
            cst.setString(2,"Mohit");
            cst.setDouble(3,47000);
            cst.setString(4,"mohit@gmail.com");

            cst.addBatch();


            /*
            =====================================================
                    EXECUTE BATCH
            =====================================================
            */

            int[] result = cst.executeBatch();

            System.out.println("══════════════════════════════════════");
            System.out.println(" Batch Executed Successfully");
            System.out.println("══════════════════════════════════════");

            for(int i=0;i<result.length;i++)
            {
                System.out.println("Procedure Call " + (i+1) + " -> " + result[i] + " row(s) affected.");
            }

            cst.close();
            con.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}