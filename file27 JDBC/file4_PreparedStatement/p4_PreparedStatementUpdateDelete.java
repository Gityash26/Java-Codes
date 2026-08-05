package file4_PreparedStatement;
/* 
╔══════════════════════════════════════════════════════════════════════════════╗
║           UPDATE and DELETE using PreparedStatement                          ║
╚══════════════════════════════════════════════════════════════════════════════╝

we already covered......

    ✔ INSERT using PreparedStatement
    ✔ SELECT using PreparedStatement

In this file, we will learn

    ✔ UPDATE
    ✔ DELETE       ------ using Placeholders (?).



═══════════════════════════════════════════════════════════════════════════════
UPDATE Query
═══════════════════════════════════════════════════════════════════════════════

Purpose
        -> Used to modify the existing records in the Database.

General SQL Syntax

    UPDATE table_name
    SET column_name = ?
    WHERE condition = ?;


Example

    UPDATE Student
    SET marks = ?
    WHERE id = ?;



═══════════════════════════════════════════════════════════════════════════════
DELETE Query
═══════════════════════════════════════════════════════════════════════════════

Purpose 
        -> Used to remove existing records from the Database.


General SQL Syntax

    DELETE FROM table_name
    WHERE condition = ?;


Example

    DELETE FROM Student
    WHERE id = ?;


*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class p4_PreparedStatementUpdateDelete
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


    private static void updateStudentMarks(Connection con, int id, double newMarks) throws Exception
    {
        String query =  """ 
                            UPDATE Student
                            SET marks = ?
                            WHERE id = ?
                        """;

        PreparedStatement pst = con.prepareStatement(query);

        pst.setDouble(1,newMarks);
        pst.setInt(2,id);

        int rowsAffected = pst.executeUpdate();
        System.out.println("\nRows Updated : " + rowsAffected);
        pst.close();
    }


    private static void deleteStudent(Connection con, int id) throws Exception
    {
        String query = """
                            DELETE FROM Student
                            WHERE id = ?
                        """;

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1,id);
        int rowsAffected = pst.executeUpdate();
        System.out.println("\nRows Deleted : " + rowsAffected);
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
        PreparedStatement pst = con.prepareStatement("TRUNCATE TABLE Student");
        pst.executeUpdate();
        pst.close();
    }


    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            createStudentTable(con);

            insertStudent(con,101,"Yash",95.5);
            insertStudent(con,102,"Rahul",88.0);
            insertStudent(con,103,"Aman",79.5);

            System.out.println("Initial Table");
            showStudentTable(con);


            updateStudentMarks(con,102,91.5);

            System.out.println("After UPDATE");
            showStudentTable(con);


            deleteStudent(con,103);

            System.out.println("After DELETE");
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
