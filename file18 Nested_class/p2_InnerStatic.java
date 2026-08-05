/*

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  ============== There are Two types of Nested CLass ========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  

(1) Non - static Nested class

(2) Static Nested class


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(2) Static Nested Class ---------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> In Java we can also define a 'static' class inside another class, such class is known as 'static nested class'

-> Unlike static class we cannot access the member Variable of the Outer class because static nested class doesn't require the instance of Outer class

syntax: 
            Outerclass.InnerClass obj = new OuterClass.InnerClass();

*/

class OuterClass 
{
    String Var1 = "Instance Variable";
    static String Var2 = "Static Variable";

    void instanceMethod() 
    {
        System.out.println("Instance Method...");
    }

    static void staticMethod() 
    {
        System.out.println("Static Method...");
    }

    // Static nested class
    static class InnerClass
    {
        void accessMembers() 
        {
            // System.out.println(OuterClass.Var1);   // ERROR Not Accessible
            System.out.println(OuterClass.Var2);

            // instanceMethod()  // ERROR Not Accessible
            staticMethod();
        }
    }
}




public class p2_InnerStatic 
{
    public static void main(String[] args) 
    {
        OuterClass.InnerClass obj = new OuterClass.InnerClass();
        obj.accessMembers();
    }
}
