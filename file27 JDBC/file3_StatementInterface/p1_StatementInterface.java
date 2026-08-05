/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                     Statement Interface Explained                            ║
╚══════════════════════════════════════════════════════════════════════════════╝


==============================================================================
                        What is Statement?
==============================================================================

Statement is a predefined Interface present inside

                    java.sql package

It is responsible for - 'Sending SQL Queries'

from Java Program
                    to
                         Database.


==============================================================================
            Why do we need Statement ?
==============================================================================

Suppose we already have

        Connection con  -----> reference to Connection Object 

Question: Can Connection execute SQL Queries?
Answer: NO.

    Connection only establishes communication or a bridge.

To send SQL Queries, Connection creates Statement


==============================================================================
                Real Flow
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
      createStatement()
        │
        ▼
Statement
        │
        ▼
       execute SQL Query
        │
        ▼
    Database


==============================================================================
            How do we get Statement Object ?
==============================================================================

Connection Interface provides

        createStatement()    ====> method.

Example

Statement st = con.createStatement();


==============================================================================
        Internally What Happens ?
==============================================================================

Question: Statement is an Interface.
          Then who creates its object?

Exactly like Connection, Database Driver creates its implementation object.


Connection internally asks Driver
        ↓

Driver creates Statement object
        ↓

Returns it as --- "Statement Reference"



==============================================================================
                Visualization
==============================================================================

Connection (which is also a reference)
        │
        ▼
 createStatement()  ---> used this method)
        │
        ▼
      Driver        
        │
        ▼
Statement Implementation Object     
        │
        ▼
Statement Reference              



==============================================================================
            What can Statement do ?  (statement reference object do??)
==============================================================================

Statement Interface mainly provides
------------------------------------------------

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. executeQuery()
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        => Used for SELECT Query.

Returns, ---> ResultSet


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. executeUpdate()
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Used for

        -> INSERT
        -> UPDATE
        -> DELETE
        -> CREATE
        -> DROP
        -> ALTER

Returns
        int  (Number of affected rows)


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
3. execute()
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        => Can execute any SQL Query.

Returns
        boolean




==============================================================================
        Statement does NOT store data
==============================================================================

Many beginners think "Statement" contains database data.

!!!! Wrong !!!!

Statement only sends SQL Query.
Database processes it and returns Result.



==============================================================================
            Real Life Analogy
==============================================================================

Imagine, You are sitting in a Restaurant.

Connection      ==> Telephone Connection

Statement       ==> Talking to Waiter

SQL Query       ==> Food Order

Database        ==> Kitchen

ResultSet       ==> Prepared Food



==============================================================================
                Important Notes (what they do...)
==============================================================================

Connection  ---> Creates Statement

Statement  ---> Sends SQL Query

Database  ---> Executes SQL Query

ResultSet  ---> Returns Data


==============================================================================
                Interview Questions
==============================================================================
/*
==============================================================================
                    JDBC SELF CHECK (P6 - P9)
==============================================================================

Q1. Why do we need a JDBC Driver?
─────────────────────────────────

Answer

Java can only communicate using the JDBC API.

However, every database (MySQL, Oracle, PostgreSQL, etc.)
has its own communication protocol.

The JDBC Driver acts as a translator.

It converts JDBC method calls into database-specific
requests and converts the database response back into
Java objects.

Therefore,

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


==============================================================================
Q2. If a company changes from MySQL to Oracle,
    do we need to rewrite the Java code?
──────────────────────────────────────────────

Answer

No.

One of the biggest advantages of JDBC is

        Database Independence.

Our Java code remains almost the same.

Usually, only the following change:

✔ Database URL
✔ Username
✔ Password
✔ JDBC Driver

The programming approach remains identical because
we always work with JDBC Interfaces such as

Connection

Statement

ResultSet


==============================================================================
Q3. Why is Connection an Interface instead of a Class?
──────────────────────────────────────────────────────

Answer

Java should not be dependent on any particular database.

If Connection were a class,

we would need different classes like

MysqlConnection

OracleConnection

PostgresConnection

Instead,

Java provides a common interface

                Connection

Each database driver internally creates its own
implementation object and returns it as a

Connection reference.

This provides

        Abstraction

and

        Database Independence.


==============================================================================
Q4. Explain the complete JDBC Flow.
───────────────────────────────────

Answer

Java Program

        │

        ▼

DriverManager

        │

        ▼

Connection

        │

createStatement()

        │

        ▼

Statement

        │

execute SQL Query

        │

        ▼

Database

        │

        ▼

ResultSet (if SELECT)


==============================================================================

Q5. Who actually creates the Connection Object?
───────────────────────────────────────────────

Answer

DriverManager.getConnection(...)

returns the Connection reference.

However,

the actual Connection object is internally created
by the JDBC Driver of the corresponding database.


==============================================================================

Q6. Who creates the Statement Object?
─────────────────────────────────────

Answer

Statement objects are obtained using

Connection.createStatement()

Internally,

the Connection requests the database driver
to create the Statement implementation object
and returns it as a Statement reference.


==============================================================================

Q7. Difference between DriverManager and Connection?
────────────────────────────────────────────────────

DriverManager

→ A predefined Utility Class.

→ Responsible for establishing the database connection.

→ Provides the static getConnection() method.


Connection

→ A predefined Interface.

→ Represents an active connection between Java
  and the Database.

→ Used to create Statement and PreparedStatement objects.


==============================================================================

Q8. Can Connection execute SQL Queries?
───────────────────────────────────────

Answer

No.

Connection only maintains communication
with the database.

SQL Queries are executed using

        Statement

or

        PreparedStatement.


==============================================================================

Q9. Why can't we write

        new Connection();

or

        new Statement();

──────────────────────────────────────────────

Answer

Because both Connection and Statement
are Interfaces.

Interfaces cannot be instantiated directly.

Their implementation objects are created internally
by the JDBC Driver.


==============================================================================

Q10. What happens if the JDBC Driver JAR is removed?
────────────────────────────────────────────────────

Answer

Without the JDBC Driver,

DriverManager cannot find any suitable driver
to establish communication with the database.

Therefore,

Java Program

        │

        ▼

DriverManager

        │

        ✖

No Suitable Driver Found

        │

Connection cannot be established.

Typical Exception

java.sql.SQLException:
No suitable driver found


==============================================================================

Q11. Explain this line in your own words.

Connection con =
DriverManager.getConnection(URL, USERNAME, PASSWORD);

──────────────────────────────────────────────────────

Answer

This statement establishes communication between
the Java application and the database.

Connection
        ↓
Reference type (Interface)

con
        ↓
Reference Variable

DriverManager
        ↓
Utility Class

getConnection(...)
        ↓
Static Method

(URL, USERNAME, PASSWORD)
        ↓
Authentication details required to connect
to the database.

If authentication succeeds,

the database driver creates a Connection object
and returns its reference, which is stored inside

        con.

==============================================================================

*/
