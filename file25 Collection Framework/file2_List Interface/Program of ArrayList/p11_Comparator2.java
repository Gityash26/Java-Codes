/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----- Second example of using comparator -------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import java.util.ArrayList;
import java.util.Comparator;

class Student 
{
    private String name;
    private double gpa;

    Student(String name, double gpa)
    {
        this.name = name;
        this.gpa = gpa;
    }

    String getName()
    {
        return name;
    }

    double getGpa()
    {
        return gpa;
    }
}

public class p11_Comparator2 
{
    public static void main(String[] args) 
    {        
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("yash", 3.5));
        list.add(new Student("sanjay", 4.3));
        list.add(new Student("Harsh", 2.4));
        list.add(new Student("Mohan", 3.9));


        // ----------------------------- Method1: Sorting using comparator 
        list.sort((a, b) -> 
        {
            if(b.getGpa() - a.getGpa() > 0)
                return 1;
            else if(b.getGpa() - a.getGpa() < 0)
                return -1;
            else 
                return 0;
        });




        // ----------------------------- Method2: Sorting using comparator.comparing()         
        Comparator<Student> compare = Comparator.comparing(Student::getGpa).reversed();
        list.sort(compare);


        // ----------------------------- Method3: thenComparing         
        Comparator<Student> compare2 = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        list.sort(compare2);

    


        for(Student s : list)
        {
            System.out.println(s.getName() + " : " + s.getGpa());
        }



    }    
}
