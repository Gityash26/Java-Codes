/*

╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║            execute(), executeQuery() and executeUpdate()                    ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

=> We already discussed about the CallableStatement interface that is used to execute the 
    stored procedures using IN, OUT, INOUT.


Question: After calling the Stored Procedure, Which method should we execute ?

        executeQuery() ?
        executeUpdate() ?
        execute() ?

Answer: It depends upon the Stored Procedure.


==============================================================================
Rule
==============================================================================

=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
executeQuery()
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
    Use this method when the stored procedure process SELECT query. 

returns: 
        ResultSet


=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
executeUpdate()
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
    Use this method when the stored procedure contains queries:

    INSERT
    UPDATE
    DELETE

returns: 
        int affected rows count


=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
execute()
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
    Use this methods when the returnType weas not cleared 
    It can returns int, resultSet, both 

Returns
        true  -> ResultSet
        false -> Update Count



==============================================================================
Decision Tree
==============================================================================

                    Stored Procedure
                            │
            ┌───────────────┼─────────────────┐
            │               │                 │
            ▼               ▼                 ▼
        SELECT         INSERT/UPDATE      Mixed
            │               │                 │
            ▼               ▼                 ▼
     executeQuery()    executeUpdate()     execute()



==============================================================================
To demonstrate all three types , first create these stored procedure in your 
workbench 
==============================================================================
     
---------------- Procedure 1 --------------------------------

DROP PROCEDURE IF EXISTS insertEmployee;

CREATE PROCEDURE insertEmployee
(
    IN empName VARCHAR(100),
    IN empSalary DOUBLE
)
BEGIN
    INSERT INTO Employee(name, salary)
    VALUES(empName, empSalary);
END;


---------------- Procedure 2 --------------------------------

DROP PROCEDURE IF EXISTS showEmployees;

CREATE PROCEDURE showEmployees()
BEGIN
    SELECT * FROM Employee;
END;

---------------- Procedure 3 --------------------------------

DROP PROCEDURE IF EXISTS insertAndShowStudent;

CREATE PROCEDURE insertAndShowStudent()
BEGIN
    INSERT INTO Student(id, name, marks)
    VALUES(108, 'Demo Student', 99.9);

    SELECT * FROM Student;
END;


==============================================================================
*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class p7_CallableExecuteMethods
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String NewURL = "jdbc:mysql://localhost:3306/College";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    // ----------------------------------------------------------
    // executeUpdate()
    // ----------------------------------------------------------
    private static void executeUpdateDemo(Connection con) throws Exception
    {
        CallableStatement cst = con.prepareCall("{CALL insertEmployee(?, ?, ?)}");

        cst.setInt(1, 201);
        cst.setString(2, "Yash");
        cst.setDouble(3, 50000);

        int rows = cst.executeUpdate();

        System.out.println("\n========== executeUpdate() ==========");
        System.out.println("Rows Inserted : " + rows);

        cst.close();
    }


    // ----------------------------------------------------------
    // executeQuery()
    // ----------------------------------------------------------
    private static void executeQueryDemo(Connection con) throws Exception
    {
        CallableStatement cst = con.prepareCall("{CALL showEmployees()}");

        ResultSet rs = cst.executeQuery();

        System.out.println("\n========== executeQuery() ==========");
        System.out.printf("%-5s %-20s %-10s%n",
                "ID", "Name", "Salary");
        System.out.println("----------------------------------------------");

        while(rs.next())
        {
            System.out.printf("%-5d %-20s %-10.2f%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("salary"));
        }

        rs.close();
        cst.close();
    }


    // ----------------------------------------------------------
    // execute()
    // ----------------------------------------------------------
    private static void executeDemo(Connection con) throws Exception
    {
        CallableStatement cst = con.prepareCall("{CALL insertAndShowStudent()}");

        boolean hasResultSet = cst.execute();

        System.out.println("\n========== execute() ==========");

        if(hasResultSet)
        {
            ResultSet rs = cst.getResultSet();

            System.out.printf("%-5s %-20s %-10s%n","ID", "Name", "Marks");
            System.out.println("----------------------------------------------");

            while(rs.next())
            {
                System.out.printf("%-5d %-20s %-10.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("marks"));
            }

            rs.close();
        }
        else
        {
            System.out.println("Rows Affected : " + cst.getUpdateCount());
        }

        cst.close();
    }


    // ----------------------------------------------------------
    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            executeUpdateDemo(con);
            executeQueryDemo(con);

            con = DriverManager.getConnection(NewURL, USERNAME, PASSWORD);

            executeDemo(con);

            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}