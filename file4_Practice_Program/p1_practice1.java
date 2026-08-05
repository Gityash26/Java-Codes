package file4_Practice_Program;
/* 
Ques: Take the total Obtained marks of 5 student in 10th class from maximum marks (500)
*/

import java.util.Scanner;

public class p1_practice1 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);

        int[] student = new int[5];

        int i = 0;

        while (i < 5) 
        {
            System.out.print("\nEnter Obtained marks of Student " + (i + 1) + " : ");
            int marks = sc.nextInt();
            if (marks >= 1 && marks <= 500) 
            {
                student[i] = marks;
                i++;
            } 
            else 
            {
                System.out.println("You Entered an Invalid Input");
            }
        }

        sc.close();

        System.out.println("\n|| Marks Percentage of 10th class ||\n");
        for (i = 0; i < 5; i++) 
        {
            System.out.println("Percentage of Student " + (i + 1) + ": " + (student[i]/5) + "%");
        }

    }
}