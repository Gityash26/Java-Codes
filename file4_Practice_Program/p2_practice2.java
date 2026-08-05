package file4_Practice_Program;
/* 
Q.1: Write a java program to convert a string into lowercase
Q.2: Write a program to replace spaces with underscore
Q.3: Write a program to fill name in a sentence.
     sentence:
             "Dear <name> thanks a lot"
            
Q.4: Write a program to detect double and triple spaces in a string.  
*/

public class p2_practice2 
{

    public void solution1() 
    {
        String s = "LOWERCASE IMPLEMENTATION SENTENCE";
        System.out.println(s.toLowerCase());
    }

    public void solution2() 
    {
        String name = " Harry Developer ";
        System.out.println("SpaceToUnderscore Implementation : " + name.replace(" ", "_"));
    }

    public void solution3() 
    {
        String s = "Dear name thanks a lot";
        System.out.println("Replace name : " + s.replace("name", "Sir"));
    }

    public void solution4() 
    {
        String sentence = "This is a sentence with double  spaces  and triple   spaces";
        if (sentence.contains("  ")) 
        {
            System.out.println("Double spaces found");
        }
        if (sentence.contains("   ")) 
        {
            System.out.println("Triple spaces found");
        }
    }

    public static void main(String[] args) 
    {
        p2_practice2 obj = new p2_practice2();
        obj.solution1();
        obj.solution2();
        obj.solution3();
        obj.solution4();

    }
}
