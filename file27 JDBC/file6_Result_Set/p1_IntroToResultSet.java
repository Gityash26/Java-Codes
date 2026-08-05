/*
        
        
╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                  ResultSet Interface - Cursor and next()                   ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝


==============================================================================
Quick Revision
==============================================================================

Till now we learnt three important JDBC Interfaces.

        Statement
                ├── Write SQL every time.
                ▼

        PreparedStatement
                ├── Prepare SQL once.
                ▼

        CallableStatement
                ├── Execute Stored Procedures.
                ▼

All of them had only ONE responsibility.

                "Execute SQL."



Examples

Statement
-----------------------------------------
        SELECT * FROM Employee;


PreparedStatement
-----------------------------------------
        INSERT INTO Employee VALUES (?, ?, ?);


CallableStatement
-----------------------------------------
        CALL addBonus();



Question...

After executing a SELECT query,
Who actually brings those records into Java ?


      JAVA <-------(record)-----------<-- DATABASE

==============================================================================
Let's Understand the Problem
==============================================================================

Suppose our Company Database contains an Employee Table.

    Employee Table
        +-----+-----------+-----------+
        │ Id  │ Name      │ Salary    │
        +-----+-----------+-----------+
        │ 101 │   Yash    │  50000    │
        │ 102 │   Aman    │  42000    │
        │ 103 │   Rahul   │  61000    │
        +-----+-----------+-----------+


Now Java executes

            SELECT * FROM Employee;


Obviously...
            Database finds all the matching rows.


Now think carefully...
    Those rows are still inside the Database.


Question: 🤔 How will Java receive them ?
             Can Java directly access Database Memory ?

        ❌ NO




-------------------------------
Reason: 
-------------------------------


                +--------------+                     +---------------------+
                │              │                     │                     │
                │ Java Program │-----access data--->>│        MySql        │
                │              │                     │                     │
                +--------------+                     +---------------------+
           
   
Java Program and MySQL Database are two different applications.

Both are running independently.

Java cannot simply open MySQL's memory and start reading rows.

There must be something in between that transfers those rows safely.




==============================================================================
How Database Returns Records
==============================================================================


                    Company Database
        +---------------------------------------+
        │                                       │
        │           Employee Table              │
        │ ---------------------------------     │
        │   101   Yash        50000             │
        │   102   Aman        42000             │
        │   103   Rahul       61000             │
        │ ---------------------------------     │
        +---------------------------------------+

                    SELECT Query
                           │
                           ▼
                Database prepares Result
                           │
                           ▼
                 Creates ResultSet Object
                           │
                           ▼
                    Returned to Java



Notice carefully...

Database DOES NOT return the original table.

Instead,
    it prepares a temporary object containing only the result of our query.

That temporary object is called...

                            ResultSet




==============================================================================
What is ResultSet ?
==============================================================================

The ResultSet is an Interface provided by the

                    java.sql package.

Its responsibility is Store the records returned by a SELECT query and allow Java to read 
them one row at a time.

Think of ResultSet as...

        "A temporary copy of Query Result."

It exists only while our Java program is working with the records.

Once ResultSet is closed, the temporary object disappears.




==============================================================================
Real Life Example
==============================================================================

Suppose you visit a Library.

You ask the Librarian...

        "Show me all Java Programming Books."

Does the Librarian hand over the entire Library ?

                ❌ No

Instead.. He prepares a list containing only the Java books.

Something like...


        Java Books
        -------------------------
        Head First Java
        Effective Java
        Java Complete Reference
        Thinking in Java


Now you start reading this list one book at a time.

Exactly the same happens inside JDBC.


                Employee Table
                        │
                        ▼
                Query Executes
                        │
                        ▼
                 ResultSet Created
                        │
                        ▼
             Java reads records one by one.




==============================================================================
Another Question...
==============================================================================

Suppose ResultSet contains

        +-----+---------+----------+
        |101  |Yash     |50000     |
        |102  |Aman     |42000     |
        |103  |Rahul    |61000     |
        +-----+---------+----------+


Question: How does Java know which row should be read first ?

How does Java move to

Second Row ?
Third Row ?
Last Row ?


Imagine reading a notebook.

You don't read all the lines together. You naturally keep your finger on one line.
After reading, you move your finger to the next line.

ResultSet works exactly the same way.

Instead of a finger, ResultSet uses...

                            CURSOR

And To move the cursor to the next row, ResultSet uses 

                            next()

*/