/*
===============================================================================
                            Program 26
===============================================================================

In this program, till now we are familiar with the Optional class -> map() method
for example, 


---------------------------------------------
Optional<String> name = "hello world"
-----------------------------------------------              
 name.map(String::UpperCase)
-----------------------------------------------              
output: Optional["HELLO WORLD"]
-----------------------------------------------              



~~~~~~~~~~~~~~~~~~~~~~ BUT ~~~~~~~~~~~~~~~
Ques: What if we have a methods that returns a Optional String 
-----------------------------------------------------------------

class Employee
{
    Optional<String> getName()
    {
        return Optional.of("Yash");
    }
}


// ----- creating an instance -------
Optional<Employee> 




==============================================================
    Understanding flatMap method
==============================================================

When we are already working with an Optional object and we call a method using map(), 
if that method itself returns another Optional, then map() wraps that returned Optional again.

    example: Optional[Optional[]]

This is called a Nested Optional, which is generally not desirable.

Therefore, Java provides flatMap(), which flattens the nested Optional and returns only

    Optional<String>



    
*/

import java.util.Optional;

class Employee
{
    Optional<String> getName()
    {
        return Optional.of("Yash");
    }
}

public class program6
{
    public static void main(String[] args) 
    {
        Optional<Employee> emp = Optional.of(new Employee());


    // ----------------------------------------------------- using map()
    
        Optional<Optional<String>> name1 = emp.map(Employee::getName);   // return map(Optional["Yash"])
        System.out.println(name1);

        
    // ----------------------------------------------------- using flatMap()

    
    Optional<String> name2 = emp.flatMap(Employee::getName);
        System.out.println(name2);


    }   
}