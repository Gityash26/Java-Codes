/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------ Enum in java --------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> enum is refered to a class in java and it is used for working with named constant.

for exmaple:
-> when we are dealing with server then there are some error code for specific error
   so instead of using a variable to store those strings and then display we can create a enum.
*/

enum status 
{
    Running, Failed, Pending, Success; // object in indexed order
}

public class program1 
{
    public static void main(String[] args) 
    {

        // Similar like creating a variable
        // int a = 10;

        // status obj = status.Running;

        status s;

        s = status.Running;
        System.out.println("-> Status is : " + s);

        s = status.Failed;
        System.out.println("-> Status is : " + s);

        s = status.Pending;
        System.out.println("-> Status is : " + s);

        s = status.Success;
        System.out.println("-> Status is : " + s + "\n");

        /* 
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ------------- ordinal() method --------------------------------
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        -> ordinal method of enum class is used to get the index number of the enum object.
        */

        status[] myStatus = status.values();
        for(status obj : myStatus)
        {
            System.out.println("Status of index : " + obj.ordinal() + " is " + obj);
        }

    }
}