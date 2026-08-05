/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
================= Implementing Access  modifiers =================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                 _________________________________________________Same class Access
                |            _____________________________________Same package Access
                |           |           __________________________Import and inherit package_Class
                |           |          |             _____________Just import and use Package_class
=========================================================== 
|  Modifier |   Class |   Package |  Subclass |  World    |
|=========================================================|
| Public    |    Y    |     Y     |     Y     |     Y     |  
===========================================================
| Protected |    Y    |     Y     |     Y     |     N     |  
===========================================================
| Default   |    Y    |     Y     |     N     |     N     |
===========================================================
| Private   |    Y    |     N     |     N     |     N     |  
===========================================================
*/

/*  
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
====== Same class Acess ============
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

public class p2_sameClass {
    public int a = 10;
    protected int b = 20;
    int c = 30;
    private int d = 40;

    public static void main(String[] args) {
        p2_sameClass obj = new p2_sameClass();

        System.out.println("\n~~~~~~~~ Same class Access ~~~~~~~~\n");
        System.out.println("public var a : " + obj.a);
        System.out.println("protect var b : " + obj.b);
        System.out.println("default var c : " + obj.c);
        System.out.println("private var d : " + obj.d);
    }
}
