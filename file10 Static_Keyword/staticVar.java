/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-------------------------------- 'static' keyword ----------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> "static" keyword is used to associate a method of a given class with the 'class' instead of 'Object'.
-> It means making a variable or method static then it becomes common for each object.


Ex: If their is a hostel of 100 students, In summer time their are two choices we have to facilitate freezer
(1) Provide a Refrigerator to each student        
(2) share a single Refrigerator among 100 student

Therefore, Sharing a Single refrigerator is much efficient than providing 100 units to all the students.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------- static variable ------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> If we create a variable static it means Each object do not have seprate copy of that variable.
  Instead of this a single variable is shared among all the Objects.
-> In simple words we can say that static variable is now associated with class instaead of Object.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------- static Method --------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> If we create a method static it means we don,t require any object to call that method.
   In Simple word we can say that it act as an normal function Instead of a method of a class.
*/

public class staticVar 
{

  private String Emp_name;
  private int Emp_age;
  static int count = 0;

  // constructor
  staticVar(String name, int age) 
  {
    Emp_name = name;
    Emp_age = age;
    count++;
  }

  // Display method
  public void display() 
  {
    System.out.println("\nEmployee No. : " + count);
    System.out.println("Employee name : " + Emp_name);
    System.out.println("Employee Age : " + Emp_age);
  }

  public static void main(String[] args) 
  {

    staticVar e1 = new staticVar("Yash", 21);
    e1.display();

    staticVar e2 = new staticVar("Kunal", 22);
    e2.display();

    staticVar e3 = new staticVar("Sanjay", 24);
    e3.display();
  }
}
