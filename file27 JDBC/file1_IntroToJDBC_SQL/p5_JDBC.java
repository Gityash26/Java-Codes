/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                    Establishing the First JDBC Connection                    ║
╚══════════════════════════════════════════════════════════════════════════════╝

==============================================================================
                            WHY ARE WE LEARNING THIS?
==============================================================================

Suppose we are developing

                           Amazon / Flipkart

A customer clicks on

                               LOGIN

Java receives

        Username : yash@gmail.com
        Password : ********

Question

How will Java verify these credentials?

Obviously...

They are stored inside the MySQL Database.

But...

                Can Java directly communicate with MySQL?

                            ┌──────────────┐
                            │     Java     │
                            └──────┬───────┘
                                   │
                                   │   ❌ NO ---> Direct Communication ?
                                   │
                                   ▼
                            ┌──────────────┐
                            │    MySQL     │
                            └──────────────┘

                                  

Reason
    Java understands Java Language.
    MySQL understands SQL Language.

Both are completely different softwares.

Therefore,

we need a communication bridge.

==============================================================================
                        THE SOLUTION → JDBC
==============================================================================

JDBC = Java Database Connectivity

Definition
----------

JDBC is an API provided by Java that allows Java Applications to communicate with Relational 
Databases.

Think of JDBC as a Bridge.

                     ┌──────────────┐
                     │     Java     │
                     └──────┬───────┘
                            │
                            │
                     JDBC API (Bridge)
                            │
                            │
                            ▼
                     ┌──────────────┐
                     │    MySQL     │
                     └──────────────┘

Without JDBC

        Java  ───────────────► MySQL   ❌ Impossible

With JDBC

        Java --─► JDBC --─► MySQL           ✅ Possible



==============================================================================
                    WHAT EXACTLY HAPPENS INTERNALLY?
==============================================================================

Imagine Customer clicked Login and The complete flow becomes


       Customer
           │
           ▼
     Java Application
           │
           ▼
     JDBC API (java.sql)
           │
           ▼
     MySQL JDBC Driver
           │
           ▼
      MySQL Server
           │
           ▼
 Database Authentication
           │
           ▼
 Connection Established
           │
           ▼
 Connection Object Returned

Notice

Java never talks directly to MySQL.
It always communicates through

        JDBC API


==============================================================================
                      ENGINEER'S THINKING
==============================================================================

Suppose someone asks you

    "Connect Java with Database."

Never start writing code immediately.

Think first.

Question 1: Where is my Database?

        Need Database Address  ✔ URL

------------------------------------------------------------

Question 2: Will Database trust everyone?

        NO

Need Authentication

        ✔ Username
        ✔ Password

------------------------------------------------------------

Question 3: Who knows how to establish connection?

        ✔ DriverManager

------------------------------------------------------------

Question 4: After successful connection

What should Java receive?

        ✔ Connection Object

Now the pseudo code becomes

==============================================================================

                           PSEUDO CODE
==============================================================================

① Need Database Address
        ↓
② Need Username
        ↓
③ Need Password
        ↓
④ Ask DriverManager

        ↓    ----> "Please connect me."

⑤ Receive Connection Object
        ↓
⑥ Execute SQL Queries
        ↓
⑦ Close Connection

If you understand this, you can write JDBC code without memorizing it.


==============================================================================
                    NOW WE ARE READY TO WRITE CODE
==============================================================================

*/