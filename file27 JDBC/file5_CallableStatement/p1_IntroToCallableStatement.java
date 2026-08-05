/*

╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                   Introduction to CallableStatement                         ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝


Till now we learnt how to execute SQL Queries using...


┌────────────────────┐
│     Statement      │ ─────► Write SQL Query every time.
└────────────────────┘

┌────────────────────┐
│ PreparedStatement  │ ─────► Prepare SQL Query once and change only values.
└────────────────────┘


Suppose a University has One Database and Three Java Applications.


                         UNIVERSITY

                  ┌───────────────────┐
                  │     Database      │
                  └───────────────────┘
                            ▲
                            │
     ┌──────────────────────┼────────────────────────┐
     │                      │                        │
     ▼                      ▼                        ▼

 Student App          Librarian App             Admin App



All three Applications perform one common task.

                    "Issue a Book"

To Issue a Book, Database has to perform


        Check Student Exists
                │
                ▼
        Check Book Exists
                │
                ▼
        Check Book Available
                │
                ▼
        Reduce Book Quantity
                │
                ▼
        Create Issue Entry
                │
                ▼
        Return Success



Now think...
Should every Java Application write the same SQL Logic ?


        Student App
                │
                ▼
      Same SQL Statements


        Librarian App
                │
                ▼
      Same SQL Statements


        Admin App
                │
                ▼
      Same SQL Statements


Problem

        ✔ SQL Logic Repeated

        ✔ Difficult to Maintain

        ✔ If Logic Changes,
          Every Application must be Modified.




==============================================================================
Better Solution
==============================================================================

Instead of storing SQL Logic inside every Java Program, Store the SQL Logic only 
once inside the Database.


                    DATABASE
        ┌────────────────────────────────┐
        │                                │
        │ Procedure : issueBook()        │
        │                                │
        │ ✔ Check Student                │
        │ ✔ Check Book                   │
        │ ✔ Update Quantity              │
        │ ✔ Insert Record                │
        │ ✔ Return Status                │
        │                                │
        └────────────────────────────────┘



Now Every Java Application simply calls

                issueBook()

instead of writing hundreds of SQL Statements.


----------------------------------------------------------------------------
Ques: How to call out the stored porcedure stored insider the database 
----------------------------------------------------------------------------
Ans: CallableStatement 

Statement -----------> PreparedStatment ----------------> CallableStatement 


╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║                      What is CallableStatement ?                            ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

=> CallableStatement is an Interface provided in the java.sql package.

=> It is used to execute Stored Procedures already present inside the Database.

Unlike Statement and PreparedStatement,
it does not execute SQL Queries written by Java program.

Instead,

        Java simply calls the Stored Procedure and the Database executes all the 
        SQL Logic internally.


]

==============================================================================
Internally What Happens ?
==============================================================================

Step 1 : Java Program wants to execute a Stored Procedure.

                Java Program
                      │
                      ▼
                "I need to call issueBook()"



Step 2 : Java cannot communicate with the Stored Procedure directly.
        So, It first asks the Connection Object to create a -----> CallableStatement Object.

            con.prepareCall("{call issueBook()}")



Step 3 : The prepareCall() method creates (internally) a CallableStatement Object and returns its Reference.

        CallableStatement callStmt = <-------- returned reference object 



Step 4 : Now the Java Program uses the CallableStatement Object to execute the Stored Procedure.


          CallableStatement Object
                      │
                      ▼
          execute() / executeQuery()
                      │
                      ▼
              CALL issueBook()



Step 5 : The Database receives the Procedure Call.
        The Stored Procedure executes all the SQL Logic already stored inside the Database.


                Database
                      │
                      ▼
          Stored Procedure issueBook()
                      │
                      ▼
                      ---------------------------
                      │ Check Student           │    
                      │ Check Book              │
                      │ Update Quantity         │
                      │ Insert Record           │
                      │ Return Result           │
                      │_________________________│
                      


Step 6 : Finally, the Result is returned back to the Java Program.

        


╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║              Creating CallableStatement Object                              ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

Syntax
        CallableStatement cs = con.prepareCall("{call issueBook()}");


where, 

┌──────────────────────┐
│ prepareCall()        │
└──────────────────────┘
        │
        └──► Method of Connection Interface


┌───────────────────────────────┐
│ {call issueBook()}            │
└───────────────────────────────┘
        │
        └──► Stored Procedure Call




==============================================================================
Main Motive
==============================================================================

                    BEFORE
---------------------------------------------------------------------

        Java Program
                │
                └──►SQL Logic (statement/preparedStatement)
                        │
                        └──► Database



                    AFTER
---------------------------------------------------------------------

        Java Program
                │
                └──► CallableStatement   __________________
                                │       │                 │
                                └────►  │Stored Procedure │
                                        │        │        │
                                        │    Database     │
                                        │_________________│


Result
        ✔ SQL Logic written only once.
        ✔ Easy Maintenance.
        ✔ Better Reusability.
        ✔ Cleaner Java Code.


Note: In this next file we would learn how to create that 'StoredProcedure'

==============================================================================
*/