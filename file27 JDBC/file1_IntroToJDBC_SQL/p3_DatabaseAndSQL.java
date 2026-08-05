/*
===============================================================================
                    Introduction to Database & MySQL
===============================================================================

1. What is Data?
────────────────
Data means any piece of information.

Examples

    Student Name
    Age
    Salary
    Mobile Number
    

Example

    Name  : Rahul
    Age   : 22
    City  : Delhi

All of the above is called DATA.

===============================================================================

2. What is Database?
────────────────────

A Database is an organized collection of related data that is stored permanently and 
can be accessed whenever required.

===============================================================================

3. Why Database?
────────────────

Suppose you create an application.

                Student Management System

Students register on your application.

                Student
                   │
                   ▼
            Java Application

Now where should their information be stored?

        Name
        Roll Number
        Mobile Number
        Address
        Course

Can Java Variables store this forever?

        ❌ NO

Reason

Variables exist only while the program is running.
Once the program stops,

                RAM Memory
                      │
                      ▼
                Data Lost

Hence we need

                Permanent Storage
                      │
                      ▼
                  Database

===============================================================================

4. Real Life Example
────────────────────

Think about your Phone.

Inside your Phone

        Contacts
        Photos
        Videos
        WhatsApp Chats

Where are they stored?

Inside Storage.

Similarly,
    Applications store their information inside

                    DATABASE

===============================================================================

5. Types of Databases
─────────────────────

                             Database
                                │
        ┌───────────────────────┼───────────────────────┐
        │                       │                       │
        ▼                       ▼                       ▼
 Relational Database      NoSQL Database         Cloud Database

Examples

--------------- Relational---------------
    MySQL
    Oracle
    PostgreSQL
    SQL Server

--------------- NoSQL ---------------
    MongoDB
    Cassandra

--------------- Cloud ---------------
    Firebase
    DynamoDB

============================================================
For JDBC
    We mainly work with

            Relational Database

===============================================================================

6. What is RDBMS?
─────────────────

An Relational Database Management System (R-D-B-M-S) stores data in the form of Tables (rowa and columns).

Example

    Instead of storing everything together,
    it organizes data into multiple tables.

===============================================================================

7. What is MySQL?
─────────────────

MySQL is an Open Source Relational Database Management System (RDBMS).

It stores data in Tables.

It understands SQL Language.

===============================================================================

8. Database Structure
─────────────────────

                     Company Database
                            │
        ┌───────────────────┼────────────────────┐
        │                   │                    │
        ▼                   ▼                    ▼
   Employee Table      Student Table      Product Table

Database
    ↓
Contains Tables

===============================================================================

9. What is a Table?
───────────────────

A Table stores similar types of data.

Employee Table
+-------+-----------+----------+
│ EmpId │ Name      │ Salary   │
│-------│-----------│----------│
│ 101   │ Rahul     │ 45000    │  ---> entry
│ 102   │ Aman      │ 52000    │
│ 103   │ Neha      │ 61000    │
+-------+-----------+----------+

===============================================================================

10. Row vs Column
─────────────────

Employee Table
+-------+-----------+----------+
│ EmpId │ Name      │ Salary   │
│-------│-----------│----------│
│ 101   │ Rahul     │ 45000    │
│ 102   │ Aman      │ 52000    │
│ 103   │ Neha      │ 61000    │
+-------+-----------+----------+

Columns
    │
    ├───────► EmpId
    ├────────► Name
    └─────────► Salary


----------------------------

Rows
   │
   ├───────► 101 Rahul 45000
   ├────────► 102 Aman 52000
   └─────────► 103 Neha 61000



===============================================================================


11. Primary Key   :   Primary Key is a Column that uniquely identifies every Row.
-------------------------------------------------------------------------------------

Example

Employee Table
+-------+-----------+----------+
│ EmpId │ Name      │ Salary   │
│-------│-----------│----------│   ---------> EmpID (primary key)
│ 101   │ Rahul     │ 45000    │   
│ 102   │ Aman      │ 52000    │
│ 103   │ Neha      │ 61000    │
+-------+-----------+----------+


===============================================================================

14. Interview Questions
───────────────────────

Q1. What is Database?
Answer: An organized collection of related data stored permanently.

------------------------------------------------------------

Q2. What is RDBMS?
Answer: A Database Management System that stores data in Tables.

------------------------------------------------------------

Q3. What is MySQL?
Answer: An Open Source Relational Database Management System.

------------------------------------------------------------

Q4. Difference between Database and Table?

    Database
        ↓
        Collection of Tables.

    Table
        ↓
        Collection of Rows and Columns.

------------------------------------------------------------

Q5. What is Primary Key?
Answer: A Column that uniquely identifies every Row.
*/

