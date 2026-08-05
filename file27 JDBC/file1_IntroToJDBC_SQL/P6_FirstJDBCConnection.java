

/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                    Writing the First JDBC Program                            ║
╚══════════════════════════════════════════════════════════════════════════════╝


==============================================================================
                           WHY THIS PROGRAM?
==============================================================================

Until now we know

        ✔ What is JDBC?
        ✔ Why JDBC is required?
        ✔ JDBC acts as a Bridge.

But...

Knowing JDBC is not enough. As a Java Backend Developer,
our first task is

        "Connect Java Application with Database."

Today's goal is

        Learn how to establish the FIRST connection.

Nothing else.

No INSERT
No UPDATE
No DELETE
No SELECT

Only

                "Connection"


==============================================================================
                            REAL LIFE SCENARIO
==============================================================================

Suppose

You joined a company. Your Team Lead says

        "Connect our Java Project with MySQL."


Question: How will you start?
    Most beginners immediately start typing code.

Professionals don't.
    They first think.

==============================================================================
                          ENGINEER'S THINKING
==============================================================================

STEP 1 ->  If Java wants to communicate with MySQL.
            What things are required... ?

Let's think...

                Java Program
                      │
                      ▼
              Database Connection ?
         ┌────────────┼────────────┐
         │            │            │
         ▼            ▼            ▼
   Database     Authentication   Connector
   Address



Question: What is Database Address?
Answer  :   URL


Question: How will Database identify me?
Answer  :   Username
            Password


Question: Who knows how to establish the connection? (connector)
Answer  :   DriverManager


Question: After successful connection - what should Java receive?
Answer  : Connection Object


Now our thinking becomes




       URL       Username     password
        │___________│____________│
                    │
                    ▼
            Ask DriverManager
                    │
                    ▼
        Receive Connection Object


Notice

We haven't written a single line of Java.
Yet...
we already know the complete solution.


==============================================================================
                           COMPLETE ARCHITECTURE
==============================================================================


                ┌────────────────────────────┐
                │       Java Program         │
                └──────────────┬─────────────┘
                               │
                               │
                               ▼
                ┌────────────────────────────┐
                │      JDBC API (java.sql)   │        provided by the jdk
                └──────────────┬─────────────┘
                               │
                               │
                               ▼
                ┌────────────────────────────┐
                │   MySQL JDBC Driver (.jar) │         provided by the mysql
                └──────────────┬─────────────┘
                               │
                               │
                               ▼
                ┌────────────────────────────┐ 
                │      MySQL Database        │
                └────────────────────────────┘


Question: Why JDBC Driver?

Because, JDBC API only defines => HOW to communicate.

Actual communication is performed by 'Database Driver'.

Different databases provide different Drivers.

Example

        MySQL
             ↓
             MySQL Driver

        Oracle
             ↓
              Oracle Driver

        PostgreSQL
             ↓
            PostgreSQL Driver



==============================================================================
                     INTERNAL COMMUNICATION FLOW
==============================================================================


Customer clicks Login
            │
            ▼
Java Application Starts
            │
            ▼
JDBC API Receives Request
            │
            ▼
DriverManager Searches Driver
            │
            ▼
MySQL Driver Found
            │
            ▼
Driver Connects MySQL Server
            │
            ▼
Database verifies
        - Username
        - Password
            │
            ▼
Authentication Successful
            │
            ▼
Connection Object Returned


This entire process happens after writing only ONE statement.
We'll study that statement now.


==============================================================================
                            PSEUDO CODE
==============================================================================

Step 1: Store Database Address

                        => URL
────────────────────────────────────────────────────────────
Step 2: Store Username
────────────────────────────────────────────────────────────
Step 3: Store Password
────────────────────────────────────────────────────────────
Step 4: Ask DriverManager

                        "Please connect me."
────────────────────────────────────────────────────────────
Step 5: Receive Connection Object
────────────────────────────────────────────────────────────
Step 6: Use Connection
────────────────────────────────────────────────────────────
Step 7: Close Connection
────────────────────────────────────────────────────────────


If you understand this logic, writing the Java code becomes very easy.

==============================================================================
                                NEXT
==============================================================================

Now we are finally ready

to convert this pseudo code

into actual Java code.

(Continue with Part 2)



╔══════════════════════════════════════════════════════════════════════════════╗
║                  Writing the First JDBC Program (Part 2)                    ║
╚══════════════════════════════════════════════════════════════════════════════╝



==============================================================================
                    STEP 1 : IMPORT REQUIRED CLASSES
