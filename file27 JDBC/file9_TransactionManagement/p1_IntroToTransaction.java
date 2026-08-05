/*
═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
                Introduction to Transaction Management
══════════════════════════════════════════════════════════════════════

=> Till now, every SQL Query executed independently.

Example,

        stmt.executeUpdate(Query 1);
        stmt.executeUpdate(Query 2);
        stmt.executeUpdate(Query 3);


If Query 2 fails,

Query 1 has already been executed and cannot be undone.
This may lead to inconsistent data inside the database.


------------------------------------------------
Real Life Example
------------------------------------------------

Suppose,

Yash transfers ₹5000 to Aman.

Steps

    1. Deduct ₹5000 from Yash's Account.

    2. Add ₹5000 to Aman's Account.


Case 1
============================================================
    Both operations are completed successfully.
    ✔ Money Transferred Successfully.



Case 2
============================================================

    Money is deducted from Yash's account,
    but before adding it to Aman, the application crashes.

Result

    ❌ Yash loses ₹5000.
    ❌ Aman never receives the money.
    ❌ Database becomes inconsistent.


To avoid such situations, Database executes related SQL queries as a single unit 
called a Transaction.


Visual Representation
------------------------------------------------

        Begin Transaction
                │
                ▼
          SQL Query 1
                │
                ▼
          SQL Query 2
                │
                ▼
          SQL Query 3
                │
        ┌───────────────┐
        │               │
        ▼               ▼
    commit()      rollback()
        │               │
        ▼               ▼
 Save Changes      Undo Changes



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Important Terms
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Transaction
===================================
    A group of related SQL queries executed as one logical unit.


2. commit()
===================================
    Permanently saves all changes made during the current Transaction.


3. rollback()
===================================
    Cancels every change made during the current Transaction.


4. Auto Commit
===================================
    By default, JDBC automatically commits every SQL query immediately after 
    successful execution.

That means,
    Every executeUpdate() becomes an individual Transaction.



5. Manual Commit
===================================
    Auto Commit can be disabled.

Then,
    multiple SQL queries become part of one Transaction.

The programmer decides whether to

            commit()
                        or
                                rollback()



======================================================
Visual Comparison
======================================================

Default Behaviour
-------------------------------------------

          Query 1
            │
            commit()

        Query 2
            │
            commit()

        Query 3
            │
            commit()


Manual Transaction
-------------------------------------------

    setAutoCommit(false)
        │
    Query 1
        │
    Query 2
        │
    Query 3
        │
------------------------------------
    commit() or rollback()
------------------------------------



Observation
==================================================
Transaction Management ensures that either

✔ Every SQL Query executes successfully.
or
✔ None of them are applied.

There is no partial execution.

══════════════════════════════════════════════════════════════════════
*/




package file9_TransactionManagement;

