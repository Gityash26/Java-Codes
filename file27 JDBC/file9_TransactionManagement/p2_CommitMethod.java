package file9_TransactionManagement;

/*
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
                    Transaction using commit()
══════════════════════════════════════════════════════════════════════

=> By default, JDBC automatically commits every SQL Query.

To create our own Transaction,

first disable Auto Commit.

        con.setAutoCommit(false);

Now,
    every SQL Query becomes part of one Transaction.


Flow
------------------------------------------------

        setAutoCommit(false)
                │
        SQL Query 1
                │
        SQL Query 2
                │
        SQL Query 3
                │
            commit()
                │
                ▼
      Changes Permanently Saved


Observation
    If every SQL Query executes successfully, 

we call
        commit() 
        
to permanently save all changes.

══════════════════════════════════════════════════════════════════════
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class p2_CommitMethod
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


            // ================== Task1: Disable Auto Commit ================
            con.setAutoCommit(false);


            // ================== Task2: Execute multiple queries ================

            stmt.executeUpdate("UPDATE Employee SET salary = salary + 5000 WHERE id = 101");
            stmt.executeUpdate("UPDATE Employee SET salary = salary + 3000 WHERE id = 102");
            stmt.executeUpdate("UPDATE Employee SET salary = salary + 2000 WHERE id = 103");


            // ================== Task3: Commit all the queries changes ================
            con.commit();


            System.out.println(" --------------- Transaction Committed Successfully  --------------- ");
            stmt.close();
            con.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}