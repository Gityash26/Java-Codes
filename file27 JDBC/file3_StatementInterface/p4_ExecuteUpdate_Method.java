
/*

╔══════════════════════════════════════════════════════════════════════════════╗
║                     executeUpdate() Method                                  ║
╚══════════════════════════════════════════════════════════════════════════════╝

The executeUpdate() method is provided by the Statement Interface.

It is used to execute SQL queries that MODIFY the database.

        ✔ CREATE
        ✔ INSERT
        ✔ UPDATE
        ✔ DELETE
        ✔ ALTER
        ✔ DROP

Return Type

        int ---- (Number of affected rows)

Current Goal

In this file we will understand how the same executeUpdate() method can execute different SQL queries.

*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class p4_ExecuteUpdate_Method
{

    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    private static void createStudentTable(Statement stmt) throws SQLException
    {
        String query = """
                            CREATE TABLE IF NOT EXISTS Student
                            (
                                id INT PRIMARY KEY,
                                name VARCHAR(50),
                                marks DOUBLE
                            )
                        """;

        stmt.executeUpdate(query);
        System.out.println("Student table created (if not exists).");
    }


    private static void insertStudents(Statement stmt) throws SQLException
    {
        String query = """
                            INSERT INTO Student (id, name, marks)
                            VALUES
                                (101, 'Yash', 95),
                                (102, 'Aman', 88),
                                (103, 'Neha', 91),
                                (104, 'Rahul', 76)
                            ON DUPLICATE KEY UPDATE
                            name = VALUES(name),
                            marks = VALUES(marks)
                        """;

        int rows = stmt.executeUpdate(query);
        System.out.println("Rows Inserted/Updated : " + rows);
    }


    private static void updateStudentMarks(Statement stmt) throws SQLException
    {
        String query = "UPDATE Student SET marks = 99 WHERE id = 101";

        int rows = stmt.executeUpdate(query);
        System.out.println("Rows Updated : " + rows);
    }


    private static void deleteStudent(Statement stmt) throws SQLException
    {
        String query = "DELETE FROM Student WHERE id = 104";

        int rows = stmt.executeUpdate(query);
        System.out.println("Rows Deleted : " + rows);
    }


    private static void alterStudentTable(Statement stmt) throws SQLException
    {
        try
        {
            String query =
                    "ALTER TABLE Student ADD COLUMN city VARCHAR(50)";

            stmt.executeUpdate(query);

            System.out.println("Student table altered.");
        }
        catch(SQLException e)
        {
            System.out.println("Column already exists, skipping ALTER.");
        }
    }


    private static void dropStudentTable(Statement stmt) throws SQLException
    {
        String query =
                "DROP TABLE IF EXISTS Student";

        stmt.executeUpdate(query);

        System.out.println("Student table dropped.");
    }


    private static void showTable(Statement stmt, String tableName)
    {
        String query = "SELECT * FROM " + tableName;

        try(ResultSet rs = stmt.executeQuery(query))
        {
            System.out.println("\n------ Data in " + tableName + " ------");

            int columnCount = rs.getMetaData().getColumnCount();

            while(rs.next())
            {
                for(int i = 1; i <= columnCount; i++)
                {
                    System.out.print(
                            rs.getMetaData().getColumnName(i)
                            + "="
                            + rs.getString(i)
                            + "    ");
                }

                System.out.println();
            }

            System.out.println("-----------------------------------------\n");
        }
        catch(SQLException e)
        {
            System.out.println("Cannot display table " + tableName +
                               " (table may not exist).");
        }
    }


    public static void main(String[] args)
    {
        try
        {
            Connection con =
                    DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement stmt =
                    con.createStatement();


            
            //   1. CREATE TABLE
            // ==========================================================

            createStudentTable(stmt);
            showTable(stmt, "Student");


            //   2. INSERT RECORDS
            // ==========================================================

            insertStudents(stmt);
            showTable(stmt, "Student");


            // 3. UPDATE RECORD
            // ==========================================================

            updateStudentMarks(stmt);
            showTable(stmt, "Student");


            // 4. DELETE RECORD
            // ==========================================================

            deleteStudent(stmt);
            showTable(stmt, "Student");


            // 5. ALTER TABLE
            // ==========================================================

            alterStudentTable(stmt);
            showTable(stmt, "Student");


            // 6. DROP TABLE
            // ==========================================================

            dropStudentTable(stmt);
            showTable(stmt, "Student");


            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}