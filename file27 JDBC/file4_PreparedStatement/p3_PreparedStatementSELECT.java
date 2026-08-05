package file4_PreparedStatement;

/*

╔~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╗
║                SELECT Query using PreparedStatement                         ║
╚~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~╝

Till now, we used PreparedStatement to execute INSERT queries.

In this file, we will learn how to execute a SELECT Query using the PreparedStatement Interface.



═══════════════════════════════════════════════════════════════════════════════
SELECT Query with Placeholder
═══════════════════════════════════════════════════════════════════════════════

Statement Interface
----------------------------------------------------
    SELECT * FROM Student WHERE id = 101;


PreparedStatement Interface
----------------------------------------------------
    SELECT * FROM Student WHERE id = ?;


The Placeholder (?) makes the Query reusable.
We only need to change its value using the Setter Methods.



═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═
Methods Used
═══════════════════════════════════════════════════════════════════════════════

============================================
1. prepareStatement(String sql)
============================================
    => The methods is used to prepare your sql query.
    => Returns the PreparedStatement Object.

============================================
2. executeQuery()
============================================
    => This methods is used to executes the Prepared 'SELECT' Query.
    Return Type -> ResultSet

-> We can read the data using

        next()
        getInt()
        getString()
        getDouble()



═══════════════════════════════════════════════════════════════════════════════
Program
═══════════════════════════════════════════════════════════════════════════════

*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class p3_PreparedStatementSELECT
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
        pst.close();
    }


    private static void insertStudent(Connection con, int id, String name, double marks) throws Exception
    {
        String query =  """
                            INSERT INTO Student
                            VALUES(?, ?, ?)
                        """;

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setDouble(3,marks);

        pst.executeUpdate();

        pst.close();
    }


    private static void searchStudent(Connection con,int id) throws Exception
    {
        String query = "SELECT * FROM Student WHERE id = ?";

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1,id);

        ResultSet rs = pst.executeQuery();

        System.out.println("\nSearching Student...\n");

        if(rs.next())
        {
            System.out.println("Id    : " + rs.getInt("id"));
            System.out.println("Name  : " + rs.getString("name"));
            System.out.println("Marks : " + rs.getDouble("marks"));
        }
        else
        {
            System.out.println("Student Not Found.");
        }

        rs.close();
        pst.close();
    }


    private static void clearStudentTable(Connection con) throws Exception
    {
        PreparedStatement pst = con.prepareStatement("TRUNCATE TABLE Student");
        pst.executeUpdate();
        pst.close();
    }


    public static void main(String[] args)
    {
        try
        {
            Connection con =
                    DriverManager.getConnection(URL,USERNAME,PASSWORD);

            createStudentTable(con);

            insertStudent(con,101,"Yash",95.5);
            insertStudent(con,102,"Rahul",88.0);
            insertStudent(con,103,"Aman",79.5);

            searchStudent(con,102);

            clearStudentTable(con);

            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}