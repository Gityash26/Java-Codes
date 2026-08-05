/*
 
 -> Hierarchical Inheritence
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
                            __________ Fulltime Employee
              Employee ____|
                           |__________ Parttime Employee
  
 */

import java.util.Scanner;

class Employee {
    Scanner sc = new Scanner(System.in);

    String name;
    int age;
    int salary;
    String company;

    void getInfo() {
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your age: ");
        age = sc.nextInt();
        System.out.print("Enter your salary: ");
        salary = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter your Company Name: ");
        company = sc.nextLine();
    }

    void displayInfo() {
        System.out.println("\nEmployee Name: " + name);
        System.out.println("Employee Age: " + age);
        System.out.println("Employee Salary: " + salary);
        System.out.println("Employee Company: " + company);
    }
}

class Fulltime extends Employee {
    float HRA;
    int leave;

    void getInfo() {
        super.getInfo();
        System.out.print("Enter your House Rent Allowance : ");
        HRA = sc.nextFloat();
        System.out.print("Enter your Casual Leave : ");
        leave = sc.nextInt();
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("House Rent Allowance : " + HRA);
        System.out.println("Total Casual Leave : " + leave);

    }
}

class Parttime extends Employee {
    String shift;
    int overtime;

    void getInfo() {
        super.getInfo();
        System.out.print("Enter your shift (Day/Night) : ");
        shift = sc.nextLine();
        System.out.print("Enter Overtime day count : ");
        overtime = sc.nextInt();
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Working Shift : " + shift);
        System.out.println("Total Overtime Day count : " + overtime);
    }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// main method class
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class p3_Hierarchical {
    public static void main(String[] args) {
        System.out.println("\n~~~~~~~~~~~~       Hybrid Inheritance      ~~~~~~~~~~~~~~~\n");

        System.out.println("\n~~~~~~~~~~~~~~~~ Full-Time Employee ~~~~~~~~~~~~~~~~\n");
        Fulltime e1 = new Fulltime();
        e1.getInfo();
        e1.displayInfo();

        System.out.println("\n~~~~~~~~~~~~~~~~ Part-Time Employee ~~~~~~~~~~~~~~~~\n");
        Parttime e2 = new Parttime();
        e2.getInfo();
        e2.displayInfo();
    }
}
