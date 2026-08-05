
class Employees {
    String name;
    String post;
    int salary;

    Employees(String name) {
        this.name = name;
        post = "Employed"; // default post
        salary = 10000; // default salary
    }

    Employees(String name, String post) {
        this.name = name;
        this.post = post;
        salary = 10000;
    }

    Employees(String name, String post, int salary) {
        this.name = name;
        this.post = post;
        this.salary = salary;
    }

    public void display() {
        System.out.println("\n~~~~~~~~~~~~~~ Employee Details ~~~~~~~~~~~~~~~");
        System.out.println("Employee Name : " + name);
        System.out.println("Post : " + post);
        System.out.println("Salary : " + salary);
    }
}

public class p3_Parameterized {

    public static void main(String[] args) {

        Employees e1 = new Employees("Harry");
        Employees e2 = new Employees("Rohan", "Programmer");
        Employees e3 = new Employees("Rohan", "Programmer", 50000);

        e1.display();
        e2.display();
        e3.display();
    }
}
