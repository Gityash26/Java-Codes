package file4_PreparedStatement;
/*
╔══════════════════════════════════════════════════════════════════════════════╗
║               Methods of PreparedStatement Interface                         ║
╚══════════════════════════════════════════════════════════════════════════════╝

Previously we discussed  WHY Java introduced the PreparedStatement Interface.
As we are facing overhead of writing same sql queries multiple times. 

In this file, we will learn HOW to use it.


═══════════════════════════════════════════════════════════════════════════════
Step 1 : Creating the PreparedStatement Object
═══════════════════════════════════════════════════════════════════════════════

Before using any method of the PreparedStatement Interface, first we require its Object (reference).

Remember

    PreparedStatement is an Interface.

Hence,

    we cannot create its object directly.

    PreparedStatement pstmt = new PreparedStatement();     ❌ Invalid


So, who creates its Object ?

Answer

The Connection Object provides a method

            prepareStatement()

which internally creates the PreparedStatement Object and returns its reference.


-------------------------------------------------
Internal Working
-------------------------------------------------

                    Connection Object
                           │
                           │ prepareStatement(query)
                           │
                           ▼
               MySQL JDBC Driver (Internally)
                           │
                           │ Creates an Object of its own
                           │ PreparedStatement Implementation Class
                           │
                           ▼
               PreparedStatement Object
                           │
                           │ Reference Returned
                           ▼
              PreparedStatement pstmt



Syntax

PreparedStatement ps = con.prepareStatement(query);

    where,  
            query ---> sql query need to prepared




═══════════════════════════════════════════════════════════════════════════════
Step 2 : Methods provided by PreparedStatement
═══════════════════════════════════════════════════════════════════════════════

==============================================================
prepareStatement(String sql)
──────────────────────────────────────────────────────────────

    => Connection Interface provide this method to returns a 'Object reference' of PreparedStatement.
    => It takes a sql query as parameter that needs to be prepared.
    
Syntax
        PreparedStatement pst = con.prepareStatement(query);


──────────────────────────────────────────────────────────────
setInt(int position, int value)
──────────────────────────────────────────────────────────────

    => This method is used to assign an Integer value to the specified Placeholder.

Syntax
        pst.setInt(position, value);



──────────────────────────────────────────────────────────────
setString(int position, String value)
──────────────────────────────────────────────────────────────

    => This method is used to assign an String value to the specified Placeholder.

Syntax
        pst.setString(position, value);



──────────────────────────────────────────────────────────────
setDouble(int position, double value)
──────────────────────────────────────────────────────────────

    => This method is used to assign a Double value to the specified Placeholder.

Syntax
        pstmt.setDouble(position, value);


        

──────────────────────────────────────────────────────────────
executeUpdate()
──────────────────────────────────────────────────────────────

    => Just like in statement interafec this method is used to execute the Prepared SQL Query.

    => Unlike statement interaface, executeUpdate() does not require the sql query, becasue the
       query was already prepared using prepareStatement() method.

Syntax
    int rowsAffected = pstmt.executeUpdate();




═══════════════════════════════════════════════════════════════════════════════
Program
═══════════════════════════════════════════════════════════════════════════════

*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class p2_preparedStatementMethods
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    private static void createStudentTable(Connection con) throws Exception
    {
        String query =
                        """
                            CREATE TABLE IF NOT EXISTS Student
                            (
                                id INT PRIMARY KEY,
                                name VARCHAR(50),
                                marks DOUBLE
                            )
                        """;

        PreparedStatement pst = con.prepareStatement(query);
        pst.executeUpdate();

        System.out.println("Student table is ready.");
        pst.close();
    }


    private static void insertStudent(Connection con, int id, String name, double marks) throws Exception
    {
        String query =  """
                            INSERT INTO Student
                            VALUES(?, ?, ?)
                        """;

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setDouble(3, marks);

        System.out.println("\nRows Inserted : " + pst.executeUpdate());
        pst.close();
    }


    private static void showStudentTable(Connection con) throws Exception
    {
        String query = "SELECT * FROM Student";

        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        System.out.println("\n========== Student Table ==========");

        while(rs.next())
        {
            System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getDouble("marks"));
        }

        System.out.println("===================================\n");

        rs.close();
        pst.close();
    }


    private static void clearStudentTable(Connection con) throws Exception
    {
        String query = "TRUNCATE TABLE Student";

        PreparedStatement pst = con.prepareStatement(query);
        pst.executeUpdate();
        pst.close();

        System.out.println("Student table cleared successfully.");
    }


    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            createStudentTable(con);

            // inserting data 
            insertStudent(con, 101, "Yash", 95.5);
            insertStudent(con, 102, "Sanjay", 91.5);
            insertStudent(con, 103, "Kunal", 74.1);

            showStudentTable(con);
            clearStudentTable(con);

            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}