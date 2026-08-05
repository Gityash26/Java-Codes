/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                 How to create DatabaseMetaData object ?                      ║
╚══════════════════════════════════════════════════════════════════════════════╝

Step 1: Create Connection

        Connection con = DriverManager.getConnection(...);


Step 2: Call getMetaData() method using Connection Object.

            DatabaseMetaData dbmd = con.getMetaData();

            
That's it Now Java can communicate with DatabaseMetaData.


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 Commonly Used Methods
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

┌═════════════════════════════════════════════════════════════════════════════┐
│ Method                                   │ Returns                          │
├══════════════════════════════════════════┼══════════════════════════════════┤
│ getDatabaseProductName()                 │ MySQL                            │
├──────────────────────────────────────────┼──────────────────────────────────┤
│ getDatabaseProductVersion()              │ Database Version                 │
├──────────────────────────────────────────┼──────────────────────────────────┤
│ getDriverName()                          │ JDBC Driver Name                 │
├──────────────────────────────────────────┼──────────────────────────────────┤
│ getDriverVersion()                       │ JDBC Driver Version              │
├──────────────────────────────────────────┼──────────────────────────────────┤
│ getUserName()                            │ Current Username                 │
├──────────────────────────────────────────┼──────────────────────────────────┤
│ getURL()                                 │ Connected Database URL           │
├──────────────────────────────────────────┼──────────────────────────────────┤
│ getJDBCMajorVersion()                    │ Major JDBC Version               │
├──────────────────────────────────────────┼──────────────────────────────────┤
│ getJDBCMinorVersion()                    │ Minor JDBC Version               │
└═════════════════════════════════════════════════════════════════════════════┘




━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
💻 Program
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
*/

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class p2_DatabaseMetaData
{
    private static final String URL = "jdbc:mysql://localhost:3306/Company";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            DatabaseMetaData dbmd = con.getMetaData();

            System.out.println("\n══════════════════════════════════════════════════════");
            System.out.println("          DATABASE INFORMATION");
            System.out.println("══════════════════════════════════════════════════════");

            System.out.println("Database Product Name : " + dbmd.getDatabaseProductName());
            System.out.println("Database Version      : " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver Name           : " + dbmd.getDriverName());
            System.out.println("Driver Version        : " + dbmd.getDriverVersion());
            System.out.println("Username              : " + dbmd.getUserName());
            System.out.println("Database URL          : " + dbmd.getURL());
            System.out.println("JDBC Major Version    : " + dbmd.getJDBCMajorVersion());
            System.out.println("JDBC Minor Version    : " + dbmd.getJDBCMinorVersion());
            System.out.println("══════════════════════════════════════════════════════");

            con.close();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

