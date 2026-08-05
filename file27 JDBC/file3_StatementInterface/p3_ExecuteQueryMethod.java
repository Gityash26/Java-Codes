
/*

                methods of statement
                         │
      ┌──────────────────┴──────────────────┐
      │                                     │
      ▼                                     ▼
executeQuery() <-                     executeUpdate()
      │                                     │
      ▼                                     ▼
   (SELECT)                        (INSERT/UPDATE/DELETE/DDL)

      
      
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
║                executeQuery() method                                ║
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~

-> The executeQuery() method provided by the statement interface, that is used to execute the 
   SELECT sql query only. 
   
-> ReturnType :  ResultSet object


~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
What is ResultSet
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
=> The ResultSet is a predefined interface present in the java.sql package.

=> ResultSet stores the rows returned by the
        executeUpdate() 

=> But it does not prints the record automatically, instead To access those rows, 
   ResultSet provides several methods... 



==============================================================================
                Internal Working of ResultSet
==============================================================================

Suppose Database returns

Employee table
+-----+---------+----------+
| id  | name    | salary   |
+-----+---------+----------+
|101  | Yash    | 55000    |
|102  | Rahul   | 42000    |
|103  | Aman    | 61000    |
+-----+---------+----------+

These rows are stored inside

                ResultSet

Where, the ResultSet Cursor was positioned before the first row and to read the first row
we have to use the...

                next() method


~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
                    methods of ResultSet
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~

----------------------------------
1. next()
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
This method move the cursor to the next row.

returns (boolean) 

    true  : if another row exist
    false : if no more next rows exist  



----------------------------------
2. getInt(column_Name)
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~

This method is is used to read the Integer data only.
example: 

    resultSet.getInt("id");



----------------------------------
3. getString(column_Name)
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~

This method is is used to read the String data only.
example: 

    resultSet.getString("name");



----------------------------------
4. getDouble(column_Name)
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~

This method is is used to read the decimal data only.
example: 

    resultSet.getDouble("salary");



----------------------------------
5. getBoolean(column_Name)
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~

This method is is used to read the boolean data only.
example: 

    resultSet.getBoolean("");



----------------------------------
6. getDate(column_Name)
~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~

This method is is used to read the sql data only.
example: 

    resultSet.getDate("date");



==============================================================================
Important Notes
==============================================================================

    ✔ executeQuery() only executes SELECT queries.
    ✔ ResultSet stores the returned records.
    ✔ next() moves the cursor to the next row.
    ✔ get---() methods read values from the current row.
    ✔ Without calling next(), no row can be accessed.



Note: Since, till now we just have a preExist database (Compony) and we are not learn the executeUpdate() method yet
      so, externally we are already execute the Employee table creation (query) in teh workbench okay.  


*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class p3_ExecuteQueryMethod
{
    public static void main(String[] args)
    {
        String URL = "jdbc:mysql://localhost:3306/Company";
        String USERNAME = "root";
        String PASSWORD = "12345";

        try
        {
            // creating connection with the database 
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // creating statement object using connection 
            Statement stmt = con.createStatement();

            // fetching data from the database 
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM Employee");


            // Trying to display the ResultSet ----- using its methods 
            System.out.println("Employee Table Records");
            System.out.println("--------------------------------------");

            while(resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");

                System.out.println(id + "  " + name + "  " + salary);
            }

            // closing all the database connections (must remember...)
            resultSet.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}