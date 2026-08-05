/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-------------------------- Inheritance in Interfaces ----------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> We can inherit one interface into another interface just like inheritance in Normal 
   Base and Derived class using "extends" keyword.
-> But we cannot extends the interface into a concrete class because we can only implement it inside the class.


*/

interface Base_Interface 
{
    void meth1();
    void meth2();
}

interface Derived_Interface extends Base_Interface 
{
    // void meth1(); ________
    // void meth2(); _______|----> inherits form Base_Interface
    void meth3();
    void meth4();
}

class MyClass implements Derived_Interface 
{
    public void meth1() {
        System.out.println("\nBase class Method 1");
    }

    public void meth2() {
        System.out.println("\nBase class Method 2");
    }

    public void meth3() {
        System.out.println("\nDerived class Method 3");
    }

    public void meth4() {
        System.out.println("\nDerived class Method 4");
    }
}

public class p5_Interface_Inheritance {
    public static void main(String[] args) 
    {
        MyClass obj = new MyClass();
        obj.meth1();
        obj.meth2();
        obj.meth3();
        obj.meth4();
    }
}
