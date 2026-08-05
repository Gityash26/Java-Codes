/*
===============================================================================
                            Program 20
===============================================================================

Question: Given a List of Employees, find the Employee having the Highest Salary using Stream API.

Rules

✓ Do NOT use loops.
✓ Do NOT use max().
✓ Do NOT use sorted().

✓ Use reduce().

Example

Input
---------------------------------------------
    Employee("Rahul", 45000)
    Employee("Aman", 65000)
    Employee("Neha", 55000)
    Employee("Riya", 70000)

Output
---------------------------------------------
    Employee : Riya
    Salary   : 70000
---------------------------------------------
*/

import java.util.Arrays;
import java.util.List;

class Employee 
{
    private String name;
    private double salary;

    public Employee(String name, double salary) 
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName() 
    {
        return name;
    }

    public double getSalary() 
    {
        return salary;
    }
}

public class program20 
{
    public static void main(String[] args) 
    {
        List<Employee> empList = Arrays.asList(                         // empList [e1, e2, e3, e4]  
                new Employee("Rahul", 45000),
                new Employee("Aman", 65000),
                new Employee("Neha", 55000),
                new Employee("Riya", 70000));


        Employee emp = empList.stream().reduce((e1,e2) -> (e1.getSalary()>e2.getSalary())?e1:e2).get();

        System.out.println("Employee : " + emp.getName());
        System.out.println("Salary : " + emp.getSalary());
    }
}
