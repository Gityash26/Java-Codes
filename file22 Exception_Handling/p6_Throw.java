/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------- Throw Keyword ----------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> throw keyword in java is used to throwing the exception explicitily.
-> In this case programmer throwing the exception instead of method.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---------- syntax -----------------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

-> syntax:
             try{
                if(condition)
                {
                    throw new <Throwable_Obj>
                }
                // code
             }
             catch (Exception e)
             {
                // Alternative solution
             }


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------ Note -----------------------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> Throw keyword are mostly used to throw User-defined exception or customized exception.
        
*/




public class p6_Throw
{
    public void divide()
    {
        int a = 10, b = 0;
        try
        {
            int c = a/b;
            System.out.println("Division : " + c);
        }
        catch(ArithmeticException e)
        {
            System.out.println("\n~~~~~~~~~~~~~~Exception thrown by method Divide~~~~~~~~~~~~~~~\n");
            e.printStackTrace();
        }
    }

    public void SelfThrow()
    {
        try 
        {
            throw new ArithmeticException();
        } 
        catch (ArithmeticException e) 
        {
            System.out.println("\n~~~~~~~~~~~~~~~Exception thrown by programmer~~~~~~~~~~~~~~~~~~\n");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
        p6_Throw obj = new p6_Throw();

        obj.divide();
        obj.SelfThrow();
    }    
}