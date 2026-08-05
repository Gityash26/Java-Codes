
// Single level Inheritence (Employee -> Programmer)
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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

class Programmer extends Employee {
  String language;
  int experience;

  void getInfo() {
    super.getInfo();
    System.out.print("Enter programming languages: ");
    language = sc.nextLine();
    System.out.print("Enter experience: ");
    experience = sc.nextInt();
  }

  void displayInfo() {
    super.displayInfo();
    System.out.println("Programming languages: " + language);
    System.out.println("Total Experience: " + experience + "years");
  }
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


public class p1_Single {
    public static void main(String[] args) {
        Programmer p1=new Programmer();
        System.out.println("\n~~~~~~~~~~~~   Single Level Inheritance    ~~~~~~~~~~~~~~~\n");
        p1.getInfo();
        p1.displayInfo();
    }    
}
