/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============ Same package Access ===============
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

*/
class student
{
    public String s1="Student-1";
    protected String s2="Student-2";
    String s3="Student-3";
    // private String s4="Student-4";    
}

public class p3_samePackage {
    public static void main(String[] args) {
        student s= new student();

        System.out.println("\n~~~~~~~~ Same Package Access ~~~~~~~~\n");
        System.out.println("Public student name : " + s.s1);
        System.out.println("Protect student name : " + s.s2);
        System.out.println("default student name : " + s.s3);
        // System.out.println("Private student name : " + s.s4); Same package access-> (Private Not allowed)
    }
}
