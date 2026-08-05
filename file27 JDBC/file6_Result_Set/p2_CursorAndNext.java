/* 
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═
                        Cursor
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═


Cursor is an invisible pointer maintained internally by ResultSet.
Its job is very simple.

        "Tell Java which row is currently selected."

Initially,
    Cursor does NOT point to the first row.

Instead,


---------------------------------------------------------
                ResultSet
---------------------------------------------------------
        
              +-----------------------------------+
 cursor-->    |                                   |
              +-----------------------------------+
              |101    Yash       50000            |
              |102    Aman       42000            |
              |103    Rahul      61000            |
              -------------------------------------


This position is called

            BEFORE FIRST ROW

Why ?
    Because Java has not started reading any record yet.



==============================================================================
Then how do we move Cursor ?
==============================================================================

ResultSet provides a method

                next()

Whenever Java calls

        rs.next();

Cursor moves exactly ONE row forward.




═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═
                Understanding next() method
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═

Initially the Cursor is here.

              +-----------------------------------+
 cursor-->    |                                   |
              +-----------------------------------+
              |101    Yash       50000            |
              |102    Aman       42000            |
              |103    Rahul      61000            |
              -------------------------------------

Now Java executes --->> rs.next();

              +-----------------------------------+
  cursor->    |101    Yash       50000            |
              |102    Aman       42000            |
              |103    Rahul      61000            |
              -------------------------------------

Now Java is allowed to read the current row.

Again...
        rs.next();

Cursor moves one step further.


Now if there are no more rows then the Cursor moves AFTER the last record.

    -------------------------------------
    |101    Yash       50000           |
    |102    Aman       42000           |
    |103    Rahul      61000           |
    -------------------------------------
        ▲
        │
     Cursor


At this moment

        rs.next()

returns false



==============================================================================
That's why we write while(rs.next())
==============================================================================

Now the famous line finally makes sense.


while(rs.next())
{
 ......
}




==============================================================================
How do we read the Current Row ?
==============================================================================

Once Cursor reaches a row, Java can access every column of THAT row.

Suppose Cursor is here.

    -------------------------------------
    |101    Yash       50000   ◄ Cursor |
    |102    Aman       42000            |
    |103    Rahul      61000            |
    -------------------------------------


Now Java can read

-------------------------------------------------------------------------------------------
rs.getInt("id")         rs.getString("name")            rs.getDouble("salary")
        ↓                        ↓                               ↓
       101                    "Yash"                            5000
-------------------------------------------------------------------------------------------


Notice something very important.

getInt(), getString(), getDouble() ------> does NOT move Cursor.

Only
        next() method moves the Cursor.



==============================================================================
Internal Working
==============================================================================

When Java executes


ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

Internally...

        executeQuery()
                │
                ▼
      Database Executes SQL
                │
                ▼
      Matching Rows Found
                │
                ▼
      ResultSet Created
                │
                ▼
 JDBC Driver receives ResultSet
                │
                ▼
 Java stores reference inside

            rs



So remember...

Java NEVER creates ResultSet.

Database creates it.

Java only receives its reference.



==============================================================================
Program
==============================================================================
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class p2_CursorAndNext
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

            while(rs.next())
            {
                System.out.println(rs.getInt("id") + 
                           "   " + rs.getString("name") + 
                           "   " + rs.getDouble("salary"));
            }

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

