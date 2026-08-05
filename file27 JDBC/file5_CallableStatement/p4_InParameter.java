/*

╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                Calling Stored Procedure using IN Parameter                  ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

Till now we learnt...

        ✔ How to create a Stored Procedure.        
        ✔ How Java calls a Stored Procedure.

Question is...
        Can every Stored Procedure perform the same task?

Answer
        NO.


Think about our Student Database.

        Student Table
        +-----+--------+--------+
        | Id  │ Name   │ Marks │
        +-----+--------+--------+
        │ 101 │ Yash   │ 95.5  │
        │ 102 │ Rahul  │ 89.0  │
        │ 103 │ Aman   │ 91.5  │
        +-----+--------+--------+


Suppose different users request different Students.

        User-1 wants Student 101
        User-2 wants Student 102
        User-3 wants Student 103


==============================================================================
Wrong Approach
==============================================================================
Should we create... (separate) stored procedure for each roll number
                        
                                  /-----------getStudent101() ------------\             ___________
                                 │------------getStudent102() ------------│            │          │
        CallableStatment cst ====│------------getStudent103() ------------│----------- │ DATABASE │
                                 │------------getStudent104() ------------│            │__________│
                                 \------------getStudent105() -----------/
                                
                        

❌ Absolutely NOT.

As the Student IDs increase, the number of Stored Procedures will also increase.
This is not practical.


==============================================================================
Better Approach
==============================================================================

Create only ONE Stored Procedure AND send the 'ID' as argument to get only that specify 
student details...

                    getStudentById()

Now,
        instead of creating multiple Procedures,
        Java simply sends the Student ID.


                Java program
                        │
                Student Id = 102
                        │
                        ▼
                getStudentById(102)
                        │
                        ▼
                    Database
                        │
                        ▼
             Returns Student 102



        But!! how to sent a prameter ??? during procedure call 


╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                          IN Parameter                                       ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

An IN Parameter is used when Java needs to send some value to the Stored Procedure.

That value becomes the input of the Procedure.


    here, the IN shoows that the database expects a parameter from the JAVA 

                        Java  ─────────────► Database

Example

                Java
        ---------------------------
            Student Id = 102
        ---------------------------
                    │
                    ▼
        ---------------------------
          Stored Procedure
         getStudentById(102)
        ---------------------------
                    │
                    ▼
            Database searches
             WHERE id = 102
                    │
                    ▼
        Student Information Returned




==============================================================================
How to Create Stored Procedure (with parameter)
==============================================================================

Run inside MySQL Workbench

DELIMITER //
CREATE PROCEDURE getStudentById(IN studentId INT)
BEGIN
    SELECT * FROM Student
    WHERE id = studentId;
END //
DELIMITER ;



Notice carefully...

        (IN studentId INT)
                    ▲
                    │
This is called the IN Parameter.

The Database is expecting one Integer value.



==============================================================================
Calling the Procedure from MySQL
==============================================================================

CALL getStudentById(102);

Database receives
                  -> 102
                  
and internally executes

                SELECT * FROM Student
                WHERE id = 102;



╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                      Methods Used                                           ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

prepareCall()
---------------------------
        => Creates the CallableStatement Object.


setInt(parameterIndex,value)
----------------------------------
        => Assigns Integer value to the Placeholder (?).


executeQuery()
---------------------------------
        => Executes the Stored Procedure and returns a ResultSet Object.



==============================================================================
*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class p4_InParameter
{
    private static final String URL = "jdbc:mysql://localhost:3306/College";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    // -------------------------------------------------------------
    // Display Student Details
    // -------------------------------------------------------------
    private static void displayStudent(ResultSet rs) throws Exception
    {
        System.out.println("\n========== Student Details ==========\n");

        while(rs.next())
        {
            System.out.println("Id    : " + rs.getInt("id"));
            System.out.println("Name  : " + rs.getString("name"));
            System.out.println("-------------------------------------");
        }
    }


    // -------------------------------------------------------------
    // Execute Stored Procedure
    // -------------------------------------------------------------
    private static void getStudentById(Connection con, int id) throws Exception
    {
        CallableStatement cst = con.prepareCall("{CALL getStudentById(?)}");

        // Passing value to IN Parameter
        cst.setInt(1, id);
        ResultSet rs = cst.executeQuery();

        displayStudent(rs);

        rs.close();
        cst.close();
    }


    // -------------------------------------------------------------
    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            getStudentById(con, 102);
            getStudentById(con, 103);

            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}