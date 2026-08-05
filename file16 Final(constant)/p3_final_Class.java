/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
final class :
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> final class can not extended by any sub class 

*/

final class Parent {
    public void display() {
        System.out.println("\n I am a Base class");
    }
}

// final class cannot extends
class Child // extends Parent
{
    public void display() {
        System.out.println("\n I am a Derived class");
    }
}

public class p3_final_Class {
    public static void main(String[] args) {
        Child c1 = new Child();
        c1.display();
    }
}
