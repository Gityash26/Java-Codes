package file4_Practice_Program;
/* 
Q.1: Create an array of 5 floats and calculate their sum.
Q.2: Write a program to find out whether a given integer present in the array or not.
Q.3: Calculate the marks average from an array containing marks of all the students in physics using for each loop.
Q.4: Create a program to add two matrix of size 2x3.  
Q.5: Write a program to reverse an array
Q.6: Write a program to find the maximum element in an array.
Q.7: Write a java program to check whether an array is sorted or not.

*/

import java.util.Arrays;
import java.util.Scanner;

public class p3_practice3 
{
    public void solution1() 
    {
        float sum = 0;
        float a[] = { 1.3f, 4.5f, 7.8f, 3.6f, 9.3f };
        for (float val : a) 
        {
            sum += val;
        }
        System.out.println("The sum of float array : " + sum);
    }

    public void solution2() 
    {
        int a[] = { 11, 22, 33, 44, 55, 66 };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (from Table 11) : ");
        int num = sc.nextInt();
        System.out.println("Your num founds at Index : " + Arrays.binarySearch(a, num)); // search method in array
        sc.close();
    }

    public void solution3() 
    {
        int sum = 0;
        int marks[] = { 25, 83, 78, 25, 88, 44 };
        for (int m : marks) 
        {
            System.out.println("marks : " + m);
            sum += m;
        }
        float average=(sum / marks.length);
        System.out.println("The Average : " + average);
    }

    public void solution4() 
    {
        int m1[][]={{2,4,6},{3,6,9}};
        int m2[][]={{11,22,33},{66,77,88}};
        int m3[][] = new int[2][3];

        System.out.println("Matrix Addition : \n");
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
            {
                m3[i][j]=m1[i][j]+m2[i][j];
                System.out.print(m3[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    public void solution5() {
        int a[]={2,3,4,5,7};
        for(int i=(a.length)-1;i>=0;i--)
        {
            System.out.print(a[i] + " ");
        }
    }

    public void solution6() 
    {
        int a[]={56,86,25,73,62,79};
        System.out.println("Array : "+ Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("Maximum Value : "+ a[(a.length)-1]);
    }

    public void solution7()
    {
        int a[]={56,86,25,73,62,79};
        boolean sorted = true;
        for (int i = 0; i < a.length - 1; i++) 
        {
            if (a[i] > a[i + 1]) 
            {
                sorted = false;
                break;
            }
        }
        if (sorted) 
        {
            System.out.println("The array is sorted.");
        } 
        else 
        {
            System.out.println("The array is not sorted.");
        }
    }

    public static void main(String[] args) 
    {
        p3_practice3 obj = new p3_practice3();
        System.out.println("\n:::::::::> Solution 1 <::::::::\n");
        obj.solution1();

        System.out.println("\n:::::::::> Solution 2 <::::::::\n");
        obj.solution2();
        
        System.out.println("\n:::::::::> Solution 3 <::::::::\n");
        obj.solution3();

        System.out.println("\n:::::::::> Solution 4 <::::::::\n");
        obj.solution4();

        System.out.println("\n:::::::::> Solution 5 <::::::::\n");
        obj.solution5();
            
        System.out.println("\n:::::::::> Solution 6 <::::::::\n");
        obj.solution6();
                
        System.out.println("\n:::::::::> Solution 6 <::::::::\n");
        obj.solution7();
    }
}
