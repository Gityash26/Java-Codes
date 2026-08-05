/* 
-> Multiple Inheritence (person)-> (Employee)-> (Programmer)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

class person {
    String name;
    int age;

    public void getDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Employee extends person {
    String department;
    int salary;
    int experience;

    public void getDetails(String name, int age, String dep, int salary, int exp) {
        super.getDetails(name, age);
        this.department = dep;
        this.salary = salary;
        this.experience = exp;
    }
}

class programmer extends Employee {
    String lang;

    public void getDetails(String name, int age, String dep, int salary, int exp, String lang) {
        super.getDetails(name, age, dep, salary, exp);
        this.lang = lang;
    }

    void display() {
        System.out.println("\n~~~~~~~~~~~~ Programmers Details ~~~~~~~~~~~~~~~~~~\n");
        System.out.println("Programmer Name : " + this.name);
        System.out.println("Programmer Age  : " + this.age);
        System.out.println("Programmer Salary : " + this.salary);
        System.out.println("Programmer Department : " + this.department);
        System.out.println("Programming Lanaguage : " + this.lang);
        System.out.println("Programming Experience of : " + this.experience + " years");
    }
}

public class p2_Multilevel {
    public static void main(String[] args) {
        programmer p1 = new programmer();
        System.out.println("\n~~~~~~~~~~~~ Multi-level Level Inheritance ~~~~~~~~~~~~~~~\n");
        p1.getDetails("Yash", 21, "Service department", 25000, 2, "Python");
        p1.display();
    }
}


