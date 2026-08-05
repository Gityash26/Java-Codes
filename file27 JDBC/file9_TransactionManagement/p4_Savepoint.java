package file9_TransactionManagement;

/*
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═
                        Savepoint in Transaction
══════════════════════════════════════════════════════════════════════

=> We already know that after disabling Auto Commit, all SQL Queries become part of a single Transaction.

Till now, if any query failed, we used

                rollback();

which cancelled the COMPLETE Transaction.

But sometimes we don't want to cancel everything.

Instead, we want to return to a particular point inside the Transaction.

That point is called a

                    Savepoint.


Visual Representation
------------------------------------------------

        setAutoCommit(false)
                │
        Query 1 ✔
                │
        Query 2 ✔
                │
               setSavepoint() <══════════╗
                │                        ║                 
        Query 3 ✔                        ║
                │                         ║
        Query 4 ❌                        ║
                │                          ║ 
      rollback(Savepoint)══════════════════╝
                │
                ▼
        Query 1 ✔
        Query 2 ✔
        Query 3 ❌
        Query 4 ❌


Observation
---------------------------------------------
rollback()
        Cancels the Complete Transaction.

rollback(savepoint)

        Cancels only the changes made after that Savepoint.

Everything before the Savepoint remains unchanged.

══════════════════════════════════════════════════════════════════════
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class p4_Savepoint
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static void main(String[] args)
    {    
        Connection con = null;
        Savepoint sp = null;
        try
        {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();


        //     ================ RESET TABLE ===========================
            stmt.executeUpdate("DELETE FROM Employee"); // clear all data 
            stmt.executeUpdate("INSERT INTO Employee(id,name,salary,email) VALUES(101,'Yash',50000,'yash@gmail.com')");
            stmt.executeUpdate("INSERT INTO Employee(id,name,salary,email) VALUES(102,'Aman',42000,'aman@gmail.com')");
            stmt.executeUpdate("INSERT INTO Employee(id,name,salary,email) VALUES(103,'Rahul',61000,'rahul@gmail.com')");


        //     ================ Set Auto Commit off ===========================
            con.setAutoCommit(false);


        //     ================ Query 1 ===========================
            stmt.executeUpdate("UPDATE Employee SET salary = salary + 5000 WHERE id = 101");
            System.out.println("✔ Salary Updated for Employee 101");


        //     ================ Query 2 ===========================
            stmt.executeUpdate("UPDATE Employee SET salary = salary + 3000 WHERE id = 102");
            System.out.println("✔ Salary Updated for Employee 102");


        //  ================ Create SavePoint ===========================
            sp = con.setSavepoint("SalaryUpdated for Employee_Id 101 AND Employee_Id 102");
            System.out.println("✔ Savepoint Created");


        //  =================== Query 3 ===========================
            stmt.executeUpdate("UPDATE Employee SET salary = salary + 2000 WHERE id = 103");
            System.out.println("✔ Salary Updated for Employee 103");


        //  =================== Query 4 ===========================
            stmt.executeUpdate("UPDATE Employee SET salary = salary + 1000 WHERE id = 104"); // exception occured
            System.out.println("✔ Salary Updated for emp_id = 104");


        //  =================== Query 4 ===========================
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
                    con.rollback(sp);
                    System.out.println("✔ Rolled back to Savepoint");
                    con.commit();

                    System.out.println("✔ Remaining Changes Committed");
                }
            }
            catch(Exception ex)  
            {
                ex.printStackTrace();
            }
        }
    }
}