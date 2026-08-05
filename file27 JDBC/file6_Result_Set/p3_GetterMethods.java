/*
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═
                  Getter Methods --> ResultSet Interface                      
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═


==============================================================================
Quick Revision
==============================================================================

In the previous file we learnt...

                  
                    ____________ cursor
        ResultSet--├
                   │____________ next()


=> Cursor: points row wise
=> next(): moves Cursor to the next row.


Suppose Cursor is currently standing here.

        Employee Table
        +-----+-----------+-----------+
        | Id  | Name      | Salary    |
        +-----+-----------+-----------+
        |101  | Yash      | 50000     | ◄ Cursor
        |102  | Aman      | 42000     |
        |103  | Rahul     | 61000     |
        +-----+-----------+-----------+


Question: We reached the row but How do we read the data ??

        Id ?
        Name ?
        Salary ?

Answer
        ResultSet provides Getter Methods.



==============================================================================
Getter Methods
==============================================================================

The ResultSet provides Getter Methods that are used to read the value of the CURRENT row.

General Syntax

        rs.get<DataType>(column);


Examples

        rs.getInt(col_Name/col_Num)
        ---------------------------------
        rs.getString(...)
        ---------------------------------
        rs.getDouble(...)
        ---------------------------------
        rs.getBoolean(...)
        ---------------------------------
        rs.getDate(...)
        ---------------------------------




==============================================================================
Reading Columns
==============================================================================

Getter Methods can access columns in TWO different ways.


-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
Way1: Using Column Index
-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-

Current Row
+-----+-----------+-----------+
|  1  |     2     |     3     |
+-----+-----------+-----------+
| Id  | Name      | Salary    |
+-----+-----------+-----------+

Example
        rs.getInt(1);

        rs.getString(2);

        rs.getDouble(3);



-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
Way2: Using Column Name
-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
-

Example

        rs.getInt("id");
        rs.getString("name");
        rs.getDouble("salary");


==============================================================================
Column Index VS Column Name
==============================================================================


Column Index
----------------------------

✔ Less typing
✔ Slightly shorter
❌ Depends on column order
❌ Difficult to understand


Example
        rs.getString(2);



----------------------------------------------
Column Name
---------------------------------------------

✔ Easy to Read
✔ Independent of column order
✔ Used in Real Projects

Example
        rs.getString("name");


Recommendation

Always prefer ---> Column Name
unless there is a special requirement.



==============================================================================
Program
==============================================================================
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class p3_GetterMethods
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static void main(String[] args)
    {
        try
        {
        //     create connection with database
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             
        //     Statment object 
            Statement stmt = con.createStatement();

        //     ResultSet object
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");


            System.out.println("\n===============================================");
            System.out.printf("%-8s %-15s %-10s%n","ID", "NAME", "SALARY");
            System.out.println("===============================================");

            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                System.out.printf("%-8d %-15s %-10.2f%n", id, name, salary);
            }

            System.out.println("===============================================");

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

