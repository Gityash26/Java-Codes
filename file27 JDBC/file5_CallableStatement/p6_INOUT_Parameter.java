/*
╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                      INOUT Parameter in CallableStatement                   ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝


==============================================================================
What we learnt till now
==============================================================================

IN Parameter
        Java -------------> Database

        Java sends data to the Database.

OUT Parameter
        Java <------------- Database

        Database returns data to Java.



==============================================================================
Problem Statement
==============================================================================

Suppose a Bank Account contains

        Current Balance = ₹10,000

A Java Program wants to deposit

        ₹2,000


Question: Should Database only receive ₹2,000 ?
or
Should Database also return the Updated Balance ?

    We need BOTH.


Visualize

    ---------------------------------
            Java
        Deposit ₹2,000
    ---------------------------------
               │
               ▼
    ---------------------------------
           Database
      10000 + 2000 = 12000
    ---------------------------------
               │
               ▼
    ---------------------------------
        Updated Balance ₹12,000
    ---------------------------------


Same parameter is used to 
        ---> SEND  
and to 
        ---> RECEIVE



==============================================================================
Solution : INOUT Parameter
==============================================================================

INOUT Parameter allows Java and Database to use the SAME parameter for

        Sending Data
and
        Receiving Updated Data.

Communication

        Java
          ⇅
      Database



==============================================================================
Definition
==============================================================================

INOUT Parameter is a Stored Procedure parameter that first receives a value from Java 
and after execution returns the modified value back to Java.


Simple Words

IN
        Java  ----------> Database


OUT
        Java <---------- Database


INOUT
        Java <=========> Database



==============================================================================
Syntax
==============================================================================

CREATE PROCEDURE procedure_name
(
    INOUT parameter datatype
)

BEGIN
    SQL Statements
END



Example

CREATE PROCEDURE addBonus
(
    INOUT salary DOUBLE
)
BEGIN
    SET salary = salary + 5000;
END




==============================================================================
Methods used
==============================================================================

Step 1: setDouble() : This was used to end Initial Value.
-----------------------------------------

Step 2: registerOutParameter() : Reserve memory for Returned Value.
-----------------------------------------

Step 3: execute() : Execute Stored Procedure.
-----------------------------------------

Step 4: getDouble(): Receive Updated Value.
-----------------------------------------


==============================================================================
Real Life Example
==============================================================================

ATM Machine
---------------------------

You Insert ₹2000

ATM Updates 
            Your Balance

ATM Returns
            Updated Balance


Exactly same happens using
            INOUT Parameter.



==============================================================================
Run this under workbench 
==============================================================================
CREATE PROCEDURE addBonus
(
    INOUT salary DOUBLE
)
BEGIN

SET salary = salary + 5000;

END

==============================================================================


*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class p6_INOUT_Parameter
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    private static void addBonus(Connection con, double salary) throws Exception
    {
        CallableStatement cst = con.prepareCall("{CALL addBonus(?)}");

        // IN Parameter
        cst.setDouble(1, salary);

        // OUT Parameter
        cst.registerOutParameter(1, Types.DOUBLE);

        // Execute Procedure
        cst.execute();

        // Receive Updated Value
        double updatedSalary = cst.getDouble(1);

        System.out.println("-------------------------------------");
        System.out.println("Original Salary : " + salary);
        System.out.println("Updated Salary  : " + updatedSalary);
        System.out.println("-------------------------------------");

        cst.close();
    }

    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            addBonus(con, 50000);

            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}