class student
{
    int rollNo;
    String name;

    // ----------------------------------------------> constructor 
    public student(int rollNo, String name) 
    {
        this.rollNo = rollNo;
        this.name = name;
    }
    
    // ----------------------------------------------> method to display 
    void display()
    {
        System.out.println("\nDisplay method called...");
        System.out.println("Student ID : " + rollNo);
        System.out.println("Student name : " + name);

    }

    @Override
    public String toString()
    {
        System.out.println("\ntoString method called...");
        return "Student ID : " + rollNo + "\nStudent name : " + name;
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + rollNo;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
            
        if (obj == null)
            return false;
            
        if (getClass() != obj.getClass())
            return false;

        student other = (student) obj;
        if (rollNo != other.rollNo)
            return false;

        if (name == null) 
        {
            if (other.name != null)
                return false;

        } 
        else if (!name.equals(other.name))
            return false;

        return true;
    }
}

public class p4_toString 
{
    public static void main(String[] args) 
    {

        student s = new student(23, "Yash");


        // System.out.println(s);  // without override result ->  student@28a418fc
        System.out.println(s); 
        s.display();
    }
}
