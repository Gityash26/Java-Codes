import java.util.Scanner;

class Students
{
    Scanner sc=new Scanner(System.in);
    String name;
    int id,age;
    
    // No arguments constructor 
    Students()
    {
        System.out.print("\nEnter your name : ");
        name=sc.nextLine();
        System.out.print("Enter your Id Number : ");
        id=sc.nextInt();
        System.out.print("Enter your age : ");
        age=sc.nextInt();
    }

    public void display()
    {
        System.out.println("\n~~~~~~~~~~ Student Details ~~~~~~~~~~~~~~");        
        System.out.println("\n-> Student Name : " + name);
        System.out.println("\n-> Student ID no. : " + id);
        System.out.println("\n-> Student Age : " + age);
    }
}


class p2_NoArgs
{
    public static void main(String[] args) 
    {
        Students s = new Students();
        s.display();
    }

}