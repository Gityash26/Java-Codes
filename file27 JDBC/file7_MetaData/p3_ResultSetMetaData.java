

/*
╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                    ResultSetMetaData Interface                              ║
╚~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╝


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Objective
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Suppose Java executes

        SELECT * FROM Employee;


Result
        ┌──────┬────────────┬────────────┐
        │ ID   │ Name       │ Salary     │
        ├──────┼────────────┼────────────┤
        │101   │ Yash       │50000       │
        │102   │ Aman       │42000       │
        └──────┴────────────┴────────────┘


Question 

Can Java automatically know

        ✔ Number of Columns
        ✔ Column Names
        ✔ Column Data Types
        ✔ Column Size

without us writing them manually?

Answer
                YES ✔

using
        ResultSetMetaData.



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 What is ResultSetMetaData?
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

    => The ResultSetMetaData is an Interface provided by JDBC.

    => It provides information about the ResultSet returned by a SELECT query.



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 How to Obtain ResultSetMetaData
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Step 1: Execute SELECT Query

        ResultSet rs = stmt.executeQuery(SELECT query);


Step 2: Call getMetaData() using ResultSet.

            ResultSetMetaData rsmd = rs.getMetaData();   // return metadata of the resultSet



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
==========  Common Methods =========================
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

┌═════════════════════════════════════════════════════════════════════════════┐
│ Method                                   │ Returns                          │
├══════════════════════════════════════════┼══════════════════════════════════┤
║ getColumnCount()                         ║    Number of Columns             ║
║──────────────────────────────────────────║──────────────────────────────────║
║ getColumnName(int)                       ║    Column Name                   ║
║──────────────────────────────────────────║──────────────────────────────────║
║ getColumnTypeName(int)                   ║    Data Type                     ║
║──────────────────────────────────────────║──────────────────────────────────║
║ getColumnDisplaySize(int)                ║    Maximum Display Width         ║
└═════════════════════════════════════════════════════════════════════════════┘



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
💻 Program
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class p3_ResultSetMetaData
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("\n══════════════════════════════════════════════════════");
            System.out.println("          RESULTSET INFORMATION");
            System.out.println("══════════════════════════════════════════════════════");

            System.out.println("Total Columns : " + rsmd.getColumnCount());
            System.out.printf("%-10s %-20s %-15s %-10s%n","Column No", "Column Name", "Data Type", "Size");
            System.out.println("────────────────────────────────────────────────────────────────────");

            for(int i=1;i<=rsmd.getColumnCount();i++)
            {
                System.out.printf("%-10d %-20s %-15s %-10d%n", i, rsmd.getColumnName(i), rsmd.getColumnTypeName(i), rsmd.getColumnDisplaySize(i));
            }
            System.out.println("══════════════════════════════════════════════════════");

            rs.close();
            stmt.close();
            con.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}



/*
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
🖥 Sample Output
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

══════════════════════════════════════════════════════
          RESULTSET INFORMATION
══════════════════════════════════════════════════════

Total Columns : 3

Column No  Column Name         Data Type       Size

------------------------------------------------------------

1          id                  INT             11

2          name                VARCHAR         100

3          salary              DOUBLE          22

══════════════════════════════════════════════════════



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
🧠 Internal Working
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

          SELECT Query

                │

                ▼

            ResultSet

                │

        getMetaData()

                │

                ▼

       ResultSetMetaData

                │

      ┌─────────┼────────────┐
      │         │            │

 Column Count  Column Name  Data Type



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
⚠ Important Points
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✔ ResultSetMetaData works only on ResultSet.

✔ It describes the structure of the ResultSet.

✔ It does NOT return actual row values.

✔ Column indexing starts from 1.

✔ Useful when writing Generic Database Applications.



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
🚀 Interview Points
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Q. Which object provides ResultSetMetaData?

Answer

        ResultSet Object.


Q. Which method returns ResultSetMetaData?

Answer

        getMetaData()


Q. Which method returns number of columns?

Answer

        getColumnCount()


Q. Which method returns column name?

Answer

        getColumnName(int)



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
📌 Revision Map
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

              ResultSet

                   │

            getMetaData()

                   │

                   ▼

         ResultSetMetaData

                   │

      ┌────────────┼────────────┐
      │            │            │

 Column Count  Column Name  Data Type



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
🎯 Metadata Folder Completed
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✅ P1 Introduction to Metadata

✅ P2 DatabaseMetaData

✅ P3 ResultSetMetaData


Next Folder

        📁 file8_BatchProcessing

where we'll learn how to execute multiple SQL queries together efficiently using JDBC.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
*/