/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
----------------------------- Conditional Stataement ---------------------------------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> Conditional statements are required in programming for controlling the flow of the program.
    and making it more dynamic and responsive.
-> Conditional statements are essential for implementing logic and making the program capable of handling different scenarios.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
---- Types of conditional statements ::
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(1) if
(2) if else
(3) Else if ladder
(4) Nested if else
(5) Switch case
*/

public class p1_conditional 
{
    public static void main(String[] args) 
    {

        // ------------------------> if statement
        int age = 20;
        if (age > 18) 
        {
            System.out.println("You are eligible to vote");
        }

        // ------------------------>  if - else statement
        int number = 10;
        if (number % 2 == 0) 
        {
            System.out.println("The number is even");
        } 
        else 
        {
            System.out.println("The number is odd");
        }

        // Else if ladder statement
        int marks = 85;
        if (marks >= 90) 
        {
            System.out.println("Grade A");
        } 
        else if (marks >= 80) 
        {
            System.out.println("Grade B");
        } 
        else if (marks >= 70) 
        {
            System.out.println("Grade C");
        } 
        else if (marks >= 60) 
        {
            System.out.println("Grade D");
        } 
        else 
        {
            System.out.println("Grade F");
        }

        // Nested if else statement
        int num1 = 5;
        int num2 = 10;
        int num3 = 15;

        if (num1 > num2) 
        {
            if (num1 > num3) 
            {
                System.out.println("num1 is the largest number");
            } 
            else 
            {
                System.out.println("num3 is the largest number");
            }
        } 
        else 
        {
            if (num2 > num3) 
            {
                System.out.println("num2 is the largest number");
            } 
            else 
            {
                System.out.println("num3 is the largest number");
            }
        }

        // switch case statement
        int day = 4;
        String dayName;

        switch (day) 
        {
            case 1:
                dayName = "Monday";
                break;

            case 2:
                dayName = "Tuesday";
                break;

            case 3:
                dayName = "Wednesday";
                break;

            case 4:
                dayName = "Thursday";
                break;

            case 5:
                dayName = "Friday";
                break;

            case 6:
                dayName = "Saturday";
                break;

            case 7:
                dayName = "Sunday";
                break;
                
            default:
                dayName = "Invalid day";
                break;
        }

        System.out.println("Today is " + dayName);

    }
}
