/*
===============================================================================
                        JDBC Architecture
===============================================================================


1. JDBC Architecture
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
                      MySQL Database


===============================================================================

2. Understanding Each Component
────────────────────────────────

                          JDBC
                            │
        ┌───────────────────┼────────────────────┐
        │                   │                    │
        ▼                   ▼                    ▼
   Java Program         JDBC Driver         Database


===============================================================================

① Java Application
──────────────────

This is our Java Program.

Example

        Student Management System
        Banking Application
        E-Commerce Website
        Hospital Management System

Java only understands Java Language.

===============================================================================

② JDBC API
──────────

JDBC API is provided by Oracle.

It contains

    Interfaces
        Classes
        │
        ├──────────────► DriverManager
        ├──────────────► Connection
        ├──────────────► Statement
        ├──────────────► PreparedStatement
        ├──────────────► CallableStatement
        └──────────────► ResultSet



NOTE,
    JDBC API DOES NOT know how to communicate with MySQL.

    It only provides the rules.

===============================================================================

③ JDBC Driver
─────────────

Question: Who actually communicates with Database?

Answer
        JDBC Driver.

Driver is provided by Database Vendor.

Examples

    MySQL                   Oracle                   PostgreSQL           
      │                        │                        │
      ▼                        ▼                        ▼
MySQL Connector/J       Oracle JDBC Driver      PostgreSQL JDBC Driver

===============================================================================


3. Why Driver is Required?
──────────────────────────

Suppose Java sends

        INSERT INTO Student ...

MySQL understands it.

But Java cannot directly send it.

Instead

Java
  │
  ▼
JDBC API
  │
  ▼
JDBC Driver
  │
  ▼
 MySQL


Driver converts Java Calls into Database Specific Protocol.

Think of Driver as

    Translator

===============================================================================

4. Database Independence
────────────────────────

One of the biggest advantages of JDBC.

Suppose today

Java
 │
 ▼
MySQL

-------------- Tomorrow -----------------

Java
 │
 ▼
Oracle

Will Java Code change?

Mostly NO.
Only Driver changes.



-------------- Visualization-------------- 

                     Java Program
                            │
                            ▼
                        JDBC API
                            │
          ┌─────────────────┼─────────────────┐
          │                 │                 │
          ▼                 ▼                 ▼
    MySQL Driver      Oracle Driver    PostgreSQL Driver
          │                 │                 │
          ▼                 ▼                 ▼
        MySQL            Oracle         PostgreSQL


This concept is called Database Independence

===============================================================================

5. Complete Communication Flow
──────────────────────────────

User clicks Login
        │
        ▼      ----> through
Java Application
        │
        ▼      -----> using interface
    JDBC API
        │      -----> connects with driver
        ▼
    JDBC Driver
        │       --------> access database
        ▼
MySQL Database
        │
        ▼        ------> provider result
    Result
        │        ------> pass it
        ▼
Java Application
        │
        ▼
Display to User

===============================================================================

6. Interview Questions
──────────────────────

Q1. Who provides JDBC API?

Answer: Oracle (Java).

------------------------------------------------------------
Q2. Who provides JDBC Driver?

Answer: Database Vendor.

Example
    MySQL → MySQL Connector/J

------------------------------------------------------------
Q3. Can JDBC API communicate directly with Database?

Answer: No.
        It requires JDBC Driver.

------------------------------------------------------------
Q4. What is Database Independence?

Answer: Changing Database requires changing Driver only,
        not the entire Java Code affects.

===============================================================================



~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
                                Memory Tree
~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-

  JDBC 
    │
    ├── Java Program
    │
    ├── JDBC API
    │      │
    │      ├── DriverManager
    │      ├── Connection
    │      ├── Statement
    │      ├── PreparedStatement
    │      └── ResultSet
    │
    ├── JDBC Driver
    │      │
    │      └── Vendor Provided
    │
    └── Database

=======================
*/