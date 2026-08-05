/*

                                statement methods
                    ____________________|_________________________________
                   |                    |                                |
            executeQuery()         executeUpdate()                   execute()





╔══════════════════════════════════════════════════════════════════════════════╗
║                         execute() Method                                     ║
╚══════════════════════════════════════════════════════════════════════════════╝

The execute() method is the third method of the Statement Interface.

It is capable of executing ANY SQL query.

        ✔ SELECT
        ✔ INSERT
        ✔ UPDATE
        ✔ DELETE
        ✔ CREATE
        ✔ ALTER
        ✔ DROP

Return Type

        boolean


Return Value

true
    -> if the executed query returns a ResultSet
       (generally SELECT)

false
    -> if the executed query does not return a ResultSet
       (INSERT, UPDATE, DELETE, CREATE, ALTER, DROP)


Current Goal

In this program we will execute a SELECT query using execute() and observe its return value.

*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P5_Execute_Method
{
    public static void main(String[] args)
    {
        String URL = "jdbc:mysql://localhost:3306/Company";
        String USERNAME = "root";
        String PASSWORD = "12345";

        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement stmt = con.createStatement();

            boolean hasResultSet = stmt.execute("SELECT * FROM Student");
            System.out.println("Returned : " + hasResultSet);

            if(hasResultSet)
            {
                ResultSet rs = stmt.getResultSet();

                while(rs.next())
                {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("marks"));
                }

                rs.close();
            }

            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}