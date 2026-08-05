
/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                    Executing SQL Queries using Statement                     ║
╚══════════════════════════════════════════════════════════════════════════════╝


==============================================================================
                    We finally reached the Database!
==============================================================================

Till now, we have successfully established

Java
    ↓
Connection
        ↓
        Statement


Now,

Statement's actual responsibility starts.

Its job is 
            "Execute SQL Queries."



==============================================================================
                    How does Statement execute SQL?
==============================================================================

Statement provides mainly three methods.

                    Statement

                         │
        ┌────────────────┼────────────────┐
        │                │                │
        ▼                ▼                ▼
 executeQuery()   executeUpdate()    execute()


Each method is designed for a different type of SQL Query.


==============================================================================
                    1. executeQuery()
==============================================================================

Purpose:: Used only for

                SELECT queries.

Example

SELECT * FROM employee;

Return Type
        ResultSet


Therefore Java needs an object to store those records.

That object is
    -------------------------------
        ResultSet
    -------------------------------




==============================================================================
                    2. executeUpdate()
==============================================================================

Purpose:: Used for

    ✔ INSERT
    ✔ UPDATE
    ✔ DELETE            
    ✔ CREATE
    ✔ DROP
    ✔ ALTER

Return Type
            int    (count of affected rows in the database)


Example

    UPDATE employee
    SET salary = 50000
    WHERE id = 101;



==============================================================================
                    3. execute()
==============================================================================

Purpose:: Can execute ANY SQL Query.

Return Type
            boolean


Returns

    (true)  ---> If ResultSet is returned.
    (false) ---> If rows were affected instead.



==============================================================================
            Which Method should we use?
==============================================================================

                    SQL Query
                         │
      ┌──────────────────┴──────────────────┐
      │                                     │
      ▼                                     ▼
SELECT Query                      INSERT / UPDATE / DELETE / DDL
      │                                     │
      ▼                                     ▼
executeQuery()                       executeUpdate()
      │                                     │
      ▼                                     ▼
  ResultSet                                int --- (count of affected rows)


==============================================================================
                Real Life Analogy
==============================================================================


Imagine, You ask "What is my Bank Balance?"
↓

Bank returns information.
This is similar to executeQuery()


--------------------------------------------

Now imagine Deposit ₹1000
↓

Bank updates your account.
It simply replies "Transaction Successful"
This is similar to executeUpdate()


*/
public class p2_StatementQueriesExecution {
    
}
