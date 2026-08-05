package file4_PreparedStatement;
/*

╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                    PreparedStatement Interface                               ║
╚~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

So, we are already able to execute the sql queries using the statement interface method.

So, The question arise..... what makes us now to learn another topic ??


         Statement ========> PreparedStatement 

Basically, 
        The Statement Interface is very much enough - Only when the SQL queries are "fixed".
Example

        SELECT * FROM Student
or
        CREATE TABLE Student(...)


But in real-world applications, the values are not fixed.

Example
        Student Id    : 101
        Student Name  : Yash
        Student Marks : 95

Tomorrow
        Student Id    : 102
        Student Name  : Aman
        Student Marks : 88

Every time the values change.

Hence, writing a completely new SQL query every time is not a good practice.



==============================================================================
Problem with Statement Interface
==============================================================================

Suppose we want to insert student details.

statement: 
                INSERT INTO Student VALUES(101,'Yash',95)

Tomorrow
                INSERT INTO Student VALUES(102,'Aman',88)

Again
                INSERT INTO Student VALUES(103,'Rahul',91)


=> As clearly seen that only values are changing but, sql query were exactly same 
   So, this approach creates unnecessary work...




==============================================================================
Solution
==============================================================================

Java introduced another Interface.

                Statement═══════╗
                                ║              
                                │
                                ▼
                -------------------------------------
                        PreparedStatement
                -------------------------------------


Instead of changing the complete same SQL query, we prepare the query only once.
Only the values are changed.


---------------- for example ---------------------

Amazon has one fixed shipping box.

                        +---------------------------+
                        |                           |
                        | Name    : ________        |
                        | Address : ________        |
                        | Mobile  : ________        |
                        |                           |
                        +---------------------------+

The box design never changes.
Only the information changes.


==============================================================================
How PreparedStatement works
==============================================================================

                SQL Query

INSERT INTO Student
VALUES( ?, ?, ? )
               │
               ▼

        Query Prepared Once
               │
               ▼

     Set values one by one

            ?  ← 101
            ?  ← Yash             ---> we just require to change value inside placeholder (?)
            ?  ← 95

               │
               ▼

        Execute Query


==============================================================================
Advantages of PreparedStatement
==============================================================================

✔ Query is prepared only once.
✔ Cleaner Code.
✔ Better Performance.
✔ Prevents SQL Injection.
✔ Used in almost every real-world Java Application.



===============================
In this code we just creating a PreparedInterface reference object
===============================

*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class p1_IntroPreparedStatement
{
    public static void main(String[] args)
    {
        String URL = "jdbc:mysql://localhost:3306/Company";
        String USERNAME = "root";
        String PASSWORD = "12345";

        String query = "INSERT INTO Student VALUES(?, ?, ?)";

        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("PreparedStatement Object Created Successfully.");

            ps.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}