==============================================================================

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=

Question: Why import these classes?

Answer: Because all JDBC related classes are present inside

                        java.sql

Think

        java.util
        ├── ArrayList
        ├── HashMap
        ├── Scanner
        └── Arrays

Similarly

        java.sql
        ├── DriverManager
        ├── Connection
        ├── Statement
        ├── PreparedStatement
        └── ResultSet



==============================================================================
                STEP 2 : STORE DATABASE INFORMATION
==============================================================================

private static final String URL = "jdbc:mysql://localhost:3306/company";   // stored url
              
private static final String USERNAME = "root";                             // stored username

private static final String PASSWORD = "your_password";                    // stored password

------------------------------------------------------------------------------

Question: Why are these variables outside main() ?

Answer: Because, 

They belong to the whole class.
Any method inside this class can use them.


Question: Why static ?

Answer: Because,

main() is static.
A static method can directly access only static members.

Therefore

URL   , USERNAME   , PASSWORD   ---> are also declared static.


Question: Why final ?
Answer: Because, 

Database URL , Username , Password   ------> should not change while the program is running.

They are Constants.



==============================================================================
                    BREAKING THE DATABASE URL
==============================================================================

jdbc:mysql://localhost:3306/company
        │
        ├────────► jdbc
        │              Protocol used by JDBC
        │
        ├────────► mysql
        │              Database Vendor
        │
        ├────────► localhost
        │              Current Computer
        │
        ├────────► 3306
        │              Default MySQL Port
        │
        └────────► company
                       Database Name


Question: Can localhost be replaced?
Answer:  YES.

Example
        192.168.1.10

or

database.company.com
        if Database is running on another machine.


==============================================================================
                         STEP 3 : MAIN METHOD
==============================================================================

public static void main(String[] args)
{

}


Question: Why does our JDBC code start from main() ?

Answer: Because, Execution of every Java Application starts from

                main()


==============================================================================
                    STEP 4 : EXCEPTION HANDLING
==============================================================================

try
{

}
catch(SQLException e)
{
    e.printStackTrace();
}


Question: Why try-catch ?
Because, Database communication is uncertain.

Examples

        ❌ Wrong Password
        ❌ Wrong Username
        ❌ Database Server Down
        ❌ Database Doesn't Exist
        ❌ Network Failure

Any of these problems cause

                SQLException

Therefore
        Professional JDBC code always handles exceptions.



==============================================================================
                        STEP 5 : CREATE CONNECTION
==============================================================================

Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        STOP !!

This is the most important line in JDBC.


Read it like English.

DriverManager

        "Please establish a connection
         using this URL, Username, and Password."

If everything is correct
        ↓       
Return a Connection Object.

Store that object inside

                ===> conn


Question: Who creates the Connection Object?

Answer: NOT Java Program.
        NOT Developer.

DriverManager creates it (using the MySQL Driver internally).


Question: Can we write

        new Connection()

Answer: NO.

Reason: Connection is an Interface.
Interfaces cannot be instantiated.
We'll understand this completely in furter Program 7.



==============================================================================
                    STEP 6 : USE THE CONNECTION
==============================================================================

Once Connection Object is available

Java can

        ✔ Execute SQL
        ✔ Insert Data
        ✔ Update Data
        ✔ Delete Data
        ✔ Read Data

Remember

Connection itself does not execute SQL.
It simply establishes communication.
Statement and PreparedStatement will use this Connection later.


==============================================================================
                    STEP 7 : CLOSE CONNECTION
==============================================================================

conn.close();

Question: Why close() ?

Imagine, 
        You opened a phone call and After conversation You disconnect the call.

Similarly,
        Database Connection is also a resource.

It consumes

        ✔ Memory
        ✔ Network Socket
        ✔ Database Session
        
        Therefore
        Always close the connection after completing the work.
        
        
        ==============================================================================
        COMPLETE PROGRAM
        ==============================================================================
*/



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//---------------------------------------  step1: import all the required classes


public class P6_FirstJDBCConnection
{
        
        private static final String URL = "jdbc:mysql://localhost:3306/Company";
        
        private static final String USERNAME = "root";
        
        private static final String PASSWORD = "12345";
        //---------------------------------------  step2: Store database info


        //---------------------------------------  step3: Main method
        public static void main(String[] args)
        {
        //---------------------------------------  step4: remember to use exception handling
        try
        {
           //---------------------------------------  step5: establish a connection  
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database Connected Successfully.");

            con.close();

        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}