/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============== Singleton Class ==============================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In java singleton class is a 
*/


class Database 
{
    private static Database db;

    // constructor to allocate memory
    private Database()
    {

    }

    // static method 
    public static Database getInstance()
    {
        if(db == null)
        {
            db = new Database();
        }

        return db;
    }

    // Non static method 
    public void getConnection()
    {
        System.out.println("You are now connected to the database....");
    }
}



public class p5_SingletonClass 
{
    public static void main(String[] args) 
    {
        Database dbase;  // only reference not object

        // static methods return the object 
        dbase = Database.getInstance();

        // No we can access non static method 
        dbase.getConnection(); 
    }    
}
