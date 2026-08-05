/*
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
                Introduction to Batch Processing
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~

=> So, as we all know using JDBC statements, PreparedStatements, CallableStatements 
   we are simply executing sql queries and get the response.

Lets take and example, 

    Inserting employee data, 

                     executeUpdate("INSERT INTO STUDENT VALUES(101, 'YASH', 45000)");

This will helps to insert a employee record

    BUT !

What if we want to insert 1000 Employees into the database.

Normal Approach

    INSERT Employee 1
    INSERT Employee 2
    INSERT Employee 3
        .
        .
    ...INSERT Employee 1000

    
Every INSERT statement travels separately from Java to MySQL.

Result
    ❌ 1000 Database Calls  
    ❌ More Network Communication
    ❌ Slower Performance



Better Solution approcah
══════════════════════════════════════════════════════════════════════
To resolve this problem  we can create a batch of queries  and execute them at once. 
This approach is called as Batch Processing.

        Collect Multiple Queries
                    ↓
         Send Them Together


Simple Visualization
----------------------------------

         ______________
        │  Query 1    │
        │  Query 2    │
        │  Query 3    │
        │  Query 4    │
        │_____________│
               │
               ▼
         Batch Created
               │
               ▼
         executeBatch()
               │
               ▼
      Database Executes All



 What is Batch Processing?
══════════════════════════════════════════════════════════════════════

Batch Processing is a JDBC feature that allows multiple SQL statements to be executed 
together in one database call.

Instead of

        Query → Database
        Query → Database
        Query → Database

we do

        Query
        Query  ------> batch
        Query
            ↓

        executeBatch()
            ↓

        Database



══════════════════════════════════════════════════════════════════════
 Methods used in batch processing 
══════════════════════════════════════════════════════════════════════

(1) addBatch()
======================================================

    -> Stores the current SQL statement inside the Batch.
    -> The query is NOT executed immediately.


======================================================
(2) executeBatch()
======================================================

    -> Executes every query stored inside the Batch.

Return Type  
            int[]  ---> affected rows


======================================================
(3) clearBatch()
======================================================

    -> Removes all stored queries from the Batch.
    -> Useful when we no longer want to execute them.





══════════════════════════════════════════════════════════════════════
                Batch Processing Flow
══════════════════════════════════════════════════════════════════════


Create PreparedStatement
            │
            ▼
      set Parameters
            │
            ▼
        addBatch()
            │
     (Repeat Many Times)
            │
            ▼
      executeBatch()
            │
            ▼
 Database Executes Everything



7. Advantages
══════════════════════════════════════════════════════════════════════

✔ Faster Execution
✔ Less Network Traffic
✔ Fewer Database Calls
✔ Better Performance
✔ Cleaner Code
✔ Ideal for Large Data Insertion



8. Where is Batch Processing Used?
══════════════════════════════════════════════════════════════════════

Real Projects

✔ Importing Excel Data
✔ Uploading CSV Files
✔ Student Records
✔ Salary Processing
✔ Bank Transactions
✔ Bulk Email/User Registration

Whenever many records need to be inserted or updated together,
Batch Processing is preferred.


*/