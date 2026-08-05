package file9_TransactionManagement;
/*
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═
                    Transaction using rollback()
══════════════════════════════════════════════════════════════════════

=> We already know that after disabling Auto Commit,

        con.setAutoCommit(false);

all SQL Queries become part of a single Transaction.

Now, if any SQL Query fails, instead of saving partial changes,

we can undo every change using

        rollback()

Flow
------------------------------------------------

        setAutoCommit(false)
                │
        SQL Query 1 ✔
                │
        SQL Query 2 ❌
                │
            Exception
                │
                ▼
          rollback()
                │
                ▼
        Database Restored


Observation

rollback() restores the Database back to its previous state.
It is as if none of the SQL Queries were executed.

══════════════════════════════════════════════════════════════════════
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class p3_RollbackMethod
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static void main(String[] args)
    {
        Connection con = null;

        try
        {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();


            // ============= Disable Auto Commit =====================
            con.setAutoCommit(false);


            // ============= Query 1 =====================
            stmt.executeUpdate("UPDATE Employee SET salary = salary + 5000 WHERE id = 101");
            System.out.println("=> Salary Updated for Employee 101");


            // ============= Query 2 =====================
            stmt.executeUpdate("UPDATE Employee SET salary = salary + 3000 WHERE emp_id = 102");  // there is no emp_id column (exception)
            System.out.println("✔ Salary Updated for Employee 102");


            // ============= Commit =====================
            con.commit();

            System.out.println("✔ Transaction Committed");

            stmt.close();
            con.close();
        }

        catch(Exception e)
        {
            System.out.println("\n❌ Exception Occurred");

            System.out.println(e.getMessage());

            try
            {
                if(con != null)
                {
                    con.rollback();
                    System.out.println("✔ Transaction Rolled Back Successfully");
                }
            }

            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}