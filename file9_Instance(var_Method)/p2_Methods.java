/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================---------- Methods in JAVA -----------========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Methods are used to breakdown a complex problem into smaller independent modules or a block of code so that,
   every module is used to perform a specific task.   
-> Method facilitate code reusability so that write your logic once and use it multiple times. 


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============= Syntax ===========================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 
class mainClass
{

(Access)   (RetrnType)       (Arguments)
(specifier)     |  (fun_name)  |
     __|________|___|__________|_______
    |  public void sum(int a, int b)  | ---------    
    |  {                              |         |
    |    System.out.printl(a+b);      |         |------ method_body
    |  }                              | --------|          
    |_________________________________| 
    
    Main_method()
    {
         _____________________________
        |   obj.funName(arg1, arg2)  |       <----------- {Calling of the method}
        |____________________________|
    }
}

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) Access Specifier: It define the accessible scope or field of the method
-> public, private, protected, default 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(2) ReturnType: It define the return value of a method after its execution.
-> void, int, float, String or any other type.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(3) Function_Name: It refers to a userdefined name given for identifinction of a method.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(4) parameters(Arguments): It refers to the arguments a function takes from outside at the time of calling.
->  If their is no argument then the paranthesis remains blank and 
    If it takes parameters then they initilized using seprated commas. 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
============================---------- Types of Methods -----------=======================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        _______________________|______________________
                       |                                             |
                (Pre_defined methods)                           (User_defined methods)
                -> length()                                     -> defined by user for 
                -> nextLine()                                      a specific purpose
                -> println()
                -> etc



*/

class Student
{
    String Name;
    int Id;
    int Age;
    
    // Method to set details
    public void setDetails(String name, int id, int age)
    {
        Name = name;
        Id = id;
        Age = age;    
    }

    // Method to display details 
    public void showDetails()
    {
        System.out.println("Name of the Student : " + Name);
        System.out.println("Id of the Student   : " + Id);
        System.out.println("Age of the Student  : " + Age);
    }
}

public class p2_Methods {
    public static void main(String[] args) {
        Student s1=new Student();
        
        // calling methods 
        s1.setDetails("Yash",77,21);
        s1.showDetails();        
    }    
}
