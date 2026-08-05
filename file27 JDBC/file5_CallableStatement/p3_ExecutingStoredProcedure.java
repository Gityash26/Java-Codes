/*

╔═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╗
║              Executing Stored Procedure using CallableStatement             ║
╚═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═╝

In the previous file we understood what a Stored Procedure is and how it can be 
created inside the Database.

Question is...
        How can a Java Program execute that Stored Procedure ?

Answer
    Java uses the CallableStatement Interface.



==============================================================================
Internal Flow
==============================================================================


             Database
     ┌──────────────────────┐
     │ Procedure            │
     │      getStudents()   │
     └──────────────────────┘
                ▲
                │
         CALL getStudents()
                ▲
                │
      CallableStatement Object
                ▲
                │
         prepareCall()
                ▲
                │
        Connection Object
                ▲
                │
           Java Program



==============================================================================
Creating CallableStatement Object
==============================================================================

Step 1 : Connection Object already exists.

            Connection con


Step 2 : Ask Connection Object to prepare a Procedure Call.

            CallableStatement cst = con.prepareCall("{call getStudents()}");


Step 3 : Internally Connection Object creates a CallableStatement Object and returns its 
         Reference.



==============================================================================
Methods Used
==============================================================================

=========================================
prepareCall()
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
    => Connection Interface provides this method to create and returns the 
       CallableStatement object reference for StoredProcedure.



=========================================
execute()
=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~
    => CallableStatement Interface use this method to execute Stored Procedure




==============================================================================
--------------------- Important note -----------------------------------------
==============================================================================

CallableStatement is a Child Interface of PreparedStatement.

Therefore, it inherits all the methods of PreparedStatement.

For example

        executeQuery()
        executeUpdate()
        execute()

can also be used through the CallableStatement Object, depending upon what the Stored Procedure returns.


==============================================================================
Program
==============================================================================

*/


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class p3_ExecutingStoredProcedure
{
    private static final String URL = "jdbc:mysql://localhost:3306/College";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    private static void showStudentTable(ResultSet rs) throws Exception
    {
        System.out.println("\n========== Student Table ==========\n");

        while(rs.next())
        {
            System.out.println(
                    rs.getInt("id") + "\t"
                  + rs.getString("name") + "\t"
                  + rs.getDouble("marks"));
        }

        System.out.println("\n===================================\n");
    }


    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            CallableStatement cst = con.prepareCall("{CALL getStudents()}");


            ResultSet rs = cst.executeQuery();
            showStudentTable(rs);

            rs.close();
            cst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}