/*
╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                     Introduction to Metadata                                 ║
╚~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
     Objective
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Till now we have learnt how to

    ✔ How java connects with MySql 
    ✔ How sql queries were executes
    ✔ How to perform operations on the records of the database 
    
But...

Question: Can Java know information ABOUT the Database itself?

For example...

        Database Name ?
        MySQL Version ?
        Driver Version ?
        Number of Columns ?
        Column Names ?
        Column Data Types ?

without writing SQL queries?

The answer is YES ✔
using
            Metadata



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
===========  What is Metadata? ======================
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

The word Metadata means "Data about Data" or we can say that describe some other data.

Example
    Suppose we have an Employee Table.

        Employee
        ┌──────┬────────────┬────────────┐
        │ ID   │ Name       │ Salary     │
        ├──────┼────────────┼────────────┤
        │101   │ Yash       │50000       │
        │102   │ Aman       │42000       │
        └──────┴────────────┴────────────┘


The table records
┌─────────────────────────────────────────────┐
│   101      │    Yash     │     50000        │  => is called Data
│   102      │    Aman     │     42000        │
└─────────────────────────────────────────────┘


But information like
┌─────────────────────────────────────────────────┐
│   Table Name        │    Employee               │
│   Column Names      │    id, name, salary       │ => is called Metadata
│   Number of Columns │    3                      │
│   Column Data Types │    INT, VARCHAR, DOUBLE   │
└─────────────────────────────────────────────────┘




━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
======  Types of Metadata in JDBC  =========================
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

JDBC mainly provides two Metadata Interfaces.

┌=============================================================================┐
│ Interface_name               │         Information type                     │
├==============================┼==============================================┤
│ DatabaseMetaData             │ metadata of Entire Database                  │
├──────────────────────────────┼──────────────────────────────────────────────┤
│ ResultSetMetaData            │ metadata of ResultSet                        │
└──────────────────────────────┴──────────────────────────────────────────────┘



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
1. DatabaseMetaData
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

DatabaseMetaData provides information about the Database Server.

Examples

        ✔ Database Product Name
        ✔ Database Version
        ✔ JDBC Driver Name
        ✔ Driver Version
        ✔ Username
        ✔ URL
        ✔ Supported Features

Visual

                MySQL Database
                       │
                       ▼
               DatabaseMetaData
                       │
      ┌────────────────┼─────────────────┐
      │                │                 │
Database Name     Database Version    Driver Version



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
2. ResultSetMetaData
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

ResultSetMetaData provides information about the ResultSet.

Suppose
        SELECT * FROM Employee;

returns
        ┌──────┬────────────┬────────────┐
        │ ID   │ Name       │ Salary     │
        └──────┴────────────┴────────────┘

Java can automatically know

        Number of Columns -->  3
        Column Names      -->  id, name, salary
        Column Types      -->  INT, VARCHAR, DOUBLE


Visual
            ResultSet
                 │
                 ▼
        ResultSetMetaData
                 │
        ┌────────┼─────────┐
        │        │         │
     Columns   Names    Data Types



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
======= Difference ========================
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━


╔═════════════════════════════════════════════════════════════════════════════╗
║       DatabaseMetaData       │ ResultSetMetaData                            ║
╚═════════════════════════════════════════════════════════════════════════════╝
║ Information about Database   ║ Information about ResultSet                  ║
║------------------------------║----------------------------------------------║
║ Uses Connection Object       ║ Uses ResultSet Object                        ║
║------------------------------║----------------------------------------------║
║ Database Name                ║ Number of Columns                            ║
║ Database Version             ║ Column Names                                 ║
║ Driver Details               ║ Column Types                                 ║
╚═════════════════════════════════════════════════════════════════════════════╝



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 Remember
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✔ Metadata never stores actual records.
✔ Metadata only describes those records.
✔ Metadata helps Java understand the Database automatically.
✔ JDBC provides two important Metadata Interfaces.

        DatabaseMetaData
        ResultSetMetaData



━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 Revision Map
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

                        Metadata
                           │
          "Information About Information"
                           │
            ┌──────────────┴──────────────┐
            │                             │
            ▼                             ▼
   DatabaseMetaData              ResultSetMetaData
            │                             │
 Database Information          ResultSet Information


*/