/*
===============================================================================
                        Introduction to JDBC
===============================================================================

Author  : Yash Sharma (m hi hu...)
Topic   : JDBC (Java Database Connectivity)
Purpose : To understand what JDBC is, why it is required, and how it works.

===============================================================================

1. What is JDBC?
────────────────

Definition
----------

JDBC (Java Database Connectivity) is a standard Java API that allows a Java application to 
communicate with a Relational Database (RDBMS).

Using JDBC, a Java application can:

        ✔ Store Data
        ✔ Retrieve Data
        ✔ Update Data
        ✔ Delete Data

These four operations are commonly called CRUD Operations.

        C → Create
        R → Read
        U → Update
        D → Delete

===============================================================================

2. Why JDBC?
────────────

Imagine you have developed an Online Shopping Website.

                    User
                      │
                      ▼
              Java Application

Now suppose a user registers.


Question: Where will you store his information?

        Name
        Email
        Password
        Mobile Number

Can Java store this permanently?
❌ NO

Java variables exist only while the program is running.

Once the application stops,

                RAM Memory
                    │
                    ▼
               Data disappears

Therefore we need a Permanent Storage.
                    │
                    ▼
                Database

===============================================================================

3. Problem Without JDBC
───────────────────────

                Java Program
                      │
                      │  ❌ Cannot Communicate
                      │
                MySQL Database

Java understands only => Java Language.
Database understands  => SQL.

-> Both speak different languages.
-> Hence they cannot communicate directly.

===============================================================================

4. Real Life Analogy
────────────────────

Suppose

You know only Hindi.

A foreign person knows only English.

                You (Hindi)
                      │
                      ▼
                 Translator
                      │
                      ▼
             Foreigner (English)

Translator allows communication.

Similarly,

            Java Application
                    │
                    ▼
                  JDBC
                    │
                    ▼
             MySQL Database

JDBC acts as a Translator between Java and Database.

===============================================================================

5. JDBC Architecture
────────────────────

                    Java Application
                           │
                           ▼
                      JDBC API
                           │
                           ▼
                     JDBC Driver
                           │
                           ▼
                  MySQL / Oracle /
               PostgreSQL / SQL Server

Flow

Java Program
      │
      ▼
JDBC API
      │
      ▼
JDBC Driver
      │
      ▼
Database

===============================================================================

6. Important Components
───────────────────────

JDBC consists of several important classes and interfaces.

Later we will study each one in detail.

                        JDBC
                          │
      ┌───────────────────┼────────────────────┐
      │                   │                    │
      ▼                   ▼                    ▼
 DriverManager       Connection           Statement
      │
      ├──────────────► PreparedStatement
      │
      ├──────────────► CallableStatement
      │
      └──────────────► ResultSet

===============================================================================

7. What is a JDBC Driver?
─────────────────────────

A JDBC Driver is a 'software library' provided by the Database Company.

Examples
        ________________________________________________
        │ MySQL        │===>  MySQL Connector/J Driver │ 
        │              │                               │
        │ Oracle       │===>  Oracle JDBC Driver       │
        │              │                               │
        │ PostgreSQL   │===>  PostgreSQL JDBC Driver   │
        │______________│_______________________________│

Think of Driver as a Translator which understands

        Java Commands
                ↓
        Database Commands

===============================================================================

8. Interview Points
───────────────────

Q1. Is JDBC a Database?
❌ No.

JDBC is only an API.

------------------------------------------------------------

Q2. Is JDBC a Driver?
❌ No.

JDBC is not a Driver.
JDBC provides interfaces and classes.
Drivers are provided by Database Vendors.

------------------------------------------------------------

Q3. Can Java communicate directly with Database?
❌ No.

Java requires a JDBC Driver.

------------------------------------------------------------

Q4. Full Form of JDBC?

Java Database Connectivity.

===============================================================================

9. Memory Trick
───────────────

                     JDBC
                       │
         Java ↔ Database Communication
                       │
             Driver acts as Translator
                       │
                Execute SQL Queries

===============================================================================
*/
