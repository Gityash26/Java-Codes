

/*
══════════════════════════════════════════════════════════════════════
                Batch Processing using Statement interface 
══════════════════════════════════════════════════════════════════════

=> We already know that the Statement interface is used to execute SQL queries.

like, 
        Statement stmt = con.createStatement();

        stmt.executeUpdate(Query 1);
        stmt.executeUpdate(Query 2);
        stmt.executeUpdate(Query 3);


Now,

But in this approcahm instead of executing query immediately first we create a batch and then execute them 
at ones, 


Visual Representation
---------------------------------------

            Statement
                │
        addBatch(Query 1)
        addBatch(Query 2)
        addBatch(Query 3)
        addBatch(Query 4)
                │
                ▼
          Batch Created
                │
                ▼
        executeBatch()
                │
                ▼
      All Queries Executed



Observation

Unlike PreparedStatement, every SQL Query inside Statement Batch can be completely different.

Example
        INSERT
        INSERT
        UPDATE
        DELETE

All of them can exist inside the same Batch.

══════════════════════════════════════════════════════════════════════
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class p2_BatchUsingStatement
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();

            /*
            =====================================================
                        RESET TABLE
            =====================================================
            */

            stmt.addBatch("DELETE FROM Employee");
            stmt.addBatch("INSERT INTO Employee(id,name,salary,email) VALUES(101,'Yash',50000,'yash@gmail.com')");
            stmt.addBatch("INSERT INTO Employee(id,name,salary,email) VALUES(102,'Aman',42000,'aman@gmail.com')");
            stmt.addBatch("INSERT INTO Employee(id,name,salary,email) VALUES(103,'Rahul',61000,'rahul@gmail.com')");

            stmt.executeBatch();
            stmt.clearBatch();

            System.out.println("✔ Employee Table Reset Successfully.\n");


            /*
            =====================================================
                    BATCH PROCESSING DEMONSTRATION
            =====================================================
            */

            // INSERT Queries
            stmt.addBatch("INSERT INTO Employee(id,name,salary,email) VALUES(201,'Ram',30000,'ram@gmail.com')");
            stmt.addBatch("INSERT INTO Employee(id,name,salary,email) VALUES(202,'Shyam',35000,'shyam@gmail.com')");
            stmt.addBatch("INSERT INTO Employee(id,name,salary,email) VALUES(203,'Mohan',45000,'mohan@gmail.com')");

            // UPDATE Query
            stmt.addBatch("UPDATE Employee SET salary = 50000 WHERE id = 201");

            // DELETE Query
            stmt.addBatch("DELETE FROM Employee WHERE id = 202");


            /*
            =====================================================
                        EXECUTE BATCH
            =====================================================
            */

            int[] result = stmt.executeBatch();

            System.out.println("══════════════════════════════════════");
            System.out.println("      Batch Executed Successfully");
            System.out.println("══════════════════════════════════════");

            for(int i = 0; i < result.length; i++)
            {
                System.out.println("Query " + (i + 1) + " -> " + result[i] + " row(s) affected.");
            }

            stmt.close();
            con.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}