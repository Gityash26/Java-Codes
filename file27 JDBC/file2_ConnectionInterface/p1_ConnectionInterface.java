/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                     Connection Interface Explained                           ║
╚══════════════════════════════════════════════════════════════════════════════╝


==============================================================================
                        What is Connection ?
==============================================================================

The 'Connection' is a predefined (Interface) present inside java.sql package

It represents

        "An Active Connection"

between

        Java Application
                         and
                                Database Server


Once DriverManager successfully establishes communication, it returns

                Connection reference.


==============================================================================
                    Why do we need Connection ?
==============================================================================

Imagine...

You successfully entered a Bank.
Now,

Can you directly withdraw money?  ==> NO.

You first need a Token.

Similarly,
After connecting to Database,

Connection acts like a

                Permission Card

Through this Connection Object

Java can

        ✔ Send SQL Queries
        ✔ Receive Result
        ✔ Commit Changes
        ✔ Rollback Changes
        ✔ Close Connection


==============================================================================
                  What can Connection Object do ?
==============================================================================

                    Connection

                         │
        ┌────────────────┼────────────────┐
        │                │                │
        ▼                ▼                ▼
 createStatement()  prepareStatement()   close()
        │
        ▼
Creates Statement Object 
which sends SQL Queries.


==============================================================================
                Real Flow inside JDBC
==============================================================================

Java Program
        │
        ▼
    DriverManager
        │
        ▼
    Connection
        │
        ▼
    Statement
        │
        ▼
    SQL Query
        │
        ▼
    Database
        │
        ▼
    Result


Remember

Connection never executes SQL.
Statement executes SQL.


==============================================================================
                Methods of Connection interface
==============================================================================

Connection Interface provides many methods.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. createStatement()
──────────────────────────────────────────────
-> Creates Statement Object.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. prepareStatement()
──────────────────────────────────────────────
-> Creates PreparedStatement Object.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
3. close()
──────────────────────────────────────────────
-> Terminates Database Connection.
    Always close connection after work.




==============================================================================
                    Analogy
==============================================================================

                    Java Program
                        │
                        ▼
                  Connection
                (Telephone Line)
                        │
                        ▼
                    Statement
                 (Speaking Words)
                        │
                        ▼
                    Database

The telephone line only connects.
Speaking happens through Statement.  (sql statements)


==============================================================================
                    Important Point
==============================================================================

The Connection were not executed SQL statements, instead it just provide an environment 
through which Statement can communicate with Database.




==============================================================================
                    Interview Questions
==============================================================================

Q1. Can Connection execute SQL Query?
Answer: No Connection just provide environment to execute sql statements 

--------------------------------------------
Q2. What is the responsibility of Connection?

Answer: To maintain communication between Java Application and Database and provide 
objects like Statement and PreparedStatement.

==============================================================================
*/
