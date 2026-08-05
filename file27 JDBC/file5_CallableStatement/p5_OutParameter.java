/*
╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                 CallableStatement  ---- OUT Parameter                       ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝


==============================================================================
What we learnt previously
==============================================================================

Till now we created Stored Procedures (or with IN parameter) that expected a resultSet from the Java.

Example

        Java
          │
          ▼
        insertIntoList("Milk")
          │
          ▼
        Database receives "Milk"
          │
          ▼
        INSERT INTO ShoppingList(item)


This type of communication is called

                    IN Parameter

because Java sends data--> TO the---> Database.



==============================================================================
Problem Statement
==============================================================================

Suppose, we have a Student table contains
        +-----------------------------+
        │ id  │  name   │  marks      │
        +-----------------------------+
        │ 101 │  Yash   │  95.5       │
        │ 102 │  Rahul  │  88.0       │
        │ 103 │  Mohit  │  91.2       │
        +-----------------------------+

Now imagine Java only knows
 
            Student ID = 101

Question: Can Database return only the 'Student_Name' back to Java ? not entire resultSet

Till now...

    Java  ------------->  Database

Only one-way communication.
Database never returned anything back except ResultSet (entrySet)



==============================================================================
Required Solution
==============================================================================

We need a mechanism where 

Java sends
                ---> Student ID

Database returns
                ---> Student Name (only name instead of entire resultSet)
 

Visualize


        Java                         Database
---------------------------------------------------------
     Student ID  ------------------------->

                                  Search Student

     Student Name <-------------------------




==============================================================================
Solution :         -------------- OUT Parameter  --------------
==============================================================================

OUT Parameter allows the Database to SEND values back to Java.

Communication becomes

          Java
            │
            ▼
        Database
            ▲
            │
Both can exchange information.


==============================================================================
Definition
==============================================================================

=> The OUT Parameter is a parameter of Stored Procedure that stores the value inside 
   the Database and returns that value back to the Java Program after execution.

Simple Words

IN Parameter
        Java  ---------> Database

OUT Parameter
        Java <--------- Database



==============================================================================
Syntax
==============================================================================

CREATE PROCEDURE procedure_name
(
    IN   parameter datatype,
    OUT  parameter datatype
)

BEGIN
    SQL Statements
END
-----------------------------------------------


Example

CREATE PROCEDURE getStudentName
(
    IN sid INT,
    OUT sname VARCHAR(100)
)
BEGIN
    ........
END



==============================================================================
Internal Working
==============================================================================


                 Java Program
                     │
                     │ Student ID
                     ▼
           CallableStatement Object
                     │
                     ▼
         CALL getStudentName(101)
                     │
                     ▼
              Stored Procedure
                     │
           Search Student Table
                     │
       Store Name inside OUT Parameter
                     │
                     ▼
           Return Name to Java



==============================================================================
How Java receives OUT Parameter
==============================================================================

Unlike IN Parameter

        setInt()
        setString()
        setDouble()


OUT Parameter introduces one NEW Method

        registerOutParameter()

Purpose
        Reserve memory inside Java where Database will store the returned value.

Flow

   prepareCall()
        │
        ▼
     setInt()
        │
        ▼
registerOutParameter()
        │
        ▼
    execute()
        │
        ▼
   getString()



==============================================================================
Methods used
==============================================================================

1. registerOutParameter(index, SQLType)
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
=> This method tell Java "Database is going to return a value at this parameter."

Example
        registerOutParameter(2, Types.VARCHAR)


--------------------------------------------


2. getString(index)
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
=> This method receive returned String value.

Example
        String name = cst.getString(2);




==============================================================================
Real Life Example
==============================================================================


Teacher asks

        "Roll Number 101"
               │
               ▼
School Database searches Record
               │
               ▼
           Returns
        "Yash Sharma"


Teacher didn't know the Name. Database returned it.

Exactly same thing happens using

                OUT Parameter.


==============================================================================
*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Types;

public class p5_OutParameter
{
    private static final String URL = "jdbc:mysql://localhost:3306/College";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    // ----------------------------------------------------------
    // Create Stored Procedure
    // ----------------------------------------------------------
    private static void createStoredProcedure(Connection con) throws Exception
    {
        Statement stmt = con.createStatement();

        stmt.executeUpdate("DROP PROCEDURE IF EXISTS getStudentName");

        stmt.executeUpdate("""
                                CREATE PROCEDURE getStudentName
                                (
                                        IN sid INT,
                                        OUT sname VARCHAR(100)
                                )
                                BEGIN
                                        SELECT name INTO sname FROM Student
                                        WHERE id = sid;
                                END
                        """);
        stmt.close();
        System.out.println("Stored Procedure Ready...");
    }


    // ----------------------------------------------------------
    // Call Stored Procedure
    // ----------------------------------------------------------
    private static void getStudentName(Connection con, int studentId) throws Exception
    {
        CallableStatement cst = con.prepareCall("{CALL getStudentName(?,?)}");   // ? (In), ? (OUT)

        // IN Parameter
        cst.setInt(1, studentId);

        // OUT Parameter
        cst.registerOutParameter(2, Types.VARCHAR);

        // Execute Procedure
        cst.execute();


        // Receive OUT Value
        String studentName = cst.getString(2);

        System.out.println();
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);

        cst.close();
    }


    // ----------------------------------------------------------
    public static void main(String[] args)
    {
        try
        {
            Connection con =DriverManager.getConnection(URL, USERNAME, PASSWORD);

            createStoredProcedure(con);

            getStudentName(con, 101);

            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}