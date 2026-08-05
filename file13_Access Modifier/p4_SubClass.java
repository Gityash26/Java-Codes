/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============ Sub Class Access ===================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Import a class from a package and inherit inside the class.
*/


import subPackage.subEmployee;

public class p4_SubClass extends subEmployee{
    public static void main(String[] args) {
        p4_SubClass obj=new p4_SubClass();

        System.out.println("\n~~~~~~~~~~~~~ SubClass Access ~~~~~~~~~~~~~\n");

        System.out.println("public Employeee : " + obj.e1);
        System.out.println("protect Employeee : " + obj.e2);

        // System.out.println("default Employeee : " + obj.e3); subClass default-> (Not Allowed)
        // System.out.println("private Employeee : " + obj.e4); subClass private-> (Not Allowed)
    }
    
}
