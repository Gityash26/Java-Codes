
/*
╔══════════════════════════════════════════════════════════════════════════════╗
║              DriverManager & Connection (Core Concept)                       ║
╚══════════════════════════════════════════════════════════════════════════════╝


==============================================================================
                    THE MOST IMPORTANT JDBC LINE
==============================================================================

Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

Almost every JDBC program starts with this line.

Question: What actually happens internally?
        Let's understand it step by step.


==============================================================================
                          STEP 1 : DriverManager
==============================================================================

DriverManager
    ↓
    A predefined Utility Class present inside

                java.sql package

Purpose

It manages all JDBC Drivers.

Think of it as a Receptionist.

                Java Program
                       │
                       │      "Who can connect to MySQL?"
                       ▼
               DriverManager   
                       │
                       ▼
             MySQL JDBC Driver
                       │
                       ▼
                 MySQL Database


==============================================================================
                    WHY IS IT CALLED DriverManager ?
==============================================================================

Imagine Java supports many databases.

                Java Application
                        │
                        ▼
                  DriverManager
          ┌─────────────┼─────────────┐
          │             │             │
          ▼             ▼             ▼
   MySQL Driver  Oracle Driver  PostgreSQL Driver


Instead of remembering every driver, we simply ask DriverManager.
DriverManager finds the correct driver automatically.

==============================================================================
                 STEP 2 : getConnection() METHOD
==============================================================================

DriverManager.getConnection(...)


Question: Why are we calling the method directly using DriverManager ?
Answer: Because, 

        getConnection()   => is a static method.

Therefore

    No object of DriverManager is required.

Correct
    DriverManager.getConnection(...)

Wrong
    new DriverManager()


==============================================================================
                  STEP 3 : WHAT DOES IT RETURN ?
==============================================================================

DriverManager.getConnection(...)

returns
                Connection

Question: What is Connection?
Connection is an Interface.

NOT a class.

Therefore

Wrong
    Connection con = new Connection();

Interfaces cannot be instantiated.


==============================================================================
              WHO CREATES THE CONNECTION OBJECT ?
==============================================================================

Question: If Connection is an Interface, who creates its object?

Answer: The JDBC Driver.

Flow

DriverManager
        │
        ▼
Calls MySQL Driver
        │
        ▼
Driver creates its own implementation
        │
        ▼
Returns it as => Connection

Therefore, 
        Connection con = DriverManager.getConnection(...);

actually stores an object of a Driver-specific class.

We don't know its class name.

We only know it behaves like a Connection.


==============================================================================
                  WHY STORE IT AS Connection ?
==============================================================================

Suppose MySQL internally creates
        ==> MysqlConnection

Tomorrow

Oracle may create
        ==> OracleConnection

PostgreSQL may create
        ==> PgConnection

Instead of changing our code every time,
Java gives us

                Connection Interface

So our code remains

    Connection con = ...

for every database.

    This is called Abstraction.


==============================================================================
                    COMPLETE FLOW
==============================================================================

Java Program
        │
        ▼
DriverManager.getConnection()
        │
        ▼
Find suitable JDBC Driver
        │
        ▼
Driver authenticates with Database
        │
        ▼
Database accepts request
        │
        ▼
Driver creates Connection Object
        │
        ▼
Returns Connection Interface Reference
        │
        ▼
Connection con


==============================================================================
                    REMEMBER
==============================================================================

    ✔ DriverManager → Utility Class
    ✔ getConnection() → Static Method
    ✔ Connection → Interface
    ✔ Driver creates actual object
    ✔ We receive only the interface reference

==============================================================================

Interview Question

Q. Why can't we write

        new Connection()

Answer

    Because Connection is an Interface.

Its implementation object is created internally by the database driver and returned through

    DriverManager.getConnection().

==============================================================================
*/
