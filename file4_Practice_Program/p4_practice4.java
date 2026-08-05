package file4_Practice_Program;
/* 

Q.1: Write a program to print multiplication table of number n.

Q.2: Write a program to print the following pattern.
     *
     * *
     * * *
     * * * *

Q.3: Write recursive program to find the sum of first n natural nummber.

Q.4: Write a function to print the following pattern
     * * * *
     * * *
     * *
     * 
     
Q.5: Write a program to print the nth term of a fibnonic series using recursion.
     
Q.6: Write a program to find the average of a set of numbers passed as an arguments.

Q.7: Repeat Q.4 using recursion
*/



import java.util.Scanner;

class solution {
    Scanner sc = new Scanner(System.in);

    public void solution1() {
        // print table of number n
        System.out.print("\nEnter a number : ");
        int num = sc.nextInt();

        System.out.println("\nTable of Number : " + num);

        for (int i = 1; i <= 10; i++) {
            System.out.printf("\n %d x %d = %d", num, i, num * i);
        }
    }

    public void solution2() {
        System.out.print("\nEnter pattern size : ");
        int s = sc.nextInt();
        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public int solution3(int num) {
        if (num < 1)
            return num;
        else
            return num + solution3(num - 1);
    }

    public void solution4() {
        System.out.print("\nEnter size of the pattern : ");
        int s = sc.nextInt();
        for (int i = s; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public int solution5(int num) {
        // 0 1 1 2 3 5 8 13
        if (num <= 1)
            return num;
        else
            return solution5(num - 1) + solution5(num - 2);
    }

    public void solution6(int... arr) {
        // Average of arguements
        int sum = 0;
        for (int val : arr) {
            System.out.println("Marks : " + val);
            sum += val;
        }
        System.out.println("\nThe Average is : " + (sum / arr.length));
    }

    public void solution7(int size) {
        // pattern using recursion
        if (size < 1)
            return;
        else {
            for (int i = 1; i <= size; i++)
                System.out.print(" * ");
            System.out.println();
            solution7(size - 1);
        }
    }

}

public class p4_practice4 {

    public static void main(String[] args) {
        solution s = new solution();
        s.solution1();
        s.solution2();
        System.out.println("\nThe sum of 5 : " + s.solution3(5));
        s.solution4();
        System.out.println("\nThe fibnonic of 5 : " + s.solution5(3));
        s.solution6(98, 67, 99, 47, 65);
        s.solution7(10);

    }

}
