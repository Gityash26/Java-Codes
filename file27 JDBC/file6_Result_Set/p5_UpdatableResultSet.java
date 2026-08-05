/*
╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                      Updatable ResultSet Interface                           ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╝


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Objective
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

So, we just cleared that the ResultSet stores the record received from the SELECT query.

AND, 

    =================================
    ScrollableResultSet: 
    =================================
            Provides a way to easily navigate throughout the ResultSet and access values using getter
            methods.

But...

Question: Can ResultSet itself modify the Database?

Can Java perform

        UPDATE
        INSERT
        DELETE

directly through ResultSet?

Without writing SQL queries like

        UPDATE Employee
        SET salary = 60000
        WHERE id = 101;

Let's understand.


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Situation
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Suppose our Employee Table is
        ┌──────┬────────────┬────────────┐
        │ ID   │ Name       │ Salary     │
        ├──────┼────────────┼────────────┤
        │101   │ Yash       │50000       │
        │102   │ Aman       │42000       │
        │103   │ Rahul      │61000       │
        └──────┴────────────┴────────────┘


Cursor is currently standing on ---> Aman

        ┌──────┬────────────┬────────────┐
        │101   │ Yash       │50000       │
        │102   │ Aman       │42000 ◄ Cursor
        │103   │ Rahul      │61000       │
        └──────┴────────────┴────────────┘


Suppose Java wants...

42000
↓
50000

Can it directly update this row?
Answer:  YES ✅



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
-------- Normal ResultSet ------------------------
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Till now we created Statement like this

Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

Notice

        CONCUR_READ_ONLY

means

        "Read Only"

ResultSet can

        ✔ Read
        ✔ Navigate
        ❌ Cannot Modify



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
----------- Updatable ResultSet ------------------
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

To modify records, we create ResultSet as

Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

Notice carefully...

    TYPE_SCROLL_INSENSITIVE

decides Cursor Behaviour

while

    CONCUR_UPDATABLE

decides "Database Modification Allowed."


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 What can an Updatable ResultSet do?
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

An Updatable ResultSet can

        ✔ Update Existing Row
        ✔ Insert New Row
        ✔ Delete Current Row


Visual

     Employee Table

        101   Yash
        102   Aman
        103   Rahul

               │
               ▼

        Cursor points to Aman
               │
               ▼
        updateString()
        updateDouble()
        updateRow()
               │
               ▼

        Database Updated



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Important Methods
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

──────────────────────────────────────────────────────────────
1. updateInt()
──────────────────────────────────────────────────────────────
Updates Integer value of Current Row.
Example

    rs.updateInt("salary", 60000);


──────────────────────────────────────────────────────────────
2. updateString()
──────────────────────────────────────────────────────────────
Updates String value of Current Row.
Example

    rs.updateString("name", "Aman Sharma");


──────────────────────────────────────────────────────────────
3. updateDouble()
──────────────────────────────────────────────────────────────
Updates Decimal value.
Example

    rs.updateDouble("salary", 55000);



──────────────────────────────────────────────────────────────
4. updateRow()
──────────────────────────────────────────────────────────────
Saves all updated values permanently into Database.

Important Calling updateString() or updateInt() does NOT update Database immediately.

Changes remain temporary until

        updateRow();

is called.




━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 Remember
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✔ updateXXX() only changes Current Row.

✔ updateRow() permanently saves changes.

✔ Without updateRow()

Database remains unchanged.




══════════════════════════════════════════════════════════════════════════════════
                     Program Demonstration
══════════════════════════════════════════════════════════════════════════════════

Employee Table (Initially)
┌──────┬────────────┬────────────┐
│ ID   │ Name       │ Salary     │
├──────┼────────────┼────────────┤
│101   │ Yash       │50000       │
│102   │ Aman       │42000       │
│103   │ Rahul      │61000       │
└──────┴────────────┴────────────┘


Operations
            ✔ Update salary with adding $5000
            ✔ Insert New Employee
            ✔ Delete Rahul
            ✔ Display Final Table

*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class p5_UpdatableResultSet
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    // Display Employee Table
    // ----------------------------------------------------------
    public static void display(ResultSet rs) throws Exception
    {
        rs.beforeFirst();

        System.out.println("════════════════════════════════════════════════════");
        System.out.printf("%-8s %-15s %-10s%n",
                "ID", "NAME", "SALARY");
        System.out.println("════════════════════════════════════════════════════");

        while(rs.next())
        {
            System.out.printf("%-8d %-15s %-10.2f%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"));
        }

        System.out.println("════════════════════════════════════════════════════");
    }



    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection( URL, USERNAME, PASSWORD);

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");


            
            // ============================== Initially table ==============================
            System.out.println("\nInitial Employee Table\n");
            display(rs);


            // ============================== UPDATE EXISTING ROWS ==============================

            rs.beforeFirst();

            while(rs.next())
            {
                rs.updateDouble("salary", rs.getDouble("salary") + 5000);
                rs.updateRow();
                System.out.println("✔ Salary Updated for : " + rs.getString("name"));
            }


            // ============================== Insert new Row ==============================

            rs.moveToInsertRow();

            rs.updateInt("id",104);
            rs.updateString("name","Mohit");
            rs.updateDouble("salary",47000);
            rs.insertRow();

            System.out.println("✔ New Employee Inserted with id(104)");


            // ============================== Delete Row ==============================

            rs.beforeFirst();

            while(rs.next())
            {
                if(rs.getInt("id") == 103)
                {
                    System.out.println("✔ Employee Deleted : " + rs.getString("name"));
                    rs.deleteRow();
                    break;
                }
            }


            // ============================== Final table ==============================

            System.out.println("\nFinal Employee Table\n");
            display(rs);

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