
/*
Ques: 
    -> Write a java program that allows maximum 5 attempt to getr array value at valid index
      and then after 5 attempt print "Error" message.
    -> If any exception occur then print the exception.
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class p9_practice {
    public static void main(String[] args) 
    {

        int[] a = { 20, 30, 45, 78, 92, 34, 765, 456, 87, 5, 78, 43 };
        int l = a.length - 1;

        Scanner sc = new Scanner(System.in);

        try 
        {
            for (int i = 1; i <= 5; i++) 
            {
                System.out.println("\n::::::::: Attempt " + i + " and " + (5-i) + " Attempts left :::::::::");
           
                System.out.printf("\nEnter array index (0 to %d) : ", l);
                int index = sc.nextInt();
                System.out.println("\n==> Value : " + a[index]);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("\n!! Sorry Index is not Available !!\n");
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("\n!! Sorry Index should be Integer !!\n");
        } 
        finally
        {
            sc.close();
        }
    }
}
