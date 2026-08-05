// This is a default constructor exmple 

class p1_Default 
{
    int a;    // default value assign as 0
    boolean b;  // default value assign as false
    
    public void display()
    {
        System.out.println("Default value of a : " + a);
        System.out.println("Default value of b : " + b);
    }

    public static void main(String[] args) 
    {
        p1_Default obj = new p1_Default();
        obj.display();
    }
}
