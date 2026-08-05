
/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============= World Access ======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> World acess means importing a class from a package 
   and try to access its modifiers applied var, method, class.
*/
import subPackage.subEmployee;

public class p5_WorldAccess {
    public static void main(String[] args) {
        subEmployee obj = new subEmployee();

        System.out.println("\n~~~~~~~ World Access ~~~~~~~~\n");
        System.out.println("Public Employee : " + obj.e1);
        // System.out.println(obj.e2); // private ->(Not Allowed)
        // System.out.println(obj.e3); // private ->(Not Allowed)
        // System.out.println(obj.e4); // private ->(Not Allowed)

    }
}
