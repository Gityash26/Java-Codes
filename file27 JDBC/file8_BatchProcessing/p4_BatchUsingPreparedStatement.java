/*
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
------------ Batch Processing ------> (PreparedStatment)
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~

=> We already know that PreparedStatement is used to execute Parameterized SQL Queries.

Example,

        PreparedStatement pst = con.prepareStatement("INSERT INTO Employee(id,name,salary,email) VALUES(?,?,?,?)");

        pst.setInt(1,101);
        pst.setString(2,"Yash");
        pst.setDouble(3,50000);
        pst.setString(4,"yash@gmail.com");

        pst.executeUpdate();


In the above approach, every record is inserted immediately.

Now,
        instead of executing every INSERT separately, PreparedStatement allows us to first store multiple
        parameter sets inside a Batch and then execute all of them together.


Visual Representation
------------------------------------------------

        PreparedStatement
                │
        set Parameters
          addBatch()
                │
        set New Parameters
          addBatch()
                │
        set New Parameters
           addBatch()
                │
                ▼
          Batch Created
                │
                ▼
        executeBatch()
                │
                ▼
        All Records Inserted


Observation, 

Unlike Statement, the SQL Query always remains SAME.

Only the Parameter Values change before every addBatch() call.

This is the most commonly used Batch Processing approach in Real Projects.

══════════════════════════════════════════════════════════════════════
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class p4_BatchUsingPreparedStatement 
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "12345";

    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            /*=====================================================
                    RESET TABLE
            ===================================================== */

            PreparedStatement pst = con.prepareStatement("DELETE FROM Employee");
            pst.executeUpdate();
            pst.close();


            /*
            =====================================================
                PREPARED STATEMENT
            =====================================================
            */

            pst = con.prepareStatement("INSERT INTO Employee(id,name,salary,email) VALUES(?,?,?,?)");


            // ============== EMPLOYEE 1 =======================

            pst.setInt(1,101);
            pst.setString(2,"Yash");
            pst.setDouble(3,50000);
            pst.setString(4,"yash@gmail.com");
            pst.addBatch();

            // ============== EMPLOYEE 2 =======================

            pst.setInt(1,102);
            pst.setString(2,"Aman");
            pst.setDouble(3,42000);
            pst.setString(4,"aman@gmail.com");
            pst.addBatch();
        

            // ============== EMPLOYEE 3 =======================

            pst.setInt(1,103);
            pst.setString(2,"Rahul");
            pst.setDouble(3,61000);
            pst.setString(4,"rahul@gmail.com");
            pst.addBatch();


            // ============== EMPLOYEE 4 =======================

            pst.setInt(1,104);
            pst.setString(2,"Mohit");
            pst.setDouble(3,47000);
            pst.setString(4,"mohit@gmail.com");
            pst.addBatch();


            // ============== execute batch =======================

            int[] result = pst.executeBatch();

            System.out.println("══════════════════════════════════════");
            System.out.println(" Batch Executed Successfully");
            System.out.println("══════════════════════════════════════");

            for(int i = 0; i < result.length; i++)
            {
                System.out.println("Record " + (i + 1) + " -> " + result[i] + " row(s) inserted.");
            }

            pst.close();
            con.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
