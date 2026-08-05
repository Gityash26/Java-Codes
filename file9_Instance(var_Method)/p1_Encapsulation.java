/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~            
======================= Encapsulation in JAVA =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Encapsulation is a fundamental concept of Object Oriented programming that refers to combine or 
   encapsulate the data(attributes) and method (Behaviours) that operates on the data into a single 
   unit called class.

-> This Encapsulated single unit restrict the access to the data from the outside and also prevent 
   accidental modification of the data.
   

    ____________________________
   |          Class            |
   |   ______________________  |
   |  |    Instance Var     |  |    
   |  |_____________________|  |   <=========== {Encapsulation}
   |   __________||__________  |    
   |  |    Instance Method  |  |
   |  |_____________________|  |
   |___________________________|


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~            
======================= Features of Encapsulation =====================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Encapsulation facilitate to provides : 
(1) Data Hiding     : (Using private, public, protected access specifier)
(2) Access control  : (Provide access using getter and setter)
(3) Abstraction     : (Hiding unnecessary detailed implementation and provide only useful method)
(4) Modularity      : (Ability to change in the internal implementation of a class without affecting the code use it)


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------------- Instance 'Variable' in JAVA -----------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Instance variable are also known as member variable or attribute declare inside the class but 
   outside the member function.
-> Instance variable are used to store value of an object properties.
-> Every object create using the class reference having a seprate copy of instance variable.

syntax:
         class fileName
         {                         __
            int Id;                  \
            String name;           __|--->  Instance (variable / Attributes / Properties)
         }


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------------- Instance 'Method' in JAVA -----------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Instance methods is refers to the methods or behaviours define inside the class and used 
   to manipulate the instance variable.
-> Instance variable of a class are not called directly from outside the class for the purpose of data hiding.
   That's why Instance methods are created and called using object of the class and perform any operation.

syntax:
        class main
        {
            int a,b;           _____________
            void setValue()                |
            {                              |---- Instance methods
            }             ________________|
        }
*/
            

public class p1_Encapsulation 
{

    // Instance variable
    int a,b;

    // Instance Method 
    void getValue(int x,int y)
    {
        System.out.println("\n--> Values set Successfully");
        a=x;
        b=y;
    }   

    // Instance Method 
    void display()
    {
        System.out.printf("\n--> Your Values \n a : %d \n b : %d",a,b);
    }  

    public static void main(String[] args) 
    {
        p1_Encapsulation obj1 = new p1_Encapsulation();        
        p1_Encapsulation obj2 = new p1_Encapsulation();

        obj1.getValue(33, 45);
        obj2.getValue(45, 47);
        
        obj1.display();
        obj2.display();
    }
}

/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
--------------------- Above program Representation ---------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Each object of the class p1_Instance have their own instance variable (a,b) 
   and instance methods (getValue,display).

                 _____________________                      ______________________
                |  instance variable  |                    |  instance variable  |
                |    => int a, int b  |                    |                     |
       obj1 ->  |_____________________|            obj2 -> |_____________________| 
                |  instance methods   |                    |  instance methods   |
                |    => getValue()    |                    |    => getValue()    |
                |    => display()     |                    |    => display       |
                |_____________________|                    |_____________________|



*/ 




