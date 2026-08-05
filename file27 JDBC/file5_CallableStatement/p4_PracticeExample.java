import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class p4_PracticeExample
{
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";


    // ----------------------------------------------------------
    // Create Database + Table + Clear old data
    // ----------------------------------------------------------
    private static void createShoppingList(Connection con) throws Exception
    {
        Statement stmt = con.createStatement();

        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS Shop");
        stmt.executeUpdate("USE Shop");

        stmt.executeUpdate(
                            """
                                CREATE TABLE IF NOT EXISTS ShoppingList
                                (
                                    serial_no INT AUTO_INCREMENT PRIMARY KEY,
                                    item VARCHAR(100)
                                )
                            """);

        stmt.executeUpdate("TRUNCATE TABLE ShoppingList");

        createInsertProcedure(stmt);
        createDisplayProcedure(stmt);
        
        stmt.close();
        System.out.println("Shopping List is ready to use...");
    }


    // ----------------------------------------------------------
    // Stored Procedure : insertIntoList()
    // ----------------------------------------------------------
    private static void createInsertProcedure(Statement stmt) throws Exception
    {
        stmt.executeUpdate("DROP PROCEDURE IF EXISTS insertIntoList");

        stmt.executeUpdate(
                            """
                                CREATE PROCEDURE insertIntoList(IN itemName VARCHAR(100))
                                BEGIN
                                    INSERT INTO ShoppingList(item)        
                                    VALUES(itemName);
                                END
                            """);

        System.out.println("Procedure insertIntoList() Ready.");
    }


    // ----------------------------------------------------------
    // Stored Procedure : showShoppingList()
    // ----------------------------------------------------------
    private static void createDisplayProcedure(Statement stmt) throws Exception
    {
        stmt.executeUpdate("DROP PROCEDURE IF EXISTS showShoppingList");

        stmt.executeUpdate("""
                                CREATE PROCEDURE showShoppingList()
                                BEGIN
                                    SELECT * FROM ShoppingList;
                                END
                            """);
        System.out.println("Procedure showShoppingList() Ready.");
    }


    // ----------------------------------------------------------
    // Insert Item using CallableStatement
    // ----------------------------------------------------------
    private static void insertIntoList(Connection con, String item) throws Exception
    {
        CallableStatement cst = con.prepareCall("{CALL insertIntoList(?)}");

        cst.setString(1, item);
        cst.executeUpdate();
        cst.close();
    }


    // ----------------------------------------------------------
    // Display Shopping List using CallableStatement
    // ----------------------------------------------------------
    private static void showShoppingList(Connection con) throws Exception
    {
        CallableStatement cst = con.prepareCall("{CALL showShoppingList()}");

        ResultSet rs = cst.executeQuery();

        System.out.println();
        System.out.println("========================================");
        System.out.printf("%-10s %-20s%n", "Serial", "Item");
        System.out.println("========================================");

        while(rs.next())
        {
            System.out.printf("%-10d %-20s%n",
                    rs.getInt("serial_no"),
                    rs.getString("item"));
        }

        System.out.println("========================================");

        rs.close();
        cst.close();
    }


    // ----------------------------------------------------------
    public static void main(String[] args)
    {
        try
        {
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Setup database and table
            createShoppingList(con);

            // Insert items
            insertIntoList(con, "Milk");
            insertIntoList(con, "Bread");
            insertIntoList(con, "Butter");
            insertIntoList(con, "Rice");
            insertIntoList(con, "Tea");
            insertIntoList(con, "Coffee");
            insertIntoList(con, "Sugar");

            // Display table
            showShoppingList(con);

            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}