package file4_PreparedStatement;
/*
╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                     B-A-T-C-H Processing                                    ║
╚~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╝

=> As the name suggest something is to be process in a batch not single. 

So, Till now, we learnt how to insert records using

    PreparedStatement
            │
            ├───────────────--- executeUpdate()
            └─────────────────------ executeQuery()

=> After reducing the overhead of writing same sql queries multiple times 

But...

What if we need to insert

                1000 Students ?

Should we call executeUpdate() 1000 Times ? 
(It means database were requested 1000 times for insertion operation)
------- 1
------- 2
--------
-------- n (1000)



==============================================================================
Problem
==============================================================================

Suppose our Database is initially Empty.


        Student Table
        ┌──────┬────────────┬─────────┐
        │ Id   │ Name       │ Marks   │
        ├──────┼────────────┼─────────┤
        │      │            │         │
        └──────┴────────────┴─────────┘


Now,

1000 New Students take Admission.
We need to Insert all of them into Database.


==============================================================================
Normal Approach
==============================================================================

    Student 1
        │________ executeUpdate()
                        │
                        ▼
                     Database

    Student 2
        │________ executeUpdate()
                        │
                        ▼
                     Database
                        .
                        .
                        .
    Student  1000
        │________ executeUpdate()
                        │
                        ▼
                     Database



Result

        ✔ 1000 Separate Database Requests
        ✔ More Network Communication
        ✔ More Time
        ✔ Poor Performance


==============================================================================
Real Life Example
==============================================================================

Imagine you are a Courier Boy.

You have to Deliver

        Parcel 1
        Parcel 2
        Parcel 3 ... Parcel 1000



Method 1
----------------------------
Take One Parcel
        ▼
        Go to Customer
        ▼
        Come Back
        ▼
Take Next Parcel
        ▼
        Go Again
        ▼
        Come Back

Repeat... 1000 Times.



Question: Is this Efficient ?  ------ NO.


==============================================================================
Better Solution
==============================================================================

Collect Every Parcel First.

        Parcel 1
        Parcel 2
        Parcel 3
        ... Parcel1000
                │
                ▼
        Store Inside Truck
                │
                ▼
      Deliver Everything Together


    ---------------------------------
    Same Idea used in JDBC.
    ---------------------------------



==============================================================================
Batch Processing
==============================================================================

                Student 1
                Student 2
                Student 3
                Student 4
                Student 5
                     │
                     ▼
                 addBatch()
                     │
                     ▼

            ┌────────────────────┐
            │   Batch Memory     │
            │                    │
            │ Student 1          │
            │ Student 2          │
            │ Student 3          │
            │ Student 4          │
            │ Student 5          │
            └────────────────────┘
                     │
                     ▼

               executeBatch()
                     │
                     ▼
                 Database  (insert)


Result

        ✔ Only One Database Request
        ✔ Less Communication
        ✔ Faster Execution
        ✔ Better Performance



╔══════════════════════════════════════════════════════════════════════════════╗
║                     Methods used in Batch Processing                         ║
╚══════════════════════════════════════════════════════════════════════════════╝


═~═~═~═~═~═~═~~═~~~═~═
 addBatch() 
═~═~═~═~═~═~═~~═~~~═~═
    -> Stores the Current SQL Query inside Batch Memory.
    -> It DOES NOT execute the Query.

Before
        Batch Memory
        ┌──────────────┐
        │              │
        └──────────────┘

After
        Batch Memory
        ┌──────────────┐
        │ Student 101  │
        └──────────────┘


------------------------------------------------------------------------------

═~═~═~═~═~═~═~~═~~~═~═
 executeBatch() 
═~═~═~═~═~═~═~~═~~~═~═
    -> Executes Every Query stored inside Batch Memory.

Flow

    -----------------------------
        Batch Memory
    -----------------------------
        Student 101
        Student 102
        Student 103
    -----------------------------
                │
                ▼
          executeBatch()
                │
                ▼
             Database


Return Type

            int[]

Because, Each Executed Query returns its own Affected Rows Count.


Example

Student101     --->     1
Student102     --->     1
Student103     --->     1

Returned Array [1,1,1]



------------------------------------------------------------------------------

═~═~═~═~═~═~═~~═~~~═~═
clearBatch()
═~═~═~═~═~═~═~~═~~~═~═
    -> Removes Every Stored Query from Batch Memory.
    -> No Query is Executed.

Before
    Student101
    Student102
    Student103

After
    Batch Memory Empty.


==============================================================================
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class p5_BatchProcessing
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    private static void createStudentTable(Connection con) throws Exception
    {
        String query =  """
                            CREATE TABLE IF NOT EXISTS Student
                            (   
                                id INT PRIMARY KEY,
                                name VARCHAR(50),
                                marks DOUBLE
                            )
                        """;

        PreparedStatement pst = con.prepareStatement(query);

        pst.executeUpdate();
        pst.close();
        System.out.println("Student Table Ready.");
    }


    private static void addStudentToBatch(PreparedStatement pst, int id, String name, double marks) throws Exception
    {
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setDouble(3, marks);

        pst.addBatch();
        System.out.println("Student Added To Batch : " + id);
    }


    private static void executeStudentBatch(PreparedStatement pst) throws Exception
    {
        int result[] = pst.executeBatch();
        System.out.println("\nBatch Executed Successfully.");
        System.out.println("Rows Affected : ");

        for(int rows : result)
        {
            System.out.print(rows + " ");
        }
        System.out.println("\n");
    }


    private static void showStudentTable(Connection con) throws Exception
    {
        PreparedStatement pst = con.prepareStatement("SELECT * FROM Student");

        ResultSet rs = pst.executeQuery();

        System.out.println("\n========== Student Table ==========");

        while(rs.next())
        {
            System.out.println(
                    rs.getInt("id") + "\t"
                  + rs.getString("name") + "\t"
                  + rs.getDouble("marks"));
        }

        System.out.println("===================================\n");

        rs.close();
        pst.close();
    }


    private static void clearStudentTable(Connection con) throws Exception
    {
        PreparedStatement pst = con.prepareStatement("TRUNCATE TABLE Student");
        pst.executeUpdate();
        pst.close();
        System.out.println("Student Table Cleared.");
    }



    public static void main(String[] args)
    {
        String query = """
                            INSERT INTO Student
                            VALUES(?, ?, ?)
                        """;

        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            createStudentTable(con);
            PreparedStatement pst = con.prepareStatement(query);

            // creating a batch  
            addStudentToBatch(pst,101,"Yash",95.5);
            addStudentToBatch(pst,102,"Rahul",88.0);
            addStudentToBatch(pst,103,"Aman",79.5);
            addStudentToBatch(pst,104,"Neha",91.0);
            addStudentToBatch(pst,105,"Rohit",85.0);

            // Insert entire batch at once 
            executeStudentBatch(pst);

            showStudentTable(con);

            clearStudentTable(con);

            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}