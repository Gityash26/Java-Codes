/*
╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                     Scrollable ResultSet Interface                           ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╝


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Objective
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Till now we have learnt...

✔ ResultSet : stores the record returned from the SELECT query
✔ Cursor    : points to one row at a time.
✔ next()    : moves the Cursor one row forward.
✔ Getter    : Methods read values from the Current Row.


Question: Can the Cursor move only in the Forward Direction?
Can we...

    ◉ Move Backward ?
    ◉ Jump to the First Record ?
    ◉ Jump to the Last Record ?
    ◉ Jump directly to any Row Number ?

Let's find out...


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
-----------  Situation ---------------------------------
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Suppose we have a...

         Employee Table 
        ┌──────┬────────────┬────────────┐
        │ ID   │ Name       │ Salary     │
        ├──────┼────────────┼────────────┤
        │101   │ Yash       │50000       │
        │102   │ Aman       │42000       │
        │103   │ Rahul      │61000       │
        │104   │ Mohit      │47000       │
        │105   │ Rohan      │55000       │
        └──────┴────────────┴────────────┘


Suppose Cursor is currently standing on 'Rahul'
        ┌──────┬────────────┬────────────┐
        │101   │ Yash       │50000       │
        │102   │ Aman       │42000       │
        │103   │ Rahul      │61000 ◄──── Cursor
        │104   │ Mohit      │47000       │
        │105   │ Rohan      │55000       │
        └──────┴────────────┴────────────┘

Now Java asks...

        "Go Back to Aman."

Can Cursor move upward?

                ❌ NO



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
⚠ Why?
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Because every ResultSet is created as

                    TYPE_FORWARD_ONLY

which means...

        Cursor
                ✔ Can Move Forward
                ❌ Cannot Move Backward
                ❌ Cannot Jump Anywhere



Visual Representation

            Cursor
        Before First Row
                │
                └─► Row 1
                      │
                      └─► Row 2
                            │
                            └─► Row 3
                                  │
                                  └─► continue...


Notice...
-> Only downward movement were allowed

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 Limitation of Normal ResultSet
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

                    Normal ResultSet

        next()                 ✔ Supported
        previous()             ❌ Not Supported
        first()                ❌ Not Supported
        last()                 ❌ Not Supported
        absolute()             ❌ Not Supported
        relative()             ❌ Not Supported


So if we want to navigate freely,
Normal ResultSet is not enough.



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
---------- !! Solution ----------------------------------
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

JDBC introduces another type of ResultSet called

                    Scrollable ResultSet

Unlike Normal ResultSet,
    Scrollable ResultSet allows Cursor to move in multiple directions.


                  ▲
                  │
        Row 1 ◄───┼────────────► Row 5
          ▲       │               ▲
          │       │               │
          ▼       ▼               ▼
       Row 2 ◄─► Row 3 ◄────── Row 4



Now Cursor becomes completely flexible.

It can...
        ✔ Move Forward
        ✔ Move Backward
        ✔ Jump to First Row
        ✔ Jump to Last Row
        ✔ Jump to Any Specific Row



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
📚 Types of ResultSet
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

┌──────────────────────────────┬──────────────────────────────────────────────┐
│ TYPE                         │ Description                                  │
├──────────────────────────────┼──────────────────────────────────────────────┤
│ TYPE_FORWARD_ONLY            │ Cursor moves only forward. (Default)         │
├──────────────────────────────┼──────────────────────────────────────────────┤
│ TYPE_SCROLL_INSENSITIVE      │ Cursor can move in all directions.           │
│                              │ Changes in Database are NOT reflected.       │
├──────────────────────────────┼──────────────────────────────────────────────┤
│ TYPE_SCROLL_SENSITIVE        │ Cursor can move in all directions.           │
│                              │ Database changes are reflected.              │
└──────────────────────────────┴──────────────────────────────────────────────┘



===========================================
In real-world applications,
===========================================
    TYPE_SCROLL_INSENSITIVE is used much more frequently.





━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━
                         Creating a Scrollable ResultSet
━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━~━

Till now we created Statement like this

        Statement stmt = con.createStatement();

which creates

        TYPE_FORWARD_ONLY

Now we create
        ---------------------------------------------------------------------------------------------------------
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ---------------------------------------------------------------------------------------------------------

Notice carefully...


Parameter 1

        TYPE_SCROLL_INSENSITIVE

decides -------------> "How Cursor should move."


Parameter 2

        CONCUR_READ_ONLY

decides ------------> "Can ResultSet modify records or only read them?"


note: 
        We will study CONCUR_UPDATABLE in the next chapter.



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 Remember
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✔ Scrollable ResultSet is NOT a different Interface.
✔ It is simply a ResultSet created with different properties.
✔ Only the Cursor behaviour changes.
✔ Getter Methods remain exactly the same.
✔ next() still works.
✔ We simply get additional navigation capabilities.



══════════════════════════════════════════════════════════════════════════════════
                    Cursor Navigation methods
══════════════════════════════════════════════════════════════════════════════════

┌────────────────────┬─────────────────────────────────────────────┐
│ Method             │ Purpose                                     │
├────────────────────┼─────────────────────────────────────────────┤
│ next()             │ Move one row forward                        │
├────────────────────┼─────────────────────────────────────────────┤
│ previous()         │ Move one row backward                       │
├────────────────────┼─────────────────────────────────────────────┤
│ first()            │ Move to the first row                       │
├────────────────────┼─────────────────────────────────────────────┤
│ last()             │ Move to the last row                        │
├────────────────────┼─────────────────────────────────────────────┤
│ absolute(n)        │ Jump directly to row number n               │
├────────────────────┼─────────────────────────────────────────────┤
│ relative(n)        │ Move relative to current position           │
├────────────────────┼─────────────────────────────────────────────┤
│ beforeFirst()      │ Move before the first row                   │
├────────────────────┼─────────────────────────────────────────────┤
│ afterLast()        │ Move after the last row                     │
└────────────────────┴─────────────────────────────────────────────┘


══════════════════════════════════════════════════════════════════════════════════
                    Program
══════════════════════════════════════════════════════════════════════════════════

*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class p4_ScrollableResultSet
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

// ---------------------------------------------------------------------------------------------------
            System.out.println("\n═══════════════ first() method ═══════════════ ");
            rs.first();
            System.out.println("First Employee : " + rs.getString("name"));

// ---------------------------------------------------------------------------------------------------
            System.out.println("\n═══════════════ last() method ═══════════════ ");
            rs.last();
            System.out.println("Last Employee : " + rs.getString("name"));

// ---------------------------------------------------------------------------------------------------
            System.out.println("\n═══════════════ previous() method ═══════════════ ");
            rs.previous();
            System.out.println("Previous of last Employee : " + rs.getString("name"));

// ---------------------------------------------------------------------------------------------------
            System.out.println("\n═══════════════ absolute(2) method ═══════════════ ");
            rs.absolute(2);
            System.out.println("Absolute second row Employee : " + rs.getString("name"));

// ---------------------------------------------------------------------------------------------------
            System.out.println("\n═══════════════ relative(2) method ═══════════════ ");
            rs.relative(2);
            System.out.println("Relative row 2 Employee : " + rs.getString("name"));

// ---------------------------------------------------------------------------------------------------
            System.out.println("\n═══════════════ beforeFirst() method ═══════════════ ");
            rs.beforeFirst();
            System.out.println("Cursor moved Before First Row.");

// ---------------------------------------------------------------------------------------------------
            System.out.println("\n═══════════════ afterLast() method ═══════════════ ");
            rs.afterLast();
            System.out.println("Cursor moved After Last Row.");
// ---------------------------------------------------------------------------------------------------
            

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


