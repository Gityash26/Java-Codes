/*

╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                      Stored Procedure in MySQL                              ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

Till now we learnt that CallableStatement is used to call Stored Procedures.

Question is...

        Where does a Stored Procedure come from ?

Answer

    A Stored Procedure is first created inside the Database.

    After creating it, any Java Application can execute it using CallableStatement.



==============================================================================
What is a Stored Procedure ?
==============================================================================

A Stored Procedure is a collection of one or more SQL Statements stored permanently inside 
the Database.

Instead of writing SQL Queries repeatedly inside Java Programs, we simply call the Stored 
Procedure whenever required.



==============================================================================
Internally What Happens ?
==============================================================================

Developer
        │
Writes SQL Logic
        │
        ▼
CREATE PROCEDURE
        │
        ▼
Database stores it 
   permanently
        │
        ▼
    Java Program
        │
CallableStatement
        │
CALL procedure_name()
        │
        ▼
Database executes the SQL Logic



==============================================================================
General Syntax --> create StoredProcedure
==============================================================================

CREATE PROCEDURE procedure_name()

BEGIN
    SQL Statements
END;



==============================================================================
Example
==============================================================================
    => Suppose we want to display every Student.

Normally we write

        SELECT * FROM Student;

Instead, we can store this query permanently inside Database.

-------------------------------------------
CREATE PROCEDURE getStudents()

BEGIN
    SELECT * FROM Student;
END;
-------------------------------------------


Now, instead of writing

        SELECT * FROM Student;


again and again, we simply execute

        CALL getStudents();



==============================================================================
Visual Difference
==============================================================================

Without Stored Procedure
---------------------------------------


      Java
        │
SELECT * FROM Student
        │
    Database



With Stored Procedure
---------------------------------------

       Java
        │
CALL getStudents()
        │
Stored Procedure
        │
SELECT * FROM Student
        │
    Database



==============================================================================
Advantages
==============================================================================

    ✔ SQL Logic written only once.
    ✔ Easy to Maintain.
    ✔ Code Reusability.
    ✔ Cleaner Java Programs.
    ✔ Better Security.
    ✔ Faster Execution (Procedure is already stored and compiled.)



==============================================================================
MySQL Commands
==============================================================================

--------------------------------------
Create Procedure
--------------------------------------

    CREATE PROCEDURE getStudents()
    BEGIN
        SELECT * FROM Student;
    END;


--------------------------------------
Execute Procedure
--------------------------------------

    CALL getStudents();


--------------------------------------
Delete Procedure
--------------------------------------

    DROP PROCEDURE getStudents();



==============================================================================
Before moving forward ,
CREATE student table in your database, 
insert the data and create a Stored Procedure so that, 
we can call it through the next java file 
==============================================================================


============= Just run this sql in your workbench manually ===========
*/

-- Create database if not exists
CREATE DATABASE IF NOT EXISTS College;
USE College;

-- Create table if not exists
CREATE TABLE IF NOT EXISTS Student
(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    marks DOUBLE
);

-- Clear existing data (safe reset)
TRUNCATE TABLE Student;

-- Insert fresh data
INSERT INTO Student (id, name, marks) VALUES
(101,'Yash',95.5),
(102,'Rahul',87.0),
(103,'Aman',91.0);

-- Drop procedure if it already exists, then recreate
DROP PROCEDURE IF EXISTS getStudents;

DELIMITER //
CREATE PROCEDURE getStudents()
BEGIN
    SELECT * FROM Student;
END //
DELIMITER ;

-- Test procedure
CALL getStudents();
